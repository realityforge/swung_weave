package org.realityforge.swung_weave.tool;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.swing.SwingUtilities;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.realityforge.swung_weave.DisallowsEDT;
import org.realityforge.swung_weave.RequiresEDT;
import org.realityforge.swung_weave.RunInEDT;
import org.realityforge.swung_weave.RunOutsideEDT;

public class Main
{
  @RequiresEDT
  public static void methodRequiresEDT()
  {
    System.out.println( "methodRequiresEDT()" );
  }

  @DisallowsEDT
  public static void methodDisallowsEDT()
  {
    System.out.println( "methodDisallowsEDT()" );
  }

  @RunInEDT
  public static void methodRunInEDT()
  {
    System.out.println( "methodRunInEDT()" );
  }

  @RunOutsideEDT
  public static void methodRunOutsideEDT()
  {
    System.out.println( "methodRunOutsideEDT()" );
  }

  public static void main( final String[] args ) throws Exception
  {
    runMethods( "Pre transform outside EDT", Main.class );

    final String n = Main.class.getName();
    final ClassWriter cw = new ClassWriter( ClassWriter.COMPUTE_MAXS );
    final ClassReader cr = new ClassReader( n );
    cr.accept( new SwClassAdapter( cw ), 0 );

    final Class c = new ClassLoader()
    {
      public Class loadClass( final String name )
        throws ClassNotFoundException
      {
        if( name.equals( n ) )
        {
          byte[] b = cw.toByteArray();
          return defineClass( name, b, 0, b.length );
        }
        return super.loadClass( name );
      }
    }.loadClass( n );

    runMethods( "Post transform outside EDT", c );

    SwingUtilities.invokeAndWait( new Runnable()
    {
      @Override
      public void run()
      {
        runMethods( "Post transform in EDT", c );
      }
    } );
  }

  private static void runMethods( final String context, final Class<?> clazz )
  {
    System.out.println();
    System.out.println();
    System.out.println( "----------------------" );
    System.out.println( context );
    System.out.println( "----------------------" );
    doMethod( clazz, "methodRequiresEDT" );
    doMethod( clazz, "methodDisallowsEDT" );
    doMethod( clazz, "methodRunInEDT" );
    doMethod( clazz, "methodRunOutsideEDT" );
  }

  public static void doMethod( final Class<?> clazz, final String methodName )
  {
    System.out.println( methodName + "() ..." );
    try
    {
      final Method m2 = clazz.getMethod( methodName, new Class[0] );
      m2.invoke( null );
    }
    catch( InvocationTargetException e )
    {
      e.getCause().printStackTrace( System.out );
    }
    catch( final Throwable t )
    {
      t.printStackTrace( System.out );
    }
    System.out.println( "... " + methodName + "()" );
  }
}
