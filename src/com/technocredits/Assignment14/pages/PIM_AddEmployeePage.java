package com.technocredits.Assignment14.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.Assignment14.base.PredefinedActions;

public class PIM_AddEmployeePage extends PredefinedActions {

	public PIM_AddEmployeePage setEmpFirstName(String fname) {
		driver.findElement(By.xpath("//input[@id='first-name-box']")).sendKeys(fname);
		return this;
	}

	public PIM_AddEmployeePage setEmpMiddleName(String mname ) {
		driver.findElement(By.xpath("//input[@id='middle-name-box']")).sendKeys(mname);
		return this;
	}

	public PIM_AddEmployeePage setEmpLastName(String lname ) {
		driver.findElement(By.xpath("//input[@id='last-name-box']")).sendKeys(lname);
		return this;
	}

	public PIM_AddEmployeePage setEmpLocation(String location ) {
		driver.findElement(By.xpath("//button[@data-id='location']")).click();
		driver.findElement(By.xpath("//span[text()='"+location+"']//parent::a")).click();//always prefer to click link
		return this;
	}

	public PIM_AddEmployeePage clickOnNext() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Next']")).click(); //next1
		return this;  
	}

	public void addEmployeeInfo(String fname,String mname,String lname,String location) {
		setEmpFirstName(fname);
		setEmpLastName(lname);
		setEmpLocation(location);
		setEmpMiddleName(mname);
	}

	public PIM_AddEmployeePage setLicenseNo(String num) {
		driver.findElement(By.xpath("//div[@class=\"input-field col s12 m12 l4\"]/input[@id='licenseNo']")).sendKeys(num);
		return this;
	}

	public PIM_AddEmployeePage setRegion(String region) {
		driver.findElement(By.xpath("//div[@id=\"9_inputfileddiv\"]//input[@class=\"select-dropdown\"]")).click();
		driver.findElement(By.xpath("//span[text()='"+region+"']")).click();
		return this;
	}

	public PIM_AddEmployeePage setFTE(String fte) {
		driver.findElement(By.xpath("//div[@id='10_inputfileddiv']//input[@class='select-dropdown']")).click();
		driver.findElement(By.xpath("//span[text()='"+fte+"']")).click();
		return this;
	}

	public PIM_AddEmployeePage setTempDept(String tempDept) {
		driver.findElement(By.xpath("//div[@id='11_inputfileddiv']//input[@class='select-dropdown']")).click();
		driver.findElement(By.xpath("//span[text()='"+tempDept+"']")).click();
		return this;
	}
	
	public PIM_AddEmployeePage setWorkShift(String workShift) {
		try {
		driver.findElement(By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")).click();
		}
		catch(StaleElementReferenceException staleExcep) {
			driver.findElement(By.xpath("//div[@id='work_shift_id_inputfileddiv']//span[@class='caret']//following-sibling::input")).click();
		}
		/*WebElement e=driver.findElement(By.xpath("//ul[contains(@class,'dropdown-content select-dropdown ')]/li/span[text()='"+workShift+"']"));
		while(!e.isDisplayed()) {
			e=driver.findElement(By.xpath("//ul[contains(@class,'dropdown-content select-dropdown ')]/li/span[text()='"+workShift+"']"));
		}
		e.click();*/
		WebDriverWait wait=new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOf(e));
		WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'dropdown-content select-dropdown ')]/li/span[text()='"+workShift+"']")));
		e.click();
		return this;
	
	}
	
	public PIM_AddEmployeePage setEffectiveFromDate(String day,String month,String year) {
		//driver.findElement(By.xpath("//input[contains(@class,'ng-dirty ng-valid-date')]//following-sibling::i")).click();
		driver.findElement(By.xpath("//label[text()='Effective From']//following-sibling::span//i")).click();
		
		//Month
		driver.findElement(By.xpath("//div[@class=\"select-wrapper picker__select--month\"]//following-sibling::input")).click();
		driver.findElement(By.xpath("//ul[contains(@class,\"dropdown-content select-dropdown\")]/li/span[text()='"+month+"']")).click();
		
		//Year
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//WebElement e1=driver.findElement(By.xpath("//input[contains(@class,\"active_datepicker\")]//parent::span/div[@class=\"picker picker--opened picker--focused\"]//div[@class=\"select-wrapper picker__select--year\"]/input"));
		/*while(!e1.isDisplayed()) {
			e1=driver.findElement(By.xpath("//input[contains(@class,\"active_datepicker\")]//parent::span/div[@class=\"picker picker--opened picker--focused\"]//div[@class=\"select-wrapper picker__select--year\"]/input"));
		}*/
		WebDriverWait wait=new WebDriverWait(driver,60);
		WebElement e1=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[contains(@class,\"active_datepicker\")]//parent::span/div[@class=\"picker picker--opened picker--focused\"]//div[@class=\"select-wrapper picker__select--year\"]/input"))));
		e1.click();
		/*WebElement e2=driver.findElement(By.xpath("//input[contains(@class,\"active_datepicker\")]//parent::span/div[@class=\"picker picker--opened picker--focused\"]//div[@class=\"select-wrapper picker__select--year\"]/ul/li/span[text()="+year+"]"));
		while(!e2.isDisplayed()) {
		e2=driver.findElement(By.xpath("//input[contains(@class,\"active_datepicker\")]//parent::span/div[@class=\"picker picker--opened picker--focused\"]//div[@class=\"select-wrapper picker__select--year\"]/ul/li/span[text()="+year+"]"));
		}*/
		 wait=new WebDriverWait(driver,60);
		WebElement e2=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[contains(@class,\"active_datepicker\")]//parent::span/div[@class=\"picker picker--opened picker--focused\"]//div[@class=\"select-wrapper picker__select--year\"]/ul/li/span[text()="+year+"]"))));
		e2.click();
		
		//Day
		 wait=new WebDriverWait(driver,60);
		WebElement e3=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[@id='add_employee_effective_date']//following-sibling::span[1]//table[@class=\"picker__table\"]//div[text()="+day+" and @class=\"picker__day picker__day--infocus\"]"))));
		/*while(!e3.isDisplayed()) {
			e3=driver.findElement(By.xpath("//input[@id='add_employee_effective_date']//following-sibling::span[1]//table[@class=\"picker__table\"]//div[text()="+day+" and @class=\"picker__day picker__day--infocus\"]"));
		}*/
		e3.click();
		return this;
		
	}
	
	public PIM_AddEmployeePage setRegion() {
		WebDriverWait wait=new WebDriverWait(driver,30);
		WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id=\"9_inputfileddiv\"]//following-sibling::input"))));
		e.click();
		WebElement e1=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id=\"9_inputfileddiv\"]//ul[contains(@class,\"dropdown-content select-dropdown\")]/li/span[text()='Region-3']"))));
		e1.click();
		return this;
	}
	
	public PIM_AddEmployeePage setFTE() {
		WebDriverWait wait=new WebDriverWait(driver,30);
		WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id=\"10_inputfileddiv\"]//following-sibling::input"))));
		e.click();
		WebElement e1=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id=\"10_inputfileddiv\"]//ul[contains(@class,\"select-dropdown\")]/li/span[text()='1']"))));
		e1.click();
		return this;
	}
	
	public PIM_AddEmployeePage setDept() {
		WebDriverWait wait=new WebDriverWait(driver,30);
		WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id=\"11_inputfileddiv\"]//following-sibling::input"))));
		e.click();
		WebElement e1=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@id=\"11_inputfileddiv\"]//ul[contains(@class,\"select-dropdown\")]/li/span[text()='Sub unit-4']"))));
		e1.click();
		return this;
	}
	
	public PIM_AddEmployeePage clickSave() {
		driver.findElement(By.xpath("//button[@class=\"btn waves-effect waves-light right\"]")).click();
		return this;
	}
}
