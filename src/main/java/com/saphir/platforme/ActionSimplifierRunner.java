package com.saphir.platforme;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

//
//@CucumberOptions(
//        features = {"src/main/java/com/saphir/platforme/features/moduleAction/ActionSimp.feature"},
//        monochrome = true,
//        plugin = {"pretty", "html:target/Reporting/action-simplifier-cucumber-reports/cucumber-html-report", "json:target/Reporting/action-simplifier-cucumber-reports/action.json", "junit:target/Reporting/action-simplifier-cucumber-reports/action.xml"},
//        glue = "com.saphir.platforme",
//tags = "@",
//        dryRun = false
//)
@CucumberOptions(
        features = {"src/main/java/com/saphir/platforme/features/moduleAction/ActionSimp.feature"},
        monochrome = true,
        plugin = {"pretty", "html:target/Reporting/action-cucumber-reports/cucumber-html-report", "json:target/Reporting/action-cucumber-reports/action.json", "junit:target/Reporting/action-cucumber-reports/action.xml"},
        glue = "com.saphir.platforme",
        dryRun = false)
public class ActionSimplifierRunner extends AbstractTestNGCucumberTests {


    @AfterSuite
    public void generateReport() {

        String outputDirectory = "target/Reporting/action-simplifier-cucumber-reports";
        String reportName = "action-simplifier-cucumber-reports";
        //
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
        //reportBuilder.generateReports();


//        Configuration configuration = new Configuration(new File("target/cucumber-reports"), "Your Project Name");
//        ReportBuilder reportBuilder = new ReportBuilder(Collections.singletonList("target/cucumber-reports/action.json"), configuration);
//        reportBuilder.generateReports();
    }

}