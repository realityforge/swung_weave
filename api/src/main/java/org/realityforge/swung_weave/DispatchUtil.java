package org.realityforge.swung_weave;

import java.awt.EventQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class DispatchUtil
{
  private static final ExecutorService c_executorService = Executors.newCachedThreadPool();

  public static <V> V invokeInEDT( final Callable<V> function )
    throws Exception
  {
    if ( EventQueue.isDispatchThread() )
    {
      throw new IllegalStateException( "Should not be calling invokeInEDT from EDT" );
    }
    try
    {
      final FutureTask<V> task = new FutureTask<V>( function );
      EventQueue.invokeLater( task );
      return task.get();
    }
    catch ( final ExecutionException e )
    {
      final Throwable cause = e.getCause();
      if ( cause instanceof RuntimeException )
      {
        throw (RuntimeException) cause;
      }
      else if ( cause instanceof Error )
      {
        throw (Error) cause;
      }
      else //if( cause instanceof Exception )
      {
        throw (Exception) cause;
      }
    }
    catch ( final InterruptedException ie )
    {
      throw new RuntimeException( ie );
    }
  }

  public static <V> V invokeOutsideEDT( final Callable<V> function )
    throws Exception
  {
    if ( !EventQueue.isDispatchThread() )
    {
      throw new IllegalStateException( "Should not be calling invokeOutsideEDT from EDT" );
    }
    try
    {
      final Future<V> task = c_executorService.submit( function );
      ConditionalEventPump.pumpEvents( task );
      return task.get();
    }
    catch ( final ExecutionException e )
    {
      final Throwable cause = e.getCause();
      if ( cause instanceof RuntimeException )
      {
        throw (RuntimeException) cause;
      }
      else if ( cause instanceof Error )
      {
        throw (Error) cause;
      }
      else //if( cause instanceof Exception )
      {
        throw (Exception) cause;
      }
    }
    catch ( final InterruptedException ie )
    {
      throw new RuntimeException( ie );
    }
  }
}
