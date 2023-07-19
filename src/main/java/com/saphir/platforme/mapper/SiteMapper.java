package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.SiteDto;
import com.saphir.platforme.entity.Site;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SiteMapper {

    SiteDto toDto(Site site);

    Site toEntity(SiteDto siteDto);

    List<SiteDto> toDtos(List<Site> site);

    List<Site> toEntities(List<SiteDto> site);


}
