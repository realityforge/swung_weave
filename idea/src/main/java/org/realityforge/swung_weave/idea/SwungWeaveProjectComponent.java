package org.realityforge.swung_weave.idea;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class SwungWeaveProjectComponent
  implements ProjectComponent
{
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
    return "SwungWeave Enhancer";
  }

  public void projectOpened()
  {
  }

  public void projectClosed()
  {
  }
}
