package org.realityforge.swung_weave.tool;

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

  public SwClassAdapter( final ClassWriter cw )
  {
    super( cw );
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
    super.visit( version,
                 access,
                 name,
                 signature,
                 superName,
                 interfaces );
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
          GenUtil.genIsDispatchThreadInvoke( mv );
          final Label end = new Label();
          mv.visitJumpInsn( Opcodes.IFNE, end );
          m_adapterCount += 1;
          final String helperClass = m_classname + "$Sw_" + methodName + "_" + m_adapterCount;
          mv.visitTypeInsn( Opcodes.NEW, helperClass );
          mv.visitInsn( Opcodes.DUP );
          //Non static
          int index = (access & Opcodes.ACC_STATIC) == 0 ? 1 : 0;
          final StringBuilder paramDesc = new StringBuilder();
          for( final Type type : methodParameterTypes )
          {
            final int sort = type.getSort();
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
            mv.visitVarInsn( opcode, index );
            index += 1;
            paramDesc.append( type.getDescriptor() );
            paramDesc.append( ';' );
          }
          mv.visitMethodInsn( Opcodes.INVOKESPECIAL, helperClass, "<init>", "(" + paramDesc + ")V" );
          mv.visitMethodInsn( Opcodes.INVOKESTATIC,
                              "org/realityforge/swung_weave/DispatchUtil",
                              "invokeAndWait",
                              "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;" );
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
          mv.visitLabel( end );
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
    };
  }
}
