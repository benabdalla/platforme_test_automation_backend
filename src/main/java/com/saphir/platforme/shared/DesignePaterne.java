package com.saphir.platforme.shared;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import static com.saphir.platforme.utils.Setup.driver;

public class DesignePaterne {

    public static void getOptiontext(WebElement element) {
        Select select = new Select(element);
        List<WebElement> options = element.findElements(By.tagName("option"));
        Random random = new Random();
        int randomNumber = random.nextInt(options.size());
        options.get(randomNumber).getText();
        select.selectByVisibleText(options.get(randomNumber).getText());
    }

    public static void selectFilaile(String filaile, WebDriver driver) throws InterruptedException {
        if (!filaile.equals("Mono")) {
            Thread.sleep(2000);
            Select selectOpTGF = new Select((driver.findElement(By.id("ctl00_DDLFiliale"))));
            switch (filaile) {
                case "Group":
                    selectOpTGF.selectByValue("0");
                    break;
                case "Filiale 1":
                    selectOpTGF.selectByValue("1");
                    break;
                case "Filiale 2":
                    selectOpTGF.selectByValue("2");
                    break;
                default:

                    // Print statement corresponding case
                    System.out.println("no match");

            }


        }
    }

    public static boolean verfierAjoute(String idchamp, String idBtnRechrech, String idGrid, String mots, WebDriver driver) throws InterruptedException {
        WebElement champ = driver.findElement(By.id(idchamp));
        WebElement btnrechrech = driver.findElement(By.id(idBtnRechrech));
        WebElement grid = driver.findElement(By.id(idGrid));
        champ.clear();
        champ.sendKeys(mots);
        Thread.sleep(1000);
        btnrechrech.click();
        boolean verif = false;

        try {
            String text = driver.findElement(By.id(idGrid)).findElement(By.xpath("//*[@id=" + "'" + idGrid + "'" + "]/tbody/tr[1]/td[2]")).findElement(By.tagName("a")).getText();
            verif = text.equals(mots);
        } catch (NoSuchElementException exp) {
            verif = false;
        }
        return verif;

    }

    public static void waitForVisibility(WebElement element, WebDriver driver1) throws Error {
        new WebDriverWait(driver1, 60).until(ExpectedConditions.visibilityOf(element));
    }

    public static void javaScriptExcuptor(WebElement elm) throws InterruptedException {
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click()", elm);
        Thread.sleep(1000);
    }

    public static void javascriptSendKyes(String str, WebElement elm) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[1].value = arguments[0];", str, elm);

    }


}
