package com.saphir.platforme.authentification.stepdefs;



import com.saphir.platforme.authentification.models.AuthentificationModel;
import com.saphir.platforme.authentification.pages.AuthentificationPage;

import com.saphir.platforme.utils.ExcelUtils;
import com.saphir.platforme.utils.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.concurrent.TimeUnit;

import static com.saphir.platforme.moduleAction.stepdefs.ReportingStepDef.lan;


public class AuthentificationStepDefinition  {


    //	protected static final Logger logger = LoggerFactory.getLogger(AbstractPage.class);
    private static String Path = "src/main/resources/testData/TestData.xlsx";

    public int row = 1;
    public String module = "Action";



    WebDriver driver;

    // @PostConstruct
    public AuthentificationStepDefinition() {
        driver = Setup.driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, AuthentificationPage.class);
      //  PageFactory.initElements(this.driver, this);
     //   driver.manage().window().maximize();
    }

    @Given("^Ouvrir le site QualiProWeb$")
    public void ouvrirQualiProWeb() throws Throwable {

        ExcelUtils.setExcelFile(Path, "Input");
        lan="fr";
        //	logger.info("Begin : Ouvrir l'application QualiProWeb ");
        System.err.println("site = " + ExcelUtils.getCellData(1, 0));
        driver.get(ExcelUtils.getCellData(1, 0));
        Thread.sleep(1000L);
        System.out.println("lang :  " + lan);
        Cookie cookie = new Cookie("lan", lan);
        driver.manage().addCookie(cookie);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        String txt="document.cookie=\'lan="+lan+"\'";
        jse.executeScript(txt);
        System.out.println(driver.manage().getCookieNamed("lan").getValue());


        //   AuthentificationModel.ouvrirQualiProWeb(driver);
    }

    @When("^saisir Login et PW$")
    public void saisirLoginPW() throws Throwable {
        //logger.info("saisi login et mot de passe");
        AuthentificationModel.saisirLogin(1, 2);

        Thread.sleep(200L);
        AuthentificationModel.saisirPW(1, 3);
        Thread.sleep(200L);

    }

    @When("saisir Login et PW1")


    @When("^saisir Login \"([^\"]*)\"$")
    public void saisir_Login(String arg1) throws Throwable {
        AuthentificationModel.saisirLogin1(arg1);
        Thread.sleep(200L);
    }

    @When("^saisir password \"([^\"]*)\"$")
    public void saisir_password(String arg1) throws Throwable {
        AuthentificationModel.sasirpw1(arg1);
        Thread.sleep(200L);
    }

    @When("^cliquer sur ouvrir une session$")
    public void clickOuvrirSession() throws Throwable {
        //	logger.info("click sur ouvrir une session");
        AuthentificationModel.clickOuvrirSession(driver);

        Thread.sleep(2000L);

    }

    @When("^Connecter en tant que (\\d+) de l (\\d+) du \"([^\"]*)\"$")
    public void connecter_en_tant_que_de_l_du(int arg1, int arg2, String arg3) throws Throwable {
        row = arg2;
        AuthentificationModel.Changer_Compte(arg3, arg1, arg2, driver);
        module = arg3;
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