package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.DirectionDto;
import com.saphir.platforme.entity.Direction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DirectionMapper {

    DirectionDto toDto(Direction direction);

    Direction toEntity(DirectionDto directionDto);

    List<DirectionDto> toDtos(List<Direction> direction);

    List<Direction> toEntities(List<DirectionDto> direction);


}
