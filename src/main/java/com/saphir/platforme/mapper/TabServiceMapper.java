package com.saphir.platforme.mapper;

import com.saphir.platforme.dto.TabServiceDto;
import com.saphir.platforme.entity.TabService;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TabServiceMapper {

    TabServiceDto toDto(TabService tabService);

    TabService toEntity(TabServiceDto tabServiceDto);

    List<TabServiceDto> toDtos(List<TabService> tabService);

    List<TabService> toEntities(List<TabServiceDto> tabService);


}
