package com.saphir.platforme.moduleAction.models;


import com.github.javafaker.Faker;
import com.saphir.platforme.entity.DemandeAction;
import com.saphir.platforme.moduleAction.pages.ActSimplPage;
import com.saphir.platforme.moduleAction.pages.FicheActionPage;
import com.saphir.platforme.moduleAction.stepdefs.ActSimplStepDefinition;
import com.saphir.platforme.shared.DesignePaterne;
import com.saphir.platforme.utils.Common;
import com.saphir.platforme.utils.ExcelUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import static com.saphir.platforme.controllors.ActionRunTest.action;
import static com.saphir.platforme.controllors.DemandeActionController.demandeAction;


public class FicheActionModele {

    private static final String Path = "resources/testData/TestData.xlsx";
    public static List<String> informations = new ArrayList<String>();
    public static HashMap<String, String> filtre_repor = new HashMap<>();
    //private static String Path = "resources/testData/TestData2.xlsx";
    static int i = 1;

    public static void consulter_types_d_action(WebDriver driver) throws Exception {
        Thread.sleep(1000L);
        //FicheActionPage.menuID.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.menuID);
        Thread.sleep(200L);
        Common.AccéderModule(2, 0, 0, driver);
        Common.AccéderModule(2, 7, 0, driver);

    }


    public static void ajouter_types_d_action() {
        FicheActionPage.wAjouttype.click();

    }


    public static void saisir_type_d_action(int row) throws Exception {

        Thread.sleep(2000);
        String st = "";

        if (action.getActSimplifier() == 1) {
            st = "Type Action Simplifier Auto" + LocalDateTime.now();

            FicheActionPage.wsaitype.sendKeys(st);
            FicheActionPage.wchekSimptype.click();

        }

       else if (!(demandeAction.getIdScenario() ==null)) {
            st = "Type Action Simplifier Auto" + LocalDateTime.now();

            FicheActionPage.wsaitype.sendKeys(st);
            FicheActionPage.wchekSimptype.click();

        }

        else {
            st = "Type Action Details Auto" + LocalDateTime.now();
            FicheActionPage.wsaitype.sendKeys(st);
            FicheActionPage.wnancastype.click();

        }

        action.setTypeAction(st);

    }


    public static void clique_sur_valider(int row) throws Exception {
        FicheActionPage.btnValiderSousAction.click();
        FicheActionPage.EditTxReaId.click();
        ExcelUtils.setExcelFile(Path, "Input");
        //ExcelUtils.setCellData1(st, row, 1, Path,"Action");
        String employer = ExcelUtils.getCellData1(row, 1);
        System.err.println("Employee  is   :   " + employer);
        FicheActionPage.wrecheperson.sendKeys(employer);
        List<WebElement> rows = FicheActionPage.wtabpersonne.findElements(By.tagName("tr"));
        for (int i = 1; i < rows.size(); i++) {
            FicheActionPage.wtabpersonne.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_Employe_wrapper\"]/div[2]/div/table/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("input")).click();
        }
        FicheActionPage.wvalidetpreson.click();
        FicheActionPage.wretourSource.click();
    }


