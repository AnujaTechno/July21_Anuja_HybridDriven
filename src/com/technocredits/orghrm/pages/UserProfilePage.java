package com.technocredits.orghrm.pages;

import java.util.List;

import org.openqa.selenium.By;

import com.technocredits.orghrm.base.PredefinedActions;

public class UserProfilePage extends PredefinedActions {
	public void clickOnUserDropdown() {
		driver.findElement(By.xpath("//span[@id=\"account-job\"]/i")).click();
	}
	
	public List<String> getListOfUserDropDownOptions(){
		/*List<WebElement> list=driver.findElements(By.xpath("//ul[@id='user_menu']/li/a"));
		List<String> userListOptions=new ArrayList<String>();
		for(WebElement e:list) {
			userListOptions.add(e.getText());
		}
		return userListOptions; */
		return getTextOfAllElements("//ul[@id='user_menu']/li/a");
	}
	
	public int getTotalAvailableOptions() {
		return getListOfUserDropDownOptions().size();
	}
	
	public void clickOnAbout() {
		driver.findElement(By.xpath("//ul[@id='user_menu']/li/a[text()='About']")).click();
	}
	
	public void clickOnSubMenu(String subMenu) {
		driver.findElement(By.xpath("//ul[@id='user_menu']/li/a[text()='"+subMenu+"']")).click();
	}
	
	public String getCmpNameFromAboutPopUp() {
		return driver.findElement(By.xpath("//div[@class=\"col s12\"]/p[1]")).getText();
	}
	
	public List<String> getAboutMenuText() {
		 //List<WebElement> list=driver.findElements(By.xpath("//div[@class=\"col s12\"]/p"));
		 return getTextOfAllElements("//div[@class=\"col s12\"]/p");
	}
}
