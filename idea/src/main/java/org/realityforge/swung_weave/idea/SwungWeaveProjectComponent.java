package org.realityforge.swung_weave.idea;

import com.intellij.javaee.model.xml.persistence.PersistenceUnit;
import com.intellij.jpa.facet.JpaFacet;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.compiler.CompileContext;
import com.intellij.openapi.compiler.CompileTask;
import com.intellij.openapi.compiler.CompilerManager;
import com.intellij.openapi.compiler.CompilerMessageCategory;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ProjectRootsTraversing;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.persistence.model.PersistentObject;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiFile;
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
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SwungWeaveProjectComponent
  implements ProjectComponent
{
  private final Project _project;

  public SwungWeaveProjectComponent( final Project project )
  {
    _project = project;
  }

  public void initComponent()
  {
  }

  public void disposeComponent()
  {
  }

  @NonNls
  @NotNull
  public String getComponentName()
  {
    return "SwungWeave Enhancer";
  }

  public void projectOpened()
  {
    CompilerManager.getInstance( _project ).addAfterTask( new CompileTask()
    {
      public boolean execute( CompileContext context )
      {
        return ApplicationManager.getApplication().runReadAction( new ComputableImpl( context ) );
      }
    } );
  }


  public void projectClosed()
  {
  }

  private class ComputableImpl
    implements Computable<Boolean>
  {

    private final CompileContext _compileContext;

    private ComputableImpl( CompileContext compileContext )
    {
      _compileContext = compileContext;
    }

    public Boolean compute()
    {
      try
      {
        // ### We could do something clever with the results of
        // ### ctx.isMake() to only process those files that
        // ### were explicitly selected in cases where the user
        // ### is compiling manually. It doesn't seem like there
        // ### is a big performance win to doing this, but it would
        // ### help us avoid any possible enhancer problems with
        // ### classes that don't currently compile or don't
        // ### currently enhance, since the user could selectively
        // ### explicitly compile files that do work.
        _compileContext.getProgressIndicator().pushState();
        _compileContext.getProgressIndicator().setText( "SwungWeave Enhancer running" );
        boolean status = true;
        final Module[] modules = _compileContext.getCompileScope().getAffectedModules();
        for ( final Module m : modules )
        {
          //Does this module have an associated facet???
          status = true;
        }
        return status;
      }
      catch ( final Throwable t )
      {
        if ( t instanceof InvocationTargetException )
        {
          t = t.getCause();
        }

        _compileContext.addMessage( CompilerMessageCategory.ERROR,
                        "An unexpected error of type " + t.getClass().getName() + " occurred in the OpenJPA plugin. Message: "
                        + t.getMessage(),
                        null, -1, -1 );
        t.printStackTrace(); // FIXME need better logging
        return false;
      }
      finally
      {
        _compileContext.getProgressIndicator().popState();
      }
    }

    private boolean isOpenJPA( PersistenceUnit pu )
    {
      PsiClass providerClass = pu.getProvider().getValue();
      return providerClass == null || providerClass.getName().equals(
        "org.apache.openjpa.persistence.PersistenceProviderImpl" );
    }

    private boolean processPersistenceUnit( JpaFacet jpa,
                                            PersistenceUnit pu )
      throws IOException, ClassNotFoundException, IllegalAccessException,
             InstantiationException, NoSuchMethodException,
             InvocationTargetException
    {

      List<String> args = new ArrayList<String>();

      if ( args.size() == 0 )
      {
        return true;
      }
      ClassLoader cl = newClassLoader( jpa.getModule() );
      ClassLoader oldLoader =
        Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader( cl );
      try
      {
        final Class cls = Class.forName( "org.apache.openjpa.idea.PCEnhancerExecutor", true, cl );
        final Object o = cls.newInstance();

        // assume that all the PersistentObjects in a given PU are
        // accessible from the same classloader.
        _compileContext.getProgressIndicator().setText2( "running enhancer on persistent types in '" + pu.getName() + "'" );

        final Method method =
          cls.getMethod( "enhance", Collection.class, String.class, Object.class, ClassLoader.class );
        final boolean status =
          (Boolean) method.invoke( o, args, pu.getName().getValue(), new LogAdapter( _compileContext ), cl );

        if ( status )
        {
          _compileContext.getProgressIndicator().setText2( "done enhancing '" + pu.getName() + "'" );
        }
        else
        {
          _compileContext.getProgressIndicator().setText2( "error while enhancing '" + pu.getName() + "'" );
        }

        return status;
      }
      finally
      {
        Thread.currentThread().setContextClassLoader( oldLoader );
      }
    }

    /**
     * Creates a new {@link ClassLoader} that includes all the module jars
     * and output dirs in the current compile context, and all the jars
     * in the current classloader. Since the returned classloader does
     * not actually delegate to the classloader of this class,
     * non-bootstrap instances cannot be shared between instances from
     * the classloader returned by this call and the current instance.
     */
    private ClassLoader newClassLoader( Module module )
      throws IOException
    {
      final Collection<URL> urls = new LinkedList<URL>();

      final UrlClassLoader loader = (UrlClassLoader) getClass().getClassLoader();
      urls.addAll( loader.getUrls() );

      for ( final VirtualFile vf : _compileContext.getAllOutputDirectories() )
      {
        urls.add( new File( vf.getPath() ).getCanonicalFile().toURI().toURL() );
      }

      PathsList paths = ProjectRootsTraversing.collectRoots( module,
                                                             ProjectRootsTraversing.PROJECT_LIBRARIES );
      for ( VirtualFile vf : paths.getVirtualFiles() )
      {
        final File f = new File( vf.getPath() );
        urls.add( f.toURI().toURL() );
      }

      return new URLClassLoader( urls.toArray( new URL[urls.size()] ) );
    }
  }

  private static void addPersistentObjects( List<String> args,
                                            List<? extends PersistentObject> pos, CompileContext ctx )
  {
    for ( PersistentObject po : pos )
    {
      if ( isUserClass( po ) && inScope( po, ctx ) )
      // don't just use po.getClazz().getStringValue() since it
      // returns unqualified names for persistent objects defined
      // in XML.
      {
        args.add( po.getClazz().getValue().getQualifiedName() );
      }
    }
  }

  /**
   * Determines whether or not <code>po</code> is a class in the
   * user-defined area of the module (vs. in a pre-packaged library).
   */
  private static boolean isUserClass( PersistentObject po )
  {
    return po.getContainingFile().getVirtualFile().isWritable();
  }

  /**
   * Whether or not <code>po</code>'s source file is in the scope of this
   * compilation context. If the file is not in scope, then we should not
   * run the enhancer on the file, since it may not have been actually
   * compiled yet.
   */
  private static boolean inScope( final PersistentObject po,
                                  final CompileContext ctx )
  {
    final PsiFile containingFile = po.getContainingFile();
    if ( null == containingFile )
    {
      return false;
    }
    final VirtualFile file = containingFile.getVirtualFile();
    return null != file && ctx.getCompileScope().belongs( file.getUrl() );
  }
}
