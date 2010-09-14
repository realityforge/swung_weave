package org.realityforge.swung_weave.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetType;
import com.intellij.facet.FacetTypeRegistry;
import com.intellij.openapi.module.Module;
import org.jetbrains.annotations.NotNull;

public class SwungWeaveFacet
  extends Facet<SwungWeaveFacetConfiguration>
{
  public static final String FACET_NAME = "SwungWeave";

  public SwungWeaveFacet( final @NotNull Module module )
  {
    super( FacetTypeRegistry.getInstance().findFacetType( SwungWeaveFacetType.ID ),
           module, FACET_NAME, new SwungWeaveFacetConfiguration(), null );
  }

  public SwungWeaveFacet( @NotNull final FacetType facetType,
                          @NotNull final Module module,
                          final String name,
                          @NotNull final SwungWeaveFacetConfiguration config,
                          final Facet underlyingFacet )
  {
    super( facetType, module, name, config, underlyingFacet );
  }
}
