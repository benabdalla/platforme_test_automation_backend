package com.saphir.platforme.service;

import com.saphir.platforme.dto.*;
import com.saphir.platforme.entity.*;
import com.saphir.platforme.mapper.*;
import com.saphir.platforme.repository.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParametrageService implements IParametreRepository, IDirectionRepository, ITabServiceRepository, IActiviteRepository {
    @Autowired
    ParametreRepository parametreRepository;
    @Autowired
    ParametrageMapper parametrageMapper;
    @Autowired
    SiteRepository siteRepository;
    @Autowired
    ProcessusRepository processusRepository;
    @Autowired
    TabServiceRepository tabServiceRepository;
    @Autowired
    DirectionRepository directionRepository;
    @Autowired
    ActiviteRepository activiteRepository;
    @Autowired
    ActiviteMapper activiteMapper;
    @Autowired
    DirectionMapper directionMapper;
    @Autowired
    TabServiceMapper tabServiceMapper;
    @Autowired
    SiteMapper siteMapper;
    @Autowired
    ScenarioSiteMapper scenarioSiteMapper;
    @Autowired
    ScenrioSiteRepository scenrioSiteRepository;
    @Autowired
    ProcessusMapper processusMapper;


    @Override
    public ParametrageDto addParametrage(ParametrageDto parametrageDto) {
        Parametrage parametrage = new Parametrage();

        parametrage = parametrageMapper.toEntity(parametrageDto);
        parametrage = parametreRepository.save(parametrage);
        parametrageDto = parametrageMapper.toDto(parametrage);
        return parametrageDto;
    }

    @Override
    public ParametrageDto modifiyParametrage(ParametrageDto parametrageDto) throws NotFoundException {

        Parametrage parametrage = parametreRepository.findById(parametrageDto.idPram)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + parametrageDto.idPram));
        parametrage.setUrl(parametrageDto.getUrl());
        parametrage.setVerssion(parametrageDto.getVerssion());
        parametrage.setNavigateur(parametrageDto.getNavigateur());
        ParametrageDto parametrageDto1 = parametrageMapper.toDto(parametreRepository.save(parametrage));

        return parametrageDto1;

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
    public ParametrageDto getParametrage(Long id) {

        return parametrageMapper.toDto(parametreRepository.findById(id).orElse(null));
    }

    @Override
    public ScenarioSiteDto addSite(ScenarioSiteDto scenarioSiteDto) {
        Site site =siteMapper.toEntity(scenarioSiteDto.getSite());
        ScenarioSite act = scenarioSiteMapper.toEntity(scenarioSiteDto);
      act.setSite(site);
        scenarioSiteDto = scenarioSiteMapper.toDto(scenrioSiteRepository.save(act));
        return scenarioSiteDto;
    }

    @Override
    public List<ScenarioSiteDto> getSecenarioSite() {
            List<ScenarioSite> scenarioSite=scenrioSiteRepository.findAll();
       List<ScenarioSiteDto> site = scenarioSiteMapper.toDtos(scenrioSiteRepository.findAll());
        return site;
    }

    @Override
    public ProcessusDto addprocessus(ProcessusDto processusDto) {
        Processus act = processusMapper.toEntity(processusDto);
        processusDto = processusMapper.toDto(processusRepository.save(act));
        return processusDto;
    }

    @Override
    public ActiviteDto acdactivite(ActiviteDto activiteDto) {
        Activite act = activiteMapper.toEntity(activiteDto);
        activiteDto = activiteMapper.toDto(activiteRepository.save(act));
        return activiteDto;
    }

    @Override
    public TabServiceDto addService(TabServiceDto tabServiceDto) {
        TabService act = tabServiceMapper.toEntity(tabServiceDto);
        tabServiceDto = tabServiceMapper.toDto(tabServiceRepository.save(act));
        return tabServiceDto;
    }

    @Override
    public DirectionDto addDirection(DirectionDto directionDto) {
        Direction act = directionMapper.toEntity(directionDto);
        DirectionDto directDto = directionMapper.toDto(directionRepository.save(act));
        return directDto;
    }

    @Override
    public ResponseEntity<Site> deleteSite(Long idSceanrio) {
        if (idSceanrio != null) {
            siteRepository.deleteById(idSceanrio);
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Processus> deleteProcessus(Long idSceanrio) {
        if (idSceanrio != null) {
            processusRepository.deleteById(idSceanrio);
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Activite> deleteActivite(Long idSceanrio) {
        if (idSceanrio != null) {
            activiteRepository.deleteById(idSceanrio);
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Direction> deleteDirection(Long idSceanrio) {
        if (idSceanrio != null) {
            directionRepository.deleteById(idSceanrio);
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<TabService> deleteServices(Long idSceanrio) {
        if (idSceanrio != null) {
            tabServiceRepository.deleteById(idSceanrio);
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public List<Site> getAllSite() {
        return siteRepository.findAll();
    }

    @Override
    public List<Processus> getAllProcessus() {
        return processusRepository.findAll();
    }

    @Override
    public List<ActiviteDto> getActivites() {
        List<ActiviteDto> activiteDto;
        List<Activite> activite = activiteRepository.findAll();
        activiteDto = activiteMapper.toDtos(activite);
        return activiteDto;
    }

    @Override
    public List<DirectionDto> getDirections() {
        List<DirectionDto> directionDto;

        directionDto = directionMapper.toDtos(directionRepository.findAll());
        return directionDto;
    }

    @Override
    public List<TabServiceDto> getServices() {
        List<TabServiceDto> tabServiceDto;

        tabServiceDto = tabServiceMapper.toDtos(tabServiceRepository.findAll());
        return tabServiceDto;
    }
}
