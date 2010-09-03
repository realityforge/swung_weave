/**
 * Copyright (c) 2002-2008, Simone Bordet
 * All rights reserved.
 *
 * This software is distributable under the BSD license.
 * See the terms of the BSD license in the documentation provided with this software.
 */

package org.realityforge.swung_weave;

import java.awt.AWTEvent;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.Future;

/**
 * This implementation of EventPump calls the package protected method
 * <tt>java.awt.EventDispatchThread.pumpEvents(Conditional)</tt>
 * to pump events while a Task is executed.
 */
final class ConditionalEventPump
{
  private static final Class CONDITIONAL_CLASS;
  private static final Method PUMP_EVENTS_METHOD;

  static
  {
    final Class<?>[] conditionalClazz = new Class<?>[1];
    final Method[] pumpEventsMethod = new Method[1];
    try
    {
      AccessController.doPrivileged( new PrivilegedExceptionAction<Object>()
      {
        public Object run()
          throws ClassNotFoundException, NoSuchMethodException
        {
          final ClassLoader loader = ClassLoader.getSystemClassLoader();
          conditionalClazz[ 0 ] = loader.loadClass( "java.awt.Conditional" );
          final Class<?> dispatchThreadClass = loader.loadClass( "java.awt.EventDispatchThread" );
          pumpEventsMethod[ 0 ] = dispatchThreadClass.getDeclaredMethod( "pumpEvents", conditionalClazz[ 0 ] );
          pumpEventsMethod[ 0 ].setAccessible( true );
          return null;
        }
      } );
    }
    catch ( final Throwable e )
    {
      throw new Error( e.toString() );
    }
    CONDITIONAL_CLASS = conditionalClazz[ 0 ];
    PUMP_EVENTS_METHOD = pumpEventsMethod[ 0 ];
  }

  static void pumpEvents( final Future<?> task )
  {
    try
    {
      // Invoke java.awt.EventDispatchThread.pumpEvents(new Conditional(task));
      final Object conditional =
        Proxy.newProxyInstance( CONDITIONAL_CLASS.getClassLoader(), new Class<?>[]{ CONDITIONAL_CLASS },
                                new Conditional( task ) );
      PUMP_EVENTS_METHOD.invoke( Thread.currentThread(), conditional );
    }
    catch ( final Exception e )
    {
      // No exceptions should escape from java.awt.EventDispatchThread.pumpEvents(Conditional)
      // since we installed a throwable handler. But one provided by the user may fail.
      final Throwable t = e.getCause();
      if ( t instanceof RuntimeException )
      {
        throw (RuntimeException) t;
      }
      else
      {
        throw (Error) t;
      }
    }
  }

  private static EventQueue getEventQueue()
  {
    return AccessController.doPrivileged( new PrivilegedAction<EventQueue>()
    {
      public EventQueue run()
      {
        return Toolkit.getDefaultToolkit().getSystemEventQueue();
      }
    } );
  }

  /**
   * Waits until an event is available on the EventQueue.
   * This method uses the same synchronization mechanisms used by EventQueue to be notified when
   * an event is posted on the EventQueue.
   * Waiting for events is necessary in this case: a Task is posted and we would like to start
   * pumping, but no events have been posted yet.
   */
  private static AWTEvent waitForEvent( final Future<?> task )
  {
    final EventQueue queue = getEventQueue();
    AWTEvent nextEvent = null;
    synchronized ( queue )
    {
      while ( !task.isDone() && !task.isCancelled() && null == ( nextEvent = queue.peekEvent() ) )
      {
        try
        {
          queue.wait( 100 );
        }
        catch ( final InterruptedException ie )
        {
          Thread.currentThread().interrupt();
          return null;
        }
      }
    }
    return nextEvent;
  }

  /**
   * Implements the <tt>java.awt.Conditional</tt> interface,
   * that is package private, with a JDK 1.3+ dynamic proxy.
   */
  private static class Conditional
    implements InvocationHandler
  {
    private final Future<?> m_task;

    /**
     * Creates a new invocation handler for the given task.
     */
    private Conditional( final Future<?> task )
    {
      m_task = task;
    }

    /**
     * Implements method <tt>java.awt.Conditional.evaluate()</tt>
     */
    public Object invoke( final Object proxy, final Method method, final Object[] args )
      throws Throwable
    {
      if( method.getDeclaringClass() != Object.class )
      {
        return null != waitForEvent( m_task );
      }
      else
      {
        return method.invoke( this, args );
      }
    }
  }
}
