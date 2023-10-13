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
        features = {"src/main/java/com/saphir/platforme/features/Documentation/CreationDocument.feature"},
        monochrome = true,
        plugin = {"pretty", "html:target/Reporting/documentation-cucumber-reports/cucumber-html-report", "json:target/Reporting/documentation-cucumber-reports/documentation.json", "junit:target/Reporting/documentation-cucumber-reports/documentation.xml"},
        glue = "com.saphir.platforme",
        tags = "@ParemtrageTypeDocument or @BoîteDialogueRédacteurSuperviseur or @DocumentaionRedecteur or @DocumentaionVerificateur or @DocumentaionApprobateur or @DocumentaionDiffusion or @DocumentaionConsulter" ,
       // @ParemtrageTypeDocument or    //" ParemtrageTypeDocument or @BoîteDialogueRédacteurSuperviseur or @DocumentaionRedecteur or @DocumentaionVerificateur or @DocumentaionApprobateur or @DocumentaionDiffusion or @DocumentaionConsulter",

        dryRun = false
)
//@ContextConfiguration
//@ComponentScan("classpath:com.saphir.platforme")
public class DocumentationRunner extends AbstractTestNGCucumberTests {



    @AfterSuite
    public void generateReport() {

      //  DesignePaterne.deleteFilesInDirectory("E:\\qualipro\\trunk\\platforme_test_automation_backend\\target\\Reporting\\action-cucumber-reports\\cucumber-html-reports");
        String outputDirectory = "target/Reporting/documentation-cucumber-reports";
        String reportName = "documentation-cucumber-reports";

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
      //  reportBuilder.generateReports();


    }

}