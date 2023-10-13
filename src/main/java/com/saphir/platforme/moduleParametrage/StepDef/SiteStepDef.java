package com.saphir.platforme.moduleParametrage.StepDef;

import com.github.javafaker.Faker;
import com.saphir.platforme.authentification.models.AuthentificationModel;
import com.saphir.platforme.authentification.pages.AuthentificationPage;
import com.saphir.platforme.controllors.ParametrageController;
import com.saphir.platforme.entity.ScenarioSite;
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

public class SiteStepDef {
    public static WebDriver driver;
    public static String site;
    static ScenarioSite scenarioSite;

    public SiteStepDef() {
        scenarioSite = ParametrageController.scenarioSite;
        driver = Setup.driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, AuthentificationPage.class);
        PageFactory.initElements(driver, FicheActionPage.class);
        PageFactory.initElements(driver, SitePage.class);
    }


    @When("Connecter en tant declencheur que de  site")
    public void connecter_en_tant_declencheur_que_de_site() throws Exception {
        AuthentificationModel.saisirLogin(scenarioSite.getDechlencheur().getLogin());


        Thread.sleep(200L);
        AuthentificationModel.saisirPW(scenarioSite.getDechlencheur().getPassword());


    }

    @When("saisir site filaile declencheur")
    public void saisir_site_filaile_declencheur() throws InterruptedException {
        DesignePaterne.selectFilaile(scenarioSite.getFilialeDeclencheur(), driver);
    }

    @When("Consulter  GRH site")
    public void consulter_grh_site() throws Exception {
        if (!scenarioSite.getFilialeDeclencheur().equals("Group")) {
            Thread.sleep(1000L);
            //FicheActionPage.menuID.click();
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", FicheActionPage.menuID);
            Thread.sleep(200L);
            Common.AccéderModule(12, 0, 0, driver);
            Common.AccéderModule(12, 1, 9, driver);
        } else {
            Thread.sleep(1000L);
            //FicheActionPage.menuID.click();
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", FicheActionPage.menuID);
            Thread.sleep(200L);
            Common.AccéderModule(6, 0, 0, driver);
            Common.AccéderModule(6, 1, 4, driver);

        }

    }

    @When("Ajouter   site")
    public void ajouter_site() throws InterruptedException {
        site = scenarioSite.getSite().getSite();
        boolean verife = DesignePaterne.verfierAjoute("ctl00_ContentPlaceHolder1_TextBox1", "ctl00_ContentPlaceHolder1_Filtre_Rechercher", "ctl00_ContentPlaceHolder1_GridView1", site, driver);
        if (!verife) {
            SitePage.btnAjout.click();
            DesignePaterne.waitForVisibility(SitePage.textSite, driver);
            Thread.sleep(500);
            DesignePaterne.javascriptSendKyes(site, SitePage.textSite);
            //    SitePage.textSite.sendKeys(site);
            Faker faker = new Faker();
            SitePage.textAbrevation.sendKeys(faker.lorem().word());
            DesignePaterne.javascriptSendKyes(faker.lorem().word(), SitePage.textAbrevation);
            SitePage.btnValider.click();
            SitePage.btnRetour.click();


        }
    }


    @Then("Vérifier  site à éte ajouter")
    public void vérifier_site_à_éte_ajouter() throws InterruptedException {

        boolean verife = DesignePaterne.verfierAjoute("ctl00_ContentPlaceHolder1_TextBox1", "ctl00_ContentPlaceHolder1_Filtre_Rechercher", "ctl00_ContentPlaceHolder1_GridView1", site, driver);
        Assert.assertTrue(verife, "le site  n'est pas  ajouté");
    }


}
