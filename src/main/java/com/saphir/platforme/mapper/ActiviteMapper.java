package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.ActiviteDto;
import com.saphir.platforme.entity.Activite;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ActiviteMapper {

    ActiviteDto toDto(Activite activite);

    Activite toEntity(ActiviteDto activiteDto);

    List<ActiviteDto> toDtos(List<Activite> activite);

    List<Activite> toEntities(List<ActiviteDto> activite);


}
