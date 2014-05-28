package org.realityforge.swung_weave;

import java.lang.ref.WeakReference;
import javax.swing.JComponent;
import javax.swing.RepaintManager;
import javax.swing.SwingUtilities;

/**
 * A repaint manager that checks if a repaint occurs outside the EDT.
 *
 * <p>This is heavily influenced by <a href="http://www.clientjava.com/blog/2004/08/20/1093059428000.html">ThreadCheckingRepaintManager</a>
 * by Scott Delap and <a href="https://swinghelper.dev.java.net/">swinghelper</a> by Alexander Potochkin.
 */
final class EDTCheckingRepaintManager
  extends RepaintManager
{
  private final EDTViolationListener _violationListener;
  private final boolean _fullCheck;

  private WeakReference<JComponent> _lastComponent;

  EDTCheckingRepaintManager( final EDTViolationListener violationListener,
                                      final boolean fullCheck )
  {
    _violationListener = violationListener;
    _fullCheck = fullCheck;
  }

  public synchronized void addInvalidComponent( final JComponent component )
  {
    checkThreadViolations( component );
    super.addInvalidComponent( component );
  }

  @Override
  public void addDirtyRegion( final JComponent component,
                              final int x,
                              final int y,
                              final int w,
                              final int h )
  {
    checkThreadViolations( component );
    super.addDirtyRegion( component, x, y, w, h );
  }

  private void checkThreadViolations( final JComponent component )
  {
    if ( !SwingUtilities.isEventDispatchThread() && ( _fullCheck || component.isShowing() ) )
    {
      boolean repaint = false;
      boolean fromSwing = false;
      boolean imageUpdate = false;
      StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
      for ( StackTraceElement st : stackTrace )
      {
        // for details see https://swinghelper.dev.java.net/issues/show_bug.cgi?id=1
        if ( repaint &&
             st.getClassName().startsWith( "javax.swing." ) &&
             !st.getClassName().startsWith( "javax.swing.SwingWorker" ) )
        {
          fromSwing = true;
        }
        if ( repaint && "imageUpdate".equals( st.getMethodName() ) )
        {
          imageUpdate = true;
        }
        if ( "repaint".equals( st.getMethodName() ) )
        {
          repaint = true;
          fromSwing = false;
        }
      }
      if ( imageUpdate )
      {
        //assuming it is java.awt.image.ImageObserver.imageUpdate(...)
        //image was asynchronously updated, that's ok
        return;
      }
      if ( repaint && !fromSwing )
      {
        //no problems here, since repaint() is thread safe
        return;
      }
      //ignore the last processed component
      if ( _lastComponent != null && component == _lastComponent.get() )
      {
        return;
      }
      _lastComponent = new WeakReference<JComponent>( component );
      _violationListener.violationOccurred( new EDTViolation( component, stackTrace ) );
    }
  }
}
