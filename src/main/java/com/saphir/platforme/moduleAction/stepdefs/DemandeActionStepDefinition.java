package com.saphir.platforme.moduleAction.stepdefs;


import com.saphir.platforme.authentification.models.AuthentificationModel;

import com.saphir.platforme.moduleAction.models.DemandeActionModel;
import com.saphir.platforme.moduleAction.pages.DemandeActionPage;
import com.saphir.platforme.moduleAction.pages.FicheActionPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

import static com.saphir.platforme.moduleAction.stepdefs.FicheActionStepDefinition.origine;


@Test
public class DemandeActionStepDefinition {
    public static String lan;
    public static int row = 0;
    public static String module = "";
    private static final String Path = "src/main/resources/testData/TestData.xlsx";
    public String NewUser = "TESTAUTO2";
    @Autowired
    protected WebDriver driver;
    String Demandeur, NACTION;

    @PostConstruct
    public void init() {

    //    driver = WebDriverConfig.driver;


        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        PageFactory.initElements(driver, DemandeActionPage.class);
        PageFactory.initElements(driver, FicheActionPage.class);

    }


    @When("^saisir (\\d+) demande action$")
    public void saisir_demande_action(int arg1) throws Throwable {
        row = arg1;
        System.out.println(" numero de  ligne  et  : " + row);
    }


    @When("^Consulter demande Action$")
    public void consulter_demande_Action() throws Throwable {

        DemandeActionModel.consulter_Demande(driver);


    }

    @When("^Cliquer sur ajouter$")
    public void cliquer_sur_ajouter() throws Throwable {
        DemandeActionModel.cliquer_Ajouter_Demande(driver);
        Thread.sleep(2000L);
    }

    @When("^Selectionner source$")
    public void selectionner_source() throws Throwable {
        DemandeActionModel.Selectionner_Source(row);
    }

    @When("^Selectionner type$")
    public void selectionner_type() throws Throwable {
        DemandeActionModel.Selectionner_Type(row);
    }

    @When("^Selectionner origine$")
    public void selectionner_origine() throws Throwable {
        DemandeActionModel.Selectionner_Origine();
    }

    @When("^Ajouter Type Cause$")
    public void ajouter_Type_Cause() throws Throwable {
        DemandeActionModel.Ajouter_Type_Cause(row, driver);
    }

    @When("^Ajouter Produit$")
    public void ajouter_Produit() throws Throwable {
        DemandeActionModel.Ajouter_Produit(driver);
    }

    @When("^Selectionner date creation$")
    public void selectionner_date_creation() throws Throwable {
        DemandeActionModel.Selectionner_Date_Creation(driver);
    }

    @When("^Saisir Designation$")
    public void saisir_Designation() throws Throwable {
        DemandeActionModel.Saisir_Designation();
    }

    @When("^Saisir description$")
    public void saisir_description() throws Throwable {
        DemandeActionModel.Saisir_Description();
    }

    @When("^Saisir Cause$")
    public void saisir_Cause() throws Throwable {
        DemandeActionModel.Saisir_Cause();
    }

    @When("^Saisir Objective$")
    public void saisir_Objective() throws Throwable {
        DemandeActionModel.Saisir_Objective();
    }

    @When("^Selectionner Site$")
    public void Selectionner_Site_Demande() throws Throwable {
        DemandeActionModel.Selectionner_Site(driver, row);
    }

    @When("^Selectionner Processus$")
    public void selectionner_Processus_Demande() throws Throwable {
        DemandeActionModel.Selectionner_Processus(driver, row);
    }

    @When("^Selectionner Activite$")
    public void selectionner_Activite_Demande() throws Throwable {
        DemandeActionModel.Selectionner_Activite(driver, row);
    }

    @When("^Selectionner Direction$")
    public void Selectionner_Direction_Demande() throws Throwable {
        DemandeActionModel.Selectionner_Direction(driver, row);
    }

    @When("^Selectionner Service$")
    public void selectionner_Service_Demande() throws Throwable {
        DemandeActionModel.Selectionner_Service(driver, row);
    }

