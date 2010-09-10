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
  }


  public void projectClosed()
  {
  }
}
