package com.saphir.platforme.utils;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    protected abstract void startService();

    protected abstract void stopService();

    protected abstract void createDriver() throws InterruptedException;

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }

    }

    public WebDriver getDriver() throws InterruptedException {
        if (null == driver) {
            startService();
            createDriver();
        }
        return driver;
    }
}
