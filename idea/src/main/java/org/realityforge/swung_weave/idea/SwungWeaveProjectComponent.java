package org.realityforge.swung_weave.idea;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetManager;
import com.intellij.openapi.compiler.CompileContext;
import com.intellij.openapi.compiler.CompileTask;
import com.intellij.openapi.compiler.CompilerManager;
import com.intellij.openapi.compiler.CompilerMessageCategory;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.realityforge.swung_weave.facet.SwungWeaveFacet;

public class SwungWeaveProjectComponent
  implements ProjectComponent
{
  private static final Logger LOG = Logger.getInstance( SwungWeaveProjectComponent.class.getName() );

  private static final boolean USE_CLASSLOADER =
    System.getProperty( "SwungWeave.useClassLoader", "true" ).equals( "true" );

  private static final String MAIN_CLASS_NAME = "org.realityforge.swung_weave.tool.Main";
  private static final String RUN_METHOD_NAME = "run";

  private static final String COMPONENT_NAME = "SwungWeave Enhancer";

  private final Project _project;

  public SwungWeaveProjectComponent( final Project project )
  {
    _project = project;
  }

  public void initComponent()
  {
    final CompilerManager compilerManager = CompilerManager.getInstance( _project );
    compilerManager.addAfterTask( new CompileTask()
    {
      @Override
      public boolean execute( final CompileContext compileContext )
      {
        boolean success = true;

        for ( final Module module : compileContext.getCompileScope().getAffectedModules() )
        {
          if ( hasSwungWeaveFacet( FacetManager.getInstance( module ) ) )
          {
            // The module has the SwungWeave facet, so we enhance its main classes
            LOG.info( "Enhancing main classes of the " + module.getName() + " module." );
            final VirtualFile outputDir = compileContext.getModuleOutputDirectory( module );
            success &= enhanceClasses( module, outputDir, compileContext );

            // enhancement of main classes succeeded, now we enhance test classes
            LOG.info( "Enhancing test classes of the " + module.getName() + " module." );
            final VirtualFile testOutputDir = compileContext.getModuleOutputDirectoryForTests( module );
            success &= enhanceClasses( module, testOutputDir, compileContext );
          }
        }

        return success;
      }
    } );
  }

  public void disposeComponent()
  {
  }

  @NonNls
  @NotNull
  public String getComponentName()
  {
    return COMPONENT_NAME;
  }

  public void projectOpened()
  {
  }

  public void projectClosed()
  {
  }


  private boolean hasSwungWeaveFacet( final FacetManager facetManager )
  {
    for ( final Facet facet : facetManager.getAllFacets() )
    {
      if ( facet instanceof SwungWeaveFacet )
      {
        return true;
      }
    }
    return false;
  }

  /**
   * Traversed <code>baseDir</code> and adds every <code>.class<code> file inside it to
   * <code>classFileNames</code>.
   *
   * @param classFileNames A non-null mutable list of <code>String</code>s
   * @param baseDir        A non-null directory
   */
  private void collectClassFileNames( final List<String> classFileNames, final String baseDir )
  {
    final File dir = new File( baseDir );
    final File[] files = dir.listFiles();
    if ( null != files )
    {
      for ( final File file : files )
      {
        if ( file.isDirectory() )
        {
          collectClassFileNames( classFileNames, file.getAbsolutePath() );
        }
        else
        {
          if ( file.getName().endsWith( ".class" ) )
          {
            classFileNames.add( file.getAbsolutePath() );
          }
        }
      }
    }
  }

  /**
   * Enhancing all the classes inside <code>outputDir</code> using SwungWeave.
   *
   * @param outputDir      The directory that contains the .class file that should be enhanced
   * @param compileContext The module compilation context
   * @return <code>false</code> in case of an error. <code>true</code> otherwise.
   */
  private boolean enhanceClasses( final Module module, final VirtualFile outputDir, final CompileContext compileContext )
  {
    if ( null != outputDir )
    {
      final String baseDir = outputDir.getPath();
      final List<String> classFileNames = new ArrayList<String>();
      collectClassFileNames( classFileNames, baseDir );

      final List<String> args = new ArrayList<String>();
      args.add( "-d" );
      args.add( baseDir );
      args.addAll( classFileNames );

      try
      {
        if ( USE_CLASSLOADER )
        {
          invokeMain( module, compileContext, args.toArray( new String[ args.size() ] ) );
        }
        else
        {
          invokeViaCLI( module, compileContext, baseDir, args );
        }
      }
      catch ( final Throwable t )
      {
        final Throwable target;
        if ( t instanceof InvocationTargetException )
        {
          target = t.getCause();
        }
        else
        {
          target = t;
        }

        compileContext.addMessage( CompilerMessageCategory.ERROR,
                                   "An unexpected error of type " + target.getClass().getName() +
                                   " occurred in the SwungWeave plugin. Message: " + toString( target ),
                                   null,
                                   -1,
                                   -1
        );
        return false;
      }
    }
    return true;
  }

  private void invokeViaCLI( final Module module,
                             final CompileContext context,
                             final String baseDir,
                             final List<String> args )
    throws Exception
  {
    final StringBuilder sb = new StringBuilder();
    sb.append( "java -cp " );
    sb.append( baseDir );

    for ( final File entry : getSwungWeaveClasspath( module, context ) )
    {
      context.addMessage( CompilerMessageCategory.ERROR, "CP Path: " + entry.getPath(), null, -1, -1 );
      context.addMessage( CompilerMessageCategory.ERROR, "CP Absolute: " + entry.getAbsolutePath(), null, -1, -1 );

      sb.append( File.pathSeparator );
      sb.append( entry.getAbsolutePath() );
    }

    sb.append( " " );
    sb.append( MAIN_CLASS_NAME );
    for ( final String arg : args )
    {
      sb.append( " " );
      sb.append( arg );
    }
    final String command = sb.toString();
    final Process process = Runtime.getRuntime().exec( command );
    process.getOutputStream().close();
    final BufferedReader errorStream = new BufferedReader( new InputStreamReader( process.getErrorStream() ) );
    final StringBuilder sb2 = new StringBuilder();
    String output = errorStream.readLine();
    while ( null != output )
    {
      sb2.append( output );
      output = errorStream.readLine();
    }

    final int exitCode = process.waitFor();
    if ( 0 != exitCode )
    {
      context.addMessage( CompilerMessageCategory.ERROR,
                          "Failed to execute command in " + module.getName() + " " + exitCode + "\nError =\n" + sb2 +
                          "\nCommand =\n" + command + "\n",
                          null,
                          -1,
                          -1 );
    }
  }

  private void invokeMain( final Module module, final CompileContext context, final String[] args )
    throws Exception
  {
    final ClassLoader oldLoader = Thread.currentThread().getContextClassLoader();

    context.addMessage( CompilerMessageCategory.INFORMATION,
                        "Enhancing " + module.getName() + " classes.",
                        null,
                        -1,
                        -1 );
    final URLClassLoader loader = newClassLoader( module, context );
    Thread.currentThread().setContextClassLoader( loader );
    try
    {
      final Class<?> mainClass = loader.loadClass( MAIN_CLASS_NAME );
      final Object main = mainClass.newInstance();
      final Method runMethod = mainClass.getDeclaredMethod( RUN_METHOD_NAME, String[].class );
      runMethod.invoke( main, new Object[]{ args } );
    }
    catch ( final ClassNotFoundException cnfe )
    {
      final StringBuilder classPathInfo = new StringBuilder();
      classPathInfo.append( module.getName() ).append( "'s class path is:\n" );
      for ( final URL url : loader.getURLs() )
      {
        classPathInfo.append( "\n\t" ).append( url.toString() );
      }

      final String message =
        "Unable to locate SwungWeave compiler in " + module.getName() + "'s dependencies.\n" +
        "Due to:\n" + toString( cnfe ) + "\n" +
        "Classpath Details: " + classPathInfo;
      context.addMessage( CompilerMessageCategory.ERROR, message, null, -1, -1 );
    }
    finally
    {
      Thread.currentThread().setContextClassLoader( oldLoader );
    }
  }

  private String toString( final Throwable t )
  {
    final StringWriter out = new StringWriter();
    t.printStackTrace( new PrintWriter( out ) );
    return out.toString();
  }

  private URLClassLoader newClassLoader( final Module module, final CompileContext context )
    throws IOException
  {
    final Collection<URL> urls = new LinkedList<URL>();
    for ( final File file : getSwungWeaveClasspath( module, context ) )
    {
      urls.add( file.toURI().toURL() );
    }
    return new URLClassLoader( urls.toArray( new URL[ urls.size() ] ), null );
  }

  private LinkedList<File> getSwungWeaveClasspath( final Module module, final CompileContext context )
  {
    final LinkedList<File> files = new LinkedList<File>();
    for ( final VirtualFile vf : ModuleRootManager.getInstance( module ).orderEntries().classes().getRoots() )
    {
      final String path = vf.getPath();
      //Strip out !/ suffix - not sure why it is there.
      final String cleanPath = path.endsWith( "!/" ) ? path.substring( 0, path.length() - 2 ) : path;
      files.add( new File( cleanPath ) );
    }
    return files;
  }
}
