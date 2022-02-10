package com.technocredits.orghrm.pages;

import org.openqa.selenium.By;
import com.technocredits.orghrm.base.*;

public class LoginPage extends PredefinedActions {
	public boolean isLogoDisplayed() {
		System.out.println("Verify Logo displayed on Login Page");
		boolean isLogoDisplayed=driver.findElement(By.xpath("//div[@class='organization-logo shadow']/img")).isDisplayed();
		return isLogoDisplayed;
	}
	
	public boolean isLoginPanelDisplayed() {
		return driver.findElement(By.xpath("//div[@class='login-form shadow']")).isDisplayed();
	}
	
	public void enterCredentials(String username,String password) {
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
	}
	
	public String getLoginErrorMessage() {
		 return driver.findElement(By.xpath("//span[@id='txtPassword-error']")).getText();
	}
}
