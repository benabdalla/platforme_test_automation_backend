package com.saphir.platforme.controllors;

import com.saphir.platforme.dto.*;
import com.saphir.platforme.entity.Action;
import com.saphir.platforme.entity.Parametrage;
import com.saphir.platforme.entity.Processus;
import com.saphir.platforme.entity.Site;
import com.saphir.platforme.mapper.ActiviteMapper;
import com.saphir.platforme.mapper.DirectionMapper;
import com.saphir.platforme.mapper.ParametrageMapper;
import com.saphir.platforme.mapper.TabServiceMapper;
import com.saphir.platforme.repository.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api/v3/paremetrage")
public class ParametrageController {

    @Autowired
    IParametreRepository iParametreRepository;


    @Autowired
    ITabServiceRepository itabServiceRepository;
    @Autowired
    IDirectionRepository directionRepository;
    @Autowired
    IActiviteRepository activiteRepository;


    @PostMapping()
    @ResponseBody
    public ParametrageDto addParametrage(@RequestBody ParametrageDto parametrageDto) throws Exception {

        return iParametreRepository.addParametrage(parametrageDto);
    }

    @GetMapping(value = "site")
    public List<Site> sites() {
        return iParametreRepository.getAllSite();
    }

    @GetMapping(value = "processus")
    public List<Processus> processus() {
        return iParametreRepository.getAllProcessus();
    }

    @PutMapping("modif")
    public ParametrageDto modifParamtere(@RequestBody ParametrageDto parametrageDto) throws NotFoundException {
        return iParametreRepository.modifiyParametrage(parametrageDto);
    }

    @GetMapping(value = "parametre")
    public List<ParametrageDto> parametrages() {
        return iParametreRepository.getAllParametrage();
    }
    @GetMapping(value = "get/scenariosite")
    public List<ScenarioSiteDto> getScenrioSite(){
        return iParametreRepository.getSecenarioSite();
    }



    @GetMapping(value = "findpram/{id}")
    public ParametrageDto parametrage(@PathVariable long id) {
        return iParametreRepository.getParametrage(id);
    }

    @GetMapping(value = "direction")
    public List<DirectionDto> directions() {
        return directionRepository.getDirections();

    }

    @GetMapping(value = "serviceApi")
    public List<TabServiceDto> listService() {
        return itabServiceRepository.getServices();

    }

    @GetMapping(value = "activite")
    public List<ActiviteDto> activites() {
        return activiteRepository.getActivites();

    }
    @DeleteMapping("delete/site/{id}")
    public void deletesite(@PathVariable long id) throws Exception {
        iParametreRepository.deleteSite(id);
    } @DeleteMapping("delete/processus/{id}")
    public void deleteProcesus(@PathVariable long id) throws Exception {
        iParametreRepository.deleteProcessus(id);
    } @DeleteMapping("delete/activite/{id}")
    public void deleteActivite(@PathVariable long id) throws Exception {
        iParametreRepository.deleteActivite(id);
    }
    @DeleteMapping("delete/direction/{id}")
    public void deleteDirection(@PathVariable long id) throws Exception {
        iParametreRepository.deleteDirection(id);
    } @DeleteMapping("delete/service/{id}")
    public void deleteServices(@PathVariable long id) throws Exception {
        iParametreRepository.deleteServices(id);
    }


    @PostMapping("add/site")
    @ResponseBody
    public ScenarioSiteDto addSite(@RequestBody ScenarioSiteDto site) throws Exception {

        return iParametreRepository.addSite( site);
    }
    @PostMapping("add/processus")
    @ResponseBody
    public ProcessusDto addProcessus(@RequestBody ProcessusDto processusDto) throws Exception {

        return iParametreRepository.addprocessus(processusDto);
    }
    @PostMapping("add/activite")
    @ResponseBody
    public ActiviteDto addActivite(@RequestBody ActiviteDto activiteDto) throws Exception {

        return iParametreRepository.acdactivite(activiteDto);
    }
    @PostMapping("add/direction")
    @ResponseBody
    public DirectionDto addDiretion(@RequestBody DirectionDto directionDto) throws Exception {

        return iParametreRepository.addDirection(directionDto);
    }
    @PostMapping("add/service")
    @ResponseBody
    public TabServiceDto addService(@RequestBody TabServiceDto tabServiceDto) throws Exception {

        return iParametreRepository.addService(tabServiceDto);
    }






}
