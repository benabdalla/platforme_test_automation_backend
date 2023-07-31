package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.ScenarioActiviteDto;
import com.saphir.platforme.entity.ScenarioActivite;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UtilisateurMapper.class, ActiviteMapper.class})

public interface ScenarioActiviteMapper {
    ScenarioActiviteDto toDto(ScenarioActivite scenarioDirection);

    ScenarioActivite toEntity(ScenarioActiviteDto scenarioActiviteDto);

    List<ScenarioActiviteDto> toDtos(List<ScenarioActivite> scenarioActivites);

    List<ScenarioActivite> toEntities(List<ScenarioActiviteDto> scenarioActiviteDtos);

}
