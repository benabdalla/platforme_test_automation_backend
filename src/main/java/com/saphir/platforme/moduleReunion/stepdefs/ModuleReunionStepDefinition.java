package com.saphir.platforme.moduleReunion.stepdefs;

import com.github.javafaker.Faker;

import com.saphir.platforme.authentification.models.AuthentificationModel;
import com.saphir.platforme.controllors.ReunionController;
import com.saphir.platforme.entity.Reunion;
import com.saphir.platforme.moduleReunion.models.ModuleReunionModel;
import com.saphir.platforme.moduleReunion.pages.ModuleReunionPage;
import com.saphir.platforme.moduleReunion.pages.typeréunionpage;
import com.saphir.platforme.shared.DesignePaterne;
import com.saphir.platforme.utils.Common;
import com.saphir.platforme.utils.ExcelUtils;
import com.saphir.platforme.utils.RTFUtil;
import com.saphir.platforme.utils.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class ModuleReunionStepDefinition {

    public int compteur;
    public static String numero_reunion = "";
    public static String filaile = "";
    private static String Path = "resources/testData/TestData.xlsx";
    public List<String> informations = new ArrayList<String>();

    public static int row;


    public static WebDriver driver;
    static Reunion reunion;

    public ModuleReunionStepDefinition() {
        driver = Setup.driver;
        PageFactory.initElements(driver, ModuleReunionPage.class);
        reunion = ReunionController.reunion;
        driver = Setup.driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, typeréunionpage.class);
        PageFactory.initElements(driver, ModuleReunionPage.class);
    }

    @When("Connecter en tant participant que de reunion")
    public void connecter_en_tant_participant_que_de_reunion() throws Exception {

        AuthentificationModel.saisirLogin(reunion.getTypeReunion().getPourInfo().getLogin());


        Thread.sleep(200L);
        AuthentificationModel.saisirPW(reunion.getTypeReunion().getPourInfo().getPassword());

    }
    @When("Connecter en tant declencheur que de reunion")
    public void connecter_en_tant_declencheur_que_de_reunion() throws Exception {

        AuthentificationModel.saisirLogin(reunion.getTypeReunion().getDechlencheur().getLogin());;


        Thread.sleep(200L);
        AuthentificationModel.saisirPW(reunion.getTypeReunion().getDechlencheur().getPassword());

    }
    @And("saisir reunion filaile")
    public void saisir_reunion_filaile() throws InterruptedException {
        filaile = reunion.getTypeReunion().getFilialeDeclencheur();
        if(!filaile.equals("MONO")){

        Thread.sleep(2000);
        Select selectOpTGF = new Select((driver.findElement(By.id("ctl00_DDLFiliale"))));
        String gf = selectOpTGF.getFirstSelectedOption().getText();
        String valueFg=DesignePaterne.getFiliale(filaile);
        if (!filaile.equals(gf)) {
            selectOpTGF.selectByValue(valueFg);}
        }

    }


    @When("^consulter reunion$")
    public void consulter_reunion() throws Throwable {

        ModuleReunionModel.consulter_Reunion(driver,filaile);

    }

    @And("^cliquer sur ajouter$")
    public void cliquer_sur_ajouter() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(ModuleReunionPage.btnAjouterID));
        ModuleReunionModel.ajouterFicheReunion();
    }

    @When("^saisir (\\d+) reunion$")
    public void saisir_reunion(int arg1) throws Throwable {
        row = arg1;

    }


    @Then("^verifier le declencheur$")
    public void verifier_le_declencheur() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(ModuleReunionPage.declencheurID));
        String declencheur = ModuleReunionPage.declencheurID.getText();
        String declenche =reunion.getTypeReunion().getDechlencheur().getName();
        Assert.assertTrue(declencheur.contains(declenche));
    }

    @When("^saisir lieu$")
    public void saisir_lieu() throws Throwable {

        ModuleReunionModel.saisirLieu(reunion.getLieu());

    }

    @And("^choisir type reunion$")
    public void choisir_type_reunion() throws Throwable {
        ModuleReunionModel.ChoisirType(driver, row,reunion.getTypeReunion().getTypeReunion());


    }

    @And("^choisir date prevu$")
    public void choisir_date_prevu() throws Throwable {

        ModuleReunionModel.cliquerCalendrier();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(ModuleReunionPage.choixDateID));
        ModuleReunionModel.choisirDate();
    }

    @And("^saisir ordre de jour$")
    public void saisir_ordre_de_jour() throws Throwable {

        ModuleReunionModel.saisirOrdreDeJour(reunion.getOrderJour());

    }

    @And("^choisir site réunion$")
    public void choisir_site_réunion() throws Throwable {
        ModuleReunionModel.site(driver, row);
    }

    @And("^choisir processus réunion$")
    public void choisir_processus_réunion() throws Throwable {
        ModuleReunionModel.processus(driver, row);
    }

    @And("^choisir activité réunion$")
    public void choisir_activité_réunion() throws Throwable {
        ModuleReunionModel.activite(driver, row);

    }

    @And("^choisir direction réunion$")
    public void choisir_direction_réunion() throws Throwable {
        ModuleReunionModel.direction(driver, row);
    }

    @And("^choisir service réunion$")
    public void choisir_service_réunion() throws Throwable {
        ModuleReunionModel.service(driver, row);
    }

    @When("^cliquer sur Valider$")
    public void cliquer_sur_Valider() throws Throwable {

        ModuleReunionModel.cliquerValider();
    }

    @Then("^fiche reunion validé$")
    public void fiche_reunion_validé() throws Throwable {
        ExcelUtils.setExcelFile(Path, "Reunion");
        String Num_Fiche_Reunion = driver.findElement(By.id("ctl00_ContentPlaceHolder1_Text_Nreunion"))
                .getText();
        System.out.println("Fiche réunion crée sous numéro : " + Num_Fiche_Reunion);
        numero_reunion = Num_Fiche_Reunion;
        informations.add(Num_Fiche_Reunion);

      reunion.setNumFiche(Integer.parseInt(Num_Fiche_Reunion));
        Common.Exporter_visibilité("Fiche réunion:" + Num_Fiche_Reunion);
        Common.Exporter_champ_A_masquer("Fiche réunion: " + Num_Fiche_Reunion);
        Common.Exporter_numFiche("Fiche réunion: " + Num_Fiche_Reunion);
    }

    @When("cliquer sur Ajouter un participant")
    public void cliquer_sur_ajouter_un_participant() throws Throwable {

       // Common.scrollerPage();
        ModuleReunionModel.AjouterParticipant(driver);
        String value= DesignePaterne.getFiliale(reunion.getTypeReunion().getFilialeDeclencheur());
        if(!value.equals("MONO")){
        WebElement listFilaile = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ListBoxFiliale"));

        Select select = new Select(listFilaile);
        select.selectByValue(value);}
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton_RechEmpFil")).click();

        String parti = reunion.getTypeReunion().getPourInfo().getName();

        driver.findElement(By.id("ctl00_ContentPlaceHolder1_TextBox_GridViewEmpFiliale")).sendKeys(parti);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton63")).click();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridViewEmpFiliale")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewEmpFiliale\"]/tbody/tr[1]/td[1]")).findElement(By.tagName("input")).click();

        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton_ValidPresentFil")).click();
    }

    @When("^rechercher avec NomPrenom$")
    public void saisir_NomPrenom() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 800);
        wait.until(ExpectedConditions.visibilityOf(ModuleReunionPage.nomprenomXPATH));
        ModuleReunionModel.saisirNomPrenom();
    }


    @When("^selectionner participant$")
    public void selectionner_participant() throws Throwable {
        ModuleReunionModel.selectionnerParticipant();
    }

    @And("^cliquer sur valider$")
    public void cliquer_sur_valider() throws Throwable {

        ModuleReunionModel.cliquervalider();

        //Thread.sleep(3000);
    }

    @Then("^participant ajouter à Liste des participants$")
    public void participant_ajouter_à_Liste_des_participants() throws Throwable {

        Boolean ajouter = false;
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView2"))));
        WebElement table = driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView2"));
        List<WebElement> TotalRowCount = table.findElements(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_GridView2']/tbody/tr"));
        System.out.println("Nombre des enregistrement est: " + (TotalRowCount.size() - 1));

        if (TotalRowCount.size() > 1) {
            ajouter = true;
        }

        assertTrue("participant bien ajouter", ajouter);
    }

    @When("^verefier compteur agenda$")
    public void verefier_compteur_agenda() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.visibilityOf(ModuleReunionPage.cmptreunionID));

