package com.saphir.platforme.utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;

public class ChromeDriverManager extends DriverManager {

    private ChromeDriverService chService;

    @Override
    public void startService() {
        if (null == chService) {
            try {
                chService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File("resources/DriversExecutables/chromedriver.exe"))
                        .usingAnyFreePort().build();
                chService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != chService && chService.isRunning())
            chService.stop();
    }

    @Override
    public void createDriver() {
        String downloadFilepath = "E:\\qualipro\\trunk\\AutomatisationTQualiPro_prod231\\resources\\Telechargement";

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.default_directory", downloadFilepath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-features=VizDisplayCompositor");
        options.addArguments("--start-maximized");
        HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();

        options.setExperimentalOption("prefs", chromePrefs);

        options.addArguments("--test-type");

//        DesiredCapabilities cap = chrome();
//
//        cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
//
//        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//
//        cap.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(chService);
        // Dimension d = new Dimension(1500,860);
        //Resize the current window to the given dimension
        //driver.manage().window().setSize(d);
        driver.manage().window().maximize();
    }

}
