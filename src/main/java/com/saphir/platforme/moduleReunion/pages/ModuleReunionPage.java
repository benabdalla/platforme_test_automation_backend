package com.saphir.platforme.moduleReunion.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ModuleReunionPage {



	/* Locators */ // optimisation de maintenance par déclaration de variable

	final static String MENU_ID = "ctl00_menuModal";
	final static String HOME_ID = "ctl00_LinkButtonHome";
	final static String REUNION_XPATH = "//*[@id=\"cssmenu15\"]/div/div/ul/li[9]/a";
	final static String REUNIONS_XPATH = "//*[@id=\"cssmenu15\"]/div/div/ul/li[9]/ul/li[1]/a";
	final static String REALISATION_XPATH = "ctl00_ContentPlaceHolder1_LabelRealisation";
	final static String ENREGISTREMENT_XPATH = "circle";
	final static String BOUTTON_AJOUTER_ID = "ctl00_ContentPlaceHolder1_Ajouter";
	final static String DECLENCHEUR_ID = "ctl00_ContentPlaceHolder1_txtdecl";
	final static String LIEU_ID = "ctl00_ContentPlaceHolder1_Textlieu";
	final static String TYPE_REUNION_ID = "ctl00_ContentPlaceHolder1_List_Treunion";
	final static String CHOIX_TYPE_REUNION_ID = "//*[@id=\"ctl00_ContentPlaceHolder1_List_Treunion\"]/option[3]";
	final static String CALENDRIER_ID = "ctl00_ContentPlaceHolder1_Image1";
	final static String CHOIX_DATE_ID = "ctl00_ContentPlaceHolder1_CalendarExtender3_today";
	final static String ORDRE_DE_JOUR_ID = "ctl00_ContentPlaceHolder1_Text_Ordrejour";
	final static String BOUTTON_VALIDER_ID = "ctl00_ContentPlaceHolder1_Valider";
	final static String AJOUT_PARTICIPANT_ID = "ctl00_ContentPlaceHolder1_Ajout_Present";
	final static String NOM_PRENOM_XPATH = "ctl00_ContentPlaceHolder1_TextBox35";
	final static String BTN_RECH_XPATH = "ctl00_ContentPlaceHolder1_LinkButton52";
	final static String BOUTTON_RECHERCHER_ID = "ctl00_ContentPlaceHolder1_LinkButton30";
	final static String CHECKBOX_PARTICIPANT_ID = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView_emp\"]/tbody/tr[1]/td[1]";
	final static String BOUTTON_VALIDER1_ID = "ctl00_ContentPlaceHolder1_Valider_list_Present_R";
	final static String LISTES_DES_PARTICIPANTS_ID = "ctl00_ContentPlaceHolder1_GridView2";
	final static String COMPTEUR_AGENDA_REUNION_ID = "ctl00_label_lb_reun";
	final static String NUMERO_REUNION_ID = "ctl00_ContentPlaceHolder1_Text_FNreunion"; 
	final static String ETAT_REUNION_ID = "ctl00_ContentPlaceHolder1_List_FEtat"; 
	final static String TYPE1_REUNION_ID = "ctl00_ContentPlaceHolder1_List_FType"; 
	final static String ORDRE_REUNION_ID = "ctl00_ContentPlaceHolder1_TextBoxOrdreJour"; 
	final static String BOUTTON_RECHERCHER_REUNION_ID = "ctl00_ContentPlaceHolder1_Filtre_Rechercher";
	final static String LISTES_DES_REUNION_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr[1]/td[2]";
	final static String ETAT_REALISATION_ID = "ctl00_ContentPlaceHolder1_etat2";
	final static String BOUTTON_VALIDER_REALISATION_ID = "ctl00_ContentPlaceHolder1_LinkButton7";
	final static String CALENDRIER_REALISATION_ID = "ctl00_ContentPlaceHolder1_Image7";
	final static String DATE_REALISATION_ID = "ctl00_ContentPlaceHolder1_TextBox5";
	final static String CHOIX_DATE_REALISATION_ID = "ctl00_ContentPlaceHolder1_CalendarExtender4_today";
	final static String DUREE_REALISATION_ID = "ctl00_ContentPlaceHolder1_TextBox6";
	final static String RATTACHER_ACTION_ID = "ctl00_ContentPlaceHolder1_LinkButton2";
	final static String RECH_ACTION_ID = "ctl00_ContentPlaceHolder1_TextBox4";
	final static String VLD_RECH_ACTION_ID = "ctl00_ContentPlaceHolder1_LinkButton18";
	final static String CHOIX_ACTION_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView1P\"]/tbody/tr[1]/td[1]";
	final static String BOUTTON_VALIDER_DECISIONS_ID = "ctl00_ContentPlaceHolder1_Valider_Decision";
	final static String ZONE_COMMENTAIRES_ID = "ctl00_ContentPlaceHolder1_HTMLEditorExtenderText_ExtenderContentEditable";
	final static String BOUTTON_VALIDER_COMMENTAIRES_ID = "ctl00_ContentPlaceHolder1_LinkButton16";
	final static String TAUX_REALISATION_ACTION_ID = "ctl00_ContentPlaceHolder1_HF_taux_realisation";
	final static String PV_ACTION_ID = "ctl00_ContentPlaceHolder1_Aperçu";
	final static String EXPORT_PV_ACTION_ID = "IconImg_CrystalReportViewer1_toptoolbar_export";
	final static String COMBO_EXPORT_PV_ACTION_ID = "bobjid_1519054795344_dialog_combo";
	final static String CHOIX_COMBO_EXPORT_PV_ACTION_ID = "iconMenu_menu_bobjid_1519042889795_dialog_combo_text_bobjid_1519042889795_dialog_combo_it_14";
	final static String BOUTTON_EXPORTER_PV_ACTION_ID = "theBttnbobjid_1519042889795_dialog_submitBtn";
	final static String VALIDER_REPORTING_LISTE_REUNIONS = "ctl00_ContentPlaceHolder1_LinkButton11";
	final static String SELECTIONNER_EMPLOYE_ID = "ctl00_ContentPlaceHolder1_LinkButton_selectemp";
	//added by rahma
	final static String RECHERCHE_EMPL_ID = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView4_filter\"]/label/input";
	//added by rahma
	final static String BTN_RECHERCHE_EMPL_ID = "ctl00_ContentPlaceHolder1_Panel36";
	final static String VALIDER_RECHERCHE_EMPL_ID = "ctl00_ContentPlaceHolder1_LinkButton_ValiderEmp";
	final static String CHOIX_EMPL_ID = "ctl00_ContentPlaceHolder1_GridView4_ctl03_CheckBox1";
	final static String SITE_ID = "ctl00_ContentPlaceHolder1_Listsite";
	final static String PROCESSUS_ID = "ctl00_ContentPlaceHolder1_lBProcessus_";
	final static String ACTIVITE_ID = "ctl00_ContentPlaceHolder1_lBDomaine_";
	final static String DIRECTION_ID = "ctl00_ContentPlaceHolder1_ListBox_Direction";
	final static String service_ID ="ctl00_ContentPlaceHolder1_lBService_";
	//added by rahma
	final static String RECHERCHE_EMPL_INF_INPUT_ID="ctl00_ContentPlaceHolder1_TextBox16";
	final static String BTN_RECHERCHE_EMPL_INF_ID="ctl00_ContentPlaceHolder1_Panel24";

	/* @FindBy */

	@FindBy(how = How.ID, using = SELECTIONNER_EMPLOYE_ID)
	public static WebElement btlSelectionnerEmployeID;

	@FindBy(how = How.ID, using = RECHERCHE_EMPL_ID)
	public static WebElement btRechercheEmplID;
	
	@FindBy(how=How.ID, using = BTN_RECHERCHE_EMPL_ID)
	public static WebElement btnRechercheEmpID;

	@FindBy(how = How.ID, using = VALIDER_RECHERCHE_EMPL_ID)
	public static WebElement btValiderRecherche;

	@FindBy(how = How.ID, using = VALIDER_REPORTING_LISTE_REUNIONS)
	public static WebElement btlValiderReportingListeReunions;

	@FindBy(how = How.ID, using = MENU_ID)
	public static WebElement menuID;
	
	@FindBy(how = How.ID, using = HOME_ID)
	public static WebElement homeID;
	
	@FindBy(how = How.XPATH, using = REUNIONS_XPATH)
	public static WebElement reunionsXpath;

	@FindBy(how = How.ID, using = BOUTTON_AJOUTER_ID)
	public static WebElement btnAjouterID;

	@FindBy(how = How.ID, using = DECLENCHEUR_ID)
	public static WebElement declencheurID;

	@FindBy(how = How.ID, using = LIEU_ID)
	public static WebElement lieuID;

	@FindBy(how = How.ID, using = TYPE_REUNION_ID)
	public static WebElement typeReunionID;

	@FindBy(how = How.ID, using = CHOIX_TYPE_REUNION_ID)
	public static WebElement choixTypeReunionID;

	@FindBy(how = How.ID, using = CHOIX_DATE_ID)
	public static WebElement choixDateID;

	@FindBy(how = How.ID, using = CALENDRIER_ID)
	public static WebElement calendrierID;

	@FindBy(how = How.ID, using = ORDRE_DE_JOUR_ID)
	public static WebElement ordreDeJourID;

	@FindBy(how = How.ID, using = BOUTTON_VALIDER_ID)
	public static WebElement btnValiderID;

	@FindBy(how = How.ID, using = AJOUT_PARTICIPANT_ID)
	public static WebElement btnAjoutParticipantID;

	@FindBy(how = How.ID, using = NOM_PRENOM_XPATH)
	public static WebElement nomprenomXPATH;
	
	@FindBy(how = How.ID, using = BTN_RECH_XPATH)
	public static WebElement BtnRechXPATH;

	@FindBy(how = How.ID, using = BOUTTON_RECHERCHER_ID)
	public static WebElement btnRechercherID;

	@FindBy(how = How.XPATH, using = CHECKBOX_PARTICIPANT_ID)
	public static WebElement checkboxParticipantID;

	@FindBy(how = How.ID, using = BOUTTON_VALIDER1_ID)
	public static WebElement btnvaliderID;

	@FindBy(how = How.ID, using = COMPTEUR_AGENDA_REUNION_ID)
	public static WebElement cmptreunionID;
	
	@FindBy(how = How.ID, using = NUMERO_REUNION_ID)
	public static WebElement numeroReunion;
	
	@FindBy(how = How.ID, using = ETAT_REUNION_ID) 
	public static WebElement numeroEtat;
	
	@FindBy(how = How.ID, using = TYPE1_REUNION_ID) 
	public static WebElement numeroType1;
	
	@FindBy(how = How.ID, using = ORDRE_REUNION_ID) 
	public static WebElement numeroOrdre;
	
	@FindBy(how = How.ID, using = BOUTTON_RECHERCHER_REUNION_ID)
	public static WebElement btnrechercherFicheReunion;

	@FindBy(how = How.XPATH, using = LISTES_DES_REUNION_XPATH)
	public static WebElement listReunionID;

	@FindBy(how = How.ID, using = ETAT_REALISATION_ID)
	public static WebElement etatRealisationID;

	@FindBy(how = How.ID, using = BOUTTON_VALIDER_REALISATION_ID)
	public static WebElement btnvaliderRealisationID;

	@FindBy(how = How.ID, using = CALENDRIER_REALISATION_ID)
	public static WebElement calendrierRealisationID;
	
	@FindBy(how = How.ID, using = DATE_REALISATION_ID)
	public static WebElement dateRealisationID;
	
	@FindBy(how = How.ID, using = CHOIX_DATE_REALISATION_ID)
	public static WebElement choixDateRealisationID;

	@FindBy(how = How.ID, using = DUREE_REALISATION_ID)
	public static WebElement dureeRealisationID;

	@FindBy(how = How.ID, using = RATTACHER_ACTION_ID)
	public static WebElement rattacherActionID;
	
	@FindBy(how = How.ID, using = RECH_ACTION_ID)
	public static WebElement rechercherActionID;

	@FindBy(how = How.ID, using = VLD_RECH_ACTION_ID)
	public static WebElement VldrechercherActionID;
	
	@FindBy(how = How.XPATH, using = CHOIX_ACTION_XPATH)
	public static WebElement choixActionXPATH;

	@FindBy(how = How.ID, using = BOUTTON_VALIDER_DECISIONS_ID)
	public static WebElement btnValiderDecisionsID;

	@FindBy(how = How.ID, using = ZONE_COMMENTAIRES_ID)
	public static WebElement zoneCommentairesID;

	@FindBy(how = How.ID, using = BOUTTON_VALIDER_COMMENTAIRES_ID)
	public static WebElement btnValiderCommantairesID;

	@FindBy(how = How.ID, using = TAUX_REALISATION_ACTION_ID)
	public static WebElement tauxRealisationAction;

	@FindBy(how = How.ID, using = PV_ACTION_ID)
	public static WebElement pvActionID;

	@FindBy(how = How.ID, using = EXPORT_PV_ACTION_ID)
	public static WebElement exportPVActionID;

	@FindBy(how = How.ID, using = COMBO_EXPORT_PV_ACTION_ID)
	public static WebElement comboExportPVID;

	@FindBy(how = How.ID, using = CHOIX_COMBO_EXPORT_PV_ACTION_ID)
	public static WebElement choixComboExportPVID;

	@FindBy(how = How.ID, using = BOUTTON_EXPORTER_PV_ACTION_ID)
	public static WebElement btnExportPVID;
	@FindBy(how = How.XPATH, using = REUNION_XPATH)
	public static WebElement REUNION_Xpath;
	@FindBy(how = How.XPATH, using = REUNIONS_XPATH)
	public static WebElement REUNIONS_Xpath;
	@FindBy(how = How.ID, using = REALISATION_XPATH)
	public static WebElement realisation_Xpath;
	@FindBy(how = How.ID, using = ENREGISTREMENT_XPATH)
	public static WebElement enregistrement_Xpath;
	
	@FindBy(how = How.ID, using = SITE_ID)
	public static WebElement siteId;
	@FindBy(how = How.ID, using = PROCESSUS_ID)
	public static WebElement processusId;
	@FindBy(how = How.ID, using = ACTIVITE_ID)
	public static WebElement activiteId;
	@FindBy(how = How.ID, using = DIRECTION_ID)
	public static WebElement directionId;
	@FindBy(how = How.ID, using = service_ID)
	public static WebElement service;
	
	//added by rahma
	
	@FindBy(how = How.ID, using = RECHERCHE_EMPL_INF_INPUT_ID)
	public static WebElement rechercheEmpInfInputID;
	
	@FindBy(how = How.ID, using = BTN_RECHERCHE_EMPL_INF_ID)
	public static WebElement btnRechercheEmpInfID;
}
