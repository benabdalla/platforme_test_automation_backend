package com.saphir.platforme.controllors;


import com.saphir.platforme.dto.ReunionDto;
import com.saphir.platforme.dto.ReportDto;
import com.saphir.platforme.entity.Reunion;
import com.saphir.platforme.entity.Reunion;
import com.saphir.platforme.repository.IReunionRepository;
import com.saphir.platforme.repository.IReunionRepository;
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
@RequestMapping("/api/v5/reunion")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ReunionController {
    public static Reunion reunion;
    @Autowired
    IReunionRepository iReunionRepository;

    @Value("${file.report}")
    private String filePath;

    @PostMapping()
    @ResponseBody
    public Reunion addReunion(@RequestBody ReunionDto reunion) throws Exception {

        return iReunionRepository.addReunion(reunion);
    }

    @RequestMapping(value = "all/")
    public List<ReunionDto> getallReunion() {
        return iReunionRepository.getAllReunion();
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
    public ReportDto runReportReunion() throws IOException {
        String url = "Reporting/reunion-cucumber-reports/cucumber-html-reports/overview-tags.html";
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
        reunion = new Reunion();

        //20002
        reunion = iReunionRepository.findReunionByIDScenario(id);
        if (reunion.getEtat() == 0) {
            System.err.println("tesssssst" + id);
            //  System.err.println("list  =" + actionList.get(0));
            // Create TestNG object
            TestNG testng = new TestNG();

            // Create a list of XML suites to run
            List<XmlSuite> suites = new ArrayList<XmlSuite>();
            XmlSuite suite = new XmlSuite();
            suite.setSuiteFiles(Collections.singletonList("Reunion.xml"));
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
            suite.setSuiteFiles(Collections.singletonList("ReunionSpec.xml"));
            suites.add(suite);

            // Set the list of suites to TestNG object
            testng.setXmlSuites(suites);

            // Run the tests
            testng.run();

        }
        iReunionRepository.updateRenuion(reunion);

        return "OK";
        // runProcess("java -cp target/myapp.jar com.swtestacademy.springbootselenium.cucumber.RunCucumberTest.java --testngXmlFile=RunTest.xml");
    }



    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) throws Exception {
        iReunionRepository.deleteRenuion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "update/actiondto")
    public void updateReunion(@PathVariable Reunion reunion) throws Exception {
        iReunionRepository.updateRenuion(reunion);
    }

    @GetMapping("get/reunion/{id}")
    public ReunionDto getReunion(@PathVariable long id) throws Exception {
        return iReunionRepository.getReunionByIDScenario(id);
    }

}