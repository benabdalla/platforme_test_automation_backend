package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.DocumentationDto;
import com.saphir.platforme.entity.Documentation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TypeDocumentMapper.class, DirectionMapper.class,ActiviteMapper.class, SiteMapper.class, TabServiceMapper.class, ProcessusMapper.class})
public interface DocumentationMapper {
    DocumentationDto toDto(Documentation Documentation);

    Documentation toEntity(DocumentationDto DocumentationDto);

    List<DocumentationDto> toDtos(List<Documentation> Documentation);

    List<Documentation> toEntities(List<DocumentationDto> DocumentationDto);


}

