package com.saphir.platforme.moduleAction.stepdefs;


import com.github.javafaker.Faker;
import com.saphir.platforme.authentification.models.AuthentificationModel;
import com.saphir.platforme.authentification.pages.AuthentificationPage;
import com.saphir.platforme.controllors.ActionRunTest;
import com.saphir.platforme.entity.Action;
import com.saphir.platforme.entity.Utilisateur;
import com.saphir.platforme.moduleAction.models.FicheActionModele;
import com.saphir.platforme.moduleAction.pages.FicheActionPage;
import com.saphir.platforme.service.ActionService;
import com.saphir.platforme.service.UtilisateurService;
import com.saphir.platforme.utils.Common;
import com.saphir.platforme.utils.ExcelUtils;
import com.saphir.platforme.utils.Setup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class FicheActionStepDefinition {

    public static int row;
    public static String origine = "";
    public static String fgRespReal = "";
    public static String fgRespSuivi = "";
    public static WebDriver driver;
    public static String lan;
    public static String module = "";
    private static final String Path = "src/main/resources/testData/TestData.xlsx";
    public String NumAction = "";
    public String taux;
    public String filaile = "";
    static Action action;
    @Autowired
    ActionService actionService;
    List<Utilisateur> connexionDTOList;
    @Autowired
    UtilisateurService utilisateurService;
    private boolean Etatcloture;
    private final Common common = new Common();

    public FicheActionStepDefinition(){
        action=  ActionRunTest.action;
        driver = Setup.driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, AuthentificationPage.class);
        PageFactory.initElements(driver, FicheActionPage.class);
    }

    @When("Connecter en tant declencheur que de  action")
    public void connecter_en_tant_declencheur_que_de_action() throws Exception {

        AuthentificationModel.saisirLogin(action.getDechlencheur().getLogin());


        Thread.sleep(200L);
        AuthentificationModel.saisirPW(action.getDechlencheur().getPassword());

    }



    @Given("consulter  types d'action")
    public void consulter_types_d_action() throws Exception {
        FicheActionModele.consulter_types_d_action(driver);
    }


    @Given("Ajouter  types d'action")
    public void ajouter_types_d_action() {
        FicheActionModele.ajouter_types_d_action();
    }


    @Given("saisir  type d'action")
    public void saisir_type_d_action() throws Exception {
        FicheActionModele.saisir_type_d_action(row);
    }


    @Given("clique   sur   valider")
    public void clique_sur_valider() throws Exception {
        FicheActionModele.clique_sur_valider(row);
    }


    @Given("verifier  type d'action")
    public void verifier_type_d_action() throws Exception {
        FicheActionModele.verifier_type_d_action(row, driver);
    }


    @Given("consulter  source d'action")
    public void consulter_source_d_action() throws Exception {
        FicheActionModele.consulter_source_d_action(driver);
    }

    @Given("^ajuter type de causeso$")
    public void ajuter_type_de_causeso() throws Throwable {
        FicheActionModele.ajouter_type_de_causes(driver);
    }


    @Given("Ajouter   source d'action")
    public void ajouter_source_d_action() {
        FicheActionModele.ajouter_source_d_action();
    }


    @Given("saisir   source d'action")
    public void saisir_source_d_action() throws Exception {
        FicheActionModele.saisir_source_d_action();
    }


    @Given("clique    source d'action")
    public void clique_source_d_action() {
        FicheActionModele.clique_source_d_action();
    }


    @Given("verifier   source d'action")
    public void verifier_source_d_action() throws Exception {
        FicheActionModele.verifier_source_d_action(row, driver);
    }


    @Given("^ajouter type de causes$")
    public void ajouter_type_de_causes() throws Throwable {
        FicheActionModele.ajouter_type_de_causes(driver);
    }

    @Given("^saisir  type   de causes$")
    public void saisir_type_de_causes() throws Throwable {
        FicheActionModele.saisir_type_de_causes(row);
    }

    @Given("^verifier type de causes$")
    public void verifier_type_de_causes() throws Throwable {
        FicheActionModele.verifier_type_de_causes(row);
    }

    @Given("^ajouter  priorité$")
    public void ajouter_priorité() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        FicheActionModele.ajouter_priorité(driver);
    }

    @Given("^saisir  priorité$")
    public void saisir_priorité() throws Throwable {
        FicheActionModele.saisir_priorité(row);
    }

    @Given("^verifier priorité$")
    public void verifier_priorité() throws Throwable {
        FicheActionModele.verifier_priorité(row);
    }

    @Given("^ajouter gravité$")
    public void ajouter_gravité() throws Throwable {
        FicheActionModele.ajouter_gravité(driver);
    }
    @Given("^ajouter Responsable Cloture$")
    public void ajouter_Responsable_Cloture() throws Throwable {
        Thread.sleep(2000L);
        //FicheActionPage.menuID.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.menuID);
        Thread.sleep(200L);
        Common.AccéderModule(2, 0, 0, driver);
        Common.AccéderModule(2, 5, 0, driver);
   }

    @Given("^saisir  gravité$")
    public void saisir_gravité() throws Throwable {
        FicheActionModele.saisir_gravité(row);
    }

    @Given("^verifier gravité$")
    public void verifier_gravité() throws Throwable {
        FicheActionModele.verifier_gravité(row);
    }
    @Given("^Saisir Responsable Cloture$")
    public void Saisir_Responsable_Cloture() throws Throwable {
        FicheActionModele.Saisir_Responsable_Cloture(driver);
    }
    @Given("^verifier Responsable Cloture$")
    public void verifier_Responsable_Cloture() throws Throwable {
        FicheActionModele.verifier_Responsable_Cloture(driver);
    }



    @When("^Consulter action a cloture$")
    public void consulter_action_a_cloture() throws Throwable {
        ExcelUtils.setExcelFile(Path, "Action");

        String NumAction = ExcelUtils.getCellData(row, 7);
        FicheActionPage.RechFiltreId.sendKeys(NumAction);
        //FicheActionPage.BtnRechFiltId.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.BtnRechFiltId);
        Thread.sleep(1000L);
        //FicheActionPage.TableFiltreAction.findElement(By.tagName("a")).click();
        executor.executeScript("arguments[0].click()", FicheActionPage.TableFiltreAction.findElement(By.tagName("a")));
        Thread.sleep(1000L);

    }

    @When("^cliquer  sur   action   Cloture$")
    public void cliquer_sur_action_Cloture() throws Throwable {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.WbtnClot);
    }

    @When("^cliquer   sur  non cloture$")
    public void cliquer_sur_non_cloture() throws Throwable {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.wNOClot);
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        Thread.sleep(500);
        FicheActionPage.dateCloture.click();
        Thread.sleep(1000);
        FicheActionPage.choixDateCloture.click();
        Thread.sleep(500);
        FicheActionPage.rapportClotureID.sendKeys("Test Auto");
        executor2.executeScript("arguments[0].click()", FicheActionPage.wBtnValidNOclot);


    }

    @When("^vérfier  etat action Module$")
    public void vérfier_etat_action_Module() throws Throwable {
        ExcelUtils.setExcelFile(Path, "Action");
        String NumAction = ExcelUtils.getCellData(row, 7);
        FicheActionPage.RechFiltreId.sendKeys(NumAction);
        //FicheActionPage.BtnRechFiltId.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.BtnRechFiltId);
        Thread.sleep(1000L);

        //No,NON
        assertTrue("No".equals(FicheActionPage.wstatutClot.getText()) || "NON".equals(FicheActionPage.wstatutClot.getText()));
    }

    @Then("^vérfier etat   action  agenda$")
    public void vérfier_etat_action_agenda() throws Throwable {
        Thread.sleep(1000);
        FicheActionModele.cliqueAgenda(driver);
        Thread.sleep(1000L);

        JavascriptExecutor executor = (JavascriptExecutor) driver;
         executor.executeScript("arguments[0].click()",FicheActionPage.actionRealise);
        int sizeTabClot = FicheActionPage.wtabFGC.findElements(By.tagName("tr")).size();
        for (int i = 1; i <= sizeTabClot; i++) {
            Thread.sleep(500);
            String fgr = FicheActionPage.wtabFGC.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_tab_ActionCloture\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).getText();
            System.err.println("f = " + origine + "  fgr = " + fgr);
            System.err.println("result   =" + origine.equals(fgr));

            if (origine.equals(fgr)) {
                FicheActionPage.wtabFGC.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_tab_ActionCloture\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).click();
                break;
            }
        }

        Thread.sleep(1000L);
        ExcelUtils.setExcelFile(Path, "Action");
        String NumAction = ExcelUtils.getCellData(row, 7);
        System.out.println("Action" + NumAction);
        FicheActionPage.rechercherActionCloturerXpath.findElement(By.tagName("input")).sendKeys(NumAction);
        assertTrue(FicheActionPage.choixActionCloturer.findElement(By.tagName("a")).getText().contains(NumAction));


    }

    @And("^Consulter Action$")
    public void consulter_Action() throws Throwable {
        Thread.sleep(2000L);
        FicheActionModele.consulter_Action(driver);
        Thread.sleep(2000L);
    }

    @When("^saisir (\\d+) action$")
    public void saisir_action(int arg1) throws Throwable {
        row = arg1;
    }




    @And("saisir action filaile declencheur$")
    public void saisir_action_filaile_declencheur() throws InterruptedException {
        filaile =action.getFilialeDeclencheur();
        if(!filaile.equals("Mono")){
        Thread.sleep(2000);
        Select selectOpTGF = new Select((driver.findElement(By.id("ctl00_DDLFiliale"))));
        String gf = selectOpTGF.getFirstSelectedOption().getText();
        if (!filaile.equals(gf)) {
            selectOpTGF.selectByVisibleText(filaile);
        }}

    }
    @And("saisir {string} action filaile")
    public void saisir_action_filaile(String string) throws InterruptedException {
        filaile = string;

        Thread.sleep(2000);
        Select selectOpTGF = new Select((driver.findElement(By.id("ctl00_DDLFiliale"))));
        String gf = selectOpTGF.getFirstSelectedOption().getText();
        if (!filaile.equals(gf)) {
            selectOpTGF.selectByVisibleText(filaile);
        }

    }

    @When("^Saisir a l'origine de l'action$")
    public void saisir_a_l_origine_de_l_action() {
        origine =action.getFilialeDeclencheur();
    }


    @When("^cliquer sur ajouter Action détaillée$")
    public void cliquer_sur_ajouter_Action_détaillée() throws InterruptedException {
        FicheActionModele.ajouter_action_détaillée(driver);
        Thread.sleep(2000L);
    }


    @When("^Ajouter Source$")
    public void ajouter_Source() throws Throwable {
        FicheActionModele.selectionnerSourceModeleAction(ActSimplStepDefinition.actionSimpl, driver);
    }

    @When("^Saisir Date Création$")
    public void saisir_Date_Création() throws Throwable {
        FicheActionModele.choixDate(driver, row);
    }


    @When("^choisir Type Action$")
    public void choisir_Type_Action() throws Throwable {
        FicheActionModele.selectionnerTypeModeleAction(row, driver);
    }

    @When("^Saisir Désignation$")
    public void saisir_Désignation() throws Throwable {
        FicheActionModele.designationModeleAction(row);
    }

    @When("^Saisir Description problème/objet$")
    public void saisir_Description_problème_objet() throws Throwable {
        FicheActionModele.saisirDescription(row);
    }

    @When("^Saisir A l origine de l action$")
    public void Saisir_A_l_origine_de_l_action() throws Throwable {
        FicheActionModele.origine_action(row);
    }

    @When("^choisir Produit$")
    public void choisir_Produit() throws Throwable {
        FicheActionModele.rattacher_produit(driver);
    }

    @When("^saisir Objectif$")
    public void saisir_Objectif() throws Throwable {
        FicheActionModele.objectif();
    }

    @When("^saisir référence Audit$")
    public void saisir_référence_Audit() throws Throwable {
        FicheActionModele.Ref_Audit(row);
    }

    @When("^choisir Types de causes$")
    public void choisir_Types_de_causes() throws Throwable {
        FicheActionModele.rattacher_Type_cause(driver, row);
    }

    @When("^Saisir Causes possibles$")
    public void saisir_Causes_possibles() throws Throwable {
        FicheActionModele.saisirCausesPossibles();
    }

    @When("^choisir Site$")
    public void choisir_Site() throws Throwable {
        FicheActionModele.selectionnerSiteModeleAction(driver, row);
    }

    @When("^Choisir Processus$")
    public void choisir_Processus() throws Throwable {
        FicheActionModele.selectionnerProcessus(driver, row);
    }

    @When("^choisir Activité$")
    public void choisir_Activité() throws Throwable {
        FicheActionModele.selectionnerActivite(driver, row);
    }

    @When("^choisir Direction$")
    public void choisir_Direction() throws Throwable {
        FicheActionModele.selectionnerDirection(driver, row);
    }

    @When("^choisir service$")
    public void choisir_service() throws Throwable {
        FicheActionModele.service(driver, row);
    }

    @When("^choisir un responsable de clôture$")
    public void choisir_un_responsable_de_clôture() throws Throwable {
        FicheActionModele.resp_cloture(row);
    }

    @When("^cliquer sur valider Action$")
    public void cliquer_sur_valider_Action() throws Throwable {
        try {
            WebElement element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_Button8"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            // executor.executeScript("arguments[0].click()", element);

        } catch (Exception exp) {
            System.err.println("n'y a pas des champs obligatoire");

        }


        WebElement element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton17_Valider"));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500L);
        executor.executeScript("arguments[0].click()", element);
        /*Actions action = new Actions(driver);
        action.moveToElement(FicheActionPage.btnValiderActionId).perform();
        Thread.sleep(500L);
        FicheActionModele.validerAjout();*/
        Thread.sleep(500L);
    }

    @Then("^Fiche Action ajouté$")
    public void fiche_Action_ajouté() throws Throwable {

        Thread.sleep(1000L);

        WebElement num = driver.findElement(By.id("ctl00_ContentPlaceHolder1_nact"));
        //ctl00_ContentPlaceHolder1_nact
        String Num = num.getText();
        System.out.println("action numero: " + Num);
        Common.Exporter_visibilité("Fiche Action:" + Num);
        Common.Exporter_champ_A_masquer("Fiche Action: " + Num);

        assertFalse(Num.equals(""));
        NumAction = Num;
       action.setNumFiche(Integer.parseInt(Num));
        Common.Exporter_numFiche(" num Action   " + Num);

    }

    @Then("Choisir FG responsble réalisation et responsble Suivi$")
    public void choisir_fg_responsble_réalisation_et_responsble_suivi() {
       fgRespReal = action.getFilialeRealisation();
        fgRespSuivi = action.getFilialeSuivi();
    }


    @When("^choisir plusieurs responsables de suivi$")
    public void choisir_plusieurs_responsables_de_suivi() throws Throwable {

        WebElement element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_Liste_sous_actions"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
        Thread.sleep(500L);
        /*element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_Span1"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
        //FicheActionPage.palnActionXpath.click();*/
        Thread.sleep(500L);
        // driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList3_1")).click();
        // driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList3_1")).click();

        executor = (JavascriptExecutor) driver;
        //  executor.executeScript("arguments[0].click()", driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList3_1")));
    }

    @When("^choisir seul responsables de suivi$")
    public void choisir_seul_responsables_de_suivi() throws Throwable {

        WebElement element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_Liste_sous_actions"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
        Thread.sleep(500L);
        /*element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_Span1"));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
        //FicheActionPage.palnActionXpath.click();*/
        Thread.sleep(500L);
        // driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList3_1")).click();
        // driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList3_1")).click();
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList3_0")));
        Select seulRespo = new Select(FicheActionPage.wrespoSuivi);
        Thread.sleep(800);
        String respoSuivi = action.getRespSuivi().getName();
        seulRespo.selectByVisibleText(respoSuivi);

        Common.SaisirDate(driver, "ctl00_ContentPlaceHolder1_TextBox17");
        Thread.sleep(800);
        FicheActionPage.wbtnValideRespoEtDateSuivi.click();


    }

    @Then("^cliquer sur ajouter sous action$")
    public void cliquer_sur_ajouter_sous_action() throws Throwable {
        FicheActionModele.clickAjouterSousActionModeleAction(driver);
        Thread.sleep(1000L);
    }

    @Then("^cliquer sur ajouter sous action un seul responsable de suivi$")
    public void cliquer_sur_ajouter_sous_actionun_seul_responsable_de_suivi() throws Throwable {
        FicheActionModele.clickAjouterSousActionModeleActionSeulRespo(driver);
        Thread.sleep(1000L);
    }


    @When("^saisir désignation sous action$")
    public void saisir_désignation_sous_action() throws Throwable {

        FicheActionModele.saisirDesignationSousAct(row);

    }

    @When("^saisir responsable de réalisation$")
    public void saisir_responsable_de_réalisation() throws Throwable {

        FicheActionModele.selectionnerResponsableRealisation(row, driver, fgRespReal);

        // DemandeActionModel.selectionnerResponsableRealisationSAD(row);

        Thread.sleep(1000L);
    }

    @When("^saisir délais de réalisation$")
    public void saisir_délais_de_réalisation() throws Throwable {

        FicheActionModele.choixDateSousActionModeleAction(driver);
        Thread.sleep(1000L);

    }

    @When("^choisir un responsable de suivi$")
    public void choisir_un_responsable_de_suivi() throws Throwable {

        FicheActionModele.selectionnerResponsableSuivi(row, driver, fgRespSuivi);
        Thread.sleep(3000L);

    }

    @When("^Verfication responsable de suivi$")
    public void Verfication_responsable_de_suivi() throws Throwable {

        FicheActionModele.Verfication_selectionnerResponsableSuivi(row);
        Thread.sleep(3000L);

    }


    @When("^choisir délais de suivi$")
    public void choisir_délais_de_suivi() throws Throwable {

        //Thread.sleep(1000L);
        //FicheActionPage.délais_suivi.click();
        Thread.sleep(1000L);
        //FicheActionPage.choix_délais_suivi.click();

        final DateFormat dateFormat;
        Cookie cookie1 = driver.manage().getCookieNamed("lan");
        if (cookie1.getValue().equals("en-US")) {
            dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        } else {
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        }
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 0);
        dt = c.getTime();
        String Sdate = dateFormat.format(dt);
        System.out.println(Sdate);
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[1].value = arguments[0];", Sdate, FicheActionPage.wdateSuiv);


        Thread.sleep(1000L);
    }


    @When("^Verfication délais de suivi$")
    public void Verfication_délais_de_suivi() throws Throwable {
        Thread.sleep(1000L);
        final DateFormat dateFormat;
        Cookie cookie1 = driver.manage().getCookieNamed("lan");
        if (cookie1.getValue().equals("en-US")) {
            dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        } else {
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        }
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 0);
        dt = c.getTime();
        String Sdate = dateFormat.format(dt);
        System.out.println(Sdate);
        Thread.sleep(1000);
        JavascriptExecutor je = (JavascriptExecutor) driver;
        String script = "return document.getElementById('ctl00_ContentPlaceHolder1_delsiuvie').getAttribute('value');";
        String datedeSuivi = (String) je.executeScript(script);
        datedeSuivi = datedeSuivi.substring(0, 10);
        System.out.println("date  de  suivi   est   " + datedeSuivi);
        Sdate = Sdate.substring(0, 10);

        System.out.println("date Ajourdhui : " + Sdate);
        Assert.assertEquals(datedeSuivi, Sdate);
        Thread.sleep(1000L);
    }


    @When("^choisir gravité action$")
    public void choisir_gravité_action() throws Throwable {

        FicheActionModele.Gravite(row);
    }

    @When("^choisir Priorité SA$")
    public void choisir_Priorité_SA() throws Throwable {

        FicheActionModele.Priorite(row);
    }

    @When("^saisir cout previ SA$")
    public void saisir_cout_previ_SA() throws Throwable {

        FicheActionModele.Cout_Prev();
    }

    @When("^saisir Risque SA$")
    public void saisir_Risque_SA() throws Throwable {

        FicheActionModele.Risque();
    }

    @When("^cliquer sur valider sous action$")
    public void cliquer_sur_valider_sous_action() throws Throwable {

        FicheActionModele.validerSousAction(driver, ActSimplStepDefinition.seulRespo);
        //Thread.sleep(4000L);

    }


    @When("verfier sousAction a été ajoutée")
    public void verfier_sousaction_a_été_ajoutée(DataTable dataTable) throws Exception {
        int numSousAct = 0;
        numSousAct = Integer.parseInt(dataTable.asList().get(0));
        System.err.println("Number for  Action plan   is   :  " + numSousAct);
        List<WebElement> Elements = FicheActionPage.gridActionRealisation.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr"));
        System.out.println("size of  list  is  " + Elements.size());
        Assert.assertEquals(numSousAct, Elements.size(), " elm 1 =" + Elements.size() + " : elem 2 = " + numSousAct);
        String desagnition = FicheActionPage.gridActionRealisation.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr[" + numSousAct + "]/td[4]")).getText();
        String priorite = FicheActionPage.gridActionRealisation.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr[" + numSousAct + "]/td[5]")).getText();
        String gravite = FicheActionPage.gridActionRealisation.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr[" + numSousAct + "]/td[6]")).getText();

        ExcelUtils.setExcelFile(Path, "Action");

        String prioiriteExcel = ExcelUtils.getCellData1(1, 2);
        String GraviteExcel = ExcelUtils.getCellData1(1, 3);
        String desaginationExcel = ExcelUtils.getCellData1(1, 18);
        //Assert.assertEquals(desagnition, desaginationExcel);
        //expresionLamda
        Assert.assertTrue(Optional.ofNullable(desagnition)
                .map(s1 -> s1.equals(desaginationExcel))
                .orElseGet(() -> desaginationExcel == null).booleanValue());
        Assert.assertEquals(priorite, prioiriteExcel);
        Assert.assertEquals(gravite, GraviteExcel);

    }


    @When("verfier sousAction un seul responsable")
    public void verfier_sousAction_un_seul_responsable(DataTable dataTable) throws Exception {
        int numSousAct = 0;
        numSousAct = Integer.parseInt(dataTable.asList().get(0));
        System.err.println("Number for  Action plan   is   :  " + numSousAct);
        List<WebElement> Elements = FicheActionPage.wGridSousActSeulRespo.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView5\"]/tbody/tr"));
        System.out.println("size of  list  is  " + Elements.size());
        Assert.assertEquals(numSousAct, Elements.size(), " elm 1 =" + Elements.size() + " : elem 2 = " + numSousAct);
        String desagnition = FicheActionPage.wGridSousActSeulRespo.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView5\"]/tbody/tr[" + numSousAct + "]/td[4]")).getText();
        String priorite = FicheActionPage.wGridSousActSeulRespo.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView5\"]/tbody/tr[" + numSousAct + "]/td[5]")).getText();
        String gravite = FicheActionPage.wGridSousActSeulRespo.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView5\"]/tbody/tr[" + numSousAct + "]/td[6]")).getText();

        ExcelUtils.setExcelFile(Path, "Action");

        String prioiriteExcel = ExcelUtils.getCellData1(1, 2);
        String GraviteExcel = ExcelUtils.getCellData1(1, 3);
        String desaginationExcel = ExcelUtils.getCellData1(1, 18);
        //Assert.assertEquals(desagnition, desaginationExcel);

        //expresionLamda
        Assert.assertTrue(Optional.ofNullable(desagnition)
                .map(s1 -> s1.equals(desaginationExcel))
                .orElseGet(() -> desaginationExcel == null).booleanValue());


        Assert.assertEquals(priorite, prioiriteExcel);
        Assert.assertEquals(gravite, GraviteExcel);

    }


    @Then("^sous action ajouté a la liste des sous actions$")
    public void sous_action_ajouté_a_la_liste_des_sous_actions() throws Throwable {
        String numSousAct = FicheActionPage.desgSousActionModeleAction.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr/td[2]")).findElement(By.tagName("a")).getText();
        System.err.println("numSousAct =" + numSousAct);
        Assert.assertEquals(numSousAct, "1");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("ctl00_ContentPlaceHolder1_Liste_sous_actions"))).perform();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_Liste_sous_actions")).click();
        Thread.sleep(200L);
        //action = new Actions(driver);
        //action.moveToElement(FicheActionPage.desgSousActionModeleAction).perform();

    }


    @When("^Consulter agenda Action$")
    public void consulter_agenda_Action() throws Throwable {
        Thread.sleep(100L);
        Actions action = new Actions(driver);
        action.moveToElement(FicheActionPage.HomeID).perform();
        FicheActionPage.HomeID.click();
        Thread.sleep(1000L);
        FicheActionModele.cliqueAgenda(driver);
        Thread.sleep(1000L);
    }

    @And("^Réaliser Action$")
    public void Réaliser_Action() throws Throwable {

        Thread.sleep(100L);
        ExcelUtils.setExcelFile(Path, "Action");
        String NumAction = ExcelUtils.getCellData(row, 7);
        try {
            FicheActionModele.saisirNumActionRealisation(NumAction, driver);
        } catch (Exception ex) {
            FicheActionPage.ActionRealisationXpath.click();
            FicheActionModele.saisirNumActionRealisation(NumAction, driver);
        }

        FicheActionModele.rechercherNumActionRealisation(driver);
        Thread.sleep(1000L);
        FicheActionModele.choixNumActionRealisation(driver);
        Thread.sleep(1000L);
        FicheActionModele.saisirTauxRealisation();
        FicheActionModele.saisirDepenses();
        FicheActionModele.saisirCommentaire();
        FicheActionPage.dateRealisation.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        FicheActionPage.choixDateRealisation.click();
        FicheActionModele.validerRealisationAction(driver);
        Thread.sleep(1000L);
    }

    @And("^Suivi Action$")
    public void Suivi_Action() throws Throwable {
        FicheActionPage.ActionSuivreXpath.click();
        Thread.sleep(1000L);
        ExcelUtils.setExcelFile(Path, "Action");
        String NumAction = ExcelUtils.getCellData(row, 7);
        FicheActionModele.saisirNumActionSuivre(NumAction);
        FicheActionModele.rechercherNumActionSuivre(driver);
        FicheActionModele.choixNumActionSuivren();
        FicheActionModele.saisirTauxEffi();
        FicheActionModele.saisirRapportEffi();
        Thread.sleep(1000L);
        FicheActionModele.validerSuivi(driver);
        Thread.sleep(3000L);
        FicheActionModele.cliqueAgenda(driver);
        Thread.sleep(3000L);
    }

    // protected static final Logger logger = LoggerFactory.getLogger(AbstractPage.class);

    @And("^Clôturée Action$")
    public void Clôturée_Action() throws Throwable {
        FicheActionModele.cliqueAgenda(driver);
        origine=action.getFilialeDeclencheur();
        NumAction=String.valueOf(action.getNumFiche());

        JavascriptExecutor executor23 = (JavascriptExecutor) driver;
            executor23.executeScript("arguments[0].click();", FicheActionPage.ActionCloturerXpath);

            Thread.sleep(2000);

            int sizeTabClot = FicheActionPage.wtabFGC.findElements(By.tagName("tr")).size();
            for (int i = 1; i <= sizeTabClot; i++) {
                Thread.sleep(500);
                String fgr = FicheActionPage.wtabFGC.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_tab_ActionCloture\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).getText();
                System.err.println("f = " + origine + "  fgr = " + fgr);
                System.err.println("result   =" + origine.equals(fgr));

                if (origine.equals(fgr)) {
                    FicheActionPage.wtabFGC.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_tab_ActionCloture\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).click();
                    break;
                }
            }

            FicheActionPage.rechercherActionCloturerXpath.findElement(By.tagName("input")).sendKeys(NumAction);

            assertTrue(FicheActionPage.choixActionCloturer.findElement(By.tagName("a")).getText().contains(NumAction));

            FicheActionModele.choixNumActionCloturee(driver, row);
            Thread.sleep(1000L);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            FicheActionModele.choixCloturee(driver);
            Thread.sleep(1000);
            Faker fakerRappCloture = new  Faker();

            FicheActionPage.rapportClotureID.sendKeys("Test Auto "+ fakerRappCloture.lorem().paragraph());
            Thread.sleep(1000);
            FicheActionModele.validerCloturee();
            System.err.println("------------- l'action a été clôturée -------------------------------->");


    }
    @When("Verifier  etat  de  suivi")
    public void Verifier_etat_de_suivi() throws Exception {
        FicheActionModele.cliqueAgenda(driver);


        JavascriptExecutor executor23 = (JavascriptExecutor) driver;
        executor23.executeScript("arguments[0].click();", FicheActionPage.ActionCloturerXpath);

        Thread.sleep(2000);
try {
    int sizeTabClot = FicheActionPage.wtabFGC.findElements(By.tagName("tr")).size();
    for (int i = 1; i <= sizeTabClot; i++) {
        Thread.sleep(500);
        String fgr = FicheActionPage.wtabFGC.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_tab_ActionCloture\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).getText();
        System.err.println("f = " + origine + "  fgr = " + fgr);
        System.err.println("result   =" + origine.equals(fgr));

        if (origine.equals(fgr)) {
            FicheActionPage.wtabFGC.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_tab_ActionCloture\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).click();
            break;
        }
    }

    FicheActionPage.rechercherActionCloturerXpath.findElement(By.tagName("input")).sendKeys(NumAction);

    assertTrue(FicheActionPage.choixActionCloturer.findElement(By.tagName("a")).getText().contains(NumAction));

    FicheActionModele.choixNumActionCloturee(driver, row);
    Thread.sleep(1000L);

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    FicheActionModele.choixCloturee(driver);
    Thread.sleep(1000);
    Assert.assertTrue(false);
}catch (NoSuchElementException exp){
    Assert.assertTrue(true);
}


    }
    @When("Connecter en tant que responsable réalisation")
    public void connecter_en_tant_que_responsable_réalisation() throws Exception {
        action = ActionRunTest.action;
        AuthentificationModel.saisirLogin(action.getRespTraitement().getLogin());
        Thread.sleep(200L);
        AuthentificationModel.saisirPW(action.getRespTraitement().getPassword());
    }
    @When("Connecter en tant que responsable suivi")
    public void connecter_en_tant_que_responsable_suivi() throws Exception {
        action = ActionRunTest.action;
        AuthentificationModel.saisirLogin(action.getRespSuivi().getLogin());
        Thread.sleep(200L);
        AuthentificationModel.saisirPW(action.getRespSuivi().getPassword());
    }
    @When("Connecter en tant que responsable cloture")
    public void connecter_en_tant_que_responsable_cloture() throws Exception {
        action = ActionRunTest.action;
        AuthentificationModel.saisirLogin(action.getRespCloture().getLogin());
        Thread.sleep(200L);
        AuthentificationModel.saisirPW(action.getRespCloture().getPassword());
    }
    @When("saisir action  responsable réalisation")
    public void saisir_action_responsable_réalisation() throws InterruptedException {
        filaile =action.getFilialeRealisation();
        if(!filaile.equals("Mono")){
            Thread.sleep(3000);

            WebElement dropdown = driver.findElement(By.id("ctl00_DDLFiliale"));

            // Create an instance of JavascriptExecutor
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Select the desired option by value using JavaScript

            ((JavascriptExecutor)driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", dropdown, filaile);

        }

    }


    @When("saisir action  responsable Suivi")
    public void saisir_action_responsable_Suivi() throws InterruptedException {
        filaile =action.getFilialeSuivi();
        if(!filaile.equals("Mono")){
            Thread.sleep(3000);

            WebElement dropdown = driver.findElement(By.id("ctl00_DDLFiliale"));

            // Create an instance of JavascriptExecutor
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Select the desired option by value using JavaScript

            ((JavascriptExecutor)driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", dropdown, filaile);

        }

    }



    @When("^Consulter action a traiter$")
    public void consulter_action_a_traiter() throws Throwable {
        Thread.sleep(1000);
        FicheActionModele.cliqueAgenda(driver);
        Thread.sleep(1000L);
        int sizeTab = FicheActionPage.wtabFGR.findElements(By.tagName("tr")).size();


        Thread.sleep(1000L);

        String NumAction = String.valueOf(action.getNumFiche());
                System.out.println("Action" + NumAction);
        Thread.sleep(1000);

            System.out.println("2222");
            FicheActionPage.ActionRealisationXpath.click();
            Thread.sleep(500);

            for (int i = 1; i <= sizeTab; i++) {
                Thread.sleep(500);
                String fgr = FicheActionPage.wtabFGR.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_ActionRealise\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).getText();
                System.err.println("f = " + origine + "  fgr = " + fgr);
                System.err.println("result   =" + origine.equals(fgr));

                if (origine.equals(fgr)) {
                    FicheActionPage.wtabFGR.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_ActionRealise\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).click();
                    break;
                }


        }
        FicheActionModele.saisirNumActionRealisation(NumAction, driver);
        System.out.println("333");
        FicheActionModele.rechercherNumActionRealisation(driver);
        System.out.println("444");
        Thread.sleep(1000);
        //FicheActionPage.wbtnClosAct.findElement(By.tagName("a")).click();
        FicheActionModele.choixNumActionRealisation(driver);

        Thread.sleep(1000L);
    }

    @When("^Réaliser action avec (\\d+)$")
    public void réaliser_action_avec(int arg1) throws Throwable {
        if (arg1==1){


                Faker faker =new Faker();
                taux=String.valueOf(faker.number().numberBetween(5,97));
                action.setTauxRealisation(taux);


        }else {
            taux="100";
            action.setTauxRealisation(taux);
        }
        final DateFormat dateFormat;
        Cookie cookie1 = driver.manage().getCookieNamed("lan");
        if (cookie1.getValue().equals("en-US")) {
            dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        } else {
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        }
        FicheActionPage.tauxRealisation.clear();
        FicheActionPage.tauxRealisation.sendKeys(taux);
        ExcelUtils.setCellData1(taux, row, 20, Path, "Action");
        FicheActionModele.saisirDepenses();
        FicheActionModele.saisirCommentaire();
        //FicheActionModele.rattacher_intervenant(driver);
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 0);
        dt = c.getTime();
        String Sdate = dateFormat.format(dt);

        action.setDateRealisation(Sdate);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[1].value = arguments[0];", Sdate, FicheActionPage.SaisieDRealisation);
        Thread.sleep(500);
        String datesaisie = driver.findElement(By.id("ctl00_ContentPlaceHolder1_TextBox9")).getAttribute("value");
        Thread.sleep(500L);

        FicheActionModele.validerRealisationAction(driver);
        Thread.sleep(500);
        try{
        FicheActionModele.EnrTauxReal(driver, taux);}
        catch (NoSuchElementException e){
            if(Integer.parseInt(taux)<100){
                Assert.assertTrue(false);
            }
        }


    }


    @When("^Consulter action a suivre$")
    public void consulter_action_a_suivre() throws Throwable {
        origine=action.getFilialeDeclencheur();






        Thread.sleep(1000L);
        FicheActionModele.cliqueAgenda(driver);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.ActionSuivreXpath);
        int sizeTab = FicheActionPage.wtabFGS.findElements(By.tagName("tr")).size();
        for (int i = 1; i <= sizeTab; i++) {
            Thread.sleep(500);
            String fgr = FicheActionPage.wtabFGS.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_tab_agenda_ActionSuivre\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).getText();
            System.err.println("f = " + origine + "  fgr = " + fgr);
            System.err.println("result   =" + origine.equals(fgr));

            if (origine.contains(fgr)) {
                Thread.sleep(500);
                FicheActionPage.wtabFGS.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_tab_agenda_ActionSuivre\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).click();
                break;
            }

        }
        Thread.sleep(1000L);

        String NumAction =String.valueOf(action.getNumFiche());
        Thread.sleep(2000);

            FicheActionModele.saisirNumActionSuivre(NumAction);

        FicheActionModele.rechercherNumActionSuivre(driver);
        Thread.sleep(1000L);
        FicheActionModele.choixNumActionSuivren();
        Thread.sleep(1000L);

    }

    @Then("^vérifier taux réalisation$")
    public void vérifier_taux_réalisation() throws Throwable {
        String tauxReal=action.getTauxRealisation();
        System.out.println(tauxReal);
        Thread.sleep(1000);
        System.out.println(FicheActionPage.AffTxReaId.getAttribute("value"));
        assertTrue(FicheActionPage.AffTxReaId.getAttribute("value").contains(tauxReal));


    }


    @When("suivre action avec {int}")
    public void suivre_action_avec_et_et(Integer int1) throws Exception {
        if (int1==1){
                Faker faker =new Faker();
                taux=String.valueOf(faker.number().numberBetween(5,97));

        }else {
            taux="100";
        }
        action.setTauxSuivi(taux);
        Thread.sleep(1000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.EditTxReaId);

        Thread.sleep(1000L);


        try {
            FicheActionPage.NouvTxReaId.clear();
            Thread.sleep(1000L);
            FicheActionPage.NouvTxReaId.sendKeys(taux);
            action.setTauxRealisation(taux);
            Faker commentaireRespoSuiv = new Faker();
            FicheActionPage.CommNouvTxReaId.sendKeys(commentaireRespoSuiv.lorem().paragraph());
            Thread.sleep(500L);
            FicheActionPage.VldNvTxReaId.click();
            Thread.sleep(500L);

        } catch (NoSuchElementException e) {
            //action  simple
            FicheActionPage.TabSimpActReal.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView4_wrapper\"]/div[2]/div/table/tbody/tr/td[" + int1 + "]")).findElement(By.tagName("a")).click();
            FicheActionPage.NouvTxReaIdSimpl.clear();
            Thread.sleep(1000L);
            FicheActionPage.NouvTxReaIdSimpl.sendKeys(taux);
            action.setTauxRealisation(taux);

            FicheActionPage.WCOMM_NOUV_TX_IDsimp.sendKeys("nécessite verification");
            Thread.sleep(500L);
            FicheActionPage.VldNvTxReaIdsimp.click();
            Thread.sleep(500L);
            FicheActionPage.retourActSimp.findElement(By.tagName("span")).click();
        }

        Thread.sleep(500L);
        FicheActionPage.TauxEffiID.clear();
        Thread.sleep(500L);
        FicheActionPage.TauxEffiID.sendKeys(taux);
        Thread.sleep(500L);

  action.setTauxSuivi(taux);
        Thread.sleep(500L);

        FicheActionPage.rapportEffiID.clear();
        Thread.sleep(500L);

        FicheActionPage.rapportEffiID.sendKeys("rapport efficacité");
        Thread.sleep(500L);

        String Sdate = driver.findElement(By.id("ctl00_ContentPlaceHolder1_TextBox10")).getAttribute("value");

        Thread.sleep(1000L);
        FicheActionModele.validerSuivi(driver);

    }

    @When("^suivre action avec (\\d+) et (\\d+)$")
    public void suivre_action_avec_et(int arg1, int arg2) throws Throwable {

        if (arg1==1){
            taux=action.getTauxRealisation();
            Predicate<String> isNotEmptyOrNull = (str) -> str == null || str.isEmpty();

            if (isNotEmptyOrNull.test(taux)) {
                Faker faker =new Faker();
                taux=String.valueOf(faker.number().numberBetween(5,97));
            }

        }else {
            taux="100";
        }

        taux = Integer.toString(arg1);
        Thread.sleep(1000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.EditTxReaId);

        Thread.sleep(1000L);


        try {
            FicheActionPage.NouvTxReaId.clear();
            Thread.sleep(1000L);
            FicheActionPage.NouvTxReaId.sendKeys(taux);

            ExcelUtils.setCellData1(taux, row, 20, Path, "Action");
            FicheActionPage.CommNouvTxReaId.sendKeys("nécessite verification");
            Thread.sleep(500L);
            FicheActionPage.VldNvTxReaId.click();
            Thread.sleep(500L);

        } catch (Exception e) {
            FicheActionPage.TabSimpActReal.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView4_wrapper\"]/div[2]/div/table/tbody/tr/td[1]")).findElement(By.tagName("a")).click();
            FicheActionPage.NouvTxReaIdSimpl.clear();
            Thread.sleep(1000L);
            FicheActionPage.NouvTxReaIdSimpl.sendKeys(taux);
            ExcelUtils.setCellData1(taux, row, 20, Path, "Action");
            FicheActionPage.WCOMM_NOUV_TX_IDsimp.sendKeys("nécessite verification");
            Thread.sleep(500L);
            FicheActionPage.VldNvTxReaIdsimp.click();
            Thread.sleep(500L);
            FicheActionPage.retourActSimp.findElement(By.tagName("span")).click();
        }
        taux = Integer.toString(arg2);
        Thread.sleep(500L);
        FicheActionPage.TauxEffiID.clear();
        Thread.sleep(500L);
        FicheActionPage.TauxEffiID.sendKeys(taux);
        Thread.sleep(500L);

        ExcelUtils.setCellData1(taux, row, 22, Path, "Action");
        Thread.sleep(500L);

        FicheActionPage.rapportEffiID.clear();
        Thread.sleep(500L);

        FicheActionPage.rapportEffiID.sendKeys("rapport efficacité");
        Thread.sleep(500L);

        String Sdate = driver.findElement(By.id("ctl00_ContentPlaceHolder1_TextBox10")).getAttribute("value");
        Thread.sleep(500L);
        ExcelUtils.setExcelFile(Path, "Action");
        ExcelUtils.setCellData1(Sdate, row, 21, Path, "Action");
        ExcelUtils.setExcelFile(Path, "Action");
        ExcelUtils.setCellData1(Sdate, row, 19, Path, "Action");
        Thread.sleep(1000L);
        FicheActionModele.validerSuivi(driver);

    }

    @Then("^vérifier taux réalisation responsable traitement$")
    public void vérifier_taux_réalisation_responsable_traitement() throws Throwable {

        assertTrue(FicheActionPage.tauxRealisation.getAttribute("value").contains(taux));
        FicheActionPage.QttRetour1Id.click();
        Thread.sleep(1000L);

    }

    @When("^Consulter \"([^\"]*)\" a realiser$")
    public void consulter_a_realiser(String arg1) throws Throwable {
        NumAction = arg1;
        Thread.sleep(1000);
        FicheActionModele.cliqueAgenda(driver);
        Thread.sleep(1000L);
        FicheActionPage.ActionRealisationXpath.click();
        Thread.sleep(100L);
        FicheActionModele.saisirNumActionRealisation(arg1, driver);
        FicheActionModele.rechercherNumActionRealisation(driver);
        Thread.sleep(100L);
        FicheActionModele.choixNumActionRealisation(driver);
        Thread.sleep(1000L);
    }

    @When("^Consulter \"([^\"]*)\" a suivre$")
    public void consulter_a_suivre(String arg1) throws Throwable {
        FicheActionPage.HomeID.click();
        Thread.sleep(1000L);
        FicheActionModele.cliqueAgenda(driver);
        Thread.sleep(1000L);
        FicheActionPage.ActionSuivreXpath.click();
        Thread.sleep(1000L);
        FicheActionModele.saisirNumActionSuivre(arg1);
        FicheActionModele.rechercherNumActionSuivre(driver);
        Thread.sleep(1000L);
        FicheActionModele.choixNumActionSuivren();
        Thread.sleep(1000L);

    }

    @Then("^delete file$")
    public void delete_file() throws InterruptedException, IOException {
        System.out.println("delete file   RTF");
        FileOutputStream fos = null;


        // create new file output stream


        //   FileUtils.cleanDirectory(new File("E:\\qualipro\\trunk\\AutomatisationTQualiPro_prod231\\resources\\apercu"));

        java.nio.file.Path path2 = FileSystems.getDefault().getPath("E:\\qualipro\\trunk\\AutomatisationTQualiPro_prod231\\resources\\Telechargement\\CrystalReportViewer1.rtf");
        System.err.println("files is  " + Files.exists(path2));

        try {
            System.err.println("files is  " + Files.exists(path2));
            fos = new FileOutputStream("E:\\qualipro\\trunk\\AutomatisationTQualiPro_prod231\\resources\\Telechargement\\CrystalReportViewer1.rtf");
            fos.close();
            Thread.sleep(1000);
            Files.delete(path2);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", path2);
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    @When("^Consulter fiche action$")
    public void consulter_fiche_action() throws Throwable {

        String NumAction = String.valueOf(action.getNumFiche());

        FicheActionModele.consulter_fiche(NumAction, driver);
    }


    @Then("^Exporter tracabilite$")
    public void exporter_tracabilite() throws Throwable {

        File folder = new File("E:\\qualipro\\trunk\\AutomatisationTQualiPro_prod231\\resources\\Telechargement");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            System.out.println("file name  : " + file.getName());
            file.delete();

            Thread.sleep(500);

        }

        Thread.sleep(1000);
        try {
            FicheActionPage.ExporterId.click();
        } catch (NoSuchElementException exp) {
            System.err.println("element   not  found ");
        }

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].scrollIntoView();", FicheActionPage.VldIntervId);
            JavascriptExecutor js2 = (JavascriptExecutor) driver;

            js2.executeScript("arguments[0].click();", FicheActionPage.VldIntervId);

            //js2.executor.executeScript("arguments[0].click();",FicheActionPage.wchoixrept );


        } catch (NoSuchElementException exp) {
            System.err.println("element   not  found ");
        }


        Thread.sleep(2000);

        //FicheActionPage.wchoixrept.click();

        //.click();

        //FicheActionPage.wexp.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", FicheActionPage.wchoixrept);


        //List<WebElement> elementList = driver.findElements(By.className("iconText"));
        //	elementList.get(1).click();
        Thread.sleep(1000);


        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", FicheActionPage.wselctRepo);
        Thread.sleep(1000);
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", FicheActionPage.wexp);

        //driver.findElement(By.tagName("table")).findElement(By.tagName("tbody")).findElement(By.tagName("tr")).findElement(By.tagName("td")).findElement(By.tagName("nobr")).findElement(By.tagName("a")).click();
    /*	Screen s = new Screen();
        Screen s1 = new Screen();
        Screen s2 = new Screen();
        Screen s3 = new Screen();
        Thread.sleep(1000);


        try {
            Pattern pattern = new Pattern("E:\\qualipro\\trunk\\AutomatisationTQualiPro_prod231\\resources\\imgs\\Exporter_PV_reunion.PNG");
            Pattern pattern1 = new Pattern("E:\\qualipro\\trunk\\AutomatisationTQualiPro_prod231\\resources\\imgs\\combo_exporter_pv_reunion.PNG");
            Pattern pattern2 = new Pattern("resources/imgs/Choix_combo_PV_reunion.PNG");
            Pattern pattern3 = new Pattern("resources/imgs/Btn_exporter_PV_reunion.PNG");
            s1.click(pattern1);
            s2.click(pattern2);
            s3.click(pattern3);
            Thread.sleep(4000);

        } catch (FindFailed e) {
            e.printStackTrace();
        }*/
        Runtime.getRuntime().exec("E:\\qualipro\\trunk\\AutomatisationTQualiPro_prod231\\resources\\Scripts\\EnregistrerFichier.exe");
        Thread.sleep(4000);
    }

    @Then("^Vérifier les donnes de traçabilite$")
    public void Vérifier_les_donnes_de_traçabilite() throws Throwable {

        String path = "E:\\qualipro\\trunk\\platforme_test_automation_backend\\resources\\Download\\CrystalReportViewer1.rtf";
        String fileData = null;
        Thread.sleep(5000);
        //fileData = RTFUtil.ReadRTFFile(path);
        System.out.println("********************************TRACABILITE**************************************" + fileData);

        ExcelUtils.setExcelFile(Path, "Action");
        String RespReal = action.getRespTraitement().getName();
        Thread.sleep(500);
        System.err.println("RespReal" + RespReal);
        System.out.println("Existe: RespReal " + Common.ExisteWord(path, RespReal));
        assertTrue(Common.ExisteWord(path, RespReal));

        String RespSuivi = action.getRespSuivi().getName();
        Thread.sleep(500);
        System.err.println("RespSuivi" + RespSuivi);
        System.out.println("Existe:  RespSuivi" + Common.ExisteWord(path, RespSuivi));
        assertTrue(Common.ExisteWord(path, RespSuivi));

        String DateReal =action.getDateRealisation();
        DateTimeFormatter formatter_1 = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate local_date_1 = LocalDate.parse(DateReal, formatter_1);


        // print date in the specified format
        String date_string = formatter_1.format(local_date_1);

        System.out.println(date_string);

        Thread.sleep(500);
        System.err.println("DateReal " + local_date_1);
        System.out.println("Existe: DateReal" + Common.ExisteWord(path, date_string));
        assertTrue(Common.ExisteWord(path, date_string));

        String tauxReal = action.getTauxRealisation();
        Thread.sleep(500);
        System.err.println("tauxReal" + tauxReal);
        System.out.println("Existe tauxReal: " + Common.ExisteWord(path, tauxReal));
        assertTrue(Common.ExisteWord(path, tauxReal));

        String DateSuivi =action.getDateSuivi();

        DateTimeFormatter formatter_2 = DateTimeFormatter.ofPattern("d/MM/yyyy");

        String TauxSuivi = action.getTauxSuivi();
        Thread.sleep(500);
        System.err.println("TauxSuivi" + TauxSuivi);
        System.out.println("Existe TauxSuivi: " + Common.ExisteWord(path, TauxSuivi));
        assertTrue(Common.ExisteWord(path, TauxSuivi));


        driver.navigate().back();

    }


    @Then("^Vérifier (\\d+) et (\\d+)$")
    public void vérifier_et(int arg1, int arg2) throws Throwable {
        List<String> informations = new ArrayList<String>();
        taux = Integer.toString(arg1);
        informations.add(taux);
        taux = Integer.toString(arg2);
        informations.add(taux);

        String path = "E:\\qualipro\\trunk\\AutomatisationTQualiPro_prod231\\resources\\Telechargement\\CrystalReportViewer1.rtf";
        String fileData = null;
        Thread.sleep(5000);
        // fileData = RTFUtil.ReadRTFFile(path);
        System.out.println("********************************TRACABILITE**************************************" + fileData);

        for (int i = 0; i < informations.size(); i++) {
            int j = i + 1;
            System.out.println("l'information " + j + ":" + informations.get(i));
            System.out.println("Existe: " + Common.ExisteWord(path, informations.get(i)));
            assertTrue(Common.ExisteWord(path, informations.get(i)));
        }
        driver.navigate().back();

    }


    @Then("^Vérifier etat action realisé$")
    public void vérifier_etat_action_realisé() throws Throwable {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.HomeID);

        Thread.sleep(1000L);
        FicheActionModele.cliqueAgenda(driver);
        Thread.sleep(1000L);

        String NumAction = String.valueOf(action.getNumFiche());

        if (Integer.parseInt(taux) < 100) {
            try {


                JavascriptExecutor executor2 = (JavascriptExecutor) driver;
                executor2.executeScript("arguments[0].click()", FicheActionPage.actionRealise);

                int sizeTab = FicheActionPage.wtabFGR.findElements(By.tagName("tr")).size();
                for (int i = 1; i <= sizeTab; i++) {
                    Thread.sleep(500);
                    String fgr = FicheActionPage.wtabFGR.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_ActionRealise\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).getText();
                    System.err.println("f = " + origine + "  fgr = " + fgr);
                    System.err.println("result   =" + origine.equals(fgr));

                    if (origine.equals(fgr)) {
                        FicheActionPage.wtabFGR.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_ActionRealise\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).click();
                        break;
                    }
                }


                FicheActionModele.saisirNumActionRealisation(NumAction, driver);
                Thread.sleep(1000L);
                FicheActionModele.rechercherNumActionRealisation(driver);
                Thread.sleep(2000L);
                assertTrue(FicheActionPage.ActionRealiserId.findElement(By.tagName("a")).getText().contains(NumAction));
            } catch (NoSuchElementException e) {
                Assert.assertTrue(false);
            }

        } else {
            try {
                FicheActionPage.FiltreRealiseId.isDisplayed();
                FicheActionPage.FiltreRealiseId.sendKeys(NumAction);
                Thread.sleep(1000L);

                assertTrue(driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr/td")).getText().contains("Aucun élément à afficher") || driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr/td")).getText().contains("No matching records found"));
          Assert.assertTrue(false);
            } catch (NoSuchElementException e) {

                System.out.println("aucun element n'est afficher");
            }
        }

    }

    @When("^suivre action (\\d+)$")
    public void suivre_action(int arg1) throws Throwable {
//        FicheActionPage.ActionSuivreXpath.click();
        Thread.sleep(1000L);
        taux ="100";
        action.setTauxSuivi(taux);
        FicheActionPage.TauxEffiID.clear();
        FicheActionPage.TauxEffiID.sendKeys(taux);
        FicheActionModele.saisirRapportEffi();
        Thread.sleep(1000L);
        FicheActionModele.validerSuivi(driver);

    }

    @Then("^Vérifier etat action suivi$")
    public void vérifier_etat_action_suivi() throws Throwable {
        Etatcloture = false;
        Thread.sleep(1000L);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", FicheActionPage.HomeID);
        //	FicheActionPage.HomeID.click();
        Thread.sleep(1000L);
        FicheActionModele.cliqueAgenda(driver);
        Thread.sleep(1000L);
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", FicheActionPage.ActionSuivreXpath);

        //FicheActionPage.ActionSuivreXpath.click();
        Thread.sleep(1000L);
        ExcelUtils.setExcelFile(Path, "Action");
        String NumAction =String.valueOf(action.getNumFiche());
        try {
            int sizeTab = FicheActionPage.wtabFGS.findElements(By.tagName("tr")).size();
            for (int i = 1; i <= sizeTab; i++) {
                Thread.sleep(500);
                String fgr = FicheActionPage.wtabFGS.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_tab_agenda_ActionSuivre\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).getText();
                System.err.println("f = " + origine + "  fgr = " + fgr);
                System.err.println("result   =" + origine.equals(fgr));

                if (origine.equals(fgr)) {
                    FicheActionPage.wtabFGS.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_tab_agenda_ActionSuivre\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).click();
                    break;
                }
            }

            FicheActionModele.saisirNumActionSuivre(NumAction);
            FicheActionModele.rechercherNumActionSuivre(driver);
            Thread.sleep(1000L);

            assertTrue(FicheActionPage.choixNumActionSuivre.getText().contains(NumAction));
        }catch (NoSuchElementException exp){
            if(Integer.parseInt(taux) < 100){
                Assert.assertTrue(false);
            }
        }



