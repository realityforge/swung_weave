package org.realityforge.swung_weave.idea;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SwungWeaveProjectComponent
  implements ProjectComponent
{
  private static final String COMPONENT_NAME = "SwungWeave Enhancer";

  @SuppressWarnings( { "UnusedDeclaration" } )
  public SwungWeaveProjectComponent( final Project project )
  {
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
    return COMPONENT_NAME;
  }

  public void projectOpened()
  {
  }

  public void projectClosed()
  {
  }
}
