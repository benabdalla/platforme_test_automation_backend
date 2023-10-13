package com.saphir.platforme.controllors;


import com.saphir.platforme.dto.ActionDto;
import com.saphir.platforme.dto.ReportDto;
import com.saphir.platforme.entity.Action;
import com.saphir.platforme.repository.IActionRepository;
import com.saphir.platforme.shared.DesignePaterne;
import com.saphir.platforme.utils.Setup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v2/actions")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ActionRunTest {
    public static Action action;
    @Autowired
    IActionRepository iActionRepository;
    @Value("${file.report}")
    private String filePath;

    @PostMapping
    @ResponseBody
    public Action addAction(@RequestBody ActionDto action) throws Exception {

        return iActionRepository.addAction(action);
    }

    @RequestMapping(value = "all/{id}")
    public List<ActionDto> getallAction(@PathVariable int id) {
        return iActionRepository.getAllAction(id);

    }

    @GetMapping("close/{id}")
    public String closeDriver(@PathVariable long id, HttpServletRequest request, HttpServletResponse response) throws Exception {


            if (Setup.driver != null) {
                try {
                    Setup.driver.close();
                    Setup.driver.quit();
                } catch (Exception ep) {
                }
                try {
                    // Execute the taskkill command to kill all ChromeDriver processes
                    Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        // Send the API response
      //  response.getWriter().println("API response");
       // asyncContext.complete(); // Complete the asynchronous context
return "Ok";

    }


    @GetMapping("/report")
    public ReportDto runReportAction() throws IOException {
        String url = "Reporting/action-cucumber-reports/cucumber-html-reports/overview-tags.html";
        String  filesPath=filePath+url;
        ReportDto report = new ReportDto();
        if(DesignePaterne.fileExists(filePath+url)){
            report.setSrcFrame(url);
        }else{
            report.setSrcFrame("404");
        }



        return report;
    }
    @GetMapping("/report/simplifier")
    public ReportDto reportActionsimplifier() throws IOException {
        String url = "Reporting/simplifier-cucumber-reports/cucumber-html-reports/overview-tags.html";
        String  filesPath=filePath+url;
        ReportDto report = new ReportDto();
        if(DesignePaterne.fileExists(filesPath)){
            report.setSrcFrame(url);
        }else{
            report.setSrcFrame("404");
        }
        return report;
    }


    @GetMapping("/{id}")
    public String  findById(@PathVariable long id) throws Exception {
        // public static List<Action> actionList;
        //actionList = serviceAction.getAllAction();
        action = new Action();

        //20002
        action = iActionRepository.findActionByIDScenario(id);
        if (action.getEtat() == 1) {
            System.err.println("tesssssst" + id);
            //  System.err.println("list  =" + actionList.get(0));
            // Create TestNG object
            TestNG testng = new TestNG();

            // Create a list of XML suites to run
            List<XmlSuite> suites = new ArrayList<XmlSuite>();
            XmlSuite suite = new XmlSuite();
            suite.setSuiteFiles(Collections.singletonList("ActionDetails.xml"));
            suites.add(suite);

            // Set the list of suites to TestNG object
            testng.setXmlSuites(suites);

            // Run the tests
            testng.run();

        } else {
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

        }
        iActionRepository.updateAction(action);
        return "OK";
        // runProcess("java -cp target/myapp.jar com.swtestacademy.springbootselenium.cucumber.RunCucumberTest.java --testngXmlFile=RunTest.xml");
    }

    @GetMapping("run/simplifier/{id}")
    public String actionSimplifier(@PathVariable long id) throws Exception {
        // public static List<Action> actionList;
        //actionList = serviceAction.getAllAction();
        action = new Action();

        //20002
        action = iActionRepository.findActionByIDScenario(id);
        if (action.getEtat() == 1) {

            System.err.println("tesssssst" + id);
            //  System.err.println("list  =" + actionList.get(0));
            // Create TestNG object
            TestNG testng = new TestNG();

            // Create a list of XML suites to run
            List<XmlSuite> suites = new ArrayList<XmlSuite>();
            XmlSuite suite = new XmlSuite();
            suite.setSuiteFiles(Collections.singletonList("ActionSimplifierSpec.xml"));
            suites.add(suite);

            // Set the list of suites to TestNG object
            testng.setXmlSuites(suites);

            // Run the tests
            testng.run();

        } else {
            System.err.println("tesssssst" + id);
            //  System.err.println("list  =" + actionList.get(0));
            // Create TestNG object
            TestNG testng = new TestNG();

            // Create a list of XML suites to run
            List<XmlSuite> suites = new ArrayList<XmlSuite>();
            XmlSuite suite = new XmlSuite();
            suite.setSuiteFiles(Collections.singletonList("ActionSimplifier.xml"));
            suites.add(suite);

            // Set the list of suites to TestNG object
            testng.setXmlSuites(suites);

            // Run the tests
            testng.run();

        }
        iActionRepository.updateAction(action);
        return "Ok";
        // runProcess("java -cp target/myapp.jar com.swtestacademy.springbootselenium.cucumber.RunCucumberTest.java --testngXmlFile=RunTest.xml");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) throws Exception {
        iActionRepository.deleteAction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "update/actiondto")
    public void updateAction(@PathVariable Action action) throws Exception {
        iActionRepository.updateAction(action);
    }

    @GetMapping("get/action/{id}")
    public ActionDto getAction(@PathVariable long id) throws Exception {
        return iActionRepository.getActionByIDScenario(id);
    }

}