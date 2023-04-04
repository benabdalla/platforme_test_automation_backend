package com.saphir.platforme.config;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
@Profile("!remote")
@Component// to avoid loading for remote runs
public class WebDriverConfig {
public static WebDriver driver;
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    public WebDriver edgeDriver() {
        // this is the bean class for edge driver

        if (System.getenv("CLOUD_RUN_FLAG") == null) {
            WebDriverManager.edgedriver().setup();
        }
        return new EdgeDriver();
    }

    @Bean
    // @Primary // this will be the default browser
    @ConditionalOnMissingBean // to catch invalid browser values
    @Scope("browserscope")
    // use custom scope
    public WebDriver chromeDriver() {
        // this is the bean class for chrome driver

        if (System.getenv("CLOUD_RUN_FLAG") == null) {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
           return driver;
        } else {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
            driver=new ChromeDriver(options = options);
            return driver;
            //return new ChromeDriver(options = options);
        }
    }


}
