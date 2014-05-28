package org.realityforge.swung_weave.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SwingUtilities;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.realityforge.swung_weave.DisallowsEDT;
import org.realityforge.swung_weave.RequiresEDT;
import org.realityforge.swung_weave.RunInEDT;
import org.realityforge.swung_weave.RunOutsideEDT;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SwClassAdapterTestCase
{
  private static Class<?> c_clazz;

  @BeforeClass
  public static void adaptClass()
    throws Exception
  {
    final String classname = "org.realityforge.swung_weave.tool.ClassToWeave";
    final ClassWriter cw = new ClassWriter( ClassWriter.COMPUTE_MAXS );
    final ClassReader cr = new ClassReader( classname );
    final SwClassAdapter adapter = new SwClassAdapter( cw );
    cr.accept( adapter, 0 );

    final HashMap<String, byte[]> classData = new HashMap<String, byte[]>();
    classData.putAll( adapter.getClassData() );
    classData.put( classname, cw.toByteArray() );

    //noinspection ConstantIfStatement
    if ( true )
    {
      for ( final Map.Entry<String, byte[]> entry : classData.entrySet() )
      {
        final String baseDir = "target/sw/";
        final File file = new File( baseDir + entry.getKey().replace( '.', '/' ) + ".class" );
        //noinspection ResultOfMethodCallIgnored
        file.getParentFile().mkdirs();

        final FileOutputStream fos = new FileOutputStream( file );
        fos.write( entry.getValue() );
        fos.close();
      }
    }

    c_clazz = new ClassLoader()
    {
      public Class loadClass( final String name )
        throws ClassNotFoundException
      {
        final byte[] data = classData.get( name );
        if ( null != data )
        {
          return defineClass( name, data, 0, data.length );
        }
        else if ( TestInvocation.class.getName().equals( name ) )
        {
          return TestInvocation.class;
        }
        else
        {
          return super.loadClass( name );
        }
      }
    }.loadClass( classname );
  }

  @Test( dataProvider = "scenarios" )
  public void verifySwClassAdapterBehaviour( final TestInvocation invocation )
    throws Throwable
  {
    if ( invocation.inEDT )
    {
      try
      {
        SwingUtilities.invokeAndWait( new Runnable()
        {
          @Override
          public void run()
          {
            invokeMethod( invocation );
          }
        } );
      }
      catch ( final InvocationTargetException ite )
      {
        throw ite.getCause();
      }
    }
    else
    {
      invokeMethod( invocation );
    }
  }

  private void invokeMethod( final TestInvocation invocation )
  {
    TestInvocation.setCurrent( invocation );
    final String methodName = invocation.getMethodName();
    boolean completed = false;
    try
    {
      final Method method = c_clazz.getDeclaredMethod( methodName, invocation.getParameterTypes() );
      method.setAccessible( true );
      final Object instance;
      if ( invocation.methodType == TestInvocation.INSTANCE )
      {
        instance = c_clazz.newInstance();
      }
      else
      {
        instance = null;
      }
      method.invoke( instance, invocation.parameters );
      completed = true;
    }
    catch ( final InvocationTargetException e )
    {
      invocation.assertMatchesException( e.getCause() );
    }
    catch ( final Throwable t )
    {
      invocation.assertMatchesException( t );
    }
    if ( completed )
    {
      Assert.assertTrue( invocation.isInvoked(), "invocation.isInvoked()" );
    }
  }

  @DataProvider( name = "scenarios" )
  public Object[][] createTestInvocations()
  {
    final ArrayList<TestInvocation> tests = new ArrayList<TestInvocation>();

    final Object[][] parameterSets = new Object[][]
      {
        new Object[]{ },
        new Object[]{ true },
        new Object[]{ (byte) 1 },
        new Object[]{ 'a' },
        new Object[]{ (short) 2 },
        new Object[]{ 3 },
        new Object[]{ 4L },
        new Object[]{ 5F },
        new Object[]{ 6D },
        new Object[]{ "Hello" },
        new Object[]{ new boolean[]{ true } },
        new Object[]{ new byte[]{ (byte) 1 } },
        new Object[]{ new char[]{ 'a' } },
        new Object[]{ new short[]{ (short) 2 } },
        new Object[]{ new int[]{ 3 } },
        new Object[]{ new long[]{ 4L } },
        new Object[]{ new float[]{ 5F } },
        new Object[]{ new double[]{ 6D } },
        new Object[]{ new String[]{ "Hello" } },
        new Object[]{ true,
                      (byte) 1,
                      'a',
                      (short) 2,
                      3,
                      4L,
                      5F,
                      6D,
                      "Hello",
                      new boolean[]{ true },
                      new byte[]{ (byte) 1 },
                      new char[]{ 'a' },
                      new short[]{ (short) 2 },
                      new int[]{ 3 },
                      new long[]{ 4L },
                      new float[]{ 5F },
                      new double[]{ 6D },
                      new String[]{ "Hello" } },
      };

    for ( final Object[] parameters : parameterSets )
    {
      addTestSet( tests, TestInvocation.STATIC, parameters, Void.TYPE );
      addTestSet( tests, TestInvocation.INSTANCE, parameters, Void.TYPE );
    }

    final Class<?>[] returnTypes =
      {
        boolean.class,
        byte.class,
        char.class,
        short.class,
        int.class,
        long.class,
        float.class,
        double.class,
        String.class,
        boolean[].class,
        byte[].class,
        char[].class,
        short[].class,
        int[].class,
        long[].class,
        float[].class,
        double[].class,
        String[].class,
      };

    for ( final Class<?> returnType : returnTypes )
    {
      addTestSet( tests, TestInvocation.STATIC, new Object[0], returnType );
      addTestSet( tests, TestInvocation.INSTANCE, new Object[0], returnType );
    }

    final Object[][] results = new Object[tests.size()][];
    for ( int i = 0; i < results.length; i++ )
    {
      results[ i ] = new Object[]{ tests.get( i ) };
    }
    return results;
  }

  private void addTestSet( final ArrayList<TestInvocation> tests,
                           final int methodType,
                           final Object[] parameters,
                           final Class<?> returnType )
  {
    failInEDT( tests, DisallowsEDT.class, methodType, false, parameters, returnType );
    succeed( tests, DisallowsEDT.class, methodType, false, false, parameters, false, returnType );
    failOutsideEDT( tests, RequiresEDT.class, methodType, false, parameters, returnType );
    succeed( tests, RequiresEDT.class, methodType, false, true, parameters, true, returnType );
    succeed( tests, RunInEDT.class, methodType, false, true, parameters, true, returnType );
    succeed( tests, RunInEDT.class, methodType, false, false, parameters, true, returnType );
    succeed( tests, RunOutsideEDT.class, methodType, false, true, parameters, false, returnType );
    succeed( tests, RunOutsideEDT.class, methodType, false, false, parameters, false, returnType );

    failInEDT( tests, DisallowsEDT.class, methodType, true, parameters, returnType );
    succeed( tests, DisallowsEDT.class, methodType, true, false, parameters, false, returnType );
    failOutsideEDT( tests, RequiresEDT.class, methodType, true, parameters, returnType );
    succeed( tests, RequiresEDT.class, methodType, true, true, parameters, true, returnType );
    succeed( tests, RunInEDT.class, methodType, true, true, parameters, true, returnType );
    succeed( tests, RunInEDT.class, methodType, true, false, parameters, true, returnType );
    succeed( tests, RunOutsideEDT.class, methodType, true, true, parameters, false, returnType );
    succeed( tests, RunOutsideEDT.class, methodType, true, false, parameters, false, returnType );
  }

  private static void succeed( final ArrayList<TestInvocation> tests,
                               final Class<?> annotation,
                               final int methodType,
                               final boolean isPrivate,
                               final boolean inEDT,
                               final Object[] parameters,
                               final boolean expectedInEDT,
                               final Class<?> returnType )
  {
    ti( tests, annotation, methodType, isPrivate, inEDT, parameters, expectedInEDT, null, null, returnType );
  }

  private static void failInEDT( final ArrayList<TestInvocation> tests,
                                 final Class<?> annotation,
                                 final int methodType,
                                 final boolean isPrivate,
                                 final Object[] parameters,
                                 final Class<?> returnType )
  {

    final String message =
      "Method " + TestInvocation.METHOD_NAME + " must only be invoked in the Event Dispatch Thread.";
    ti( tests, annotation, methodType, isPrivate, true, parameters, true, IllegalStateException.class, message, returnType );
  }

  private static void failOutsideEDT( final ArrayList<TestInvocation> tests,
                                      final Class<?> annotation,
                                      final int methodType,
                                      final boolean isPrivate,
                                      final Object[] parameters,
                                      final Class<?> returnType )
  {

    final String message =
      "Method " + TestInvocation.METHOD_NAME + " must not be invoked in the Event Dispatch Thread.";
    ti( tests, annotation, methodType, isPrivate, false, parameters, false, IllegalStateException.class, message, returnType );
  }

  private static void ti( final ArrayList<TestInvocation> tests,
                          final Class<?> annotation,
                          final int methodType,
                          final boolean isPrivate,
                          final boolean inEDT,
                          final Object[] parameters,
                          final boolean expectedInEDT,
                          final Class<? extends Throwable> expectedExceptionType,
                          final String expectedExceptionMessage,
                          final Class<?> returnType )
  {
    tests.add( new TestInvocation( annotation,
                                   methodType,
                                   isPrivate,
                                   inEDT,
                                   parameters,
                                   returnType,
                                   expectedInEDT,
                                   expectedExceptionType,
                                   expectedExceptionMessage ) );
  }
}
