package org.realityforge.swung_weave.tool;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

final class SwClassAdapter
  extends ClassVisitor
{
  private static final String GENERATED_ACCESSOR_PREFIX = "sw_access$";

  private String _classname;
  private int _adapterCount;
  private boolean _matchedAnnotations;
  private final Map<String, byte[]> _adapters = new HashMap<String, byte[]>();

  public SwClassAdapter( final ClassWriter cw )
  {
    super( Opcodes.ASM5, cw );
  }

  public Map<String, byte[]> getClassData()
  {
    return _adapters;
  }

  public String getClassname()
  {
    return _classname;
  }

  public boolean matchedAnnotations()
  {
    return _matchedAnnotations;
  }

  @Override
  public void visit( final int version,
                     final int access,
                     final String name,
                     final String signature,
                     final String superName,
                     final String[] interfaces )
  {
    _classname = name;
    super.visit( version, access, name, signature, superName, interfaces );
  }

  public MethodVisitor visitMethod( final int access,
                                    final String methodName,
                                    final String desc,
                                    final String signature,
                                    final String[] exceptions )
  {
    if( methodName.equals( "<init>" ) || methodName.equals( "<cinit>" ) )
    {
      return super.visitMethod( access, methodName, desc, signature, exceptions );
    }
    final Type[] methodParameterTypes = Type.getArgumentTypes( desc );
    final Type returnType = Type.getReturnType( desc );
    final MethodVisitor v = cv.visitMethod( access, methodName, desc, signature, exceptions );

    return new MethodVisitor( Opcodes.ASM5, v )
    {
      private boolean _requiresEDT;
      private boolean _disallowsEDT;
      private boolean _runInEDT;
      private boolean _runOutsideEDT;

      @Override
      public AnnotationVisitor visitAnnotation( final String desc, final boolean visible )
      {
        if( desc.equals( "Lorg/realityforge/swung_weave/RunInEDT;" ) )
        {
          _runInEDT = true;
          _matchedAnnotations = true;
          return null;
        }
        else if( desc.equals( "Lorg/realityforge/swung_weave/RunOutsideEDT;" ) )
        {
          _runOutsideEDT = true;
          _matchedAnnotations = true;
          return null;
        }
        else if( desc.equals( "Lorg/realityforge/swung_weave/RequiresEDT;" ) )
        {
          _requiresEDT = true;
          _matchedAnnotations = true;
          return null;
        }
        else if( desc.equals( "Lorg/realityforge/swung_weave/DisallowsEDT;" ) )
        {
          _disallowsEDT = true;
          _matchedAnnotations = true;
          return null;
        }
        else
        {
          return super.visitAnnotation( desc, visible );
        }
      }

      public void visitCode()
      {
        if ( _runInEDT || _runOutsideEDT )
        {
          // Method is private so we need to generate a magic accessor method.
          // This is the same approach taken by inner classes.
          if ( Modifier.isPrivate( access ) )
          {
            genAccessor();
          }
        }

        if( _runInEDT )
        {
          genTransfer( true );
        }

        if( _runOutsideEDT )
        {
          genTransfer( false );
        }

        if( _requiresEDT )
        {
          genIsDispatchThreadInvoke( mv );
          final Label end = new Label();
          mv.visitJumpInsn( Opcodes.IFNE, end );
          genIllegalStateException( mv,
                                    "Method " + methodName + " must only be " +
                                    "invoked in the Event Dispatch Thread." );
          mv.visitLabel( end );
        }
        if( _disallowsEDT )
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
        _adapterCount += 1;
        final String helperClass =
          _classname + "$Sw_" + methodName + "_" + _adapterCount;
        mv.visitTypeInsn( Opcodes.NEW, helperClass );
        mv.visitInsn( Opcodes.DUP );
        final StringBuilder paramDesc = new StringBuilder();
        int index = 0;
        if( !Modifier.isStatic( access ) )
        {
          paramDesc.append( 'L' );
          paramDesc.append( _classname );
          paramDesc.append( ';' );
          mv.visitVarInsn( Opcodes.ALOAD, index );
          index += 1;
        }
        for( final Type type : methodParameterTypes )
        {
          mv.visitVarInsn( loadOpcode( type.getSort() ), index );
          index += 1;
          paramDesc.append( type.getDescriptor() );
          index += isDoubleSlot( type ) ? 1 : 0;
        }
        final String helperConstructorDesc = "(" + paramDesc + ")V";
        mv.visitMethodInsn( Opcodes.INVOKESPECIAL, helperClass, "<init>", helperConstructorDesc, false );
        mv.visitMethodInsn( Opcodes.INVOKESTATIC,
                            "org/realityforge/swung_weave/DispatchUtil",
                            toEDT ? "invokeInEDT" : "invokeOutsideEDT",
                            "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;",
                            false );
        genReturn( mv, returnType );
        mv.visitLabel( end );

        final ClassWriter cw = new ClassWriter( ClassWriter.COMPUTE_FRAMES );
        cw.visit( Opcodes.V1_1,
                  Opcodes.ACC_FINAL | Opcodes.ACC_SYNTHETIC,
                  helperClass,
                  null,
                  "java/lang/Object",
                  new String[]{ "java/util/concurrent/Callable" } );

        int parameterID = 0;
        if( !Modifier.isStatic( access ) )
        {
          parameterID += 1;
          cw.visitField( Opcodes.ACC_PRIVATE | Opcodes.ACC_FINAL,
                         "p" + parameterID,
                         "L" + _classname + ";",
                         null,
                         null );
        }

        for( final Type type : methodParameterTypes )
        {
          parameterID += 1;
          cw.visitField( Opcodes.ACC_PRIVATE | Opcodes.ACC_FINAL,
                         "p" + parameterID,
                         type.getDescriptor(),
                         null,
                         null );
        }

        // default public constructor
        final MethodVisitor ctor = cw.visitMethod( Opcodes.ACC_PROTECTED,
                                                   "<init>",
                                                   helperConstructorDesc,
                                                   null,
                                                   null );
        ctor.visitVarInsn( Opcodes.ALOAD, 0 );
        ctor.visitMethodInsn( Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false );

        parameterID = 0;
        index = 0;
        if( !Modifier.isStatic( access ) )
        {
          parameterID += 1;
          index += 1;
          ctor.visitVarInsn( Opcodes.ALOAD, 0 );
          ctor.visitVarInsn( Opcodes.ALOAD, index );
          ctor.visitFieldInsn( Opcodes.PUTFIELD, helperClass, "p" + parameterID, "L" + _classname + ";" );
        }

        for( final Type type : methodParameterTypes )
        {
          parameterID += 1;
          index += 1;
          ctor.visitVarInsn( Opcodes.ALOAD, 0 );
          //the parameter to put in field
          ctor.visitVarInsn( loadOpcode( type.getSort() ), index );
          ctor.visitFieldInsn( Opcodes.PUTFIELD,
                               helperClass,
                               "p" + parameterID,
                               type.getDescriptor() );
          index += isDoubleSlot( type ) ? 1 : 0;
        }

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

        parameterID = 0;
        if( !Modifier.isStatic( access ) )
        {
          parameterID += 1;
          callMethod.visitVarInsn( Opcodes.ALOAD, 0 );
          callMethod.visitFieldInsn( Opcodes.GETFIELD, helperClass, "p" + parameterID, "L" + _classname + ";" );
        }

        for( final Type type : methodParameterTypes )
        {
          parameterID += 1;
          callMethod.visitVarInsn( Opcodes.ALOAD, 0 );
          callMethod.visitFieldInsn( Opcodes.GETFIELD,
                                     helperClass,
                                     "p" + parameterID,
                                     type.getDescriptor() );
        }
        final String targetMethodName;
        if ( Modifier.isPrivate( access ) )
        {
          targetMethodName = GENERATED_ACCESSOR_PREFIX + methodName;
        }
        else
        {
          targetMethodName = methodName;
        }
        callMethod.visitMethodInsn( invokeOpcode( access ), _classname, targetMethodName, desc, false );
        final int sort = returnType.getSort();
        if( Type.VOID == sort )
        {
          callMethod.visitInsn( Opcodes.ACONST_NULL );
        }
        else if( Type.BOOLEAN == sort )
        {
          callMethod.visitMethodInsn( Opcodes.INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false );
        }
        else if( Type.BYTE == sort )
        {
          callMethod.visitMethodInsn( Opcodes.INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;", false );
        }
        else if( Type.CHAR == sort)
        {
          callMethod.visitMethodInsn( Opcodes.INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;", false );
        }
        else if( Type.SHORT == sort )
        {
          callMethod.visitMethodInsn( Opcodes.INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;", false );
        }
        else if( Type.INT == sort )
        {
          callMethod.visitMethodInsn( Opcodes.INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false );
        }
        else if( Type.LONG == sort )
        {
          callMethod.visitMethodInsn( Opcodes.INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false );
        }
        else if( Type.FLOAT == sort )
        {
          callMethod.visitMethodInsn( Opcodes.INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;", false );
        }
        else if( Type.DOUBLE == sort )
        {
          callMethod.visitMethodInsn( Opcodes.INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;", false );
        }
        else //OBJECT and arrays
        {
          //Nothing
        }
        callMethod.visitInsn( Opcodes.ARETURN );

        // max stack and max locals automatically computed
        callMethod.visitMaxs( 0, 0 );
        callMethod.visitEnd();

        _adapters.put( helperClass.replace( '/', '.' ), cw.toByteArray() );
      }

      private void genAccessor()
      {
        //Generate accessor
        final int accessModifiers = Opcodes.ACC_PROTECTED + ( Modifier.isStatic( access ) ? Opcodes.ACC_STATIC : 0 );
        final MethodVisitor accessorMethod =
          cv.visitMethod( accessModifiers, GENERATED_ACCESSOR_PREFIX + methodName, desc, signature, exceptions );

        int index = 0;
        if ( !Modifier.isStatic( access ) )
        {
          accessorMethod.visitVarInsn( Opcodes.ALOAD, 0 );
          index += 1;
        }

        for ( final Type type : methodParameterTypes )
        {
          accessorMethod.visitVarInsn( loadOpcode( type.getSort() ), index );
          index += 1 + ( isDoubleSlot( type ) ? 1 : 0 );
        }

        final int invokeOpcode = invokeOpcode( access );
        accessorMethod.visitMethodInsn( invokeOpcode, _classname, methodName, desc, false );
        final int sort = returnType.getSort();
        if ( Type.VOID == sort )
        {
          accessorMethod.visitInsn( Opcodes.RETURN );
        }
        else if ( Type.BOOLEAN == sort ||
                  Type.BYTE == sort ||
                  Type.CHAR == sort ||
                  Type.SHORT == sort ||
                  Type.INT == sort )
        {
          accessorMethod.visitInsn( Opcodes.IRETURN );
        }
        else if ( Type.LONG == sort )
        {
          accessorMethod.visitInsn( Opcodes.LRETURN );
        }
        else if ( Type.FLOAT == sort )
        {
          accessorMethod.visitInsn( Opcodes.FRETURN );
        }
        else if ( Type.DOUBLE == sort )
        {
          accessorMethod.visitInsn( Opcodes.DRETURN );
        }
        else //OBJECT and arrays
        {
          accessorMethod.visitInsn( Opcodes.ARETURN );
        }

        // max stack and max locals automatically computed
        accessorMethod.visitMaxs( 0, 0 );
        accessorMethod.visitEnd();
      }
    };
  }

  private static int invokeOpcode( final int access )
  {
    final int invokeOpcode;
    if ( !Modifier.isStatic( access ) )
    {
      invokeOpcode = Opcodes.INVOKEVIRTUAL;
    }
    else
    {
      invokeOpcode = Opcodes.INVOKESTATIC;
    }
    return invokeOpcode;
  }

  private static boolean isDoubleSlot( final Type type )
  {
    return Type.DOUBLE == type.getSort() || Type.LONG == type.getSort();
  }

  static void genIsDispatchThreadInvoke( final MethodVisitor mv )
  {
    mv.visitMethodInsn( Opcodes.INVOKESTATIC,
                        "java/awt/EventQueue",
                        "isDispatchThread",
                        "()Z",
                        false);
  }

  static void genIllegalStateException( final MethodVisitor mv,
                                        final String message )
  {
    final String exception = "java/lang/IllegalStateException";
    mv.visitTypeInsn( Opcodes.NEW, exception );
    mv.visitInsn( Opcodes.DUP );
    mv.visitLdcInsn( message );
    mv.visitMethodInsn( Opcodes.INVOKESPECIAL, exception, "<init>", "(Ljava/lang/String;)V", false );
    mv.visitInsn( Opcodes.ATHROW );
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
    else if( Type.BOOLEAN == sort )
    {
      mv.visitTypeInsn( Opcodes.CHECKCAST, "java/lang/Boolean" );
      mv.visitMethodInsn( Opcodes.INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false );
      mv.visitInsn( Opcodes.IRETURN );
    }
    else if( Type.BYTE == sort )
    {
      mv.visitTypeInsn( Opcodes.CHECKCAST, "java/lang/Byte" );
      mv.visitMethodInsn( Opcodes.INVOKEVIRTUAL, "java/lang/Byte", "byteValue", "()B", false );
      mv.visitInsn( Opcodes.IRETURN );
    }
    else if( Type.CHAR == sort)
    {
      mv.visitTypeInsn( Opcodes.CHECKCAST, "java/lang/Character" );
      mv.visitMethodInsn( Opcodes.INVOKEVIRTUAL, "java/lang/Character", "charValue", "()C", false );
      mv.visitInsn( Opcodes.IRETURN );
    }
    else if( Type.SHORT == sort )
    {
      mv.visitTypeInsn( Opcodes.CHECKCAST, "java/lang/Short" );
      mv.visitMethodInsn( Opcodes.INVOKEVIRTUAL, "java/lang/Short", "shortValue", "()S", false );
      mv.visitInsn( Opcodes.IRETURN );
    }
    else if( Type.INT == sort )
    {
      mv.visitTypeInsn( Opcodes.CHECKCAST, "java/lang/Integer" );
      mv.visitMethodInsn( Opcodes.INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false );
      mv.visitInsn( Opcodes.IRETURN );
    }
    else if( Type.LONG == sort )
    {
      mv.visitTypeInsn( Opcodes.CHECKCAST, "java/lang/Long" );
      mv.visitMethodInsn( Opcodes.INVOKEVIRTUAL, "java/lang/Long", "longValue", "()J", false );
      mv.visitInsn( Opcodes.LRETURN );
    }
    else if( Type.FLOAT == sort )
    {
      mv.visitTypeInsn( Opcodes.CHECKCAST, "java/lang/Float" );
      mv.visitMethodInsn( Opcodes.INVOKEVIRTUAL, "java/lang/Float", "floatValue", "()F", false );
      mv.visitInsn( Opcodes.FRETURN );
    }
    else if( Type.DOUBLE == sort )
    {
      mv.visitTypeInsn( Opcodes.CHECKCAST, "java/lang/Double" );
      mv.visitMethodInsn( Opcodes.INVOKEVIRTUAL, "java/lang/Double", "doubleValue", "()D", false );
      mv.visitInsn( Opcodes.DRETURN );
    }
    else //OBJECT and arrays
    {
      mv.visitTypeInsn( Opcodes.CHECKCAST, returnType.getInternalName() );
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
