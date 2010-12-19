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

  @RequiresEDT
  private static boolean RequiresEDT_ps_rZ()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], boolean.class );
    return true;
  }

  @RequiresEDT
  private static byte RequiresEDT_ps_rB()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], byte.class );
    return (byte) 1;
  }

  @RequiresEDT
  private static char RequiresEDT_ps_rC()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], char.class );
    return 'a';
  }

  @RequiresEDT
  private static short RequiresEDT_ps_rS()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], short.class );
    return (short) 1;
  }

  @RequiresEDT
  private static int RequiresEDT_ps_rI()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], int.class );
    return 1;
  }

  @RequiresEDT
  private static long RequiresEDT_ps_rJ()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], long.class );
    return 1L;
  }

  @RequiresEDT
  private static float RequiresEDT_ps_rF()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], float.class );
    return 1.0F;
  }

  @RequiresEDT
  private static double RequiresEDT_ps_rD()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], double.class );
    return 1.0D;
  }

  @RequiresEDT
  private static String RequiresEDT_ps_rA()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], String.class );
    return "";
  }

  @RequiresEDT
  private static boolean[] RequiresEDT_ps_raZ()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], boolean[].class );
    return new boolean[0];
  }

  @RequiresEDT
  private static byte[] RequiresEDT_ps_raB()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], byte[].class );
    return new byte[0];
  }

  @RequiresEDT
  private static char[] RequiresEDT_ps_raC()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], char[].class );
    return new char[0];
  }

  @RequiresEDT
  private static short[] RequiresEDT_ps_raS()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], short[].class );
    return new short[0];
  }

  @RequiresEDT
  private static int[] RequiresEDT_ps_raI()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], int[].class );
    return new int[0];
  }

  @RequiresEDT
  private static long[] RequiresEDT_ps_raJ()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], long[].class );
    return new long[0];
  }

  @RequiresEDT
  private static float[] RequiresEDT_ps_raF()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], float[].class );
    return new float[0];
  }

  @RequiresEDT
  private static double[] RequiresEDT_ps_raD()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], double[].class );
    return new double[0];
  }

  @RequiresEDT
  private static String[] RequiresEDT_ps_raA()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], String[].class );
    return new String[0];
  }

  // Instance methods with return values

  @RequiresEDT
  private boolean RequiresEDT_pi_rZ()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], boolean.class );
    return true;
  }

  @RequiresEDT
  private byte RequiresEDT_pi_rB()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], byte.class );
    return (byte) 1;
  }

  @RequiresEDT
  private char RequiresEDT_pi_rC()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], char.class );
    return (char) 1;
  }

  @RequiresEDT
  private short RequiresEDT_pi_rS()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], short.class );
    return (short) 1;
  }

  @RequiresEDT
  private int RequiresEDT_pi_rI()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], int.class );
    return 1;
  }

  @RequiresEDT
  private long RequiresEDT_pi_rJ()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], long.class );
    return 1L;
  }

  @RequiresEDT
  private float RequiresEDT_pi_rF()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], float.class );
    return 1.0F;
  }

  @RequiresEDT
  private double RequiresEDT_pi_rD()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], double.class );
    return 1.0D;
  }

  @RequiresEDT
  private String RequiresEDT_pi_rA()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], String.class );
    return "";
  }

  @RequiresEDT
  private boolean[] RequiresEDT_pi_raZ()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], boolean[].class );
    return new boolean[0];
  }

  @RequiresEDT
  private byte[] RequiresEDT_pi_raB()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], byte[].class );
    return new byte[0];
  }

  @RequiresEDT
  private char[] RequiresEDT_pi_raC()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], char[].class );
    return new char[0];
  }

  @RequiresEDT
  private short[] RequiresEDT_pi_raS()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], short[].class );
    return new short[0];
  }

  @RequiresEDT
  private int[] RequiresEDT_pi_raI()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], int[].class );
    return new int[0];
  }

  @RequiresEDT
  private long[] RequiresEDT_pi_raJ()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], long[].class );
    return new long[0];
  }

  @RequiresEDT
  private float[] RequiresEDT_pi_raF()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], float[].class );
    return new float[0];
  }

  @RequiresEDT
  private double[] RequiresEDT_pi_raD()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], double[].class );
    return new double[0];
  }

  @RequiresEDT
  private String[] RequiresEDT_pi_raA()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], String[].class );
    return new String[0];
  }

  // Static methods for RequiresEDT

  @RequiresEDT
  private static void RequiresEDT_ps()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0], Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_Z( final boolean v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_B( final byte v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_C( final char v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_S( final short v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_I( final int v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_J( final long v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_F( final float v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_D( final double v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_A( final String v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_aZ( final boolean[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_aB( final byte[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_aC( final char[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_aS( final short[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_aI( final int[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_aJ( final long[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_aF( final float[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_aD( final double[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_aA( final String[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private static void RequiresEDT_ps_ZBCSIJFDAaZaBaCaSaIaJaFaDaA( final boolean v1,
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
  private void RequiresEDT_pi()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0], Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_Z( final boolean v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_B( final byte v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_C( final char v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_S( final short v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_I( final int v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_J( final long v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_F( final float v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_D( final double v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_A( final String v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_aZ( final boolean[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_aB( final byte[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_aC( final char[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_aS( final short[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_aI( final int[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_aJ( final long[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_aF( final float[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_aD( final double[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_aA( final String[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RequiresEDT
  private void RequiresEDT_pi_ZBCSIJFDAaZaBaCaSaIaJaFaDaA( final boolean v1,
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
  private static boolean DisallowsEDT_ps_rZ()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], boolean.class );
    return true;
  }

  @DisallowsEDT
  private static byte DisallowsEDT_ps_rB()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], byte.class );
    return (byte) 1;
  }

  @DisallowsEDT
  private static char DisallowsEDT_ps_rC()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], char.class );
    return 'a';
  }

  @DisallowsEDT
  private static short DisallowsEDT_ps_rS()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], short.class );
    return (short) 1;
  }

  @DisallowsEDT
  private static int DisallowsEDT_ps_rI()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], int.class );
    return 1;
  }

  @DisallowsEDT
  private static long DisallowsEDT_ps_rJ()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], long.class );
    return 1L;
  }

  @DisallowsEDT
  private static float DisallowsEDT_ps_rF()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], float.class );
    return 1.0F;
  }

  @DisallowsEDT
  private static double DisallowsEDT_ps_rD()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], double.class );
    return 1.0D;
  }

  @DisallowsEDT
  private static String DisallowsEDT_ps_rA()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], String.class );
    return "";
  }

  @DisallowsEDT
  private static boolean[] DisallowsEDT_ps_raZ()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], boolean[].class );
    return new boolean[0];
  }

  @DisallowsEDT
  private static byte[] DisallowsEDT_ps_raB()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], byte[].class );
    return new byte[0];
  }

  @DisallowsEDT
  private static char[] DisallowsEDT_ps_raC()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], char[].class );
    return new char[0];
  }

  @DisallowsEDT
  private static short[] DisallowsEDT_ps_raS()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], short[].class );
    return new short[0];
  }

  @DisallowsEDT
  private static int[] DisallowsEDT_ps_raI()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], int[].class );
    return new int[0];
  }

  @DisallowsEDT
  private static long[] DisallowsEDT_ps_raJ()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], long[].class );
    return new long[0];
  }

  @DisallowsEDT
  private static float[] DisallowsEDT_ps_raF()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], float[].class );
    return new float[0];
  }

  @DisallowsEDT
  private static double[] DisallowsEDT_ps_raD()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], double[].class );
    return new double[0];
  }

  @DisallowsEDT
  private static String[] DisallowsEDT_ps_raA()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], String[].class );
    return new String[0];
  }

  // Instance methods with return values

  @DisallowsEDT
  private boolean DisallowsEDT_pi_rZ()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], boolean.class );
    return true;
  }

  @DisallowsEDT
  private byte DisallowsEDT_pi_rB()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], byte.class );
    return (byte) 1;
  }

  @DisallowsEDT
  private char DisallowsEDT_pi_rC()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], char.class );
    return (char) 1;
  }

  @DisallowsEDT
  private short DisallowsEDT_pi_rS()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], short.class );
    return (short) 1;
  }

  @DisallowsEDT
  private int DisallowsEDT_pi_rI()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], int.class );
    return 1;
  }

  @DisallowsEDT
  private long DisallowsEDT_pi_rJ()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], long.class );
    return 1L;
  }

  @DisallowsEDT
  private float DisallowsEDT_pi_rF()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], float.class );
    return 1.0F;
  }

  @DisallowsEDT
  private double DisallowsEDT_pi_rD()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], double.class );
    return 1.0D;
  }

  @DisallowsEDT
  private String DisallowsEDT_pi_rA()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], String.class );
    return "";
  }

  @DisallowsEDT
  private boolean[] DisallowsEDT_pi_raZ()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], boolean[].class );
    return new boolean[0];
  }

  @DisallowsEDT
  private byte[] DisallowsEDT_pi_raB()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], byte[].class );
    return new byte[0];
  }

  @DisallowsEDT
  private char[] DisallowsEDT_pi_raC()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], char[].class );
    return new char[0];
  }

  @DisallowsEDT
  private short[] DisallowsEDT_pi_raS()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], short[].class );
    return new short[0];
  }

  @DisallowsEDT
  private int[] DisallowsEDT_pi_raI()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], int[].class );
    return new int[0];
  }

  @DisallowsEDT
  private long[] DisallowsEDT_pi_raJ()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], long[].class );
    return new long[0];
  }

  @DisallowsEDT
  private float[] DisallowsEDT_pi_raF()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], float[].class );
    return new float[0];
  }

  @DisallowsEDT
  private double[] DisallowsEDT_pi_raD()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], double[].class );
    return new double[0];
  }

  @DisallowsEDT
  private String[] DisallowsEDT_pi_raA()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], String[].class );
    return new String[0];
  }


  // Static methods for DisallowsEDT

  @DisallowsEDT
  private static void DisallowsEDT_ps()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0], Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_Z( final boolean v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_B( final byte v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_C( final char v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_S( final short v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_I( final int v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_J( final long v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_F( final float v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_D( final double v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_A( final String v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_aZ( final boolean[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_aB( final byte[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_aC( final char[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_aS( final short[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_aI( final int[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_aJ( final long[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_aF( final float[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_aD( final double[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_aA( final String[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private static void DisallowsEDT_ps_ZBCSIJFDAaZaBaCaSaIaJaFaDaA( final boolean v1,
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
  private void DisallowsEDT_pi()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0], Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_Z( final boolean v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_B( final byte v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_C( final char v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_S( final short v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_I( final int v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_J( final long v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_F( final float v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_D( final double v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_A( final String v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_aZ( final boolean[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_aB( final byte[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_aC( final char[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_aS( final short[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_aI( final int[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_aJ( final long[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_aF( final float[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_aD( final double[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_aA( final String[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @DisallowsEDT
  private void DisallowsEDT_pi_ZBCSIJFDAaZaBaCaSaIaJaFaDaA( final boolean v1,
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
  private static boolean RunInEDT_ps_rZ()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], boolean.class );
    return true;
  }

  @RunInEDT
  private static byte RunInEDT_ps_rB()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], byte.class );
    return (byte) 1;
  }

  @RunInEDT
  private static char RunInEDT_ps_rC()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], char.class );
    return 'a';
  }

  @RunInEDT
  private static short RunInEDT_ps_rS()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], short.class );
    return (short) 1;
  }

  @RunInEDT
  private static int RunInEDT_ps_rI()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], int.class );
    return 1;
  }

  @RunInEDT
  private static long RunInEDT_ps_rJ()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], long.class );
    return 1L;
  }

  @RunInEDT
  private static float RunInEDT_ps_rF()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], float.class );
    return 1.0F;
  }

  @RunInEDT
  private static double RunInEDT_ps_rD()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], double.class );
    return 1.0D;
  }

  @RunInEDT
  private static String RunInEDT_ps_rA()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], String.class );
    return "";
  }

  @RunInEDT
  private static boolean[] RunInEDT_ps_raZ()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], boolean[].class );
    return new boolean[0];
  }

  @RunInEDT
  private static byte[] RunInEDT_ps_raB()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], byte[].class );
    return new byte[0];
  }

  @RunInEDT
  private static char[] RunInEDT_ps_raC()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], char[].class );
    return new char[0];
  }

  @RunInEDT
  private static short[] RunInEDT_ps_raS()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], short[].class );
    return new short[0];
  }

  @RunInEDT
  private static int[] RunInEDT_ps_raI()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], int[].class );
    return new int[0];
  }

  @RunInEDT
  private static long[] RunInEDT_ps_raJ()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], long[].class );
    return new long[0];
  }

  @RunInEDT
  private static float[] RunInEDT_ps_raF()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], float[].class );
    return new float[0];
  }

  @RunInEDT
  private static double[] RunInEDT_ps_raD()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], double[].class );
    return new double[0];
  }

  @RunInEDT
  private static String[] RunInEDT_ps_raA()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], String[].class );
    return new String[0];
  }

  // Instance methods with return values

  @RunInEDT
  private boolean RunInEDT_pi_rZ()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], boolean.class );
    return true;
  }

  @RunInEDT
  private byte RunInEDT_pi_rB()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], byte.class );
    return (byte) 1;
  }

  @RunInEDT
  private char RunInEDT_pi_rC()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], char.class );
    return (char) 1;
  }

  @RunInEDT
  private short RunInEDT_pi_rS()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], short.class );
    return (short) 1;
  }

  @RunInEDT
  private int RunInEDT_pi_rI()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], int.class );
    return 1;
  }

  @RunInEDT
  private long RunInEDT_pi_rJ()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], long.class );
    return 1L;
  }

  @RunInEDT
  private float RunInEDT_pi_rF()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], float.class );
    return 1.0F;
  }

  @RunInEDT
  private double RunInEDT_pi_rD()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], double.class );
    return 1.0D;
  }

  @RunInEDT
  private String RunInEDT_pi_rA()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], String.class );
    return "";
  }

  @RunInEDT
  private boolean[] RunInEDT_pi_raZ()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], boolean[].class );
    return new boolean[0];
  }

  @RunInEDT
  private byte[] RunInEDT_pi_raB()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], byte[].class );
    return new byte[0];
  }

  @RunInEDT
  private char[] RunInEDT_pi_raC()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], char[].class );
    return new char[0];
  }

  @RunInEDT
  private short[] RunInEDT_pi_raS()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], short[].class );
    return new short[0];
  }

  @RunInEDT
  private int[] RunInEDT_pi_raI()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], int[].class );
    return new int[0];
  }

  @RunInEDT
  private long[] RunInEDT_pi_raJ()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], long[].class );
    return new long[0];
  }

  @RunInEDT
  private float[] RunInEDT_pi_raF()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], float[].class );
    return new float[0];
  }

  @RunInEDT
  private double[] RunInEDT_pi_raD()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], double[].class );
    return new double[0];
  }

  @RunInEDT
  private String[] RunInEDT_pi_raA()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], String[].class );
    return new String[0];
  }

  // Static methods for RunInEDT

  @RunInEDT
  private static void RunInEDT_ps()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0], Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_Z( final boolean v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_B( final byte v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_C( final char v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_S( final short v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_I( final int v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_J( final long v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_F( final float v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_D( final double v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_A( final String v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_aZ( final boolean[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_aB( final byte[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_aC( final char[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_aS( final short[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_aI( final int[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_aJ( final long[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_aF( final float[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_aD( final double[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_aA( final String[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private static void RunInEDT_ps_ZBCSIJFDAaZaBaCaSaIaJaFaDaA( final boolean v1,
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
  private void RunInEDT_pi()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0], Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_Z( final boolean v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_B( final byte v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_C( final char v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_S( final short v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_I( final int v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_J( final long v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_F( final float v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_D( final double v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_A( final String v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_aZ( final boolean[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_aB( final byte[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_aC( final char[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_aS( final short[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_aI( final int[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_aJ( final long[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_aF( final float[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_aD( final double[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_aA( final String[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunInEDT
  private void RunInEDT_pi_ZBCSIJFDAaZaBaCaSaIaJaFaDaA( final boolean v1,
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
  private static boolean RunOutsideEDT_ps_rZ()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], boolean.class );
    return true;
  }

  @RunOutsideEDT
  private static byte RunOutsideEDT_ps_rB()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], byte.class );
    return (byte) 1;
  }

  @RunOutsideEDT
  private static char RunOutsideEDT_ps_rC()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], char.class );
    return 'a';
  }

  @RunOutsideEDT
  private static short RunOutsideEDT_ps_rS()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], short.class );
    return (short) 1;
  }

  @RunOutsideEDT
  private static int RunOutsideEDT_ps_rI()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], int.class );
    return 1;
  }

  @RunOutsideEDT
  private static long RunOutsideEDT_ps_rJ()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], long.class );
    return 1L;
  }

  @RunOutsideEDT
  private static float RunOutsideEDT_ps_rF()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], float.class );
    return 1.0F;
  }

  @RunOutsideEDT
  private static double RunOutsideEDT_ps_rD()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], double.class );
    return 1.0D;
  }

  @RunOutsideEDT
  private static String RunOutsideEDT_ps_rA()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], String.class );
    return "";
  }

  @RunOutsideEDT
  private static boolean[] RunOutsideEDT_ps_raZ()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], boolean[].class );
    return new boolean[0];
  }

  @RunOutsideEDT
  private static byte[] RunOutsideEDT_ps_raB()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], byte[].class );
    return new byte[0];
  }

  @RunOutsideEDT
  private static char[] RunOutsideEDT_ps_raC()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], char[].class );
    return new char[0];
  }

  @RunOutsideEDT
  private static short[] RunOutsideEDT_ps_raS()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], short[].class );
    return new short[0];
  }

  @RunOutsideEDT
  private static int[] RunOutsideEDT_ps_raI()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], int[].class );
    return new int[0];
  }

  @RunOutsideEDT
  private static long[] RunOutsideEDT_ps_raJ()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], long[].class );
    return new long[0];
  }

  @RunOutsideEDT
  private static float[] RunOutsideEDT_ps_raF()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], float[].class );
    return new float[0];
  }

  @RunOutsideEDT
  private static double[] RunOutsideEDT_ps_raD()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], double[].class );
    return new double[0];
  }

  @RunOutsideEDT
  private static String[] RunOutsideEDT_ps_raA()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], String[].class );
    return new String[0];
  }

  // Instance methods with return values

  @RunOutsideEDT
  private boolean RunOutsideEDT_pi_rZ()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], boolean.class );
    return true;
  }

  @RunOutsideEDT
  private byte RunOutsideEDT_pi_rB()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], byte.class );
    return (byte) 1;
  }

  @RunOutsideEDT
  private char RunOutsideEDT_pi_rC()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], char.class );
    return (char) 1;
  }

  @RunOutsideEDT
  private short RunOutsideEDT_pi_rS()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], short.class );
    return (short) 1;
  }

  @RunOutsideEDT
  private int RunOutsideEDT_pi_rI()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], int.class );
    return 1;
  }

  @RunOutsideEDT
  private long RunOutsideEDT_pi_rJ()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], long.class );
    return 1L;
  }

  @RunOutsideEDT
  private float RunOutsideEDT_pi_rF()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], float.class );
    return 1.0F;
  }

  @RunOutsideEDT
  private double RunOutsideEDT_pi_rD()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], double.class );
    return 1.0D;
  }

  @RunOutsideEDT
  private String RunOutsideEDT_pi_rA()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], String.class );
    return "";
  }

  @RunOutsideEDT
  private boolean[] RunOutsideEDT_pi_raZ()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], boolean[].class );
    return new boolean[0];
  }

  @RunOutsideEDT
  private byte[] RunOutsideEDT_pi_raB()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], byte[].class );
    return new byte[0];
  }

  @RunOutsideEDT
  private char[] RunOutsideEDT_pi_raC()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], char[].class );
    return new char[0];
  }

  @RunOutsideEDT
  private short[] RunOutsideEDT_pi_raS()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], short[].class );
    return new short[0];
  }

  @RunOutsideEDT
  private int[] RunOutsideEDT_pi_raI()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], int[].class );
    return new int[0];
  }

  @RunOutsideEDT
  private long[] RunOutsideEDT_pi_raJ()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], long[].class );
    return new long[0];
  }

  @RunOutsideEDT
  private float[] RunOutsideEDT_pi_raF()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], float[].class );
    return new float[0];
  }

  @RunOutsideEDT
  private double[] RunOutsideEDT_pi_raD()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], double[].class );
    return new double[0];
  }

  @RunOutsideEDT
  private String[] RunOutsideEDT_pi_raA()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], String[].class );
    return new String[0];
  }

  // Static methods for RunOutsideEDT

  @RunOutsideEDT
  private static void RunOutsideEDT_ps()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0], Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_Z( final boolean v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_B( final byte v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_C( final char v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_S( final short v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_I( final int v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_J( final long v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_F( final float v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_D( final double v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_A( final String v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_aZ( final boolean[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_aB( final byte[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_aC( final char[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_aS( final short[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_aI( final int[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_aJ( final long[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_aF( final float[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_aD( final double[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_aA( final String[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_ps_ZBCSIJFDAaZaBaCaSaIaJaFaDaA( final boolean v1,
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
  private void RunOutsideEDT_pi()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0], Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_Z( final boolean v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_B( final byte v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_C( final char v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_S( final short v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_I( final int v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_J( final long v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_F( final float v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_D( final double v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_A( final String v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_aZ( final boolean[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_aB( final byte[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_aC( final char[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_aS( final short[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_aI( final int[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_aJ( final long[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_aF( final float[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_aD( final double[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private void RunOutsideEDT_pi_aA( final String[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v }, Void.TYPE );
  }

  @RunOutsideEDT
  private static void RunOutsideEDT_pi_ZBCSIJFDAaZaBaCaSaIaJaFaDaA( final boolean v1,
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

  public void s(long i, int j)
  {
    s(i, j);
  }
}
