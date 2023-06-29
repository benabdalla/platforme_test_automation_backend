package com.saphir.platforme.service;

import com.saphir.platforme.dto.ActionDto;
import com.saphir.platforme.dto.ParametrageDto;
import com.saphir.platforme.entity.Parametrage;
import com.saphir.platforme.entity.Processus;
import com.saphir.platforme.entity.Site;
import com.saphir.platforme.mapper.ParametrageMapper;
import com.saphir.platforme.repository.IParametreRepository;
import com.saphir.platforme.repository.ParametreRepository;
import com.saphir.platforme.repository.ProcessusRepository;
import com.saphir.platforme.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParametrageService implements IParametreRepository {
    @Autowired
    ParametreRepository parametreRepository;
    @Autowired
    ParametrageMapper parametrageMapper;
    @Autowired
    SiteRepository siteRepository;
    @Autowired
    ProcessusRepository processusRepository;


    @Override
    public ParametrageDto addParametrage(ParametrageDto parametrageDto) {
        Parametrage parametrage = new Parametrage();

        parametrage = parametrageMapper.toEntity(parametrageDto);
        parametrage = parametreRepository.save(parametrage);
        parametrageDto = parametrageMapper.toDto(parametrage);
        return parametrageDto;
    }

    @Override
    public ParametrageDto modifiyParametrage(ParametrageDto parametrageDto) {
        return null;
    }

    @Override
    public ParametrageDto deleteParametrage(ParametrageDto parametrageDto) {
        return null;
    }

    @Override
    public List<ParametrageDto> getAllParametrage() {
        List<ParametrageDto> parametrageDto;

        parametrageDto = parametrageMapper.toDtos(parametreRepository.findAll());
        return parametrageDto;
    }

    @Override
    public List<Site> getAllSite() {
        return siteRepository.findAll();
    }

    @Override
    public List<Processus> getAllProcessus() {
        return processusRepository.findAll();
    }
}
