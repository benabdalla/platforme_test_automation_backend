package com.saphir.platforme.moduleAction.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DemandeActionPage {
    /* Locators */ // optimisation de maintenance par déclaration de variable

    final static String MENU_ID = "ctl00_menuModal";
    final static String HOME_ID = "ctl00_LinkButtonHome";
    final static String MENU_DEMANDE_ACTION_XPATH = "//*[@id=\"cssmenu15\"]/div/div/ul/li[2]/ul/li[2]/a";
    final static String BOUTON_AJOUT_ID = "ctl00_ContentPlaceHolder1_Ajouter_Ajouter";

    final static String SOURCE_ID = "ctl00_ContentPlaceHolder1_Listsource";
    final static String TYPE_ID = "ctl00_ContentPlaceHolder1_Listtype";
    final static String ORIGINE_ID = "ctl00_ContentPlaceHolder1_TextBox_Origine";

    final static String TYPE_CAUSE_ID = "ctl00_ContentPlaceHolder1_ListBoxTypeCause";
    final static String AJOUT_TYPE_CAUSE_ID = "ctl00_ContentPlaceHolder1_LinkButton32";
    final static String RECH_TYPE_CAUSE_ID = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView9_filter\"]/label/input";
    final static String GRID_TYPE_CAUSE_ID = "ctl00_ContentPlaceHolder1_GridView9";
    final static String TYPE_CAUSE_VALIDE_ID = "ctl00_ContentPlaceHolder1_Label200";

    final static String PRODUIT_ID = "ctl00_ContentPlaceHolder1_ListBoxProduit";
    final static String AJOUT_PRODUIT_ID = "ctl00_ContentPlaceHolder1_ButtonRattachProd";
    final static String PRODUIT_AJOUTE_ID = "ctl00_ContentPlaceHolder1_GridPRODUIT_ctl02_CheckBox1";
    final static String PRODUIT_VALIDE_ID = "ctl00_ContentPlaceHolder1_Label61";

    final static String DATE_CREATION_ID = "ctl00_ContentPlaceHolder1_Img10";
    final static String CALENDRIER_ID = "ctl00_ContentPlaceHolder1_CalendarExtender3_today";
    final static String DESIGNATION_ID = "ctl00_ContentPlaceHolder1_desi";
    final static String DESCRIPTION_ID = "ctl00_ContentPlaceHolder1_descrip";
    final static String CAUSE_XPATH = "ctl00_ContentPlaceHolder1_cause";
    final static String OBJECTIVE_ID = "ctl00_ContentPlaceHolder1_TextBoxObj";

    final static String BOUTON_VALIDE_ID = "ctl00_ContentPlaceHolder1_Button1";
    final static String NUMERO_DEMANDE_ID = "ctl00_ContentPlaceHolder1_nact";
    final static String FILTRE_NUMERO_ID = "ctl00_ContentPlaceHolder1_nacp";
    final static String BOUTON_CHERCHER_ID = "ctl00_ContentPlaceHolder1_Filtre_Rechercher";
    final static String TABLE_DEMANDE_ID = "ctl00_ContentPlaceHolder1_GridView1p";

    final static String SITE_ID = "ctl00_ContentPlaceHolder1_Listsite";
    final static String ACTIVITE_ID = "ctl00_ContentPlaceHolder1_lBDomaine_";
    final static String PROCESSUS_ID = "ctl00_ContentPlaceHolder1_lBProcessus_";
    final static String DIRECTION_ID = "ctl00_ContentPlaceHolder1_lBDirection_";
    final static String SERVICE_ID = "ctl00_ContentPlaceHolder1_lBService_";

    final static String OBJET_MENU_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_Objet_heading\"]/h4/a";
    final static String PLAN_MENU_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_SA_heading\"]/h4/a/span";

    final static String COMPTEUR_ID = "ctl00_label_lb_act";
    final static String COMPTE_ID = "ctl00_Imageus";
    final static String DECONNEXION_ID = "ctl00_Lbldec";
    final static String RESPONSABLE_TABLE_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView10\"]";
    final static String DEMANDEUR_ID = "ctl00_ContentPlaceHolder1_dec";
    final static String AGENDA_AC_ID = "ctl00_lb_act";
    final static String FILTRE_AGENDA_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView3_filter\"]/label/input";
    final static String TABLE_ID = "ctl00_ContentPlaceHolder1_GridView3";
    final static String MODIFY_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView3\"]/tbody/tr/td[1]";
    final static String BUTTON_VR_ID = "ctl00_ContentPlaceHolder1_Button3";
    final static String MENU_AG_DA_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_Div2\"]/h4/a";

    final static String BOUTTON_AJOUTER_LISTE_SAD_ID = "ctl00_ContentPlaceHolder1_LinkButton3";
    final static String DESIGNATION_LISTE_SAD_ID = "ctl00_ContentPlaceHolder1_desit";
    final static String RESPONSABLE_REALISATION_SAD_ID = "ctl00_ContentPlaceHolder1_tb_respreal";
    final static String RESPONSABLE_SUIVI_SAD_ID = "ctl00_ContentPlaceHolder1_tb_respsv";
    final static String DATE_SAD_ID = "ctl00_ContentPlaceHolder1_Img11";
    final static String CHOIX_DATE_SAD_ID = "ctl00_ContentPlaceHolder1_CalendarExtender4_today";
    final static String Date_Real_txt_ID = "ctl00_ContentPlaceHolder1_Del";
    final static String Date_suivi_TXT_ID = "ctl00_ContentPlaceHolder1_delsuivie";
    final static String délais_suivi_ID = "ctl00_ContentPlaceHolder1_Img14";
    final static String choix_délais_suivi_ID = "ctl00_ContentPlaceHolder1_CalendarExtender6_today";

    final static String GRAVITE_ID = "ctl00_ContentPlaceHolder1_DropDownList_Gravite";
    final static String PRIORITE_ID = "ctl00_ContentPlaceHolder1_DropDownList_Priorite";
    final static String COUT_PREV_SA_ID = "ctl00_ContentPlaceHolder1_TextBoxCout";
    final static String RISQUE_ID = "ctl00_ContentPlaceHolder1_TextBoxRisque";

    final static String BOUTTON_VALIDER_LISTE_SAD_ID = "ctl00_ContentPlaceHolder1_LinkButton11";
    final static String TABLE_SAD_ID = "ctl00_ContentPlaceHolder1_GridView1";


    /* @FindBy */
    @FindBy(how = How.ID, using = MENU_ID)
    public static WebElement menuID;

    @FindBy(how = How.ID, using = HOME_ID)
    public static WebElement HomeID;

    @FindBy(how = How.ID, using = TABLE_ID)
    public static WebElement TableID;

    @FindBy(how = How.XPATH, using = OBJET_MENU_XPATH)
    public static WebElement ObjetMenuID;

    @FindBy(how = How.XPATH, using = MENU_AG_DA_XPATH)
    public static WebElement MenuAgDaID;

    @FindBy(how = How.ID, using = AGENDA_AC_ID)
    public static WebElement AgendaAcID;

    @FindBy(how = How.XPATH, using = MODIFY_XPATH)
    public static WebElement ModifyID;

    @FindBy(how = How.ID, using = BUTTON_VR_ID)
    public static WebElement ButtonVrID;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_Button2")
    public static WebElement wBtnrefusse;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_TextBox_MotifR")
    public static WebElement wCommentRefusse;


    @FindBy(how = How.XPATH, using = FILTRE_AGENDA_XPATH)
    public static WebElement FiltreAgendaID;

    @FindBy(how = How.ID, using = COMPTE_ID)
    public static WebElement CompteID;

    @FindBy(how = How.XPATH, using = RESPONSABLE_TABLE_XPATH)
    public static WebElement ResponsableTableID;

    @FindBy(how = How.ID, using = DEMANDEUR_ID)
    public static WebElement DemandeurID;

    @FindBy(how = How.ID, using = DECONNEXION_ID)
    public static WebElement DeconnexionID;

    @FindBy(how = How.XPATH, using = PLAN_MENU_XPATH)
    public static WebElement PlanMenuID;

    @FindBy(how = How.XPATH, using = MENU_DEMANDE_ACTION_XPATH)
    public static WebElement ModuleDemandeActions;

    @FindBy(how = How.ID, using = BOUTON_AJOUT_ID)
    public static WebElement BoutonAjoutID;

    /* @FindBy */
    @FindBy(how = How.ID, using = SOURCE_ID)
    public static WebElement SourceID;

    /* @FindBy */
    @FindBy(how = How.ID, using = TYPE_ID)
    public static WebElement TypeID;

    /* @FindBy */
    @FindBy(how = How.ID, using = ORIGINE_ID)
    public static WebElement OrigineID;

    /* @FindBy */
    @FindBy(how = How.ID, using = TYPE_CAUSE_ID)
    public static WebElement TypeCauseID;

    /* @FindBy */
    @FindBy(how = How.ID, using = PRODUIT_ID)
    public static WebElement ProduitID;

    /* @FindBy */
    @FindBy(how = How.ID, using = DATE_CREATION_ID)
    public static WebElement dateCreationID;

    /* @FindBy */
    @FindBy(how = How.ID, using = CALENDRIER_ID)
    public static WebElement CalendrierID;

    /* @FindBy */
    @FindBy(how = How.ID, using = DESIGNATION_ID)
    public static WebElement DesignationID;

    /* @FindBy */
    @FindBy(how = How.ID, using = DESCRIPTION_ID)
    public static WebElement DescriptionID;

    /* @FindBy */
    @FindBy(how = How.ID, using = CAUSE_XPATH)
    public static WebElement CauseID;

    /* @FindBy */
    @FindBy(how = How.ID, using = OBJECTIVE_ID)
    public static WebElement ObjectiveID;

    /* @FindBy */
    @FindBy(how = How.ID, using = AJOUT_TYPE_CAUSE_ID)
    public static WebElement AjoutTypeCauseID;

    /* @FindBy */
    @FindBy(how = How.XPATH, using = RECH_TYPE_CAUSE_ID)
    public static WebElement RechTypeCauseID;

    /* @FindBy */
    @FindBy(how = How.ID, using = GRID_TYPE_CAUSE_ID)
    public static WebElement GridTypeCauseID;

    /* @FindBy */
    @FindBy(how = How.ID, using = TYPE_CAUSE_VALIDE_ID)
    public static WebElement TypeCauseValideID;

    /* @FindBy */
    @FindBy(how = How.ID, using = AJOUT_PRODUIT_ID)
    public static WebElement AjoutProduitID;

    /* @FindBy */
    @FindBy(how = How.ID, using = PRODUIT_AJOUTE_ID)
    public static WebElement produitAjouteID;

    /* @FindBy */
    @FindBy(how = How.ID, using = PRODUIT_VALIDE_ID)
    public static WebElement produitValideID;

    /* @FindBy */
    @FindBy(how = How.ID, using = BOUTON_VALIDE_ID)
    public static WebElement BoutonValideID;

    /* @FindBy */
    @FindBy(how = How.ID, using = NUMERO_DEMANDE_ID)
    public static WebElement NumeroDemandeID;

    /* @FindBy */
    @FindBy(how = How.ID, using = FILTRE_NUMERO_ID)
    public static WebElement FiltreNumeroID;
    /* @FindBy */
    @FindBy(how = How.ID, using = BOUTON_CHERCHER_ID)
    public static WebElement BoutonChercherID;

    /* @FindBy */
    @FindBy(how = How.ID, using = TABLE_DEMANDE_ID)
    public static WebElement TableDemandeID;

    /* @FindBy */
    @FindBy(how = How.ID, using = SITE_ID)
    public static WebElement SiteID;

    /* @FindBy */
    @FindBy(how = How.ID, using = ACTIVITE_ID)
    public static WebElement ActiviteID;

    /* @FindBy */
    @FindBy(how = How.ID, using = PROCESSUS_ID)
    public static WebElement ProcessusID;

    /* @FindBy */
    @FindBy(how = How.ID, using = DIRECTION_ID)
    public static WebElement DirectionID;

    /* @FindBy */
    @FindBy(how = How.ID, using = SERVICE_ID)
    public static WebElement ServiceID;

    @FindBy(how = How.ID, using = COMPTEUR_ID)
    public static WebElement CompteurID;

    @FindBy(how = How.ID, using = BOUTTON_AJOUTER_LISTE_SAD_ID)
    public static WebElement btnAjouter_SAD_ID;
    @FindBy(how = How.ID, using = DESIGNATION_LISTE_SAD_ID)
    public static WebElement designation_SAD_ID;
    @FindBy(how = How.ID, using = RESPONSABLE_REALISATION_SAD_ID)
    public static WebElement responsableRealisation_SAD_ID;
    @FindBy(how = How.ID, using = RESPONSABLE_SUIVI_SAD_ID)
    public static WebElement responsableSuivi_SAD_ID;
    @FindBy(how = How.ID, using = BOUTTON_VALIDER_LISTE_SAD_ID)
    public static WebElement btnValider_SAD_ID;
    @FindBy(how = How.ID, using = DATE_SAD_ID)
    public static WebElement date_SAD_ID;
    @FindBy(how = How.ID, using = CHOIX_DATE_SAD_ID)
    public static WebElement choixDate_SAD_ID;
    @FindBy(how = How.ID, using = TABLE_SAD_ID)
    public static WebElement Table_SAD_ID;

    @FindBy(how = How.ID, using = Date_Real_txt_ID)
    public static WebElement Date_real_txt_id;
    @FindBy(how = How.ID, using = Date_suivi_TXT_ID)
    public static WebElement Date_suivi_txt_id;

    @FindBy(how = How.ID, using = délais_suivi_ID)
    public static WebElement délais_suivi;
    @FindBy(how = How.ID, using = choix_délais_suivi_ID)
    public static WebElement choix_délais_suivi;

    @FindBy(how = How.ID, using = GRAVITE_ID)
    public static WebElement GraviteId;
    @FindBy(how = How.ID, using = PRIORITE_ID)
    public static WebElement PrioriteId;
    @FindBy(how = How.ID, using = COUT_PREV_SA_ID)
    public static WebElement CoutPrevId;
    @FindBy(how = How.ID, using = RISQUE_ID)
    public static WebElement RisqueId;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_ListBox1")
    public static WebElement idSiteRespValidation;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_ListBoxProcessus")
    public static WebElement idProcessusRespValidation;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_Ajouter_rv")
    public static WebElement idBtnAjouterRespValidation;





}