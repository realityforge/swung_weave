package org.realityforge.swung_weave.tool;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

final class GenUtil
{
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
}
