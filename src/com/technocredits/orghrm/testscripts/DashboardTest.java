package com.technocredits.orghrm.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.DashboardPage;
import com.technocredits.orghrm.pages.LoginPage;

//import com.technocredits.orghrm.base.PredefinedActions;
public class DashboardTest  {
	SoftAssert softAssert=new SoftAssert();
	@BeforeMethod
	public void setUp(){
		
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
	public void verifyWidgetsTest() {
		DashboardPage dashboardPage=new DashboardPage();
		System.out.println("Verify \"\"Dashboard\"\" as Title(Tab Level) Display Dashboard page");
		String actualDashboardPageHeaderTitle=dashboardPage.getPageHeaderTitle();
		String expectedDashboardPageHeaderTitle="Dashboard";
		softAssert.assertEquals(actualDashboardPageHeaderTitle, expectedDashboardPageHeaderTitle);

		String actualDashboardPageTitle=dashboardPage.getPageTitle();
		String expectedDashboardPageTitle="Dashboard";
		softAssert.assertEquals(actualDashboardPageTitle, expectedDashboardPageTitle);

		System.out.println("Verify total 11 widget's are disply on Dashboard page");
		int totalWidgets=dashboardPage.getTotalWidgets();
		int expected=12;
		softAssert.assertEquals(totalWidgets,expected);
		softAssert.assertAll();

		System.out.println("Get all widget names");
		List<String>actualWidgetsList =dashboardPage.getAllWidgetsText();
		List<String> expectedWidgetsList=new ArrayList<String>();
		expectedWidgetsList.add("Quick Access");
		expectedWidgetsList.add("Buzz Latest Posts");
		expectedWidgetsList.add("Employee Job Details");
		expectedWidgetsList.add("My Actions");
		expectedWidgetsList.add("Headcount by Location");
		expectedWidgetsList.add("Employees on Leave today");
		expectedWidgetsList.add("Time At Work");
		expectedWidgetsList.add("Performance Quick Feedback");
		expectedWidgetsList.add("Annual basic payment by Location");
		expectedWidgetsList.add("Latest Documents");
		expectedWidgetsList.add("Latest News");
		expectedWidgetsList.add("Yearly New Hires");
		System.out.println("Verify Widget names");
		softAssert.assertTrue(actualWidgetsList.equals(expectedWidgetsList)); //will compare index by index of both lists
	}
	
	@AfterMethod
	public void tearDown() {
		PredefinedActions.closeBrowser();
	}
}
