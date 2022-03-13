package com.technocredits.orghrm.pages;

import org.openqa.selenium.By;

import com.technocredits.Assignment14.base.PredefinedActions;
import com.technocredits.Assignment14.pages.MenuPage;

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
	
	public MenuPage clickOnLoginButton() {
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		return new MenuPage();
	}
	
	public String getLoginErrorMessage() {
		 return driver.findElement(By.xpath("//span[@id='txtPassword-error']")).getText();
	}
}
