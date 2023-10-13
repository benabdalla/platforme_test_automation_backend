package com.saphir.platforme.moduleParametrage.StepDef;

import com.github.javafaker.Faker;
import com.saphir.platforme.authentification.models.AuthentificationModel;
import com.saphir.platforme.authentification.pages.AuthentificationPage;
import com.saphir.platforme.controllors.ParametrageController;
import com.saphir.platforme.entity.ScenarioDirection;
import com.saphir.platforme.entity.ScenarioProcessus;
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

public class DirectionStepDef {
    public static WebDriver driver;
    public static String direction;
    static ScenarioDirection scenarioDirection;

    public DirectionStepDef() {
        scenarioDirection = ParametrageController.scenarioDirection;
        driver = Setup.driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, AuthentificationPage.class);
        PageFactory.initElements(driver, FicheActionPage.class);
        PageFactory.initElements(driver, SitePage.class);
    }

    @When("Connecter en tant declencheur que de  direction")
    public void connecter_en_tant_declencheur_que_de_direction() throws Exception {
        AuthentificationModel.saisirLogin(scenarioDirection.getDechlencheur().getLogin());


        Thread.sleep(200L);
        AuthentificationModel.saisirPW(scenarioDirection.getDechlencheur().getPassword());


    }
    @When("saisir direction filaile declencheur")
    public void saisir_direction_filaile_declencheur() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        DesignePaterne.selectFilaile(scenarioDirection.getFilialeDeclencheur(), driver);
    }
    @When("Consulter  GRH direction")
    public void consulter_grh_direction() throws Exception {
        if (!scenarioDirection.getFilialeDeclencheur().equals("Group")) {
            Thread.sleep(1000L);
            //FicheActionPage.menuID.click();
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", FicheActionPage.menuID);
            Thread.sleep(200L);
            Common.AccéderModule(12, 0, 0, driver);
            Common.AccéderModule(12, 1, 12, driver);
        } else {
            Thread.sleep(1000L);
            //FicheActionPage.menuID.click();
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", FicheActionPage.menuID);
            Thread.sleep(200L);
            Common.AccéderModule(6, 0, 0, driver);
            Common.AccéderModule(6, 1, 7, driver);

        }
    }
    @When("Ajouter   direction")
    public void ajouter_direction() throws InterruptedException {
        direction = scenarioDirection.getDirection().getDirection();
        boolean verife = DesignePaterne.verfierAjoute("ctl00_ContentPlaceHolder1_TextBox1", "ctl00_ContentPlaceHolder1_Filtre_Rechercher", "ctl00_ContentPlaceHolder1_GridView1", direction, driver);
        if (!verife) {
            SitePage.btnAjout.click();
            DesignePaterne.waitForVisibility(SitePage.textSite, driver);
            Thread.sleep(500);
            DesignePaterne.javascriptSendKyes(direction, SitePage.textSite);
            //    SitePage.textSite.sendKeys(site);
            Faker faker = new Faker();

            SitePage.directionAbrevation.sendKeys(faker.lorem().word());
            DesignePaterne.javascriptSendKyes(faker.lorem().word(), SitePage.directionAbrevation);
            SitePage.btnValider.click();
            SitePage.btnRetour.click();


        }
    }
    @Then("Vérifier  direction à éte ajouter")
    public void vérifier_direction_à_éte_ajouter() throws InterruptedException {

        boolean verife = DesignePaterne.verfierAjoute("ctl00_ContentPlaceHolder1_TextBox1", "ctl00_ContentPlaceHolder1_Filtre_Rechercher", "ctl00_ContentPlaceHolder1_GridView1", direction, driver);
        Assert.assertTrue(verife, "le site  n'est pas  ajouté");
    }


}
