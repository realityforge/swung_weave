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
  public static void RequiresEDT_s()
  {
    record( RequiresEDT.class, TestInvocation.STATIC, new Object[0] );
  }

  @DisallowsEDT
  public static void DisallowsEDT_s()
  {
    record( DisallowsEDT.class, TestInvocation.STATIC, new Object[0] );
  }

  @RunInEDT
  public static void RunInEDT_s()
  {
    record( RunInEDT.class, TestInvocation.STATIC, new Object[0] );
  }

  @RunOutsideEDT
  public static void RunOutsideEDT_s()
  {
    record( RunOutsideEDT.class, TestInvocation.STATIC, new Object[0] );
  }

  @RequiresEDT
  public void RequiresEDT_i()
  {
    record( RequiresEDT.class, TestInvocation.INSTANCE, new Object[0] );
  }

  @DisallowsEDT
  public void DisallowsEDT_i()
  {
    record( DisallowsEDT.class, TestInvocation.INSTANCE, new Object[0] );
  }

  @RunInEDT
  public void RunInEDT_i()
  {
    record( RunInEDT.class, TestInvocation.INSTANCE, new Object[0] );
  }

  @RunOutsideEDT
  public void RunOutsideEDT_i()
  {
    record( RunOutsideEDT.class, TestInvocation.INSTANCE, new Object[0] );
  }

  private static void record( final Class<?> annotation,
                              final int methodType,
                              final Object[] parameters )
  {
    System.out.println( "ClassToWeave.record..." );
    final TestInvocation entry = TestInvocation.current();
    if( entry.annotation != annotation )
    {
      System.out.println( "Current TestInvocation does not match expected annotation" );
      throw new IllegalStateException( "Current TestInvocation does not match expected annotation" );
    }
    if( entry.methodType != methodType )
    {
      System.out.println( "Current TestInvocation does not match expected methodType" );
      throw new IllegalStateException( "Current TestInvocation does not match expected methodType" );
    }
    if( entry.inEDT != SwingUtilities.isEventDispatchThread() )
    {
      System.out.println( "Current TestInvocation does not match expected inEDT" );
      throw new IllegalStateException( "Current TestInvocation does not match expected inEDT" );
    }
    try
    {
      Assert.assertEquals( entry.parameters, parameters );
    }
    catch( Exception e )
    {
      System.out.println( "Current TestInvocation does not match expected parameters" );
      throw new IllegalStateException( "Current TestInvocation does not match expected parameters", e );
    }
    entry.invoked();
    System.out.println( "...ClassToWeave.record" );
  }
}
