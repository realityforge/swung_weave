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
  // Static methods for RequiresEDT

  @RequiresEDT
  public static void RequiresEDT_s()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0] );
  }

  @RequiresEDT
  public static void RequiresEDT_s_Z( final boolean v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RequiresEDT
  public static void RequiresEDT_s_B( final byte v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RequiresEDT
  public static void RequiresEDT_s_C( final char v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RequiresEDT
  public static void RequiresEDT_s_S( final short v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RequiresEDT
  public static void RequiresEDT_s_I( final int v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RequiresEDT
  public static void RequiresEDT_s_J( final long v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RequiresEDT
  public static void RequiresEDT_s_F( final float v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RequiresEDT
  public static void RequiresEDT_s_D( final double v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RequiresEDT
  public static void RequiresEDT_s_A( final String v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aZ( final boolean[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aB( final byte[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aC( final char[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aS( final short[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aI( final int[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aJ( final long[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aF( final float[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aD( final double[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RequiresEDT
  public static void RequiresEDT_s_aA( final String[] v )
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[]{ v } );
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
            new Object[]{ v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18 } );
  }

  // Instance methods for RequiresEDT

  @RequiresEDT
  public void RequiresEDT_i()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0] );
  }

  @RequiresEDT
  public void RequiresEDT_i_Z( final boolean v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RequiresEDT
  public void RequiresEDT_i_B( final byte v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RequiresEDT
  public void RequiresEDT_i_C( final char v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RequiresEDT
  public void RequiresEDT_i_S( final short v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RequiresEDT
  public void RequiresEDT_i_I( final int v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RequiresEDT
  public void RequiresEDT_i_J( final long v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RequiresEDT
  public void RequiresEDT_i_F( final float v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RequiresEDT
  public void RequiresEDT_i_D( final double v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RequiresEDT
  public void RequiresEDT_i_A( final String v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RequiresEDT
  public void RequiresEDT_i_aZ( final boolean[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RequiresEDT
  public void RequiresEDT_i_aB( final byte[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RequiresEDT
  public void RequiresEDT_i_aC( final char[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RequiresEDT
  public void RequiresEDT_i_aS( final short[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RequiresEDT
  public void RequiresEDT_i_aI( final int[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RequiresEDT
  public void RequiresEDT_i_aJ( final long[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RequiresEDT
  public void RequiresEDT_i_aF( final float[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RequiresEDT
  public void RequiresEDT_i_aD( final double[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RequiresEDT
  public void RequiresEDT_i_aA( final String[] v )
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
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
            new Object[]{ v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18 } );
  }

  // Static methods for DisallowsEDT

  @DisallowsEDT
  public static void DisallowsEDT_s()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0] );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_Z( final boolean v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_B( final byte v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_C( final char v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_S( final short v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_I( final int v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_J( final long v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_F( final float v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_D( final double v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_A( final String v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aZ( final boolean[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aB( final byte[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aC( final char[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aS( final short[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aI( final int[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aJ( final long[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aF( final float[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aD( final double[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s_aA( final String[] v )
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[]{ v } );
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
            new Object[]{ v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18 } );
  }

  // Instance methods for DisallowsEDT

  @DisallowsEDT
  public void DisallowsEDT_i()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0] );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_Z( final boolean v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_B( final byte v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_C( final char v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_S( final short v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_I( final int v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_J( final long v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_F( final float v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_D( final double v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_A( final String v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aZ( final boolean[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aB( final byte[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aC( final char[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aS( final short[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aI( final int[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aJ( final long[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aF( final float[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aD( final double[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @DisallowsEDT
  public void DisallowsEDT_i_aA( final String[] v )
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
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
            new Object[]{ v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18 } );
  }

  // Static methods for RunInEDT

  @RunInEDT
  public static void RunInEDT_s()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0] );
  }

  @RunInEDT
  public static void RunInEDT_s_Z( final boolean v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunInEDT
  public static void RunInEDT_s_B( final byte v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunInEDT
  public static void RunInEDT_s_C( final char v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunInEDT
  public static void RunInEDT_s_S( final short v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunInEDT
  public static void RunInEDT_s_I( final int v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunInEDT
  public static void RunInEDT_s_J( final long v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunInEDT
  public static void RunInEDT_s_F( final float v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunInEDT
  public static void RunInEDT_s_D( final double v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunInEDT
  public static void RunInEDT_s_A( final String v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunInEDT
  public static void RunInEDT_s_aZ( final boolean[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunInEDT
  public static void RunInEDT_s_aB( final byte[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunInEDT
  public static void RunInEDT_s_aC( final char[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunInEDT
  public static void RunInEDT_s_aS( final short[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunInEDT
  public static void RunInEDT_s_aI( final int[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunInEDT
  public static void RunInEDT_s_aJ( final long[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunInEDT
  public static void RunInEDT_s_aF( final float[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunInEDT
  public static void RunInEDT_s_aD( final double[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunInEDT
  public static void RunInEDT_s_aA( final String[] v )
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[]{ v } );
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
            new Object[]{ v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18 } );
  }

  // Instance methods for RunInEDT

  @RunInEDT
  public void RunInEDT_i()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0] );
  }

  @RunInEDT
  public void RunInEDT_i_Z( final boolean v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunInEDT
  public void RunInEDT_i_B( final byte v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunInEDT
  public void RunInEDT_i_C( final char v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunInEDT
  public void RunInEDT_i_S( final short v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunInEDT
  public void RunInEDT_i_I( final int v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunInEDT
  public void RunInEDT_i_J( final long v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunInEDT
  public void RunInEDT_i_F( final float v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunInEDT
  public void RunInEDT_i_D( final double v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunInEDT
  public void RunInEDT_i_A( final String v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunInEDT
  public void RunInEDT_i_aZ( final boolean[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunInEDT
  public void RunInEDT_i_aB( final byte[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunInEDT
  public void RunInEDT_i_aC( final char[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunInEDT
  public void RunInEDT_i_aS( final short[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunInEDT
  public void RunInEDT_i_aI( final int[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunInEDT
  public void RunInEDT_i_aJ( final long[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunInEDT
  public void RunInEDT_i_aF( final float[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunInEDT
  public void RunInEDT_i_aD( final double[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunInEDT
  public void RunInEDT_i_aA( final String[] v )
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
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
            new Object[]{ v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18 } );
  }

  // Static methods for RunOutsideEDT

  @RunOutsideEDT
  public static void RunOutsideEDT_s()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0] );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_Z( final boolean v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_B( final byte v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_C( final char v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_S( final short v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_I( final int v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_J( final long v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_F( final float v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_D( final double v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_A( final String v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aZ( final boolean[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aB( final byte[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aC( final char[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aS( final short[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aI( final int[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aJ( final long[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aF( final float[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aD( final double[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s_aA( final String[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[]{ v } );
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
            new Object[]{ v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18 } );
  }

  // Instance methods for RunOutsideEDT

  @RunOutsideEDT
  public void RunOutsideEDT_i()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0] );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_Z( final boolean v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_B( final byte v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_C( final char v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_S( final short v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_I( final int v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_J( final long v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_F( final float v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_D( final double v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_A( final String v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aZ( final boolean[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aB( final byte[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aC( final char[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aS( final short[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aI( final int[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aJ( final long[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aF( final float[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aD( final double[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i_aA( final String[] v )
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[]{ v } );
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
            new Object[]{ v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18 } );
  }

  private static void record( final Class<?> annotation,
                              final int methodType,
                              final Object[] parameters )
  {
    final TestInvocation entry = TestInvocation.current();
    if( entry.annotation != annotation )
    {
      throw new IllegalStateException( "Current TestInvocation does not match expected annotation" );
    }
    if( entry.methodType != methodType )
    {
      throw new IllegalStateException( "Current TestInvocation does not match expected methodType" );
    }
    if( entry.expectedInEDT != SwingUtilities.isEventDispatchThread() )
    {
      throw new IllegalStateException( "Current TestInvocation does not match expected inEDT" );
    }
    try
    {
      Assert.assertEquals( entry.parameters, parameters );
    }
    catch( Exception e )
    {
      throw new IllegalStateException( "Current TestInvocation does not match expected parameters", e );
    }
    entry.invoked();
  }
}
