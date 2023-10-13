package com.saphir.platforme.authentification.stepdefs;


import com.saphir.platforme.authentification.models.AuthentificationModel;
import com.saphir.platforme.authentification.pages.AuthentificationPage;
import com.saphir.platforme.dto.ParametrageDto;
import com.saphir.platforme.service.ParametrageService;
import com.saphir.platforme.utils.ExcelUtils;
import com.saphir.platforme.utils.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class AuthentificationStepDefinition {


    //	protected static final Logger logger = LoggerFactory.getLogger(AbstractPage.class);
    private static final String Path = "src/main/resources/testData/TestData.xlsx";
    public static List<ParametrageDto> parametrageList;
    public static String lan = "";
    static WebDriver driver;
    public int row = 1;
    public String module = "Action";
    @Autowired
    ParametrageService parametrageService;

    @PostConstruct
    public void init() throws IOException, InterruptedException {
//        Setup setup =new Setup();
//       driver=setup.setup("CHROME");
        driver = Setup.driver;
        parametrageList = parametrageService.getAllParametrage();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, AuthentificationPage.class);
        PageFactory.initElements(driver, this);
    }

    @Given("^Ouvrir le site QualiProWeb$")
    public void ouvrirQualiProWeb() throws Throwable {
        System.err.println("site = " + parametrageList.get(0).getUrl());
        ExcelUtils.getCellData(1, 0);
        driver.get(parametrageList.get(0).getUrl());
        Thread.sleep(1000L);
        lan = parametrageList.get(0).getVerssion();
        System.out.println("lang :  " + lan);
        Cookie cookie = new Cookie("lan", lan);
        try{
        driver.manage().addCookie(cookie);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String txt = "document.cookie='lan=" + lan + "'";
        jse.executeScript(txt);
        System.out.println(driver.manage().getCookieNamed("lan").getValue());}catch (NoSuchSessionException exp){

        }


        //   AuthentificationModel.ouvrirQualiProWeb(driver);
    }


    @When("^cliquer sur ouvrir une session$")
    public void clickOuvrirSession() throws Throwable {
        //	logger.info("click sur ouvrir une session");
        AuthentificationModel.clickOuvrirSession(driver);

        Thread.sleep(2000L);

    }



    @And("^changer la langue en anglais$")
    public void changer_la_langue_en_anglais() throws Throwable {
        AuthentificationModel.changer_langue();
    }

    @Then("^redirection vers compte$")
    public void redirectionCompte() throws Throwable {

        //	logger.info("redirection vers compte");

        System.out.println("Connexion reussite");
    }

}
