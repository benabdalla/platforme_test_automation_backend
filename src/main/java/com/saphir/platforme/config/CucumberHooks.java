package com.saphir.platforme.config;

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