package com.saphir.platforme;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@CucumberOptions(
        features = {"src/main/java/com/saphir/platforme/features/Parametrage/Site.feature"},
        monochrome = true,
        plugin = {"pretty", "html:target/Reporting/activite-cucumber-reports/cucumber-html-report", "json:target/Reporting/activite-cucumber-reports/activite.json", "junit:target/Reporting/activite-cucumber-reports/activite.xml"},
        glue = "com.saphir.platforme",
        dryRun = false, tags = "@Activite"
)

public class ActiviteRunner extends AbstractTestNGCucumberTests {

    @AfterSuite
    public void generateReport() {

        String outputDirectory = "target/Reporting/activite-cucumber-reports";
        String reportName = "activite-cucumber-reports";

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

    }

}