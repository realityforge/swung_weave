package org.realityforge.swung_weave.tool;

import javax.swing.SwingUtilities;
import org.realityforge.swung_weave.DisallowsEDT;
import org.realityforge.swung_weave.RequiresEDT;
import org.realityforge.swung_weave.RunInEDT;
import org.realityforge.swung_weave.RunOutsideEDT;

public class Dummy
{
  @RequiresEDT
  public static void methodRequiresEDT()
  {
    System.out.println( "methodRequiresEDT() EDT=" + SwingUtilities.isEventDispatchThread() );
  }

  @DisallowsEDT
  public static void methodDisallowsEDT()
  {
    System.out.println( "methodDisallowsEDT() EDT=" + SwingUtilities.isEventDispatchThread() );
  }

  @RunInEDT
  public static void methodRunInEDT()
  {
    System.out.println( "methodRunInEDT() EDT=" + SwingUtilities.isEventDispatchThread() );
  }

  @RunOutsideEDT
  public static void methodRunOutsideEDT()
  {
    System.out.println( "methodRunOutsideEDT() EDT=" + SwingUtilities.isEventDispatchThread() );
  }

  @RequiresEDT
  public void instanceMethodRequiresEDT()
  {
    System.out.println( "methodRequiresEDT() EDT=" + SwingUtilities.isEventDispatchThread() );
  }

  @DisallowsEDT
  public void instanceMethodDisallowsEDT()
  {
    System.out.println( "methodDisallowsEDT() EDT=" + SwingUtilities.isEventDispatchThread() );
  }

  @RunInEDT
  public void instanceMethodRunInEDT()
  {
    System.out.println( "methodRunInEDT() EDT=" + SwingUtilities.isEventDispatchThread() );
  }

  @RunOutsideEDT
  public void instanceMethodRunOutsideEDT()
  {
    System.out.println( "methodRunOutsideEDT() EDT=" + SwingUtilities.isEventDispatchThread() );
  }
}
