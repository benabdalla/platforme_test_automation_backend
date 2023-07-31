package com.saphir.platforme.controllors;

import com.saphir.platforme.dto.*;
import com.saphir.platforme.entity.*;
import com.saphir.platforme.repository.IActiviteRepository;
import com.saphir.platforme.repository.IDirectionRepository;
import com.saphir.platforme.repository.IParametreRepository;
import com.saphir.platforme.repository.ITabServiceRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api/v3/paremetrage")
public class ParametrageController {

    public static ScenarioProcessus scenarioProcessus;
    public static ScenarioActivite scenarioActivite;
    public static ScenarioSite scenarioSite;
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
    public List<ScenarioSiteDto> getScenrioSite() {
        return iParametreRepository.getSecenarioSite();

    }

    @GetMapping(value = "get/scenarioactivite")
    public List<ScenarioActiviteDto> getScenrioActivite() {
        return iParametreRepository.getScenarioActivite();
    }

    @GetMapping(value = "get/scenarioprocessus")
    public List<ScenarioPrcocessDto> getScenrioProcessus() {
        return iParametreRepository.getScenarioPocessus();
    }

    @GetMapping(value = "get/scenarioservice")
    public List<ScenarioServiceDto> getScenrioScervice() {
        return iParametreRepository.getScenarioServices();
    }

    @GetMapping(value = "get/scenariodirection")
    public List<ScenarioDirectionDto> getScenrioDirectionDtos() {
        return iParametreRepository.getScenarioDirection();
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
    }

    @DeleteMapping("delete/processus/{id}")
    public void deleteProcesus(@PathVariable long id) throws Exception {
        iParametreRepository.deleteProcessus(id);
    }

    @DeleteMapping("delete/activite/{id}")
    public void deleteActivite(@PathVariable long id) throws Exception {
        iParametreRepository.deleteActivite(id);
    }

    @DeleteMapping("delete/direction/{id}")
    public void deleteDirection(@PathVariable long id) throws Exception {
        iParametreRepository.deleteDirection(id);
    }

    @DeleteMapping("delete/service/{id}")
    public void deleteServices(@PathVariable long id) throws Exception {
        iParametreRepository.deleteServices(id);
    }


    @PostMapping("add/site")
    @ResponseBody
    public ScenarioSiteDto addSite(@RequestBody ScenarioSiteDto site) throws Exception {

        return iParametreRepository.addSite(site);
    }

    @PostMapping("add/processus")
    @ResponseBody
    public ScenarioPrcocessDto addProcessus(@RequestBody ScenarioPrcocessDto processusDto) throws Exception {

        return iParametreRepository.addprocessus(processusDto);
    }

    @PostMapping("add/activite")
    @ResponseBody
    public ScenarioActiviteDto addActivite(@RequestBody ScenarioActiviteDto activiteDto) throws Exception {

        return iParametreRepository.acdactivite(activiteDto);
    }

    @PostMapping("add/direction")
    @ResponseBody
    public ScenarioDirectionDto addDiretion(@RequestBody ScenarioDirectionDto directionDto) throws Exception {

        return iParametreRepository.addDirection(directionDto);
    }

    @PostMapping("add/service")
    @ResponseBody
    public ScenarioServiceDto addService(@RequestBody ScenarioServiceDto tabServiceDto) throws Exception {

        return iParametreRepository.addService(tabServiceDto);
    }


    @GetMapping(value = "find/scenariosite/{idScenrio}")
    public String findById(@PathVariable long idScenrio) {

        scenarioSite = iParametreRepository.getSecenarioSite(idScenrio);
        System.err.println("tesssssst" + idScenrio);
        //  System.err.println("list  =" + actionList.get(0));
        // Create TestNG object
        TestNG testng = new TestNG();

        // Create a list of XML suites to run
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        XmlSuite suite = new XmlSuite();
        suite.setSuiteFiles(Collections.singletonList("parametrage/site.xml"));
        suites.add(suite);

        // Set the list of suites to TestNG object
        testng.setXmlSuites(suites);

        // Run the tests
        testng.run();
return "ok";
    }

    @GetMapping(value = "find/scenarioprocessus")
    public void getScenrioProcessus(Long idScenrio) {

        scenarioProcessus = iParametreRepository.getSecenarioProcessus(idScenrio);
        System.err.println("tesssssst" + idScenrio);
        //  System.err.println("list  =" + actionList.get(0));
        // Create TestNG object
        TestNG testng = new TestNG();

        // Create a list of XML suites to run
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        XmlSuite suite = new XmlSuite();
        suite.setSuiteFiles(Collections.singletonList("parametrage/processus.xml"));
        suites.add(suite);

        // Set the list of suites to TestNG object
        testng.setXmlSuites(suites);

        // Run the tests
        testng.run();

    }

    @GetMapping(value = "find/scenarioActivite")
    public void getScenrioActivite(Long idScenrio) {

        scenarioActivite = iParametreRepository.getSecenarioActivite(idScenrio);
        System.err.println("tesssssst" + idScenrio);
        //  System.err.println("list  =" + actionList.get(0));
        // Create TestNG object
        TestNG testng = new TestNG();

        // Create a list of XML suites to run
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        XmlSuite suite = new XmlSuite();
        suite.setSuiteFiles(Collections.singletonList("parametrage/activite.xml"));
        suites.add(suite);

        // Set the list of suites to TestNG object
        testng.setXmlSuites(suites);

        // Run the tests
        testng.run();

    }

}
