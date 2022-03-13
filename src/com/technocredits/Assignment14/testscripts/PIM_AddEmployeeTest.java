package com.technocredits.Assignment14.testscripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technocredits.Assignment14.pages.MenuPage;
import com.technocredits.Assignment14.pages.PIM_AddEmployeePage;
public class PIM_AddEmployeeTest extends TestBase{
	 private MenuPage menuPage=new MenuPage();
	@BeforeMethod
	public void setUp() {
		
		menuPage=super.setup();
		System.out.println(menuPage);
	} 

	

	@Test
	public void verifyAddEmployeeTest() {
		menuPage.navigateTo("PIM->Add Employee");
		PIM_AddEmployeePage pim_AddEmployeePage=new PIM_AddEmployeePage();
		pim_AddEmployeePage.setEmpFirstName("Techno").setEmpMiddleName("M").setEmpLastName("Credits").setEmpLocation("Australian Regional HQ")
		.clickOnNext().setLicenseNo("14ssAbh245").clickOnNext().setWorkShift("Twilight").setEffectiveFromDate("01","April","2021")
		.setRegion().setFTE().setDept().clickSave();
		////driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.navigate().refresh();
		//pim_AddEmployeePage.setWorkShift("Default Shift").setEffectiveFromDate("01","March","2022");//setRegion("Region-1").setFTE("0.5").setTempDept("Sub unit-1");
		//pim_AddEmployeePage.setLicenseNo("14ssAbh245");
		//pim_AddEmployeePage.clickOnNext();
	}
	

	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}

}
