package com.saphir.platforme.moduleReunion.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class typeréunionpage  {

	


	
	final static String MENU_ID = "ctl00_menuModal";
	final static String M_Réunion_XPATH="//*[@id=\"cssmenu15\"]/div/div/ul/li[9]/a";
	final static String M_Typ_Réunion_XPATH="//*[@id=\"cssmenu15\"]/div/div/ul/li[9]/ul/li[2]/a";
	final static String Ajouter_ID ="ctl00_ContentPlaceHolder1_Ajouter";
	final static String type_Réuinion_ID="ctl00_ContentPlaceHolder1_Text_Type";
	final static String Périodicité_ID="ctl00_ContentPlaceHolder1_TextBox_Periodicite";
	final static String Source_ID="ctl00_ContentPlaceHolder1_Listsource";
	final static String valider_ID="ctl00_ContentPlaceHolder1_Valider";
	final static String retour_ID="ctl00_ContentPlaceHolder1_Annuler_Ajout";
	final static String filtre_typ_réunion_ID="ctl00_ContentPlaceHolder1_Text_FTypeR";
	final static String rechercher_ID="ctl00_ContentPlaceHolder1_Rechercher";
	final static String Gridview_ID="ctl00_ContentPlaceHolder1_GridView1";
	final static String Gridview_element_ID="ctl00_ContentPlaceHolder1_GridView1_ctl02_Label2";

	
	
	@FindBy(how = How.ID, using = MENU_ID)
	public static WebElement MenuID;
	@FindBy(how = How.XPATH, using = M_Réunion_XPATH)
	public static WebElement MRéunion;
	@FindBy(how = How.XPATH, using = M_Typ_Réunion_XPATH)
	public static WebElement MTypeRéunion;
	@FindBy(how = How.ID, using = type_Réuinion_ID)
	public static WebElement TypeRéunion;
	@FindBy(how = How.ID, using = Périodicité_ID)
	public static WebElement Périodicité;
	@FindBy(how = How.ID, using = Source_ID)
	public static WebElement Source;
	@FindBy(how = How.ID, using =valider_ID)
	public static WebElement valider;
	@FindBy(how = How.ID, using =Ajouter_ID)
	public static WebElement ajouter;
	@FindBy(how = How.ID, using =retour_ID)
	public static WebElement retourID ;
	@FindBy(how = How.ID, using =filtre_typ_réunion_ID)
	public static WebElement filtre;
	@FindBy(how = How.ID, using =rechercher_ID)
	public static WebElement rechercher;
	@FindBy(how = How.ID, using = Gridview_ID)
	public static WebElement gridview;
	@FindBy(how = How.ID, using = Gridview_element_ID)
	public static WebElement gridviewElement;

}
