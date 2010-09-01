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
  public SwClassAdapter( final ClassWriter cw )
  {
    super( cw );
  }

  public MethodVisitor visitMethod( final int access,
                                    final String name,
                                    final String desc,
                                    final String signature,
                                    final String[] exceptions )
  {
    final Type[] args = Type.getArgumentTypes( desc );
    MethodVisitor v = cv.visitMethod( access,
                                      name,
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
        if( requiresEDT )
        {
          GenUtil.genIsDispatchThreadInvoke( mv );
          final Label end = new Label();
          mv.visitJumpInsn( Opcodes.IFNE, end );
          GenUtil.genIllegalStateException( mv,
                                            "Method " + name + ";" + desc + " must only be " +
                                            "invoked in the Event Dispatch Thread." );
          mv.visitLabel( end );
        }
        if( disallowsEDT )
        {
          GenUtil.genIsDispatchThreadInvoke( mv );
          final Label end = new Label();
          mv.visitJumpInsn( Opcodes.IFEQ, end );
          GenUtil.genIllegalStateException( mv,
                                            "Method " + name + ";" + desc + " must not be " +
                                            "invoked in the Event Dispatch Thread." );
          mv.visitLabel( end );
        }
      }
    };
  }
}
