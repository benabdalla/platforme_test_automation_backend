package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.ScenarioPrcocessDto;
import com.saphir.platforme.entity.ScenarioProcessus;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UtilisateurMapper.class, ProcessusMapper.class})

public interface ScenarioProcessusMapper {
    ScenarioPrcocessDto toDto(ScenarioProcessus scenarioProcessus);

    ScenarioProcessus toEntity(ScenarioPrcocessDto scenarioPrcocessDto);

    List<ScenarioPrcocessDto> toDtos(List<ScenarioProcessus> scenarioProcessuses);

    List<ScenarioProcessus> toEntities(List<ScenarioPrcocessDto> scenarioPrcocessDtos);

}
