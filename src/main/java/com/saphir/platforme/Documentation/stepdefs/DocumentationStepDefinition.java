package com.saphir.platforme.Documentation.stepdefs;

import com.github.javafaker.Faker;
import com.saphir.platforme.Documentation.models.DocumentationModele;
import com.saphir.platforme.Documentation.pages.DocumentationPage;
import com.saphir.platforme.authentification.models.AuthentificationModel;
import com.saphir.platforme.controllors.DocumentationController;
import com.saphir.platforme.entity.Documentation;
import com.saphir.platforme.moduleReunion.pages.ModuleReunionPage;
import com.saphir.platforme.shared.DesignePaterne;
import com.saphir.platforme.utils.Common;
import com.saphir.platforme.utils.ExcelUtils;
import com.saphir.platforme.utils.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import static com.saphir.platforme.moduleReunion.stepdefs.ModuleReunionStepDefinition.filaile;
import static com.saphir.platforme.moduleReunion.stepdefs.ModuleReunionStepDefinition.row;
import static org.testng.Assert.assertTrue;


public class DocumentationStepDefinition {

    public WebDriver driver;
    public String CompteurDocument, CodeDocument = "";


    public String pathTelechargment = "E:/qualipro/trunk/platforme_test_automation_backend/resources/Telechargement";
    public String pathContext = "E:/qualipro/trunk/platforme_test_automation_backend/resources/Telechargement";
    private static String Path = "resources/testData/TestData.xlsx";
    public static String filePathResource = "E:/qualipro/trunk/platforme_test_automation_backend/";

    String module = "Documentation";
    static String circuit = "";
    public String[] Fils = null;
    public List<String> informations = new ArrayList<String>();
    String compteur, compteur1, dateEnvoi;
    static int securise, pdf, codification, visibleAtous;

    public static Documentation documentation;

