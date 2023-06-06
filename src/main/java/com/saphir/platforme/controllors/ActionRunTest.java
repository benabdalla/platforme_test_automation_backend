package com.saphir.platforme.controllors;


import com.saphir.platforme.dto.ActionDto;
import com.saphir.platforme.entity.Action;
import com.saphir.platforme.repository.IActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v2/actions")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ActionRunTest {
public static  Action action;
    @Autowired
    IActionRepository iActionRepository;

    private static void printLines(String cmd, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(cmd + " " + line);
        }
    }

    private static void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
    }

    @PostMapping()
    @ResponseBody
    public Action addAction(@RequestBody ActionDto action) throws Exception {

        return iActionRepository.addAction(action);
    }

    @GetMapping
    public List<ActionDto> getallAction() {
        return iActionRepository.getAllAction();
    }

    @GetMapping("/{id}")
    public void findById(@PathVariable long id) throws Exception {
        // public static List<Action> actionList;
        //actionList = serviceAction.getAllAction();
       action =new  Action();
        //20002
        action=iActionRepository.findActionByIDScenario(id);
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

}