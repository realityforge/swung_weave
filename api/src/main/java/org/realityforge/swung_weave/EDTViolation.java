package org.realityforge.swung_weave;

import javax.swing.JComponent;

/**
 * Representation of EDT violation.  
 */
public final class EDTViolation
{
  private final JComponent _component;
  private final StackTraceElement[] _stackTrace;

  EDTViolation( final JComponent component, final StackTraceElement[] stackTrace )
  {
    _component = component;
    _stackTrace = stackTrace;
  }

  public JComponent getComponent()
  {
    return _component;
  }

  public StackTraceElement[] getStackTrace()
  {
    return _stackTrace;
  }

  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder( );
    sb.append( "EDT violation detected Component=" );
    sb.append( _component.getName() );
    sb.append( " / " );
    sb.append( _component );
    sb.append( "\n" );
    for( final StackTraceElement element : _stackTrace )
    {
      sb.append( "\tat " );
      sb.append( element );
      sb.append( "\n" );
    }
    return sb.toString();
  }
}
