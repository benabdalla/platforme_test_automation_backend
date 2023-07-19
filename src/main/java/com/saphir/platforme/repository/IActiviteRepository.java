package com.saphir.platforme.repository;

import com.saphir.platforme.dto.ActiviteDto;

import java.util.List;

public interface IActiviteRepository {
    public List<ActiviteDto> getActivites();
}
