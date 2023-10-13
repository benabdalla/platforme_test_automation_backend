package com.saphir.platforme.moduleParametrage.StepDef;

import com.github.javafaker.Faker;
import com.saphir.platforme.authentification.models.AuthentificationModel;
import com.saphir.platforme.authentification.pages.AuthentificationPage;
import com.saphir.platforme.controllors.ParametrageController;
import com.saphir.platforme.entity.ScenarioActivite;
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

public class ActiviteStepdef {

    public static WebDriver driver;
    public static String processus;
    static ScenarioActivite scenarioActivite;

    public ActiviteStepdef() {
        scenarioActivite = ParametrageController.scenarioActivite;
        driver = Setup.driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, AuthentificationPage.class);
        PageFactory.initElements(driver, FicheActionPage.class);
        PageFactory.initElements(driver, SitePage.class);
    }

    @When("Connecter en tant declencheur que de  activite")
    public void connecter_en_tant_declencheur_que_de_activite() throws Exception {
        AuthentificationModel.saisirLogin(scenarioActivite.getDechlencheur().getLogin());


        Thread.sleep(200L);
        AuthentificationModel.saisirPW(scenarioActivite.getDechlencheur().getPassword());


    }


    @When("saisir activite filaile declencheur")
    public void saisir_activite_filaile_declencheur() throws InterruptedException {
        DesignePaterne.selectFilaile(scenarioActivite.getFilialeDeclencheur(), driver);

    }

    @When("Consulter  GRH activite")
    public void consulter_grh_activite() throws Exception {
        if (!scenarioActivite.getFilialeDeclencheur().equals("Group")) {
            Thread.sleep(1000L);
            //FicheActionPage.menuID.click();
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", FicheActionPage.menuID);
            Thread.sleep(200L);
            Common.AccéderModule(12, 0, 0, driver);
            Common.AccéderModule(12, 1, 11, driver);
        } else {
            Thread.sleep(1000L);
            //FicheActionPage.menuID.click();
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", FicheActionPage.menuID);
            Thread.sleep(200L);
            Common.AccéderModule(6, 0, 0, driver);
            Common.AccéderModule(6, 1, 6, driver);

        }
    }

    @When("Ajouter   activite")
    public void ajouter_activite() throws InterruptedException {
        processus = scenarioActivite.getActivite().getActivite();
        boolean verife = DesignePaterne.verfierAjoute("ctl00_ContentPlaceHolder1_TextBox1", "ctl00_ContentPlaceHolder1_Filtre_Rechercher", "ctl00_ContentPlaceHolder1_GridView1", processus, driver);
        if (!verife) {
            SitePage.btnAjout.click();
            DesignePaterne.waitForVisibility(SitePage.textSite, driver);
            Thread.sleep(500);
            DesignePaterne.javascriptSendKyes(processus, SitePage.textSite);
            //    SitePage.textSite.sendKeys(site);
            Faker faker = new Faker();
            SitePage.textAbrevationActivite.sendKeys(faker.lorem().word());
            DesignePaterne.javascriptSendKyes(faker.lorem().word(), SitePage.textAbrevationActivite);
            SitePage.btnValider.click();
            SitePage.btnRetour.click();


        }
    }

    @Then("Vérifier  activite à éte ajouter")
    public void vérifier_activite_à_éte_ajouter() throws InterruptedException {
        boolean verife = DesignePaterne.verfierAjoute("ctl00_ContentPlaceHolder1_TextBox1", "ctl00_ContentPlaceHolder1_Filtre_Rechercher", "ctl00_ContentPlaceHolder1_GridView1", processus, driver);
        Assert.assertTrue(verife, "le site  n'est pas  ajouté");
    }





}
