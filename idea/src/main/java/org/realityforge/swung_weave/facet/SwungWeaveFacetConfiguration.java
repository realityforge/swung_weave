package org.realityforge.swung_weave.facet;

import com.intellij.facet.FacetConfiguration;
import com.intellij.facet.ui.FacetEditorContext;
import com.intellij.facet.ui.FacetEditorTab;
import com.intellij.facet.ui.FacetValidatorsManager;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.WriteExternalException;
import org.jdom.Element;

public class SwungWeaveFacetConfiguration implements FacetConfiguration
{
  @Override
  public FacetEditorTab[] createEditorTabs( final FacetEditorContext facetEditorContext,
                                            final FacetValidatorsManager facetValidatorsManager )
  {
    return new FacetEditorTab[0];
  }

  @Override
  public void readExternal( final Element element )
    throws InvalidDataException
  {
  }

  @Override
  public void writeExternal( final Element element )
    throws WriteExternalException
  {
  }
}
