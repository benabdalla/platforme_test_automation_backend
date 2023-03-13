package com.saphir.platforme.moduleAction.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class FicheActionPage {


    /* Locators */ // optimisation de maintenance par déclaration de variable
    public static List<String> Filtre_rep = new ArrayList<String>();
    final static String MENU_ID = "ctl00_menuModal";
    final static String HOME_ID = "ctl00_LinkButtonHome";
    final static String ACTIONS_XPATH = "//*[@id=\"cssmenu15\"]/div/div/ul/li[2]/a";
    final static String ACTION_XPATH = "//*[@id=\"cssmenu15\"]/div/div/ul/li[2]/ul/li[1]/a";
    final static String BOUTTON_AJOUTER_ACTION_ID = "ctl00_ContentPlaceHolder1_Ajouter";
    final static String BOUTTON_AJOUTER_DETAILLEE_ACTION_ID = "ctl00_ContentPlaceHolder1_AjactDet";
    final static String btnEnrTReal = "ctl00_ContentPlaceHolder1_lb_enreg_real";
    final static String tauxRealAg = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_ctl02_tb_taux\"]";
    final static String BtnClot = "ctl00_ContentPlaceHolder1_Label126";

    final static String btnVldTReal = "ctl00_ContentPlaceHolder1_LinkButton32";
    final static String OBJET_XPATH = "ctl00_ContentPlaceHolder1_Liste_sous_actions";
    final static String PLAN_ACTION_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_Panel13_2Heading\"]/h4/a/span";

    final static String ATT_MODELE_ID = "ctl00_ContentPlaceHolder1_LinkButton_Modele";
    final static String RECH_MODELE_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView3_filter\"]/label/input";
    final static String CHX_MODELE_ID = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView3\"]/tbody/tr/td[1]";
    final static String APERCU_ID = "ctl00_ContentPlaceHolder1_Label150";


    final static String SOURCE_ID = "ctl00_ContentPlaceHolder1_Listsource";
    final static String Datecreation_Act_ID = "ctl00_ContentPlaceHolder1_Img8";
    final static String agenda_creation_ID = "ctl00_ContentPlaceHolder1_CalendarExtender1_today";
    final static String CALENDRIER_ID = "ctl00_ContentPlaceHolder1_datcrea";
    final static String CHOIX_DATE_ID = "ctl00_ContentPlaceHolder1_CalendarExtender1_today";

    final static String ORIGINE_ID = "ctl00_ContentPlaceHolder1_TextBox_Origine";
    final static String AJT_PRDT_ID = "ctl00_ContentPlaceHolder1_Button1";
    final static String CHX_PRDT_ID = "ctl00_ContentPlaceHolder1_GridPRODUIT";
    final static String VLD_PRDT_ID = "ctl00_ContentPlaceHolder1_Label110";
    final static String FERMER_PRDT_ID = "//*[@id=\"myModalRatproduit\"]/div/div/div[1]/button/span";

    final static String AJT_TYP_CAUSE = "ctl00_ContentPlaceHolder1_LinkButton32";
    final static String RECH_TYP_CAUSE = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView9_filter\"]/label/input";
    final static String GRID_TYP_CAUSE = "ctl00_ContentPlaceHolder1_GridView9";
    final static String VLD_TYP_CAUSE = "ctl00_ContentPlaceHolder1_Label200";
    final static String FERMER_TYP_CAUSE = "//*[@id=\"myModalTypes8causes\"]/div/div/div[1]/button/span";

    final static String Objectif_ID = "ctl00_ContentPlaceHolder1_TextBoxObj";
    final static String REF_AUDIT_ID = "ctl00_ContentPlaceHolder1_DropDownList4";


    final static String DESIGNATION_ID = "ctl00_ContentPlaceHolder1_desi";
    final static String TYPE_ID = "ctl00_ContentPlaceHolder1_Listtype";
    final static String DESCRIPTION_OBJET_ID = "ctl00_ContentPlaceHolder1_descrip";
    final static String CAUSES_POSSIBLES_ID = "ctl00_ContentPlaceHolder1_cause";
    final static String SITE_ID = "ctl00_ContentPlaceHolder1_Listsite";
    final static String PROCESSUS_ID = "ctl00_ContentPlaceHolder1_lBProcessus_";
    final static String ACTIVITE_ID = "ctl00_ContentPlaceHolder1_lBDomaine_";
    final static String DIRECTION_ID = "ctl00_ContentPlaceHolder1_ListBox_Direction";
    final static String service_ID = "ctl00_ContentPlaceHolder1_lBService_";

    final static String Resp_cloture_ID = "ctl00_ContentPlaceHolder1_ListBox_cloture";
    final static String BOUTTON_VALIDER_ID = "ctl00_ContentPlaceHolder1_LinkButton17_Valider";
    final static String AGENDA_ACTION_ID = "ctl00_lb_act";
    final static String AGENDA_ACTION2_ID = "//*[@id=\"ctl00_lb_act\"]/span";

    final static String BOUTTON_AJOUTER_LISTE_DES_SOUS_ACTION_ID = "ctl00_ContentPlaceHolder1_LinkButton3pm";
    final static String DESIGNATION_SOUS_ACTION_ID = "ctl00_ContentPlaceHolder1_TextBox5";
    final static String RESPONSABLE_REALISATION_SOUS_ACTION_ID = "ctl00_ContentPlaceHolder1_tb_respreal";
    final static String RESPONSABLE_SUIVI_SOUS_ACTION_ID = "ctl00_ContentPlaceHolder1_tb_respsv";
    final static String DATE_SOUS_ACTION_ID = "ctl00_ContentPlaceHolder1_Img13";
    final static String CHOIX_DATE_SOUS_ACTION_ID = "ctl00_ContentPlaceHolder1_CalendarExtender14_today";
    final static String délais_suivi_ID = "ctl00_ContentPlaceHolder1_Img14";

    final static String choix_délais_suivi_ID = "ctl00_ContentPlaceHolder1_CalendarExtender15_today";
    final static String BOUTTON_VALIDER_LISTE_DES_SOUS_ACTION_ID = "ctl00_ContentPlaceHolder1_LinkButton11";
    final static String DESIGNATION_GRID_LISTE_DES_SOUS_ACTION_ID = "ctl00_ContentPlaceHolder1_GridView1";

    final static String GRAVITE_ID = "ctl00_ContentPlaceHolder1_DropDownList_Gravite";
    final static String PRIORITE_ID = "ctl00_ContentPlaceHolder1_DropDownList_Priorite";
    final static String COUT_PREV_SA_ID = "ctl00_ContentPlaceHolder1_TextBox10";
    final static String RISQUE_ID = "ctl00_ContentPlaceHolder1_TextBox19";

    final static String GRID_ACTION_A_REALISATION_ID = "ctl00_ContentPlaceHolder1_GridView1";
    final static String ACTION_A_REALISATION_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_Panel_actRealiser\"]/div[1]/h4/a/span";
    final static String ACTION_A_CLOTURER_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_Panel20\"]/div[1]/h4/a/span";
    final static String ACTION_A_SUIVIRE_XPATH = "ctl00_ContentPlaceHolder1_num3";
    final static String NUM_ACTION_A_REALISATION_ID = "ctl00_ContentPlaceHolder1_textBoxNAct2";
    final static String CHOIX_NUM_ACTION_A_REALISATION_ID = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr/td[1]";

    final static String RECHERCHER_NUM_ACTION_A_REALISATION_ID = "ctl00_ContentPlaceHolder1_LinkButton38";

    final static String RECHERCHER_ACTION_A_CLOTURER_XPATH = "ctl00_ContentPlaceHolder1_GridView_Cloture_filter";

    //*[@id="ctl00_ContentPlaceHolder1_GridView2_wrapper"]/div[1]/div[2]/div/label/input
    //*[@id="ctl00_ContentPlaceHolder1_GridView_Cloture_wrapper"]/div[1]/div[2]/div/label/input

    final static String TAUX_REALISATION_ID = "ctl00_ContentPlaceHolder1_Taux1";
    final static String DEPENSES_ID = "ctl00_ContentPlaceHolder1_depen";
    final static String COMMENTAIRE_ID = "ctl00_ContentPlaceHolder1_comm1";
    final static String DATE_REALISATION_ID = "ctl00_ContentPlaceHolder1_Img6";
    final static String CHOIX_DATE_REALISATION_ID = "ctl00_ContentPlaceHolder1_CalendarExtender5_today";
    final static String SAISIE_D_REALISATION_ID = "ctl00_ContentPlaceHolder1_datrea";
    final static String VALIDER_REALISATION_ID = "ctl00_ContentPlaceHolder1_LinkButton21";

    final static String NUM_ACTION_A_SUIVRE_ID = "ctl00_ContentPlaceHolder1_textBoxNAct";
    final static String CHOIX_NUM_ACTION_A_SUIVRE_ID = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView2\"]/tbody/tr/td[1]";
    final static String RECHERCHER_NUM_ACTION_A_SUIVRE_ID = "ctl00_ContentPlaceHolder1_LinkButton36_Rechercher";

    final static String TAUX_EFF_ID = "ctl00_ContentPlaceHolder1_Tauxeff2";
    final static String RAPPORT_EFF_ID = "ctl00_ContentPlaceHolder1_reff2";
    final static String VALIDER_SUIVI_ID = "ctl00_ContentPlaceHolder1_LinkButton7";

    final static String CHOIX_ACTION_CLOTURER_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView_Cloture\"]/tbody/tr/td[1]";
    final static String CLOTUREE_ID = "ctl00_ContentPlaceHolder1_RadioButtonList1_0";

    final static String DATE_CLOTURE_ID = "ctl00_ContentPlaceHolder1_img3";

    final static String CHOIX_DATE_CLOTURE_ID = "ctl00_ContentPlaceHolder1_CalendarExtender8_today";

    final static String VALIDER_CLOTURE_ID = "ctl00_ContentPlaceHolder1_LinkButton44_suivi";
    final static String RAPPORT_CLOTURE_ID = "ctl00_ContentPlaceHolder1_rapclot";

    final static String RECH_FILT_ID = "ctl00_ContentPlaceHolder1_nacP";
    final static String BTN_RECH_FILTRE_ID = "ctl00_ContentPlaceHolder1_Filtre_Rechercher";
    final static String TABLE_FILTRE_ACTION_ID = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView1P\"]/tbody/tr/td[2]";

    final static String AFFI_TX_REA_ID = "ctl00_ContentPlaceHolder1_tauxreal2";
    final static String EDIT_TX_REA_ID = "ctl00_ContentPlaceHolder1_LinkButton2";
    final static String CHX_SA_REA_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView4\"]/tbody/tr/td[1]";
    final static String NOUV_TX_REA_ID = "ctl00_ContentPlaceHolder1_Trd1";
    final static String NOUV_TX_REA_IDSmp = "ctl00_ContentPlaceHolder1_TextBox10dcfsd";

    final static String COMM_NOUV_TX_ID = "ctl00_ContentPlaceHolder1_Tr2";
    final static String COMM_NOUV_TX_IDsimp = "ctl00_ContentPlaceHolder1_Texyyy";

    final static String VLD_NOUV_TAUX_REA_ID = "ctl00_ContentPlaceHolder1_LinkButton15";
    final static String VLD_NOUV_TAUX_REA_IDsimp = "ctl00_ContentPlaceHolder1_Lindwfdv";
    final static String QUTT_MOD_TX_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_juj\"]/span";
    final static String VLD_RETOUR_ID = "ctl00_ContentPlaceHolder1_LinkButton7";
    final static String QTT_RETOUR_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_LinkButton8\"]/span";
    final static String QTT_RETOUR1_XPATH = "//*[@id=\"ctl00_ContentPlaceHolder1_LinkButton22\"]/span";
    final static String EXPORTER_ID = "IconImg_CrystalReportViewer1_toptoolbar_export";
    final static String TRACABILITE_ID = "ctl00_ContentPlaceHolder1_Label154";
    final static String CHX_APERCU_ID = "ctl00_ContentPlaceHolder1_type_report_1";
    final static String VLD_Apercu_ID = "ctl00_ContentPlaceHolder1_LinkButton16";


    final static String ACTION_A_REALISER_ID = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView1\"]/tbody/tr/td[1]";
    final static String ACTION_A_SUIVRE_ID = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView2\"]/tbody/tr/td[1]";
    final static String FILTRE_REALISE_ID = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView1_filter\"]/label/input";

    final static String PNL_Intervenant_ID = "//*[@id=\"ctl00_ContentPlaceHolder1_panelIntervHeading\"]/h4/a/span";
    final static String AJT_INTER_ID = "ctl00_ContentPlaceHolder1_LinkButton6";
    final static String RECH_INTER_ID = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView8_filter\"]/label/input";
    final static String CHX_INTER_ID = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView8\"]/tbody/tr/td[1]";
    final static String VLD_INTER_ID = "ctl00_ContentPlaceHolder1_LinkButton11";

    public final static String selec_source_id = "ctl00_ContentPlaceHolder1_ListBox_Source";
    public final static String selec_declencheur_id = "ctl00_ContentPlaceHolder1_ListBox_Decl";
    public final static String del_creation_1_id = "ctl00_ContentPlaceHolder1_TextBox_Creat1";
    public final static String del_creation_2_id = "ctl00_ContentPlaceHolder1_TextBox_Creat2";
    public final static String designation_id = "ctl00_ContentPlaceHolder1_TextBox_Desig";
    public final static String selec_type_id = "ctl00_ContentPlaceHolder1_ListBox_Type";
    public final static String description_id = "ctl00_ContentPlaceHolder1_TextBox_Desc";
    public final static String selec_type_cause_id = "ctl00_ContentPlaceHolder1_ListBox_TypeC";
    public final static String btnS_pdt_id = "ctl00_ContentPlaceHolder1_Button1_1";
    public final static String rech_pdt_xpath = "//*[@id=\"ctl00_ContentPlaceHolder1_GridPRODUIT_filter\"]/label/input";
    public final static String grid_pdt_id = "ctl00_ContentPlaceHolder1_GridPRODUIT";
    public final static String selec_site_id = "ctl00_ContentPlaceHolder1_ListBox_Site";
    public final static String selec_processus_id = "ctl00_ContentPlaceHolder1_lBProcessus_";
    public final static String selec_domaine_id = "ctl00_ContentPlaceHolder1_lBDomaine_";
    public final static String selec_direction_id = "ctl00_ContentPlaceHolder1_ListBox_Direction";
    public final static String designsousact_id = "ctl00_ContentPlaceHolder1_TextBox_DesigSousAct";
    public final static String selec_resp_rea_id = "ctl00_ContentPlaceHolder1_ListBox_RespR";
    public final static String selec_resp_suivi_id = "ctl00_ContentPlaceHolder1_ListBox_RespS";
    public final static String del_real_1_id = "ctl00_ContentPlaceHolder1_TextBox_DelaiR1";
    public final static String del_real_2_id = "ctl00_ContentPlaceHolder1_TextBox_DelaiR2";
    public final static String del_suivi_1_id = "ctl00_ContentPlaceHolder1_TextBox_DelaiS1";
    public final static String del_suivi_2_id = "ctl00_ContentPlaceHolder1_TextBox_DelaiS2";
    public final static String selec_Priorite_id = "ctl00_ContentPlaceHolder1_DropDownList_Priorite";
    public final static String selec_gravite_id = "ctl00_ContentPlaceHolder1_DropDownList_Gravite";
    public final static String audit_id = "ctl00_ContentPlaceHolder1_TextBox_audit";
    public final static String taux_real_1_id = "ctl00_ContentPlaceHolder1_TextBox_PReal1";
    public final static String taux_real_2_id = "ctl00_ContentPlaceHolder1_TextBox_PReal2";
    public final static String taux_eff_1_id = "ctl00_ContentPlaceHolder1_TextBox_PEff1";
    public final static String taux_eff_2_id = "ctl00_ContentPlaceHolder1_TextBox_PEff2";
    public final static String btn_real_id = "ctl00_ContentPlaceHolder1_RadioButtonList_Real_0";
    public final static String btn_nn_real_id = "ctl00_ContentPlaceHolder1_RadioButtonList_Real_1";
    public final static String btn_clot_id = "ctl00_ContentPlaceHolder1_RadioButtonList_Clot_0";
    public final static String btn_nn_clot_id = "ctl00_ContentPlaceHolder1_RadioButtonList_Clot_1";
    public final static String btn_mod_2_id = "ctl00_ContentPlaceHolder1_RadioButtonList_Modele_1";
    public final static String btn_mod_3_id = "ctl00_ContentPlaceHolder1_RadioButtonList_Modele_2";
    public final static String btn_aff_dep_id = "ctl00_ContentPlaceHolder1_CheckBox_AffDepence";
    public final static String btn_group_decl_id = "ctl00_ContentPlaceHolder1_R_groupe_1";
    public final static String btn_group_type_id = "ctl00_ContentPlaceHolder1_R_groupe_2";
    public final static String btn_group_pdt_id = "ctl00_ContentPlaceHolder1_R_groupe_3";
    public final static String btn_group_site_id = "ctl00_ContentPlaceHolder1_R_groupe_4";
    public final static String btn_group_resp_real_id = "ctl00_ContentPlaceHolder1_R_groupe_5";

    public final static String selec_Site_Action_Par_Resp_id = "ctl00_ContentPlaceHolder1_ListBox1";
    public final static String selec_Processus_Action_Par_Resp_id = "ctl00_ContentPlaceHolder1_ddlActivite";
    public final static String selec_Activité_Action_Par_Resp_id = "ctl00_ContentPlaceHolder1_lBDomaine_";
    public final static String selec_Direction_Action_Par_Resp_id = "ctl00_ContentPlaceHolder1_ListBox_Direction";
    public final static String selec_Priorité_Action_Par_Resp_id = "ctl00_ContentPlaceHolder1_DropDownList_PFiltre";
    public final static String selec_GravitéAction_Action_Par_Resp_id = "ctl00_ContentPlaceHolder1_DropDownList_GFiltre";
    public final static String selec_RespRéalisation_Action_Par_Resp_id = "ctl00_ContentPlaceHolder1_tb_respreal";
    public final static String del_DateCreation1_Action_Par_Resp_id = "ctl00_ContentPlaceHolder1_TextBox1";
    public final static String del_DateCreation2_Action_Par_Resp_id = "ctl00_ContentPlaceHolder1_TextBox3";
    public final static String del_DateRealisation1_Action_Par_Resp_id = "ctl00_ContentPlaceHolder1_TextBoxDate1";
    public final static String del_DateRealisation2_Action_Par_Resp_id = "ctl00_ContentPlaceHolder1_TextBoxDate2";

    //Amira

    public final static String selec_Site_Action_Par_Personne_id = "ctl00_ContentPlaceHolder1_listboxSiteFiltre";
    public final static String selec_Processus_Action_Par_Personne_id = "ctl00_ContentPlaceHolder1_lBProcessus_";
    public final static String selec_Activité_Action_Par_Personne_id = "ctl00_ContentPlaceHolder1_lBDomaine_";
    public final static String selec_Direction_Action_Par_Personne_id = "ctl00_ContentPlaceHolder1_ListBox_Direction";
    public final static String selec_Priorité_Action_Par_Personne_id = "ctl00_ContentPlaceHolder1_DropDownList_PFiltre";
    public final static String selec_GravitéAction_Action_Par_Personne_id = "ctl00_ContentPlaceHolder1_DropDownList_GFiltre";
    public final static String selec_Source_Action_Par_Personne_id = "ctl00_ContentPlaceHolder1_ListBoxSources";
    public final static String selec_RespRéalisation_Action_Par_Personne_id = "ctl00_ContentPlaceHolder1_ListBox2";
    public final static String del_DateRealisation1_Action_Par_Personne_id = "ctl00_ContentPlaceHolder1_TextBox1";
    public final static String del_DateRealisation2_Action_Par_Personne_id = "ctl00_ContentPlaceHolder1_TextBox3";
    public final static String del_DateSaisieRealisation1_Action_Par_Personne_id = "ctl00_ContentPlaceHolder1_TextBox2";
    public final static String del_DateSaisieRealisation2_Action_Par_Personne_id = "ctl00_ContentPlaceHolder1_TextBox4";
    public final static String NoClot = "ctl00_ContentPlaceHolder1_RadioButtonList1_1";
    public final static String BtnValidNOclot = "ctl00_ContentPlaceHolder1_LinkButton44_suivi";
    public final static String statutClot = "ctl00_ContentPlaceHolder1_GridView1P_ctl02_lb_cloture";
    public final static String btnAjout = "ctl00_ContentPlaceHolder1_Ajouter";
    public final static String exp = "/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr/td[2]/nobr/a";
    public final static String examp = "ctl00_ContentPlaceHolder1_Label67";

    public final static String btnClosAct = "//*[@id=\"ctl00_ContentPlaceHolder1_GridView_Cloture_wrapper\"]/div[2]/div/table/tbody/tr/td[1]";
    public final static String choixrept = "//td/div/table/tbody/tr/td/table/tbody/tr/td[2]/div";
    //td/div/table/tbody/tr/td/table/tbody/tr/td[2]/div
    //td/div/table/tbody/tr/td/div/table/tbody/tr/td[2]/table/tbody/tr/td/div
    //div/table/tbody/tr/td[2]/table/tbody/tr/td/div/img
    public final static String selctRepo = "//tr[8]/td[2]/span";
    public final static String reporting = "ctl00_cssmenu12";

    public final static String actionrep = "//div[@id='menu_rep']/div/div/ul/li/ul/li[2]/a";
    public static final String reportingAct = "//div[@id='menu_rep']/div/div/ul/li/ul/li[2]/ul/li/a";
    public static final String export = "//a[contains(text(),'Exporter')]";
    static final String dateRel = "ctl00_ContentPlaceHolder1_Del";
    static final String dateSuiv = "ctl00_ContentPlaceHolder1_delsiuvie";
    static final String btnAjouSource = "ctl00_ContentPlaceHolder1_Ajouter_Ajouter";
    static final String Source = "ctl00_ContentPlaceHolder1_TextBox2";
    static final String SourceSimp = "body";
    static final String ValidSource = "ctl00_ContentPlaceHolder1_LinkButton11";
    static final String retourSource = "ctl00_ContentPlaceHolder1_LinkButton12";
    static final String recherSource = "ctl00_ContentPlaceHolder1_TextBox1";
    static final String btnrecherSource = "ctl00_ContentPlaceHolder1_Label49";
    static final String verfiSource = "//table[@id='ctl00_ContentPlaceHolder1_GridView1']/tbody/tr/td[2]";
    static final String Ajouttype = "ctl00_ContentPlaceHolder1_Ajouter";
    static final String saitype = "ctl00_ContentPlaceHolder1_TextBox2";

    static final String chekSimptype = "ctl00_ContentPlaceHolder1_ch_act_simp";
    static final String nancastype = "ctl00_ContentPlaceHolder1_Ch_analys_cause";
    static final String recheperson = "//div[@id='ctl00_ContentPlaceHolder1_GridView_Employe_filter']/label/input";
    static final String tabpersonne = "ctl00_ContentPlaceHolder1_GridView_Employe";
    static final String recherchetype = "//div[@id='ctl00_ContentPlaceHolder1_GridView1_filter']/label/input";
    static final String tabtypeAct = "ctl00_ContentPlaceHolder1_GridView1";
    static final String validetpreson = "ctl00_ContentPlaceHolder1_LinkButton9";

    static final String SiteIdModele = "ctl00_ContentPlaceHolder1_ListsiteDivAffect";
    static final String processusIdModele = "ctl00_ContentPlaceHolder1_lBProcessus_DivAffect";
    static final String serveieIdModele = "ctl00_ContentPlaceHolder1_lBService_DivAffect";
    static final String activiteIdModele = "ctl00_ContentPlaceHolder1_lBDomaine_DivAffect";
    static final String directionIdModele = "ctl00_ContentPlaceHolder1_ListBox_DirectionDivAffect";


    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_ch_act_simp")
    public static WebElement wcheckBoxActionSimplifier;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_tb_respsv0")
    public static WebElement wrespoSuivi;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_LinkButton27")
    public static WebElement wBtnAjouterSousActSeulRespo;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_LinkButton30")
    public static WebElement wbtnValideRespoEtDateSuivi;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_GridView5")
    public static WebElement wGridSousActSeulRespo;

    @FindBy(how = How.ID, using = activiteIdModele)
    public static WebElement wactiviteIdModele;
    @FindBy(how = How.ID, using = directionIdModele)
    public static WebElement wdirectionIdModele;

    @FindBy(how = How.ID, using = serveieIdModele)
    public static WebElement wserveieIdModele;

    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_GridView_ActionRealise")
    public static WebElement wtabFGR;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_GridView_ActionDemande")
    public static WebElement wtabFGDemandAction;

    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_GridView_tab_agenda_ActionSuivre")
    public static WebElement wtabFGS;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_GridView_tab_ActionCloture")
    public static WebElement wtabFGC;


    @FindBy(how = How.ID, using = SiteIdModele)
    public static WebElement wSiteIdModele;

    @FindBy(how = How.ID, using = processusIdModele)
    public static WebElement wprocessusIdModele;
    @FindBy(how = How.ID, using = del_DateSaisieRealisation1_Action_Par_Personne_id)
    public static WebElement wtypecaus;

    @FindBy(how = How.ID, using = validetpreson)
    public static WebElement wvalidetpreson;
    @FindBy(how = How.ID, using = tabtypeAct)
    public static WebElement wtabtypeAct;
    @FindBy(how = How.XPATH, using = recherchetype)
    public static WebElement wrecherchetype;

    @FindBy(how = How.ID, using = tabpersonne)
    public static WebElement wtabpersonne;
    @FindBy(how = How.XPATH, using = recheperson)
    public static WebElement wrecheperson;
    @FindBy(how = How.ID, using = nancastype)
    public static WebElement wnancastype;
    @FindBy(how = How.ID, using = chekSimptype)
    public static WebElement wchekSimptype;
    @FindBy(how = How.ID, using = saitype)
    public static WebElement wsaitype;
    @FindBy(how = How.ID, using = Ajouttype)
    public static WebElement wAjouttype;
    @FindBy(how = How.XPATH, using = verfiSource)
    public static WebElement wverfiSource;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_GridView1")
    public static WebElement wTabSource;

    @FindBy(how = How.ID, using = recherSource)
    public static WebElement wrecherSource;
    @FindBy(how = How.ID, using = btnrecherSource)
    public static WebElement wbtnrecherSource;
    @FindBy(how = How.ID, using = retourSource)
    public static WebElement wretourSource;

    @FindBy(how = How.ID, using = ValidSource)
    public static WebElement wValidSource;
    @FindBy(how = How.ID, using = SourceSimp)
    public static WebElement wSourceSimp;
    @FindBy(how = How.ID, using = Source)
    public static WebElement wource;
    @FindBy(how = How.ID, using = btnAjouSource)
    public static WebElement wbtnAjouSource;


    @FindBy(how = How.ID, using = dateRel)
    public static WebElement wdateRel;
    @FindBy(how = How.ID, using = dateSuiv)
    public static WebElement wdateSuiv;
    @FindBy(how = How.XPATH, using = export)
    public static WebElement wexport;
    @FindBy(how = How.XPATH, using = reportingAct)
    public static WebElement wreportingAct;
    @FindBy(how = How.XPATH, using = actionrep)
    public static WebElement wactionrep;
    @FindBy(how = How.ID, using = reporting)
    public static WebElement wreporting;
    @FindBy(how = How.XPATH, using = selctRepo)
    public static WebElement wselctRepo;
    @FindBy(how = How.XPATH, using = choixrept)
    public static WebElement wchoixrept;
    @FindBy(how = How.XPATH, using = exp)
    public static WebElement wexp;
    @FindBy(how = How.XPATH, using = btnClosAct)
    public static WebElement wbtnClosAct;
    @FindBy(how = How.ID, using = examp)
    public static WebElement wexamp;

    @FindBy(how = How.ID, using = statutClot)
    public static WebElement wstatutClot;
    @FindBy(how = How.ID, using = BtnValidNOclot)
    public static WebElement wBtnValidNOclot;
    @FindBy(how = How.ID, using = NoClot)
    public static WebElement wNOClot;
    @FindBy(how = How.ID, using = BtnClot)
    public static WebElement WbtnClot;
    @FindBy(how = How.ID, using = btnVldTReal)
    public static WebElement WbtnVldTReall;
    @FindBy(how = How.ID, using = btnEnrTReal)
    public static WebElement WbtnEnrTReal;

    @FindBy(how = How.XPATH, using = tauxRealAg)
    public static WebElement WtauxRealAg;
    @FindBy(how = How.ID, using = RAPPORT_CLOTURE_ID)
    public static WebElement rapportClotureID;
    @FindBy(how = How.ID, using = RECHERCHER_ACTION_A_CLOTURER_XPATH)
    public static WebElement rechercherActionCloturerXpath;
    @FindBy(how = How.XPATH, using = ACTION_A_CLOTURER_XPATH)
    public static WebElement ActionCloturerXpath;
    @FindBy(how = How.XPATH, using = ACTION_A_REALISATION_XPATH)
    public static WebElement ActionRealisationXpath;
    @FindBy(how = How.ID, using = ACTION_A_SUIVIRE_XPATH)
    public static WebElement ActionSuivreXpath;
    @FindBy(how = How.ID, using = MENU_ID)
    public static WebElement menuID;
    @FindBy(how = How.ID, using = HOME_ID)
    public static WebElement HomeID;
    @FindBy(how = How.XPATH, using = ACTIONS_XPATH)
    public static WebElement ActionSXpath;
    @FindBy(how = How.XPATH, using = ACTION_XPATH)
    public static WebElement ActionXpath;
    @FindBy(how = How.ID, using = OBJET_XPATH)
    public static WebElement objetXpath;
    @FindBy(how = How.XPATH, using = PLAN_ACTION_XPATH)
    public static WebElement palnActionXpath;
    @FindBy(how = How.ID, using = BOUTTON_AJOUTER_ACTION_ID)
    public static WebElement btnAjouterAction;
    @FindBy(how = How.ID, using = BOUTTON_AJOUTER_DETAILLEE_ACTION_ID)
    public static WebElement btnajouter_action_detaillee;
    @FindBy(how = How.ID, using = SOURCE_ID)
    public static WebElement sourceId;
    @FindBy(how = How.ID, using = Datecreation_Act_ID)
    public static WebElement Datecreation_Act;
    @FindBy(how = How.ID, using = agenda_creation_ID)
    public static WebElement agendacreation;
    @FindBy(how = How.ID, using = CALENDRIER_ID)
    public static WebElement calenrierId;
    @FindBy(how = How.ID, using = CHOIX_DATE_ID)
    public static WebElement choixDateId;
    @FindBy(how = How.ID, using = DESIGNATION_ID)
    public static WebElement designationId;

    @FindBy(how = How.ID, using = ORIGINE_ID)
    public static WebElement ORIGINEId;
    @FindBy(how = How.ID, using = AJT_PRDT_ID)
    public static WebElement AjtProdId;
    @FindBy(how = How.ID, using = CHX_PRDT_ID)
    public static WebElement ChxProdId;
    @FindBy(how = How.ID, using = VLD_PRDT_ID)
    public static WebElement VldProdId;
    @FindBy(how = How.XPATH, using = FERMER_PRDT_ID)
    public static WebElement FermerProdId;

    @FindBy(how = How.ID, using = AJT_TYP_CAUSE)
    public static WebElement AjtTypCauseId;
    @FindBy(how = How.XPATH, using = RECH_TYP_CAUSE)
    public static WebElement RechTypCauseId;
    @FindBy(how = How.ID, using = GRID_TYP_CAUSE)
    public static WebElement GridTypCauseId;
    @FindBy(how = How.ID, using = VLD_TYP_CAUSE)
    public static WebElement VldTypCauseId;
    @FindBy(how = How.XPATH, using = FERMER_TYP_CAUSE)
    public static WebElement FermerTypCauseId;

    @FindBy(how = How.ID, using = Objectif_ID)
    public static WebElement ObjectifId;
    @FindBy(how = How.ID, using = REF_AUDIT_ID)
    public static WebElement RefAuditId;

    @FindBy(how = How.ID, using = GRAVITE_ID)
    public static WebElement GraviteId;
    @FindBy(how = How.ID, using = PRIORITE_ID)
    public static WebElement PrioriteId;
    @FindBy(how = How.ID, using = COUT_PREV_SA_ID)
    public static WebElement CoutPrevId;
    @FindBy(how = How.ID, using = RISQUE_ID)
    public static WebElement RisqueId;

    @FindBy(how = How.ID, using = TYPE_ID)
    public static WebElement listeTypeId;
    @FindBy(how = How.ID, using = DESCRIPTION_OBJET_ID)
    public static WebElement descriptionObjetId;
    @FindBy(how = How.ID, using = CAUSES_POSSIBLES_ID)
    public static WebElement causesPossiblesId;
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
    @FindBy(how = How.ID, using = Resp_cloture_ID)
    public static WebElement Respcloture;
    @FindBy(how = How.ID, using = BOUTTON_VALIDER_ID)
    public static WebElement btnValiderActionId;
    @FindBy(how = How.ID, using = AGENDA_ACTION_ID)
    public static WebElement agendatActionId;
    @FindBy(how = How.XPATH, using = AGENDA_ACTION2_ID)
    public static WebElement agendatAction2Id;
    @FindBy(how = How.ID, using = BOUTTON_AJOUTER_LISTE_DES_SOUS_ACTION_ID)
    public static WebElement btnAjouterSousActionModeleAction;
    @FindBy(how = How.ID, using = DESIGNATION_SOUS_ACTION_ID)
    public static WebElement designationSousAction;

    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_LbAutreEmpRespReal")
    public static WebElement SelectresponsableRealisationID;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_TextBox38")
    public static WebElement winserRespReal;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_GridViewAutreEmpRespReal")
    public static WebElement wTabReal;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_LinkButton62")
    public static WebElement wrecher;


    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_LbRespSuiv")
    public static WebElement SelectresponsableSuviID;

    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_select_respsv0")
    public static WebElement UnSeulSelectresponsableSuviID;



    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_TextBox39")
    public static WebElement winserResSuvi;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_TextBoxSearch_AutreEmpSeulRespSuiv")
    public static WebElement winserSeulResSuvi;

    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_GridViewAutreEmpRespSuiv")
    public static WebElement wTabSuvi;

    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_GridView_AutreEmpSeulRespSuivi")
    public static WebElement wTabSeulSuvi;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_LinkButton63")
    public static WebElement wrecherSuvi;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_LinkButton61")
    public static WebElement wrecherSeulRespoSuvi;



    @FindBy(how = How.ID, using = RESPONSABLE_SUIVI_SOUS_ACTION_ID)
    public static WebElement responsableSuiviID;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_LbRespSuiv")
    public static WebElement SeulresponsableSuiviID;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_TextBox_respSuivi")
    public static WebElement SeulresponsableSuiviIDSous;


    @FindBy(how = How.ID, using = BOUTTON_VALIDER_LISTE_DES_SOUS_ACTION_ID)
    public static WebElement btnValiderSousAction;
    @FindBy(how = How.ID, using = DATE_SOUS_ACTION_ID)
    public static WebElement dateSousAction;
    @FindBy(how = How.ID, using = CHOIX_DATE_SOUS_ACTION_ID)
    public static WebElement choixDateSousAction;
    @FindBy(how = How.ID, using = délais_suivi_ID)
    public static WebElement délais_suivi;
    @FindBy(how = How.ID, using = choix_délais_suivi_ID)
    public static WebElement choix_délais_suivi;
    @FindBy(how = How.ID, using = DESIGNATION_GRID_LISTE_DES_SOUS_ACTION_ID)
    public static WebElement desgSousActionModeleAction;
    @FindBy(how = How.ID, using = GRID_ACTION_A_REALISATION_ID)
    public static WebElement gridActionRealisation;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_GridView2")
    public static WebElement WgridActionSuivi;
    @FindBy(how = How.ID, using = NUM_ACTION_A_REALISATION_ID)
    public static WebElement numActionrealisation;
    @FindBy(how = How.XPATH, using = CHOIX_NUM_ACTION_A_REALISATION_ID)
    public static WebElement choixNumActionrealisation;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_GridView1")
    public static WebElement wtabActionArealise;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_LinkButton33")
    public static WebElement wBtnVAlideSuivi;

    @FindBy(how = How.ID, using = RECHERCHER_NUM_ACTION_A_REALISATION_ID)
    public static WebElement rechercherNumActionrealisation;
    @FindBy(how = How.ID, using = TAUX_REALISATION_ID)
    public static WebElement tauxRealisation;
    @FindBy(how = How.ID, using = DEPENSES_ID)
    public static WebElement depensesID;
    @FindBy(how = How.ID, using = COMMENTAIRE_ID)
    public static WebElement commentaireID;
    @FindBy(how = How.ID, using = DATE_REALISATION_ID)
    public static WebElement dateRealisation;
    @FindBy(how = How.ID, using = SAISIE_D_REALISATION_ID)
    public static WebElement SaisieDRealisation;
    @FindBy(how = How.ID, using = CHOIX_DATE_REALISATION_ID)
    public static WebElement choixDateRealisation;
    @FindBy(how = How.ID, using = VALIDER_REALISATION_ID)
    public static WebElement validerRealisation;
    @FindBy(how = How.ID, using = NUM_ACTION_A_SUIVRE_ID)
    public static WebElement numActionSuivre;
    @FindBy(how = How.XPATH, using = CHOIX_NUM_ACTION_A_SUIVRE_ID)
    public static WebElement choixNumActionSuivre;
    @FindBy(how = How.ID, using = RECHERCHER_NUM_ACTION_A_SUIVRE_ID)
    public static WebElement rechercherNumActionSuivre;
    @FindBy(how = How.ID, using = TAUX_EFF_ID)
    public static WebElement TauxEffiID;
    @FindBy(how = How.ID, using = RAPPORT_EFF_ID)
    public static WebElement rapportEffiID;
    @FindBy(how = How.ID, using = VALIDER_SUIVI_ID)
    public static WebElement validerSuivi;
    @FindBy(how = How.XPATH, using = CHOIX_ACTION_CLOTURER_XPATH)
    public static WebElement choixActionCloturer;
    @FindBy(how = How.ID, using = CLOTUREE_ID)
    public static WebElement choixCloturee;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_RadioButtonList1")
    public static WebElement wchoixCloturee;

    @FindBy(how = How.ID, using = DATE_CLOTURE_ID)
    public static WebElement dateCloture;
    @FindBy(how = How.ID, using = CHOIX_DATE_CLOTURE_ID)
    public static WebElement choixDateCloture;
    @FindBy(how = How.ID, using = VALIDER_CLOTURE_ID)
    public static WebElement validerCloture;
    @FindBy(how = How.ID, using = CHX_APERCU_ID)
    public static WebElement ChxApercu;
    @FindBy(how = How.ID, using = VLD_Apercu_ID)
    public static WebElement validerApercu;
    @FindBy(how = How.ID, using = RECH_FILT_ID)
    public static WebElement RechFiltreId;
    @FindBy(how = How.ID, using = BTN_RECH_FILTRE_ID)
    public static WebElement BtnRechFiltId;
    @FindBy(how = How.XPATH, using = TABLE_FILTRE_ACTION_ID)
    public static WebElement TableFiltreAction;

    @FindBy(how = How.ID, using = ATT_MODELE_ID)
    public static WebElement AttModele;
    @FindBy(how = How.XPATH, using = RECH_MODELE_XPATH)
    public static WebElement RechModele;
    @FindBy(how = How.XPATH, using = CHX_MODELE_ID)
    public static WebElement ChxModele;
    @FindBy(how = How.ID, using = APERCU_ID)
    public static WebElement apercu;

    @FindBy(how = How.ID, using = AFFI_TX_REA_ID)
    public static WebElement AffTxReaId;
    @FindBy(how = How.ID, using = EDIT_TX_REA_ID)
    public static WebElement EditTxReaId;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_lb_enreg_suivi")
    public static WebElement EditTxSuiviId;
    @FindBy(how = How.XPATH, using = CHX_SA_REA_XPATH)
    public static WebElement ChxSaReaId;
    @FindBy(how = How.ID, using = NOUV_TX_REA_ID)
    public static WebElement NouvTxReaId;
    @FindBy(how = How.ID, using = NOUV_TX_REA_IDSmp)
    public static WebElement NouvTxReaIdSimpl;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_GridView4")
    public static WebElement TabSimpActReal;

    @FindBy(how = How.ID, using = COMM_NOUV_TX_ID)
    public static WebElement CommNouvTxReaId;
    @FindBy(how = How.ID, using = COMM_NOUV_TX_IDsimp)
    public static WebElement WCOMM_NOUV_TX_IDsimp;
    @FindBy(how = How.ID, using = VLD_NOUV_TAUX_REA_ID)
    public static WebElement VldNvTxReaId;
    @FindBy(how = How.ID, using = VLD_NOUV_TAUX_REA_IDsimp)
    public static WebElement VldNvTxReaIdsimp;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_juj")
    public static WebElement retourActSimp;

    @FindBy(how = How.XPATH, using = QUTT_MOD_TX_XPATH)
    public static WebElement QttModTxId;
    @FindBy(how = How.ID, using = VLD_RETOUR_ID)
    public static WebElement VldRetourId;
    @FindBy(how = How.XPATH, using = QTT_RETOUR_XPATH)
    public static WebElement QttRetourId;

    @FindBy(how = How.XPATH, using = QTT_RETOUR1_XPATH)
    public static WebElement QttRetour1Id;

    @FindBy(how = How.ID, using = TRACABILITE_ID)
    public static WebElement TracabiliteId;

    @FindBy(how = How.ID, using = EXPORTER_ID)
    public static WebElement ExporterId;

    @FindBy(how = How.XPATH, using = ACTION_A_REALISER_ID)
    public static WebElement ActionRealiserId;
    @FindBy(how = How.XPATH, using = ACTION_A_SUIVRE_ID)
    public static WebElement ActionSuivreId;

    @FindBy(how = How.XPATH, using = FILTRE_REALISE_ID)
    public static WebElement FiltreRealiseId;

    @FindBy(how = How.XPATH, using = PNL_Intervenant_ID)
    public static WebElement PanelIntervId;
    @FindBy(how = How.ID, using = AJT_INTER_ID)
    public static WebElement AjtIntervId;
    @FindBy(how = How.XPATH, using = RECH_INTER_ID)
    public static WebElement RechInetervId;
    @FindBy(how = How.XPATH, using = CHX_INTER_ID)
    public static WebElement ChxIntervId;
    @FindBy(how = How.ID, using = VLD_INTER_ID)
    public static WebElement VldIntervId;


}
