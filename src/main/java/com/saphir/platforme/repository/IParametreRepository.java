package com.saphir.platforme.repository;

import com.saphir.platforme.dto.ParametrageDto;
import com.saphir.platforme.entity.Parametrage;

import java.util.List;

public interface IParametreRepository {
    public ParametrageDto addParametrage(ParametrageDto parametrageDto);

    public ParametrageDto modifiyParametrage(ParametrageDto parametrageDto);

    public ParametrageDto deleteParametrage(ParametrageDto parametrageDto);

    public List<ParametrageDto> getAllParametrage();
}
