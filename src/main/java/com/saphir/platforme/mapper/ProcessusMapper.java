package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.ProcessusDto;
import com.saphir.platforme.entity.Processus;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProcessusMapper {

    ProcessusDto toDto(Processus processus);

    Processus toEntity(ProcessusDto processusDto);

    List<ProcessusDto> toDtos(List<Processus> processus);

    List<Processus> toEntities(List<ProcessusDto> processus);


}
