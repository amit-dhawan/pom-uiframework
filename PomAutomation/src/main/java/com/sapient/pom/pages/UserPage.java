package com.sapient.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {

@FindBy(xpath = "//h3[contains(text(), 'Neo')]")
private WebElement heading_username;
	public UserPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean isUserHeadingPresent() {
		return heading_username.isDisplayed();

	}

}
