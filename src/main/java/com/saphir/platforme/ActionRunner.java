package com.saphir.platforme;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.boot.test.context.SpringBootTest;


@CucumberOptions(
        features = {"src/main/java/com/saphir/platforme/features/moduleAction/Action.feature"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json", "junit:target/cucumber.xml",
        },
        glue = {"com.saphir.platforme"},
        tags = "@FicheActionDetaille",
        //tags ="@ParemétrageFicheActionDetaille or @FicheActionDetaille or @RealisationetSuiviAction or @VérificationActionNonClôturée or @AfficherTracabilite",

        dryRun = false
)
@SpringBootTest
public class ActionRunner extends AbstractTestNGCucumberTests {

}