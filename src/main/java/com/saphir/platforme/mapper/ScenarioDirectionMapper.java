package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.ScenarioDirectionDto;
import com.saphir.platforme.entity.ScenarioDirection;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UtilisateurMapper.class, DirectionMapper.class})

public interface ScenarioDirectionMapper {
    ScenarioDirectionDto toDto(ScenarioDirection scenarioDirection);

    ScenarioDirection toEntity(ScenarioDirectionDto scenarioDirectionDto);

    List<ScenarioDirectionDto> toDtos(List<ScenarioDirection> scenarioDirections);

    List<ScenarioDirection> toEntities(List<ScenarioDirectionDto> scenarioDirectionDtos);

}
