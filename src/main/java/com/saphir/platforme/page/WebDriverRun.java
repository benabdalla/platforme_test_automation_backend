package com.saphir.platforme.page;


import com.saphir.platforme.annotation.Page;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;

// this is the main page class that uses search componet and search results componet
@Page // using custom annotation created; src/main/java/com/demo/seleniumspring/annotation/Page.java
public class WebDriverRun extends Base {



    @Value("${application.url}")
    private String url;

    //launch website
    public WebDriver getWebDriver(){
        //this.driver.get(url);
        return driver;
    }


}
