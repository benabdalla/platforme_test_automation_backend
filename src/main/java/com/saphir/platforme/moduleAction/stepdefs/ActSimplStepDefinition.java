package com.saphir.platforme.moduleAction.stepdefs;


import com.saphir.platforme.authentification.pages.AuthentificationPage;
import com.saphir.platforme.controllors.ActionRunTest;
import com.saphir.platforme.entity.Action;
import com.saphir.platforme.moduleAction.models.ActSimplModel;
import com.saphir.platforme.moduleAction.pages.ActSimplPage;
import com.saphir.platforme.moduleAction.pages.FicheActionPage;
import com.saphir.platforme.utils.Setup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.saphir.platforme.moduleAction.stepdefs.FicheActionStepDefinition.fgRespSuivi;

public class ActSimplStepDefinition {
    private static final String Path = "src/main/resources/testData/TestData.xlsx";
    public static String lan;
    public static int row = 0;
    public static String module = "";
    public static int seulRespo = 0;
    public static String actionSimpl = "";
    public static WebDriver driver;
    static Action action;

    public ActSimplStepDefinition() {
        action = ActionRunTest.action;
        driver = Setup.driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, AuthentificationPage.class);
        PageFactory.initElements(driver, FicheActionPage.class);
    }


    @When("cliquer sur action simplifiée parametrage")
    public void cliquer_sur_action_simplifiée_parametrage() throws InterruptedException {

        if (action.getActSimplifier() == 1) {
            actionSimpl = "action_simplifiée";
        }

    }

    @When("cliquer sur action simplifiée")
    public void cliquer_sur_action_simplifiée() throws InterruptedException {
        if (action.getActSimplifier() == 1) {
            actionSimpl = "action_simplifiée";
        }
        ActSimplModel.consulterFiltreActionsSimplifiée(driver);
    }


    @When("^choisir un responsable de clôture simplifie$")
    public void choisir_un_responsable_de_clôture_simplifie() throws Throwable {
        ActSimplModel.resp_cloture(row);
    }


    @When("^cliquer sur valider Action simplifiée$")
    public void cliquer_sur_valider_Action_simplifiée() throws Throwable {


        ActSimplModel.validationActSimpl(driver);
    }


    @When("^saisir un seul responsable de suivi$")
    public void saisir_un_seul_responsable_de_suivi() throws Throwable {

        seulRespo = 1;
        ActSimplModel.ResponsableSuivi(driver, row, fgRespSuivi);
    }

    @When("^saisir la date de suivi$")
    public void saisir_la_date_de_suivi() throws Throwable {


        ActSimplModel.DateSuivi(driver);
    }


    @When("^Vérifier responsable de suivi$")
    public void Vérifier_responsable_de_suivi() throws Throwable {
        ActSimplModel.VérifierRespSuivi(row);

    }

    @When("^Vérifier délais de suivi$")
    public void Vérifier_délais_de_suivi() throws Throwable {
        ActSimplModel.VérifierDateSuivi();
    }

    @Then("^cliquer sur ajouter sous action simplifiee$")
    public void cliquer_sur_ajouter_sous_action_simplifiee() throws Throwable {


        ActSimplModel.clickAjouterSousActionModeleAction(driver);
        Thread.sleep(2000L);
    }

    @Then("^sous action ajouté a la liste des sous actions simplifiee$")
    public void sous_action_ajouté_a_la_liste_des_sous_actions_simplifiee() throws Throwable {
        Thread.sleep(100L);
        Actions action = new Actions(driver);
        action.moveToElement(ActSimplPage.desgSousActionModeleAction).perform();
        String verifDesignation = ActSimplPage.desgSousActionModeleAction.findElement(By.tagName("a")).getText();
        if (verifDesignation.contains("1")) {
            System.out.println("sous action ajoute");
        }
    }


    /*@When("^saisir délais de réalisation$")
    public void saisir_délais_de_réalisation() throws Throwable {

    }

    @When("^vérifier champ responsable de suivi est rempli automatiquement$")
    public void vérifier_champ_responsable_de_suivi_est_rempli_automatiquement() throws Throwable {

    }

    @When("^rattacher des directions associées$")
    public void rattacher_des_directions_associées() throws Throwable {

    }

    @Then("^vérifier que la sous action est ajoutée dans la liste des sous actions$")
    public void vérifier_que_la_sous_action_est_ajoutée_dans_la_liste_des_sous_actions() throws Throwable {

    }

    @When("^vérifier compteur agenda$")
    public void vérifier_compteur_agenda() throws Throwable {

    }

    @Then("^incrémentation compteur agenda Action$")
    public void incrémentation_compteur_agenda_Action() throws Throwable {

    }

    @When("^Consulter agenda Action à réaliser$")
    public void consulter_agenda_Action_à_réaliser() throws Throwable {

    }

    @Then("^Cliquer sur action simplifiée$")
    public void cliquer_sur_action_simplifiée() throws Throwable {

    }

    @Then("^Vérifier que le champs liste d’actions est rempli$")
    public void vérifier_que_le_champs_liste_d_actions_est_rempli() throws Throwable {

    }

    @Then("^saisir taux de réalisation \\(fichier excel\\)$")
    public void saisir_taux_de_réalisation_fichier_excel() throws Throwable {

    }

    @Then("^saisir cout \\(fichier excel\\)$")
    public void saisir_cout_fichier_excel() throws Throwable {

    }

    @Then("^saisir date de réalisation \\(scénario outline si le taux est inférieur ou supérieur à (\\d+) /Si le taux est égale à (\\d+)\\)$")
    public void saisir_date_de_réalisation_scénario_outline_si_le_taux_est_inférieur_ou_supérieur_à_Si_le_taux_est_égale_à(int arg1, int arg2) throws Throwable {

    }

    @Then("^ajouter commentaire$")
    public void ajouter_commentaire() throws Throwable {

    }

    @Then("^Ajouter intervenant ou groupe$")
    public void ajouter_intervenant_ou_groupe() throws Throwable {

    }

    @Then("^ajouter pièce jointe$")
    public void ajouter_pièce_jointe() throws Throwable {

    }

    @When("^cliquer sur valider réalisation action$")
    public void cliquer_sur_valider_réalisation_action() throws Throwable {

    }

    @Then("^vérifier compteur agenda \\(en cas de taux de réalisation égale à (\\d+)\\)$")
    public void vérifier_compteur_agenda_en_cas_de_taux_de_réalisation_égale_à(int arg1) throws Throwable {

    }

    @Then("^cliquer sur action à suivre$")
    public void cliquer_sur_action_à_suivre() throws Throwable {

    }

    @Then("^Vérifier le taux de rélaisation et date de réalisation sont remplies$")
    public void vérifier_le_taux_de_rélaisation_et_date_de_réalisation_sont_remplies() throws Throwable {

    }

    @Then("^saisir taux de suivi$")
    public void saisir_taux_de_suivi() throws Throwable {

    }

    @Then("^saisir commentaire$")
    public void saisir_commentaire() throws Throwable {

    }

    @When("^Valider suivi action simplifiée$")
    public void valider_suivi_action_simplifiée() throws Throwable {

    }

    @Then("^vérifier compteur agenda \\(nombre d’actions à suivre décrémente de (\\d+)\\)$")
    public void vérifier_compteur_agenda_nombre_d_actions_à_suivre_décrémente_de(int arg1) throws Throwable {

    }

    @Then("^Vérifier agenda action à clôturer$")
    public void vérifier_agenda_action_à_clôturer() throws Throwable {

    }

    @Then("^cliquer sur clôturer action$")
    public void cliquer_sur_clôturer_action() throws Throwable {

    }

    @When("^consulter action$")
    public void consulter_action() throws Throwable {

    }

    @When("^saisir Numéro action$")
    public void saisir_Numéro_action() throws Throwable {

    }

    @When("^choisir Type action$")
    public void choisir_Type_action() throws Throwable {

    }

    @When("^sélectionner source action$")
    public void sélectionner_source_action() throws Throwable {

    }

    @When("^saisir désignation$")
    public void saisir_désignation() throws Throwable {

    }

    @When("^cliquer sur rechercher action$")
    public void cliquer_sur_rechercher_action() throws Throwable {

    }

    @Then("^Liste des actions contient la fiche action à recherche$")
    public void liste_des_actions_contient_la_fiche_action_à_recherche() throws Throwable {

    }

    @Then("^Ouvrir fiche action$")
    public void ouvrir_fiche_action() throws Throwable {

    }

    @When("^vérifier si toutes les données existe$")
    public void vérifier_si_toutes_les_données_existe() throws Throwable {

    }

    @When("^consulter reporting actions$")
    public void consulter_reporting_actions() throws Throwable {

    }

    @When("^cliquer sur bilan des actions$")
    public void cliquer_sur_bilan_des_actions() throws Throwable {

    }

*/

}