package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.ActionDto;
import com.saphir.platforme.entity.Action;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UtilisateurMapper.class,ActiviteMapper.class, DirectionMapper.class, SiteMapper.class, TabServiceMapper.class, ProcessusMapper.class})
public interface ActionMapper {
    ActionDto toDto(Action action);

    Action toEntity(ActionDto actionDto);

    List<ActionDto> toDtos(List<Action> action);

    List<Action> toEntities(List<ActionDto> actionDto);


}

