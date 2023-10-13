package com.saphir.platforme.Documentation.models;


import com.github.javafaker.Faker;

import com.saphir.platforme.Documentation.pages.DocumentationPage;
import com.saphir.platforme.shared.DesignePaterne;
import com.saphir.platforme.utils.Common;
import com.saphir.platforme.utils.ExcelUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class DocumentationModele {
    private static int i;
    public static String dateEnvoi;
    static Date date;

    public  static String filePathResource="E:/qualipro/trunk/platforme_test_automation_backend/";

    private static String Path = "resources/testData/TestData.xlsx";

    public static void cliqueBoiteDeDialogue(WebDriver driver) throws Throwable {
        Thread.sleep(1000);
        JavascriptExecutor jesExecutor = (JavascriptExecutor) driver;
        jesExecutor.executeScript("arguments[0].click()", DocumentationPage.menuID);
        // DocumentationPage.menuID.click();
        Thread.sleep(200);
        Common.AccéderModule(1, 0, 0, driver);
        Common.AccéderModule(1, 2, 0, driver);
    }

    public static void cliqueRedacteurSuperviseur(WebDriver driver) throws InterruptedException {
        Thread.sleep(200);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", DocumentationPage.redacteurSuperviseurID);
        //  DocumentationPage.redacteurSuperviseurID.click();
    }

    public static void choixTypeDocument(int arg1,String typeDoc) throws Exception {
        i = arg1;


        System.out.println(" type  doc " + typeDoc);
        Thread.sleep(1000);
        Select select = new Select(DocumentationPage.typeDocumentID);
        Thread.sleep(1000);
        select.selectByVisibleText(typeDoc);
    }

    public static String saisirObjet(String objet) throws Exception {

        String object="";
        Thread.sleep(1000);
        if(objet==null || objet==""){
        Faker fack = new Faker();
            object = fack.lorem().paragraph();
            DocumentationPage.objetID.sendKeys(object);
        }else {
            object=objet;
        DocumentationPage.objetID.sendKeys(objet);

        }
        return  object;
    }

    public static void choixFichier(WebDriver driver,int type,String path) throws Exception {
        Thread.sleep(1000);
        // JavascriptExecutor executor = (JavascriptExecutor) driver;
        //executor.executeScript("arguments[0].click()", DocumentationPage.btnChoisirFichierID);

        if(type==0){
            DocumentationPage.btnChoisirFichierID.click();
        System.out.println("===>  PIECE  JOINTE");
        Common.delletfileCopy(filePathResource+"resources/pieces_jointes");
        Thread.sleep(3000);


        Runtime.getRuntime().exec(filePathResource+"resources/Scripts/joindreFichier.exe");


        Thread.sleep(3000);}
    else{
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_FichierSuper")).sendKeys(path);
    }

    }

    public static void choixFichierr(WebDriver driver) throws Exception {
        Thread.sleep(1000);
        //   JavascriptExecutor executor = (JavascriptExecutor) driver;
        //executor.executeScript("arguments[0].click()", DocumentationPage.btnChoisirFichierID);
        DocumentationPage.btnChoisirFichierID.click();
        System.out.println("===>  PIECE  JOINTE");

        Thread.sleep(1000);
        Runtime.getRuntime().exec(filePathResource+"resources/Scripts/joindreFichier2.exe");
        Thread.sleep(1000);

    }

    public static void saisirMessage() throws Exception {
        ExcelUtils.setExcelFile(Path, "Documentation");
        String msg = " message  AUTO " + LocalDateTime.now().toString();
        ExcelUtils.setCellData1(msg, i, 2, Path, "Documentation");
        DocumentationPage.messageID.sendKeys(msg);
    }

    public static void cliqueEnvoiSuperviseur() throws InterruptedException {
        Thread.sleep(1000);
        DocumentationPage.envoiSuperviseurID.click();


        date = new Date();
    }

    //added by rahma
    public static void cliqueBoiteEnvoi(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
try{
        WebElement BoiteEnvoi = driver.findElement(By.id("ctl00_ContentPlaceHolder1_Label1"));
        BoiteEnvoi.click();}catch (NoSuchElementException exp){
    System.out.println("agenda");
        }
        Thread.sleep(1000);
    }

    public static void VerifierAjoutDansBoiteEnvoi(WebDriver driver,String  objet) throws Throwable {

        ExcelUtils.setExcelFile(Path, "Documentation");

        DocumentationPage.RechBoiteEnvoiID.sendKeys(objet);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_LinkButton_RechercheRapide")).click();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        //wait.until(ExpectedConditions.visibilityOf(DocumentationPage.boiteEnvoiID));

        Actions action = new Actions(driver);
        action.moveToElement(DocumentationPage.boiteEnvoiID).perform();
        //wait.until(ExpectedConditions.visibilityOf(DocumentationPage.boiteEnvoiID.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_envoi\"]/tbody/tr[1]/td[4]"))));
        dateEnvoi = DocumentationPage.boiteEnvoiID.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_Rec\"]/tbody/tr[1]/td[4]")).getText();
        //Cookie cookie1 = driver.manage().getCookieNamed("lan")
        Assert.assertTrue(dateEnvoi.length() > 0);
    }

    public static void cliqueAgendaDocument(WebDriver driver) throws Throwable {
        Thread.sleep(4000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DocumentationPage.agendaDocumentID);
        Thread.sleep(1000);
    }

    public static void cliqueCompteurBoiteDialogue() {

        DocumentationPage.compteurBoiteDialogueID.click();
    }

    public static void cliqueConsulterMessage(WebDriver driver, int ligne) throws Throwable {
        ExcelUtils.setExcelFile(Path, "Documentation");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_TxtMotRechercher_rec")).sendKeys(ExcelUtils.getCellData(ligne, 3));
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_Rec\"]/tbody/tr/td[2]")).findElement(By.tagName("a")).click();
    }

    public static void cliqueConsulterMessage(WebDriver driver) throws Throwable {
        ExcelUtils.setExcelFile(Path, "Documentation");
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_TxtMotRechercher_rec")).sendKeys(ExcelUtils.getCellData(i, 2));
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView_Rec\"]/tbody/tr/td[2]")).findElement(By.tagName("a")).click();
    }


    public static String getValeurCompteur() {
        System.out.println(DocumentationPage.compteurDocumentID.getText());

        return DocumentationPage.compteurDocumentID.getText();


    }

    public static void cliqueDocumentBoiteDialogue() {

        DocumentationPage.documentBoiteDialogueID.click();
    }

    public static void cliqueFichierJoint(WebDriver driver) throws Throwable {
        //Actions action = new Actions(driver);
        //action.moveToElement(DocumentationPage.fichierID).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments [0] .scrollIntoView ();", DocumentationPage.fichierID);
        Thread.sleep(1000);
        //DocumentationPage.fichierID.click();
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments [0] .scrollIntoView ();", DocumentationPage.fichierID);
        Thread.sleep(1000);
    }

    public static void cliqueCreeDocument(WebDriver driver, int row) throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments [0] .scrollIntoView ();", DocumentationPage.fichierID);
        DocumentationPage.creeDocumentID.click();
