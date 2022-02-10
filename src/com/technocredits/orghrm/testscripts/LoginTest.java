package com.technocredits.orghrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.LoginPage;

public class LoginTest {
	SoftAssert softAssert=new SoftAssert();
	public void setUp() {
		PredefinedActions.start();
	}
	
	@Test
	public void loginTest() {
		//PredefinedActions p=new PredefinedActions();
				System.out.println("Launch OrgHRM Application");
				PredefinedActions.start();

				System.out.println("Verify Logo displayed on Login Page");
				LoginPage loginPage=new LoginPage();
				boolean isLogoDisplayed=loginPage.isLogoDisplayed();
				softAssert.assertTrue(isLogoDisplayed,"Logo was not displayed on Login Page");

				System.out.println("Verify Login Panel displayed on Login Page");
				boolean isLoginPanelDisplayed=loginPage.isLoginPanelDisplayed();
				softAssert.assertTrue(isLoginPanelDisplayed,"Login Panel was not displayed on Login Page");

				System.out.println("User able to enter username as \"\"your username\"\"");
				loginPage.enterCredentials("Admin","1V@Ph1laXC");
				System.out.println("User able to enter password as \"\"your password\"\"");
				softAssert.assertAll();

				System.out.println("Click on Login button");
				loginPage.clickOnLoginButton();
	}
	
	@Test
	public void loginTestWithoutPassword() {
		//PredefinedActions p=new PredefinedActions();
				System.out.println("Launch OrgHRM Application");
				PredefinedActions.start();

				System.out.println("Verify Logo displayed on Login Page");
				LoginPage loginPage=new LoginPage();
				boolean isLogoDisplayed=loginPage.isLogoDisplayed();
				softAssert.assertTrue(isLogoDisplayed,"Logo was not displayed on Login Page");

				System.out.println("Verify Login Panel displayed on Login Page");
				boolean isLoginPanelDisplayed=loginPage.isLoginPanelDisplayed();
				softAssert.assertTrue(isLoginPanelDisplayed,"Login Panel was not displayed on Login Page");

				System.out.println("User able to enter username as \"\"your username\"\"");
				loginPage.enterCredentials("Admin","");
				System.out.println("User able to enter password as \"\"your password\"\"");
				softAssert.assertAll();

				System.out.println("Click on Login button");
				loginPage.clickOnLoginButton();
				
				String expectedErrorMessage="Password cannot be empty";
				String actualErrorMessage=loginPage.getLoginErrorMessage();
				Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
				
	}
	
	@AfterMethod
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}
}
