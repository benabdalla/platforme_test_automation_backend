package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.ReunionDto;
import com.saphir.platforme.entity.Reunion;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TypeReunionMapper.class,ActiviteMapper.class, DirectionMapper.class, SiteMapper.class, TabServiceMapper.class, ProcessusMapper.class})
public interface ReunionMapper {
    ReunionDto toDto(Reunion reunion);

    Reunion toEntity(ReunionDto reunionDto);

    List<ReunionDto> toDtos(List<Reunion> reunion);

    List<Reunion> toEntities(List<ReunionDto> reunionDto);


}

