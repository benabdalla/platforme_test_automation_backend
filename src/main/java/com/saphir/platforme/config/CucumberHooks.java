package com.saphir.platforme.config;

import com.saphir.platforme.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.BeforeMethod;

public class CucumberHooks {
//
//    private ScreenshotUtil screenshotUtil;
//
//
//    private ApplicationContext applicationContext;
//    public static WebDriver driver;
//    @BeforeMethod
//    public void beforeMethod(){
//        if (System.getenv("CLOUD_RUN_FLAG") == null) {
//            WebDriverManager.chromedriver().setup();
//            driver=new ChromeDriver();
//
//        } else {
//            WebDriverManager.chromedriver().setup();
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--no-sandbox");
//            options.addArguments("--headless");
//            driver= new ChromeDriver(options = options);
//        }
//    }
//
//
//
//    @AfterStep
//    public void afterStep(Scenario scenario){
//        if(scenario.isFailed()){
//            scenario.attach(this.screenshotUtil.getScreenshot(), "image/png", scenario.getName());
//        }
//    }
//
//    @After
//    public void afterScenario(){
//        this.applicationContext.getBean(WebDriver.class).quit();
//    }

}