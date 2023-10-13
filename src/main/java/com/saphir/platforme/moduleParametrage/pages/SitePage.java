package com.saphir.platforme.moduleParametrage.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SitePage {
    @FindBy(id = "ctl00_ContentPlaceHolder1_Ajouter")
    public static WebElement btnAjout;
    @FindBy(id = "ctl00_ContentPlaceHolder1_TextBox2")
    public static WebElement textSite;
    @FindBy(id = "ctl00_ContentPlaceHolder1_textboxAbrev")
    public static WebElement textAbrevation;
    @FindBy(id = "ctl00_ContentPlaceHolder1_TextBox_abrev")
    public static WebElement directionAbrevation;

    @FindBy(id = "ctl00_ContentPlaceHolder1_TextBox_abrev")
    public static WebElement textAbrevationService;

    @FindBy(id = "ctl00_ContentPlaceHolder1_TextBox3")
    public static WebElement textAbrevationActivite;

    @FindBy(id = "ctl00_ContentPlaceHolder1_LinkButton11")
    public static WebElement btnValider;
    @FindBy(id = "ctl00_ContentPlaceHolder1_LinkButton12")
    public static WebElement btnRetour;

}
