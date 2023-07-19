package com.saphir.platforme.repository;

import com.saphir.platforme.dto.*;
import com.saphir.platforme.entity.*;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IParametreRepository {
    public ParametrageDto addParametrage(ParametrageDto parametrageDto);

    public ParametrageDto modifiyParametrage(ParametrageDto parametrageDto) throws NotFoundException;

    public ParametrageDto deleteParametrage(ParametrageDto parametrageDto);

    public List<ParametrageDto> getAllParametrage();
    public List<Site> getAllSite();
    public List<Processus> getAllProcessus();
    public ParametrageDto getParametrage(Long id );
    public ScenarioSiteDto addSite(ScenarioSiteDto  site);
    public List<ScenarioSiteDto> getSecenarioSite();
    public ProcessusDto addprocessus(ProcessusDto processusDto);
    public ActiviteDto acdactivite(ActiviteDto activiteDto);
    public TabServiceDto addService(TabServiceDto tabServiceDto);
    public DirectionDto addDirection(DirectionDto directionDto);
    ResponseEntity<Site> deleteSite(Long idSceanrio);
    ResponseEntity<Processus> deleteProcessus(Long idSceanrio);
    ResponseEntity<Activite> deleteActivite(Long idSceanrio);
    ResponseEntity<Direction> deleteDirection(Long idSceanrio);
    ResponseEntity<TabService>  deleteServices(Long idSceanrio);


}
