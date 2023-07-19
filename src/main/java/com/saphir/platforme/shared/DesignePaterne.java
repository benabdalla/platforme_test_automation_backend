package com.saphir.platforme.shared;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class DesignePaterne {

    public static void getOptiontext(WebElement element) {
        Select select = new Select(element);
        List<WebElement> options = element.findElements(By.tagName("option"));
        Random random = new Random();
        int randomNumber = random.nextInt(options.size());
        options.get(randomNumber).getText();
        select.selectByVisibleText(options.get(randomNumber).getText());
    }


}
