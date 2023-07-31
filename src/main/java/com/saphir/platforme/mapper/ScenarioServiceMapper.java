package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.ScenarioServiceDto;
import com.saphir.platforme.entity.ScenarioService;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UtilisateurMapper.class, TabServiceMapper.class})

public interface ScenarioServiceMapper {

    ScenarioServiceDto toDto(ScenarioService scenarioService);

    ScenarioService toEntity(ScenarioServiceDto scenarioServiceDto);


    List<ScenarioServiceDto> toDtos(List<ScenarioService> scenarioService);

    List<ScenarioService> toEntities(List<ScenarioServiceDto> scenarioServiceDto);

}
