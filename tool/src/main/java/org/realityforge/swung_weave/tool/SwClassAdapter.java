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

class SwClassAdapter
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
          GenUtil.genIsDispatchThreadInvoke( mv );
          final Label end = new Label();
          mv.visitJumpInsn( Opcodes.IFNE, end );
          GenUtil.genIllegalStateException( mv,
                                            "Method " + methodName + ";" + desc + " must only be " +
                                            "invoked in the Event Dispatch Thread." );
          mv.visitLabel( end );
        }
        if( disallowsEDT )
        {
          GenUtil.genIsDispatchThreadInvoke( mv );
          final Label end = new Label();
          mv.visitJumpInsn( Opcodes.IFEQ, end );
          GenUtil.genIllegalStateException( mv,
                                            "Method " + methodName + ";" + desc + " must not be " +
                                            "invoked in the Event Dispatch Thread." );
          mv.visitLabel( end );
        }
      }

      private void genTransfer( final boolean toEDT )
      {
        GenUtil.genIsDispatchThreadInvoke( mv );
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
          mv.visitVarInsn( GenUtil.loadOpcode( type.getSort() ), index );
          index += 1;
          paramDesc.append( type.getDescriptor() );
          paramDesc.append( ';' );
        }
        final String helperConstructorDesc = "(" + paramDesc + ")V";
        mv.visitMethodInsn( Opcodes.INVOKESPECIAL, helperClass, "<init>", helperConstructorDesc );
        mv.visitMethodInsn( Opcodes.INVOKESTATIC,
                            "org/realityforge/swung_weave/DispatchUtil",
                            toEDT ? "invokeInEDT" : "invokeOutsideEDT",
                            "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;" );
        GenUtil.genReturn( mv, returnType );
        mv.visitLabel( end );

        final ClassWriter cw = new ClassWriter( ClassWriter.COMPUTE_MAXS );
        cw.visit( Opcodes.V1_1,
                  Opcodes.ACC_FINAL | Opcodes.ACC_SYNTHETIC,
                  helperClass,
                  null,
                  "java/lang/Object",
                  new String[]{ "java/util/concurrent/Callable" } );

        if( ( access & Opcodes.ACC_STATIC ) == 0 )
        {
          cw.visitField( Opcodes.ACC_PRIVATE | Opcodes.ACC_FINAL,
                         "p0",
                         "L" + m_classname + ";",
                         null,
                         null );
        }

        int parameterID = 1;
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
        if( ( access & Opcodes.ACC_STATIC ) == 0 )
        {
          ctor.visitVarInsn( Opcodes.ALOAD, 0 );
          ctor.visitVarInsn( Opcodes.ALOAD, 1 );
          ctor.visitFieldInsn( Opcodes.PUTFIELD, helperClass, "p0", "L" + m_classname + ";" );
        }

        parameterID = 1;
        for( final Type type : methodParameterTypes )
        {
          // the this object
          ctor.visitVarInsn( Opcodes.ALOAD, 0 );
          //the parameter to put in field
          ctor.visitVarInsn( GenUtil.loadOpcode( type.getSort() ), 1 + parameterID );
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
        callMethod.visitInsn( Opcodes.ACONST_NULL );
        callMethod.visitInsn( Opcodes.ARETURN );
        // max stack and max locals automatically computed
        callMethod.visitMaxs( 0, 0 );
        callMethod.visitEnd();

        m_adapters.put( helperClass.replace( '/', '.' ), cw.toByteArray() );
      }
    };
  }
}