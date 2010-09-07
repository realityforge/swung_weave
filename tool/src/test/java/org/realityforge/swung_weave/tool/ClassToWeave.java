package org.realityforge.swung_weave.tool;

import javax.swing.SwingUtilities;
import org.realityforge.swung_weave.DisallowsEDT;
import org.realityforge.swung_weave.RequiresEDT;
import org.realityforge.swung_weave.RunInEDT;
import org.realityforge.swung_weave.RunOutsideEDT;
import org.testng.Assert;

@SuppressWarnings( { "UnusedDeclaration" } )
public class ClassToWeave
{                                             
  @RequiresEDT
  public static boolean RequiresEDT_s_rZ()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], boolean.class );
    return true;
  }

  @RequiresEDT
  public static byte RequiresEDT_s_rB()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], byte.class );
    return (byte) 1;
  }

  @RequiresEDT
  public static char RequiresEDT_s_rC()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], char.class );
    return 'a';
  }

  @RequiresEDT
  public static short RequiresEDT_s_rS()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], short.class );
    return (short) 1;
  }

  @RequiresEDT
  public static int RequiresEDT_s_rI()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], int.class );
    return 1;
  }

  @RequiresEDT
  public static long RequiresEDT_s_rJ()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], long.class );
    return 1L;
  }

  @RequiresEDT
  public static float RequiresEDT_s_rF()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], float.class );
    return 1.0F;
  }

  @RequiresEDT
  public static double RequiresEDT_s_rD()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], double.class );
    return 1.0D;
  }

  @RequiresEDT
  public static String RequiresEDT_s_rA()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], String.class );
    return "";
  }

  @RequiresEDT
  public static boolean[] RequiresEDT_s_raZ()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], boolean[].class );
    return new boolean[0];
  }

  @RequiresEDT
  public static byte[] RequiresEDT_s_raB()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], byte[].class );
    return new byte[0];
  }

  @RequiresEDT
  public static char[] RequiresEDT_s_raC()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], char[].class );
    return new char[0];
  }

  @RequiresEDT
  public static short[] RequiresEDT_s_raS()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], short[].class );
    return new short[0];
  }

  @RequiresEDT
  public static int[] RequiresEDT_s_raI()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], int[].class );
    return new int[0];
  }

  @RequiresEDT
  public static long[] RequiresEDT_s_raJ()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], long[].class );
    return new long[0];
  }

  @RequiresEDT
  public static float[] RequiresEDT_s_raF()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], float[].class );
    return new float[0];
  }

  @RequiresEDT
  public static double[] RequiresEDT_s_raD()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], double[].class );
    return new double[0];
  }

  @RequiresEDT
  public static String[] RequiresEDT_s_raA()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], String[].class );
    return new String[0];
  }

  // Instance methods with return values

  @RequiresEDT
  public boolean RequiresEDT_i_rZ()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], boolean.class );
    return true;
  }

  @RequiresEDT
  public byte RequiresEDT_i_rB()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], byte.class );
    return (byte) 1;
  }

  @RequiresEDT
  public char RequiresEDT_i_rC()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], char.class );
    return (char) 1;
  }

  @RequiresEDT
  public short RequiresEDT_i_rS()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], short.class );
    return (short) 1;
  }

  @RequiresEDT
  public int RequiresEDT_i_rI()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], int.class );
    return 1;
  }

  @RequiresEDT
  public long RequiresEDT_i_rJ()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], long.class );
    return 1L;
  }

  @RequiresEDT
  public float RequiresEDT_i_rF()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], float.class );
    return 1.0F;
  }

  @RequiresEDT
  public double RequiresEDT_i_rD()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], double.class );
    return 1.0D;
  }

  @RequiresEDT
  public String RequiresEDT_i_rA()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], String.class );
    return "";
  }

  @RequiresEDT
  public boolean[] RequiresEDT_i_raZ()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], boolean[].class );
    return new boolean[0];
  }

  @RequiresEDT
  public byte[] RequiresEDT_i_raB()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], byte[].class );
    return new byte[0];
  }

  @RequiresEDT
  public char[] RequiresEDT_i_raC()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], char[].class );
    return new char[0];
  }

  @RequiresEDT
  public short[] RequiresEDT_i_raS()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], short[].class );
    return new short[0];
  }

  @RequiresEDT
  public int[] RequiresEDT_i_raI()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], int[].class );
    return new int[0];
  }

  @RequiresEDT
  public long[] RequiresEDT_i_raJ()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], long[].class );
    return new long[0];
  }

  @RequiresEDT
  public float[] RequiresEDT_i_raF()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], float[].class );
    return new float[0];
  }

  @RequiresEDT
  public double[] RequiresEDT_i_raD()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], double[].class );
    return new double[0];
  }

  @RequiresEDT
  public String[] RequiresEDT_i_raA()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], String[].class );
    return new String[0];
  }

  // Static methods for RequiresEDT

  @RequiresEDT
  public static void RequiresEDT_s()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_Z( final boolean v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_B( final byte v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_C( final char v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_S( final short v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_I( final int v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_J( final long v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_F( final float v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_D( final double v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_A( final String v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aZ( final boolean[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aB( final byte[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aC( final char[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aS( final short[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aI( final int[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aJ( final long[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aF( final float[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aD( final double[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aA( final String[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public static void RequiresEDT_s_ZBCSIJFDAaZaBaCaSaIaJaFaDaA( final boolean v1,
                                                                final byte v2,
                                                                final char v3,
                                                                final short v4,
                                                                final int v5,
                                                                final long v6,
                                                                final float v7,
                                                                final double v8,
                                                                final String v9,
                                                                final boolean[] v10,
                                                                final byte[] v11,
                                                                final char[] v12,
                                                                final short[] v13,
                                                                final int[] v14,
                                                                final long[] v15,
                                                                final float[] v16,
                                                                final double[] v17,
                                                                final String[] v18 )
  {
    record( RequiresEDT.class,
            TestInvocation.STATIC,
            new Object[]{ v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18 },
            Void.TYPE );
  }

  // Instance methods for RequiresEDT

  @RequiresEDT
  public void RequiresEDT_i()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_Z( final boolean v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_B( final byte v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_C( final char v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_S( final short v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_I( final int v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_J( final long v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_F( final float v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_D( final double v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_A( final String v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_aZ( final boolean[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_aB( final byte[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_aC( final char[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_aS( final short[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_aI( final int[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_aJ( final long[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_aF( final float[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_aD( final double[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_aA( final String[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  public void RequiresEDT_i_ZBCSIJFDAaZaBaCaSaIaJaFaDaA( final boolean v1,
                                                         final byte v2,
                                                         final char v3,
                                                         final short v4,
                                                         final int v5,
                                                         final long v6,
                                                         final float v7,
                                                         final double v8,
                                                         final String v9,
                                                         final boolean[] v10,
                                                         final byte[] v11,
                                                         final char[] v12,
                                                         final short[] v13,
                                                         final int[] v14,
                                                         final long[] v15,
                                                         final float[] v16,
                                                         final double[] v17,
                                                         final String[] v18 )
  {
    record( RequiresEDT.class,
            TestInvocation.INSTANCE,
            new Object[]{ v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18 },
            Void.TYPE );
  }

  @DisallowsEDT
  public static boolean DisallowsEDT_s_rZ()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], boolean.class );
    return true;
  }

  @DisallowsEDT
  public static byte DisallowsEDT_s_rB()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], byte.class );
    return (byte) 1;
  }

  @DisallowsEDT
  public static char DisallowsEDT_s_rC()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], char.class );
    return 'a';
  }

  @DisallowsEDT
  public static short DisallowsEDT_s_rS()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], short.class );
    return (short) 1;
  }

  @DisallowsEDT
  public static int DisallowsEDT_s_rI()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], int.class );
    return 1;
  }

  @DisallowsEDT
  public static long DisallowsEDT_s_rJ()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], long.class );
    return 1L;
  }

  @DisallowsEDT
  public static float DisallowsEDT_s_rF()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], float.class );
    return 1.0F;
  }

  @DisallowsEDT
  public static double DisallowsEDT_s_rD()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], double.class );
    return 1.0D;
  }

  @DisallowsEDT
  public static String DisallowsEDT_s_rA()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], String.class );
    return "";
  }

  @DisallowsEDT
  public static boolean[] DisallowsEDT_s_raZ()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], boolean[].class );
    return new boolean[0];
  }

  @DisallowsEDT
  public static byte[] DisallowsEDT_s_raB()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], byte[].class );
    return new byte[0];
  }

  @DisallowsEDT
  public static char[] DisallowsEDT_s_raC()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], char[].class );
    return new char[0];
  }

  @DisallowsEDT
  public static short[] DisallowsEDT_s_raS()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], short[].class );
    return new short[0];
  }

  @DisallowsEDT
  public static int[] DisallowsEDT_s_raI()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], int[].class );
    return new int[0];
  }

  @DisallowsEDT
  public static long[] DisallowsEDT_s_raJ()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], long[].class );
    return new long[0];
  }

  @DisallowsEDT
  public static float[] DisallowsEDT_s_raF()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], float[].class );
    return new float[0];
  }

  @DisallowsEDT
  public static double[] DisallowsEDT_s_raD()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], double[].class );
    return new double[0];
  }

  @DisallowsEDT
  public static String[] DisallowsEDT_s_raA()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], String[].class );
    return new String[0];
  }

  // Instance methods with return values

  @DisallowsEDT
  public boolean DisallowsEDT_i_rZ()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], boolean.class );
    return true;
  }

  @DisallowsEDT
  public byte DisallowsEDT_i_rB()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], byte.class );
    return (byte) 1;
  }

  @DisallowsEDT
  public char DisallowsEDT_i_rC()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], char.class );
    return (char) 1;
  }

  @DisallowsEDT
  public short DisallowsEDT_i_rS()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], short.class );
    return (short) 1;
  }

  @DisallowsEDT
  public int DisallowsEDT_i_rI()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], int.class );
    return 1;
  }

  @DisallowsEDT
  public long DisallowsEDT_i_rJ()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], long.class );
    return 1L;
  }

  @DisallowsEDT
  public float DisallowsEDT_i_rF()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], float.class );
    return 1.0F;
  }

  @DisallowsEDT
  public double DisallowsEDT_i_rD()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], double.class );
    return 1.0D;
  }

  @DisallowsEDT
  public String DisallowsEDT_i_rA()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], String.class );
    return "";
  }

  @DisallowsEDT
  public boolean[] DisallowsEDT_i_raZ()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], boolean[].class );
    return new boolean[0];
  }

  @DisallowsEDT
  public byte[] DisallowsEDT_i_raB()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], byte[].class );
    return new byte[0];
  }

  @DisallowsEDT
  public char[] DisallowsEDT_i_raC()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], char[].class );
    return new char[0];
  }

  @DisallowsEDT
  public short[] DisallowsEDT_i_raS()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], short[].class );
    return new short[0];
  }

  @DisallowsEDT
  public int[] DisallowsEDT_i_raI()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], int[].class );
    return new int[0];
  }

  @DisallowsEDT
  public long[] DisallowsEDT_i_raJ()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], long[].class );
    return new long[0];
  }

  @DisallowsEDT
  public float[] DisallowsEDT_i_raF()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], float[].class );
    return new float[0];
  }

  @DisallowsEDT
  public double[] DisallowsEDT_i_raD()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], double[].class );
    return new double[0];
  }

  @DisallowsEDT
  public String[] DisallowsEDT_i_raA()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], String[].class );
    return new String[0];
  }


  // Static methods for DisallowsEDT

  @DisallowsEDT
  public static void DisallowsEDT_s()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_Z( final boolean v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_B( final byte v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_C( final char v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_S( final short v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_I( final int v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_J( final long v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_F( final float v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_D( final double v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_A( final String v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aZ( final boolean[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aB( final byte[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aC( final char[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aS( final short[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aI( final int[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aJ( final long[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aF( final float[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aD( final double[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aA( final String[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_ZBCSIJFDAaZaBaCaSaIaJaFaDaA( final boolean v1,
                                                                 final byte v2,
                                                                 final char v3,
                                                                 final short v4,
                                                                 final int v5,
                                                                 final long v6,
                                                                 final float v7,
                                                                 final double v8,
                                                                 final String v9,
                                                                 final boolean[] v10,
                                                                 final byte[] v11,
                                                                 final char[] v12,
                                                                 final short[] v13,
                                                                 final int[] v14,
                                                                 final long[] v15,
                                                                 final float[] v16,
                                                                 final double[] v17,
                                                                 final String[] v18 )
  {
    record( DisallowsEDT.class,
            TestInvocation.STATIC,
            new Object[]{ v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18 },
            Void.TYPE );
  }

  // Instance methods for DisallowsEDT

  @DisallowsEDT
  public void DisallowsEDT_i()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_Z( final boolean v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_B( final byte v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_C( final char v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_S( final short v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_I( final int v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_J( final long v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_F( final float v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_D( final double v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_A( final String v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aZ( final boolean[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aB( final byte[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aC( final char[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aS( final short[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aI( final int[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aJ( final long[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aF( final float[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aD( final double[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aA( final String[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_ZBCSIJFDAaZaBaCaSaIaJaFaDaA( final boolean v1,
                                                          final byte v2,
                                                          final char v3,
                                                          final short v4,
                                                          final int v5,
                                                          final long v6,
                                                          final float v7,
                                                          final double v8,
                                                          final String v9,
                                                          final boolean[] v10,
                                                          final byte[] v11,
                                                          final char[] v12,
                                                          final short[] v13,
                                                          final int[] v14,
                                                          final long[] v15,
                                                          final float[] v16,
                                                          final double[] v17,
                                                          final String[] v18 )
  {
    record( DisallowsEDT.class,
            TestInvocation.INSTANCE,
            new Object[]{ v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18 },
            Void.TYPE );
  }

  @RunInEDT
  public static boolean RunInEDT_s_rZ()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], boolean.class );
    return true;
  }

  @RunInEDT
  public static byte RunInEDT_s_rB()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], byte.class );
    return (byte) 1;
  }

  @RunInEDT
  public static char RunInEDT_s_rC()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], char.class );
    return 'a';
  }

  @RunInEDT
  public static short RunInEDT_s_rS()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], short.class );
    return (short) 1;
  }

  @RunInEDT
  public static int RunInEDT_s_rI()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], int.class );
    return 1;
  }

  @RunInEDT
  public static long RunInEDT_s_rJ()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], long.class );
    return 1L;
  }

  @RunInEDT
  public static float RunInEDT_s_rF()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], float.class );
    return 1.0F;
  }

  @RunInEDT
  public static double RunInEDT_s_rD()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], double.class );
    return 1.0D;
  }

  @RunInEDT
  public static String RunInEDT_s_rA()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], String.class );
    return "";
  }

  @RunInEDT
  public static boolean[] RunInEDT_s_raZ()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], boolean[].class );
    return new boolean[0];
  }

  @RunInEDT
  public static byte[] RunInEDT_s_raB()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], byte[].class );
    return new byte[0];
  }

  @RunInEDT
  public static char[] RunInEDT_s_raC()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], char[].class );
    return new char[0];
  }

  @RunInEDT
  public static short[] RunInEDT_s_raS()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], short[].class );
    return new short[0];
  }

  @RunInEDT
  public static int[] RunInEDT_s_raI()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], int[].class );
    return new int[0];
  }

  @RunInEDT
  public static long[] RunInEDT_s_raJ()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], long[].class );
    return new long[0];
  }

  @RunInEDT
  public static float[] RunInEDT_s_raF()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], float[].class );
    return new float[0];
  }

  @RunInEDT
  public static double[] RunInEDT_s_raD()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], double[].class );
    return new double[0];
  }

  @RunInEDT
  public static String[] RunInEDT_s_raA()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], String[].class );
    return new String[0];
  }

  // Instance methods with return values

  @RunInEDT
  public boolean RunInEDT_i_rZ()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], boolean.class );
    return true;
  }

  @RunInEDT
  public byte RunInEDT_i_rB()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], byte.class );
    return (byte) 1;
  }

  @RunInEDT
  public char RunInEDT_i_rC()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], char.class );
    return (char) 1;
  }

  @RunInEDT
  public short RunInEDT_i_rS()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], short.class );
    return (short) 1;
  }

  @RunInEDT
  public int RunInEDT_i_rI()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], int.class );
    return 1;
  }

  @RunInEDT
  public long RunInEDT_i_rJ()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], long.class );
    return 1L;
  }

  @RunInEDT
  public float RunInEDT_i_rF()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], float.class );
    return 1.0F;
  }

  @RunInEDT
  public double RunInEDT_i_rD()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], double.class );
    return 1.0D;
  }

  @RunInEDT
  public String RunInEDT_i_rA()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], String.class );
    return "";
  }

  @RunInEDT
  public boolean[] RunInEDT_i_raZ()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], boolean[].class );
    return new boolean[0];
  }

  @RunInEDT
  public byte[] RunInEDT_i_raB()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], byte[].class );
    return new byte[0];
  }

  @RunInEDT
  public char[] RunInEDT_i_raC()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], char[].class );
    return new char[0];
  }

  @RunInEDT
  public short[] RunInEDT_i_raS()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], short[].class );
    return new short[0];
  }

  @RunInEDT
  public int[] RunInEDT_i_raI()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], int[].class );
    return new int[0];
  }

  @RunInEDT
  public long[] RunInEDT_i_raJ()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], long[].class );
    return new long[0];
  }

  @RunInEDT
  public float[] RunInEDT_i_raF()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], float[].class );
    return new float[0];
  }

  @RunInEDT
  public double[] RunInEDT_i_raD()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], double[].class );
    return new double[0];
  }

  @RunInEDT
  public String[] RunInEDT_i_raA()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], String[].class );
    return new String[0];
  }

  // Static methods for RunInEDT

  @RunInEDT
  public static void RunInEDT_s()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_Z( final boolean v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_B( final byte v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_C( final char v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_S( final short v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_I( final int v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_J( final long v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_F( final float v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_D( final double v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_A( final String v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_aZ( final boolean[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_aB( final byte[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_aC( final char[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_aS( final short[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_aI( final int[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_aJ( final long[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_aF( final float[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_aD( final double[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_aA( final String[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public static void RunInEDT_s_ZBCSIJFDAaZaBaCaSaIaJaFaDaA( final boolean v1,
                                                             final byte v2,
                                                             final char v3,
                                                             final short v4,
                                                             final int v5,
                                                             final long v6,
                                                             final float v7,
                                                             final double v8,
                                                             final String v9,
                                                             final boolean[] v10,
                                                             final byte[] v11,
                                                             final char[] v12,
                                                             final short[] v13,
                                                             final int[] v14,
                                                             final long[] v15,
                                                             final float[] v16,
                                                             final double[] v17,
                                                             final String[] v18 )
  {
    record( RunInEDT.class,
            TestInvocation.STATIC,
            new Object[]{ v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18 },
            Void.TYPE );
  }

  // Instance methods for RunInEDT

  @RunInEDT
  public void RunInEDT_i()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_Z( final boolean v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_B( final byte v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_C( final char v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_S( final short v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_I( final int v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_J( final long v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_F( final float v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_D( final double v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_A( final String v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_aZ( final boolean[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_aB( final byte[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_aC( final char[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_aS( final short[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_aI( final int[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_aJ( final long[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_aF( final float[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_aD( final double[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_aA( final String[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  public void RunInEDT_i_ZBCSIJFDAaZaBaCaSaIaJaFaDaA( final boolean v1,
                                                      final byte v2,
                                                      final char v3,
                                                      final short v4,
                                                      final int v5,
                                                      final long v6,
                                                      final float v7,
                                                      final double v8,
                                                      final String v9,
                                                      final boolean[] v10,
                                                      final byte[] v11,
                                                      final char[] v12,
                                                      final short[] v13,
                                                      final int[] v14,
                                                      final long[] v15,
                                                      final float[] v16,
                                                      final double[] v17,
                                                      final String[] v18 )
  {
    record( RunInEDT.class,
            TestInvocation.INSTANCE,
            new Object[]{ v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18 },
            Void.TYPE );
  }

  @RunOutsideEDT
  public static boolean RunOutsideEDT_s_rZ()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], boolean.class );
    return true;
  }

  @RunOutsideEDT
  public static byte RunOutsideEDT_s_rB()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], byte.class );
    return (byte) 1;
  }

  @RunOutsideEDT
  public static char RunOutsideEDT_s_rC()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], char.class );
    return 'a';
  }

  @RunOutsideEDT
  public static short RunOutsideEDT_s_rS()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], short.class );
    return (short) 1;
  }

  @RunOutsideEDT
  public static int RunOutsideEDT_s_rI()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], int.class );
    return 1;
  }

  @RunOutsideEDT
  public static long RunOutsideEDT_s_rJ()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], long.class );
    return 1L;
  }

  @RunOutsideEDT
  public static float RunOutsideEDT_s_rF()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], float.class );
    return 1.0F;
  }

  @RunOutsideEDT
  public static double RunOutsideEDT_s_rD()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], double.class );
    return 1.0D;
  }

  @RunOutsideEDT
  public static String RunOutsideEDT_s_rA()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], String.class );
    return "";
  }

  @RunOutsideEDT
  public static boolean[] RunOutsideEDT_s_raZ()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], boolean[].class );
    return new boolean[0];
  }

  @RunOutsideEDT
  public static byte[] RunOutsideEDT_s_raB()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], byte[].class );
    return new byte[0];
  }

  @RunOutsideEDT
  public static char[] RunOutsideEDT_s_raC()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], char[].class );
    return new char[0];
  }

  @RunOutsideEDT
  public static short[] RunOutsideEDT_s_raS()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], short[].class );
    return new short[0];
  }

  @RunOutsideEDT
  public static int[] RunOutsideEDT_s_raI()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], int[].class );
    return new int[0];
  }

  @RunOutsideEDT
  public static long[] RunOutsideEDT_s_raJ()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], long[].class );
    return new long[0];
  }

  @RunOutsideEDT
  public static float[] RunOutsideEDT_s_raF()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], float[].class );
    return new float[0];
  }

  @RunOutsideEDT
  public static double[] RunOutsideEDT_s_raD()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], double[].class );
    return new double[0];
  }

  @RunOutsideEDT
  public static String[] RunOutsideEDT_s_raA()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], String[].class );
    return new String[0];
  }

  // Instance methods with return values

  @RunOutsideEDT
  public boolean RunOutsideEDT_i_rZ()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], boolean.class );
    return true;
  }

  @RunOutsideEDT
  public byte RunOutsideEDT_i_rB()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], byte.class );
    return (byte) 1;
  }

  @RunOutsideEDT
  public char RunOutsideEDT_i_rC()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], char.class );
    return (char) 1;
  }

  @RunOutsideEDT
  public short RunOutsideEDT_i_rS()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], short.class );
    return (short) 1;
  }

  @RunOutsideEDT
  public int RunOutsideEDT_i_rI()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], int.class );
    return 1;
  }

  @RunOutsideEDT
  public long RunOutsideEDT_i_rJ()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], long.class );
    return 1L;
  }

  @RunOutsideEDT
  public float RunOutsideEDT_i_rF()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], float.class );
    return 1.0F;
  }

  @RunOutsideEDT
  public double RunOutsideEDT_i_rD()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], double.class );
    return 1.0D;
  }

  @RunOutsideEDT
  public String RunOutsideEDT_i_rA()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], String.class );
    return "";
  }

  @RunOutsideEDT
  public boolean[] RunOutsideEDT_i_raZ()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], boolean[].class );
    return new boolean[0];
  }

  @RunOutsideEDT
  public byte[] RunOutsideEDT_i_raB()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], byte[].class );
    return new byte[0];
  }

  @RunOutsideEDT
  public char[] RunOutsideEDT_i_raC()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], char[].class );
    return new char[0];
  }

  @RunOutsideEDT
  public short[] RunOutsideEDT_i_raS()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], short[].class );
    return new short[0];
  }

  @RunOutsideEDT
  public int[] RunOutsideEDT_i_raI()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], int[].class );
    return new int[0];
  }

  @RunOutsideEDT
  public long[] RunOutsideEDT_i_raJ()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], long[].class );
    return new long[0];
  }

  @RunOutsideEDT
  public float[] RunOutsideEDT_i_raF()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], float[].class );
    return new float[0];
  }

  @RunOutsideEDT
  public double[] RunOutsideEDT_i_raD()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], double[].class );
    return new double[0];
  }

  @RunOutsideEDT
  public String[] RunOutsideEDT_i_raA()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], String[].class );
    return new String[0];
  }

  // Static methods for RunOutsideEDT

  @RunOutsideEDT
  public static void RunOutsideEDT_s()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_Z( final boolean v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_B( final byte v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_C( final char v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_S( final short v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_I( final int v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_J( final long v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_F( final float v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_D( final double v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_A( final String v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aZ( final boolean[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aB( final byte[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aC( final char[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aS( final short[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aI( final int[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aJ( final long[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aF( final float[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aD( final double[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aA( final String[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_ZBCSIJFDAaZaBaCaSaIaJaFaDaA( final boolean v1,
                                                                  final byte v2,
                                                                  final char v3,
                                                                  final short v4,
                                                                  final int v5,
                                                                  final long v6,
                                                                  final float v7,
                                                                  final double v8,
                                                                  final String v9,
                                                                  final boolean[] v10,
                                                                  final byte[] v11,
                                                                  final char[] v12,
                                                                  final short[] v13,
                                                                  final int[] v14,
                                                                  final long[] v15,
                                                                  final float[] v16,
                                                                  final double[] v17,
                                                                  final String[] v18 )
  {
    record( RunOutsideEDT.class,
            TestInvocation.STATIC,
            new Object[]{ v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18 },
            Void.TYPE );
  }

  // Instance methods for RunOutsideEDT

  @RunOutsideEDT
  public void RunOutsideEDT_i()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_Z( final boolean v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_B( final byte v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_C( final char v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_S( final short v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_I( final int v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_J( final long v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_F( final float v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_D( final double v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_A( final String v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aZ( final boolean[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aB( final byte[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aC( final char[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aS( final short[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aI( final int[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aJ( final long[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aF( final float[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aD( final double[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aA( final String[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_i_ZBCSIJFDAaZaBaCaSaIaJaFaDaA( final boolean v1,
                                                                  final byte v2,
                                                                  final char v3,
                                                                  final short v4,
                                                                  final int v5,
                                                                  final long v6,
                                                                  final float v7,
                                                                  final double v8,
                                                                  final String v9,
                                                                  final boolean[] v10,
                                                                  final byte[] v11,
                                                                  final char[] v12,
                                                                  final short[] v13,
                                                                  final int[] v14,
                                                                  final long[] v15,
                                                                  final float[] v16,
                                                                  final double[] v17,
                                                                  final String[] v18 )
  {
    record( RunOutsideEDT.class,
            TestInvocation.INSTANCE,
            new Object[]{ v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18 },
            Void.TYPE );
  }

  private static void record( final Class<?> annotation,
                              final int methodType,
                              final Object[] parameters,
                              final Class<?> returnType )
  {
    final TestInvocation entry = TestInvocation.current();
    if ( entry.annotation != annotation )
    {
      throw new IllegalStateException( "Current TestInvocation does not match expected annotation" );
    }
    if ( entry.methodType != methodType )
    {
      throw new IllegalStateException( "Current TestInvocation does not match expected methodType" );
    }
    if ( entry.returnType != returnType )
    {
      throw new IllegalStateException( "Current TestInvocation does not match expected returnType" );
    }
    if ( entry.expectedInEDT != SwingUtilities.isEventDispatchThread() )
    {
      throw new IllegalStateException( "Current TestInvocation does not match expected inEDT" );
    }
    try
    {
      Assert.assertEquals( entry.parameters, parameters );
    }
    catch ( Exception e )
    {
      throw new IllegalStateException( "Current TestInvocation does not match expected parameters", e );
    }
    entry.invoked();
  }
}
