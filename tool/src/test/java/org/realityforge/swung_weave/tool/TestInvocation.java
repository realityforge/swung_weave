package org.realityforge.swung_weave.tool;

import org.testng.Assert;

/**
 * Note: Many fields are public as they are accessed from within a different class loader
 * and if they are not public they will generate IllegalAccessError exceptions. 
 */
public final class TestInvocation
{
  static final String METHOD_NAME = "@@METHOD_NAME@@";
  static final int STATIC = 1;
  static final int INSTANCE = 2;
  static final int CONSTRUCTOR = 3;

  public final Class<?> annotation;
  public final int methodType;
  public final boolean inEDT;
  public final Object[] parameters;
  public final boolean expectedInEDT;
  final Class<? extends Throwable> expectedExceptionType;
  final String expectedExceptionMessage;
  boolean invoked;

  private static TestInvocation c_current;

  public static TestInvocation current()
  {
    if( null == c_current ) throw new IllegalStateException( "No current TestInvocation specified" );
    return c_current;
  }

  static void setCurrent( final TestInvocation current )
  {
    c_current = current;
  }

  TestInvocation( final Class<?> annotation,
                  final int methodType,
                  final boolean inEDT,
                  final Object[] parameters,
                  final boolean expectedInEDT,
                  final Class<? extends Throwable> expectedExceptionType,
                  final String expectedExceptionMessage )
  {
    this.annotation = annotation;
    this.methodType = methodType;
    this.inEDT = inEDT;
    this.parameters = parameters;
    this.expectedInEDT = expectedInEDT;
    this.expectedExceptionType = expectedExceptionType;
    this.expectedExceptionMessage = expectedExceptionMessage;
  }

  String getMethodName()
  {
    final String shortAnnotationName =
      annotation.getName().substring( "org.realityforge.swung_weave.".length() );
    final String methodTypeSuffix =
      methodType == STATIC ? "s" : methodType == INSTANCE ? "i" : "c";
    final StringBuilder sb = new StringBuilder();
    for( final Object parameter : parameters )
    {
      if( sb.length() == 0 ) sb.append( '_' );
      sb.append( encodingForType( parameter.getClass() ) );
    }
    return shortAnnotationName + "_" + methodTypeSuffix + sb;
  }

  Class<?>[] getParameterTypes()
  {
    final Class[] types = new Class[parameters.length];
    for( int i = 0; i < parameters.length; i++ )
    {
      types[i] = typeOfParameter(parameters[i].getClass());
    }
    return types;
  }

  private Class<?> typeOfParameter( final Class<?> type )
  {
    if( Boolean.class == type )
    {
      return Boolean.TYPE;
    }
    else if( Byte.class == type )
    {
      return Byte.TYPE;
    }
    else if( Character.class == type )
    {
      return Character.TYPE;
    }
    else if( Short.class == type )
    {
      return Short.TYPE;
    }
    else if( Integer.class == type )
    {
      return Integer.TYPE;
    }
    else if( Long.class == type )
    {
      return Long.TYPE;
    }
    else if( Float.class == type )
    {
      return Float.TYPE;
    }
    else if( Double.class == type )
    {
      return Double.TYPE;
    }
    else
    {
      return type;
    }
  }

  private String encodingForType( final Class<?> type )
  {
    if( Boolean.class == type || Boolean.TYPE == type )
    {
      return "Z";
    }
    else if( Byte.class == type || Byte.TYPE == type )
    {
      return "B";
    }
    else if( Character.class == type || Character.TYPE == type )
    {
      return "C";
    }
    else if( Short.class == type || Short.TYPE == type )
    {
      return "S";
    }
    else if( Integer.class == type || Integer.TYPE == type )
    {
      return "I";
    }
    else if( Long.class == type || Long.TYPE == type )
    {
      return "J";
    }
    else if( Float.class == type || Float.TYPE == type )
    {
      return "F";
    }
    else if( Double.class == type || Double.TYPE == type )
    {
      return "D";
    }
    else if( type.isArray() )
    {
      return "a" + encodingForType( type.getComponentType() );
    }
    else
    {
      return "A";
    }
  }

  public boolean isInvoked()
  {
    return invoked;
  }

  public void invoked()
  {
    this.invoked = true;
  }

  void assertMatchesException( final Throwable t )
  {
    if( null == t && null == expectedExceptionType )
    {
      return;
    }
    else if( null == t )
    {
      Assert.assertEquals( null,
                           expectedExceptionType,
                           "Expected exception type " + expectedExceptionType + ". Actual exception: " + t );
    }
    else if( null == expectedExceptionType )
    {
      t.printStackTrace();
      Assert.assertEquals( expectedExceptionType,
                           t.getClass(),
                           "Expected exception type " + expectedExceptionType + ". Actual exception: " + t );
      final String message =
        ( null == expectedExceptionMessage ) ?
        "" :
        expectedExceptionMessage.replaceAll( METHOD_NAME, getMethodName() );
      Assert.assertEquals( t.getMessage(), message, "Expected exception message " + t );
    }
  }

  @Override
  public String toString()
  {
    return "TestInvocation[Method=" + getMethodName() + ",inEDT=" + inEDT + "]";
  }
}
