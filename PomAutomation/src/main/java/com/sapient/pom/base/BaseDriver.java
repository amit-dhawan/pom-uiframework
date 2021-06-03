package com.sapient.pom.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.sapient.pom.utilities.Utilities;

public class BaseDriver {

	public WebDriver driver;

	@BeforeSuite
	public void startUp() throws IOException, InterruptedException {

		Utilities util = new Utilities();
		driver = util.launchDriver();
		driver.get(util.getPropertyValue("url"));
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


	}

	@AfterSuite
	public void cleanUp() {
		if (driver != null) {
			driver.quit();
		}
	}

}
