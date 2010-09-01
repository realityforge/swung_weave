package org.realityforge.swung_weave.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
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
    final SwClassAdapter adapter = new SwClassAdapter( cw );
    cr.accept( adapter, 0 );

    final HashMap<String, byte[]> classData = new HashMap<String, byte[]>();
    classData.putAll( adapter.getClassData() );
    classData.put( n, cw.toByteArray() );

    for( final Map.Entry<String, byte[]> entry : classData.entrySet() )
    {
      final String baseDir = "/home/peter/Code/swung-weave/target/sw/";
      final File file = new File( baseDir + entry.getKey().replace('.','/' )+ ".class");
      file.getParentFile().mkdirs();

      final FileOutputStream fos = new FileOutputStream( file );
      fos.write( entry.getValue() );
      fos.close();
    }

    final Class c = new ClassLoader()
    {
      public Class loadClass( final String name )
        throws ClassNotFoundException
      {
        final byte[] data = classData.get( name );
        if( null != data )
        {
          return defineClass( name, data, 0, data.length );
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
