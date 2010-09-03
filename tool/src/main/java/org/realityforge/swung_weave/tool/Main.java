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

public class Main
{
  public static void main( final String[] args ) throws Exception
  {
    new Main().main();
  }

  public void main() throws Exception
  {
    final Class<?> clazz = Dummy.class;
    runMethods( "Pre transform outside EDT", clazz );

    final String classname = clazz.getName();
    final ClassWriter cw = new ClassWriter( ClassWriter.COMPUTE_MAXS );
    final ClassReader cr = new ClassReader( classname );
    final SwClassAdapter adapter = new SwClassAdapter( cw );
    cr.accept( adapter, 0 );

    final HashMap<String, byte[]> classData = new HashMap<String, byte[]>();
    classData.putAll( adapter.getClassData() );
    classData.put( classname, cw.toByteArray() );

    for( final Map.Entry<String, byte[]> entry : classData.entrySet() )
    {
      final String baseDir = "/dev/external/swung_weave/target/sw/";
      final File file = new File( baseDir + entry.getKey().replace( '.', '/' ) + ".class" );
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
    }.loadClass( classname );

    runMethods( "Post transform outside EDT", c );

    SwingUtilities.invokeAndWait( new Runnable()
    {
      @Override
      public void run()
      {
        runMethods( "Post transform in EDT", c  );
      }
    } );
  }

  private void runMethods( final String context, final Class<?> clazz )
  {
    final Object instance = createInstance( clazz );

    System.out.println();
    System.out.println();
    System.out.println( "----------------------" );
    System.out.println( context );
    System.out.println( "----------------------" );
    doStaticMethod( clazz, "methodRequiresEDT" );
    doStaticMethod( clazz, "methodDisallowsEDT" );
    doStaticMethod( clazz, "methodRunInEDT" );
    doStaticMethod( clazz, "methodRunOutsideEDT" );
    doInstanceMethod( clazz, instance, "instanceMethodRequiresEDT" );
    doInstanceMethod( clazz, instance, "instanceMethodDisallowsEDT" );
    doInstanceMethod( clazz, instance, "instanceMethodRunInEDT" );
    doInstanceMethod( clazz, instance, "instanceMethodRunOutsideEDT" );
  }

  private Object createInstance( final Class<?> clazz )
  {
    try
    {
      return clazz.newInstance();
    }
    catch ( InstantiationException e )
    {
      throw new IllegalStateException( e );
    }
    catch ( IllegalAccessException e )
    {
      throw new IllegalStateException( e );
    }
  }

  public void doInstanceMethod( final Class<?> clazz,
                                final Object object,
                                final String methodName )
  {
    System.out.println( methodName + "() ..." );
    try
    {
      final Method m2 = clazz.getMethod( methodName, new Class[0] );
      m2.invoke( object );
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

  public void doStaticMethod( final Class<?> clazz, final String methodName )
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
