package org.realityforge.swung_weave.tool;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

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
