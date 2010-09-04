package org.realityforge.swung_weave.tool;

import java.util.HashMap;
import java.util.Map;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

final class SwClassAdapter
  extends ClassAdapter
{
  private String m_classname;
  private int m_adapterCount;
  private final Map<String, byte[]> m_adapters = new HashMap<String, byte[]>();

  public SwClassAdapter( final ClassWriter cw )
  {
    super( cw );
  }

  public Map<String, byte[]> getClassData()
  {
    return m_adapters;
  }

  @Override
  public void visit( final int version,
                     final int access,
                     final String name,
                     final String signature,
                     final String superName,
                     final String[] interfaces )
  {
    m_classname = name;
    super.visit( version, access, name, signature, superName, interfaces );
  }

  public MethodVisitor visitMethod( final int access,
                                    final String methodName,
                                    final String desc,
                                    final String signature,
                                    final String[] exceptions )
  {
    final Type[] methodParameterTypes = Type.getArgumentTypes( desc );
    final Type returnType = Type.getReturnType( desc );
    MethodVisitor v = cv.visitMethod( access,
                                      methodName,
                                      desc,
                                      signature,
                                      exceptions );
    return new MethodAdapter( v )
    {
      private boolean requiresEDT;
      private boolean disallowsEDT;
      private boolean runInEDT;
      private boolean runOutsideEDT;

      @Override
      public AnnotationVisitor visitAnnotation( final String desc, final boolean visible )
      {
        if( desc.equals( "Lorg/realityforge/swung_weave/RunInEDT;" ) )
        {
          runInEDT = true;
        }
        if( desc.equals( "Lorg/realityforge/swung_weave/RunOutsideEDT;" ) )
        {
          runOutsideEDT = true;
        }
        if( desc.equals( "Lorg/realityforge/swung_weave/RequiresEDT;" ) )
        {
          requiresEDT = true;
        }
        if( desc.equals( "Lorg/realityforge/swung_weave/DisallowsEDT;" ) )
        {
          disallowsEDT = true;
        }
        return super.visitAnnotation( desc, visible );
      }

      public void visitCode()
      {
        if( runInEDT )
        {
          genTransfer( true );
        }

        if( runOutsideEDT )
        {
          genTransfer( false );
        }

        if( requiresEDT )
        {
          genIsDispatchThreadInvoke( mv );
          final Label end = new Label();
          mv.visitJumpInsn( Opcodes.IFNE, end );
          genIllegalStateException( mv,
                                    "Method " + methodName + " must only be " +
                                    "invoked in the Event Dispatch Thread." );
          mv.visitLabel( end );
        }
        if( disallowsEDT )
        {
          genIsDispatchThreadInvoke( mv );
          final Label end = new Label();
          mv.visitJumpInsn( Opcodes.IFEQ, end );
          genIllegalStateException( mv,
                                    "Method " + methodName + " must not be " +
                                    "invoked in the Event Dispatch Thread." );
          mv.visitLabel( end );
        }
      }

      private void genTransfer( final boolean toEDT )
      {
        genIsDispatchThreadInvoke( mv );
        final Label end = new Label();
        mv.visitJumpInsn( toEDT ? Opcodes.IFNE : Opcodes.IFEQ, end );
        m_adapterCount += 1;
        final String helperClass = m_classname + "$Sw_" + methodName + "_" + m_adapterCount;
        mv.visitTypeInsn( Opcodes.NEW, helperClass );
        mv.visitInsn( Opcodes.DUP );
        final StringBuilder paramDesc = new StringBuilder();
        int index = 0;
        if( ( access & Opcodes.ACC_STATIC ) == 0 )
        {
          paramDesc.append( 'L' );
          paramDesc.append( m_classname );
          paramDesc.append( ';' );
          mv.visitVarInsn( Opcodes.ALOAD, index );
          index += 1;
        }
        for( final Type type : methodParameterTypes )
        {
          mv.visitVarInsn( loadOpcode( type.getSort() ), index );
          index += 1;
          paramDesc.append( type.getDescriptor() );
        }
        final String helperConstructorDesc = "(" + paramDesc + ")V";
        mv.visitMethodInsn( Opcodes.INVOKESPECIAL, helperClass, "<init>", helperConstructorDesc );
        mv.visitMethodInsn( Opcodes.INVOKESTATIC,
                            "org/realityforge/swung_weave/DispatchUtil",
                            toEDT ? "invokeInEDT" : "invokeOutsideEDT",
                            "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;" );
        genReturn( mv, returnType );
        mv.visitLabel( end );

        final ClassWriter cw = new ClassWriter( ClassWriter.COMPUTE_MAXS );
        cw.visit( Opcodes.V1_1,
                  Opcodes.ACC_FINAL | Opcodes.ACC_SYNTHETIC,
                  helperClass,
                  null,
                  "java/lang/Object",
                  new String[]{ "java/util/concurrent/Callable" } );

        int parameterID = 1;
        if( ( access & Opcodes.ACC_STATIC ) == 0 )
        {
          cw.visitField( Opcodes.ACC_PRIVATE | Opcodes.ACC_FINAL,
                         "p1",
                         "L" + m_classname + ";",
                         null,
                         null );
          parameterID += 1;
        }

        for( final Type type : methodParameterTypes )
        {
          cw.visitField( Opcodes.ACC_PRIVATE | Opcodes.ACC_FINAL,
                         "p" + parameterID,
                         type.getDescriptor(),
                         null,
                         null );
          parameterID += 1;
        }

        // default public constructor
        final MethodVisitor ctor = cw.visitMethod( Opcodes.ACC_PROTECTED,
                                                   "<init>",
                                                   helperConstructorDesc,
                                                   null,
                                                   null );
        parameterID = 1;
        if( ( access & Opcodes.ACC_STATIC ) == 0 )
        {
          ctor.visitVarInsn( Opcodes.ALOAD, 0 );
          ctor.visitVarInsn( Opcodes.ALOAD, 1 );
          ctor.visitFieldInsn( Opcodes.PUTFIELD, helperClass, "p1", "L" + m_classname + ";" );
          parameterID += 1;
        }

        for( final Type type : methodParameterTypes )
        {
          // the this object
          ctor.visitVarInsn( Opcodes.ALOAD, 0 );
          //the parameter to put in field
          ctor.visitVarInsn( loadOpcode( type.getSort() ), parameterID );
          ctor.visitFieldInsn( Opcodes.PUTFIELD,
                               helperClass,
                               "p" + parameterID,
                               type.getDescriptor() );

          parameterID += 1;
        }

        ctor.visitVarInsn( Opcodes.ALOAD, 0 );
        ctor.visitMethodInsn( Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V" );
        ctor.visitInsn( Opcodes.RETURN );
        ctor.visitMaxs( 1, 1 );
        ctor.visitEnd();

        // eval method
        final MethodVisitor callMethod =
          cw.visitMethod( Opcodes.ACC_PUBLIC,
                          "call",
                          "()Ljava/lang/Object;",
                          null,
                          new String[]{ "java/lang/Exception" } );

        parameterID = 1;
        if( ( access & Opcodes.ACC_STATIC ) == 0 )
        {
          callMethod.visitVarInsn( Opcodes.ALOAD, 0 );
          callMethod.visitFieldInsn( Opcodes.GETFIELD, helperClass, "p1", "L" + m_classname + ";" );
          parameterID += 1;
        }

        for( final Type type : methodParameterTypes )
        {
          // the this object
          callMethod.visitVarInsn( Opcodes.ALOAD, 0 );
          callMethod.visitFieldInsn( Opcodes.GETFIELD,
                               helperClass,
                               "p" + parameterID,
                               type.getDescriptor() );

          parameterID += 1;
        }
        final int invokeOpcode;
        if( ( access & Opcodes.ACC_STATIC ) == 0 )
        {
          invokeOpcode = Opcodes.INVOKEVIRTUAL;
        }
        else
        {
          invokeOpcode = Opcodes.INVOKESTATIC;
        }
        callMethod.visitMethodInsn( invokeOpcode, m_classname, methodName, desc );
        if( Type.VOID == returnType.getSort() )
        {
          callMethod.visitInsn( Opcodes.ACONST_NULL );
        }
        callMethod.visitInsn( Opcodes.ARETURN );
        // max stack and max locals automatically computed
        callMethod.visitMaxs( 0, 0 );
        callMethod.visitEnd();

        m_adapters.put( helperClass.replace( '/', '.' ), cw.toByteArray() );
      }
    };
  }

  static void genIsDispatchThreadInvoke( final MethodVisitor mv )
  {
    mv.visitMethodInsn( Opcodes.INVOKESTATIC,
                        "java/awt/EventQueue",
                        "isDispatchThread",
                        "()Z" );
  }

  static void genIllegalStateException( final MethodVisitor mv,
                                        final String message )
  {
    final String exception = "java/lang/IllegalStateException";
    mv.visitTypeInsn( Opcodes.NEW, exception );
    mv.visitInsn( Opcodes.DUP );
    mv.visitLdcInsn( message );
    mv.visitMethodInsn( Opcodes.INVOKESPECIAL, exception, "<init>", "(Ljava/lang/String;)V" );
    mv.visitInsn( Opcodes.ATHROW );
    mv.visitInsn( Opcodes.RETURN );
  }

  static void genReturn( final MethodVisitor mv,
                         final Type returnType )
  {
    final int sort = returnType.getSort();
    if( Type.VOID == sort )
    {
      mv.visitInsn( Opcodes.POP );
      mv.visitInsn( Opcodes.RETURN );
    }
    else if( Type.BOOLEAN == sort ||
             Type.BYTE == sort ||
             Type.CHAR == sort ||
             Type.SHORT == sort ||
             Type.INT == sort )
    {
      mv.visitInsn( Opcodes.IRETURN );
    }
    else if( Type.LONG == sort )
    {
      mv.visitInsn( Opcodes.LRETURN );
    }
    else if( Type.FLOAT == sort )
    {
      mv.visitInsn( Opcodes.FRETURN );
    }
    else if( Type.DOUBLE == sort )
    {
      mv.visitInsn( Opcodes.DRETURN );
    }
    else //OBJECT and arrays
    {
      mv.visitInsn( Opcodes.ARETURN );
    }
  }

  static int loadOpcode( final int sort )
  {
    final int opcode;
    if( Type.BOOLEAN == sort ||
        Type.BYTE == sort ||
        Type.CHAR == sort ||
        Type.SHORT == sort ||
        Type.INT == sort )
    {
      opcode = Opcodes.ILOAD;
    }
    else if( Type.LONG == sort )
    {
      opcode = Opcodes.LLOAD;
    }
    else if( Type.FLOAT == sort )
    {
      opcode = Opcodes.FLOAD;
    }
    else if( Type.DOUBLE == sort )
    {
      opcode = Opcodes.DLOAD;
    }
    else //OBJECT and arrays
    {
      opcode = Opcodes.ALOAD;
    }
    return opcode;
  }
}
