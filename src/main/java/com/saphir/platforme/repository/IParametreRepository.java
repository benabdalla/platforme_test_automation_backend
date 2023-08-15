package com.saphir.platforme.repository;

import com.saphir.platforme.dto.*;
import com.saphir.platforme.entity.*;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IParametreRepository {
    ParametrageDto addParametrage(ParametrageDto parametrageDto);

    ParametrageDto modifiyParametrage(ParametrageDto parametrageDto) throws NotFoundException;

    ParametrageDto deleteParametrage(ParametrageDto parametrageDto);

    List<ParametrageDto> getAllParametrage();

    List<Site> getAllSite();

    List<Processus> getAllProcessus();

    ParametrageDto getParametrage(Long id);

    ScenarioSiteDto addSite(ScenarioSiteDto site);

    List<ScenarioSiteDto> getSecenarioSite();

    ScenarioPrcocessDto addprocessus(ScenarioPrcocessDto processusDto);

    ScenarioActiviteDto acdactivite(ScenarioActiviteDto activiteDto);

    ScenarioServiceDto addService(ScenarioServiceDto tabServiceDto);

    ScenarioDirectionDto addDirection(ScenarioDirectionDto directionDto);

    ResponseEntity<ScenarioSite> deleteSite(Long idSceanrio);

    List<ScenarioPrcocessDto> getScenarioPocessus();

    List<ScenarioActiviteDto> getScenarioActivite();

    List<ScenarioDirectionDto> getScenarioDirection();

    List<ScenarioServiceDto> getScenarioServices();

    ResponseEntity<ScenarioProcessus> deleteProcessus(Long idSceanrio);

    ResponseEntity<ScenarioActivite> deleteActivite(Long idSceanrio);

    ResponseEntity<ScenarioDirection> deleteDirection(Long idSceanrio);

    ResponseEntity<ScenarioService> deleteServices(Long idSceanrio);

    ScenarioSite getSecenarioSite(Long idScenrio);

    ScenarioProcessus getSecenarioProcessus(Long idScenrio);

    ScenarioActivite getSecenarioActivite(Long idScenrio);
    ScenarioService getSecenarioService(Long idScenrio);

    ScenarioDirection getSecenarioDirection(Long idScenrio);


}
