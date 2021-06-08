package com.sapient.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath = "//input[@name='username']")
	private WebElement txtBox_email;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement txtBox_pswrd;
	@FindBy(xpath = "//a[contains(.,'My Account')]")
	private WebElement btn_myAccount;
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement link_Login;
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement btn_Login;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterCredentials(String username, String password) throws InterruptedException {
		txtBox_email.sendKeys(username);
		txtBox_pswrd.sendKeys(password);
	}

	public void clickOnMyAccountAndLogin() {
		btn_myAccount.click();
		link_Login.click();
	}

	public void clickOnLoginButton() {
		btn_Login.click();
	}

}
