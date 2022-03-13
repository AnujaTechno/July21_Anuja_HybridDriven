package com.technocredits.Assignment14.testscripts;

import org.testng.asserts.SoftAssert;

import com.technocredits.Assignment14.base.PredefinedActions;
import com.technocredits.Assignment14.pages.MenuPage;
import com.technocredits.orghrm.pages.LoginPage;

public class TestBase extends PredefinedActions {
	
	SoftAssert softAssert=new SoftAssert();
	public MenuPage setup() {
		System.out.println("Launch OrgHRM Application");
		PredefinedActions.start();
		System.out.println("Verify Logo displayed on Login Page");
		LoginPage loginPage=new LoginPage();
		loginPage.enterCredentials("Admin", "1V@Ph1laXC");
		System.out.println("Click on Login button");
		return loginPage.clickOnLoginButton();
	}
	
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}
}
