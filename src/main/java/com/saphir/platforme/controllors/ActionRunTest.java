package com.saphir.platforme.controllors;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/controller/action/")
public class ActionRunTest {



    @GetMapping("/{id}")
    public void findById(@PathVariable long id) throws Exception {
       // public static List<Action> actionList;
        //actionList = serviceAction.getAllAction();

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

}