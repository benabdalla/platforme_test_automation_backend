package com.saphir.platforme.moduleReunion.models;



import com.github.javafaker.Faker;
import com.saphir.platforme.moduleReunion.pages.ModuleReunionPage;
import com.saphir.platforme.shared.DesignePaterne;
import com.saphir.platforme.utils.Common;
import com.saphir.platforme.utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static com.saphir.platforme.controllors.ReunionController.reunion;

public class ModuleReunionModel {

	/* Public methods */
	private static String Path = "resources/testData/TestData.xlsx";

	 public static void consulter_Reunion(WebDriver driver,String filaile) throws Throwable {
		 Thread.sleep(2000);
		 JavascriptExecutor executor= (JavascriptExecutor) driver;
		 executor.executeScript("arguments[0].click()", ModuleReunionPage.menuID);
if(filaile.equals("Group")){
	Common.AccéderModule(5, 0, 0, driver);
	Common.AccéderModule(5,1,0, driver);

}else{
		 //ModuleReunionPage.menuID.click();
			Thread.sleep(500L);
			Common.AccéderModule(10, 0, 0, driver);
			Common.AccéderModule(10,1,0, driver);}
		}
	 public static void cliquerSelectionnerEmploye(WebDriver driver) {
		 JavascriptExecutor  executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click()", ModuleReunionPage.btlSelectionnerEmployeID);
	}


	public static void RechercheEmploye() {

		ModuleReunionPage.btRechercheEmplID.sendKeys("TESTAUTO2");
		//added by rahma
		ModuleReunionPage.btnRechercheEmpID.click();
		
	}

	public static void cliquerValiderSelection() {

		ModuleReunionPage.btValiderRecherche.click(); 
	}

	
	public static void cliquerReunions() {

		ModuleReunionPage.reunionsXpath.click();
	}

	public static void ajouterFicheReunion() {

		ModuleReunionPage.btnAjouterID.click();
		Common.Exporter_visibilité("Nouvelle Fiche Reunion");
		Common.Exporter_champ_A_masquer("Nouvelle Fiche Reunion");
	}

	public static void saisirLieu(String lieu) throws Throwable {
		if((lieu ==null)) {
			Faker faker =new Faker();
			lieu= DesignePaterne.wordsParagraphe(8);}

		ModuleReunionPage.lieuID.sendKeys(lieu);
		reunion.setLieu(lieu);
	}
	public static void ChoisirType(WebDriver driver,int arg1,String type) throws Throwable {

		Select typeReunion = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_List_Treunion")));
		typeReunion.selectByVisibleText(type);

	}

	public static void cliquerTypeReunion() {

		ModuleReunionPage.typeReunionID.click();
	}

	public static void choisirTypeReunion() {

		ModuleReunionPage.choixTypeReunionID.click();
	}

	public static void cliquerCalendrier() {

		ModuleReunionPage.calendrierID.click();
	}

	public static void choisirDate() 
	{

		ModuleReunionPage.choixDateID.click();
	}

	public static void saisirOrdreDeJour(String orderJour) {
		 if (orderJour==null){
			 Faker faker = new Faker();
			 orderJour = faker.lorem().paragraph();
		 }

		ModuleReunionPage.ordreDeJourID.sendKeys(orderJour);
		 reunion.setOrderJour(orderJour);
		 reunion.setOrderJour(orderJour);
	}
	
	public static void site(WebDriver driver, int arg1) throws Throwable {
		try {
			
			ModuleReunionPage.siteId.isDisplayed();
			Common.Exporter_visibilité("le site est visible");
			String text=driver.findElement(By.id("ctl00_ContentPlaceHolder1_lbsite2")).getText();
			if(text.indexOf('*')!=-1) 
			{
				Common.Exporter_visibilité("le site est obligatoire");
			}else 
			{
				Common.Exporter_visibilité("le site n'est pas obligatoire");
				
			}
			ExcelUtils.setExcelFile(Path, "Reunion");
			Select select = new Select(ModuleReunionPage.siteId);
			select.selectByVisibleText(ExcelUtils.getCellData(arg1, 2));
			}
			catch (NoSuchElementException e) {
				Common.Exporter_visibilité("le site est invisible");
			}
		
	}
	
