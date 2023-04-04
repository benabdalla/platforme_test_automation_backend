package com.saphir.platforme.utils;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class Setup {

	public static WebDriver driver;
	public static String browsername;
	static DriverManager driverManager;


	/**
	 * Call Browser
	 */
	@Before
	public void before(io.cucumber.java.Scenario scenario) throws IOException, InterruptedException {
		System.err.println("Browser name in @BeforeClass is" + browsername);
		browsername="CHROME";
		if(browsername.equals("CHROME")) {
			driverManager = DriverManagerFactory.getManager(DriverType.CHROME);}
		else if(browsername.equals("FireFox"))
		{
			driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
		}else if(browsername.equals("IE"))
		{
			driverManager = DriverManagerFactory.getManager(DriverType.IE);
		}else if(browsername.equals("OPERA"))
		{
			driverManager = DriverManagerFactory.getManager(DriverType.OPERA);
		}
		//driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
		//System.out.println("driver manager Started");
		 driver = driverManager.getDriver();

		//System.out.println("Get driver Started");

	}



@After
	public void after(io.cucumber.java.Scenario scenario) throws InterruptedException {
		int i = 0;
		String screenshotName = "";

		if (scenario.isFailed()) {
//			i = i + 1;
//			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//			Date d = new Date();
//			SimpleDateFormat formatter = new SimpleDateFormat("E dd MMM HH:mm:ss z yyyy");
//			String strDate = formatter.format(d);
//			screenshotName = scenario.getName() +".jpg";



					System.out.println("This will run after the Scenario");

							TakesScreenshot ts = (TakesScreenshot) driver;
			Thread.sleep(1000);
					byte[] screenshot =ts.getScreenshotAs (OutputType.BYTES);
					Thread.sleep(1000);
			scenario.attach(screenshot, "image/png", scenario.getName());
					//

//					jelse (
//							TakesScreenshot ts (TakesScreenshot) driver;
//					byte[] screenshot . ts.getScreenshotAs(utputType.BYTES);
//					sc.attach(screenshot, "image/png", "Screenshot attached");


//					try {
//				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/target/" + screenshotName));
//			} catch (IOException e) {
//				e.printStackTrace();
//
//			}
		}
		else {
			driver.quit();
			//driver.close();

		}



	}


}