//        try {
//            if (ModuleReunionPage.cmptreunionID.getText() != "") {
//                compteur = Integer.parseInt(ModuleReunionPage.cmptreunionID.getText());
//                System.out.println("compteur: " + compteur);
//            } else {
//                compteur = 0;
//                System.out.println("compteur: " + compteur);
//            }
//        } catch (Exception e) {

        //}


    }

    @Then("^incrementation compteur agenda reunion$")
    public void incrementation_compteur_agenda_reunion() throws Throwable {
//        Boolean incrementation = false;
//        ModuleReunionPage.homeID.click();
//        Thread.sleep(2000);
//        //ModuleReunionModel.consulter_Reunion();
//        //Thread.sleep(2000);
//        //ModuleReunionPage.numeroReunion.sendKeys(numero_reunion);
//        //ModuleReunionPage.btnrechercherFicheReunion.click();
//        //ModuleReunionPage.listReunionID.click();
//        //Thread.sleep(2000);
//        WebDriverWait wait = new WebDriverWait(driver, 2000);
//        wait.until(ExpectedConditions.visibilityOf(ModuleReunionPage.cmptreunionID));
//        System.out.println("compteur1 : " + ModuleReunionPage.cmptreunionID.getText());
//        if (Integer.parseInt(ModuleReunionPage.cmptreunionID.getText()) == compteur + 2) {
//            incrementation = true;
//        }

        //	assertTrue("Compteur agenda reunion est incrémenté ", incrementation);

    }

    @When("^saisir numero reunion$")
    public void saisir_numero_reunion() throws Throwable {
        ModuleReunionPage.numeroReunion.sendKeys(numero_reunion);
    }

    @When("^saisir \"([^\"]*)\"$")
    public void saisir(String arg1) throws Throwable {
        ModuleReunionPage.numeroReunion.sendKeys(arg1);
    }

    @When("^cliquer sur rechercher reunion$")
    public void cliquer_sur_rechercher_reunion() throws Throwable {
        //ModuleReunionPage.btnrechercherFicheReunion.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", ModuleReunionPage.btnrechercherFicheReunion);
    }

    @When("^Ouvrir fiche reunion$")
    public void ouvrir_fiche_reunion() throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", ModuleReunionPage.listReunionID);
        //ModuleReunionPage.listReunionID.click();
    }

    @Then("^redirection vers fiche réunion$")
    public void redirection_vers_fiche_réunion() throws Throwable {
        System.out.println("redirection vers fiche réunion numéro : " + numero_reunion);
    }

    @When("^sélectionner Etat$")
    public void sélectionner_Etat() throws Throwable {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", ModuleReunionPage.enregistrement_Xpath);
        Thread.sleep(500);
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", ModuleReunionPage.realisation_Xpath);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(ModuleReunionPage.etatRealisationID));
        ModuleReunionPage.etatRealisationID.click();
        Thread.sleep(100);
    }


    @When("^saisir Date réalisation$")
    public void saisir_Date_réalisation() throws Throwable {
        //ModuleReunionPage.enregistrement_Xpath.click();
        //Thread.sleep(100);
        //ModuleReunionPage.realisation_Xpath.click();
        //Thread.sleep(200);
        ModuleReunionPage.etatRealisationID.click();
        Thread.sleep(100);
        ModuleReunionPage.calendrierRealisationID.click();
        ModuleReunionPage.choixDateRealisationID.click();
        //ModuleReunionPage.dateRealisationID.sendKeys("03/09/2018");
    }

    @When("^saisir Durée réalisée$")
    public void saisir_Durée_réalisée() throws Throwable {
        ModuleReunionPage.dureeRealisationID.sendKeys("3H");
    }

    @When("^cliquer sur valider Réalisation$")
    public void cliquer_sur_valider_Réalisation() throws Throwable {
        ModuleReunionPage.btnvaliderRealisationID.click();
    }

    @When("^Rattacher action$")
    public void rattacher_action() throws Throwable {

        /*Actions action = new Actions(driver);
        action.moveToElement(ModuleReunionPage.realisation_Xpath).perform();

         JavascriptExecutor executor = (JavascriptExecutor)driver;
         executor.executeScript("arguments[0].click()",ModuleReunionPage.realisation_Xpath);*/

        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(ModuleReunionPage.rattacherActionID));

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", ModuleReunionPage.rattacherActionID);

        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(ModuleReunionPage.rechercherActionID));

        ExcelUtils.setExcelFile(Path, "Action");
        ModuleReunionPage.rechercherActionID.sendKeys(ExcelUtils.getCellData(row+1, 7));
        ModuleReunionPage.VldrechercherActionID.click();
        Thread.sleep(500);
        ModuleReunionPage.choixActionXPATH.findElement(By.tagName("a")).click();
        Thread.sleep(1000);

    }

    @When("^cliquer sur valider Décision$")
    public void cliquer_sur_valider_Décision() throws Throwable {
        ModuleReunionPage.btnValiderDecisionsID.click();
        Thread.sleep(1000);
    }

    @Then("^Taux de réalisation actions est correctement calculer$")
    public void taux_de_réalisation_actions_est_correctement_calculer() throws Throwable {

        double taux = 0;
        double taux_realisation_Action;
        boolean comp = false;
        WebElement table = driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView3"));
        List<WebElement> TotalRowCount = table
                .findElements(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_GridView3']/tbody/tr"));
        System.out.println("Nombre des enregistrement est: " + (TotalRowCount.size()));

        List<WebElement> TotalTaux = table
                .findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView3\"]/tbody/tr/td[4]"));

        try {
            for (WebElement e : TotalTaux) {

                taux = taux + Integer.parseInt(e.getText());
            }
        } catch (Exception ex) {
            taux = 0;
        }
        taux = taux / (TotalRowCount.size());
        System.out.println("Taux_realisation: " + taux);
        System.out.println("Taux_realisation_Action: " + ModuleReunionPage.tauxRealisationAction.getAttribute("value"));

        taux_realisation_Action = Integer.parseInt(ModuleReunionPage.tauxRealisationAction.getAttribute("value"));
        System.out.println("round(Taux): " + Math.round(taux));
        if (taux_realisation_Action == Math.round(taux)) {
            comp = true;
            System.out.println("Taux realisation action  est correctement calculé");
        }

        assertTrue("Taux realisation action  n'est pas correctement calculé", comp);
    }

    @When("^saisir Commentaires$")
    public void saisir_Commentaires() throws Throwable {
        ModuleReunionPage.zoneCommentairesID.sendKeys("*******Commentaire test automatisé******");
    }

    @When("^cliquer sur valider Commentaires$")
    public void cliquer_sur_valider_Commentaires() throws Throwable {
        ModuleReunionPage.btnValiderCommantairesID.click();
    }

    @When("^cliquer sur Retour$")
    public void cliquer_sur_Retour() throws Throwable {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

        driver.findElement(By.id("ctl00_ContentPlaceHolder1_Retour")).click();
        Thread.sleep(1000);
        driver.navigate().back();
    }

    @When("^cliquer sur Demande action$")
    public void cliquer_sur_Demande_action() throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButtonDemand")).click();
        Thread.sleep(500);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton12")).click();
        Thread.sleep(500);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_TextBox7")).sendKeys("5");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton21")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView8\"]/tbody/tr[1]/td[1]")).findElement(By.tagName("input")).click();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton38")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_LinkButtonRetour\"]/span")).click();

    }

    @When("^cliquer sur Pièces jointes$")
    public void cliquer_sur_Pièces_jointes() throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton32")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton33")).click();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_tb_obj")).sendKeys("objet test pieces jointes automatique");
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_Panel_ajtpj\"]/div[2]/div[2]/div/div/span/label")).click();
        Thread.sleep(500);
        Runtime.getRuntime().exec("E:\\qualipro\\trunk\\AutomatisationTQualiPro_prod\\resources\\Scripts\\joindreFichier.exe");
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LB_vald_ajtpiec")).click();
        Thread.sleep(500);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton34")).click();
        Thread.sleep(500);


    }

    @When("^cliquer sur Personnes à informer$")
    public void cliquer_sur_Personnes_à_informer() throws Throwable {
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

        WebElement element1 = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton_Informe"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element1);
        Thread.sleep(500);

    }

    @When("^cliquer sur Selectionner Employe$")
    public void cliquer_sur_Selectionner_Employe() throws Throwable {
        Thread.sleep(500);
        ModuleReunionModel.cliquerSelectionnerEmploye(driver);
        Thread.sleep(500);
    }

    @When("^rechercher avec Nom Prenom Employe a informer$")
    public void saisir_Nom_Prenom_Employe() throws Throwable {
        ModuleReunionModel.RechercheEmployeInformer();
        Thread.sleep(500);
    }

    @When("^selectionner Employe$")
    public void selectionner_Employe() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView4\"]/tbody/tr[1]/td[1]")).findElement(By.tagName("input")).click();
        //ModuleReunionPage.choixEmplID.click();
        Thread.sleep(500);
    }

    @When("^cliquer sur valider selectionner Employe$")
    public void cliquer_sur_valider_selectionner_Employe() throws Throwable {
        ModuleReunionModel.cliquerValiderSelection();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_LinkButton_Retour\"]/span")).click();
        Thread.sleep(500);

    }

    @When("^choisir Type reunion$")
    public void choisir_Type_reunion() throws Throwable {
        Select typeReunion = new Select(ModuleReunionPage.numeroType1);
        //Select typeReunion = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_List_FType")));
        ExcelUtils.setExcelFile(Path, "Reunion");
        String typeR = ExcelUtils.getCellData1(row, 0);
        typeReunion.selectByVisibleText(typeR);

    }

    @When("^selectionner etat$")
    public void selectionner_etat() throws Throwable {
        Select etat = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_List_FEtat")));
        etat.selectByIndex(1);
        //etat.selectByVisibleText("Réalisée");
    }

    @When("^saisir Ordre de jour$")
    public void saisir_Ordre_de_jour() throws Throwable {

        ModuleReunionPage.numeroOrdre.sendKeys("Ordre de jour test");
    }

    @Then("^Liste des reunions contient la fiche reunion à recherche$")
    public void Liste_des_reunions_contient_la_fiche_reunion_à_recherche() throws Throwable {
        WebElement table = driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1"));
        List<WebElement> TotalRowCount = table
                .findElements(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_GridView1']/tbody/tr"));
        List<WebElement> numero = table
                .findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr[1]/td[2]"));
        System.out.println("get num: " + numero.get(0).getText());
        System.out.println("get size: " + TotalRowCount.size());
        assertTrue(numero.get(0).getText().contains(numero_reunion));
        //assertTrue(TotalRowCount.size() == 1);
    }

    @When("^cliquer sur PV$")
    public void cliquer_sur_PV() throws Throwable {
        ModuleReunionPage.pvActionID.click();
    }

    /*@When("^Exporter le rapport$")
    public void exporter_le_rapport() throws Throwable {
        JavascriptExecutor  executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", ModuleReunionPage.exportPVActionID);
    Screen s = new Screen();
        Screen s1 = new Screen();
        Screen s2 = new Screen();
        Screen s3 = new Screen();
        try {
            Pattern pattern = new Pattern("resources/imgs/Exporter_PV_reunion.PNG");
            Pattern pattern1 = new Pattern("resources/imgs/combo_exporter_pv_reunion.PNG");
            Pattern pattern2 = new Pattern("resources/imgs/Choix_combo_PV_reunion.PNG");
            Pattern pattern3 = new Pattern("resources/imgs/Btn_exporter_PV_reunion.PNG");
            s.click(pattern);
            s1.click(pattern1);
            s2.click(pattern2);
            s3.click(pattern3);
            Thread.sleep(8000);

        } catch (FindFailed e) {
            e.printStackTrace();
        }
        Runtime.getRuntime().exec("C:\\Qualipro_Auto\\AutomatisationTQualiPro_23\\AutomatisationTQualiPro_23\\resources\\Scripts\\EnregistrerFichier.exe");
        Thread.sleep(3000);
    }*/

    @Then("^vérifier si tous les donneés existe$")
    public void vérifier_si_tous_les_donneés_existe() throws Throwable {
        Thread.sleep(8000);

        String path = "resources/Telechargement/CrystalReportViewer1.rtf";
        String fileData = null;
        fileData = RTFUtil.ReadRTFFile(path);
        System.out.println("**************************************PV************************************************" + fileData);

        for (int i = 0; i < informations.size(); i++) {
            int j = i + 1;
            System.out.println("l'information " + j + ":" + informations.get(i));
            System.out.println("Existe: " + Common.ExisteWord(path, informations.get(i)));
            assertTrue(Common.ExisteWord(path, informations.get(i)));
        }
        driver.navigate().back();
    }

    @When("^consulter reporting$")
    public void consulter_reporting() throws Throwable {


    }

    @When("^cliquer sur liste des reunions$")
    public void cliquer_sur_liste_des_reunions() throws Throwable {
        //PageFactory.initElements(driver, ModuleReunionPage.class);
        Actions actions = new Actions(driver);
        WebElement moveonmenu = driver.findElement(By.xpath("//*[@id=\"menu_rep\"]/div/div/ul/li/ul/li[12]/a"));
        actions.moveToElement(moveonmenu)
                .moveToElement(driver.findElement(By.xpath("//*[@id=\"menu_rep\"]/div/div/ul/li/ul/li[12]/ul/li[1]/a")))
                .click().perform();
        Thread.sleep(1000);
        Select typeReunion = new Select(ModuleReunionPage.numeroType1);
        typeReunion.selectByVisibleText("WEEKend");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_Image1")).click();
        Thread.sleep(500);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender1_today")).click();

        driver.findElement(By.id("ctl00_ContentPlaceHolder1_Image2")).click();
        Thread.sleep(500);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender2_today")).click();

        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton11")).click();


    }

    @Then("^vérifier rapport$")
    public void vérifier_rapport() throws Throwable {

        Thread.sleep(4000);
        String path = "C:/Qualipro_Auto/AutomatisationTQualiPro_23/AutomatisationTQualiPro_23/resources/Telechargement/CrystalReportViewer1.rtf";
        String pathContext = "E:/qualipro/trunk/AutomatisationTQualiPro_prod/resources/apercu";
        String fileData = null;
        // Générer un nom significatif pour le fichier téléchargé
        String nom = Common.GenererNom("réunion", numero_reunion, ".rtf");

        // Renommer et Deplacer la fichier
        Common.RenomerDeplacer(nom, path, pathContext);
        fileData = RTFUtil.ReadRTFFile(pathContext);
        System.out.println(
                "**************************************Liste des reunions************************************************"
                        + fileData);

        System.out.println("Réunion numéro :" + numero_reunion);
        System.out.println("Existe: " + Common.ExisteWord(pathContext, numero_reunion));
        assertTrue(Common.ExisteWord(pathContext, numero_reunion));

    }

    @When("^Vérifier l'exportation Excel$")
    public void vérifier_l_exportation_Excel() throws Throwable {
        String excelLoc = "C:/Qualipro_Auto/AutomatisationTQualiPro_23/AutomatisationTQualiPro_23/resources/Telechargement/test.xlsx";

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(excelLoc));
            Workbook wb = WorkbookFactory.create(inputStream);
            int numberOfSheet = wb.getNumberOfSheets();
            System.out.println("number Of Sheet :" + numberOfSheet);

            Sheet sheet = wb.getSheetAt(0);
            Cell Cell = sheet.getRow(7).getCell(0);

            String CellData = Cell.getStringCellValue();

            System.out.println("Cell Data :" + CellData);

        } catch (Exception e) {

            throw (e);
        }

    }


    @When("consulter agenda reunion")
    public void consulter_agenda_reunion() throws InterruptedException {
        DesignePaterne.javaScriptExcuptor( driver.findElement(By.id("ctl00_LKB_badge_reun")));

    }

    @When("consulter réunion planifiée")
    public void consulter_réunion_planifiée() throws Exception {
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_num")).click();

       // numero_reunion = String.valueOf(reunion.getNumFiche());
        Common.agendaFG("ctl00_ContentPlaceHolder1_GridView_reunionplanifiee",reunion.getTypeReunion().getFilialeDeclencheur());

        driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView_reun_filter")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_reun_filter\"]/label/input")).clear();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView_reun_filter")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_reun_filter\"]/label/input")).sendKeys(String.valueOf(reunion.getNumFiche()));
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView_reun")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_reun\"]/tbody/tr[1]/td[1]")).findElement(By.tagName("a")).click();


    }

    @When("confirmer l’assistance des participants reunion")
    public void confirmer_l_assistance_des_participants_reunion() {
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_TextBox9")).click();
        Faker faker = new Faker();
        String comm = faker.lorem().paragraph();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_TextBox9")).sendKeys(comm);
        driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceHolder1_Panel_ConfAuditeur']/div[2]/div/div/span/label")).click();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton5")).click();

    }

    @When("consulter réunion pour info")
    public void consulter_réunion_pour_info() throws InterruptedException {
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_Label6")).click();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1_filter")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_filter\"]/label/input")).clear();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1_filter")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_filter\"]/label/input")).sendKeys(String.valueOf(reunion.getNumFiche()));
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr[1]/td[1]")).findElement(By.tagName("a")).click();
        driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceHolder1_Panel3']/div/div[2]/table/tbody/tr/td/span/label")).click();
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.id("ctl00_ContentPlaceHolder1_Retour")));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click()", driver.findElement(By.id("ctl00_ContentPlaceHolder1_Retour")));
        Thread.sleep(1000);
    }

    @Then("verfier réunion  consulter")
    public void verfier_réunion_consulter() {
        try {
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_Label6")).click();

            driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1_filter")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_filter\"]/label/input")).clear();
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1_filter")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_filter\"]/label/input")).sendKeys(String.valueOf(reunion.getNumFiche()));
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr[1]/td[1]")).findElement(By.tagName("a")).click();
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }


}