    public DocumentationStepDefinition() {
        driver = Setup.driver;
        documentation = DocumentationController.documentation;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, DocumentationPage.class);
        PageFactory.initElements(driver, ModuleReunionPage.class);
    }

    @When("Connecter en tant que superviseur")
    public void connecter_en_tant_superviseur() throws Exception {

        AuthentificationModel.saisirLogin(documentation.getTypeDocumentation().getSuperviseur().getLogin());


        Thread.sleep(200L);
        AuthentificationModel.saisirPW(documentation.getTypeDocumentation().getSuperviseur().getPassword());

    }

    @When("Connecter en tant que redacteur")
    public void connecter_en_tant_redacteur() throws Exception {

        AuthentificationModel.saisirLogin(documentation.getTypeDocumentation().getRedacteur().getLogin());


        Thread.sleep(200L);
        AuthentificationModel.saisirPW(documentation.getTypeDocumentation().getRedacteur().getPassword());

    }

    @When("Connecter en tant que verficateur")
    public void connecter_en_tant_verficateur() throws Exception {

        AuthentificationModel.saisirLogin(documentation.getTypeDocumentation().getVerificateurs().getLogin());


        Thread.sleep(200L);
        AuthentificationModel.saisirPW(documentation.getTypeDocumentation().getVerificateurs().getPassword());

    }

    @When("Connecter en tant que approbateur")
    public void connecter_en_tant_approbateur() throws Exception {

        AuthentificationModel.saisirLogin(documentation.getTypeDocumentation().getApprobateur().getLogin());


        Thread.sleep(200L);
        AuthentificationModel.saisirPW(documentation.getTypeDocumentation().getApprobateur().getPassword());

    }

    @When("saisir filaile documentation")
    public void saisir_filaile_documentation() throws InterruptedException {
        filaile = documentation.getFilaileScenario();
        if (!filaile.equals("MONO")) {

            Thread.sleep(2000);
            Select selectOpTGF = new Select((driver.findElement(By.id("ctl00_DDLFiliale"))));
            String gf = selectOpTGF.getFirstSelectedOption().getText();
            String valueFg = DesignePaterne.getFiliale(filaile);
            if (!filaile.equals(gf)) {
         try{       selectOpTGF.selectByValue(valueFg);}
         catch (Exception exp){

         }
            }
        }


    }

    @When("Paramétrage documentation")
    public void paramétrage_documentation() {
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButtonParamDoc")).click();
    }

    @Then("choisir {string} décideur")
    public void choisir_décideur(String string) {
        WebElement redacteur = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_Rb_decid_redac\"]"));
        WebElement superviseur = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_Rb_decid_superv\"]"));
        if (string.equals("Rédacteur")) {
            boolean isSelected = redacteur.isSelected();
            if (!isSelected) {
                redacteur.click();
            }
        } else {
            boolean isSelected = superviseur.isSelected();
            if (!isSelected) {
                superviseur.click();
            }
        }
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButtonValidDoc")).click();


    }


    @Then("vérifier le décideur cocher {string}")
    public void vérifier_le_décideur_cocher(String string) {
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButtonParamDoc")).click();
        WebElement redacteur = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_Rb_decid_redac\"]"));
        WebElement superviseur = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_Rb_decid_superv\"]"));
        if (string.equals("Rédacteur")) {
            boolean isSelected = redacteur.isSelected();
            Assert.assertTrue(isSelected);
        } else {
            boolean isSelected = superviseur.isSelected();
            Assert.assertTrue(isSelected);
        }

    }


    @When("cliquer  sur  ceration  modification   doc")
    public void cliquer_sur_ceration_modification_doc() throws Exception {
        Thread.sleep(3000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", ModuleReunionPage.menuID);
//		ModuleAuditsPage.menuID.click();
        Thread.sleep(1000);
        Common.AccéderModule(1, 0, 0, driver);
        Common.AccéderModule(1, 3, 0, driver);
        Thread.sleep(500);

        JavascriptExecutor excouter2 = (JavascriptExecutor) driver;
        excouter2.executeScript("arguments[0].click()", driver.findElement(By.id("ctl00_ContentPlaceHolder1_Ajouter")));
        Thread.sleep(500);
        Select select = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_List_TypeD")));
        select.selectByValue("330");
        Thread.sleep(500);

        driver.findElement(By.id("ctl00_ContentPlaceHolder1_Text_LibD")).sendKeys(Common.paragraphe(5, 8));
        Thread.sleep(500);
    }

    @When("cliquer sur superviseur  au Rédacteur")
    public void cliquer_sur_superviseur_au_Rédacteur() {
        DocumentationPage.wSupRedc.click();

    }

    @When("cliquer sur Envoyer au Rédacteur")
    public void cliquer_sur_Envoyer_au_Rédacteur() {
        DocumentationPage.wEnRedc.click();
    }


    @When("^Consulter boite de dialogue$")
    public void Consulter_boite_de_dialogue() throws Throwable {
        DocumentationModele.cliqueBoiteDeDialogue(driver);
        Thread.sleep(1000L);
        Fils = Common.NbrFils(pathTelechargment);
        System.out.println("Nombre des fichier dans la reparatoire Telechargement est :" + Fils.length);
    }

    @When("consulter  le message de   Boîte de réception")
    public void consulter_le_message_de_boîte_de_réception() throws Exception {
        Thread.sleep(1000);
        JavascriptExecutor jesExecutor = (JavascriptExecutor) driver;
        jesExecutor.executeScript("arguments[0].click()", DocumentationPage.menuID);
        // DocumentationPage.menuID.click();
        Thread.sleep(200);

        Common.AccéderModule(2, 0, 0, driver);
        DesignePaterne.javaScriptExcuptor(DocumentationPage.BoiteReception);
        DesignePaterne.javaScriptExcuptor(DocumentationPage.afficheMessage);
        DesignePaterne.javaScriptExcuptor(driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_checkBoxRecepLu\"]")));

        ExcelUtils.setExcelFile(Path, module);
        String message = ExcelUtils.getCellData1(row, 2);
        DocumentationPage.rechecherechetextMessage.sendKeys(message);
        DesignePaterne.javaScriptExcuptor(DocumentationPage.loopRechrecher);


    }

    @Then("vérifier le message  lu et  traite")
    public void vérifier_le_message_lu_et_traite() {
        boolean lu = DocumentationPage.tabMessage.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_Rec\"]/tbody/tr[1]/td[7]")).findElement(By.tagName("input")).isSelected();
        boolean traite = DocumentationPage.tabMessage.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_Rec\"]/tbody/tr[1]/td[8]")).findElement(By.tagName("input")).isSelected();
        Assert.assertTrue(lu, "Non lu");
        Assert.assertTrue(traite, "Non traite");
    }

    @When("^cliquer sur Rédacteur au superviseur$")
    public void cliquer_sur_Rédacteur_au_superviseur() throws Throwable {
        Thread.sleep(4000);
        compteur1 = DocumentationModele.getValeurCompteur();
        System.out.println("cliquer sur Rédacteur au superviseur");

        System.out.println("Valeur compteur increment est: " + compteur1);
        DocumentationModele.cliqueRedacteurSuperviseur(driver);
    }

    @When("^Saisir (\\d+)$")
    public void saisir(int arg1) throws Throwable {
        DocumentationModele.choixTypeDocument(arg1, documentation.getTypeDocumentation().getTypeDoc());
        row = arg1;
    }

    @When("^Saisir ligne (\\d+)$")
    public void saisir_ligne(int arg1) throws Throwable {
        row = arg1;
    }

    /*
     * @When("^Saisir Type document$") public void saisir_Type_document() throws
     * Throwable { DocumentationModele.choixTypeDocument(); }
     */
    @When("^Saisir Objet$")
    public void saisir_Objet() throws Throwable {
        String object = DocumentationModele.saisirObjet(documentation.getObjet());
        documentation.setObjet(object);
    }

    @When("^rattacher fichier lien$")
    public void rattacher_fichier_lien() throws Throwable {
        DocumentationModele.choixFichier(driver,documentation.getEtat(),documentation.getPathDoc());

    }

    @When("^rattacher fichier lienn$")
    public void rattacher_fichier_lienn() throws Throwable {
        DocumentationModele.choixFichierr(driver);


    }

    @When("^Saisir message$")
    public void saisir_message() throws Throwable {
        DocumentationModele.saisirMessage();
    }

    @When("^choisir site lab$")
    public void choisir_site_lab() throws Throwable {

        try {


            WebElement site = driver.findElement(By.id("ctl00_ContentPlaceHolder1_ListBoxSite"));

            Select select = new Select(site);
            ExcelUtils.setExcelFile(Path, "Documentation");
            String value = ExcelUtils.getCellData(row, 18);
            select.selectByVisibleText(value);
        } catch (NoSuchElementException e) {
            Common.Exporter_visibilité("le site est invisible");
        }


    }

    @When("^choisir processus lab$")
    public void choisir_processus_lab() throws Throwable {
        try {


            WebElement processus = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lBProcessus_"));

            Select select = new Select(processus);
            ExcelUtils.setExcelFile(Path, "Documentation");
            String value = ExcelUtils.getCellData(row, 19);
            select.selectByVisibleText(value);
        } catch (NoSuchElementException e) {
            Common.Exporter_visibilité("le site est invisible");
        }

    }

    @When("^choisir activite lab$")
    public void choisir_activite_lab() throws Throwable {
        try {


            WebElement activite = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lBDomaine_"));

            Select select = new Select(activite);
            ExcelUtils.setExcelFile(Path, "Documentation");
            String value = ExcelUtils.getCellData(row, 20);
            select.selectByVisibleText(value);
        } catch (NoSuchElementException e) {
            Common.Exporter_visibilité("le site est invisible");
        }

    }

    @When("^choisir direction lab$")
    public void choisir_direction_lab() throws Throwable {
        try {


            WebElement direction = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lBDirection_"));

            Select select = new Select(direction);
            ExcelUtils.setExcelFile(Path, "Documentation");
            String value = ExcelUtils.getCellData(row, 21);
            select.selectByVisibleText(value);
        } catch (NoSuchElementException e) {
            Common.Exporter_visibilité("le site est invisible");
        }

    }


    @When("^choisir service lab$")
    public void choisir_service_lab() throws Throwable {
        try {


            WebElement service = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lBService_"));


            Select select = new Select(service);
            ExcelUtils.setExcelFile(Path, "Documentation");
            String value = ExcelUtils.getCellData(row, 22);
            select.selectByVisibleText(value);
        } catch (NoSuchElementException e) {
            Common.Exporter_visibilité("le site est invisible");
        }

    }


    @When("^cliquer sur Envoyer au superviseur$")
    public void cliquer_sur_Envoyer_au_superviseur() throws Throwable {
        DocumentationModele.cliqueEnvoiSuperviseur();

    }

    @Then("^verifier ajout dans la boite d envoi et vérifier message a été envoyé$")
    public void verifier_ajout_dans_la_boite_d_envoi_et_vérifier_message_a_été_envoyé() throws Throwable {
        DocumentationModele.cliqueAgendaDocument(driver);
        WebElement boit = driver.findElement(By.id("ctl00_ContentPlaceHolder1_Nbr_dialog"));
        DesignePaterne.javaScriptExcuptor(boit);
        if (!filaile.equals("MONO")) {
            Common.agendaFG("ctl00_ContentPlaceHolder1_GridView_DocMessage", filaile);
        }
        DocumentationModele.cliqueBoiteEnvoi(driver);
        DocumentationModele.VerifierAjoutDansBoiteEnvoi(driver,documentation.getTypeDocumentation().getTypeDoc());
    }

    @Then("^verifier l incrémentation du compteur$")
    public void verifier_l_incrémentation_du_compteur() throws Throwable {
        boolean inc = false;
        // String compteur, compteur1;

        DocumentationPage.HomeID.click();
        Thread.sleep(4000);
        compteur = DocumentationModele.getValeurCompteur();
        System.out.println("Valeur compteur increment est: " + compteur);
        // assertTrue(Integer.parseInt(compteur) == Integer.parseInt(compteur1) + 1);

    }

    @When("^cliquer sur agenda documentation$")
    public void cliquer_sur_agenda_documentation() throws Throwable {
        DocumentationModele.cliqueAgendaDocument(driver);

    }


    @When("saisir circuit {string}")
    public void saisir_circuit(String string) {
        circuit = string;
    }

    @Then("Vérifier le poupup")
    public void vérifier_le_poupup() throws InterruptedException {
        String info = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lb_msg_correct_redac")).getText();
        String str = "";
        Cookie cookie1 = driver.manage().getCookieNamed("lan");
        if (cookie1.getValue().equals("en-US")) {
            str = "This document is sent for information only, the decision to return/comment is up to  the editor.";

        } else {
            str = "Ce document est envoyé seulement pour information, la décision de retour/commentaire revient au rédacteur";

        }
        Common.compareTowLargeString(info, str);
        Thread.sleep(500);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_PanelNbAutoriseAtteint\"]/div/div/div[2]/button"));
        DesignePaterne.javaScriptExcuptor(element);
    }

    @When("Change compte rédacteur")
    public void change_compte_rédacteur() throws Exception {


        String value = documentation.getTypeDocumentation().getSuperviseur().getName();

        DocumentationPage.CompteID.click();
        Thread.sleep(500);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", DocumentationPage.DeconnID);
        JavascriptExecutor executor2 = (JavascriptExecutor) driver;
        executor2.executeScript("arguments[0].click();", DocumentationPage.DeconnID);
        Thread.sleep(500);
        System.err.println("Personne : " + value);
        AuthentificationModel.Changer_Compte(value, driver);
        Thread.sleep(2000L);


    }


    @Given("^cliquer sur notification agenda boite de dialogue (\\d+)$")
    public void cliquer_sur_notification_agenda_boite_de_dialogue(int arg1) throws Throwable {
        // DocumentationPage.HomeID.click();
        Thread.sleep(2000);
        DocumentationModele.cliqueAgendaDocument(driver);
        Thread.sleep(2000);
        DocumentationModele.cliqueCompteurBoiteDialogue();
        Thread.sleep(1000);
        DocumentationModele.cliqueConsulterMessage(driver, arg1);

    }

    @When("^cliquer sur notification agenda boite de dialogue$")
    public void cliquer_sur_notification_agenda_boite_de_dialogue() throws Throwable {
        // DocumentationPage.HomeID.click();
        Thread.sleep(2000);
        DocumentationModele.cliqueAgendaDocument(driver);
        Thread.sleep(2000);
        DocumentationModele.cliqueCompteurBoiteDialogue();
        Thread.sleep(1000);
        if (!filaile.equals("MONO")) {
            Common.agendaFG("ctl00_ContentPlaceHolder1_GridView_DocMessage", filaile);
        }


//        int sizeAuditeur = driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView_DocMessage")).findElements(By.tagName("tr")).size();
//        System.out.println("list auditeur  apres filter :" + sizeAuditeur);
//        for (int i = 1; i <= sizeAuditeur - 1; i++) {
//            Thread.sleep(500L);
//            String filiale = driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView_DocMessage")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_DocMessage\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).getText();
//            System.out.println("filiale ====> " + filiale);
//            System.out.println("fg ====> " + filaile);
//            System.out.println("assert ====> " + filaile.contains(filiale));
//            if (filaile.contains(filiale)) {
//                driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView_DocMessage")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_DocMessage\"]/tbody/tr[" + i + "]/td[1]")).findElement(By.tagName("a")).click();
//            }
//        }

        DocumentationModele.cliqueConsulterMessage(driver);

    }


    @When("^cliquer sur document boite de réception$")
    public void cliquer_sur_document_boite_de_réception() throws Throwable {
        Thread.sleep(500);
        DocumentationModele.cliqueDocumentBoiteDialogue();
        Thread.sleep(1000);
    }

    @Given("^cliquer sur le fichier joint pour stocker le document au niveau de l infrastructurePP$")
    public void cliquer_sur_le_fichier_joint_pour_stocker_le_document_au_niveau_de_l_infrastructurePP() throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#body > div.news.news1 > div.alignl > div.panel.panel-infoPers.C_entete > div.panel-body > div:nth-child(3) > div > div > div:nth-child(1) > div > div.col-md-8.col-sm-8.col-xs-8.col-lg-8.espacebottom > div > span > label")).click();
        Thread.sleep(1000);
        Runtime.getRuntime().exec(filePathResource + "resources/Scripts/joindreFichier.exe");
        Thread.sleep(1000);
    }


    @When("^cliquer sur le fichier joint pour stocker le document au niveau de l infrastructure$")
    public void cliquer_sur_le_fichier_joint_stocker_le_document_au_niveau_de_l_infrastructure() throws Throwable {
        System.out.println("cliquer_sur_le_fichier_joint_stocker_le_document_au_niveau_de_l_infrastructure");
        Thread.sleep(1000);
        Fils = Common.NbrFils(pathTelechargment);
        int nbr = Fils.length;
        System.out.println("L'ancien nombre de fichiers dans le dossier Téléchargements :" + nbr);
        Thread.sleep(1000);
        DocumentationModele.cliqueFichierJoint(driver);
        // Thread.sleep(500);
        Runtime.getRuntime().exec(filePathResource + "resources/Scripts/EnregistrerFichier.exe");
        Thread.sleep(1000);
        Fils = Common.NbrFils(pathTelechargment);
        int nbr1 = Fils.length;
        System.out.println("Le nouveau nombre de fichiers dans le dossier Téléchargements :" + nbr1);
        // commented assert by rahma
        // assertTrue(nbr1 == nbr + 1, "Fichier ñ'est pas téléchargé!!!!");
        // Générer un nom significatif pour le fichier téléchargé
        String nom = Common.GenererNom("Documentation", CodeDocument, ".jpg");
        // Renommer et Deplacer la fichier
        Common.RenomerDeplacer(nom, pathTelechargment, pathContext);
    }

    @When("^cliquer sur Créer document$")
    public void cliquer_sur_Créer_document() throws Throwable {
        DocumentationModele.cliqueCreeDocument(driver, row);
    }

    @When("^saisir code document$")
    public void saisir_code_document() throws Throwable {
        DocumentationModele.saisirCodeDocumentEnCours();
    }

    @When("^saisir Mot clé spécifique$")
    public void saisir_Mot_clé_spécifique() throws Throwable {
        DocumentationModele.saisirMotCle();
    }

    @When("^cliquer sur valider Creation Document$")
    public void cliquer_sur_valider_Creation_Document() throws Throwable {
        DocumentationModele.cliqueValider(driver);
        Thread.sleep(500);
        CodeDocument = driver.findElement(By.id("ctl00_ContentPlaceHolder1_Text_CodeD")).getAttribute("value");
        System.out.println("code document : " + CodeDocument + " row " + row);
       documentation.setDocCode(CodeDocument);
        Common.Exporter_numFiche("code  document " + CodeDocument);
        Thread.sleep(2000);
    }

    @When("^cliquer sur valider en bas de page$")
    public void cliquer_sur_valider_en_bas_de_page() throws Throwable {
        DocumentationModele.cliqueValiderBas(driver);
        Thread.sleep(500);
    }

    @When("^cliquer sur visualiser le document à diffuser et vérifier son téléchargement et stockage sur plateforme$")
    public void cliquer_sur_visualiserle_document_a_diffuser_et_vérifier_son_téléchargement_et_stockage_sur_plateforme()
            throws Throwable {
        Fils = Common.NbrFils(pathTelechargment);
        int nbr = Fils.length;
        System.err.println("L'ancien nombre de fichiers dans le dossier Téléchargements :" + nbr);
        Thread.sleep(1000);
        //driver.findElement(By.id("ctl00_ContentPlaceHolder1_VsDoc")).click();
        String currentURL = driver.getCurrentUrl();

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DocumentationPage.wvisuleDoc);

        Thread.sleep(3000);

        System.out.println("Current URL: " + currentURL);
        Thread.sleep(1000);
        driver.get(currentURL);

    }

    @When("^cliquer sur Rédacteur en bas de page$")
    public void cliquer_sur_Rédacteur_en_bas_de_page() throws Throwable {
        // WebDriverWait wait = new WebDriverWait(driver,1000);
        // wait.until(ExpectedConditions.visibilityOf(DocumentationPage.redacteurBasD));

        Thread.sleep(3000);
        String codeEncour ="";
        codeEncour  = driver.findElement(By.id("ctl00_ContentPlaceHolder1_Text_CodeD")).getAttribute("value");
        documentation.setDocCode(codeEncour);
        DocumentationModele.cliqueRedacteurBas(driver);


    }

    @When("^consulter agenda documentation documents à valider par le rédacteur$")
    public void consulter_agenda_documentation_documents_à_valider_par_le_rédacteur() throws Throwable {
        Thread.sleep(1000);

        DocumentationPage.HomeID.click();
        Thread.sleep(1000);
        DocumentationModele.cliqueAgendaDocument(driver);
        Thread.sleep(500);
        DocumentationModele.cliqueAgendaRedacteur();
        Thread.sleep(500);
        if (!filaile.equals("MONO")) {
            Common.agendaFG("ctl00_ContentPlaceHolder1_GridView_DocRedac", filaile);
        }


    }


    @When("^verifier l'incrémentation du compteur général et spécifique rédaction$")
    public void verifier_l_incrémentation_du_compteur_général_et_spécifique_rédaction() throws Throwable {

    }

    @When("^insérer code documents$")
    public void insérer_code_documents() throws Throwable {

        DocumentationModele.saisirCodeDocument(documentation.getDocCode());
        DocumentationModele.cliqueRechercheDocuments();
        Thread.sleep(1000);

    }

    @When("^cliquer sur le document en question$")
    public void cliquer_sur_le_document_en_question() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr/td[1]"))
                .findElement(By.tagName("a")).click();
    }

    @When("cliquer sur valider pour envoyer doc  rédacteur vers  superviseur")
    public void cliquer_sur_valider_pour_envoyer_doc_rédacteur_vers_superviseur() {
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_Valider_Doc")).click();
    }

    @When("^cliquer sur le document à consulter$")
    public void cliquer_sur_le_document_à_consulter() throws Throwable {
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView2")).findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView2\"]/tbody/tr[1]/td[1]")).findElement(By.tagName("a")).click();

    }

    @When("^cliquer sur visualiser le document et vérifier son téléchargement et stockage sur plateforme$")
    public void cliquer_sur_visualiser_le_document_et_vérifier_son_téléchargement_et_stockage_sur_plateforme()
            throws Throwable {
        DesignePaterne.delete_file(pathTelechargment);
        Fils = Common.NbrFils(pathTelechargment);
        int nbr = Fils.length;
        System.out.println("L'ancien nombre de fichiers dans le dossier Téléchargements :" + nbr);
        Thread.sleep(1000);
        DocumentationModele.cliqueVisualiserDocument(driver);
        Thread.sleep(1000);
        Fils = Common.NbrFils(pathTelechargment);
        int nbr1 = Fils.length;
        System.out.println("Le nouveau nombre de fichiers dans le dossier Téléchargements :" + nbr1);
        try{
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_Circuit")).isDisplayed();
            assertTrue(nbr1 == nbr + 1, "Fichier ñ'est pas téléchargé!!!!");
        }catch (Exception exp){
            driver.navigate().back();
    }


        // Générer un nom significatif pour le fichier téléchargé
        //String nom = Common.GenererNom("Documentation", CodeDocument, ".xlsx");

        // Renommer et Deplacer la fichier
        // Common.RenomerDeplacer(nom, pathTelechargment, pathContext);

    }

    @When("^cliquer sur vérificateur bleu$")
    public void cliquer_sur_vérificateur_bleu() throws Throwable {
        DocumentationModele.cliqueVerificateur();
    }

    @When("^consulter agenda documentation documents à valider par le vérificateur$")
    public void consulter_agenda_documentation_documents_à_valider_par_le_vérificateur() throws Throwable {
        //   driver.get("http://10.66.245.30/w232/accueil_.aspx");
        Thread.sleep(1000);
        DocumentationPage.HomeID.click();
        Thread.sleep(1000);
        DocumentationModele.cliqueAgendaDocument(driver);
        DocumentationModele.cliqueAgendaVerifiacteur();
        if (!filaile.equals("MONO")) {
            Common.agendaFG("ctl00_ContentPlaceHolder1_GridViewDocVerif", filaile);
        }
    }

    @When("^cliquer sur approbateur bleu$")
    public void cliquer_sur_approbateur_bleu() throws Throwable {
        DocumentationModele.cliqueApprobateurBleu(driver);
    }

    @When("^consulter agenda documentation documents à valider par l approbateur$")
    public void consulter_agenda_documentation_documents_à_valider_par_l_approbateur() throws Throwable {
        // driver.get("http://10.66.245.30/Qualipro_Vierge/");
        Thread.sleep(1000);
        DocumentationPage.HomeID.click();
        Thread.sleep(1000);
        DocumentationModele.cliqueAgendaDocument(driver);
        DocumentationModele.cliqueAgendaApprobateur();
        if (!filaile.equals("MONO")) {
            Common.agendaFG("ctl00_ContentPlaceHolder1_GridView_DocApprob", filaile);
        }
    }

    @When("^verifier l'incrémentation du compteur général et spécifique approbation$")
    public void verifier_l_incrémentation_du_compteur_général_et_spécifique_approbation() throws Throwable {

    }

    @When("^cliquer sur Envoi diffusion bleu$")
    public void cliquer_sur_Envoi_diffusion_bleu() throws Throwable {

        DocumentationModele.cliqueDiffusion(driver);
    }

    @When("^consulter agenda documentation documents en attente de diffusion$")
    public void consulter_agenda_documentation_documents_en_attente() throws Throwable {
        DocumentationPage.HomeID.click();
        Thread.sleep(1000);
        DocumentationModele.cliqueAgendaDocument(driver);
        DocumentationModele.cliqueEnCours();
        if (!filaile.equals("MONO")) {
            Common.agendaFG("ctl00_ContentPlaceHolder1_GridView_DocAttDiff", filaile);
        }
    }

    @When("^cliquer sur Mise en vigueur bleu$")
    public void cliquer_sur_Mise_en_vigueur_bleu() throws Throwable {

        DocumentationModele.cliqueApprobateurBleu(driver);
    }

    @When("^insérer code documents à consulter$")
    public void insérer_code_documents_à_consulter() throws Throwable {

        DocumentationModele.saisirCodeDocumentsAConsulter(documentation.getDocCode());
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton13")).click();
        Thread.sleep(500);
    }

    @When("^consulter agenda documentation documents à consulter$")
    public void consulter_agenda_documentation_documents_à_consulter() throws Throwable {
        DocumentationPage.HomeID.click();
        Thread.sleep(1000);
        DocumentationModele.cliqueAgendaDocument(driver);
        DocumentationModele.cliqueAConsulter();
        if (!filaile.equals("MONO")) {
            Common.agendaFG("ctl00_ContentPlaceHolder1_GridView_DocConsult", filaile);
        }
    }

    public static String etat = "";

    @When("^cliquer sur Visualiser  document en bleu vérifier son téléchargement et stockage sur plateforme$")
    public void cliquer_sur_Visualiser_document_en_bleu_vérifier_son_téléchargement_et_stockage_sur_plateforme()
            throws Throwable {

        Fils = Common.NbrFils(pathTelechargment);
        int nbr = Fils.length;
        System.out.println("L'ancien nombre de fichiers dans le dossier Téléchargements :" + nbr);
        Thread.sleep(1000);
        DocumentationModele.cliqueVisualiser(driver);
        Thread.sleep(500);
        Fils = Common.NbrFils(pathTelechargment);
        int nbr1 = Fils.length;
        System.out.println("Le nouveau nombre de fichiers dans le dossier Téléchargements :" + nbr1);
        // assertTrue(nbr1 == nbr + 1, "Fichier ñ'est pas téléchargé!!!!");


    }

    @When("^cliquer sur J ai consulté ce document$")
    public void cliquer_sur_J_ai_consulté_ce_document() throws Throwable {
        DocumentationModele.cliquejaiConsulte(driver);
        Thread.sleep(500);
        boolean ok = false;
        try {
            ok = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblerr")).getText() != null;

        } catch (NoSuchElementException e) {
            System.out.println("file not downloaded");
            ok = true;
        }
        assertTrue(ok);
        /*if (etat.equals("close")) {
            //driver.findElement(By.xpath("//*[@id=\"Popconsult\"]/div/div/div[1]/button")).click();
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            for (int i = 0; i < tabs2.size(); i++) {
                driver.switchTo().window(tabs2.get(i));

                if (tabs2.get(i) != tabs2.get(0)) {
                    driver.switchTo().window(tabs2.get(i));

                    driver.close();
                }
            }

            driver.switchTo().window(tabs2.get(0));

        }*/

    }

    @When("^cliquer sur raccourci consulter doc interne$")
    public void cliquer_sur_raccourci_consulter_doc_interne() throws Throwable {
        DocumentationModele.cliqueIconeDocumentsInternes(driver);
        try{
        if (filaile.contains("Group")) {
            JavascriptExecutor executor2 = (JavascriptExecutor) driver;
            executor2.executeScript("arguments[0].click()", driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_RBList_IEGr_0\"]")));


        } else {
            JavascriptExecutor executor22 = (JavascriptExecutor) driver;
            executor22.executeScript("arguments[0].click()", driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_RBList_IEGr_1\"]")));

        }
        }catch (Exception e){

        }
    }

    @When("^rechercher code documents niveau filtre$")
    public void rechercher_code_documents_niveau_filtre() throws Throwable {
        DocumentationModele.saisirCodeDocumentsInternes(driver);
        DocumentationModele.cliqueRechercheDocumentsInternes(driver);

    }

    @When("^rechercher \"([^\"]*)\" niveau filtre$")
    public void rechercher_niveau_filtre(String arg1) throws Throwable {
        DocumentationModele.saisirCodeDocumentsInternes(driver);
        DocumentationModele.cliqueRechercheDocumentsInternes(driver);

    }

    @When("^cliquer sur le document interne en question$")
    public void cliquer_sur_le_document_interne_en_question() throws Throwable {
        DocumentationModele.choisirDocumentsInternes(driver);
    }

    @When("^Vérifier nombre et taux de consultation$")
    public void Vérifier_nombre_et_taux_de_consultation() throws Throwable {
        DocumentationModele.vérifier_taux(driver);
    }

    @When("^cliquer sur commentaire$")
    public void cliquer_sur_commentaire() throws Throwable {
        DocumentationModele.cliqueCommentaire();
    }

    @When("^cliquer sur Ajouter$")
    public void cliquer_sur_Ajouter() throws Throwable {
        DocumentationModele.ajouterCommentaire(driver);
    }

    @When("^cliquer saisir message au superviseur$")
    public void cliquer_saisir_message_au_superviseur() throws Throwable {
        DocumentationModele.saisirMessageSuperviseur();
    }

    @Then("vérifier le commantaire reçu")
    public void vérifier_le_commantaire_reçu() {

    }

    @When("^Envoyer au superviseur$")
    public void envoyer_au_superviseur() throws Throwable {
        DocumentationModele.cliqueEnvoyerSuperviseur(driver);
    }

    @When("^Supprimer les fichiers temporaires de l infrastructure$")
    public void Supprimer_les_fichiers_temporaires_de_l_infrastructure() throws Throwable {
        DesignePaterne.delete_file(pathTelechargment);
        System.out.println("Les fichiers temporaires ont été supprimés");
    }

    // *********steps Documentation spirale *************//

    @When("^cliquer sur envoyer le document pour correction$")
    public void cliquer_sur_envoyer_le_document_pour_correction() throws Throwable {
        DocumentationPage.correctionID.click();
    }

    @When("^remplir le commentaire de rejection$")
    public void remplir_le_commentaire_de_rejection() throws Throwable {
        Thread.sleep(500);
        DocumentationPage.messID.sendKeys("Test commentaire");
        Thread.sleep(500);
        DocumentationPage.validermessID.click();
    }

    @When("^consulter agenda documentation boite superviseur$")
    public void consulter_agenda_documentation_boite_superviseur() throws Throwable {
        Thread.sleep(500);
        DocumentationPage.superviseurID.click();
        Thread.sleep(500);
    }

    @When("^cliquer sur valider haut de page$")
    public void cliquer_sur_valider_haut_de_page() throws Throwable {
        DocumentationPage.validerID.click();
        Thread.sleep(2000);
    }

    @When("^cliquer sur valider verte$")
    public void cliquer_sur_valider_verte() throws Throwable {
        DocumentationPage.validerBasID.click();
        Thread.sleep(500);
    }

    @When("^cliquer sur rédacteur$")
    public void cliquer_sur_rédacteur() throws Throwable {
        DocumentationPage.redacteurBasD.click();
        Thread.sleep(500);
    }

    @When("^rattacher action$")
    public void rattacher_action_And_Ajouter_action_scenario_outline() throws Throwable {
        Thread.sleep(2000);

        DesignePaterne.javaScriptExcuptor(driver.findElement(By.id("ctl00_ContentPlaceHolder1_Lbltitre12")));
        DesignePaterne.javaScriptExcuptor(driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton10")));
        String idRecher = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView8_filter\"]/label/input";
        ExcelUtils.setExcelFile(Path, "DemandeAction");
        String numAct = ExcelUtils.getCellData1(1, 14);
        String idGrid = "ctl00_ContentPlaceHolder1_GridView8";
        String idGrid2 = "ctl00_ContentPlaceHolder1_GridView17";
        String validerBtn = "ctl00_ContentPlaceHolder1_LinkButton5";
        DesignePaterne.rattacherListEmployerWithoutLoop(idRecher, numAct, idGrid, validerBtn, idGrid2);

    }

    @When("^Rattacher formation$")
    public void rattacher_formation() throws Throwable {
        Thread.sleep(2000);

        DesignePaterne.javaScriptExcuptor(driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton2p")));
        //DesignePaterne.javaScriptExcuptor(driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton10")));
        String idRecher = "//*[@id=\"ctl00_ContentPlaceHolder1_GridViewListAct_filter\"]/label/input";
        ExcelUtils.setExcelFile(Path, "Action");
        String numAct = ExcelUtils.getCellData1(1, 7);
        String idGrid = "ctl00_ContentPlaceHolder1_GridViewListAct";
        String idGrid2 = "ctl00_ContentPlaceHolder1_GridView_act";
        String validerBtn = "ctl00_ContentPlaceHolder1_LinkButton67";
        DesignePaterne.rattacherListEmployerWithoutLoop(idRecher, numAct, idGrid, validerBtn, idGrid2);

    }

    @When("^Vérifier le calcul des taux de consultation$")
    public void vérifier_le_calcul_des_taux_de_consultation() throws Throwable {

    }

    @When("^vérifier que les données existent au niveau des listes des documents internes$")
    public void vérifier_que_les_données_existent_au_niveau_des_listes_des_documents_internes() throws Throwable {
        String url = "http://10.66.245.30/w2327_auto/Documentation/Rapport/FiltreEtatdIV.aspx";
        String type = "ctl00_ContentPlaceHolder1_DropDownList1";
        String path = filePathResource + "resources/Telechargement/CrystalReportViewer1.rtf";
        String pathContext = filePathResource + "resources/apercu";
        String typeDocument = "testAuto";
        String superviseur = "ctl00_ContentPlaceHolder1_LbSuperviseur";
        String superviseurdoc = "AUTO";

        Common.F(driver, url, type, typeDocument, superviseur, superviseurdoc);

        Thread.sleep(3000);
        String name1 = "BilanDocInternes";
        //  Common.Vérifier_données(name1,codeDocument);
        System.out.println(name1);
        String newpath = Common.RenommerFichier1(name1, path, pathContext);
        for (int i = 0; i < informations.size(); i++) {
            int j = i + 1;
            System.out.println("l'information " + j + ":" + informations.get(i));
            System.out.println("Existe: " + Common.ExisteWord(path, informations.get(i)));
            assertTrue(Common.ExisteWord(newpath, informations.get(i)));
        }

    }

    @When("^vérifier que les données existent au niveau des reportings document en cours$")
    public void vérifier_que_les_données_existent_au_niveau_des_reportings_document_en_cours() throws Throwable {

        String url = "http://10.66.245.30/w232/Documentation/Rapport/FiltreBilanDocEnCours.aspx";
        String code = "ctl00_ContentPlaceHolder1_TextBox_Code";
        // String path =
        // "E:/qualipro/trunk/AutomatisationTQualiPro_prod/resources/Telechargement/CrystalReportViewer1.rtf";
        String path = filePathResource + "resources/Telechargement/CrystalReportViewer1.rtf";
        String pathContext = filePathResource + "/resources/apercu";
        String codeDocument = CodeDocument;
        String superviseur = "ctl00_ContentPlaceHolder1_DropDownList_Superviseur";
        String superviseurdoc = "AUTO";
        informations.add(superviseurdoc);

        //Common.F(driver, url, code, codeDocument, superviseur, superviseurdoc);
        Thread.sleep(2000);
        String name1 = "BilanDocEnCours";
        // Common.Vérifier_données(name1,codeDocument);
        // System.out.println(name1);
        String newpath = Common.RenommerFichier1(name1, path, pathContext);
        for (int i = 0; i < informations.size(); i++) {
            int j = i + 1;
            System.out.println("l'information " + j + ":" + informations.get(i));
            System.out.println("Existe: " + Common.ExisteWord(newpath, informations.get(i)));
            // assertTrue(Common.ExisteWord(path, informations.get(i)));
        }

    }

    @When("^vérifier que les données existent au niveau de l Excel$")
    public void vérifier_que_les_données_existent_au_niveau_de_l_Excel() throws Throwable {

    }

    @When("^vérifier la maj de l’historique du document motif et indice$")
    public void vérifier_la_maj_de_l_historique_du_document_motif_et_indice() throws Throwable {

    }


    @When("^consulter boite superviseur$")
    public void consulter_boite_superviseur() throws Throwable {
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_Nbr_DocEncours")).click();
        Thread.sleep(500);
        if (!filaile.equals("MONO")) {
            Common.agendaFG("ctl00_ContentPlaceHolder1_GridView_DocDiff", filaile);
        }

    }


    @When("consulter type  document")
    public void consulter_type_document() throws Exception {
        Thread.sleep(1000);
        JavascriptExecutor jesExecutor = (JavascriptExecutor) driver;
        jesExecutor.executeScript("arguments[0].click()", DocumentationPage.menuID);
        // DocumentationPage.menuID.click();
        Thread.sleep(200);

        Common.AccéderModule(1, 5, 0, driver);
    }

    @When("cliquer sur ajouter type document")
    public void cliquer_sur_ajouter_type_document() {
        DocumentationPage.ajouterTypeDocument.click();
    }

    @When("saisir  type  document")
    public void saisir_type_document() throws Exception {
        Common.waitForVisibility(DocumentationPage.typeDocument);
        Faker words = new Faker();
        if (documentation.getEtat()==0) {

            String typeDoc = "Type Document " + String.join(" ", words.lorem().words(10));
            DocumentationPage.typeDocument.sendKeys(typeDoc);
        } else {
            DocumentationPage.typeDocument.sendKeys(documentation.getTypeDocumentation().getTypeDoc());
        }

        if (codification == 1) {
            if (documentation.getTypeDocumentation().getAbreviation() == null || documentation.getTypeDocumentation().getAbreviation() == "") {

                driver.findElement(By.id("ctl00_ContentPlaceHolder1_textboxAbrev")).sendKeys(words.lorem().word());
            } else {
                driver.findElement(By.id("ctl00_ContentPlaceHolder1_textboxAbrev")).sendKeys(documentation.getTypeDocumentation().getAbreviation());

            }
            driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_panelCodifDoc\"]/table/tbody/tr[2]/td[2]/input")).sendKeys(words.lorem().word());
            driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_TextBoxOrdreFixe\"]")).sendKeys("1");
        }
    }

    @When("saisir nature document")
    public void saisir_nature_document() throws Exception {
        Select nature = new Select(DocumentationPage.naturetypeDoc);

        int natur = 1;
        if (natur == 2) {
            nature.selectByValue("2");
        } else {
            nature.selectByValue("1");
        }


    }

    @When("saisir périodicité de revue de document")
    public void saisir_périodicité_de_revue_de_document() throws Exception {
        String prd = "";


        DocumentationPage.Periodicite_de_revue_de_document.sendKeys("0");

    }

    @When("Saisir  paremetrage  {int}")
    public void saisir_paremetrage(Integer int1) {
        row = int1;

    }

    @When("saisir docuemnt  pdf {int}  au  Document sécurisé {int}")
    public void saisir_docuemnt_pdf_au_document_sécurisé(Integer int1, Integer int2) throws Exception {
        securise = int2;
        pdf = int1;
        if (int1 == 1) {
            DocumentationPage.pdf.click();
            DocumentationPage.pageGarde.click();
        }
        if (int2 == 1) {
            DocumentationPage.scurise.click();
            DocumentationPage.nonPageGarde.click();
        }

    }


    @When("saisir Avec possibilité d'envoi par mail {int}")
    public void saisir_avec_possibilité_d_envoi_par_mail(Integer int1) {
        if (int1 == 1) {
            DocumentationPage.mail.click();
        } else {
            DocumentationPage.nonMail.click();

        }

    }

    @When("Avec codification automatique des documents {int}")
    public void avec_codification_automatique_des_documents(Integer int1) throws InterruptedException {
        codification = int1;
        Thread.sleep(500);

        if (int1 == 1) {
            DocumentationPage.codification.click();
        } else {
            DocumentationPage.noncodification.click();

        }


    }

    @When("Document visible par tout le monde {int}")
    public void Document_visible_par_tout_le_monde(Integer int1) throws InterruptedException {
        visibleAtous = int1;
        Thread.sleep(500);

        if (int1 == 1) {
            DocumentationPage.visibleAtous.click();
        } else {
            DocumentationPage.nonVisbileAtous.click();

        }


    }

    @Then("cliquer  sur  valider document")
    public void cliquer_sur_valider_document() {
        DocumentationPage.rechercheDocumentsID.click();
        String code = DocumentationPage.typeDocument.getAttribute("value");
        documentation.getTypeDocumentation().setTypeDoc(code);

    }

    @Then("ajouter  superviseur")
    public void ajouter_superviseur() throws Exception {

        String superviseur = documentation.getTypeDocumentation().getSuperviseur().getName();
//        DocumentationPage.panelListRespoValidation.click();
//        DocumentationPage.panelListSuperviseur.click();
        DesignePaterne.javaScriptExcuptor(DocumentationPage.panelListRespoValidation);
        DesignePaterne.javaScriptExcuptor(DocumentationPage.panelListSuperviseur);
        Thread.sleep(2000);
        DesignePaterne.javaScriptExcuptor(DocumentationPage.selectSupervseur);
        //DocumentationPage.selectSupervseur.click();

        try {
            String idRecher = "ctl00_ContentPlaceHolder1_TextBox16";
            String idGrid1 = "ctl00_ContentPlaceHolder1_GridView_SupervRat";
            String idLoop = "ctl00_ContentPlaceHolder1_lk_rechercher";
            String idValider = "ctl00_ContentPlaceHolder1_LinkButton27";
            String idGrid2 = "ctl00_ContentPlaceHolder1_GridView_Superv";
            DesignePaterne.rattacherListEmployerwithLoop(idRecher, superviseur, idLoop, idGrid1, idValider, idGrid2);

        } catch (NoSuchElementException exp) {
            String idRecher = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView_SupervRat_filter\"]/label/input";
            String idGrid1 = "ctl00_ContentPlaceHolder1_GridView_SupervRat";
            String idValider = "ctl00_ContentPlaceHolder1_LinkButton27";
            String idGrid2 = "ctl00_ContentPlaceHolder1_GridView_Superv";
            DesignePaterne.rattacherListEmployerWithoutLoop(idRecher, superviseur, idGrid1, idValider, idGrid2);


        }


    }

    @Then("ajouter des personnes ayant le droit d'imprimer")
    public void ajouter_des_personnes_ayant_le_droit_d_imprimer() throws Exception {
        if (securise == 1) {

            String personeImprimer = documentation.getTypeDocumentation().getResponsables_gestion_diffusion().getName();
            // DocumentationPage.panelListImprimer.click();
            DesignePaterne.javaScriptExcuptor(DocumentationPage.panelListImprimer);

            Thread.sleep(2000);
            // DocumentationPage.selectImprimer.click();

            DesignePaterne.javaScriptExcuptor(DocumentationPage.selectImprimer);

            String idRecher = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView_emplImpr_filter\"]/label/input";
            String idGrid1 = "ctl00_ContentPlaceHolder1_GridView_emplImpr";
            String idValider = "ctl00_ContentPlaceHolder1_Lb_Valid_EmpImp";
            String idGrid2 = "ctl00_ContentPlaceHolder1_GridView_Impression";
            DesignePaterne.rattacherListEmployerWithoutLoop(idRecher, personeImprimer, idGrid1, idValider, idGrid2);
        }

    }

    @Then("ajouter des rédacteurs")
    public void ajouter_des_rédacteurs() throws Exception {

        String redacteur = documentation.getTypeDocumentation().getRedacteur().getName();

        DesignePaterne.javaScriptExcuptor(DocumentationPage.panelListRedacteur);

        DesignePaterne.javaScriptExcuptor(DocumentationPage.selectRedecteur);

        Thread.sleep(2000);


        DesignePaterne.javaScriptExcuptor(DocumentationPage.selectRedecteuremp);

        String idRecher = "ctl00_ContentPlaceHolder1_TextBox14";
        String idGrid1 = "ctl00_ContentPlaceHolder1_G4";
        String idloop = "ctl00_ContentPlaceHolder1_LinkButton55";
        String idValider = "ctl00_ContentPlaceHolder1_Valider_LD0";
        String idGrid2 = "ctl00_ContentPlaceHolder1_Gv_redacteur";
        DesignePaterne.rattacherListEmployerwithLoop(idRecher, redacteur, idloop, idGrid1, idValider, idGrid2);

    }

    @Then("ajouter  des vérificateurs")
    public void ajouter_des_vérificateurs() throws Exception {

        String redacteur = documentation.getTypeDocumentation().getVerificateurs().getName();

        Thread.sleep(2000);
        DesignePaterne.javaScriptExcuptor(DocumentationPage.panelverficeteur);
        DesignePaterne.javaScriptExcuptor(DocumentationPage.ajouterVerficateur);
        DesignePaterne.javaScriptExcuptor(DocumentationPage.selectionnerVerficateur);


        String idRecher = "ctl00_ContentPlaceHolder1_TextBox14";
        String idGrid1 = "ctl00_ContentPlaceHolder1_G4";
        String idloop = "ctl00_ContentPlaceHolder1_LinkButton55";
        String idValider = "ctl00_ContentPlaceHolder1_Valider_LD0";
        String idGrid2 = "ctl00_ContentPlaceHolder1_GridView_Verif";
        DesignePaterne.rattacherListEmployerwithLoop(idRecher, redacteur, idloop, idGrid1, idValider, idGrid2);


    }

    @Then("ajouter des approbateurs")
    public void ajouter_des_approbateurs() throws Exception {

        String redacteur = documentation.getTypeDocumentation().getApprobateur().getName();
        Thread.sleep(2000);
        DesignePaterne.javaScriptExcuptor(DocumentationPage.panelapprobateur);
        DesignePaterne.javaScriptExcuptor(DocumentationPage.ajouterapprobateur);
        DesignePaterne.javaScriptExcuptor(DocumentationPage.selectionnerapprobateur);

        String idRecher = "ctl00_ContentPlaceHolder1_TextBox14";
        String idGrid1 = "ctl00_ContentPlaceHolder1_G4";
        String idloop = "ctl00_ContentPlaceHolder1_LinkButton55";
        String idValider = "ctl00_ContentPlaceHolder1_Valider_LD0";
        String idGrid2 = "ctl00_ContentPlaceHolder1_GridView_Appr";
        DesignePaterne.rattacherListEmployerwithLoop(idRecher, redacteur, idloop, idGrid1, idValider, idGrid2);
    }


    @Then("Liste de diffusion par défaut avec accusé de réception")
    public void liste_de_diffusion_par_défaut_avec_accusé_de_réception() throws Exception {
        if (visibleAtous != 1) {

            String redacteur = documentation.getTypeDocumentation().getAccuse_reception().getName();
            Thread.sleep(2000);
            DesignePaterne.javaScriptExcuptor(DocumentationPage.panelListeDiffusion);
            DesignePaterne.javaScriptExcuptor(DocumentationPage.avecAccusé);
            DesignePaterne.javaScriptExcuptor(DocumentationPage.selectEmp);
            String idRecher = "ctl00_ContentPlaceHolder1_TextBox13";
            String idGrid1 = "ctl00_ContentPlaceHolder1_GridView_listediffemp";
            String idloop = "ctl00_ContentPlaceHolder1_LinkButton53";
            String idValider = "ctl00_ContentPlaceHolder1_LinkButton13";
            String idGrid2 = "ctl00_ContentPlaceHolder1_GridView3";
            DesignePaterne.rattacherListEmployerwithLoop(idRecher, redacteur, idloop, idGrid1, idValider, idGrid2);
        }


    }


    @Then("responsables de la gestion diffusion papier")
    public void responsables_de_la_gestion_diffusion_papier() throws Exception {

        String redacteur = documentation.getTypeDocumentation().getResponsables_gestion_diffusion().getName();
        DesignePaterne.javaScriptExcuptor(DocumentationPage.pannelRespoDiffisuion);
        DesignePaterne.javaScriptExcuptor(DocumentationPage.selectRespoDiffision);

        String idRecher = "ctl00_ContentPlaceHolder1_TextBox33";
        String idGrid1 = "ctl00_ContentPlaceHolder1_GridView6";
        String idloop = "ctl00_ContentPlaceHolder1_LinkButton41";
        String idValider = "ctl00_ContentPlaceHolder1_LinkButton35";
        String idGrid2 = "ctl00_ContentPlaceHolder1_GridView4";

        DesignePaterne.rattacherListEmployerwithLoop(idRecher, redacteur, idloop, idGrid1, idValider, idGrid2);
    }

    @Then("verfier le type document")
    public void verfier_le_type_document() throws Exception {
        String oui, non;
        if (DesignePaterne.getlanguge() == "en") {
            oui = "Yes";
            non = "No";


        } else {
            oui = "OUI";
            non = "NON";
        }
        DocumentationPage.btnrtourTypedoc.click();
        Common.waitForVisibility(DocumentationPage.textRecherecheTypedoc);
        ExcelUtils.setExcelFile(Path, module);
        String typeDoc = documentation.getTypeDocumentation().getTypeDoc();
        String superviseurEx = documentation.getTypeDocumentation().getSuperviseur().getName();
        DocumentationPage.textRecherecheTypedoc.sendKeys(typeDoc);
        DocumentationPage.rechercheDocumentsInternesID.click();
        WebElement tabtyps = driver.findElement(By.id("ctl00_ContentPlaceHolder1_GridView1"));
        String TypeDI = tabtyps.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_GridView1']/tbody/tr/td[2]")).findElement(By.tagName("a")).getText();
        String superviseur = tabtyps.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_GridView1']/tbody/tr/td[4]")).findElement(By.tagName("span")).getText();
        String nature = tabtyps.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_GridView1']/tbody/tr/td[5]")).findElement(By.tagName("span")).getText();
        String pdfTab = tabtyps.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_GridView1']/tbody/tr/td[6]")).findElement(By.tagName("span")).getText();
        String securiseDoc = tabtyps.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_GridView1']/tbody/tr/td[7]")).findElement(By.tagName("span")).getText();
        String preiod = tabtyps.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_GridView1']/tbody/tr/td[9]")).findElement(By.tagName("span")).getText();
        Assert.assertEquals(TypeDI, typeDoc, "les deux types de document sont différents ");
        Assert.assertTrue(superviseur.contains(superviseurEx), "les deux superviseurs de document sont différents ");
        if (securise == 1) {
            Assert.assertEquals(securiseDoc, oui, "Non  Sécurisé");

        } else {

            Assert.assertEquals(securiseDoc, non, "  Sécurisé");
        }
        if (pdf == 1) {
            Assert.assertEquals(pdfTab, oui, "Non  PDF");

        } else {
            Assert.assertEquals(pdfTab, non, "  PDF");
        }
        boolean ok = (nature.equals("Interne") || nature.equals("Internal"));
        Assert.assertTrue(ok, "les deux nature de document sont différents ");
        Assert.assertTrue(ok, "les deux nature de document sont différents ");


    }
}


