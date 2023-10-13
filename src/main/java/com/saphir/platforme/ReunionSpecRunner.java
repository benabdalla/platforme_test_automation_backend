package com.saphir.platforme;


import com.saphir.platforme.repository.IActionRepository;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@CucumberOptions(
monochrome =true,
features = { "src/main/java/com/saphir/platforme/features/Reunion/Reunion.feature" }, plugin = {
		"pretty","html:target/cucumber-html-report", "json:target/cucumber.json", "junit:target/cucumber.xml"},
dryRun= false,
		tags= "@typeRénion or @reunion or @AgendaReunion"

)

	
	//@Test
	public class ReunionSpecRunner extends AbstractTestNGCucumberTests {

	@Autowired
	IActionRepository iActionRepository;

	@AfterSuite
	public void generateReport() {

		//  DesignePaterne.deleteFilesInDirectory("E:\\qualipro\\trunk\\platforme_test_automation_backend\\target\\Reporting\\action-cucumber-reports\\cucumber-html-reports");
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
