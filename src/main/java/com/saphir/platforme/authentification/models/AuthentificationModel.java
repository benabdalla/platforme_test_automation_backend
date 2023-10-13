package com.saphir.platforme.authentification.models;


import com.saphir.platforme.authentification.pages.AuthentificationPage;
import com.saphir.platforme.entity.Utilisateur;
import com.saphir.platforme.repository.UtilisateurQualiproRepository;
import com.saphir.platforme.utils.ExcelUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class AuthentificationModel {
    private static UtilisateurQualiproRepository utilisateurQualiproRepository;
    private static final String Path = "src/main/resources/testData/TestData.xlsx";


    @Autowired
    public AuthentificationModel(UtilisateurQualiproRepository utilisateurQualiproRepository) {
        AuthentificationModel.utilisateurQualiproRepository = utilisateurQualiproRepository;
    }
    public static void saisirLogin(String login) throws Exception {
        Thread.sleep(500);
//        ExcelUtils.setExcelFile(Path, "Input");
        // String login = ExcelUtils.getCellData(RowNum, RowCol);
        System.err.println("login " + login);
        Thread.sleep(500);

        AuthentificationPage.loginID.clear();
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
        AuthentificationPage.motDePasse.clear();
        AuthentificationPage.motDePasse.sendKeys(password);
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("arguments[1].value = arguments[0];", password, AuthentificationPage.motDePasse);


    }

    public static void clickOuvrirSession(WebDriver driver) throws Exception {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", AuthentificationPage.Valider);


        Thread.sleep(5000L);
    }

    public static void Changer_Compte(String username, WebDriver driver) throws Exception {
        Thread.sleep(500);
        Utilisateur user = utilisateurQualiproRepository.findByName(username);
        saisirLogin(user.getLogin());
        saisirPW(user.getPassword());
        Thread.sleep(2000L);
        clickOuvrirSession(driver);
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
