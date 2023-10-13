package com.saphir.platforme.moduleReunion.stepdefs;


import com.saphir.platforme.authentification.pages.AuthentificationPage;
import com.saphir.platforme.controllors.ActionRunTest;
import com.saphir.platforme.controllors.ReunionController;
import com.saphir.platforme.entity.Action;
import com.saphir.platforme.entity.Reunion;
import com.saphir.platforme.moduleAction.pages.FicheActionPage;
import com.saphir.platforme.moduleReunion.models.typeréunionmodel;
import com.saphir.platforme.moduleReunion.pages.ModuleReunionPage;
import com.saphir.platforme.moduleReunion.pages.typeréunionpage;
import com.saphir.platforme.utils.ExcelUtils;
import com.saphir.platforme.utils.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static com.saphir.platforme.moduleReunion.stepdefs.ModuleReunionStepDefinition.row;


public class TypeRéunionStepDef {
    public static WebDriver driver;
    static Reunion reunion;
    private static String Path = "resources/testData/TestData.xlsx";
    private static boolean ok = true;

    public TypeRéunionStepDef() {



        reunion = ReunionController.reunion;
        driver = Setup.driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, typeréunionpage.class);
        PageFactory.initElements(driver, ModuleReunionPage.class);
    }




    @When("^consulter type de réunion$")
    public void consulter_type_de_réunion() throws Throwable {
        typeréunionmodel.Consulter_typ_réunion(driver);
    }

    @When("^ajouter type réunion$")
    public void ajouter_type_réunion() throws Throwable {
        typeréunionmodel.ajouter_type_réunion();
    }

    @When("^saisir type de réunion$")
    public void saisir_type_de_réunion() throws Throwable {
        typeréunionmodel.saisir_type_réunion(reunion.getTypeReunion().getTypeReunion());
    }

    @When("^saisir périodicité$")
    public void saisir_périodicité() throws Throwable {
        typeréunionmodel.saisir_périodicité(reunion.getTypeReunion().getPeriodicite());
    }

    @When("^saisir source$")
    public void saisir_source() throws Throwable {
        typeréunionmodel.saisir_Source();
    }

    @When("^valider type$")
    public void valider_type() throws Throwable {
        typeréunionmodel.valider_typeréunion();


    }


    @Then("^type ajouté$")
    public void type_ajouté() throws Throwable {
        if(ok){
        typeréunionmodel.retour_typeréunion();
        typeréunionmodel.filtre_typeréunion();
        typeréunionmodel.recherche_typeréunion();
        typeréunionmodel.resultat_typeréunion();}
    }

    @Then("Affectation des accès par type de réunion")
    public void affectation_des_accès_par_type_de_réunion() throws Exception {
        try{
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_Ajouter_resp")).click();

        }catch (NoSuchElementException ex){
            ok=false;
        }

if(ok){

        driver.findElement(By.id("ctl00_ContentPlaceHolder1_TextBox33")).sendKeys(reunion.getTypeReunion().getDechlencheur().getName());
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton52")).click();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView_emp")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_emp\"]/tbody/tr[1]/td[1]")).findElement(By.tagName("input")).click();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_Valider_list_resp_reunion")).click();}


    }

    @Then("Affectation de la liste des personnes à informer automatiquement")
    public void affectation_de_la_liste_des_personnes_à_informer_automatiquement() throws Exception {
        if(ok){

        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton2")).click();

        driver.findElement(By.id("ctl00_ContentPlaceHolder1_TextBox7")).sendKeys(reunion.getTypeReunion().getPourInfo().getName());
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton5")).click();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView_Employe")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_Employe\"]/tbody/tr[1]/td[1]")).findElement(By.tagName("input")).click();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton9")).click();}

    }


}