//        try {
//            String msg = driver.findElement(By.id("ctl00_ContentPlaceHolder1_Label_erreurSuperviseurType")).getText();
//            Assert.assertEquals(msg, "Vous n'êtes plus le superviseur de ce type", "message supperviseur   n'est   pas  affiché");
//            ExcelUtils.setExcelFile(Path, "Documentation");
//            String superviseur = ExcelUtils.getCellData1(row, 5);
//            //verfier
//            assertEquals(driver.findElement(By.id("ctl00_ContentPlaceHolder1_TextBoxExped")).getText(), superviseur);
//
//            Common.changeCompte(superviseur);
//        } catch (NoSuchElementException exception) {
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    public static String getType() throws Throwable {
        ExcelUtils.setExcelFile(Path, "Documentation");
        return (ExcelUtils.getCellData(i, 0));

    }

    public static void saisirSite() throws InterruptedException {
        Thread.sleep(1000);

        Select select = new Select(DocumentationPage.siteID);
        select.selectByValue("17");
    }

    public static void saisirProcessus() throws InterruptedException {
        Thread.sleep(1000);

        Select select = new Select(DocumentationPage.processusID);
        select.selectByValue("8");
    }

    public static void saisirMotCle() throws InterruptedException {
        Thread.sleep(1000);
        DocumentationPage.motCleD.sendKeys("Test AUTO");
    }

    public static void cliqueValider(WebDriver driver) throws Throwable {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", DocumentationPage.validerID);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DocumentationPage.validerID);
        //DocumentationPage.validerID.click();
        Thread.sleep(500);
        String CodeDocument = DocumentationPage.codeDocumentsEncoursID.getAttribute("value");
        ExcelUtils.setExcelFile(Path, "Documentation");
        ExcelUtils.setCellData1(CodeDocument, i, 4, Path, "Documentation");
    }

    public static void cliqueValiderBas(WebDriver driver) throws Throwable {

        Thread.sleep(2000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DocumentationPage.validerBasID);
        //DocumentationPage.validerBasID.click();
        Thread.sleep(2000);

    }

    public static void cliqueRedacteurBas(WebDriver driver) throws InterruptedException {
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", DocumentationPage.redacteurBasD);
        // DocumentationPage.redacteurBasD.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DocumentationPage.redacteurBasD);
   /*
      Actions actions = new Actions(driver);
        actions.moveToElement(DocumentationPage.redacteurBasD);
        actions.perform();
        */

    }

    public static void cliqueAgendaRedacteur() {


        DocumentationPage.agendaRedacteurID.click();
    }

    public static void saisirCodeDocument(String codeDoc) throws Throwable {

        DocumentationPage.codeDocumentID.clear();
        Thread.sleep(1000);
        System.out.println("cod excel doc" +codeDoc);
        DocumentationPage.codeDocumentID.sendKeys(codeDoc);
        Thread.sleep(1000);
    }

    public static void saisirCodeDocumentEnCours() {

        DocumentationPage.codeDocumentsEncoursID.sendKeys("Doc_Test_" + DesignePaterne.wordsParagraphe(10));
    }

    public static void cliqueVisualiserDocument(WebDriver driver) throws InterruptedException, AWTException {

        DocumentationPage.visualiserDocumentID.click();


        // Wait for a brief moment to ensure the dialog is handled
        Thread.sleep(3000);


        //
       /* Point coordinates = driver.findElement(By.id("toolbar")).getLocation();
        Robot robot = new Robot();
        robot.mouseMove(coordinates.getX(),coordinates.getY());
        DocumentationPage.wDocPdf.findElement(By.xpath("//*[@id=\"icon\"]/iron-icon")).click();
        Thread.sleep(200);*/

        //  driver.navigate().back();

    }

    public static void cliqueVerificateur() {

        DocumentationPage.verificateurID.click();
    }

    public static void cliqueAgendaVerifiacteur() {

        DocumentationPage.agendaVerificteurID.click();
    }

    public static void cliqueApprobateurBleu(WebDriver driver) throws InterruptedException {
       /* final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 0);
        String Sdate = dateFormat.format(dt);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
      try{  jse.executeScript("arguments[1].value = arguments[0];", Sdate,driver.findElement(By.id(" ctl00_ContentPlaceHolder1_tb_date_applic")));
        Thread.sleep(1000L);}catch (NoSuchElementException )*/

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DocumentationPage.approbateurBleuID);

    }

    public static void cliqueAgendaApprobateur() {

        DocumentationPage.agendApprobateurID.click();
    }

    public static void cliqueDiffusion(WebDriver driver) throws InterruptedException {


        DocumentationPage.diffusionID.click();
    }

    public static void cliqueEnCours() throws InterruptedException {
        Thread.sleep(1000);
        DocumentationPage.enCoursId.click();
        Thread.sleep(1000);
    }

    public static void cliqueAConsulter() {

        DocumentationPage.aConsulterId.click();
    }

    public static void cliqueVisualiser(WebDriver driver) {


        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DocumentationPage.visualiserBleuID);
    }

    public static void cliquejaiConsulte(WebDriver driver) throws InterruptedException {

        Thread.sleep(2000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DocumentationPage.jaiConsulteID);
        //	DocumentationPage.jaiConsulteID.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

    }

    public static void cliqueIconeDocumentsInternes(WebDriver driver) {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DocumentationPage.iconeDocumentsInternesID);




    }

    public static void saisirCodeDocumentsInternes(WebDriver driver) throws Throwable {
        ExcelUtils.setExcelFile(Path, "Documentation");
        Thread.sleep(500);
        //	DocumentationPage.codeDocumentsInternesID.sendKeys(ExcelUtils.getCellData(i, 4));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[1].value = arguments[0];", ExcelUtils.getCellData(i, 4), DocumentationPage.codeDocumentsInternesID);

    }

    public static void saisirCodeDocumentsInternes2(String arg1) throws Throwable {
        Thread.sleep(500);
        DocumentationPage.codeDocumentsInternesID.sendKeys(arg1);
    }

    public static void cliqueRechercheDocumentsInternes(WebDriver driver) throws InterruptedException {

        Thread.sleep(1000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DocumentationPage.rechercheDocumentsInternesID);
    }

    public static void choisirDocumentsInternes(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        //   DocumentationPage.choixDocumentsInternesID.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr/td[2]")).findElement(By.tagName("a")).click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", DocumentationPage.choixDocumentsInternesID.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_GridView1_ctl02_LinkButton1 > font")));
    }//*[@id="ctl00_ContentPlaceHolder1_GridView1"]/tbody/tr[1]/td[2]


    public static void vérifier_taux() {
        String taux = DocumentationPage.TauxConsID.getText();
        String nbre = DocumentationPage.NbreConsID.getText();
    }

    public static void vérifier_taux(WebDriver driver) throws Exception {
        //WebElement elm=driver.findElement(By.cssSelector("#gg2 > svg > text:nth-child(6) > tspan"));
        //WebElement elm2=driver.findElement(By.cssSelector("#gg2 > svg > text:nth-child(6) > tspan"));

        WebElement elm = driver.findElement(By.xpath("//*[starts-with(@id,'gg2')]/*[local-name() = 'svg']//*[local-name() = 'text'][2]"));

        Thread.sleep(1000);
        //System.out.println("element taux:::"+elm2.hashCode());
        //System.out.println("element taux:::"+elm2.getLocation());

        Thread.sleep(1000);

        //WebElement elm1=driver.findElement(By.cssSelector("#gg1 > svg > text:nth-child(6) > tspan"));
        //WebElement elm3=driver.findElement(By.cssSelector("#gg1 > svg > text:nth-child(6) > tspan"));
        WebElement elm2 = driver.findElement(By.xpath("//*[starts-with(@id,'gg2')]/*[local-name() = 'svg']//*[local-name() = 'text'][2]"));
        WebElement elm1 = driver.findElement(By.xpath("//*[starts-with(@id,'gg1')]/*[local-name() = 'svg']//*[local-name() = 'text'][2]"));
        WebElement elm3 = driver.findElement(By.xpath("//*[starts-with(@id,'gg1')]/*[local-name() = 'svg']//*[local-name() = 'text'][2]"));
        String taux = elm2.getText();

        // System.out.println("element nbr:::"+elm3.hashCode());
        //System.out.println("element nbr:::"+elm3.getLocation());
        String nbre = elm3.getText();
        System.out.println("element nombre:::" + nbre);

        List<WebElement> rows = DocumentationPage.GridAccID.findElements(By.xpath("//*[@id=\"ctl00_ContentPlaceHolder1_GridView3\"]/thead/tr"));
        int nbre_per_accuse = rows.size();
        if (nbre.contains("1")) {
            System.out.println("nombre de consultation incrémenté");
        } else {
            System.out.println("nombre de consultation non modifié");
        }
        int taux_cal = (Integer.parseInt(nbre) / nbre_per_accuse) * 100;
        if (taux.contains(String.valueOf(taux_cal))) {
            System.out.println("taux de consultation correcte");
        } else {
            System.out.println("taux de consultation incorrecte");
        }
    }

    public static void cliqueCommentaire() throws InterruptedException {
        Thread.sleep(1000);
        DocumentationPage.commentaireID.click();
    }

    public static void ajouterCommentaire(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor jes = (JavascriptExecutor) driver;
        jes.executeScript("arguments[0].click()", DocumentationPage.ajouiterCommentaireID);
        //  DocumentationPage.ajouiterCommentaireID.click();
    }

    public static void saisirMessageSuperviseur() throws InterruptedException {
        Thread.sleep(1000);
        DocumentationPage.messageSuperviseurID.sendKeys("Test auto" + DesignePaterne.wordsParagraphe(8));
    }

    public static void cliqueEnvoyerSuperviseur(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        //DocumentationPage.envoyerSuperviseurID.click();
        JavascriptExecutor jes = (JavascriptExecutor) driver;
        jes.executeScript("arguments[0].click()", DocumentationPage.envoyerSuperviseurID);
    }

    public static void cliqueRechercheDocuments() throws InterruptedException {
        Thread.sleep(1000);
        DocumentationPage.rechercheDocumentsID.click();
        Thread.sleep(1000);
    }

    public static void saisirCodeDocumentsAConsulter(String  code) throws Throwable {

        System.out.println(" code   doc  : " + code);
        DocumentationPage.codeDocumentsAConsulterID.sendKeys(code);


    }
}