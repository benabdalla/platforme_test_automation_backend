package com.saphir.platforme.repository;

import com.saphir.platforme.dto.ActiviteDto;
import com.saphir.platforme.dto.DirectionDto;

import java.util.List;

public interface IDirectionRepository {
    public List<DirectionDto> getDirections();
}
