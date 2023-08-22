package com.saphir.platforme.moduleAction.models;

import com.saphir.platforme.moduleAction.pages.ActSimplPage;
import com.saphir.platforme.moduleAction.pages.FicheActionPage;
import com.saphir.platforme.shared.DesignePaterne;
import com.saphir.platforme.utils.Common;
import com.saphir.platforme.utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.saphir.platforme.controllors.ActionRunTest.action;


public class ActSimplModel {

    /* Public methods */

    private static final String Path = "resources/testData/TestData.xlsx";

    public static void consulterFiltreActionsSimplifiée(WebDriver driver) throws InterruptedException {
        //FicheActionPage.btnAjouterAction.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", FicheActionPage.btnAjouterAction);
        Thread.sleep(1000L);
        //ActSimplPage.AjouterActSimplifiee.click();
        executor.executeScript("arguments[0].click()", ActSimplPage.AjouterActSimplifiee);
        Thread.sleep(1000L);
        Common.Exporter_visibilité("Nouvelle Fiche Action Simplifie");
        Common.Exporter_champ_A_masquer("Nouvelle Fiche Action Simplifie");
    }

    public static void service() throws Exception {
        ExcelUtils.setExcelFile(Path, "ActSimpl");
        Select select = new Select(ActSimplPage.serviceActSimplifiee);
        select.selectByVisibleText(ExcelUtils.getCellData(1, 0));
    }

    public static void resp_cloture(int row) throws Exception {


        Select select = new Select(ActSimplPage.Respcloture);
        String value= Common.getValueSelected(ActSimplPage.Respcloture,action.getRespCloture().getName());
        select.selectByValue(value);
    }

    public static void validationActSimpl(WebDriver driver) throws InterruptedException {
        //ActSimplPage.VldenregactSimplifiee.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", ActSimplPage.VldenregactSimplifiee);
        Thread.sleep(1000L);
    }

    public static void datecreation(WebDriver driver) throws Exception {

        //ActSimplPage.DatecreationActSimplifiee.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", ActSimplPage.DatecreationActSimplifiee);
        Thread.sleep(1000);
        //ActSimplPage.agendacreation.click();
        executor.executeScript("arguments[0].click()", ActSimplPage.agendacreation);
    }

    public static void ResponsableSuivi(WebDriver driver, int row, String fg) throws Exception {
        //ActSimplPage.VolDetailsActionId.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", ActSimplPage.VolDetailsActionId);
        Thread.sleep(1000);
        ActSimplPage.TypeRespSuiviId.click();
               /* executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click()", ActSimplPage.TypeRespSuiviId);
            Thread.sleep(1000);
            ExcelUtils.setExcelFile(Path, "Action");
            Select select = new Select(ActSimplPage.RespSuiviId);
            select.selectByVisibleText(ExcelUtils.getCellData(row,6));*/

        FicheActionPage.UnSeulSelectresponsableSuviID.click();
        Thread.sleep(500);

        Select selectfg = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ListBoxFiliale_AutreEmpSeulRespSuivi")));
        selectfg.selectByVisibleText(fg);

        String employer = action.getRespSuivi().getName();
        System.err.println("Employee  is   :   " + employer);
        FicheActionPage.winserSeulResSuvi.sendKeys(employer);
        FicheActionPage.wrecherSeulRespoSuvi.click();
        FicheActionPage.wTabSeulSuvi.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_AutreEmpSeulRespSuivi\"]/tbody/tr[1]/td[1]")).findElement(By.tagName("a")).click();


        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton30")).click();


    }

    public static void DateSuivi(WebDriver driver) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 60);
        //   wait.until(ExpectedConditions.elementToBeClickable(ActSimplPage.DelaiSuiviId));
        ActSimplPage.DelaiSuiviId.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        //executor.executeScript("arguments[0].click()", ActSimplPage.DelaiSuiviId);
        Thread.sleep(1000);
        //		wait.until(ExpectedConditions.elementToBeClickable(ActSimplPage.DateSuiviId));
        ActSimplPage.DateSuiviId.click();
        //executor.executeScript("arguments[0].click()", ActSimplPage.DateSuiviId);
        //ActSimplPage.BtnVldRespSuiviId.click();
        executor.executeScript("arguments[0].click()", ActSimplPage.BtnVldRespSuiviId);
        Thread.sleep(1000);

    }

    public static void VérifierRespSuivi(int row) throws Exception {
        boolean VerifRespSuivi = FicheActionPage.SeulresponsableSuiviID.isDisplayed();
        System.out.println(VerifRespSuivi);
        Assert.assertTrue(VerifRespSuivi);
        //Select select = new Select(FicheActionPage.responsableSuiviID);


        System.out.println(FicheActionPage.SeulresponsableSuiviIDSous.getAttribute("value"));
        String respoSuivi = FicheActionPage.SeulresponsableSuiviIDSous.getAttribute("value");
        ExcelUtils.setExcelFile(Path, "Action");
        String employer = action.getRespSuivi().getName();
        System.out.println("row = " + row);
        Assert.assertEquals(employer, respoSuivi);
        System.err.println("Employee  is   :   " + employer);


    }

    public static void VérifierDateSuivi() throws Exception {
        boolean VerifDateSuivi = ActSimplPage.AFFDateSuiviId.isDisplayed();
        System.out.println(VerifDateSuivi);
        if (VerifDateSuivi) {
            System.out.println(ActSimplPage.AFFDateSuiviId.getText());
        }

    }

    public static void clickAjouterSousActionModeleAction(WebDriver driver) {

        //ActSimplPage.btnAjouterSousActionModeleAction.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", ActSimplPage.btnAjouterSousActionModeleAction);
    }


}
