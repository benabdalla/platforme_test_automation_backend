package com.saphir.platforme.moduleAction.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ActSimplPage {

    /* Locators */ // optimisation de maintenance par déclaration de variable

    final static String MENU_ID = "ctl00_menuModal";
    final static String ModuleActions_XPATH = "//*[@id=\"cssmenu15\"]/div/div/ul/li[2]/a";
    final static String Filtre_Actions_XPATH = "//*[@id=\"cssmenu15\"]/div/div/ul/li[2]/ul/li[1]/a";
    final static String Bouton_Ajouter_ID = "ctl00_ContentPlaceHolder1_Label12";
    final static String Ajouter_Act_Simplifiee_ID = "ctl00_ContentPlaceHolder1_AjactSimpl";
    final static String Source_Act_Simplifiee_ID = "ctl00_ContentPlaceHolder1_Listsource";
    final static String Type_Act_Simplifiee_ID = "ctl00_ContentPlaceHolder1_Listtype";
    final static String Datecreation_Act_Simplifiee_ID = "ctl00_ContentPlaceHolder1_Img8";
    final static String agenda_creation_ID = "ctl00_ContentPlaceHolder1_CalendarExtender1_today";
    final static String service_ActSimplifiee_ID = "ctl00_ContentPlaceHolder1_lBService_";
    final static String Resp_cloture_ID = "ctl00_ContentPlaceHolder1_ListBox_cloture";
    final static String Vldenreg_actSimplifiee_ID = "ctl00_ContentPlaceHolder1_LinkButton99";
    final static String TYPE_RESP_SUIVI_ID = "ctl00_ContentPlaceHolder1_RadioButtonList3_0";
    final static String NOM_RESP_SUIVI_ID = "ctl00_ContentPlaceHolder1_tb_respsv0";
    final static String DELAI_SUIVI_ID = "ctl00_ContentPlaceHolder1_Imgb5";
    final static String DATE_SUIVI_ID = "ctl00_ContentPlaceHolder1_CalendarExtender4_today";
    final static String Vol_DETAIL_ACTION = "spandetail";
    final static String BTN_VLD_RESP_SUIVI_ID = "ctl00_ContentPlaceHolder1_LinkButton30";
    final static String AFF_DAT_SUIVI_ID = "ctl00_ContentPlaceHolder1_delsiuvie";
    final static String BOUTTON_AJOUTER_LISTE_DES_SOUS_ACTION_ID = "ctl00_ContentPlaceHolder1_LinkButton27";
    final static String DESIGNATION_GRID_LISTE_DES_SOUS_ACTION_ID = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView5\"]/tbody/tr/td[3]";

    /* @FindBy */
    @FindBy(how = How.ID, using = MENU_ID)
    public static WebElement menuID;
    @FindBy(how = How.XPATH, using = ModuleActions_XPATH)
    public static WebElement ModuleActions;
    @FindBy(how = How.XPATH, using = Filtre_Actions_XPATH)
    public static WebElement FiltreActions;
    @FindBy(how = How.ID, using = Bouton_Ajouter_ID)
    public static WebElement BoutonAjouter;
    @FindBy(how = How.ID, using = Ajouter_Act_Simplifiee_ID)
    public static WebElement AjouterActSimplifiee;
    @FindBy(how = How.ID, using = Source_Act_Simplifiee_ID)
    public static WebElement SourceActSimplifiee;
    @FindBy(how = How.ID, using = Type_Act_Simplifiee_ID)
    public static WebElement TypeActSimplifiee;
    @FindBy(how = How.ID, using = Datecreation_Act_Simplifiee_ID)
    public static WebElement DatecreationActSimplifiee;
    @FindBy(how = How.ID, using = agenda_creation_ID)
    public static WebElement agendacreation;
    @FindBy(how = How.ID, using = service_ActSimplifiee_ID)
    public static WebElement serviceActSimplifiee;
    @FindBy(how = How.ID, using = Resp_cloture_ID)
    public static WebElement Respcloture;
    @FindBy(how = How.ID, using = Vldenreg_actSimplifiee_ID)
    public static WebElement VldenregactSimplifiee;
    @FindBy(how = How.ID, using = TYPE_RESP_SUIVI_ID)
    public static WebElement TypeRespSuiviId;
    @FindBy(how = How.ID, using = NOM_RESP_SUIVI_ID)
    public static WebElement RespSuiviId;
    @FindBy(how = How.ID, using = DELAI_SUIVI_ID)
    public static WebElement DelaiSuiviId;
    @FindBy(how = How.ID, using = DATE_SUIVI_ID)
    public static WebElement DateSuiviId;
    @FindBy(how = How.ID, using = Vol_DETAIL_ACTION)
    public static WebElement VolDetailsActionId;
    @FindBy(how = How.ID, using = BTN_VLD_RESP_SUIVI_ID)
    public static WebElement BtnVldRespSuiviId;
    @FindBy(how = How.ID, using = AFF_DAT_SUIVI_ID)
    public static WebElement AFFDateSuiviId;
    @FindBy(how = How.ID, using = BOUTTON_AJOUTER_LISTE_DES_SOUS_ACTION_ID)
    public static WebElement btnAjouterSousActionModeleAction;
    @FindBy(how = How.XPATH, using = DESIGNATION_GRID_LISTE_DES_SOUS_ACTION_ID)
    public static WebElement desgSousActionModeleAction;
}