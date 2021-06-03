package com.sapient.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserPage {

	WebDriver driver;
	
	public UserPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isUserHeadingPresent() {
		WebElement heading_username = driver.findElement(By.xpath("//h3[text()='Hi, Kate S']"));

		return heading_username.isDisplayed();

	}

}
