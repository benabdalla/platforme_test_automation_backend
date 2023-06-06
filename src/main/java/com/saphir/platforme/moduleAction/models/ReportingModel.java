package com.saphir.platforme.moduleAction.models;


import com.saphir.platforme.authentification.models.AuthentificationModel;
import com.saphir.platforme.moduleAction.pages.DemandeActionPage;
import com.saphir.platforme.moduleAction.pages.FicheActionPage;
import com.saphir.platforme.moduleAction.pages.ReportingPage;
import com.saphir.platforme.moduleAction.stepdefs.FicheActionStepDefinition;
import com.saphir.platforme.utils.Common;
import com.saphir.platforme.utils.ExcelUtils;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class ReportingModel {


    public static HashMap<String, String> filtre_repor = new HashMap<>();
    private static final String Path = "resources/testData/TestData.xlsx";
    private static String regroup = "";

    public static void consulter_reporting_Nombre_d_actions_par_type(WebDriver driver) throws InterruptedException {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > a > img")));
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(21) > a")));
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(2) > ul > li:nth-child(4) > a")));


        Thread.sleep(1000L);


    }


    public static void choisir_de_regroupement_des_actions_par_type(String type_regroupment) {

        regroup = type_regroupment;

    }

    public static void récupérer_filtre_reporting_liste_des_actions_par_type(WebDriver driver, int row) throws Throwable {

        ExcelUtils.setExcelFile(Path, "Action");
//site
        filtre_repor.put("ctl00_ContentPlaceHolder1_ListBox1", ExcelUtils.getCellData(row, 13));
        filtre_repor.put("ctl00_ContentPlaceHolder1_ListBoxSite", ExcelUtils.getCellData(row, 13));

        //processus
        filtre_repor.put(FicheActionPage.selec_processus_id, ExcelUtils.getCellData(row, 14));
        filtre_repor.put("ctl00_ContentPlaceHolder1_ListBox2", ExcelUtils.getCellData(row, 14));

        filtre_repor.put("ctl00_ContentPlaceHolder1_ddlActivite", ExcelUtils.getCellData(row, 14));
        filtre_repor.put(FicheActionPage.selec_Activité_Action_Par_Resp_id, ExcelUtils.getCellData(1, 15));
        filtre_repor.put(FicheActionPage.selec_Direction_Action_Par_Resp_id, ExcelUtils.getCellData(1, 16));
        filtre_repor.put("ctl00_ContentPlaceHolder1_lBService_", ExcelUtils.getCellData(row, 17));

//priorité
        filtre_repor.put("ctl00_ContentPlaceHolder1_DropDownList_PFiltre", ExcelUtils.getCellData(row, 2));
        filtre_repor.put("ctl00_ContentPlaceHolder1_DropDownList_Priorite", ExcelUtils.getCellData(row, 2));

        filtre_repor.put("ctl00_ContentPlaceHolder1_DropDownList_GFiltre", ExcelUtils.getCellData(row, 3));
        filtre_repor.put("ctl00_ContentPlaceHolder1_ListBox1", ExcelUtils.getCellData(row, 13));

    }

    public static void saisir_filtre_reporting_liste_des_actions_par_type(WebDriver driver) throws Throwable {


        Iterator<Map.Entry<String, String>> iterator = filtre_repor.entrySet().iterator();
        System.out.print("map   :  " + filtre_repor);
        while (iterator.hasNext()) {
            Map.Entry mapentry = iterator.next();
            System.out.print("element  :  " + mapentry.getKey().toString());
            System.out.println("contune  :  " + mapentry.getValue().toString());
            Common.remplir_filtre_by_id(driver, mapentry.getKey().toString(), mapentry.getValue().toString());
        }
        Common.SaisirDate(driver, "ctl00_ContentPlaceHolder1_TextBox3");
        Common.SaisirDate(driver, "ctl00_ContentPlaceHolder1_TextBox1");
        Common.SaisirDate(driver, "ctl00_ContentPlaceHolder1_TextBox3");
        Common.SaisirDate(driver, "ctl00_ContentPlaceHolder1_TextBox1");
        Common.SaisirDate(driver, "ctl00_ContentPlaceHolder1_TextBox2");
        Common.SaisirDate(driver, "ctl00_ContentPlaceHolder1_TextBoxDate1");
        Common.SaisirDate(driver, "ctl00_ContentPlaceHolder1_TextBox4");
        Common.SaisirDate(driver, "ctl00_ContentPlaceHolder1_TextBoxDate2");
        //	Common.SaisirDate(driver,"ctl00_ContentPlaceHolder1_TextBox4");


        try {
            WebElement element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton11"));
            element.click();
            Thread.sleep(500);
        } catch (Exception ex) {
            System.out.println("Export word ");
        }
    }

    public static void vérifier_les_données_rapport_liste_des_actions_par_type(WebDriver driver) throws IOException, InterruptedException {
//        driver.findElement(By.id("CrystalReportViewer1_toptoolbar_palette")).findElement(By.
//                        xpath("//*[@id=\"CrystalReportViewer1_toptoolbar\"]/table/tbody/tr/td[1]/table/tbody/tr/td[6]")).
//                findElement(By.id("CrystalReportViewer1_toptoolbar_nextPg")).
//                findElement(By.xpath("//*[@id=\"CrystalReportViewer1_toptoolbar\"]/table/tbody/tr/td[1]/table/tbody/tr/td[6]/table/tbody/tr/td")).findElement(By.tagName("img")).click();
//Thread.sleep(3000);
//        try {
//            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(scrFile, new File("E:\\qualipro\\trunk\\AutomatisationTQualiPro_prod231\\resources\\comparReporting\\ReportingListeActionRealiseeParType.jpg"));
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }
//        File file = new File("E:\\qualipro\\trunk\\AutomatisationTQualiPro_prod231\\resources\\comparReporting\\datpartype.jpg");
//        System.out.println(file);
//        File file2 = new File("E:\\qualipro\\trunk\\AutomatisationTQualiPro_prod231\\resources\\comparReporting\\ReportingListeActionRealiseeParType.jpg");
//        BufferedImage expectedImg = ImageIO.read(file);
//        BufferedImage expectedImg2 = ImageIO.read(file2);
//        Thread.sleep(1000);
//        ImageDiffer imgDiff = new ImageDiffer();
//        ImageDiff dif = imgDiff.makeDiff(expectedImg, expectedImg2);
//        if(dif.hasDiff()){
//            System.out.println("Both images are different");
//            Assert.assertTrue(false,"Both images are different");
//        }else {
//            System.out.println("Both images are same");
//            Assert.assertTrue(true,"Both images are same");
//        }

    }


    public static void consulter_reporting_Nombre_d_actions_par_source(WebDriver driver) throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > a > img")));
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(21) > a")));
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(2) > ul > li:nth-child(3) > a")));


        Thread.sleep(1000L);

    }

    public static void vérifier_les_données_rapport_liste_des_actions_par_source(WebDriver driver) throws InterruptedException, IOException {
//        driver.findElement(By.id("CrystalReportViewer1_toptoolbar_palette")).findElement(By.
//                        xpath("//*[@id=\"CrystalReportViewer1_toptoolbar\"]/table/tbody/tr/td[1]/table/tbody/tr/td[6]")).
//                findElement(By.id("CrystalReportViewer1_toptoolbar_nextPg")).
//                findElement(By.xpath("//*[@id=\"CrystalReportViewer1_toptoolbar\"]/table/tbody/tr/td[1]/table/tbody/tr/td[6]/table/tbody/tr/td")).findElement(By.tagName("img")).click();
//        Thread.sleep(3000);
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        //  FileUtils.copyFile(scrFile, new File("E:\\qualipro\\trunk\\AutomatisationTQualiPro_prod231\\resources\\comparReporting\\ReportingListeActionRealiseeParSource.jpg"));
//        File file = new File("E:\\qualipro\\trunk\\AutomatisationTQualiPro_prod231\\resources\\comparReporting\\dataReport.jpg");
//        System.out.println(file);
//        File file2 = new File("E:\\qualipro\\trunk\\AutomatisationTQualiPro_prod231\\resources\\comparReporting\\dataReportingParSource.jpg");
//        BufferedImage expectedImg = ImageIO.read(file);
//        BufferedImage expectedImg2 = ImageIO.read(file2);
//        Thread.sleep(1000);
//        ImageDiffer imgDiff = new ImageDiffer();
//        ImageDiff dif = imgDiff.makeDiff(expectedImg, expectedImg2);
//        if(dif.hasDiff()){
//            System.out.println("Both images are different");
//            Assert.assertTrue(false,"Both images are different");
//        }else {
//            System.out.println("Both images are same");
//            Assert.assertTrue(true,"Both images are same");
//        }

    }


    public static void refusées_Demande_Action_par_les_responsable(WebDriver driver) throws Throwable {
        String curResp;
        String Demandeur = "AUTO1";
        do {
            curResp = DemandeActionModel.recuperer_current_reponsable();
            System.out.println("responsable  est   " + curResp);
            if (!(curResp.equals(""))) {
                if (!(Demandeur.equals(curResp))) {
                    DemandeActionModel.Deconnexion_Compte(driver);
                    AuthentificationModel.Changer_Compte(curResp, driver);
                    Thread.sleep(4000L);
                } else {
                    DemandeActionModel.incrementation_compteur_agenda_DA(driver);
                }
                DemandeActionModel.Acceder_Demande(driver, FicheActionStepDefinition.origine);
                String comments = Common.paragraphe(8, 8);
                Thread.sleep(1000);
                ExcelUtils.setExcelFile(Path, "DemandeAction");
                ExcelUtils.setCellData1(comments, 1, 16, Path, "DemandeAction");
                DemandeActionPage.wCommentRefusse.sendKeys(comments);
                DemandeActionPage.wBtnrefusse.click();
            }
        } while (!(curResp.equals("")));
    }


    public static void verifier_Demande_Action_refusées(WebDriver driver) throws InterruptedException {
        String NACTION;
        Thread.sleep(1000L);
        WebElement tableRow = DemandeActionPage.TableDemandeID.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1p\"]/tbody/tr"));
        WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1p\"]/tbody/tr/td[8]"));
        String verifDesignation = cellIneed.getText();
        WebElement cellIneed1 = tableRow.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1p\"]/tbody/tr[1]/td[9]"));
        NACTION = cellIneed1.getText();
        Thread.sleep(1000L);
        System.out.println("Statut  demande  : " + verifDesignation);
        if ((verifDesignation.equals("Rejected Request")) || (verifDesignation.equals("DEMANDE REFUSEE"))) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }


    public static void consulter_reporting_de_historique_demandes_refusées(WebDriver driver) throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > a > img")));
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(21) > a")));
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(2) > ul > li:nth-child(5) > a")));
        Thread.sleep(1000L);


    }


    public static void verifier_le_demande_Action_dans_reporting_historique_demandes_refusées(WebDriver driver, int row) throws Throwable {

        String name1 = "Demande_Action";
        ExcelUtils.setExcelFile(Path, "DemandeAction");
        List<String> data = new ArrayList<String>();

        // Num demande
        data.add(ExcelUtils.getCellData(row, 14));
        //Désignation Demande
        data.add(ExcelUtils.getCellData(row, 15));
        //Motif de refus
        data.add(ExcelUtils.getCellData(row, 16));
        //
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
        //date
        data.add(Sdate);
        data.add("AUTO");


        ExcelUtils.setExcelFile(Path, "Action");


        Common.Vérifier_liste_données(name1, data);

    }

    public static void cliquer_sur_etat_des_sous_actions_par_Processus(WebDriver driver) throws InterruptedException {

        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(2) > ul > li:nth-child(9) > a")));
        Thread.sleep(1000L);
    }

    public static void consulter_reporting_sous_action_par_priorité(WebDriver driver) throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > a > img")));
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(21) > a")));
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(2) > ul > li:nth-child(11) > a")));
        Thread.sleep(1000L);

    }


    public static void récupérer_filtre_reporting_liste_des_sous_actions_par_Priorite(int row) throws Exception {

        ExcelUtils.setExcelFile(Path, "Action");
//site
        filtre_repor.put("ctl00_ContentPlaceHolder1_ListBox1", ExcelUtils.getCellData(row, 13));
        filtre_repor.put("ctl00_ContentPlaceHolder1_ListBoxSite", ExcelUtils.getCellData(row, 13));

        //processus
        filtre_repor.put(FicheActionPage.selec_processus_id, ExcelUtils.getCellData(row, 14));
        //source
        filtre_repor.put("ctl00_ContentPlaceHolder1_ListBox2", ExcelUtils.getCellData(row, 0));
        //type

        filtre_repor.put("ctl00_ContentPlaceHolder1_ListBox3", ExcelUtils.getCellData(row, 1));

        filtre_repor.put("ctl00_ContentPlaceHolder1_ddlActivite", ExcelUtils.getCellData(row, 14));
        filtre_repor.put(FicheActionPage.selec_Activité_Action_Par_Resp_id, ExcelUtils.getCellData(1, 15));
        filtre_repor.put(FicheActionPage.selec_Direction_Action_Par_Resp_id, ExcelUtils.getCellData(1, 16));
        filtre_repor.put("ctl00_ContentPlaceHolder1_lBService_", ExcelUtils.getCellData(row, 17));

//priorité
        filtre_repor.put("ctl00_ContentPlaceHolder1_DropDownList_PFiltre", ExcelUtils.getCellData(row, 2));
        filtre_repor.put("ctl00_ContentPlaceHolder1_DropDownList_Priorite", ExcelUtils.getCellData(row, 2));

        filtre_repor.put("ctl00_ContentPlaceHolder1_DropDownList_GFiltre", ExcelUtils.getCellData(row, 3));
        filtre_repor.put("ctl00_ContentPlaceHolder1_ListBox1", ExcelUtils.getCellData(row, 13));


    }


    public static void consulter_reporting_liste_des_sous_actions_par_produit(WebDriver driver) throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > a > img")));
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        executor1.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(21) > a")));
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(2) > ul > li:nth-child(10) > a")));
        Thread.sleep(1000L);


    }

    public static void récupérer_filtre_reporting_liste_des_sous_actions_par_produit(WebDriver driver, int row) throws Exception {

        ExcelUtils.setExcelFile(Path, "Action");
//site
        filtre_repor.put("ctl00_ContentPlaceHolder1_ListBox1", ExcelUtils.getCellData(row, 13));
        filtre_repor.put("ctl00_ContentPlaceHolder1_ListBoxSite", ExcelUtils.getCellData(row, 13));

        //processus
        filtre_repor.put(FicheActionPage.selec_processus_id, ExcelUtils.getCellData(row, 14));
        //source
        filtre_repor.put("ctl00_ContentPlaceHolder1_ListBox2", ExcelUtils.getCellData(row, 0));
        //type

        filtre_repor.put("ctl00_ContentPlaceHolder1_ListBox3", ExcelUtils.getCellData(row, 1));

        filtre_repor.put("ctl00_ContentPlaceHolder1_ddlActivite", ExcelUtils.getCellData(row, 14));
        filtre_repor.put(FicheActionPage.selec_Activité_Action_Par_Resp_id, ExcelUtils.getCellData(1, 15));
        filtre_repor.put(FicheActionPage.selec_Direction_Action_Par_Resp_id, ExcelUtils.getCellData(1, 16));
        filtre_repor.put("ctl00_ContentPlaceHolder1_lBService_", ExcelUtils.getCellData(row, 17));

//priorité
        filtre_repor.put("ctl00_ContentPlaceHolder1_DropDownList_PFiltre", ExcelUtils.getCellData(row, 2));
        filtre_repor.put("ctl00_ContentPlaceHolder1_DropDownList_Priorite", ExcelUtils.getCellData(row, 2));

        filtre_repor.put("ctl00_ContentPlaceHolder1_DropDownList_GFiltre", ExcelUtils.getCellData(row, 3));

        filtre_repor.put("ctl00_ContentPlaceHolder1_ListBox1", ExcelUtils.getCellData(row, 13));

        Thread.sleep(500);
        ReportingPage.wselectProduit.click();
        Thread.sleep(500);
        ReportingPage.wrecherech.sendKeys(ExcelUtils.getCellData(row, 24));
        ReportingPage.wbtnrecherech.click();
        Thread.sleep(500);

        ReportingPage.wtabProd.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridPRODUIT\"]/tbody/tr[2]/td[1]")).findElement(By.tagName("a")).click();


    }


    public static void vérifier_les_données_rapport_liste_des_sous_actions_par_produit(WebDriver driver, int row) throws Throwable {

        String name1 = "Etat_des_sous_actions_par_produit";

        ExcelUtils.setExcelFile(Path, "Action");
        List<String> data = new ArrayList<String>();
        // Num Action
        data.add(ExcelUtils.getCellData(row, 7));
        //Désignation action
        data.add(ExcelUtils.getCellData(row, 11));
        //Désignation sous action
        data.add(ExcelUtils.getCellData(row, 18));
        data.add("AUTO1");

        //Etat des sous actions par produit

        Common.Vérifier_liste_données(name1, data);
    }

    // ----------------------------> etat  d'avancement  de  action  plan

    public static void consulter_reporting_Etat_d_avancement_des_plans_d_actions(WebDriver driver) throws InterruptedException {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        // executor.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > a > img")) );
        JavascriptExecutor executor1 = (JavascriptExecutor) driver;
        // executor1.executeScript("arguments[0].click();",FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(21) > a")) );
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", FicheActionPage.wreporting.findElement(By.cssSelector("#menu_rep > div > div > ul > li > ul > li:nth-child(2) > ul > li:nth-child(8) > a")));
        Thread.sleep(1000L);

    }


    public static void récupérer_filtre_reporting_liste_Etat_d_avancement_des_plans_d_actions(int row) throws Throwable {
        ExcelUtils.setExcelFile(Path, "Action");
//site
        filtre_repor.put("ctl00_ContentPlaceHolder1_listboxSiteFiltre", ExcelUtils.getCellData(row, 13));
        //processus
        filtre_repor.put(FicheActionPage.selec_processus_id, ExcelUtils.getCellData(row, 14));
        filtre_repor.put("ctl00_ContentPlaceHolder1_lBDomaine_", ExcelUtils.getCellData(row, 15));
        filtre_repor.put("ctl00_ContentPlaceHolder1_ListBox1", ExcelUtils.getCellData(1, 16));
        filtre_repor.put("ctl00_ContentPlaceHolder1_lBService_", ExcelUtils.getCellData(row, 17));


        Thread.sleep(500);
        ReportingPage.wbtnRespo.click();
        Thread.sleep(500);
        ReportingPage.wrecherech.sendKeys(ExcelUtils.getCellData(row, 4));
        ReportingPage.wbtnrecherRespo.click();
        Thread.sleep(500);

        ReportingPage.wtabRespo.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_G4\"]/tbody/tr[2]/td[1]")).findElement(By.tagName("a")).click();


    }


    public static void saisir_filtre_reporting_Etat_d_avancement_des_plans_d_actions(WebDriver driver) throws Throwable {
        Iterator<Map.Entry<String, String>> iterator = filtre_repor.entrySet().iterator();
        System.out.print("map   :  " + filtre_repor);
        while (iterator.hasNext()) {
            Map.Entry mapentry = iterator.next();
            System.out.print("element  :  " + mapentry.getKey().toString());
            System.out.println("contune  :  " + mapentry.getValue().toString());
            Common.remplir_filtre_by_id(driver, mapentry.getKey().toString(), mapentry.getValue().toString());
        }
        try {
            WebElement element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton11"));
            element.click();
            Thread.sleep(500);
        } catch (Exception ex) {
            System.out.println("Export word ");
        }
    }


    public static void choisir_de_regroupement_Etat_d_avancement_des_plans_d_actions(String string, WebDriver driver) throws Throwable {
//ReportingPage.wAnnee.sendKeys("2022");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[1].value = arguments[0];", "2022", ReportingPage.wAnnee);
        if (string.equals("avecDate")) {
            ReportingPage.wRegroupEtaAction.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_RadioButtonList_Avancement\"]/tbody/tr/td[2]")).
                    findElement(By.tagName("input")).click();
            Common.SaisirDate(driver, "ctl00_ContentPlaceHolder1_TextBox_Date");
        } else {
            ReportingPage.wRegroupEtaAction.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_RadioButtonList_Avancement\"]/tbody/tr/td[3]")).
                    findElement(By.tagName("input")).click();
        }
    }


    public static void vérifier_les_données_rapport_Etat_d_avancement_des_plans_d_actions(int row, WebDriver driver) throws Throwable {


        String name1 = "Etat_avancement_des_plans_actions";

        ExcelUtils.setExcelFile(Path, "Action");
        List<String> data = new ArrayList<String>();
        // Num Action
        String numAction = ExcelUtils.getCellData(row, 7);
        StringBuilder result = new StringBuilder();
        if (numAction.length() > 3) {
            for (int i = 0; i < numAction.length(); i++) {
                if (i == 1) {
                    result.append(" ");
                }
                result.append(numAction.charAt(i));
            }
            data.add(String.valueOf(result));
        } else {
            data.add(numAction);
        }

        //Désignation action
        //  data.add(ExcelUtils.getCellData(row,11));
        //Désignation sous action
        //  data.add(ExcelUtils.getCellData(row,18));
        data.add("AUTO1");
        //observation
        data.add("test auto");
        //Etat des sous actions par produit
        // date  cible
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
        //date
        data.add(Sdate);


        Common.Vérifier_liste_données(name1, data);
    }


}


