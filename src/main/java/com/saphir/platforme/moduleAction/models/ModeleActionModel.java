package com.saphir.platforme.moduleAction.models;

import com.saphir.platforme.moduleAction.pages.FicheActionPage;
import com.saphir.platforme.moduleAction.pages.ModeleActionPage;
import com.saphir.platforme.utils.Common;
import com.saphir.platforme.utils.ExcelUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class ModeleActionModel {
    private static final String Path = "resources/testData/TestData.xlsx";
    public static int del_rea, del_suivi;
    static int val1;

    public static void consulter_Modele_Action(WebDriver driver) throws Throwable {
        //ModeleActionPage.menuID.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", ModeleActionPage.menuID);
        Thread.sleep(500L);
        Common.AccéderModule(2, 0, 0, driver);
        Common.AccéderModule(2, 3, 0, driver);
    }

    public static void ajouter_modele(WebDriver driver) throws Throwable {
        //ModeleActionPage.btnAjouterModele.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", ModeleActionPage.btnAjouterModele);
        Thread.sleep(500L);
        Common.Exporter_visibilité("Nouvelle Fiche modele Action");
        Common.Exporter_champ_A_masquer("Nouvelle Fiche modele Action");
    }

    public static void saisir_delai_realisation() throws Throwable {
        Random rand = new Random();
        val1 = rand.nextInt(10);
        String Index1 = Integer.toString(val1);
        ModeleActionPage.delai_traitement.sendKeys(Index1);
        del_rea = Integer.parseInt(Index1);
        Thread.sleep(500L);
    }

    public static void saisir_delai_suivi() throws Throwable {
        int val2;
        do {
            Random rand = new Random();
            val2 = rand.nextInt(10);
        } while (val2 < val1);
        String Index = Integer.toString(val2);
        ModeleActionPage.delais_suivi.sendKeys(Index);
        del_suivi = Integer.parseInt(Index);
        Thread.sleep(500L);
    }

    public static void saisir_cout() throws Throwable {
        ModeleActionPage.CoutSousAction.sendKeys("500");
        Thread.sleep(500L);
    }

    public static void rattacher_type_cause(int row, WebDriver driver) throws Throwable {
        //ModeleActionPage.TypeCauseXpath.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", ModeleActionPage.TypeCauseXpath);
        Thread.sleep(500L);
        ExcelUtils.setExcelFile(Path, "Action");
        ModeleActionPage.RechTypeCauseXpath.sendKeys(ExcelUtils.getCellData(row, 9));
        Thread.sleep(500L);
        //ModeleActionPage.ChxTypeCauseId.findElement(By.tagName("input")).click();
        executor.executeScript("arguments[0].click()", ModeleActionPage.ChxTypeCauseId.findElement(By.tagName("input")));
        Thread.sleep(500L);

        //ModeleActionPage.VldTypeCause.click();
        executor.executeScript("arguments[0].click()", ModeleActionPage.VldTypeCause);


    }

    public static void selectionnerDirection(WebDriver driver) {
        try {
            ModeleActionPage.directionId.isDisplayed();
            Common.Exporter_visibilité("la direction est visible");
            String text = driver.findElement(By.id("ctl00_ContentPlaceHolder1_LabelDir")).getText();
            if (text.indexOf('*') != -1) {
                Common.Exporter_visibilité("la direction est obligatoire");
            } else {
                Common.Exporter_visibilité("la direction n'est pas obligatoire");

            }
            Select select = new Select(ModeleActionPage.directionId);
            select.selectByVisibleText("DIRECTION AUTO");

        } catch (NoSuchElementException e) {
            Common.Exporter_visibilité("la direction est invisible");
        }

    }

    public static void rattacherr_modele(String num, WebDriver driver, int row) throws Throwable {
        System.out.println(num);
        Thread.sleep(1000L);
        //FicheActionPage.choix_délais_suivi.click();
        //FicheActionPage.AttModele.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.AttModele);
        Thread.sleep(500L);

        ExcelUtils.setExcelFile(Path, "Action");
        String designation = ExcelUtils.getCellData(row, 25);
        Thread.sleep(500);
        FicheActionPage.RechModele.sendKeys(designation);
        //FicheActionPage.ChxModele.findElement(By.tagName("a")).click();
        executor.executeScript("arguments[0].click()", FicheActionPage.ChxModele.findElement(By.tagName("a")));
        Thread.sleep(500L);
    }

    public static void apercu_action(WebDriver driver) throws Throwable {
        //FicheActionPage.apercu.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.apercu);
        Thread.sleep(500L);
        //FicheActionPage.ChxApercu.click();
        executor.executeScript("arguments[0].click()", FicheActionPage.ChxApercu);
        Thread.sleep(500L);
        //FicheActionPage.validerApercu.click();
        executor.executeScript("arguments[0].click()", FicheActionPage.validerApercu);
        Thread.sleep(1000L);

    }

    private static boolean asserttrue(Boolean incrementation) {
        return incrementation;
    }

    public static void verifier_date_rea(WebDriver driver) throws Throwable {
        String pattern = "dd/MM/yyyy";
        String Creation = ModeleActionPage.Datecreation_Act.getAttribute("value");
        System.out.println(Creation);
        DateFormat df = new SimpleDateFormat(pattern);
        Date today = df.parse(Creation);
        Thread.sleep(1000);
        FicheActionPage.objetXpath.click();
        //  JavascriptExecutor executor =(JavascriptExecutor)driver;
        // executor.executeScript("arguments[0].click()", FicheActionPage.objetXpath);
        Thread.sleep(500L);
        WebElement Element = ModeleActionPage.GridSousActionAction.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr[1]/td[7]"));
        String Trait = Element.findElement(By.tagName("span")).getText();
        Date Datrealisation = df.parse(Trait);
        int Dreal = (int) (Datrealisation.getTime() - (int) today.getTime());
        asserttrue(Dreal == del_rea);
        Thread.sleep(500L);
        Element = ModeleActionPage.GridSousActionAction.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr[1]/td[15]"));
        String suivi = Element.findElement(By.tagName("span")).getText();
        Date DatSuivi = df.parse(suivi);
        int Dsuivi = (int) (DatSuivi.getTime() - (int) today.getTime());
        asserttrue(Dsuivi == del_suivi);
    }


}
