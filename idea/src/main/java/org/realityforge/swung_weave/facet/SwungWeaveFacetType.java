package org.realityforge.swung_weave.facet;

import com.intellij.facet.Facet;
import com.intellij.facet.FacetType;
import com.intellij.facet.FacetTypeId;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.StdModuleTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SwungWeaveFacetType
  extends FacetType<SwungWeaveFacet, SwungWeaveFacetConfiguration>
{
  public static final String STRING_ID = "SwungWeave";
  public static final String PRESENTABLE_NAME = "SwungWeave";
  public static final FacetTypeId<SwungWeaveFacet> ID = new FacetTypeId<SwungWeaveFacet>( STRING_ID );
  public static final SwungWeaveFacetType INSTANCE = new SwungWeaveFacetType();

  public SwungWeaveFacetType()
  {
    super( ID, STRING_ID, PRESENTABLE_NAME );
  }

  @Override
  public SwungWeaveFacetConfiguration createDefaultConfiguration()
  {
    return new SwungWeaveFacetConfiguration();
  }

  @Override
  public SwungWeaveFacet createFacet( @NotNull final Module module,
                                      final String s,
                                      @NotNull final SwungWeaveFacetConfiguration swungWeaveFacetConfiguration,
                                      @Nullable final Facet facet )
  {
    return new SwungWeaveFacet( this, module, s, swungWeaveFacetConfiguration, facet );
  }

  @Override
  public boolean isSuitableModuleType( final ModuleType moduleType )
  {
    return StdModuleTypes.JAVA.equals( moduleType );
  }
}
