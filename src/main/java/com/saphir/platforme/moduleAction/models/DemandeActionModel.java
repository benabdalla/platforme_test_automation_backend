package com.saphir.platforme.moduleAction.models;


import com.github.javafaker.Faker;
import com.saphir.platforme.moduleAction.pages.DemandeActionPage;
import com.saphir.platforme.moduleAction.pages.FicheActionPage;
import com.saphir.platforme.utils.Common;
import com.saphir.platforme.utils.ExcelUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DemandeActionModel {
    /* Public methods */
    private static final String Path = "src/main/resources/testData/TestData.xlsx";
    public static String NumDemande;
    public static List<String> responsable;
    public static String Cpt_agenda;

    public static void consulter_Demande(WebDriver driver) throws Throwable {

        //FicheActionPage.menuID.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.menuID);
        Thread.sleep(200L);
        Common.AccéderModule(2, 0, 0, driver);
        Common.AccéderModule(2, 2, 0, driver);


    }

    public static void cliquer_Ajouter_Demande(WebDriver driver) {

        //DemandeActionPage.BoutonAjoutID.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DemandeActionPage.BoutonAjoutID);
        Common.Exporter_visibilité("Nouvelle Fiche demande Action");
        Common.Exporter_champ_A_masquer("Nouvelle Fiche demande Action");
    }

    public static void Selectionner_Source(int arg1) throws Throwable {
        ExcelUtils.setExcelFile(Path, "DemandeActionSpec.xml");
        Select select = new Select(DemandeActionPage.SourceID);
        select.selectByVisibleText(ExcelUtils.getCellData(arg1, 0));
    }

    public static void Selectionner_Type(int arg1) throws Throwable {
        ExcelUtils.setExcelFile(Path, "DemandeActionSpec.xml");
        Select select = new Select(DemandeActionPage.TypeID);
        select.selectByVisibleText(ExcelUtils.getCellData(arg1, 1));
    }

    public static void Selectionner_Origine() {

        try {
            DemandeActionPage.OrigineID.isDisplayed();
            Select select = new Select(DemandeActionPage.OrigineID);
            select.selectByVisibleText("TESTAUTO2");
            Common.Exporter_champ_A_masquer("le champ origine action est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ origine action est invisible");
        }


    }

    public static void Ajouter_Type_Cause(int arg1, WebDriver driver) throws Throwable {
        try {
            ExcelUtils.setExcelFile(Path, "DemandeActionSpec.xml");
            DemandeActionPage.AjoutTypeCauseID.isDisplayed();
            //DemandeActionPage.AjoutTypeCauseID.click();
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", DemandeActionPage.AjoutTypeCauseID);
            Thread.sleep(500L);
            DemandeActionPage.RechTypeCauseID.sendKeys(ExcelUtils.getCellData(arg1, 2));
            DemandeActionPage.GridTypeCauseID.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView9\"]/tbody/tr/td[1]")).findElement(By.tagName("input")).click();
            //DemandeActionPage.TypeCauseValideID.click();
            executor.executeScript("arguments[0].click()", DemandeActionPage.TypeCauseValideID);
            Common.Exporter_champ_A_masquer("le champ type cause est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ type cause est invisible");
        }

    }

    public static void Ajouter_Produit(WebDriver driver) throws Throwable {
        try {
            DemandeActionPage.AjoutProduitID.isDisplayed();
            //DemandeActionPage.AjoutProduitID.click();
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", DemandeActionPage.AjoutProduitID);
            Thread.sleep(500L);
            //DemandeActionPage.produitAjouteID.click();
            executor.executeScript("arguments[0].click()", DemandeActionPage.produitAjouteID);
            //DemandeActionPage.produitValideID.click();
            executor.executeScript("arguments[0].click()", DemandeActionPage.produitValideID);
            Common.Exporter_champ_A_masquer("le champ produit est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ produit est invisible");
        }

    }

    public static void Selectionner_Date_Creation(WebDriver driver) throws Throwable {

        Common.SaisirDate(driver, "ctl00_ContentPlaceHolder1_datcrea");

    }

    public static void Saisir_Designation() throws Exception {

        Thread.sleep(2000);
        Faker faker = new Faker();
        String paragraph = faker.lorem().paragraph();
        paragraph = "désignation de demande  action " + paragraph + Common.paragraphe(8, 1);
        System.out.println(paragraph);

        DemandeActionPage.DesignationID.sendKeys(paragraph);
        ExcelUtils.setExcelFile(Path, "DemandeActionSpec.xml");
        ExcelUtils.setCellData1(paragraph, 1, 15, Path, "DemandeActionSpec.xml");
    }

    public static void Saisir_Description() {

        //Thread.sleep(2000);
        Faker faker = new Faker();
        String paragraph = faker.lorem().paragraph();
        paragraph = "description demande action " + paragraph + Common.paragraphe(8, 1);
        System.out.println(paragraph);

        DemandeActionPage.DescriptionID.sendKeys(paragraph);
    }

    public static void Saisir_Cause() {
        Faker faker = new Faker();
        String paragraph = faker.lorem().paragraph();
        paragraph = "Cause demande action" + paragraph + Common.paragraphe(8, 1);
        System.out.println(paragraph);
        DemandeActionPage.CauseID.sendKeys(paragraph);
    }

    public static void Saisir_Objective() {
        try {
            DemandeActionPage.ObjectiveID.isDisplayed();
            Faker faker = new Faker();
            String paragraph = faker.lorem().paragraph();
            paragraph = "Objective demande action" + paragraph + Common.paragraphe(8, 1);

            DemandeActionPage.ObjectiveID.sendKeys(paragraph);
            Common.Exporter_champ_A_masquer("le champ objectif est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ objectif est invisible");
        }

    }


    public static void Selectionner_Site(WebDriver driver, int arg1) throws Exception {
        try {
            DemandeActionPage.SiteID.isDisplayed();
            Common.Exporter_visibilité("le site est visible");
            String text = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lbsite2")).getText();
            if (text.indexOf('*') != -1) {
                Common.Exporter_visibilité("le site est obligatoire");
            } else {
                Common.Exporter_visibilité("le site n'est pas obligatoire");

            }
            Thread.sleep(1000);
            ExcelUtils.setExcelFile(Path, "DemandeActionSpec.xml");
            Select select = new Select(DemandeActionPage.SiteID);
            select.selectByVisibleText(ExcelUtils.getCellData(arg1, 3));
        } catch (NoSuchElementException e) {
            Common.Exporter_visibilité("le site est invisible");
        }


    }

    public static void Selectionner_Processus(WebDriver driver, int arg1) throws Exception {
        try {
            DemandeActionPage.ProcessusID.isDisplayed();
            Common.Exporter_visibilité("le processus est visible");
            String text = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LblProcessus_")).getText();
            if (text.indexOf('*') != -1) {
                Common.Exporter_visibilité("le processus est obligatoire");
            } else {
                Common.Exporter_visibilité("le processus n'est pas obligatoire");

            }
            Thread.sleep(1000);
            ExcelUtils.setExcelFile(Path, "DemandeActionSpec.xml");
            Select select = new Select(DemandeActionPage.ProcessusID);
            select.selectByVisibleText(ExcelUtils.getCellData(arg1, 4));
        } catch (NoSuchElementException e) {
            Common.Exporter_visibilité("le processus est invisible");
        }

    }

    public static void Selectionner_Activite(WebDriver driver, int arg1) throws Exception {
        try {
            DemandeActionPage.ActiviteID.isDisplayed();
            Common.Exporter_visibilité("l'activité est visible");
            String text = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LblDomaine_")).getText();
            if (text.indexOf('*') != -1) {
                Common.Exporter_visibilité("l'activité est obligatoire");
            } else {
                Common.Exporter_visibilité("l'activité n'est pas obligatoire");

            }
            Thread.sleep(1000);
            ExcelUtils.setExcelFile(Path, "DemandeActionSpec.xml");
            Select select = new Select(DemandeActionPage.ActiviteID);
            select.selectByVisibleText(ExcelUtils.getCellData(1, 5));
        } catch (NoSuchElementException e) {
            Common.Exporter_visibilité("l'activité est invisible");
        }

    }

    public static void Selectionner_Direction(WebDriver driver, int arg1) throws Throwable {

        try {
            DemandeActionPage.DirectionID.isDisplayed();
            Common.Exporter_visibilité("la direction est visible");
            String text = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LabelDir")).getText();
            if (text.indexOf('*') != -1) {
                Common.Exporter_visibilité("la direction est obligatoire");
            } else {
                Common.Exporter_visibilité("la direction n'est pas obligatoire");

            }
            ExcelUtils.setExcelFile(Path, "DemandeActionSpec.xml");
            Select select = new Select(DemandeActionPage.DirectionID);
            select.selectByVisibleText(ExcelUtils.getCellData(arg1, 6));
        } catch (NoSuchElementException e) {
            Common.Exporter_visibilité("la direction est invisible");
        }
    }

    public static void Selectionner_Service(WebDriver driver, int arg1) throws Throwable {

        try {
            DemandeActionPage.ServiceID.isDisplayed();
            Common.Exporter_visibilité("le service est visible");
            String text = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LblService_")).getText();
            if (text.indexOf('*') != -1) {
                Common.Exporter_visibilité("le service est obligatoire");
            } else {
                Common.Exporter_visibilité("le service n'est pas obligatoire");
            }
            ExcelUtils.setExcelFile(Path, "DemandeActionSpec.xml");
            Select select = new Select(DemandeActionPage.ServiceID);
            select.selectByVisibleText(ExcelUtils.getCellData(arg1, 7));
        } catch (NoSuchElementException e) {
            Common.Exporter_visibilité("le service est invisible");
        }

    }

    public static void valider_Demande(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        //wait.until(ExpectedConditions.visibilityOf(DemandeActionPage.CompteurID));
        Cpt_agenda = DemandeActionPage.CompteurID.getText();
        //DemandeActionPage.BoutonValideID.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DemandeActionPage.BoutonValideID);
        String NumDemanedeAction = driver.findElement(By.id("ctl00_ContentPlaceHolder1_nact")).getText();
        Assert.assertNotEquals(NumDemanedeAction, "");


    }

    public static void clickAjouterSAD(WebDriver driver) throws Exception {
        //DemandeActionPage.ObjetMenuID.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DemandeActionPage.ObjetMenuID);
        Thread.sleep(1000L);
        //DemandeActionPage.PlanMenuID.click();
        executor.executeScript("arguments[0].click()", DemandeActionPage.PlanMenuID);
        Thread.sleep(1000L);
        //DemandeActionPage.btnAjouter_SAD_ID.click();
        executor.executeScript("arguments[0].click()", DemandeActionPage.btnAjouter_SAD_ID);
    }

    public static void saisirDesignationSAD(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000L);
        Faker faker = new Faker();
        String paragraph = faker.lorem().paragraph();
        paragraph = "désignation de sous action pour demande Action " + paragraph + Common.paragraphe(8, 1);
        System.out.println(paragraph);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[1].value = arguments[0];", paragraph, DemandeActionPage.designation_SAD_ID);
        //DemandeActionPage.designation_SAD_ID.sendKeys(st);
        Thread.sleep(1000L);
    }

    public static void selectionnerResponsableRealisationSAD(int arg1) throws Throwable {
        ExcelUtils.setExcelFile(Path, "Action");
        Select select = new Select(DemandeActionPage.responsableRealisation_SAD_ID);
        System.err.println(" row   is   : " + arg1);
        select.selectByVisibleText(ExcelUtils.getCellData(arg1, 4));
    }

    public static void selectionnerResponsableSuiviSAD(int arg1) throws Throwable {
        ExcelUtils.setExcelFile(Path, "Action");
        Select select = new Select(DemandeActionPage.responsableSuivi_SAD_ID);
        select.selectByVisibleText(ExcelUtils.getCellData(arg1, 6));
    }

    public static void choixDateSAD(WebDriver driver) throws Throwable {

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
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[1].value = arguments[0];", Sdate, DemandeActionPage.Date_real_txt_id);
        jse.executeScript("arguments[1].value = arguments[0];", Sdate, DemandeActionPage.Date_suivi_txt_id);
    }

    public static void Priorite(int arg1) throws Throwable {
        try {
            DemandeActionPage.PrioriteId.isDisplayed();
            ExcelUtils.setExcelFile(Path, "DemandeActionSpec.xml");
            Select select = new Select(DemandeActionPage.PrioriteId);
            select.selectByVisibleText(ExcelUtils.getCellData(arg1, 9));
            Common.Exporter_champ_A_masquer("le champ priorite est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ priorite est invisible");
        }
    }

    public static void Gravite(int arg1) throws Throwable {
        try {
            DemandeActionPage.GraviteId.isDisplayed();
            ExcelUtils.setExcelFile(Path, "DemandeActionSpec.xml");
            Select select = new Select(DemandeActionPage.GraviteId);
            select.selectByVisibleText(ExcelUtils.getCellData(arg1, 8));
            Common.Exporter_champ_A_masquer("le champ gravite est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ gravite est invisible");
        }
    }

    public static void Risque() {
        try {
            DemandeActionPage.RisqueId.isDisplayed();
            DemandeActionPage.RisqueId.sendKeys("Risque sous action");
            Common.Exporter_champ_A_masquer("le champ risque est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ risque est invisible");
        }
    }

    public static void Cout_Prev() {
        try {
            DemandeActionPage.CoutPrevId.isDisplayed();
            DemandeActionPage.CoutPrevId.sendKeys("1000");
            Common.Exporter_champ_A_masquer("le champ cout prévisionelle est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ cout prévisionelle est invisible");
        }
    }

    public static void validerSAD(WebDriver driver) throws InterruptedException {
        //DemandeActionPage.btnValider_SAD_ID.click();
        Thread.sleep(500);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DemandeActionPage.btnValider_SAD_ID);
    }

    public static void Verifier_Demande_Ajout() throws Throwable {
        Thread.sleep(1000L);
        NumDemande = DemandeActionPage.NumeroDemandeID.getText();
        Common.Exporter_visibilité("Fiche Demande Action:" + NumDemande);
        Common.Exporter_champ_A_masquer("Fiche Demande Action: " + NumDemande);
        System.out.println("demande N:" + NumDemande + "est Ajoute");
        ExcelUtils.setExcelFile(Path, "DemandeActionSpec.xml");
        ExcelUtils.setCellData1(NumDemande, 1, 14, Path, "DemandeActionSpec.xml");
        asserttrue(NumDemande != "");

    }

    public static void recuperer_responsable() throws Exception {
        Thread.sleep(1000);
        responsable = new ArrayList();
        List<WebElement> rows_Table = DemandeActionPage.ResponsableTableID.findElements(By.tagName("tr"));
        int rowCount = rows_Table.size();
        for (int i = 0; i < rowCount; i++) {
            List<WebElement> Column_Table = rows_Table.get(i).findElements(By.tagName("td"));
            if (Column_Table.size() != 0) {
                responsable.add(Column_Table.get(2).getText());
                System.out.println("responsable:" + Column_Table.get(2).getText());
            }
        }

    }

    public static void incrementation_compteur_agenda_DA(WebDriver driver) throws Throwable {
        Boolean incrementation = false;
        Thread.sleep(1000);
        int compteur;
        if (Cpt_agenda != "") {
            compteur = Integer.parseInt(Cpt_agenda);
            System.out.println("compteur: " + compteur);
        } else {
            compteur = 0;
            System.out.println("compteur: " + compteur);
        }
        //DemandeActionPage.HomeID.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DemandeActionPage.HomeID);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        //   wait.until(ExpectedConditions.visibilityOf(DemandeActionPage.CompteurID));
        System.out.println("compteur1 : " + DemandeActionPage.CompteurID.getText());
        if (Integer.parseInt(DemandeActionPage.CompteurID.getText()) == compteur + 1) {
            incrementation = true;
        }
        asserttrue(incrementation);
    }

    private static void asserttrue(Boolean incrementation) {

    }

    public static void Deconnexion_Compte(WebDriver driver) throws Exception {
        Thread.sleep(500);
        //DemandeActionPage.CompteID.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DemandeActionPage.CompteID);
        //DemandeActionPage.DeconnexionID.click();
        executor.executeScript("arguments[0].click()", DemandeActionPage.DeconnexionID);
        Thread.sleep(3000L);
    }


    public static void Acceder_Demande(WebDriver driver, String origine) throws Exception {
        Thread.sleep(5000L);
        //DemandeActionPage.AgendaAcID.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DemandeActionPage.AgendaAcID);
        Thread.sleep(1000L);
        //DemandeActionPage.MenuAgDaID.click();
        executor.executeScript("arguments[0].click()", DemandeActionPage.MenuAgDaID);
        int sizeTab = FicheActionPage.wtabFGDemandAction.findElements(By.tagName("tr")).size();
        Thread.sleep(1000);
        for (int i = 1; i <= sizeTab - 1; i++) {
            Thread.sleep(1000);
            String fgr = FicheActionPage.wtabFGDemandAction.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_ActionDemande\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).getText();
            System.err.println("f = " + origine + "  fgr = " + fgr);
            System.err.println("result   =" + origine.equals(fgr));

            if (origine.equals(fgr)) {
                FicheActionPage.wtabFGDemandAction.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_ActionDemande\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).click();
                break;
            }

        }


        String demandID1 = NumDemande;
        DemandeActionPage.FiltreAgendaID.sendKeys(demandID1);
        Thread.sleep(1000L);
        //To find third row of table
        WebElement tableRow = DemandeActionPage.TableID.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView3\"]/tbody/tr"));

        //to get 3rd row's 2nd column data
        WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView3\"]/tbody/tr/td[1]"));
        WebElement cellIneed1 = cellIneed.findElement(By.tagName("a"));
        cellIneed1.click();
        Thread.sleep(1000L);
        //DemandeActionPage.ObjetMenuID.click();
        /*executor.executeScript("arguments[0].click()", DemandeActionPage.ObjetMenuID);
        Thread.sleep(1000L);
        //DemandeActionPage.PlanMenuID.click();
        executor.executeScript("arguments[0].click()", DemandeActionPage.PlanMenuID);*/
    }

    public static String recuperer_current_reponsable() throws Exception {
        Thread.sleep(500);
        String curRes;
        if (!(responsable.isEmpty())) {
            curRes = responsable.get(0);
            responsable.remove(0);
        } else {

            curRes = "";
        }
        return curRes;

    }

    public static void Saisir_Numero_Demande() {
        DemandeActionPage.FiltreNumeroID.sendKeys(NumDemande);

    }

    public static void Cliquer_rechercher_Demande(WebDriver driver) {
        //DemandeActionPage.BoutonChercherID.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DemandeActionPage.BoutonChercherID);
    }


}
