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
import java.util.Collections;

import static com.saphir.platforme.controllors.ActionRunTest.action;


@CucumberOptions(
        features = {"src/main/java/com/saphir/platforme/features/moduleAction/Action.feature"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-reports/action.json", "junit:target/cucumber-reports/action.xml"},
        glue = "com.saphir.platforme",
        //glue = {"com.saphir.platforme"},
        tags = "@SuiviCloture",
       // @ParemétrageFicheActionDetaille or @FicheActionDetaille or @RealisationAction or @RealisationAction or @SuiviAction or @RealisationActionRetour or @SuiviActionRetour
        //tags ="@ParemétrageFicheActionDetaille or @FicheActionDetaille or @RealisationetSuiviAction or @VérificationActionNonClôturée or @AfficherTracabilite",

        dryRun = false
)
//@ContextConfiguration
//@ComponentScan("classpath:com.saphir.platforme")
public class ActionRunner extends AbstractTestNGCucumberTests {
    @Autowired
    IActionRepository iActionRepository;

    @AfterSuite
    public void generateReport() {
        Configuration configuration = new Configuration(new File("target/cucumber-reports"), "Your Project Name");
        ReportBuilder reportBuilder = new ReportBuilder(Collections.singletonList("target/cucumber-reports/action.json"), configuration);
        reportBuilder.generateReports();
    }

}