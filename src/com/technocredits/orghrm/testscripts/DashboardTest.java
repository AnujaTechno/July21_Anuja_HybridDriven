package com.technocredits.orghrm.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.Assignment14.testscripts.TestBase;
import com.technocredits.orghrm.pages.DashboardPage;

//import com.technocredits.orghrm.base.PredefinedActions;
public class DashboardTest extends TestBase {
	SoftAssert softAssert=new SoftAssert();
	@BeforeClass
	public void setUp(){
		super.setup();
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
	
	@AfterClass
	public void tearDown() {
		//PredefinedActions.closeBrowser();
		super.tearDown();
	}
}