    public static void verifier_type_d_action(int row, WebDriver driver) throws Exception {
        Cookie cookie1 = driver.manage().getCookieNamed("lan");
        if (!ActSimplStepDefinition.actionSimpl.equals("")) {

            String st = action.getTypeAction();
            FicheActionPage.wrecherchetype.sendKeys(st);
            Assert.assertEquals(st, FicheActionPage.wtabtypeAct.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_wrapper\"]/div[2]/div/table/tbody/tr[1]/td[2]")).getText());
            String acttionSimpl = FicheActionPage.wtabtypeAct.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_wrapper\"]/div[2]/div/table/tbody/tr[1]/td[3]")).getText();
            String cause = FicheActionPage.wtabtypeAct.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_wrapper\"]/div[2]/div/table/tbody/tr[1]/td[4]")).getText();
            if (cookie1.getValue().equals("en-US")) {
                Assert.assertEquals("Yes", acttionSimpl);
                Assert.assertEquals(cause, "No");
            } else {
                Assert.assertEquals("OUI", acttionSimpl);
                Assert.assertEquals(cause, "NON");

            }


        } else {

            ExcelUtils.setExcelFile(Path, "Action");
            String st = ExcelUtils.getCellData1(row, 1);
            FicheActionPage.wrecherchetype.sendKeys(st);
            Assert.assertEquals(st, FicheActionPage.wtabtypeAct.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_wrapper\"]/div[2]/div/table/tbody/tr[1]/td[2]")).getText());
            String acttionSimpl = FicheActionPage.wtabtypeAct.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_wrapper\"]/div[2]/div/table/tbody/tr[1]/td[3]")).getText();
            String cause = FicheActionPage.wtabtypeAct.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_wrapper\"]/div[2]/div/table/tbody/tr[1]/td[4]")).getText();
            if (cookie1.getValue().equals("en-US")) {
                Assert.assertEquals(acttionSimpl, "No");
                Assert.assertEquals(cause, "Yes");
            } else {
                Assert.assertEquals(cause, "OUI");
                Assert.assertEquals(acttionSimpl, "NON");
            }


        }


        Thread.sleep(1000);

    }


    public static void consulter_source_d_action(WebDriver driver) throws Exception {

        Thread.sleep(1000L);
        //FicheActionPage.menuID.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.menuID);
        Thread.sleep(200L);
        Common.AccéderModule(2, 0, 0, driver);
        Common.AccéderModule(2, 6, 0, driver);


    }


    public static void ajouter_source_d_action() {
        FicheActionPage.wbtnAjouSource.click();

    }

    public static void saisir_source_d_action() throws Exception {
        Thread.sleep(2000);
        if (demandeAction.getIdScenario() != null) {
            String st = "Source de demandeAction  Auto" + LocalDateTime.now();
            action.setSource(st);
            FicheActionPage.wource.sendKeys(st);
            FicheActionPage.wcheckBoxActionSimplifier.click();


        }
        else if (ActSimplStepDefinition.actionSimpl != "") {
            String st = "Source Action Simplifier Auto" + LocalDateTime.now();
            action.setSource(st);
            FicheActionPage.wource.sendKeys(st);
        }

        else {
            String st = "Source Action Auto" + LocalDateTime.now();
            action.setSource(st);
            FicheActionPage.wource.sendKeys(st);

        }
    }


    public static void clique_source_d_action() {
        FicheActionPage.wValidSource.click();
        FicheActionPage.wretourSource.click();

    }


    public static void verifier_source_d_action(int row, WebDriver driver) throws Exception {
        String st = "";
        if (ActSimplStepDefinition.actionSimpl != "") {

            st = action.getSource();
        } else {
            ExcelUtils.setExcelFile(Path, "Action");
            st = action.getSource();
        }
        FicheActionPage.wrecherSource.sendKeys(st);
        FicheActionPage.wbtnrecherSource.click();
        Assert.assertEquals(FicheActionPage.wverfiSource.getText(), st);
        String simplifier = FicheActionPage.wTabSource.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr/td[3]")).findElement(By.tagName("span")).getText();
        Cookie cookie1 = driver.manage().getCookieNamed("lan");
        if (ActSimplStepDefinition.actionSimpl != "") {

            if (cookie1.getValue().equals("en-US")) {
                Assert.assertEquals(simplifier, "Yes");
            } else {
                Assert.assertEquals(simplifier, "OUI");
            }

        } else {
            if (cookie1.getValue().equals("en-US")) {
                Assert.assertEquals(simplifier, "No");
            } else {
                Assert.assertEquals(simplifier, "NON");
            }
        }


    }

    public static void ajouter_type_de_causes(WebDriver driver) throws Throwable {
        Thread.sleep(2000L);
        //FicheActionPage.menuID.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.menuID);
        Thread.sleep(200L);
        Common.AccéderModule(2, 0, 0, driver);
        Common.AccéderModule(2, 8, 0, driver);

        FicheActionPage.btnAjouterAction.click();

    }


    public static void saisir_type_de_causes(int row) throws Throwable {
        Thread.sleep(2000);
        String st = "type de causes auto" + LocalDateTime.now();
        action.setTypeCause(st);
        FicheActionPage.wtypecaus.sendKeys(st);
        FicheActionPage.btnValiderSousAction.click();


    }


    public static void verifier_type_de_causes(int row) throws Throwable {
        FicheActionPage.wretourSource.click();
        String st = action.getTypeCause();
        FicheActionPage.wrecherchetype.sendKeys(st);
        Assert.assertEquals(FicheActionPage.gridActionRealisation.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_wrapper\"]/div[2]/div/table/tbody/tr[1]/td[2]")).getText(), st);


    }

    public static void ajouter_priorité(WebDriver driver) throws Throwable {

        Thread.sleep(2000L);
        //FicheActionPage.menuID.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.menuID);
        Thread.sleep(200L);
        Common.AccéderModule(2, 0, 0, driver);
        Common.AccéderModule(2, 10, 0, driver);
        FicheActionPage.btnAjouterAction.click();

    }


    public static void saisir_priorité(int row) throws Throwable {

        Thread.sleep(2000);
        String st = "Priorité" + LocalDateTime.now();
        action.setPriorite(st);
        FicheActionPage.wtypecaus.sendKeys(st);
        FicheActionPage.btnValiderSousAction.click();


    }


    public static void verifier_priorité(int row) throws Throwable {
        FicheActionPage.wretourSource.click();

        ExcelUtils.setExcelFile(Path, "Action");
        String st = action.getPriorite();
        FicheActionPage.wrecherchetype.sendKeys(st);
        Assert.assertEquals(st, FicheActionPage.wtabtypeAct.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_wrapper\"]/div[2]/div/table/tbody/tr[1]/td[2]")).getText());

        Thread.sleep(1000);
    }


    public static void ajouter_gravité(WebDriver driver) throws Throwable {
        Thread.sleep(2000L);
        //FicheActionPage.menuID.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.menuID);
        Thread.sleep(200L);
        Common.AccéderModule(2, 0, 0, driver);
        Common.AccéderModule(2, 11, 0, driver);
        FicheActionPage.btnAjouterAction.click();

    }


    public static void saisir_gravité(int row) throws Throwable {
        Thread.sleep(2000);
        String st = "Gravité " + LocalDateTime.now();
        action.setGravite(st);
        FicheActionPage.wsaitype.sendKeys(st);
        FicheActionPage.wValidSource.click();

    }


    public static void verifier_gravité(int row) throws Throwable {
        FicheActionPage.wretourSource.click();
        String st = action.getGravite();
        FicheActionPage.wrecherchetype.sendKeys(st);
        Assert.assertEquals(st, FicheActionPage.wtabtypeAct.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_wrapper\"]/div[2]/div/table/tbody/tr[1]/td[2]")).getText());

        Thread.sleep(1000);


    }

    public static void Saisir_Responsable_Cloture(WebDriver driver) throws InterruptedException {
        String site = action.getSite().getSite();
        String processus = action.getProcessus().getProcessus();
        String valueSite = Common.getValueSelected(FicheActionPage.wsite, site);
        Select selectSite = new Select(FicheActionPage.wsite);
        selectSite.selectByValue(valueSite);
        Thread.sleep(2000);
        boolean exsiste = false;

        String valueProcessus = Common.getValueSelected(FicheActionPage.wprocess, processus);
        Select selectProcessus = new Select(FicheActionPage.wprocess);
        selectProcessus.selectByValue(valueProcessus);
        Thread.sleep(2000);
        String respoClot = action.getRespCloture().getName();


        try {
            FicheActionPage.tabRespoCloture.isDisplayed();
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1_filter")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_filter\"]/label/input")).sendKeys(respoClot);
            String nameCloture = FicheActionPage.tabRespoCloture.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr/td[3]")).findElement(By.tagName("span")).getText();
            if (nameCloture.equals(respoClot)) {
                exsiste = true;
            }
        } catch (NoSuchElementException ex) {
            exsiste = false;
        }
        if (!exsiste) {

            FicheActionPage.wajouterRespoClot.click();
            Common.waitForVisibility(FicheActionPage.wrechrecher);
            FicheActionPage.wrechrecher.sendKeys(respoClot);
            FicheActionPage.btnRrechreche.click();
            Common.waitForVisibility(FicheActionPage.wtabRespoCloture);
            FicheActionPage.wtabRespoCloture.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridVghj\"]/tbody/tr[1]/td[1]")).findElement(By.tagName("input")).click();
            FicheActionPage.wValiderRespoCloture.click();
        }

    }

    public static void verifier_Responsable_Cloture(WebDriver driver) throws InterruptedException {
        String respoClot = action.getRespCloture().getName();
        FicheActionPage.tabRespoCloture.isDisplayed();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1_filter")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_filter\"]/label/input")).clear();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1_filter")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_filter\"]/label/input")).sendKeys(respoClot);
        String nameCloture = FicheActionPage.tabRespoCloture.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr/td[3]")).findElement(By.tagName("span")).getText();
        Assert.assertEquals(nameCloture, respoClot, "responsable cloture n'est  pas   enrrgistré ");
    }

    public static void consulter_Action(WebDriver driver) throws Throwable {
        Thread.sleep(2000L);
        //FicheActionPage.menuID.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.menuID);
        Thread.sleep(200L);
        Common.AccéderModule(2, 0, 0, driver);
        Common.AccéderModule(2, 1, 0, driver);
        Thread.sleep(200L);

    }

    public static void ajouter_action_détaillée(WebDriver driver) throws InterruptedException {
        //FicheActionPage.btnAjouterAction.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.btnAjouterAction);
        Thread.sleep(1000L);
        //FicheActionPage.btnajouter_action_detaillee.click();
        executor.executeScript("arguments[0].click()", FicheActionPage.btnajouter_action_detaillee);
        Thread.sleep(1000L);
        Common.Exporter_visibilité("Nouvelle Fiche Action");
        Common.Exporter_champ_A_masquer("Nouvelle Fiche Action");
    }

    public static void selectionnerSourceModeleAction(String actionSimpl, WebDriver driver) throws Throwable {


        WebElement select = FicheActionPage.sourceId;
        Select selected = new Select(FicheActionPage.sourceId);

        if (demandeAction != null) {

            String source = demandeAction.getSource().trim();
            ((JavascriptExecutor) driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", select, source);


        }else {
        informations.add(action.getSource());
        if (actionSimpl == "") {
            String source = action.getSource();
//String  getValSource =Common.getValueSelected(select,source);
            try {
                selected.selectByVisibleText(source);
                informations.add(action.getSource());

                String option_Selected = action.getSource();
                System.out.println("option_Selected " + option_Selected);

                Assert.assertEquals(option_Selected, option_Selected);
            } catch (Exception e) {
                DesignePaterne.getOptiontext(FicheActionPage.sourceId);
            }
        } else {

            // select.selectByVisibleText(ExcelUtils.getCellData(row, 3).trim());
            String source = action.getSource().trim();
            ((JavascriptExecutor) driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", select, source);

            informations.add(action.getSource());

            String option_Selected = selected.getFirstSelectedOption().getText();
            if (option_Selected == "") {
                DesignePaterne.getOptiontext(FicheActionPage.sourceId);
            } else {
                Assert.assertEquals(option_Selected, option_Selected);

            }


        }


    }
    }

//	try  {	select.selectByVisibleText(ExcelUtils.getCellData(row, 0));}
//	catch(Exception ex){
//		select.selectByVisibleText(ExcelUtils.getCellData(row, 0));
//		informations.add(ExcelUtils.getCellData(row,0));
//	}


    public static void choixDate(WebDriver driver, int row) throws Throwable {
        SimpleDateFormat dateFormat;
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
        jse.executeScript("arguments[1].value = arguments[0];", Sdate, FicheActionPage.calenrierId);
        Thread.sleep(500);


        /*
        FicheActionPage.calenrierId.click();
        //JavascriptExecutor executor =(JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].click()", FicheActionPage.calenrierId);
        FicheActionPage.choixDateId.click();
        //executor.executeScript("arguments[0].click()", FicheActionPage.choixDateId);
        String value=driver.findElement(By.id("ctl00_ContentPlaceHolder1_datcrea")).getAttribute("value");
        System.out.println(value);
        ExcelUtils.setExcelFile(Path, "Action");
        ExcelUtils.setCellData1(value, row ,8 , Path) ;*/
    }

    public static void origine_action(int row) {
        try {
            FicheActionPage.ORIGINEId.isDisplayed();
            Select select = new Select(FicheActionPage.ORIGINEId);
            ExcelUtils.setExcelFile(Path, "Input");
            //ExcelUtils.setCellData1(st, row, 1, Path,"Action");
            String employer = action.getDechlencheur().getName();
            System.err.println("Employee  is   :   " + employer);
            select.selectByVisibleText(employer);
            Common.Exporter_champ_A_masquer("le champ origine action est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ origine action est invisible");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void rattacher_produit(WebDriver driver) throws Throwable {
        try {
            FicheActionPage.AjtProdId.isDisplayed();
            //FicheActionPage.AjtProdId.click();
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", FicheActionPage.AjtProdId);
            Thread.sleep(1000);
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_TextBox34")).sendKeys(action.getProduit());
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton90")).click();
            executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", FicheActionPage.ChxProdId.findElement(By.xpath("//*[@id=\"myModalRatproduit\"]/div/div/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td[1]")).findElement(By.tagName("input")));
            Thread.sleep(2000);
            FicheActionPage.VldProdId.click();
            //JavascriptExecutor executor3 =(JavascriptExecutor)driver;

            //executor3.executeScript("arguments[0].click()", FicheActionPage.VldProdId);
            Thread.sleep(300);

            Common.Exporter_champ_A_masquer("le champ produit est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ produit est invisible");
        }
    }

    public static void rattacher_Type_cause(WebDriver driver, int row) throws Throwable {
        try {

            FicheActionPage.AjtTypCauseId.isDisplayed();
            ExcelUtils.setExcelFile(Path, "Action");
            //FicheActionPage.AjtTypCauseId.click();
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", FicheActionPage.AjtTypCauseId);
            Thread.sleep(1000);
            FicheActionPage.RechTypCauseId.sendKeys(action.getTypeCause());
            FicheActionPage.GridTypCauseId.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView9\"]/tbody/tr/td[1]")).findElement(By.tagName("input")).click();
            Thread.sleep(1000);
            //FicheActionPage.VldTypCauseId.click();
            executor.executeScript("arguments[0].click()", FicheActionPage.VldTypCauseId);
            Thread.sleep(1000);
            Common.Exporter_champ_A_masquer("le champ type cause est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ type cause est invisible");
        }
    }

    public static void rattacher_intervenant(WebDriver driver, int row) throws Throwable {
        try {
            Thread.sleep(300);
            FicheActionPage.PanelIntervId.isDisplayed();
            List<WebElement> Exist = driver.findElements(By.id("ctl00_ContentPlaceHolder1_GridView_Intervenants"));
            if (Exist.size() == 0) {
                //FicheActionPage.PanelIntervId.click();
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click()", FicheActionPage.PanelIntervId);
                Thread.sleep(300);
                //FicheActionPage.AjtIntervId.click();
                executor.executeScript("arguments[0].click()", FicheActionPage.AjtIntervId);
                Thread.sleep(300);
                ExcelUtils.setExcelFile(Path, "Input");
                //ExcelUtils.setCellData1(st, row, 1, Path,"Action");
                String employer = action.getDechlencheur().getName();
                System.err.println("Employee  is   :   " + employer);
                FicheActionPage.RechInetervId.sendKeys(employer);
                Thread.sleep(300);
                //FicheActionPage.ChxIntervId.findElement(By.tagName("input")).click();
                executor.executeScript("arguments[0].click()", FicheActionPage.ChxIntervId.findElement(By.tagName("input")));
                Thread.sleep(300);
                //FicheActionPage.VldIntervId.click();
                executor.executeScript("arguments[0].click()", FicheActionPage.VldIntervId);
                Thread.sleep(300);
            }

            Common.Exporter_champ_A_masquer("le champ intervenant est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ intervenant est invisible");
        }
    }

    public static void objectif() throws Throwable {
        try {
            FicheActionPage.ObjectifId.isDisplayed();
            FicheActionPage.ObjectifId.sendKeys("Objectif Action");
            Common.Exporter_champ_A_masquer("le champ objectif est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ objectif est invisible");
        }
    }

    public static void Ref_Audit(int row) throws Throwable {
        try {
            FicheActionPage.RefAuditId.isDisplayed();
            ExcelUtils.setExcelFile(Path, "Action");
            Select select = new Select(FicheActionPage.RefAuditId);
            select.selectByVisibleText("");
            Common.Exporter_champ_A_masquer("le champ ref audit est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ ref audit est invisible");
        }
    }

    public static void Priorite(int row) throws Throwable {
        try {
            FicheActionPage.PrioriteId.isDisplayed();
            ExcelUtils.setExcelFile(Path, "Action");
            Select select = new Select(FicheActionPage.PrioriteId);
            select.selectByVisibleText(action.getPriorite());
            Common.Exporter_champ_A_masquer("le champ priorite est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ priorite est invisible");
        }
    }

    public static void Gravite(int row) throws Throwable {
        try {
            FicheActionPage.GraviteId.isDisplayed();
            Select select = new Select(FicheActionPage.GraviteId);
            select.selectByVisibleText(action.getGravite());
            Common.Exporter_champ_A_masquer("le champ gravite est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ gravite est invisible");
        }
    }

    public static void Risque() {
        Faker faker = new Faker();
        try {
            FicheActionPage.RisqueId.isDisplayed();
            FicheActionPage.RisqueId.sendKeys("Risque sous action" + faker.lorem().paragraph());
            Common.Exporter_champ_A_masquer("le champ risque est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ risque est invisible");
        }
    }

    public static void Cout_Prev() {
        Faker faker = new Faker();

        try {
            FicheActionPage.CoutPrevId.isDisplayed();
            FicheActionPage.CoutPrevId.sendKeys(String.valueOf(faker.number().numberBetween(100, 10000)));
            Common.Exporter_champ_A_masquer("le champ cout prévisionelle est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ cout prévisionelle est invisible");
        }
    }

    public static void designationModeleAction(int row) throws Throwable {

        Thread.sleep(2000);
        Faker faker = new Faker();
        String paragraph = faker.lorem().paragraph();
        paragraph = "désignation de modele action " + paragraph + Common.paragraphe(8, 1);
        System.out.println(paragraph);
        System.out.println("row  desaignation :" + row);

        FicheActionPage.designationId.sendKeys(paragraph);
        action.setDesignation(paragraph);
        informations.add(ExcelUtils.getCellData(row, 25));
    }

    public static void saisirCausesPossibles() {
        Faker faker = new Faker();
        faker.lorem().paragraph();
        FicheActionPage.causesPossiblesId.sendKeys("Test Auto" + faker.lorem().paragraph());
        informations.add(FicheActionPage.causesPossiblesId.getText());
    }

    public static void selectionnerTypeModeleAction(int row, WebDriver driver) throws Throwable {

        WebElement select = FicheActionPage.listeTypeId;
        Select selected = new Select(select);

        if(demandeAction!=null){
            String type = demandeAction.getTypeAction();
            ((JavascriptExecutor) driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", select, type);

        }else{



        String type = action.getTypeAction();
        if (ActSimplStepDefinition.actionSimpl == "") {

            ((JavascriptExecutor) driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", select, type);
        } else {
            ((JavascriptExecutor) driver).executeScript("var select = arguments[0]; for(var i = 0; i < select.options.length; i++){ if(select.options[i].text == arguments[1]){ select.options[i].selected = true; } }", select, type);


        }

        String option_Selected = selected.getFirstSelectedOption().getText();
        if (option_Selected == "") {
            DesignePaterne.getOptiontext(select);
        } else {
            Assert.assertEquals(option_Selected, option_Selected);

        }}


    }

    public static void saisirDescription(int row) throws Throwable {
        Faker faker = new Faker();
        String paragraph = faker.lorem().paragraph();
        paragraph = paragraph + Common.paragraphe(8, 1);
        System.out.println(paragraph);
        FicheActionPage.descriptionObjetId.sendKeys(paragraph);
        action.setDescription(paragraph);
        informations.add(ExcelUtils.getCellData(1, 12));

    }

    public static void selectionnerSiteModeleAction(WebDriver driver, int row) throws Throwable {
        try {

            FicheActionPage.siteId.isDisplayed();
            Common.Exporter_visibilité("le site est visible");
            String text = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lbsite2")).getText();
            if (text.indexOf('*') != -1) {
                Common.Exporter_visibilité("le site est obligatoire");
            } else {
                Common.Exporter_visibilité("le site n'est pas obligatoire");

            }
            Select select = new Select(FicheActionPage.siteId);
            select.selectByVisibleText(action.getSite().getSite());
            Thread.sleep(500);
        } catch (NoSuchElementException e) {
            Common.Exporter_visibilité("le site est invisible");
        }

    }

    public static void selectionnerProcessus(WebDriver driver, int row) throws Throwable {
        try {
            FicheActionPage.processusId.isDisplayed();
            Common.Exporter_visibilité("le processus est visible");
            String text = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LblProcessus_")).getText();
            ExcelUtils.setExcelFile(Path, "Action");
            if (text.indexOf('*') != -1) {
                Common.Exporter_visibilité("le processus est obligatoire");
            } else {
                Common.Exporter_visibilité("le processus n'est pas obligatoire");

            }
            Thread.sleep(500);
            Select select = new Select(FicheActionPage.processusId);
            Thread.sleep(500);
            select.selectByVisibleText(action.getProcessus().getProcessus());
            Thread.sleep(500);
            informations.add(ExcelUtils.getCellData(row, 14));
            Thread.sleep(500);
        } catch (NoSuchElementException e) {
            Common.Exporter_visibilité("le processus est invisible");
        }
    }

    public static void selectionnerActivite(WebDriver driver, int row) throws Throwable {
        try {
            FicheActionPage.activiteId.isDisplayed();
            Common.Exporter_visibilité("l'activité est visible");
            String text = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LblDomaine_")).getText();
            if (text.indexOf('*') != -1) {
                Common.Exporter_visibilité("l'activité est obligatoire");
            } else {
                Common.Exporter_visibilité("l'activité n'est pas obligatoire");

            }
            ExcelUtils.setExcelFile(Path, "Action");
            Select select = new Select(FicheActionPage.activiteId);
            if(action.getActivite()!=null){
            select.selectByVisibleText(action.getActivite().getActivite());}
            informations.add(ExcelUtils.getCellData(row, 15));
        } catch (NoSuchElementException e) {
            Common.Exporter_visibilité("l'activité est invisible");
        }

    }

    public static void selectionnerDirection(WebDriver driver, int row) throws Throwable {
        try {
            FicheActionPage.directionId.isDisplayed();
            Common.Exporter_visibilité("la direction est visible");
            String text = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LabelDir")).getText();
            if (text.indexOf('*') != -1) {
                Common.Exporter_visibilité("la direction est obligatoire");
            } else {
                Common.Exporter_visibilité("la direction n'est pas obligatoire");

            }
            ExcelUtils.setExcelFile(Path, "Action");
            Select select = new Select(FicheActionPage.directionId);
            if(action.getDirection()!=null){
            select.selectByVisibleText(action.getDirection().getDirection());}
            informations.add(ExcelUtils.getCellData(row, 16));
        } catch (NoSuchElementException e) {
            Common.Exporter_visibilité("la direction est invisible");
        }

    }

    public static void service(WebDriver driver, int row) throws Exception {
        try {
            FicheActionPage.service.isDisplayed();
            Common.Exporter_visibilité("le service est visible");
            String text = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LblService_")).getText();
            if (text.indexOf('*') != -1) {
                Common.Exporter_visibilité("le service est obligatoire");
            } else {
                Common.Exporter_visibilité("le service n'est pas obligatoire");
            }
            ExcelUtils.setExcelFile(Path, "Action");
            Select select = new Select(FicheActionPage.service);
            if(action.getService()!=null){
            select.selectByVisibleText(action.getService().getService());}
            informations.add(select.getFirstSelectedOption().getText());
        } catch (NoSuchElementException e) {
            Common.Exporter_visibilité("le service est invisible");
        }
    }

    public static void resp_cloture(int row) throws Exception {


        Select select = new Select(FicheActionPage.Respcloture);

        String employer = action.getRespSuivi().getName();
        System.err.println("Employee  is   :   " + employer);
        select.selectByVisibleText(employer);
        informations.add(select.getFirstSelectedOption().getText());
    }

    public static void datecreation(WebDriver driver) throws Exception {

        //ActSimplPage.DatecreationActSimplifiee.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", ActSimplPage.DatecreationActSimplifiee);
        Thread.sleep(1000);
        //ActSimplPage.agendacreation.click();
        executor.executeScript("arguments[0].click()", ActSimplPage.agendacreation);
    }

    public static void validerAjout(WebDriver driver) {

        //FicheActionPage.btnValiderActionId.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.btnValiderActionId);
    }

    public static void cliqueAgenda(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        // wait.until(ExpectedConditions.visibilityOf(FicheActionPage.agendatActionId));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.agendatActionId);
        //FicheActionPage.agendatActionId.click();
        //FicheActionPage.agendatAction2Id.click();
    }

    public static void clickAjouterSousActionModeleAction(WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.btnAjouterSousActionModeleAction);

    }

    public static void clickAjouterSousActionModeleActionSeulRespo(WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.wBtnAjouterSousActSeulRespo);

    }

    public static void selectionnerResponsableRealisation(int row, WebDriver driver, String fg) throws Throwable {
        //ExcelUtils.setExcelFile(Path, "Action");
        //Select select = new Select();
        //select.selectByVisibleText(ExcelUtils.getCellData(row,4));
        FicheActionPage.SelectresponsableRealisationID.click();
        Thread.sleep(500);
        Select selectfg = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ListBoxFiliale")));
        selectfg.selectByVisibleText(fg);

        Thread.sleep(500);

        String employer = action.getRespTraitement().getName();
        System.err.println("Employee  is   :   " + employer);
        FicheActionPage.winserRespReal.sendKeys(employer);
        FicheActionPage.wrecher.click();
        FicheActionPage.wTabReal.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewAutreEmpRespReal\"]/tbody/tr[1]/td[1]")).findElement(By.tagName("a")).click();


    }

    public static void selectionnerResponsableSuivi(int row, WebDriver driver, String fg) throws Throwable {
        FicheActionPage.SelectresponsableSuviID.click();
        Thread.sleep(500);

        Select selectfg = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ListBoxFilialeSuiv")));
        selectfg.selectByVisibleText(fg);

        String employer = action.getRespSuivi().getName();
        System.err.println("Employee  is   :   " + employer);
        FicheActionPage.winserResSuvi.sendKeys(employer);
        FicheActionPage.wrecherSuvi.click();
        FicheActionPage.wTabSuvi.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridViewAutreEmpRespSuiv\"]/tbody/tr[1]/td[1]")).findElement(By.tagName("a")).click();


        informations.add(ExcelUtils.getCellData(row, 1));

    }


    public static void Verfication_selectionnerResponsableSuivi(int row) throws Throwable {
        ExcelUtils.setExcelFile(Path, "Action");
        Select select = new Select(FicheActionPage.responsableSuiviID);
        String respoExcel = action.getRespSuivi().getName();
        boolean attrubite = Boolean.parseBoolean(FicheActionPage.responsableSuiviID.getAttribute("disabled"));
        System.err.println("attr" + attrubite);
        Assert.assertTrue(attrubite, "elementis desaible when attrubite  return true  ");
        String responsableDeSuivi = select.getFirstSelectedOption().getText();
        Assert.assertEquals(responsableDeSuivi, respoExcel);
        informations.add(ExcelUtils.getCellData(row, 6));

    }

    public static void saisirDesignationSousAct(int row) throws Throwable {
        Thread.sleep(2000);
        Faker faker = new Faker();
        String paragraph = faker.lorem().paragraph();
        paragraph = "désignation action " + paragraph + Common.paragraphe(8, 1);
        System.out.println(paragraph);

        FicheActionPage.designationSousAction.sendKeys(paragraph);
        i++;
        ExcelUtils.setExcelFile(Path, "Action");
        ExcelUtils.setCellData1(FicheActionPage.designationSousAction.getAttribute("value"), row, 18, Path, "Action");
        informations.add(ExcelUtils.getCellData(row, 18));

    }

    public static void initializer_filtre_Bilan_action(int row) throws Throwable {

        ExcelUtils.setExcelFile(Path, "Action");

        filtre_repor.put(FicheActionPage.selec_source_id, ExcelUtils.getCellData(row, 0));

        filtre_repor.put(FicheActionPage.selec_type_id, ExcelUtils.getCellData(row, 1));

        filtre_repor.put(FicheActionPage.selec_Priorite_id, ExcelUtils.getCellData(row, 2));
        filtre_repor.put(FicheActionPage.selec_gravite_id, ExcelUtils.getCellData(row, 3));
        filtre_repor.put(FicheActionPage.selec_resp_rea_id, ExcelUtils.getCellData(row, 4));
        filtre_repor.put(FicheActionPage.selec_resp_suivi_id, ExcelUtils.getCellData(row, 6));
        //filtre_repor.put(FicheActionPage.del_creation_1_id,ExcelUtils.getCellData(row,8));
        //filtre_repor.put(FicheActionPage.del_creation_2_id,ExcelUtils.getCellData(row,8));
        filtre_repor.put(FicheActionPage.selec_type_cause_id, ExcelUtils.getCellData(row, 9));
        filtre_repor.put(FicheActionPage.audit_id, ExcelUtils.getCellData(row, 10));
        filtre_repor.put(FicheActionPage.designation_id, ExcelUtils.getCellData(row, 11));
        filtre_repor.put(FicheActionPage.description_id, ExcelUtils.getCellData(row, 12));
        filtre_repor.put(FicheActionPage.selec_site_id, ExcelUtils.getCellData(row, 13));
        filtre_repor.put(FicheActionPage.selec_processus_id, ExcelUtils.getCellData(row, 14));
        filtre_repor.put(FicheActionPage.selec_domaine_id, ExcelUtils.getCellData(row, 15));
        filtre_repor.put(FicheActionPage.selec_direction_id, ExcelUtils.getCellData(row, 16));
        filtre_repor.put("ctl00_ContentPlaceHolder1_lBService_", ExcelUtils.getCellData(row, 17));

        filtre_repor.put(FicheActionPage.designsousact_id, ExcelUtils.getCellData(row, 18));

        System.out.println("list : " + filtre_repor);
//		filtre_repor.put(FicheActionPage.del_real_1_id,ExcelUtils.getCellData(row,19));
//		filtre_repor.put(FicheActionPage.del_real_2_id,ExcelUtils.getCellData(row,19));
//		filtre_repor.put(FicheActionPage.taux_real_1_id,ExcelUtils.getCellData(row,20));
//		filtre_repor.put(FicheActionPage.taux_real_2_id,ExcelUtils.getCellData(row,20));
////		filtre_repor.put(FicheActionPage.del_suivi_1_id,ExcelUtils.getCellData(row,21));
////		filtre_repor.put(FicheActionPage.del_suivi_2_id,ExcelUtils.getCellData(row,21));
//		filtre_repor.put(FicheActionPage.taux_eff_1_id,ExcelUtils.getCellData(row,22));
//		filtre_repor.put(FicheActionPage.taux_eff_2_id,ExcelUtils.getCellData(row,22));
    }

    public static void initializer_filtre_Etat_action(String Path) throws Throwable {
        ExcelUtils.setExcelFile(Path, "Action");
        filtre_repor.put(FicheActionPage.selec_Site_Action_Par_Resp_id, ExcelUtils.getCellData(1, 13));
        filtre_repor.put(FicheActionPage.selec_Processus_Action_Par_Resp_id, ExcelUtils.getCellData(1, 14));
        filtre_repor.put(FicheActionPage.selec_Activité_Action_Par_Resp_id, ExcelUtils.getCellData(1, 15));
        filtre_repor.put(FicheActionPage.selec_Direction_Action_Par_Resp_id, ExcelUtils.getCellData(1, 16));
        filtre_repor.put(FicheActionPage.selec_Priorité_Action_Par_Resp_id, ExcelUtils.getCellData(1, 2));
        filtre_repor.put(FicheActionPage.selec_GravitéAction_Action_Par_Resp_id, ExcelUtils.getCellData(1, 3));
        filtre_repor.put(FicheActionPage.selec_RespRéalisation_Action_Par_Resp_id, ExcelUtils.getCellData(1, 4));
        filtre_repor.put(FicheActionPage.del_DateCreation1_Action_Par_Resp_id, ExcelUtils.getCellData(1, 8));
        filtre_repor.put(FicheActionPage.del_DateCreation2_Action_Par_Resp_id, ExcelUtils.getCellData(1, 8));
        filtre_repor.put(FicheActionPage.del_DateRealisation1_Action_Par_Resp_id, ExcelUtils.getCellData(1, 18));
        filtre_repor.put(FicheActionPage.del_DateRealisation2_Action_Par_Resp_id, ExcelUtils.getCellData(1, 18));
    }


    public static void choixDateSousActionModeleAction(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
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
        jse.executeScript("arguments[1].value = arguments[0];", Sdate, FicheActionPage.wdateRel);
        Thread.sleep(500);


    }

    public static void validerSousAction(WebDriver driver, int seulRespo) {
        //FicheActionPage.btnValiderSousAction.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.btnValiderSousAction);
        if (seulRespo == 1) {
            String NumSousActSeulRespo = "";

            NumSousActSeulRespo = FicheActionPage.wGridSousActSeulRespo.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView5_wrapper\"]/div[2]/div/table/tbody/tr/td[3]")).getText();
            Assert.assertNotEquals(NumSousActSeulRespo, "");
        }
    }

    public static void saisirNumActionRealisation(String num, WebDriver driver) throws InterruptedException {

        try {
            FicheActionPage.numActionrealisation.clear();
            FicheActionPage.numActionrealisation.sendKeys(num);
        } catch (Exception ex) {

            Thread.sleep(1000);

            FicheActionPage.numActionrealisation.clear();
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click()", FicheActionPage.numActionrealisation);
//			FicheActionPage.numActionrealisation.sendKeys(num);
            JavascriptExecutor jse2 = (JavascriptExecutor) driver;
            jse2.executeScript("arguments[1].value = arguments[0];", num, FicheActionPage.numActionrealisation);
        }
    }

    public static void rechercherNumActionRealisation(WebDriver driver) throws InterruptedException {
        Thread.sleep(500);
        //FicheActionPage.rechercherNumActionrealisation.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.rechercherNumActionrealisation);
        Thread.sleep(500);
    }

    public static void choixNumActionRealisation(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr[1]/td[1]")).findElement(By.tagName("a")).click();

    }

    public static void saisirTauxRealisation() {

        FicheActionPage.tauxRealisation.sendKeys("25");
    }

    public static void saisirDepenses() {
        try {
            FicheActionPage.depensesID.isDisplayed();
            FicheActionPage.depensesID.clear();
            FicheActionPage.depensesID.sendKeys("1000");
            Common.Exporter_champ_A_masquer("le champ cout est visible");
        } catch (NoSuchElementException e) {
            Common.Exporter_champ_A_masquer("le champ cout est invisible");
        }

    }

    public static void saisirCommentaire() {
        FicheActionPage.commentaireID.clear();
        FicheActionPage.commentaireID.sendKeys("test auto");
    }

    public static void choixDateRealisation(WebDriver driver) {

        FicheActionPage.dateRealisation.click();
        //JavascriptExecutor executor =(JavascriptExecutor)driver;
        //executor.executeScript("arguments[0].click()", FicheActionPage.dateRealisation);

        FicheActionPage.choixDateRealisation.click();
        //executor.executeScript("arguments[0].click()", FicheActionPage.choixDateRealisation);
    }

    public static void validerRealisationAction(WebDriver driver) {

        //FicheActionPage.validerRealisation.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.validerRealisation);
        //	=====>


    }

    public static void EnrTauxReal(WebDriver driver, String ta) throws InterruptedException {
        Thread.sleep(500);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.WbtnEnrTReal);
        Thread.sleep(500);
        try {
            FicheActionPage.WtauxRealAg.clear();
            Thread.sleep(500);
            FicheActionPage.WtauxRealAg.sendKeys(ta);
            Thread.sleep(500);
            JavascriptExecutor executor2 = (JavascriptExecutor) driver;
            executor2.executeScript("arguments[0].click()", FicheActionPage.WbtnVldTReall);
            Thread.sleep(500);
        } catch (NoSuchElementException e) {
            if (Integer.parseInt(ta) < 100) {
                Assert.fail();
            }
        }

    }

    public static void saisirNumActionSuivre(String num) throws Throwable {
        Thread.sleep(500);
        FicheActionPage.numActionSuivre.clear();
        Thread.sleep(500);

        FicheActionPage.numActionSuivre.sendKeys(num);
    }

    public static void rechercherNumActionSuivre(WebDriver driver) throws InterruptedException {

        //FicheActionPage.rechercherNumActionSuivre.click();


        Thread.sleep(1000);

        JavascriptExecutor executor = (JavascriptExecutor) driver;


        //	executor.executeScript("arguments[0].clear()", FicheActionPage.rechercherNumActionSuivre);
        Thread.sleep(1000);

        executor.executeScript("arguments[0].click()", FicheActionPage.rechercherNumActionSuivre);

    }

    public static void choixNumActionSuivren() throws InterruptedException {
        //	FicheActionPage.choixNumActionSuivre.clear();
        Thread.sleep(1000);
        FicheActionPage.choixNumActionSuivre.findElement(By.tagName("a")).click();
    }

    public static void saisirTauxEffi() {

        FicheActionPage.TauxEffiID.sendKeys("100");
    }

    public static void saisirRapportEffi() {

        FicheActionPage.rapportEffiID.sendKeys("test Auto");
    }

    public static void validerSuivi(WebDriver driver) {

        //FicheActionPage.validerSuivi.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.validerSuivi);
    }

    public static void choixNumActionCloturee(WebDriver driver, int row) throws Exception {

        String numAct = String.valueOf(action.getNumFiche());
        System.err.println("le num action pour le    cloture   est    " + numAct);
        //try{driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView_Cloture_filter")).
        //	findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_Cloture_filter\"]/label")).
        //findElement(By.tagName("input")).sendKeys(numAct);}catch (Exception ex){
        //}
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.choixActionCloturer.findElement(By.tagName("a")));
    }

    public static void choixCloturee(WebDriver driver) throws InterruptedException {

        //FicheActionPage.choixCloturee.click();
        Thread.sleep(500);
        FicheActionPage.wchoixCloturee.findElement(By.xpath("//*[@id=\"collapseCloture\"]/div/div[1]/div[1]/table/tbody/tr/td[1]")).findElement(By.tagName("input")).click();

//        JavascriptExecutor executor =(JavascriptExecutor)driver;
//        	executor.executeScript("arguments[0].click()", FicheActionPage.choixCloturee);
    }

    public static void choixDateCloture(WebDriver driver) {

        //FicheActionPage.dateCloture.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.dateCloture);
        //FicheActionPage.choixDateCloture.click();
        executor.executeScript("arguments[0].click()", FicheActionPage.choixDateCloture);
    }

    public static void validerCloturee() throws InterruptedException {
        Thread.sleep(2000);
        FicheActionPage.validerCloture.click();
    }

    public static void consulter_fiche(String NumFiche, WebDriver driver) throws Throwable {
        FicheActionPage.RechFiltreId.sendKeys(NumFiche);
        //FicheActionPage.BtnRechFiltId.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.BtnRechFiltId);
        Thread.sleep(1000L);
        //FicheActionPage.TableFiltreAction.findElement(By.tagName("a")).click();
        executor.executeScript("arguments[0].click()", FicheActionPage.TableFiltreAction.findElement(By.tagName("a")));
        Thread.sleep(1000L);
        //FicheActionPage.TracabiliteId.click();
        executor.executeScript("arguments[0].click()", FicheActionPage.TracabiliteId);
        Thread.sleep(1000L);

    }

    public static void initializer_filtre_action_par_personne(String Path) throws Throwable {

        ExcelUtils.setExcelFile(Path, "Action");
        filtre_repor.put(FicheActionPage.selec_Site_Action_Par_Personne_id, ExcelUtils.getCellData(1, 13));
        filtre_repor.put(FicheActionPage.selec_Processus_Action_Par_Personne_id, ExcelUtils.getCellData(1, 14));
        filtre_repor.put(FicheActionPage.selec_Activité_Action_Par_Personne_id, ExcelUtils.getCellData(1, 15));
        filtre_repor.put(FicheActionPage.selec_Direction_Action_Par_Personne_id, ExcelUtils.getCellData(1, 16));
        filtre_repor.put(FicheActionPage.selec_Priorité_Action_Par_Personne_id, ExcelUtils.getCellData(1, 2));
        filtre_repor.put(FicheActionPage.selec_GravitéAction_Action_Par_Personne_id, ExcelUtils.getCellData(1, 3));
        filtre_repor.put(FicheActionPage.selec_Source_Action_Par_Personne_id, ExcelUtils.getCellData(1, 0));
        filtre_repor.put(FicheActionPage.selec_RespRéalisation_Action_Par_Personne_id, ExcelUtils.getCellData(1, 4));
        filtre_repor.put(FicheActionPage.del_DateRealisation1_Action_Par_Personne_id, ExcelUtils.getCellData(1, 18));
        filtre_repor.put(FicheActionPage.del_DateRealisation2_Action_Par_Personne_id, ExcelUtils.getCellData(1, 18));
        filtre_repor.put(FicheActionPage.del_DateSaisieRealisation1_Action_Par_Personne_id, ExcelUtils.getCellData(1, 22));
        filtre_repor.put(FicheActionPage.del_DateSaisieRealisation2_Action_Par_Personne_id, ExcelUtils.getCellData(1, 22));
    }

    public static void initializer_filtre_Bilan_action(String Path, String Filtre) throws Throwable {
        ExcelUtils.setExcelFile(Path, "Action");
        if (Filtre.equals("source")) {
            filtre_repor.put(FicheActionPage.selec_source_id, ExcelUtils.getCellData(1, 0));
        } else if (Filtre.equals("type")) {
            filtre_repor.put(FicheActionPage.selec_type_id, ExcelUtils.getCellData(1, 1));
        } else if (Filtre.equals("priorité")) {
            filtre_repor.put(FicheActionPage.selec_Priorite_id, ExcelUtils.getCellData(1, 2));
        } else if (Filtre.equals("gravité")) {
            filtre_repor.put(FicheActionPage.selec_gravite_id, ExcelUtils.getCellData(1, 3));
        } else if (Filtre.equals("Resp réalisation")) {
            filtre_repor.put(FicheActionPage.selec_resp_rea_id, ExcelUtils.getCellData(1, 4));
        } else if (Filtre.equals("Resp suivi")) {
            filtre_repor.put(FicheActionPage.selec_resp_suivi_id, ExcelUtils.getCellData(1, 6));
        } else if (Filtre.equals("date création")) {
            filtre_repor.put(FicheActionPage.del_creation_1_id, ExcelUtils.getCellData(1, 8));
            filtre_repor.put(FicheActionPage.del_creation_2_id, ExcelUtils.getCellData(1, 8));
        } else if (Filtre.equals("type cause")) {
            filtre_repor.put(FicheActionPage.selec_type_cause_id, ExcelUtils.getCellData(1, 9));
        } else if (Filtre.equals("Ref Audit")) {
            filtre_repor.put(FicheActionPage.audit_id, ExcelUtils.getCellData(1, 10));
        } else if (Filtre.equals("Designation")) {
            filtre_repor.put(FicheActionPage.designation_id, ExcelUtils.getCellData(1, 11));
        } else if (Filtre.equals("Description")) {
            filtre_repor.put(FicheActionPage.description_id, ExcelUtils.getCellData(1, 12));
        } else if (Filtre.equals("site")) {
            filtre_repor.put(FicheActionPage.selec_site_id, ExcelUtils.getCellData(1, 13));
        } else if (Filtre.equals("processus")) {
            filtre_repor.put(FicheActionPage.selec_processus_id, ExcelUtils.getCellData(1, 14));
        } else if (Filtre.equals("domaine")) {
            filtre_repor.put(FicheActionPage.selec_domaine_id, ExcelUtils.getCellData(1, 15));
        } else if (Filtre.equals("direction")) {
            filtre_repor.put(FicheActionPage.selec_direction_id, ExcelUtils.getCellData(1, 16));
            //}else if(Filtre.equals("service")) {
            //filtre_repor.put(FicheActionPage.selec_service_id,ExcelUtils.getCellData(1,17));
        } else if (Filtre.equals("des sous act")) {
            filtre_repor.put(FicheActionPage.designsousact_id, ExcelUtils.getCellData(1, 18));
        } else if (Filtre.equals("date réalisation")) {
            filtre_repor.put(FicheActionPage.del_real_1_id, ExcelUtils.getCellData(1, 19));
            filtre_repor.put(FicheActionPage.del_real_2_id, ExcelUtils.getCellData(1, 19));
        } else if (Filtre.equals("taux réalisation")) {
            filtre_repor.put(FicheActionPage.taux_real_1_id, ExcelUtils.getCellData(1, 20));
            filtre_repor.put(FicheActionPage.taux_real_2_id, ExcelUtils.getCellData(1, 20));
        } else if (Filtre.equals("date suivi")) {
            filtre_repor.put(FicheActionPage.del_suivi_1_id, ExcelUtils.getCellData(1, 21));
            filtre_repor.put(FicheActionPage.del_suivi_2_id, ExcelUtils.getCellData(1, 21));
        } else if (Filtre.equals("taux efficacité")) {
            filtre_repor.put(FicheActionPage.taux_eff_1_id, ExcelUtils.getCellData(1, 22));
            filtre_repor.put(FicheActionPage.taux_eff_2_id, ExcelUtils.getCellData(1, 22));
        }
    }


}
