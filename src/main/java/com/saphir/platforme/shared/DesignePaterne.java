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

        boolean verif = false, verif2 = false;
        String text = "";
        int size = 0;
        WebElement champ = driver.findElement(By.id(idchamp));
        WebElement btnrechrech = driver.findElement(By.id(idBtnRechrech));
        WebElement grid = driver.findElement(By.id(idGrid));
        champ.clear();
        champ.sendKeys(mots);
        Thread.sleep(1000);
        btnrechrech.click();

        mots = mots.replaceAll("\\s+", " ");

        try {
            size = driver.findElement(By.id(idGrid)).findElements(By.tagName("tr")).size();
            verif2 = true;
        } catch (NoSuchElementException exp) {
            verif2 = false;
        }
        mots = removeTrailingSpaces(mots);
        if (verif2) {
            for (int i = 1; i <= size; i++) {
                try {
                    //*[@id="ctl00_ContentPlaceHolder1_GridView1"]/tbody
                    text = driver.findElement(By.id(idGrid)).findElement(By.xpath("//*[@id=" + "'" + idGrid + "'" + "]/tbody/tr[" + i + "]/td[2]")).findElement(By.tagName("a")).getText().replaceAll("\\s+", " ");
                    ;
                    text = removeTrailingSpaces(text);
                    verif = text.equals(mots);
                    if (verif) {
                        break;
                    }
                } catch (NoSuchElementException exp) {
                    verif = false;
                }

            }
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

    public static String removeTrailingSpaces(String input) {
        int endIndex = input.length() - 1;

        // Find the index of the last non-space character
        while (endIndex >= 0 && Character.isWhitespace(input.charAt(endIndex))) {
            endIndex--;
        }

        // If all characters are spaces, return an empty string
        if (endIndex < 0) {
            return "";
        }

        // Return the substring without trailing spaces
        return input.substring(0, endIndex + 1);
    }
}
