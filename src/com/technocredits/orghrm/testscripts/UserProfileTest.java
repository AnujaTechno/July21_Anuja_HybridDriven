/*1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
	2.Login using Valid credentials
	3.Verify User profile is displayed.
	4.Click on Arrow icon on profile
	5.Verify User menu total 3 options are displayed(About,Change Password and Logout) on after click on arrow
	6.Click on About.
	7.Verify employee count is more than 0.
	8.Verify the companny details fields are getting displayed on information alert(Company name,employees,version,Users 
	and renewal on)
	9.Click on OK button on popup.
	 */
package com.technocredits.orghrm.testscripts;

import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.LoginPage;

public class UserProfileTest {
	@BeforeMethod
	public void setUp(){
		SoftAssert softAssert=new SoftAssert();
		//PredefinedActions p=new PredefinedActions();
		System.out.println("Launch OrgHRM Application");
		PredefinedActions.start();

		System.out.println("Verify Logo displayed on Login Page");
		LoginPage loginPage=new LoginPage();
		boolean isLogoDisplayed=loginPage.isLogoDisplayed();
		

		System.out.println("Verify Login Panel displayed on Login Page");
		boolean isLoginPanelDisplayed=loginPage.isLoginPanelDisplayed();
		

		System.out.println("User able to enter username as \"\"your username\"\"");
		loginPage.enterCredentials("Admin","1V@Ph1laXC");
		System.out.println("User able to enter password as \"\"your password\"\"");
		

		System.out.println("Click on Login button");
		loginPage.clickOnLoginButton();
	}
}
