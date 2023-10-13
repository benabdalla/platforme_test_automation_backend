package com.saphir.platforme.controllors;


import com.saphir.platforme.dto.ReportDto;
import com.saphir.platforme.dto.DocumentationDto;
import com.saphir.platforme.entity.Documentation;
import com.saphir.platforme.repository.DocumentationRepository;
import com.saphir.platforme.repository.IDocumentationRepository;
import com.saphir.platforme.shared.DesignePaterne;
import com.saphir.platforme.utils.Setup;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestController

@RequestMapping("/api/v6/documentation")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class DocumentationController {
    public static Documentation documentation;
    @Autowired
    IDocumentationRepository iDocumentationRepository;


    @Value("${file.report}")
    public String filePath;
    @Value("${file.rattacher}")
    public String rattacher;
    private static long idDoc;


    @PostMapping
    @ResponseBody
    public Documentation addDocumentation(@RequestBody DocumentationDto documentation) throws Exception {
        Documentation documentation1 = new Documentation();
        documentation1 = iDocumentationRepository.addDocumentation(documentation);
        idDoc = documentation1.getIdScenario();

        return documentation1;
    }


    @PostMapping(value = "/spec", headers = "content-type=multipart/*", consumes = "application/*")
    public String addSpecDocumentation(
            @RequestParam("file") MultipartFile file) throws Exception {
        //       documentationRepository.save(documentation);
        System.out.print("name " + file.getName());
        try {
            // Get the original filename
            String originalFileName = file.getOriginalFilename();
            // Set the directory where you want to save the file
            String uploadDir = "E:\\qualipro\\trunk\\platforme_test_automation_backend\\resources\\documentRattacher\\";
            // Create the directory if it doesn't exist
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Create a new file in the upload directory
            File serverFile = new File(uploadDir + File.separator + originalFileName);
            String urlPath = "";
            urlPath = serverFile.getAbsolutePath();
            iDocumentationRepository.updatePathDoc(idDoc,urlPath);
            // Save the uploaded file to the server
            file.transferTo(serverFile);
            return "File uploaded successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "File upload failed!";
        }
    }


    @RequestMapping(value = "all/")
    public List<DocumentationDto> getallDocumentation() {
        return iDocumentationRepository.getAllDocumentation();
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
    public ReportDto runReportDocumentation() throws IOException {
        String url = "Reporting/Documentation-cucumber-reports/cucumber-html-reports/overview-tags.html";
        String filesPath = filePath + url;
        ReportDto report = new ReportDto();
        if (DesignePaterne.fileExists(filesPath)) {
            report.setSrcFrame(url);
        } else {
            report.setSrcFrame("404");
        }
        return report;
    }


    @GetMapping("/{id}")
    public String findById(@PathVariable long id) throws Exception {
        // public static List<Action> actionList;
        //actionList = serviceAction.getAllAction();
        documentation = new Documentation();

        //20002
        documentation = iDocumentationRepository.findDocumentationByIDScenario(id);
        if (documentation.getEtat() == 0) {
            System.err.println("tesssssst" + id);
            //  System.err.println("list  =" + actionList.get(0));
            // Create TestNG object
            TestNG testng = new TestNG();

            // Create a list of XML suites to run
            List<XmlSuite> suites = new ArrayList<XmlSuite>();
            XmlSuite suite = new XmlSuite();
            suite.setSuiteFiles(Collections.singletonList("Documntation.xml"));
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
            suite.setSuiteFiles(Collections.singletonList("DocumentationSpec.xml"));
            suites.add(suite);

            // Set the list of suites to TestNG object
            testng.setXmlSuites(suites);

            // Run the tests
            testng.run();

        }
        iDocumentationRepository.updateDocumentation(documentation);

        return "OK";
        // runProcess("java -cp target/myapp.jar com.swtestacademy.springbootselenium.cucumber.RunCucumberTest.java --testngXmlFile=RunTest.xml");
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) throws Exception {
        iDocumentationRepository.deleteDocumentation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "update")
    public void updateDocumentation(@PathVariable Documentation Documentation) throws Exception {
        iDocumentationRepository.updateDocumentation(Documentation);
    }

    @GetMapping("get/documentation/{id}")
    public DocumentationDto getDocumentation(@PathVariable long id) throws Exception {
        return iDocumentationRepository.getDocumentationByIDScenario(id);
    }

}