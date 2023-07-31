package com.saphir.platforme.repository;

import com.saphir.platforme.dto.TabServiceDto;

import java.util.List;

public interface ITabServiceRepository {
    List<TabServiceDto> getServices();

}
