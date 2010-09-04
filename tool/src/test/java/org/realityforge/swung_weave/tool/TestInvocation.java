package org.realityforge.swung_weave.tool;

import org.testng.Assert;

/**
 * Note: Many fields are public as they are accessed from within a different classloader
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
    return shortAnnotationName + "_" + methodTypeSuffix;
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
      Assert.assertEquals( null, expectedExceptionType, "Expected exception type " + expectedExceptionType + ". Actual exception: " + t );
    }
    else if( null == expectedExceptionType )
    {
      Assert.assertEquals( expectedExceptionType, t.getClass(), "Expected exception type " + expectedExceptionType + ". Actual exception: " + t );
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
