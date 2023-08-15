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
import java.util.Optional;

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
    ScenarioProcessusMapper scenarioProcessusMapper;
    @Autowired
    ScenrioProcessusRepository scenrioProcessusRepository;
    @Autowired
    ScenarioActiviteMapper scenarioActiviteMapper;
    @Autowired
    ScenrioActiviteepository scenrioActiviteepository;
    @Autowired
    ScenrioServiceRepository scenrioServiceRepository;
    @Autowired
    ScenarioServiceMapper scenarioServiceMapper;
    @Autowired
    ScenarioDirectionMapper scenarioDirectionMapper;
    @Autowired
    ScenrioDirectionRepository  scenrioDirectionRepository;

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
        Site site = siteMapper.toEntity(scenarioSiteDto.getSite());
        ScenarioSite act = scenarioSiteMapper.toEntity(scenarioSiteDto);
//        act.setSite(site);
        scenarioSiteDto = scenarioSiteMapper.toDto(scenrioSiteRepository.save(act));
        return scenarioSiteDto;
    }

    @Override
    public List<ScenarioSiteDto> getSecenarioSite() {
        List<ScenarioSite> scenarioSite = scenrioSiteRepository.findAll();
        List<ScenarioSiteDto> site = scenarioSiteMapper.toDtos(scenrioSiteRepository.findBySiteIdSiteNotNull());
        return site;
    }

    @Override
    public ScenarioSite getSecenarioSite(Long idScenrio) {
        return scenrioSiteRepository.findById(idScenrio).orElse(null);
    }

    @Override
    public ScenarioProcessus getSecenarioProcessus(Long idScenrio) {
        return scenrioProcessusRepository.findById(idScenrio).orElse(null);
    }

    @Override
    public ScenarioActivite getSecenarioActivite(Long idScenrio) {
        return scenrioActiviteepository.findById(idScenrio).orElse(null);
    }

    @Override
    public ScenarioService getSecenarioService(Long idScenrio) {
        return scenrioServiceRepository.findById(idScenrio).orElse(null);
    }

    @Override
    public ScenarioDirection getSecenarioDirection(Long idScenrio) {
        return scenrioDirectionRepository.findById(idScenrio).orElse(null);
    }


    @Override
    public ScenarioPrcocessDto addprocessus(ScenarioPrcocessDto processusDto) {
        ScenarioProcessus act = scenarioProcessusMapper.toEntity(processusDto);
        // act.setProcessus(processus);
        processusDto = scenarioProcessusMapper.toDto(scenrioProcessusRepository.save(act));
        return processusDto;
    }

    @Override
    public ScenarioActiviteDto acdactivite(ScenarioActiviteDto activiteDto) {
        ScenarioActivite scenarioActivite = scenarioActiviteMapper.toEntity(activiteDto);
        activiteDto = scenarioActiviteMapper.toDto(scenrioActiviteepository.save(scenarioActivite));
        return activiteDto;
    }

    @Override
    public ScenarioServiceDto addService(ScenarioServiceDto tabServiceDto) {
        TabService act = tabServiceMapper.toEntity(tabServiceDto.getTabService());
        ScenarioService scenarioService = scenarioServiceMapper.toEntity(tabServiceDto);
        // scenarioService.setTabService(act);

        tabServiceDto = scenarioServiceMapper.toDto(scenrioServiceRepository.save(scenarioService));
        return tabServiceDto;
    }

    @Override
    public ScenarioDirectionDto addDirection(ScenarioDirectionDto directionDto) {

        ScenarioDirection act = scenarioDirectionMapper.toEntity(directionDto);
        ScenarioDirectionDto directDto = scenarioDirectionMapper.toDto(scenrioDirectionRepository.save(act));

        return directDto;
    }

    @Override
    public ResponseEntity<ScenarioSite> deleteSite(Long idSceanrio) {
        if (idSceanrio != null) {
            Optional<ScenarioSite> scenarioSite = scenrioSiteRepository.findById(idSceanrio);
            Long idSite = scenarioSite.get().getSite().getIdSite();
            if (idSite != null) {
                siteRepository.deleteById(scenarioSite.get().getSite().getIdSite());
            }
            scenrioSiteRepository.deleteById(idSceanrio);
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public List<ScenarioPrcocessDto> getScenarioPocessus() {
        List<ScenarioPrcocessDto> procesessDtos = scenarioProcessusMapper.toDtos(scenrioProcessusRepository.findAll());
        return procesessDtos;
    }

    @Override
    public List<ScenarioActiviteDto> getScenarioActivite() {
        List<ScenarioActiviteDto> site = scenarioActiviteMapper.toDtos(scenrioActiviteepository.findAll());
        return site;
    }

    @Override
    public List<ScenarioDirectionDto> getScenarioDirection() {

        List<ScenarioDirectionDto> site = scenarioDirectionMapper.toDtos(scenrioDirectionRepository.findAll());
        return site;
    }

    @Override
    public List<ScenarioServiceDto> getScenarioServices() {
        List<ScenarioService> scenarioServices = scenrioServiceRepository.findByTabServiceIdServiceNotNull();
        List<ScenarioServiceDto> site = scenarioServiceMapper.toDtos(scenarioServices);
        return site;
    }

    @Override
    public ResponseEntity<ScenarioProcessus> deleteProcessus(Long idSceanrio) {
        if (idSceanrio != null) {

            Optional<ScenarioProcessus> scenarioProcessus = scenrioProcessusRepository.findById(idSceanrio);
            Long idProcess = scenarioProcessus.get().getProcessus().getIdProcessus();
            if (idProcess != null) {
                processusRepository.deleteById(scenarioProcessus.get().getProcessus().getIdProcessus());
            }
            scenrioProcessusRepository.deleteById(idSceanrio);
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<ScenarioActivite> deleteActivite(Long idSceanrio) {
        if (idSceanrio != null) {
            Optional<ScenarioActivite> scenarioActivite = scenrioActiviteepository.findById(idSceanrio);
            Long idActivite = scenarioActivite.get().getActivite().getIdActivite();
            if (idActivite != null) {
                activiteRepository.deleteById(scenarioActivite.get().getActivite().getIdActivite());
            }
            scenrioActiviteepository.deleteById(idSceanrio);

        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<ScenarioDirection> deleteDirection(Long idSceanrio) {
        if (idSceanrio != null) {

            Optional<ScenarioDirection> scenarioDirection = scenrioDirectionRepository.findById(idSceanrio);
            Long idDirection = scenarioDirection.get().getDirection().getIdDrirection();
            if (idDirection != null) {
                directionRepository.deleteById(scenarioDirection.get().getDirection().getIdDrirection());
            }
            scenrioDirectionRepository.deleteById(idSceanrio);

        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<ScenarioService> deleteServices(Long idSceanrio) {
        if (idSceanrio != null) {
            Optional<ScenarioService> scenarioService = scenrioServiceRepository.findById(idSceanrio);
            Long idService = scenarioService.get().getTabService().getIdService();
            if (idService != null) {
                tabServiceRepository.deleteById(scenarioService.get().getTabService().getIdService());
            }
            scenrioServiceRepository.deleteById(idSceanrio);
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
