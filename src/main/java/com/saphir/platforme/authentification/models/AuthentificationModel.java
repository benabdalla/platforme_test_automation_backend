package com.saphir.platforme.authentification.models;


import com.saphir.platforme.authentification.pages.AuthentificationPage;
import com.saphir.platforme.utils.ExcelUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;



@Component
public class AuthentificationModel {



//    public static List<Action> actionList;
//    public static List<Parametrage> parametrageList;
//    @Autowired
//    ParametrageService parametrageService;
//    @Autowired
//    ActionService actionService;
//    @Autowired
//    AuthentificationQualipro authentificationQualipro;
//    List<ConnexionDTO> connexionDTOList;

    /* Public methods */
    private static String Path = "src/main/resources/testData/TestData.xlsx";


//AuthentificationQualipro authentificationQualipro;

    public static  void ouvrirQualiProWeb(WebDriver driver) throws Throwable {
//        ExcelUtils.setExcelFile(Path, "Input");
//        lan="fr";
//        //	logger.info("Begin : Ouvrir l'application QualiProWeb ");
//        System.err.println("site = " + ExcelUtils.getCellData(1, 0));
//        driver.get(ExcelUtils.getCellData(1, 0));
//        Thread.sleep(1000L);
//        System.out.println("lang :  " + lan);
//        Cookie cookie = new Cookie("lan", lan);
//        driver.manage().addCookie(cookie);
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        String txt="document.cookie=\'lan="+lan+"\'";
//        jse.executeScript(txt);
//        System.out.println(driver.manage().getCookieNamed("lan").getValue());
    }

    public static void saisirLogin(String login) throws Exception {
        Thread.sleep(500);
//        ExcelUtils.setExcelFile(Path, "Input");
        // String login = ExcelUtils.getCellData(RowNum, RowCol);
        System.err.println("login " + login);
        Thread.sleep(500);

        AuthentificationPage.loginID.sendKeys(login);
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[1].value = arguments[0];", login, AuthentificationPage.loginID);

    }

    public static void saisirLogin1(String id) {
        AuthentificationPage.loginID.sendKeys(id);

    }

    public static void sasirpw1(String id) {
        AuthentificationPage.motDePasse.sendKeys(id);

    }

    public static void saisirPW(String password) throws Exception {
//        ExcelUtils.setExcelFile(Path, "Input");
//        String password = ExcelUtils.getCellData(RowNum, RowCol);
        System.err.println("password " + password);
        Thread.sleep(500);
        AuthentificationPage.motDePasse.sendKeys(password);
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[1].value = arguments[0];", password, AuthentificationPage.motDePasse);


    }

    public static void clickOuvrirSession(WebDriver driver) throws Exception {

JavascriptExecutor jse=(JavascriptExecutor)driver;
  jse.executeScript("arguments[0].click()", AuthentificationPage.Valider);
        //AuthentificationPage.Valider.click();

        Thread.sleep(5000L);
    }

    public static void Changer_Compte(String username, WebDriver driver) throws Exception {
        Thread.sleep(500);


        ExcelUtils.setExcelFile(Path, "Input");
        //String NewUser="nada";
        int RowNum = ExcelUtils.GetLigneData(username);
        System.out.println("num ligne " + RowNum);
        //saisirLogin(RowNum, 2);
       // saisirPW(RowNum, 3);
        Thread.sleep(2000L);
        clickOuvrirSession(driver);
        Thread.sleep(5000L);
    }

    public static void Changer_Compte(String module, String col, int row, WebDriver driver) throws Exception {



        ExcelUtils.setExcelFile(Path, module);
        String username ="test";
                //ExcelUtils.getCellData(row, col);
        System.err.println("user name  is   :  " +username);
        if (!(username.equals(""))) {
            ExcelUtils.setExcelFile(Path, "Input");
            int RowNum = ExcelUtils.GetLigneData(username);
            //System.out.println("num ligne"+RowNum);
            //saisirLogin(RowNum, 2);
          //  saisirPW(RowNum, 3);
            clickOuvrirSession(driver);
        }
        Thread.sleep(5000L);
    }

    public static void changer_langue() throws Throwable {
        AuthentificationPage.utilitaireID.click();
        AuthentificationPage.personnalisationId.click();
        AuthentificationPage.englisId.click();
        Thread.sleep(1000);
        AuthentificationPage.valider_Langue.click();
        Thread.sleep(1000);
        AuthentificationPage.HOMEID.click();
        Thread.sleep(1000);

    }


}