	public static void processus(WebDriver driver, int arg1) throws Throwable {
	try {
			ModuleReunionPage.processusId.isDisplayed();
			Common.Exporter_visibilité("le processus est visible");
			String text=driver.findElement(By.id("ctl00_ContentPlaceHolder1_LblProcessus_")).getText();
			if(text.indexOf('*')!=-1) 
			{
				Common.Exporter_visibilité("le processus est obligatoire");
			}else 
			{
				Common.Exporter_visibilité("le processus n'est pas obligatoire");
				
			}
			ExcelUtils.setExcelFile(Path, "Reunion");
			Select select = new Select(ModuleReunionPage.processusId);
			select.selectByVisibleText(ExcelUtils.getCellData(arg1, 3));
			}
			catch (NoSuchElementException e) {
				Common.Exporter_visibilité("le processus est invisible");
			}
	}
	public static void activite(WebDriver driver, int arg1) throws Throwable {
		try {
			ModuleReunionPage.activiteId.isDisplayed();
			Common.Exporter_visibilité("l'activité est visible");
			String text=driver.findElement(By.id("ctl00_ContentPlaceHolder1_LblDomaine_")).getText();
			if(text.indexOf('*')!=-1) 
			{
				Common.Exporter_visibilité("l'activité est obligatoire");
			}else 
			{
				Common.Exporter_visibilité("l'activité n'est pas obligatoire");
				
			}
			ExcelUtils.setExcelFile(Path, "Reunion");
			Select select = new Select(ModuleReunionPage.activiteId);
			select.selectByVisibleText(ExcelUtils.getCellData(arg1, 4));
			}
			catch (NoSuchElementException e) {
				Common.Exporter_visibilité("l'activité est invisible");
			}
		
	}
	public static void direction(WebDriver driver, int arg1) throws Throwable {
		try {
			ModuleReunionPage.directionId.isDisplayed();
			Common.Exporter_visibilité("la direction est visible");
			String text=driver.findElement(By.id("ctl00_ContentPlaceHolder1_LabelDirPilot")).getText();
			if(text.indexOf('*')!=-1) 
			{
				Common.Exporter_visibilité("la direction est obligatoire");
			}else 
			{
				Common.Exporter_visibilité("la direction n'est pas obligatoire");
				
			}
			ExcelUtils.setExcelFile(Path, "Reunion");
			Select select = new Select(ModuleReunionPage.directionId);
			select.selectByVisibleText(ExcelUtils.getCellData(arg1, 5));
			}
			catch (NoSuchElementException e) {
				Common.Exporter_visibilité("la direction est invisible");
			}

	}
	
	public static void service(WebDriver driver, int arg1) throws Exception {
		try {
			ModuleReunionPage.service.isDisplayed();
			Common.Exporter_visibilité("le service est visible");
			String text=driver.findElement(By.id("ctl00_ContentPlaceHolder1_LblService_")).getText();
			if(text.indexOf('*')!=-1) 
			{
				Common.Exporter_visibilité("le service est obligatoire");
			}else 
			{
				Common.Exporter_visibilité("le service n'est pas obligatoire");
			}
			ExcelUtils.setExcelFile(Path, "Reunion");
			Select select = new Select(ModuleReunionPage.service);
			select.selectByVisibleText(ExcelUtils.getCellData(arg1, 6 ));
			}
			catch (NoSuchElementException e) {
				Common.Exporter_visibilité("le service est invisible");
			}
	}

	public static void cliquerValider() {

		ModuleReunionPage.btnValiderID.click();
	}

	public static void AjouterParticipant(WebDriver driver) throws Throwable {
		Thread.sleep(200);
		JavascriptExecutor js1 =(JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);",ModuleReunionPage.btnAjoutParticipantID);
		ModuleReunionPage.btnAjoutParticipantID.click();
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",ModuleReunionPage.btnAjoutParticipantID);

		Thread.sleep(200);

	}

	public static void saisirNomPrenom() throws Throwable {

		ModuleReunionPage.nomprenomXPATH.sendKeys("auto");
		Thread.sleep(200);
		ModuleReunionPage.BtnRechXPATH.click();
		Thread.sleep(200);

	}


	public static void selectionnerParticipant() {

		ModuleReunionPage.checkboxParticipantID.findElement(By.tagName("input")).click();
	}

	public static void cliquervalider() {

		ModuleReunionPage.btnvaliderID.click();
	}
	public static void RechercheEmployeInformer() {

		ModuleReunionPage.rechercheEmpInfInputID.sendKeys("AUTO");
		//added by rahma
		ModuleReunionPage.btnRechercheEmpInfID.click();
		
	}

}
