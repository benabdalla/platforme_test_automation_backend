package com.saphir.platforme.controllors;


import com.saphir.platforme.dto.ActionDto;
import com.saphir.platforme.entity.Action;
import com.saphir.platforme.moduleAction.stepdefs.FicheActionStepDefinition;
import com.saphir.platforme.repository.IActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.*;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v2/actions")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ActionRunTest {
    public static Action action;
    @Autowired
    IActionRepository iActionRepository;

    @PostMapping
    @ResponseBody
    public Action addAction(@RequestBody ActionDto action) throws Exception {

        return iActionRepository.addAction(action);
    }

    @GetMapping
    public List<ActionDto> getallAction() {
        return iActionRepository.getAllAction();
    }

    @GetMapping("close/{id}")
    public void closeDriver(@PathVariable long id) throws Exception {
        if (FicheActionStepDefinition.driver != null) {
           try{ FicheActionStepDefinition.driver.close();
            FicheActionStepDefinition.driver.quit();}catch (Exception ep){
           }
            try {
                // Execute the taskkill command to kill all ChromeDriver processes
                Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @GetMapping(value = "/file", produces = MediaType.TEXT_HTML_VALUE)
    public String getFileHtml() throws IOException {
        URL fileUrl = new URL("file:E:/qualipro/trunk/platforme_test_automation_backend/target/cucumber-reports/cucumber-html-reports/overview-features.html");
        Resource resource = new UrlResource(fileUrl);
        return new String(resource.getInputStream().readAllBytes());
    }

    @GetMapping("/{id}")
    public void findById(@PathVariable long id) throws Exception {
        // public static List<Action> actionList;
        //actionList = serviceAction.getAllAction();
        action = new Action();
        //20002
        action = iActionRepository.findActionByIDScenario(id);
        System.err.println("tesssssst" + id);
        //  System.err.println("list  =" + actionList.get(0));
        // Create TestNG object
        TestNG testng = new TestNG();

        // Create a list of XML suites to run
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        XmlSuite suite = new XmlSuite();
        suite.setSuiteFiles(Collections.singletonList("Action.xml"));
        suites.add(suite);

        // Set the list of suites to TestNG object
        testng.setXmlSuites(suites);

        // Run the tests
        testng.run();


        // runProcess("java -cp target/myapp.jar com.swtestacademy.springbootselenium.cucumber.RunCucumberTest.java --testngXmlFile=RunTest.xml");
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(@PathVariable long id) throws Exception {
        iActionRepository.deleteAction(id);
    }

    @PutMapping(value="update/actiondto")
    public void updateAction(@PathVariable Action action) throws Exception {
        iActionRepository.updateAction(action);
    }
    @GetMapping("get/action/{id}")
    public ActionDto getAction(@PathVariable long id) throws Exception {
     return iActionRepository.getActionByIDScenario(id);
    }
}