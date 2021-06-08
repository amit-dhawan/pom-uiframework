package com.sapient.pom.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sapient.pom.base.BaseDriver;
import com.sapient.pom.pages.LoginPage;
import com.sapient.pom.pages.UserPage;
import com.sapient.pom.utilities.Utilities;

public class Test_LoginPage extends BaseDriver {

	@Test
	public void testLoginPage() throws IOException, InterruptedException {		
		Utilities util = new Utilities();
		LoginPage lp = new LoginPage(driver);
		UserPage up = new UserPage(driver);

		lp.clickOnMyAccountAndLogin();
		lp.enterCredentials(util.getPropertyValue("email"), util.getPropertyValue("password"));
		lp.clickOnLoginButton();
		boolean headingPresent = up.isUserHeadingPresent();
		
		Assert.assertTrue(false, "Hi Neo - heading text should be present");

	}

}
