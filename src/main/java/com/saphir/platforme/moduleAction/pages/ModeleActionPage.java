package com.saphir.platforme.moduleAction.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ModeleActionPage {
    final static String MENU_ID = "ctl00_menuModal";
    final static String HOME_ID = "ctl00_image2";
    final static String ACTIONS_XPATH = "//*[@id=\"cssmenu15\"]/div/div/ul/li[2]/a";
    final static String MODELE_XPATH = "//*[@id=\"cssmenu15\"]/div/div/ul/li[2]/ul/li[3]/a";
    final static String BOUTTON_AJOUTER_MODELE_ID = "ctl00_ContentPlaceHolder1_Ajouter";

    final static String OBJET_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_panelEnregHeading\"]/h4/a/span";
    final static String PLAN_ACTION_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_Span1\"]";
    final static String PLAN_VOL = "//*[@id=\"spandetail\"]";

    final static String SOURCE_ID = "ctl00_ContentPlaceHolder1_Listsource";
    final static String Datecreation_Act_ID = "ctl00_ContentPlaceHolder1_datcrea";

    final static String VLD_MODELE_ID = "ctl00_ContentPlaceHolder1_LinkButton17";

    final static String DESIGNATION_ID = "ctl00_ContentPlaceHolder1_desi";
    final static String TYPE_ID = "ctl00_ContentPlaceHolder1_Listtype";
    final static String DESCRIPTION_OBJET_ID = "ctl00_ContentPlaceHolder1_descrip";
    final static String CAUSES_POSSIBLES_ID = "ctl00_ContentPlaceHolder1_cause";
    final static String SITE_ID = "ctl00_ContentPlaceHolder1_Listsite";
    final static String PROCESSUS_ID = "ctl00_ContentPlaceHolder1_lBProcessus_";
    final static String DIRECTION_ID = "ctl00_ContentPlaceHolder1_lBDirection_";
    final static String TYPE_CAUSE_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_LinkButton32\"]/span";
    final static String RECH_TYPE_CAUSE_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView9_filter\"]/label/input";
    final static String CHX_TYPE_CAUSE_ID = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView9\"]/tbody/tr/td[1]";
    final static String VLD_TYPE_CAUSE_ID = "ctl00_ContentPlaceHolder1_Label200";
    final static String BOUTTON_VALIDER_ID = "ctl00_ContentPlaceHolder1_LinkButton9";


    final static String BOUTTON_AJOUTER_LISTE_DES_SOUS_ACTION_ID = "ctl00_ContentPlaceHolder1_Label65";
    final static String DESIGNATION_SOUS_ACTION_ID = "ctl00_ContentPlaceHolder1_TextBox5";
    final static String COUT_SOUS_ACTION_ID = "ctl00_ContentPlaceHolder1_TextBox10";
    final static String RESPONSABLE_REALISATION_SOUS_ACTION_ID = "ctl00_ContentPlaceHolder1_tb_respreal";
    final static String RESPONSABLE_SUIVI_SOUS_ACTION_ID = "ctl00_ContentPlaceHolder1_tb_respsv";
    final static String DELAI_TRAITEMENT_ID = "ctl00_ContentPlaceHolder1_Del";
    final static String DELAI_SUIVI_ID = "ctl00_ContentPlaceHolder1_delsiuvie";
    final static String BOUTTON_VALIDER_LISTE_DES_SOUS_ACTION_ID = "ctl00_ContentPlaceHolder1_LinkButton11_Valider";
    final static String GRID_LISTE_DES_SOUS_ACTION_ID = "ctl00_ContentPlaceHolder1_GridView1";
    final static String NUM_MODELE = "ctl00_ContentPlaceHolder1_nact";



    /* @FindBy */

    @FindBy(how = How.ID, using = MENU_ID)
    public static WebElement menuID;
    @FindBy(how = How.ID, using = HOME_ID)
    public static WebElement HomeID;
    @FindBy(how = How.ID, using = NUM_MODELE)
    public static WebElement NumModele;
    @FindBy(how = How.XPATH, using = ACTIONS_XPATH)
    public static WebElement ActionSXpath;
    @FindBy(how = How.XPATH, using = MODELE_XPATH)
    public static WebElement ModeleXpath;
    @FindBy(how = How.XPATH, using = OBJET_XPATH)
    public static WebElement objetXpath;
    @FindBy(how = How.XPATH, using = PLAN_ACTION_XPATH)
    public static WebElement planActionXpath;
    @FindBy(how = How.XPATH, using = PLAN_VOL)
    public static WebElement planVol;
    @FindBy(how = How.ID, using = BOUTTON_AJOUTER_MODELE_ID)
    public static WebElement btnAjouterModele;
    @FindBy(how = How.ID, using = SOURCE_ID)
    public static WebElement sourceId;
    @FindBy(how = How.ID, using = Datecreation_Act_ID)
    public static WebElement Datecreation_Act;

    @FindBy(how = How.ID, using = DESIGNATION_ID)
    public static WebElement designationId;
    @FindBy(how = How.ID, using = TYPE_ID)
    public static WebElement listeTypeId;
    @FindBy(how = How.ID, using = DESCRIPTION_OBJET_ID)
    public static WebElement descriptionObjetId;
    @FindBy(how = How.ID, using = CAUSES_POSSIBLES_ID)
    public static WebElement causesPossiblesId;
    @FindBy(how = How.XPATH, using = TYPE_CAUSE_XPATH)
    public static WebElement TypeCauseXpath;
    @FindBy(how = How.XPATH, using = RECH_TYPE_CAUSE_XPATH)
    public static WebElement RechTypeCauseXpath;
    @FindBy(how = How.XPATH, using = CHX_TYPE_CAUSE_ID)
    public static WebElement ChxTypeCauseId;
    @FindBy(how = How.ID, using = VLD_TYPE_CAUSE_ID)
    public static WebElement VldTypeCause;
    @FindBy(how = How.ID, using = SITE_ID)
    public static WebElement siteId;
    @FindBy(how = How.ID, using = PROCESSUS_ID)
    public static WebElement processusId;
    @FindBy(how = How.ID, using = DIRECTION_ID)
    public static WebElement directionId;
    @FindBy(how = How.XPATH, using = BOUTTON_VALIDER_ID)
    public static WebElement btnValiderActionId;
    @FindBy(how = How.ID, using = VLD_MODELE_ID)
    public static WebElement VldModeleID;
    @FindBy(how = How.ID, using = BOUTTON_AJOUTER_LISTE_DES_SOUS_ACTION_ID)
    public static WebElement btnAjouterSousActionModeleAction;
    @FindBy(how = How.ID, using = DESIGNATION_SOUS_ACTION_ID)
    public static WebElement designationSousAction;
    @FindBy(how = How.ID, using = COUT_SOUS_ACTION_ID)
    public static WebElement CoutSousAction;
    @FindBy(how = How.ID, using = RESPONSABLE_REALISATION_SOUS_ACTION_ID)
    public static WebElement responsableRealisationID;
    @FindBy(how = How.ID, using = RESPONSABLE_SUIVI_SOUS_ACTION_ID)
    public static WebElement responsableSuiviID;
    @FindBy(how = How.ID, using = BOUTTON_VALIDER_LISTE_DES_SOUS_ACTION_ID)
    public static WebElement btnValiderSousAction;
    @FindBy(how = How.ID, using = DELAI_TRAITEMENT_ID)
    public static WebElement delai_traitement;
    @FindBy(how = How.ID, using = DELAI_SUIVI_ID)
    public static WebElement delais_suivi;
    @FindBy(how = How.ID, using = GRID_LISTE_DES_SOUS_ACTION_ID)
    public static WebElement GridSousActionAction;

}
