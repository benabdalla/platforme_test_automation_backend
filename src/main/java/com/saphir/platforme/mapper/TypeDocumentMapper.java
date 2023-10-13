package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.TypeDocumentationDto;
import com.saphir.platforme.entity.TypeDocumentation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UtilisateurMapper.class})
public interface TypeDocumentMapper {
    TypeDocumentationDto toDto(TypeDocumentation typeDocumentation);

    TypeDocumentation toEntity(TypeDocumentationDto typeDocumentationDto);

    List<TypeDocumentationDto> toDtos(List<TypeDocumentation> typeDocumentation);

    List<TypeDocumentation> toEntities(List<TypeDocumentationDto> typeDocumentationDto);


}

