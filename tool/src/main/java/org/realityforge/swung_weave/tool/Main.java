package org.realityforge.swung_weave.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

public class Main
{
  static final Logger LOG = Logger.getLogger( Main.class.getName() );

  private final LinkedList<String> _filenames = new LinkedList<String>();
  private String _baseDir = "";
  private boolean _error;

  public static void main( final String[] args )
  {
    final ConsoleHandler handler = new ConsoleHandler();
    handler.setLevel( Level.ALL );
    handler.setFormatter( new Formatter()
    {
      @Override
      public String format( final LogRecord record )
      {
        return record.getMessage() + "\n";
      }
    } );
    handler.setLevel( Level.ALL );
    LOG.setLevel( Level.WARNING );
    LOG.addHandler( handler );
    LOG.setUseParentHandlers( false );
    new Main().run( args );
  }

  public void run( final String[] args )
  {
    processArgs( args );
    if ( isError() )
    {
      return;
    }
    LOG.info( "Weave Tool starting" );

    LOG.fine( "Files to process:" );
    for ( final String filename : getFilenames() )
    {
      LOG.fine( "\t" + filename );
    }

    int transformCount = 0;
    int skipCount = 0;
    final long start = System.currentTimeMillis();
    for ( final String filename : getFilenames() )
    {
      LOG.fine( "Evaluating: " + filename );
      if ( process( filename ) )
      {
        transformCount++;
        LOG.fine( "Transformed: " + filename );
      }
      else
      {
        skipCount++;
        LOG.fine( "Skipped: " + filename );
      }
      if ( isError() )
      {
        return;
      }
    }

    final long seconds = ( System.currentTimeMillis() - start ) / 1000;
    final String message =
      "Weave tool completed in " + seconds + "s (Transformed: " + transformCount + " Skipped: " + skipCount + ")";
    LOG.info( message );
  }

  private boolean process( final String filename )
  {
    final ClassWriter cw;
    final SwClassAdapter adapter;
    try
    {
      final FileInputStream inputStream = new FileInputStream( filename );
      cw = new ClassWriter( ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS );
      final ClassReader cr = new ClassReader( inputStream );
      adapter = new SwClassAdapter( cw );
      cr.accept( adapter, 0 );
      inputStream.close();
    }
    catch ( final IOException ioe )
    {
      error( "Problem reading file: " + filename, ioe );
      return false;
    }
    catch ( final Throwable t )
    {
      error( "Problem processing file: " + filename, t );
      return false;
    }

    if ( !adapter.matchedAnnotations() )
    {
      return false;
    }
    else
    {
      final HashMap<String, byte[]> classData = new HashMap<String, byte[]>();
      for ( final Entry<String, byte[]> e : adapter.getClassData().entrySet() )
      {
        classData.put( toFilename( e.getKey() ), e.getValue() );
      }
      classData.put( toFilename( adapter.getClassname() ), cw.toByteArray() );

      for ( final Map.Entry<String, byte[]> entry : classData.entrySet() )
      {
        final File file = new File( entry.getKey() );
        if ( file.getParentFile().mkdirs() )
        {
          if ( LOG.isLoggable( Level.FINE ) )
          {
            LOG.fine( "Created dir: " + file.getParentFile().getAbsolutePath() );
          }
        }
        try
        {
          final FileOutputStream fos = new FileOutputStream( file );
          fos.write( entry.getValue() );
          fos.close();
        }
        catch ( final IOException ioe )
        {
          error( "Problem writing file: " + file, ioe );
          return false;
        }
      }
      return true;
    }
  }

  private String toFilename( final String classname )
  {
    return getBaseDir() + '/' + classname.replace( '.', '/' ) + ".class";
  }

  private void processArgs( final String[] args )
  {
    boolean expectBasedir = false;
    for ( final String arg : args )
    {
      if ( expectBasedir )
      {
        _baseDir = arg;
        expectBasedir = false;
      }
      else if ( "--verbose".equals( arg ) )
      {
        LOG.setLevel( Level.INFO );
      }
      else if ( "--debug".equals( arg ) )
      {
        LOG.setLevel( Level.FINE );
      }
      else if ( "-d".equals( arg ) )
      {
        expectBasedir = true;
      }
      else if ( arg.startsWith( "@" ) )
      {
        try
        {
          final BufferedReader reader =
            new BufferedReader( new InputStreamReader( new FileInputStream( arg.substring( 1 ) ) ) );
          String line;
          while ( ( line = reader.readLine() ) != null )
          {
            getFilenames().add( line );
          }
        }
        catch ( final IOException e )
        {
          error( "Error reading file list from " + arg, e );
          return;
        }
      }
      else
      {
        getFilenames().add( arg );
      }
    }
  }

  private void error( final String message, final Throwable e )
  {
    LOG.log( Level.SEVERE, message, e );
    _error = true;
  }

  final boolean isError()
  {
    return _error;
  }

  final String getBaseDir()
  {
    return _baseDir;
  }

  final LinkedList<String> getFilenames()
  {
    return _filenames;
  }
}
