package com.saphir.platforme;



import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@CucumberOptions(
monochrome =true,
features = { "src/main/java/com/saphir/platforme/features/Reunion/Reunion.feature" },
		plugin = {"pretty", "html:target/Reporting/reunion-cucumber-reports/cucumber-html-report", "json:target/Reporting/reunion-cucumber-reports/action.json", "junit:target/Reporting/reunion-cucumber-reports/reunion.xml"},
		glue = "com.saphir.platforme",
		dryRun = false,
		tags= "@typeRénion or @reunion or @AgendaReunion"
		//

)

	
	//@Test
	public class ReunionRunner extends AbstractTestNGCucumberTests {



	@AfterSuite
	public void generateReport() {
		String outputDirectory = "target/Reporting/reunion-cucumber-reports";
		String reportName = "reunion-cucumber-reports";

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
