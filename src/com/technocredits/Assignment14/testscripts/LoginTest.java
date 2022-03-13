/*Assignment - 14 : 30th Oct'2021
	1. Launch https://<your server name>-trials71.orangehrmlive.com/auth/login
	2. Login with username and password 
	3. Verify ""Dashboard"" as Title(Tab Level) Display Dashboard page
	4. Go to PIM--> Add employee button
	5. Add all details in form and add employee
	6. Go to PIM--> Employee list
	7. Verify recently added employee should be displayed on Employee list

	Please create new repo, add testcases which we covered in session apart from above one.
	Repo naming convention : July21_Margi_HybridDriven*/

package com.technocredits.Assignment14.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.technocredits.Assignment14.base.PredefinedActions;

public class LoginTest extends PredefinedActions {
	@Test
	public void loginSetUp() {
		System.out.println("Launch OrgHRM Application");
		PredefinedActions.start();  
		System.out.println(" Login with username and password");
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("1V@Ph1laXC");
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		String title=driver.getTitle();
		String menu="PIM->Add Employee";
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='first-name-box']")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@id='last-name-box']")).sendKeys("User");
		driver.findElement(By.xpath("//button/i[@class=\"material-icons\"]//")).click();
		//Select select=new Select(element1);
		driver.findElement(By.xpath("//span[text()='India Office']")).click();
		//select.selectByVisibleText("India Office");
		driver.findElement(By.id("modal-save-button")).click(); //next1
		System.out.println(1);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		System.out.println(2);
		//driver.findElement(By.xpath("//*[@id=\"wizard-nav-button-section\"]/button[2]")).click(); //next2
		
		
		driver.findElement(By.xpath("//div[@id=\"emp_gender_inputfileddiv\"]//input[@class=\"select-dropdown\"]")).click();
		System.out.println(3);
		driver.findElement(By.xpath("//div[@id=\"emp_gender_inputfileddiv\"]//ul/li[2]")).click();
		driver.findElement(By.xpath("//div[@id=\"wizard-nav-button-section\"]/button[2]")).click();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//*[@id=\"wizard-nav-button-section\"]/button[2]")).click(); //next2
		//driver.findElement(By.className("btn waves-effect waves-light right")).click();//next2
		driver.findElement(By.xpath("//div[@id=\"9_inputfileddiv\"]//input[@class=\"select-dropdown\"]")).click();
		driver.findElement(By.xpath("//span[text()='Region-1']")).click();
		//Select select=new Select(regionElement);
		//select.selectByVisibleText("Region-1");
		driver.findElement(By.xpath("//div[@id='10_inputfileddiv']//input[@class='select-dropdown']")).click();
		driver.findElement(By.xpath("//span[text()='0.5']")).click();
		//Select select=new Select(fteElement);
		//select.selectByVisibleText("0.5");
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']//input[@class='select-dropdown']")).click();
		driver.findElement(By.xpath("//span[text()='Sub unit-1']")).click();
		////Select select=new Select(tempDeptElement);
		//select.selectByVisibleText("Sub unit-1");
		driver.findElement(By.className("btn waves-effect waves-light right")).click();
		
		WebElement vaccineElement=driver.findElement(By.xpath("//div[@id=\"55_inputfileddiv\"]//input[@class=\"select-dropdown\"]"));
		 Select select=new Select(vaccineElement);
		select.deselectByVisibleText("Yes");
		WebElement doseElement=driver.findElement(By.xpath("//div[@id=\"32_inputfileddiv\"]//input[@class=\"select-dropdown\"]"));
		select=new Select(doseElement);
		select.deselectByVisibleText("2nd dose");
		driver.findElement(By.xpath("//div[@class=\"form-group schema-form-submit right\"]/button[@class=\" btn waves-effect waves-green \"]")).click();
		
		 menu="PIM->Employee List";
		/*arr=menu.split("->");
		for(String menuname:arr) {
			driver.findElement(By.xpath("//span[text()='"+menuname+"']")).click();
		}*/
		driver.findElement(By.xpath("//a[@class=\"employee-navbar-button circle\"]/i[text()='ohrm_filter']")).click();
		driver.findElement(By.id("emp_search_mdl_employee_name_filter_value")).sendKeys("Test User");
		driver.findElement(By.className("modal-action modal-close waves-effect btn primary-btn")).click();
		
		
		
	}
}
