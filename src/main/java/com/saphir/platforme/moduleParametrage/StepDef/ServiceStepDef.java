package com.saphir.platforme.moduleParametrage.StepDef;

import com.github.javafaker.Faker;
import com.saphir.platforme.authentification.models.AuthentificationModel;
import com.saphir.platforme.authentification.pages.AuthentificationPage;
import com.saphir.platforme.controllors.ParametrageController;
import com.saphir.platforme.entity.ScenarioProcessus;
import com.saphir.platforme.entity.ScenarioService;
import com.saphir.platforme.moduleAction.pages.FicheActionPage;
import com.saphir.platforme.moduleParametrage.pages.SitePage;
import com.saphir.platforme.shared.DesignePaterne;
import com.saphir.platforme.utils.Common;
import com.saphir.platforme.utils.Setup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class ServiceStepDef {

    public static WebDriver driver;
    public static String service;
    static ScenarioService scenarioService;

    public ServiceStepDef() {
        scenarioService = ParametrageController.scenarioAService;
        driver = Setup.driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, AuthentificationPage.class);
        PageFactory.initElements(driver, FicheActionPage.class);
        PageFactory.initElements(driver, SitePage.class);
    }


    @When("Connecter en tant declencheur que de  service")
    public void connecter_en_tant_declencheur_que_de_service() throws Exception {
        AuthentificationModel.saisirLogin(scenarioService.getDechlencheur().getLogin());


        Thread.sleep(200L);
        AuthentificationModel.saisirPW(scenarioService.getDechlencheur().getPassword());


    }

    @When("saisir service filaile declencheur")
    public void saisir_service_filaile_declencheur() throws InterruptedException {
        DesignePaterne.selectFilaile(scenarioService.getFilialeDeclencheur(), driver);

    }

    @When("Consulter  GRH service")
    public void consulter_grh_service() throws Exception {
        if (!scenarioService.getFilialeDeclencheur().equals("Group")) {
            Thread.sleep(1000L);
            //FicheActionPage.menuID.click();
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", FicheActionPage.menuID);
            Thread.sleep(200L);
            Common.AccéderModule(12, 0, 0, driver);
            Common.AccéderModule(12, 1, 13, driver);
        } else {
            Thread.sleep(1000L);
            //FicheActionPage.menuID.click();
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", FicheActionPage.menuID);
            Thread.sleep(200L);
            Common.AccéderModule(5, 0, 0, driver);
            Common.AccéderModule(5, 1, 8, driver);

        }
    }

    @When("Ajouter   service")
    public void ajouter_service() throws InterruptedException {
        service = scenarioService.getTabService().getService();
        boolean verife = DesignePaterne.verfierAjoute("ctl00_ContentPlaceHolder1_TextBox1", "ctl00_ContentPlaceHolder1_Filtre_Rechercher", "ctl00_ContentPlaceHolder1_GridView1", service, driver);
        if (!verife) {
            SitePage.btnAjout.click();
            DesignePaterne.waitForVisibility(SitePage.textSite, driver);
            Thread.sleep(500);
            DesignePaterne.javascriptSendKyes(service, SitePage.textSite);
            //    SitePage.textSite.sendKeys(site);
            Faker faker = new Faker();
            SitePage.textAbrevationService.sendKeys(faker.lorem().word());
            DesignePaterne.javascriptSendKyes(faker.lorem().word(), SitePage.textAbrevationService);
            SitePage.btnValider.click();
            SitePage.btnRetour.click();


        }
    }

    @Then("Vérifier  service à éte ajouter")
    public void vérifier_service_à_éte_ajouter() throws InterruptedException {
        boolean verife = DesignePaterne.verfierAjoute("ctl00_ContentPlaceHolder1_TextBox1", "ctl00_ContentPlaceHolder1_Filtre_Rechercher", "ctl00_ContentPlaceHolder1_GridView1", service, driver);
        Assert.assertTrue(verife, "le site  n'est pas  ajouté");
    }

}
