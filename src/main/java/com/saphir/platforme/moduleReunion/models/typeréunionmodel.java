package com.saphir.platforme.moduleReunion.models;

import com.github.javafaker.Faker;

import com.saphir.platforme.moduleReunion.pages.ModuleReunionPage;
import com.saphir.platforme.moduleReunion.pages.typeréunionpage;
import com.saphir.platforme.shared.DesignePaterne;
import com.saphir.platforme.utils.Common;
import com.saphir.platforme.utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


import static com.saphir.platforme.controllors.ReunionController.reunion;
import static com.saphir.platforme.moduleAction.stepdefs.FicheActionStepDefinition.row;
import static com.saphir.platforme.moduleReunion.stepdefs.ModuleReunionStepDefinition.filaile;
import static org.testng.Assert.assertTrue;

public class typeréunionmodel {
    public static String recuptr;
    private static String Path = "resources/testData/TestData.xlsx";


    public static void Consulter_typ_réunion(WebDriver driver) throws Exception {
        Thread.sleep(2000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", ModuleReunionPage.menuID);
        if(filaile.equals("Group")){
            Common.AccéderModule(5, 0, 0, driver);
            Common.AccéderModule(5,2,0, driver);

        }else{
        //ModuleReunionPage.menuID.click();
        Thread.sleep(500L);
        Common.AccéderModule(10, 0, 0, driver);
        Common.AccéderModule(10, 2, 0, driver);}
    }

    public static void ajouter_type_réunion() throws Throwable {
        typeréunionpage.ajouter.click();

    }

    public static void saisir_type_réunion(String typeReunion) throws Throwable {
        if((typeReunion==null) || (reunion.getEtat()==0) ){
            typeReunion = "Type Réunion " + DesignePaterne.wordsParagraphe(10);
        }
        recuptr=typeReunion;


        typeréunionpage.TypeRéunion.sendKeys(recuptr);

        Thread.sleep(100);
        reunion.getTypeReunion().setTypeReunion(recuptr);
        Thread.sleep(100);
       // typeréunionpage.valider.click();


    }

    public static void saisir_périodicité(String peroidicite) throws Throwable {
        if (peroidicite==null){
            Faker faker =new Faker();
            peroidicite=String.valueOf(faker.random().nextInt(0,25));
        }
        typeréunionpage.Périodicité.sendKeys(peroidicite);
        Thread.sleep(100);
        reunion.getTypeReunion().setPeriodicite(peroidicite);

    }

    public static void saisir_Source() throws Throwable {
//        ExcelUtils.setExcelFile(Path, "Action");
//        String source = ExcelUtils.getCellData1(row+1, 0);
//        Select select = new Select(typeréunionpage.Source);
//        select.selectByVisibleText(source);

    }

    public static void valider_typeréunion() throws Throwable {
        typeréunionpage.valider.click();
        Thread.sleep(100);



    }

    public static void retour_typeréunion() throws Throwable {
        typeréunionpage.retourID.click();
        Thread.sleep(100);

    }

    public static void filtre_typeréunion() throws Throwable {

        typeréunionpage.filtre.sendKeys(recuptr);

    }

    public static void recherche_typeréunion() throws Throwable {
        typeréunionpage.rechercher.click();

    }

    public static void resultat_typeréunion() throws Throwable {

        String a = typeréunionpage.gridview.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr/td[3]")).findElement(By.tagName("span")).getText();
        assertTrue(recuptr.equals(a));


    }

}
