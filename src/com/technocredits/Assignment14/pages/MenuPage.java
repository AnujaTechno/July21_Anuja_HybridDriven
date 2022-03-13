package com.technocredits.Assignment14.pages;

import org.openqa.selenium.By;

import com.technocredits.Assignment14.base.PredefinedActions;

public class MenuPage extends PredefinedActions
{
	
	public void navigateTo(String menu) {
		System.out.println("Start of navigate");
		//System.out.println(driver);
		String[] arr=menu.split("->");
		for(String menuname:arr) {
			System.out.println(driver);
			driver.findElement(By.xpath("//span[text()='"+menuname+"']")).click();
		}
		System.out.println("End of navigate");
	}
}
