package com.saphir.platforme;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;


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
@ContextConfiguration
@ComponentScan("classpath:cucumber.glue")
public class ActionRunner extends AbstractTestNGCucumberTests {

}