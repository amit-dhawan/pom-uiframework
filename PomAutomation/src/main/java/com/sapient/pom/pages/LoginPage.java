package com.sapient.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterCredentials(String username, String password) throws InterruptedException {

		WebElement txtBox_email = driver.findElement(By.xpath("//input[@name='username']"));

		WebElement txtBox_pswrd = driver.findElement(By.xpath("//input[@name='password']"));

		txtBox_email.sendKeys(username);

		txtBox_pswrd.sendKeys(password);

	}

	public void clickOnMyAccountAndLogin() {

		WebElement btn_myAccount = driver.findElement(By.xpath("//a[contains(.,'My Account')]"));
		btn_myAccount.click();

		WebElement link_Login = driver.findElement(By.xpath("//a[text()='Login']"));
		link_Login.click();

	}

	public void clickOnLoginButton() {

		WebElement btn_Login = driver.findElement(By.xpath("//button[text()='Login']"));
		btn_Login.click();

	}

}