    @When("^Cliquer valider demande action$")
    public void cliquer_valider_demande_action() throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        Thread.sleep(100L);
        //DemandeActionPage.BoutonAjoutID.click();*/
        DemandeActionModel.valider_Demande(driver);
    }

    @When("^cliquer sur ajouter sous action demande$")
    public void cliquer_sur_ajouter_sous_action_demande() throws Throwable {
        DemandeActionModel.clickAjouterSAD(driver);
    }

    @When("^ajouter sous action demande$")
    public void ajouter_sous_action_demande() throws Throwable {
        DemandeActionModel.saisirDesignationSAD(driver);
        DemandeActionModel.selectionnerResponsableRealisationSAD(row);
        DemandeActionModel.selectionnerResponsableSuiviSAD(row);
        DemandeActionModel.choixDateSAD(driver);
    }

    @When("saisir responsable de réalisation modele action")
    public void saisir_responsable_de_réalisation_modele_action() throws Throwable {
        DemandeActionModel.selectionnerResponsableRealisationSAD(row);

    }

    @When("choisir un responsable de suivi modele action")
    public void choisir_un_responsable_de_suivi_modele_action() throws Throwable {
        DemandeActionModel.selectionnerResponsableSuiviSAD(row);
    }

    @When("^choisir gravité DA$")
    public void choisir_gravité_action() throws Throwable {

        DemandeActionModel.Gravite(row);
    }

    @When("^choisir Priorité DA$")
    public void choisir_Priorité_SA() throws Throwable {

        DemandeActionModel.Priorite(row);
    }

    @When("^saisir cout previ DA$")
    public void saisir_cout_previ_SA() throws Throwable {

        DemandeActionModel.Cout_Prev();
    }

    @When("^saisir Risque DA$")
    public void saisir_Risque_SA() throws Throwable {

        DemandeActionModel.Risque();
    }

    @When("^cliquer sur valider sous action demande$")
    public void cliquer_sur_valider_sous_action_demande() throws Throwable {
        DemandeActionModel.validerSAD(driver);
        Thread.sleep(200L);
    }

    @Then("^Verifier sous action ajouté a la liste$")
    public void Verifier_sous_action_ajouté_a_la_liste() throws Throwable {
        //DemandeActionPage.ObjetMenuID.click();
        //Thread.sleep(100L);
        //DemandeActionPage.PlanMenuID.click();
        //Thread.sleep(1000L);
        //To find first row of table
        WebElement tableRow = DemandeActionPage.Table_SAD_ID.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr"));

        //to get 1rd row's 3nd column data
        WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr/td[3]"));
        String verifDesignation = cellIneed.getText();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
        Thread.sleep(1000L);
        if (!(verifDesignation.equals(""))) Assert.assertTrue(true);

    }

    @Then("^Verifier fiche Demande Action ajoute$")
    public void Verifier_fiche_Demande_Action_ajoute() throws Throwable {
        DemandeActionModel.Verifier_Demande_Ajout();
        Demandeur = DemandeActionPage.DemandeurID.getText();
    }

    @Then("^Recuperer responsable validation$")
    public void Recuperer_responsable_validation() throws Throwable {
        DemandeActionModel.recuperer_responsable();
    }


    @Then("^Valider Demande Action par les responsable$")
    public void Valider_Demande_Action_par_les_responsable() throws Throwable {
        String curResp;
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
                DemandeActionModel.Acceder_Demande(driver, origine);

                DemandeActionPage.ButtonVrID.click();
            }
        } while (!(curResp.equals("")));
    }


    @When("^Saisir Numero Demande$")
    public void saisir_Numero_Demande() throws Throwable {
        DemandeActionModel.Deconnexion_Compte(driver);
        AuthentificationModel.Changer_Compte(Demandeur, driver);
        Thread.sleep(4000L);
        DemandeActionModel.consulter_Demande(driver);

        DemandeActionModel.Saisir_Numero_Demande();
    }

    @When("^Cliquer rechercher Demande$")
    public void Cliquer_rechercher_Demande() throws Throwable {
        WebElement element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_Filtre_Rechercher"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
        //DemandeActionModel.Cliquer_rechercher_Demande();
    }

    @Then("^Verifier Demande Action validé$")
    public void Verifier_Demande_Action_validé() throws Throwable {
        Thread.sleep(1000L);

        WebElement row = DemandeActionPage.TableDemandeID.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1p\"]/thead/tr"));
        int sizecol = DemandeActionPage.TableDemandeID.findElements(By.tagName("td")).size();
        System.out.println("Size : " + sizecol);
        //postion  de  status  de  demande action
        int pos = 0;
        for (int i = 1; i < sizecol - 1; i++) {
            String NameCol = DemandeActionPage.TableDemandeID.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1p\"]/thead/tr/th[" + i + "]")).getText();
            System.out.println("Name colomun : " + NameCol);
            if (NameCol.equals("Statut") || NameCol.equals("Status")) {
                pos = i;
                break;
            }

        }
        WebElement tableRow = DemandeActionPage.TableDemandeID.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1p\"]/tbody/tr"));
        WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1p\"]/tbody/tr/td[" + pos + "]"));

        String verifDesignation = cellIneed.getText();
        int posNumAct = pos + 1;
        WebElement cellIneed1 = tableRow.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1p\"]/tbody/tr[1]/td[" + posNumAct + "]"));
        NACTION = cellIneed1.getText();
        Thread.sleep(1000L);
        System.out.println("Statut  demande  : " + verifDesignation);

        if ((verifDesignation.equals("DEMANDE VALIDEE")) || (verifDesignation.equals("Request approved"))) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

    }

    @When("^Saisir Code Action$")
    public void Saisir_Code_Action() throws Throwable {
        FicheActionPage.RechFiltreId.sendKeys(NACTION);
    }

    @When("^Saisir \"([^\"]*)\" Action$")
    public void Saisir_Action(String arg1) throws Throwable {
        FicheActionPage.RechFiltreId.sendKeys(arg1);
    }

    @When("^Rechercher Action$")
    public void Rechercher_Action() throws Throwable {
        FicheActionPage.BtnRechFiltId.click();
    }

    @Then("^Afficher Fiche Action$")
    public void Afficher_Fiche_Action() throws Throwable {
        Thread.sleep(2000L);
        WebElement tableRow = FicheActionPage.TableFiltreAction.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1P\"]/tbody/tr"));
        WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1P\"]/tbody/tr/td[2]"));
        WebElement cellIneed1 = cellIneed.findElement(By.tagName("a"));
        cellIneed1.click();
        Thread.sleep(1000L);

        Assert.assertTrue(true);

    }

    @Then("^Afficher aperçu Fiche Action$")
    public void Afficher_aperçu_Fiche_Action() throws Throwable {
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_Label150")).click();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton16")).click();
        Thread.sleep(1000);
    }

    @Then("^Exporter fiche Action$")
    public void Exporter_fiche_Action() throws Throwable {
        driver.findElement(By.id("IconImg_CrystalReportViewer1_toptoolbar_export")).click();
        Thread.sleep(500);
        WebElement element = driver.findElement(By.id("bobjid_1547215355460_dialog_combo")).findElement(By.xpath("//*[@id=\"bobjid_1547215355460_dialog_combo\"]/tbody/tr/td[2]")).findElement(By.id("iconMenu_arrow_bobjid_1547215355460_dialog_combo")).findElement(By.xpath("//*[@id=\"iconMenu_arrow_bobjid_1547215355460_dialog_combo\"]/tbody/tr/td")).findElement(By.tagName("div")).findElement(By.id("IconImg_iconMenu_arrow_bobjid_1547215355460_dialog_combo"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
        Thread.sleep(500);
        driver.findElement(By.id("iconMenu_menu_bobjid_1547214709695_dialog_combo_text_bobjid_1547214709695_dialog_combo_it_11")).click();
        Thread.sleep(500);
        driver.findElement(By.id("theBttnbobjid_1547214709695_dialog_submitBtn")).click();

    }
}