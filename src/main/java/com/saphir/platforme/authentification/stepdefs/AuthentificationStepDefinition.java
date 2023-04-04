package com.saphir.platforme.authentification.stepdefs;


import com.saphir.platforme.authentification.models.AuthentificationModel;
import com.saphir.platforme.authentification.pages.AuthentificationPage;
import com.saphir.platforme.config.CucumberHooks;
import com.saphir.platforme.config.WebDriverConfig;
import com.saphir.platforme.dto.ConnexionDTO;
import com.saphir.platforme.entity.Action;
import com.saphir.platforme.entity.Parametrage;
import com.saphir.platforme.entity.UtilisateurQualipro;
import com.saphir.platforme.page.WebDriverRun;
import com.saphir.platforme.service.AuthentificationQualipro;
import com.saphir.platforme.service.ParametrageService;
import com.saphir.platforme.service.ActionService;
import com.saphir.platforme.service.UtilisateurService;
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

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.saphir.platforme.moduleAction.stepdefs.ReportingStepDef.lan;


public class AuthentificationStepDefinition  {


    //	protected static final Logger logger = LoggerFactory.getLogger(AbstractPage.class);
    private static String Path = "src/main/resources/testData/TestData.xlsx";

    public int row = 1;
    public String module = "Action";
    static  WebDriver driver;
    public static List<Parametrage> parametrageList;
    @Autowired
    ParametrageService parametrageService;

    @PostConstruct
    public void init() throws IOException, InterruptedException {
//        Setup setup =new Setup();
//       driver=setup.setup("CHROME");
        driver=Setup.driver;
        parametrageList=parametrageService.getAllParametere();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, AuthentificationPage.class);
        PageFactory.initElements(this.driver, this);
    }

    @Given("^Ouvrir le site QualiProWeb$")
    public void ouvrirQualiProWeb() throws Throwable {


        ExcelUtils.setExcelFile(Path, "Input");
        lan = parametrageList.get(0).getVerssion();
        //	logger.info("Begin : Ouvrir l'application QualiProWeb ");
        System.err.println("site = " + parametrageList.get(0).getUrl());
        //ExcelUtils.getCellData(1, 0)
        driver.get(parametrageList.get(0).getUrl());
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
       // AuthentificationModel.saisirLogin(1, 2);

        Thread.sleep(200L);
      //  AuthentificationModel.saisirPW(1, 3);
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
    public void connecter_en_tant_que_de_l_du(String arg1, int arg2, String arg3) throws Throwable {
//        row = arg2;
//       // ExcelUtils.setExcelFile(Path, module);
//        String username ="test";
//        //ExcelUtils.getCellData(row, col);
//       //=authentificationQualipro.connextionParModule(arg3,arg1,arg2);
//        System.err.println("login  :  " +connexionDTOList.get(0).getLogin());
//        System.err.println("password  :  " +connexionDTOList.get(0).getPassword());
//
////        System.err.println("user name  is   :  " +username);
////        if (!(username.equals(""))) {
////            ExcelUtils.setExcelFile(Path, "Input");
////            int RowNum = ExcelUtils.GetLigneData(username);
//            //System.out.println("num ligne"+RowNum);
//            AuthentificationModel.saisirLogin(connexionDTOList.get(0).getLogin());
//            AuthentificationModel.saisirPW(connexionDTOList.get(0).getPassword());
//            AuthentificationModel.clickOuvrirSession(driver);
//       // }
//        Thread.sleep(5000L);
//
//                    //AuthentificationModel.Changer_Compte(arg3, arg1, arg2, driver);
//        module = arg3;
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
