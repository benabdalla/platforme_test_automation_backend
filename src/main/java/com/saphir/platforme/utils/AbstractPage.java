package com.saphir.platforme.utils;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

    //public static final String DATE_FORMAT_IN_GUI = "yyyy-MM-dd";
    //protected static final Logger logger = LoggerFactory.getLogger(AbstractPage.class);

    public static WebDriver driver;
    public static boolean bResult;

    public AbstractPage(WebDriver driver) {
        AbstractPage.driver = driver;
        AbstractPage.bResult = true;
    }

}
