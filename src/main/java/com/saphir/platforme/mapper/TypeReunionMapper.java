package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.TypeReunionDto;
import com.saphir.platforme.entity.TypeReunion;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UtilisateurMapper.class})
public interface TypeReunionMapper {
    TypeReunionDto toDto(TypeReunion typeReunion);

    TypeReunion toEntity(TypeReunionDto typeReunionDto);

    List<TypeReunionDto> toDtos(List<TypeReunion> typeReunion);

    List<TypeReunion> toEntities(List<TypeReunionDto> typeReunionDto);


}

