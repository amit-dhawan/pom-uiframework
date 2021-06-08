package com.sapient.pom.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.yaml.snakeyaml.parser.ParserImpl;

public class Utilities {

	public static WebDriver driver;
	final String CHROME_PROPERTY = "webdriver.chrome.driver";
	final String CHROME_DRIVERPATH = "resources/drivers/chromedriver";

	public WebDriver launchDriver() {
		System.setProperty(CHROME_PROPERTY, CHROME_DRIVERPATH);
		driver = new ChromeDriver();
		return driver;

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

	public void getScreenshot(WebDriver driver, String methodName) {
		try {

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot,
					new File("output/screenshots/" + methodName + "_" + getCurrentDateTime() + ".png"));

		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

	public String getCurrentDateTime() {
		LocalDate dt = LocalDate.now();
		String time = String.valueOf(LocalTime.now().toSecondOfDay());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd");
		String formatted = dt.format(formatter);
		formatted = formatted + "_" + time;
		System.out.println(formatted);

		return formatted;

	}

}
