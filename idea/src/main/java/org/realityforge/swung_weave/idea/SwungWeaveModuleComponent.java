package org.realityforge.swung_weave.idea;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetManager;
import com.intellij.openapi.compiler.CompileContext;
import com.intellij.openapi.compiler.CompileTask;
import com.intellij.openapi.compiler.CompilerManager;
import com.intellij.openapi.compiler.CompilerMessageCategory;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleComponent;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootsTraversing;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.PathsList;
import com.intellij.util.lang.UrlClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.realityforge.swung_weave.facet.SwungWeaveFacet;

/**
 * This component enhances SwungWeave annotated classes appropriately. The enhancement operation
 * is done after regular compilation of Java classes. The enhanced version of the classes
 * overwrite the original version of classes.
 */
public class SwungWeaveModuleComponent
  implements ModuleComponent
{
  private static final Logger LOG = Logger.getInstance( SwungWeaveModuleComponent.class.getName() );

  private static final String COMPONENT_NAME = "SwingWeave Module Enhancer Component";

  private static final String MAIN_CLASS_NAME = "org.realityforge.swung_weave.tool.Main";
  private static final String RUN_METHOD_NAME = "run";

  private final Module _module;
  private final FacetManager _facetManager;

  public SwungWeaveModuleComponent( final Module module )
  {
    _module = module;
    _facetManager = FacetManager.getInstance( _module );
  }

  public void initComponent()
  {
    // Nothing to do here
  }

  public void disposeComponent()
  {
    // Nothing to do here
  }

  @NotNull
  public String getComponentName()
  {
    return COMPONENT_NAME;
  }

  public void projectOpened()
  {
    // Nothing to to here
  }

  public void projectClosed()
  {
    // TODO: Should we call _module.dispose()?
  }

  public void moduleAdded()
  {
    // TODO add logging
    final Project project = _module.getProject();
    final CompilerManager compilerManager = CompilerManager.getInstance( project );
    compilerManager.addAfterTask( new CompileTask()
    {
      @Override
      public boolean execute( final CompileContext compileContext )
      {
        if ( !hasSwungWeaveFacet() )
        {
          return true;
        }

        // The module has the SwungWeave facet, so we enhance its main classes
        LOG.info( "Enhancing main classes of the " + _module.getName() + " module." );
        final VirtualFile outputDir = compileContext.getModuleOutputDirectory( _module );
        boolean success = enhanceClasses( outputDir, compileContext );

        if ( success )
        {
          // enhancement of main classes succeeded, now we enhance test classes
          LOG.info( "Enhancing test classes of the " + _module.getName() + " module." );
          final VirtualFile testOutputDir = compileContext.getModuleOutputDirectoryForTests( _module );
          success = enhanceClasses( testOutputDir, compileContext );
        }

        return success;
      }
    } );
  }

  private boolean hasSwungWeaveFacet()
  {
    boolean hasSwungWeaveFacet = false;
    for ( final Facet facet : _facetManager.getAllFacets() )
    {
      if ( facet instanceof SwungWeaveFacet )
      {
        hasSwungWeaveFacet = true;
        break;
      }
    }
    return hasSwungWeaveFacet;
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
    for ( final File file : dir.listFiles() )
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

  /**
   * Enhancing all the classes inside <code>outputDir</code> using SwungWeave.
   *
   * @param outputDir      The directory that contains the .class file that should be enhanced
   * @param compileContext The module compilation context
   * @return <code>false</code> in case of an error. <code>true</code> otherwise.
   */
  private boolean enhanceClasses( final VirtualFile outputDir, final CompileContext compileContext )
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
        invokeMain( compileContext, args.toArray( new String[args.size()] ) );
      }
      catch ( Throwable t )
      {
        if ( t instanceof InvocationTargetException )
        {
          t = t.getCause();
        }

        compileContext.addMessage( CompilerMessageCategory.ERROR,
                                   "An unexpected error of type " + t.getClass().getName() +
                                   " occurred in the SwungWeave plugin. Message: " + t.getMessage(),
                                   null,
                                   -1,
                                   -1 );
        t.printStackTrace(); // TODO need better logging
        return false;
      }
    }
    return true;
  }

  private void invokeMain( final CompileContext context, final String[] args )
    throws NoSuchMethodException, IllegalAccessException,
           InvocationTargetException, IOException, InstantiationException
  {
    final URLClassLoader loader = newClassLoader( context, _module );
    final ClassLoader oldLoader = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader( loader );

    final StringBuilder classPathInfo = new StringBuilder( );
    classPathInfo.append( _module.getName() ).append( "'s class path is:\n" );
    for ( final URL url : loader.getURLs() )
    {
      classPathInfo.append( "\n\t" ).append( url.toString() );
    }

    LOG.info( classPathInfo.toString() );

    context.addMessage( CompilerMessageCategory.INFORMATION,
                        "Enhancing " + _module.getName() + " classes.",
                        null,
                        -1,
                        -1 );
    try
    {
      final Class mainClass = loader.loadClass( MAIN_CLASS_NAME );
      final Object main = mainClass.newInstance();
      final Method runMethod = mainClass.getDeclaredMethod( RUN_METHOD_NAME, String[].class );
      runMethod.invoke( main, new Object[]{ args } );
    }
    catch ( final ClassNotFoundException cnfe )
    {
      LOG.error( cnfe );
    }
    finally
    {
      Thread.currentThread().setContextClassLoader( oldLoader );
    }
  }

  /**
   * <p>Creates a new {@link ClassLoader} that includes all the module jars
   * and output dirs in the current compile context, and all the jars
   * in the current classloader. Since the returned classloader does
   * not actually delegate to the classloader of this class,
   * non-bootstrap instances cannot be shared between instances from
   * the classloader returned by this call and the current instance.</p>
   * <p/>
   * (Note: this method is copied from the OpenJPA project with some minor modifications.)
   */
  private URLClassLoader newClassLoader( final CompileContext context, final Module module )
    throws IOException
  {
    final Collection<URL> urls = new LinkedList<URL>();

    final UrlClassLoader loader = (UrlClassLoader) getClass().getClassLoader();
    urls.addAll( loader.getUrls() );

    for ( final VirtualFile vf : context.getAllOutputDirectories() )
    {
      urls.add( new File( vf.getPath() ).getCanonicalFile().toURI().toURL() );
    }

    final PathsList paths = ProjectRootsTraversing.collectRoots( module, ProjectRootsTraversing.PROJECT_LIBRARIES );
    for ( final VirtualFile vf : paths.getVirtualFiles() )
    {
      final File f = new File( vf.getPath() );
      urls.add( f.toURI().toURL() );
    }

    return new URLClassLoader( urls.toArray( new URL[urls.size()] ) );
  }
}
