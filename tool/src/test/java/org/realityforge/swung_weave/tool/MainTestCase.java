package org.realityforge.swung_weave.tool;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.regex.Pattern;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTestCase
{
  @Test
  public void verifyProcessFileWithAnnotations()
    throws Throwable
  {
    final File srcFile = copyClassToSourceDir( "ClassToWeave.class" );
    final File targetDir = targetDir();

    final CollectingHandler handler = initLogger();
    Main.main( new String[]{ "--debug", "-d", targetDir.getAbsolutePath(), srcFile.getAbsolutePath() } );

    final File targetFile =
      new File( targetDir, "org/realityforge/swung_weave/tool/ClassToWeave.class" );

    handler.assertMatches( Pattern.quote( "Evaluating: " + srcFile.getAbsolutePath() ) );
    handler.assertMatches( Pattern.quote( "Created dir: " +
                                          targetFile.getParentFile().getAbsolutePath() ) );
    handler.assertMatches( Pattern.quote( "Transformed: " + srcFile.getAbsolutePath() ) );
    handler.assertMatches( "Transformed: 1 Skipped: 0" );

    Assert.assertTrue( targetFile.exists() );
  }

  @Test
  public void verifyProcessFileWithAnnotationsWithFileSuppliedByAt()
    throws Throwable
  {

    final File srcFile = copyClassToSourceDir( "ClassToWeave.class" );
    final File targetDir = targetDir();

    final File fileList = new File( tmpDir(), "Filelist.txt" );
      final FileOutputStream outputStream = new FileOutputStream( fileList );
    outputStream.write( srcFile.getAbsolutePath().getBytes() );
    outputStream.close();


    final CollectingHandler handler = initLogger();
    Main.main( new String[]{ "--verbose", "--debug", "-d", targetDir.getAbsolutePath(), "@" + fileList.getAbsolutePath() } );

    final File targetFile =
      new File( targetDir, "org/realityforge/swung_weave/tool/ClassToWeave.class" );

    handler.assertMatches( Pattern.quote( "Evaluating: " + srcFile.getAbsolutePath() ) );
    handler.assertMatches( Pattern.quote( "Created dir: " +
                                          targetFile.getParentFile().getAbsolutePath() ) );
    handler.assertMatches( Pattern.quote( "Transformed: " + srcFile.getAbsolutePath() ) );
    handler.assertMatches( "Transformed: 1 Skipped: 0" );

    Assert.assertTrue( targetFile.exists() );
  }

  @Test
  public void verifySkipFileWithoutAnnotations()
    throws Throwable
  {
    final File srcFile = copyClassToSourceDir( "TestInvocation.class" );
    final File targetDir = targetDir();

    final CollectingHandler handler = initLogger();
    Main.main( new String[]{ "--verbose", "-d", targetDir.getAbsolutePath(), srcFile.getAbsolutePath() } );

    final File targetFile =
      new File( targetDir, "org/realityforge/swung_weave/tool/TestInvocation.class" );
    handler.assertMatches( "Transformed: 0 Skipped: 1" );

    Assert.assertFalse( targetFile.exists() );
  }

  private CollectingHandler initLogger()
  {
    Main.L.setUseParentHandlers( false );
    Main.L.setLevel( Level.ALL );
    for ( final Handler h : Main.L.getHandlers() )
    {
      Main.L.removeHandler( h );
    }

    final CollectingHandler handler = new CollectingHandler();
    handler.setLevel( Level.ALL );
    Main.L.addHandler( handler );

    return handler;
  }

  private static File tmpDir()
  {
    return new File( System.getProperty( "java.io.tmpdir" ) );
  }

  private static File sourceDir()
  {
    final File file = new File( tmpDir(), "swung-weave_test_" + System.nanoTime() + "_src" );
    file.mkdirs();
    return file;
  }

  private static File targetDir()
  {
    final File file = new File( tmpDir(), "swung-weave_test_" + System.nanoTime() + "_target" );
    file.mkdirs();
    return file;
  }

  private static File copyClassToSourceDir( final String classname )
    throws IOException
  {
    final File srcFile = new File( sourceDir(), classname );
    final FileOutputStream outputStream = new FileOutputStream( srcFile );
    final InputStream inputStream =
      new BufferedInputStream( MainTestCase.class.getResourceAsStream( classname ) );
    int data;
    while ( -1 != ( data = inputStream.read() ) )
    {
      outputStream.write( data );
    }
    outputStream.close();
    return srcFile;
  }

  private static class CollectingHandler
    extends Handler
  {
    final LinkedList<LogRecord> records = new LinkedList<LogRecord>();

    @Override
    public void publish( final LogRecord record )
    {
      records.add( record );
    }

    @Override
    public void flush()
    {
    }

    @Override
    public void close()
      throws SecurityException
    {
    }

    void assertMatches( final String regex )
    {
      final StringBuilder sb = new StringBuilder();
      for ( final LogRecord record : records )
      {
        final String message = record.getMessage();
        sb.append( message );
        sb.append( "\n" );
        if ( message.matches( ".*" + regex + ".*" ) )
        {
          return;
        }
      }

      Assert.fail( "Failed to match regex " + regex + " in log \n" + sb );
    }
  }
}
