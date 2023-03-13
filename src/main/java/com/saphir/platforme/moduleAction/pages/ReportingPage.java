package com.saphir.platforme.moduleAction.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ReportingPage {

    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_ListBox1")
    public static WebElement wsite;

    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_lBService_")
    public static WebElement wservice;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_DropDownList_PFiltre")
    public static WebElement wproirite;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_DropDownList_GFiltre")
    public static WebElement wgravite;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_TextBox1")
    public static WebElement wdate1;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_TextBox3")
    public static WebElement wdate2;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_Button1")
    public static WebElement wselectProduit;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_TextBox33")
    public static WebElement wrecherech;

    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_LinkButton44")
    public static WebElement wbtnrecherech;

    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_GridPRODUIT")
    public static WebElement wtabProd;

    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_TextBox33")
    public static WebElement wrecherRespo;

    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_S_client")
    public static WebElement wbtnRespo;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_LinkButton44")
    public static WebElement wbtnrecherRespo;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_G4")
    public static WebElement wtabRespo;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_RadioButtonList_Avancement")
    public static WebElement wRegroupEtaAction;
    @FindBy(how = How.ID, using = "ctl00_ContentPlaceHolder1_TextBox_Annee")
    public static WebElement wAnnee;









}
