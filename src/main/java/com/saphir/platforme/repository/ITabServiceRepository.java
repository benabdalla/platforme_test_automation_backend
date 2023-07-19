package com.saphir.platforme.repository;

import com.saphir.platforme.dto.DirectionDto;
import com.saphir.platforme.dto.TabServiceDto;
import com.saphir.platforme.entity.TabService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITabServiceRepository  {
    public List<TabServiceDto> getServices();

}
