package com.saphir.platforme.moduleAction.stepdefs;


import com.saphir.platforme.moduleAction.models.ReportingModel;
import com.saphir.platforme.moduleAction.pages.FicheActionPage;
import com.saphir.platforme.moduleAction.pages.ReportingPage;
import com.saphir.platforme.utils.Common;
import com.saphir.platforme.utils.ExcelUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReportingStepDef {

    public static String lan;
    public static int row = 0;
    public static String module = "";
    private static final String Path = "src/main/resources/testData/TestData.xlsx";
    public WebDriver driver;


    @PostConstruct
    private void init() {
 //       driver = WebDriverConfig.driver;
        PageFactory.initElements(driver, FicheActionPage.class);
        // PageFactory.initElements(driver, PageSommerAgenda.class);
        PageFactory.initElements(driver, ReportingPage.class);
    }


    @When("Consulter reporting Nombre d'actions par type")
    public void consulter_reporting_Nombre_d_actions_par_type() throws InterruptedException {

        ReportingModel.consulter_reporting_Nombre_d_actions_par_type(driver);


    }

    @When("choisir {string} de regroupement des actions par type")
    public void choisir_de_regroupement_des_actions_par_type(String string) {

        ReportingModel.choisir_de_regroupement_des_actions_par_type(string);

    }

    @When("récupérer filtre reporting liste des actions")
    public void récupérer_filtre_reporting_liste_des_actions() throws Throwable {
        ReportingModel.récupérer_filtre_reporting_liste_des_actions_par_type(driver, row);
    }

    @When("saisir filtre reporting liste des actions")
    public void saisir_filtre_reporting_liste_des_actions() throws Throwable {
        ReportingModel.saisir_filtre_reporting_liste_des_actions_par_type(driver);
    }


    @When("vérifier les données rapport liste des actions par type")
    public void vérifier_les_données_rapport_liste_des_actions_par_type() throws IOException, InterruptedException {
        ReportingModel.vérifier_les_données_rapport_liste_des_actions_par_type(driver);

    }

    @When("Consulter reporting Nombre d'actions par source")
    public void consulter_reporting_Nombre_d_actions_par_source() throws InterruptedException {
        ReportingModel.consulter_reporting_Nombre_d_actions_par_source(driver);
    }


    @Then("vérifier les données rapport liste des actions par source")
    public void vérifier_les_données_rapport_liste_des_actions_par_source() throws InterruptedException, IOException {
        ReportingModel.vérifier_les_données_rapport_liste_des_actions_par_source(driver);
    }


    @When("choisir {string} de regroupement Etat des actions par responsable")
    public void choisir_de_regroupement_Etat_des_actions_par_responsable(String string) throws InterruptedException {
        Thread.sleep(3000);
        Select respoReal = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_tb_respreal")));
        respoReal.selectByValue(string);
    }

    @Then("vérifier les données rapport des actions par responsable")
    public void vérifier_les_données_rapport_des_actions_par_responsable() throws Throwable {

        String name1 = "Etat_action";
        ExcelUtils.setExcelFile(Path, "Action");
        List<String> data = new ArrayList<String>();
        ExcelUtils.setExcelFile(Path, "Action");
        // RespoReal
        data.add(ExcelUtils.getCellData(row, 4));
        //number  of action  paln
        data.add("1");
        //taux
        data.add(ExcelUtils.getCellData(row, 20));
        //taux
        data.add("100");
        Common.Vérifier_liste_données(name1, data);
    }

    @When("^saisir (\\d+) demande action reporting$")
    public void saisir_demande_action_reporting(int arg1) throws Throwable {
        row = arg1;
        System.out.println(" numero de  ligne  et  : " + row);
    }

    @Then("refusées Demande Action par les responsable")
    public void refusées_Demande_Action_par_les_responsable() throws Throwable {
        ReportingModel.refusées_Demande_Action_par_les_responsable(driver);

    }

    @Then("Verifier Demande Action refusées")
    public void verifier_Demande_Action_refusées() throws InterruptedException {
        ReportingModel.verifier_Demande_Action_refusées(driver);
    }

    @When("Consulter reporting de historique demandes refusées")
    public void consulter_reporting_de_historique_demandes_refusées() throws InterruptedException {
        ReportingModel.consulter_reporting_de_historique_demandes_refusées(driver);

    }

    @Then("verifier le demande Action dans reporting historique demandes refusées")
    public void verifier_le_demande_Action_dans_reporting_historique_demandes_refusées() throws Throwable {
        ReportingModel.verifier_le_demande_Action_dans_reporting_historique_demandes_refusées(driver, row);
    }

    @When("cliquer sur etat des sous actions par Processus")
    public void cliquer_sur_etat_des_sous_actions_par_Processus() throws InterruptedException {
        ReportingModel.cliquer_sur_etat_des_sous_actions_par_Processus(driver);
    }

    @When("choisir {string} de réalisation des actions par processus")
    public void choisir_de_réalisation_des_actions_par_processus(String string) {
        if (string.equals("REALISEE")) {
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_cloP")).
                    findElement(By.id("ctl00_ContentPlaceHolder1_cloP_1")).click();
        } else {
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_cloP")).
                    findElement(By.id("ctl00_ContentPlaceHolder1_cloP_0")).click();
        }
    }

    @When("choisir {string} de cloture des actions par  processus")
    public void choisir_de_cloture_des_actions_par_processus(String string) throws InterruptedException {
//
        System.out.println("Cloture :" + string);
        if (string.equals("CLOTUREE")) {
            // driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList1_1")).click();
            Thread.sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()", driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList1_1")));
            System.out.println("OUI :" + string);
            System.out.println("eleme is selected   :" + driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList1_1")).isSelected());

        } else {
            //driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList1_0")).click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()", driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList1_0")));
            System.out.println("NON :" + string);
            System.out.println("eleme is selected   :" + driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList1_0")).isSelected());

        }
    }

    @When("choisir {string} de regroupement des actions par processus")
    public void choisir_de_regroupement_des_actions_par_processus(String string) {
        if (string.equals("oui")) {
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_CheckBox1")).click();
        }

    }

    @When("saisir {int} d'action  des sous actions par Priorite")
    public void saisir_d_action_des_sous_actions_par_Priorite(Integer int1) {
        row = int1;

    }

    @Then("vérifier les données rapport liste des sous actions par Priorite")
    public void vérifier_les_données_rapport_liste_des_sous_actions_par_Priorite() throws Throwable {
        String name1 = "bilan_action_par_priorite";
        ExcelUtils.setExcelFile(Path, "Action");
        String num_action = ExcelUtils.getCellData(1, 7);
        Common.Vérifier_données(name1, num_action);

    }

    @When("Consulter reporting sous action par priorité")
    public void consulter_reporting_sous_action_par_priorité() throws InterruptedException {
        ReportingModel.consulter_reporting_sous_action_par_priorité(driver);
    }

    @When("récupérer filtre reporting liste des sous actions par Priorite")
    public void récupérer_filtre_reporting_liste_des_sous_actions_par_Priorite() throws Exception {
        ReportingModel.récupérer_filtre_reporting_liste_des_sous_actions_par_Priorite(row);
    }
    // -------------------------->  Produit

    @When("saisir {int} d'action  des sous actions par produit")
    public void saisir_d_action_des_sous_actions_par_produit(Integer int1) {
        row = int1;

    }

    @When("Consulter reporting liste des  sous actions par produit")
    public void consulter_reporting_liste_des_sous_actions_par_produit() throws InterruptedException {
        ReportingModel.consulter_reporting_liste_des_sous_actions_par_produit(driver);

    }

    @When("récupérer filtre reporting liste des sous actions par produit")
    public void récupérer_filtre_reporting_liste_des_sous_actions_par_produit() throws Exception {
        ReportingModel.récupérer_filtre_reporting_liste_des_sous_actions_par_produit(driver, row);

    }

    @Then("vérifier les données rapport liste des sous actions par produit")
    public void vérifier_les_données_rapport_liste_des_sous_actions_par_produit() throws Throwable {
        ReportingModel.vérifier_les_données_rapport_liste_des_sous_actions_par_produit(driver, row);

    }

    @When("Consulter reporting Etat d'avancement des plans d'actions")
    public void consulter_reporting_Etat_d_avancement_des_plans_d_actions() throws InterruptedException {
        ReportingModel.consulter_reporting_Etat_d_avancement_des_plans_d_actions(driver);
    }

    @When("récupérer filtre reporting liste Etat d'avancement des plans d'actions")
    public void récupérer_filtre_reporting_liste_Etat_d_avancement_des_plans_d_actions() throws Throwable {
        ReportingModel.récupérer_filtre_reporting_liste_Etat_d_avancement_des_plans_d_actions(row);
    }

    @When("saisir filtre reporting Etat d'avancement des plans d'actions")
    public void saisir_filtre_reporting_Etat_d_avancement_des_plans_d_actions() throws Throwable {
        ReportingModel.saisir_filtre_reporting_Etat_d_avancement_des_plans_d_actions(driver);
    }

    @When("choisir {string} de regroupement Etat d'avancement des plans d'actions")
    public void choisir_de_regroupement_Etat_d_avancement_des_plans_d_actions(String string) throws Throwable {
        ReportingModel.choisir_de_regroupement_Etat_d_avancement_des_plans_d_actions(string, driver);
    }

    @Then("vérifier les données rapport Etat d'avancement des plans d'actions")
    public void vérifier_les_données_rapport_Etat_d_avancement_des_plans_d_actions() throws Throwable {
        ReportingModel.vérifier_les_données_rapport_Etat_d_avancement_des_plans_d_actions(row, driver);
    }

}
