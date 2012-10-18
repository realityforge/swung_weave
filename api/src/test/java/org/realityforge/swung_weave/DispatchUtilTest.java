package org.realityforge.swung_weave;

import java.util.concurrent.Callable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DispatchUtilTest
{
  CollectingEDTViolationListener _listener;
  boolean _invoked;

  @BeforeTest
  public void installListener()
  {
    _listener = new CollectingEDTViolationListener();
    DispatchUtil.installEDTViolationListener( _listener, true );
  }

  @AfterTest
  public void uninstallListener()
  {
    DispatchUtil.uninstallEDTViolationListener();
  }

  @Test
  public void verifyUIConstructionInEDTisOK()
    throws Exception
  {
    SwingUtilities.invokeAndWait( new Runnable()
    {
      public void run()
      {
        displayUIComponets( null );
      }
    } );
    assertZeroEDTViolations();
  }

  @Test
  public void verifyRepaintOutsideEDTisOK()
    throws Exception
  {
    final JButton[] buttons = new JButton[1];
    SwingUtilities.invokeAndWait( new Runnable()
    {
      public void run()
      {
        buttons[ 0 ] = new JButton();
        buttons[ 0 ].setSize( 100, 100 );
      }
    } );

    buttons[ 0 ].repaint( buttons[ 0 ].getBounds() );
    buttons[ 0 ].repaint( 0, 0, 100, 100 );
    buttons[ 0 ].repaint();

    assertZeroEDTViolations();
  }

  @Test
  public void verifyUIConstructionOutsideEDTisNotOK()
    throws Exception
  {
    displayUIComponets( null );
    assertEDTViolations();
  }

  @Test
  public void verifyInvokeInEDTFromEDTResultsInException()
    throws Exception
  {
    SwingUtilities.invokeAndWait( new Runnable()
    {
      public void run()
      {
        try
        {
          DispatchUtil.invokeInEDT( invoker() );
          Assert.fail( "Expected to to fail to invoke in EDT from EDT" );
        }
        catch ( final Exception e )
        {
          Assert.assertTrue( e instanceof IllegalStateException );
          Assert.assertEquals( e.getMessage(), "Should not be calling invokeInEDT from EDT" );
        }
      }
    } );
    assertZeroEDTViolations();
    assertNotInvoked();
  }

  @Test
  public void verifyInvokeOutsideEDTFromEDTIsOK()
    throws Exception
  {
    SwingUtilities.invokeAndWait( new Runnable()
    {
      public void run()
      {
        displayUIComponets( new Runnable()
        {
          @Override
          public void run()
          {
            try
            {
              DispatchUtil.invokeOutsideEDT( invoker() );
            }
            catch ( final Exception e )
            {
              e.printStackTrace();
            }
          }
        } );
      }
    } );
    assertZeroEDTViolations();
    assertInvoked();
  }

  @Test
  public void verifyInvokeInEDTFromOutsideEDTIsOK()
    throws Exception
  {
    DispatchUtil.invokeInEDT( invoker() );
    assertZeroEDTViolations();
    assertInvoked();
  }

  @Test
  public void verifyInvokeOutsideEDTFromOutsideEDTIsOK()
    throws Exception
  {
    try
    {
      DispatchUtil.invokeOutsideEDT( invoker() );
      Assert.fail( "Expected to to fail to invoke outside EDT from outside EDT" );
    }
    catch ( final Exception e )
    {
      Assert.assertTrue( e instanceof IllegalStateException );
      Assert.assertEquals( e.getMessage(), "Should not be calling invokeOutsideEDT when not in EDT" );
    }

    assertZeroEDTViolations();
    assertNotInvoked();
  }

  private Callable<Object> invoker()
  {
    _invoked = false;
    return new Callable<Object>()
    {
      @Override
      public Object call()
        throws Exception
      {
        _invoked = true;
        return null;
      }
    };
  }

  private void displayUIComponets( final Runnable runnable )
  {
    final JFrame frame = new JFrame( "Am I on EDT?" );
    frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    frame.add( new JButton( "JButton" ) );
    frame.pack();
    frame.setVisible( true );
    if ( null != runnable )
    {
      runnable.run();
    }
    frame.dispose();
  }

  private void assertInvoked()
  {
    Assert.assertTrue( _invoked, "invoked" );
  }

  private void assertNotInvoked()
  {
    Assert.assertFalse( _invoked, "invoked" );
  }

  private void assertZeroEDTViolations()
  {
    Assert.assertEquals( 0, _listener._violations.size(), "violations=" + _listener._violations );
  }

  private void assertEDTViolations()
  {
    Assert.assertTrue( _listener._violations.size() > 0, "violations=" + _listener._violations );
  }
}
