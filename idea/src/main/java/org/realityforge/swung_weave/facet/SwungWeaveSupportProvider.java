package org.realityforge.swung_weave.facet;

import com.intellij.facet.ui.FacetBasedFrameworkSupportProvider;
import com.intellij.ide.util.frameworkSupport.FrameworkVersion;
import com.intellij.openapi.roots.ModifiableRootModel;

public class SwungWeaveSupportProvider
  extends FacetBasedFrameworkSupportProvider<SwungWeaveFacet>
{
  public SwungWeaveSupportProvider()
  {
    super( SwungWeaveFacetType.INSTANCE );
  }

  @Override
  public String getTitle()
  {
    return "SwungWeave Plugin";
  }

  @Override
  protected void setupConfiguration( final SwungWeaveFacet facet,
                                     final ModifiableRootModel modifiableRootModel,
                                     final FrameworkVersion frameworkVersion )


  {

  }
}
