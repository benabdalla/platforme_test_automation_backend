package com.saphir.platforme.repository;

import com.saphir.platforme.dto.DirectionDto;

import java.util.List;

public interface IDirectionRepository {
    List<DirectionDto> getDirections();
}
