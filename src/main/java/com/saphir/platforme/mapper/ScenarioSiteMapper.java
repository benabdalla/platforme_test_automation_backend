package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.ScenarioSiteDto;
import com.saphir.platforme.dto.SiteDto;
import com.saphir.platforme.entity.ScenarioSite;
import com.saphir.platforme.entity.Site;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UtilisateurMapper.class,SiteMapper.class})

public interface ScenarioSiteMapper {
    ScenarioSiteDto toDto(ScenarioSite site);

    ScenarioSite toEntity(ScenarioSiteDto siteDto);

    List<ScenarioSiteDto> toDtos(List<ScenarioSite> site);

    List<ScenarioSite> toEntities(List<ScenarioSiteDto> site);

}
