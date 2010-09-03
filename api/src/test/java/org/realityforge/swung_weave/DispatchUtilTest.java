package org.realityforge.swung_weave;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Callable;
import javax.swing.JButton;
import javax.swing.JFrame;

public class DispatchUtilTest
{
  public static void main( String[] args )
  {
    final JFrame frame = new JFrame( "FrameDemo" );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    final JButton button = new JButton( "Foo" );
    button.addActionListener( new ActionListener()
    {
      @Override
      public void actionPerformed( final ActionEvent e )
      {
        try
        {
          DispatchUtil.invokeOutsideEDT( new Callable<Object>()
          {
            @Override
            public Object call()
              throws Exception
            {
              System.out.println( "El starto!" );
              for ( int i = 0; i < 4; i++ )
              {
                System.out.println( ( i % 2 == 0 ) ? "Tick!" : "Tock!" );
                Thread.sleep( 1000 );
              }
              System.out.println( "El finito!" );
              return null;
            }
          } );
          System.out.println( "El finito outo!" );
        }
        catch ( Exception e1 )
        {
          e1.printStackTrace();
        }
      }
    } );
    frame.getContentPane().add( button, BorderLayout.CENTER );
    frame.pack();
    frame.setVisible( true );
  }
}
