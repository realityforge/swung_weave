/*
 * User: behrangsa
 * Date: 10/09/2010
 * Time: 3:59:44 PM 
 */
package org.realityforge.swung_weave.idea;

import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.compiler.CompileContext;
import com.intellij.openapi.compiler.CompileTask;
import com.intellij.openapi.compiler.CompilerManager;
import com.intellij.openapi.module.ModuleComponent;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.VirtualFile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.realityforge.swung_weave.tool.Main;

/**
 * This component enhances Swinkar annotated classes appropriately. The enhancement operation
 * is done after regular compilation of Java classes. The enhanced version of the classes overwrite
 * the original version of classes.
 *
 * @author Behrang Saeedzadeh
 */
public class SwungWeaveModuleComponent
  implements ModuleComponent
{
  private final Module _module;

  public SwungWeaveModuleComponent( Module module )
  {
    _module = module;
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
    return "SwungWeave Module Enhancement Component";
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
        final VirtualFile outputDir = compileContext.getModuleOutputDirectory( _module );
        final String baseDir = outputDir.getPath();
        final List<String> classFileNames = new ArrayList<String>();
        collectClassFileNames( classFileNames, baseDir );

        final List<String> args = new ArrayList<String>();
        args.add("-d");
        args.add(baseDir);
        args.addAll( classFileNames );       
        Main.main( args.toArray( new String[0] ) );

        return true;
      }
    } );
  }

  /**
   * Traversed <code>baseDir</code> and adds every <code>.class<code> file inside it to
   * <code>classFileNames</code>.
   *
   * @param classFileNames A non-null mutable list of <code>String</code>s
   * @param baseDir A non-null directory
   */
  private void collectClassFileNames( List<String> classFileNames, final String baseDir )
  {
    final File dir = new File( baseDir );
    for ( File file : dir.listFiles() )
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
