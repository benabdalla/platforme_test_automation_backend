package com.saphir.platforme.authentification.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AuthentificationPage {



    /* Locators */

    final static String LOGIN_ID = "Text_Login";
    final static String MOT_DE_PASSE_ID = "Text_Motpass";
    final static String OUVRIR_SESSION = "Valider";
    final static String SESSION_TITLE = "//*[@id=\"ctl00_nom_emp_connected\"]";
    final static String utilitaire = "ctl00_lnk_utilitaire";
    final static String personnalisation = "ctl00_ContentPlaceHolder1_linkbutton_personnalisés";
    final static String english_ID = "ctl00_ContentPlaceHolder1_rbl_langue_1";
    final static String VLD_LANGUE = "ctl00_ContentPlaceHolder1_Button2";
    final static String Home = "ctl00_image2";


    /* @FindBy */


    @FindBy(how = How.ID, using = LOGIN_ID)
    public static WebElement loginID;

    @FindBy(how = How.ID, using = MOT_DE_PASSE_ID)
    public static WebElement motDePasse;

    @FindBy(how = How.ID, using = OUVRIR_SESSION)
    public static WebElement Valider;

    @FindBy(how = How.ID, using = SESSION_TITLE)
    public static WebElement sessionTitle;

    @FindBy(how = How.ID, using = utilitaire)
    public static WebElement utilitaireID;
    @FindBy(how = How.ID, using = personnalisation)
    public static WebElement personnalisationId;
    @FindBy(how = How.ID, using = english_ID)
    public static WebElement englisId;
    @FindBy(how = How.ID, using = VLD_LANGUE)
    public static WebElement valider_Langue;
    @FindBy(how = How.ID, using = Home)
    public static WebElement HOMEID;


}
