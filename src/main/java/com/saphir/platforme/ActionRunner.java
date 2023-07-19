package com.saphir.platforme;

import com.saphir.platforme.entity.Action;
import com.saphir.platforme.repository.IActionRepository;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.saphir.platforme.controllors.ActionRunTest.action;


@CucumberOptions(
        features = {"src/main/java/com/saphir/platforme/features/moduleAction/Action.feature"},
        monochrome = true,
        plugin = {"pretty", "html:target/Reporting/action-cucumber-reports/cucumber-html-report", "json:target/Reporting/action-cucumber-reports/action.json", "junit:target/Reporting/action-cucumber-reports/action.xml"},
        glue = "com.saphir.platforme",
        dryRun = false
)
//@ContextConfiguration
//@ComponentScan("classpath:com.saphir.platforme")
public class ActionRunner extends AbstractTestNGCucumberTests {


    @AfterSuite
    public void generateReport() {

        String outputDirectory = "target/Reporting/action-cucumber-reports";
        String reportName = "action-cucumber-reports";

        // Add cucumber JSON report files to the list
        File reportOutputDirectory = new File(outputDirectory);
        File[] jsonFiles = reportOutputDirectory.listFiles((dir, name) -> name.endsWith(".json"));

        // Convert array of File objects to List of Strings
        List<String> jsonFilePaths = new ArrayList<>();
        for (File file : jsonFiles) {
            jsonFilePaths.add(file.getAbsolutePath());
        }

        // Generate the cucumber report with a specific name
        Configuration configuration = new Configuration(reportOutputDirectory, reportName);
        ReportBuilder reportBuilder = new ReportBuilder(jsonFilePaths, configuration);
        reportBuilder.generateReports();



//        Configuration configuration = new Configuration(new File("target/cucumber-reports"), "Your Project Name");
//        ReportBuilder reportBuilder = new ReportBuilder(Collections.singletonList("target/cucumber-reports/action.json"), configuration);
//        reportBuilder.generateReports();
    }

}