//
//            JavascriptExecutor executor12 = (JavascriptExecutor) driver;
//            // executor12.executeScript("arguments[0].click()", ModuleAuditsPage.CompteID);
//            Thread.sleep(500);
//            JavascriptExecutor executor22 = (JavascriptExecutor) driver;
//            // executor22.executeScript("arguments[0].click()", ModuleAuditsPage.DeconnID);
//            Thread.sleep(500);
//            //ModuleAuditsPage.DeconnID.click();
//            ExcelUtils.setExcelFile(Path, "Action");
//            String value = ExcelUtils.getCellData(row, 5);
//            if (!(value.equals(""))) {
//
//
//                Thread.sleep(1000L);
//                AuthentificationModel.Changer_Compte(value, driver);
//                Thread.sleep(4000);
//            }
//
//
//            FicheActionModele.cliqueAgenda(driver);
//
//
    }

    @Then("Vérifier etat action suivi {string}")
    public void vérifier_etat_action_suivi(String string) throws Throwable {
        Etatcloture = false;
        Thread.sleep(1000L);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", FicheActionPage.HomeID);
        //	FicheActionPage.HomeID.click();
        Thread.sleep(1000L);
        FicheActionModele.cliqueAgenda(driver);
        Thread.sleep(1000L);
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", FicheActionPage.ActionSuivreXpath);
        //FicheActionPage.ActionSuivreXpath.click();
        Thread.sleep(1000L);
        ExcelUtils.setExcelFile(Path, "Action");
        String NumAction = ExcelUtils.getCellData(row, 7);
        if (Integer.parseInt(taux) < 100) {

            FicheActionModele.saisirNumActionSuivre(NumAction);
            FicheActionModele.rechercherNumActionSuivre(driver);
            Thread.sleep(1000L);

            assertTrue(FicheActionPage.choixNumActionSuivre.getText().contains(NumAction));
        } else {
            Thread.sleep(2000);

            JavascriptExecutor executor23 = (JavascriptExecutor) driver;
            executor23.executeScript("arguments[0].click();", FicheActionPage.ActionCloturerXpath);

            Thread.sleep(2000);

            FicheActionPage.rechercherActionCloturerXpath.findElement(By.tagName("input")).sendKeys(NumAction);

            assertTrue(FicheActionPage.choixActionCloturer.findElement(By.tagName("a")).getText().contains(NumAction));

            FicheActionModele.choixNumActionCloturee(driver, row);
            Thread.sleep(1000L);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            FicheActionModele.choixCloturee(driver);
            Thread.sleep(1000);
            if (string.equals("Oui")) {
                FicheActionPage.rapportClotureID.sendKeys("Test Auto");
                FicheActionModele.validerCloturee();
            }


        }

    }


    @When("^cliquer sur bilan des actions$")
    public void cliquer_sur_bilan_des_actions() throws Throwable {

//		  JavascriptExecutor executor = (JavascriptExecutor)driver;
//	      executor.executeScript("arguments[0].click();",FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > a > img")) );
//	      JavascriptExecutor executor1 = (JavascriptExecutor)driver;
//	      executor1.executeScript("arguments[0].click();",FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(21) > a")) );

        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(2) > ul > li:nth-child(1) > a")));


        Thread.sleep(1000L);

    }

    @When("^récupérer filtre reporting$")
    public void récupérer_filtre_reporting() throws Throwable {
        FicheActionModele.initializer_filtre_Bilan_action(row);
    }


    @When("^saisir filtre reporting$")
    public void saisir_filtre_reporting() throws Throwable {
        //Object obj=FicheActionPage.class.newInstance();
        /*FicheActionPage pageclass = FicheActionPage.class.newInstance();
        for (Field field : FicheActionPage.class.getDeclaredFields())
        {
            System.out.println(field.getName());
            System.out.println(field.get(pageclass));
        }*/
        FicheActionModele.initializer_filtre_Bilan_action(1);

        Iterator<Map.Entry<String, String>> iterator = FicheActionModele.filtre_repor.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry mapentry = iterator.next();
            System.out.print("element  :  " + mapentry.getKey().toString());
            System.out.println("contune  :  " + mapentry.getValue().toString());
            Common.remplir_filtre_by_id(driver, mapentry.getKey().toString(), mapentry.getValue().toString());
        }
        Common.SaisirDate(driver, "ctl00_ContentPlaceHolder1_TextBox3");
        Common.SaisirDate(driver, "ctl00_ContentPlaceHolder1_TextBox1");
        Common.SaisirDate(driver, "ctl00_ContentPlaceHolder1_TextBox2");
        Common.SaisirDate(driver, "ctl00_ContentPlaceHolder1_TextBoxDate1");
        Common.SaisirDate(driver, "ctl00_ContentPlaceHolder1_TextBox4");
        Common.SaisirDate(driver, "ctl00_ContentPlaceHolder1_TextBoxDate2");
        //	Common.SaisirDate(driver,"ctl00_ContentPlaceHolder1_TextBox4");
        try {
            Select respoReal = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_tb_respreal")));

            respoReal.selectByVisibleText("AUTO1");
        } catch (Exception ex) {

        }


        try {
            WebElement element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton11"));

            //This will scroll the page till the element is found
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", element);
            js.executeScript("arguments[0].click()", element);

            Thread.sleep(500);
        } catch (Exception ex) {

        }
    }

    @When("^choisir \"([^\"]*)\" de réalisation des actions$")
    public void choisir_de_réalisation_des_actions(String arg1) throws Throwable {
        if (arg1.equals("NON REALISEE")) {
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList_Real_0")).click();
        } else if (arg1.equals("REALISEE")) {
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList_Real_1")).click();
        } else {
            System.out.println("type réalisation incorrecte");
        }
    }

    @When("^choisir \"([^\"]*)\" de cloture des actions$")
    public void choisir_de_cloture_des_actions(String arg1) throws Throwable {
        if (arg1.equals("NON CLOTUREE")) {
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList_Clot_0")).click();
        } else if (arg1.equals("CLOTUREE")) {
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList_Clot_1")).click();
        } else {
            System.out.println("type cloture incorrecte");
        }
    }

    @When("^choisir \"([^\"]*)\" bilan des actions$")
    public void choisir_bilan_des_actions(String arg1) throws Throwable {
        if (arg1.equals("MODELE 1")) {
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList_Modele_0")).click();
        } else if (arg1.equals("MODELE 2")) {
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList_Modele_1")).click();
        } else if (arg1.equals("MODELE 3")) {
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_RadioButtonList_Modele_2")).click();
        } else {
            System.out.println("modele incorrecte");
        }
    }

    @When("^choisir \"([^\"]*)\" de regroupement des actions$")
    public void choisir_de_regroupement_des_actions(String arg1) throws Throwable {
        if (arg1.equals("SOURCE")) {
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_R_groupe_0")).click();
        } else if (arg1.equals("DECLENCHEUR")) {
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_R_groupe_1")).click();
        } else if (arg1.equals("TYPE")) {
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_R_groupe_2")).click();
        } else if (arg1.equals("PRODUIT")) {
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_R_groupe_3")).click();
        } else if (arg1.equals("SITE")) {
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_R_groupe_4")).click();
        } else if (arg1.equals("RESP.REAL")) {
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_R_groupe_5")).click();
        } else if (arg1.equals("Intervenant")) {
            WebElement select = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ListBox_Intervenant"));
            Select intervanet = new Select(select);
            //	intervanet.selectByVisibleText("AUTO1");
        } else {
            System.out.println("type regroupement incorrecte");
        }
    }


    @When("saisir {int} d'action réalisées par personne")
    public void saisir_d_action_réalisées_par_personne(Integer int1) {
        row = int1;
    }


    @Then("^Exporter les données$")
    public void exporter_les_données() throws Throwable {

        /*JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        String currentFrame = (String) jsExecutor.executeScript("return self.name");
        System.out.println(currentFrame);
         List<WebElement> elements =driver.findElements(By.tagName("table"));
         System.out.println(elements.size());
         int i=0;
         while(i<elements.size())
         {
             String id = elements.get(i).getAttribute("id");
             System.out.println(id);
             if(id.contains("bobjid_1560876287447_dialog"))
             {
                 System.out.println("yes");
                 WebElement td=elements.get(i).findElement(By.id("td_dialog_bobjid_1560874207391_dialog"));
                 System.out.println(td.getAttribute("id"));
             }
             i++;
         }*/
        //WebElement table= driver.findElement(By.id("bobjid_1560874207391_dialog"));
        //WebElement td=table.findElement(By.id("td_dialog_bobjid_1560874207391_dialog"));
        //System.out.println(td.getAttribute("id"));

    /*	 Screen s = new Screen();
            Screen s1 = new Screen();
            Screen s2 = new Screen();
            Screen s3 = new Screen();
            try {
                Pattern pattern  = new Pattern("resources/imgs/Exporter_PV_reunion.PNG");
                Pattern pattern1 = new Pattern("resources/imgs/combo_exporter_pv_reunion.PNG");
                Pattern pattern2 = new Pattern("resources/imgs/Choix_combo_PV_reunion.PNG");
                Pattern pattern3 = new Pattern("resources/imgs/Btn_exporter_PV_reunion.PNG");
                s.click(pattern);
                s1.click(pattern1);
                s2.click(pattern2);
                s3.click(pattern3);
            } catch (FindFailed e) {
                e.printStackTrace();
            }*/
        //  JavascriptExecutor executor = (JavascriptExecutor)driver;
        // executor.executeScript("arguments[0].click();",FicheActionPage.wexport );
        //  driver.findElement(By.linkText("Exporter")).click();

        //*[@id="iconMenu_icon_bobjid_1604052822944_dialog_combo"]/tbody/tr/td[2]
    }

    @Then("^vérifier les données rapport$")
    public void vérifier_les_données_rapport() throws Throwable {
        String name1 = "bilan_action";
        ExcelUtils.setExcelFile(Path, "Action");
        String num_action = ExcelUtils.getCellData(1, 7);
        Common.Vérifier_données(name1, num_action);
    }

    @When("^Consulter reporting Etat des actions par responsable$")
    public void consulter_reporting_Etat_des_actions_par_responsable() throws Throwable {
        //driver.get("http://10.66.245.30/w23/action/rapport/FiltreEtatResp.aspx");

        Thread.sleep(1000L);
        PageFactory.initElements(driver, FicheActionPage.class);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > a > img")));
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(2) > a")));
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(2) > ul > li:nth-child(6) > a")));
        Thread.sleep(2000L);
    }

    @When("^récupérer filtre reporting Etat action$")
    public void récupérer_filtre_reporting_Etat_action() throws Throwable {
        FicheActionModele.initializer_filtre_Etat_action(Path);

    }

    @Then("^vérifier les données rapport Etat action$")
    public void vérifier_les_données_rapport_Etat_action() throws Throwable {
        String name1 = "Etat_action";
        ExcelUtils.setExcelFile(Path, "Action");
        String num_action = ExcelUtils.getCellData(row, 7);
        Common.Vérifier_données(name1, num_action);
    }

    //Amira
    @When("^Consulter reporting liste des actions réalisées par personne$")
    public void consulter_reporting_liste_des_actions_réalisées_par_personne() throws Throwable {
        //	driver.get("http://10.66.245.30/w23/action/rapport/FilteEtatnbreactionparpersonne.aspx");
        Thread.sleep(1000L);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > a > img")));
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(2) > a")));
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector(" #menu_rep > div > div > ul > li > ul > li:nth-child(2) > ul > li:nth-child(2) > a")));
    }

    @When("^récupérer filtre reporting liste des actions realisees par personne$")
    public void récupérer_filtre_reporting_liste_des_actions_realisees_par_personne() throws Throwable {
        FicheActionModele.initializer_filtre_action_par_personne(Path);
    }

    @Then("^vérifier les données rapport liste des actions realisees par personne$")
    public void vérifier_les_données_rapport_liste_des_actions_realisees_par_personne() throws Throwable {
        String name1 = "Liste_action_réalisée_par_personne";
        List<String> data = new ArrayList<String>();
        ExcelUtils.setExcelFile(Path, "Action");
        String num_action = ExcelUtils.getCellData(row, 7);
        //num  action
        data.add(num_action);
        // desaignation  d'action
        data.add(ExcelUtils.getCellData(row, 11));
        //number  of action  paln
        data.add("1");
        //désaignation de  sous Action
        data.add(ExcelUtils.getCellData(row, 18));
        //taux
        data.add("100");
        Common.Vérifier_liste_données(name1, data);

        //VldIntervId
    }


    @When("^récupérer \"([^\"]*)\" reporting$")
    public void récupérer_reporting(String arg1) throws Throwable {
        FicheActionModele.initializer_filtre_Bilan_action(Path, arg1);
    }


    @When("Consulter action a traiter triple SousAct")
    public void consulter_action_a_traiter_triple_SousAct(DataTable dataTable) throws Exception {
        System.out.println("DATA1 " + dataTable.asList().size());


        Thread.sleep(1000);
        FicheActionModele.cliqueAgenda(driver);
        Thread.sleep(1000L);


        Thread.sleep(1000L);
        ExcelUtils.setExcelFile(Path, "Action");
        String NumAction = ExcelUtils.getCellData(row, 7);
        System.out.println("Action" + NumAction);
        Thread.sleep(1000);
        try {
            FicheActionModele.saisirNumActionRealisation(NumAction, driver);
        } catch (Exception e) {
            FicheActionPage.ActionRealisationXpath.click();
            FicheActionModele.saisirNumActionRealisation(NumAction, driver);
        }
        FicheActionModele.rechercherNumActionRealisation(driver);
        Thread.sleep(1000);
        //FicheActionPage.wbtnClosAct.findElement(By.tagName("a")).click();
        //FicheActionModele.choixNumActionRealisation();
        int i = 0;


        Thread.sleep(500);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.WbtnEnrTReal);
        Thread.sleep(500);

        int k = 0;
        while (i < dataTable.asList().size()) {
            Thread.sleep(1000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            System.out.println(" i  = " + i);
            k++;
            js.executeScript("arguments[0].scrollIntoView(true);", FicheActionPage.gridActionRealisation.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr[" + k + "]/td[9]/table/tbody/tr/td[1]")).findElement(By.tagName("input")));

            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("arguments[1].value =arguments[0];", "", FicheActionPage.gridActionRealisation.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr[" + k + "]/td[9]/table/tbody/tr/td[1]")).findElement(By.tagName("input")));
            js2.executeScript("arguments[1].value =arguments[0];", dataTable.asList().get(i), FicheActionPage.gridActionRealisation.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr[" + k + "]/td[9]/table/tbody/tr/td[1]")).findElement(By.tagName("input")));
            js2.executeScript("arguments[1].value =arguments[0];", "Report plan action Realisation ", FicheActionPage.gridActionRealisation.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr[" + k + "]/td[10]/table/tbody/tr/td[1]")).findElement(By.tagName("textarea")));


            final DateFormat dateFormat;
            Cookie cookie1 = driver.manage().getCookieNamed("lan");
            if (cookie1.getValue().equals("en-US")) {
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            } else {
                dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            }
            Thread.sleep(1000L);

            taux = Integer.toString(Integer.parseInt(dataTable.asList().get(i)));
            ExcelUtils.setCellData1(taux, row, 20, Path, "Action");


            //*[@id="ctl00_ContentPlaceHolder1_GridView1"]/tbody/tr[1]/td[14]/table/tbody/tr/td  cout

            Date dt = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            c.add(Calendar.DATE, 0);
            dt = c.getTime();
            String Sdate = dateFormat.format(dt);
            ExcelUtils.setExcelFile(Path, "Action");
            ExcelUtils.setCellData1(Sdate, row, 19, Path, "Action");

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[1].value = arguments[0];", Sdate, FicheActionPage.gridActionRealisation.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr[" + k + "]/td[13]/table/tbody/tr/td[1]")).findElement(By.tagName("input")));

            Thread.sleep(500);

            i++;
        }

        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click()", FicheActionPage.WbtnVldTReall);
        Thread.sleep(500);


    }

    @When("suivre action avec {int} et {int}  triple SousAct")
    public void suivre_action_avec_et_triple_SousAct(Integer int1, Integer int2, DataTable dataTable) throws Throwable {
        Thread.sleep(1000L);
        //FicheActionPage.ActionSuivreXpath.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.ActionSuivreXpath);
        Thread.sleep(1000L);
        ExcelUtils.setExcelFile(Path, "Action");
        String NumAction = ExcelUtils.getCellData(row, 7);
        Thread.sleep(2000);
        try {
            FicheActionModele.saisirNumActionSuivre(NumAction);
        } catch (Throwable e) {
            JavascriptExecutor executor2 = (JavascriptExecutor) driver;
            executor2.executeScript("arguments[0].click()", FicheActionPage.ActionSuivreXpath);
            FicheActionModele.saisirNumActionSuivre(NumAction);
        }


        FicheActionModele.rechercherNumActionSuivre(driver);
        Thread.sleep(1000L);


        System.out.println("DATA2 " + dataTable);
        int i = 0, k = 0;
        JavascriptExecutor executor22 = (JavascriptExecutor) driver;
        executor22.executeScript("arguments[0].click()", FicheActionPage.EditTxSuiviId);


        while (i < dataTable.asList().size()) {
            k++;
            taux = Integer.toString(100);
            Thread.sleep(1000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            Thread.sleep(1000L);
            js.executeScript("arguments[0].scrollIntoView(true);", FicheActionPage.WgridActionSuivi.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView2\"]/tbody/tr[" + k + "]/td[15]/table/tbody/tr/td[1]")).findElement(By.tagName("input")));

            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("arguments[1].value =arguments[0];", "", FicheActionPage.WgridActionSuivi.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView2\"]/tbody/tr[" + k + "]/td[15]/table/tbody/tr/td[1]")).findElement(By.tagName("input")));
            js2.executeScript("arguments[1].value =arguments[0];", dataTable.asList().get(i), FicheActionPage.WgridActionSuivi.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView2\"]/tbody/tr[" + k + "]/td[15]/table/tbody/tr/td[1]")).findElement(By.tagName("input")));
            js2.executeScript("arguments[1].value =arguments[0];", "Report plan action Suivi", FicheActionPage.WgridActionSuivi.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView2\"]/tbody/tr[" + k + "]/td[16]/table/tbody/tr/td[1]")).findElement(By.tagName("textarea")));


            final DateFormat dateFormat;
            Cookie cookie1 = driver.manage().getCookieNamed("lan");
            if (cookie1.getValue().equals("en-US")) {
                dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            } else {
                dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            }
            Thread.sleep(1000L);

            taux = Integer.toString(Integer.parseInt(dataTable.asList().get(i)));
            ExcelUtils.setCellData1(taux, row, 20, Path, "Action");


            //*[@id="ctl00_ContentPlaceHolder1_GridView1"]/tbody/tr[1]/td[14]/table/tbody/tr/td  cout

            Date dt = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(dt);
            c.add(Calendar.DATE, 0);
            dt = c.getTime();
            String Sdate = dateFormat.format(dt);
            ExcelUtils.setExcelFile(Path, "Action");
            ExcelUtils.setCellData1(Sdate, row, 19, Path, "Action");

            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[1].value = arguments[0];", Sdate, FicheActionPage.gridActionRealisation.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView2\"]/tbody/tr[" + k + "]/td[13]/table/tbody/tr/td[1]")).findElement(By.tagName("input")));

            Thread.sleep(500);


            i++;
        }
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click()", FicheActionPage.wBtnVAlideSuivi);
    }

}


