package com.sapient.pom.utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utilities {

	final String CHROME_PROPERTY = "webdriver.chrome.driver";
	final String CHROME_DRIVERPATH = "resources/drivers/chromedriver";

	public WebDriver launchDriver() {
		
		System.setProperty(CHROME_PROPERTY, CHROME_DRIVERPATH);
		return new ChromeDriver();

	}

	
	
	public String getPropertyValue(String key) throws IOException {
		String value = "";
		String filePath = "resources/config/config.properties";
		FileReader reader = new FileReader(filePath);
		Properties prop = new Properties();

		prop.load(reader);

		try {
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			reader.close();
		}

		return value;
	}

}
