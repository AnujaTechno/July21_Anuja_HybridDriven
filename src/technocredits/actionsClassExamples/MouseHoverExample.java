package technocredits.actionsClassExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class MouseHoverExample {
	
	@Test
	public static void m1() throws InterruptedException {
		WebDriver driver = PredefinedActions.start("https://www.flipkart.com/");
		Thread.sleep(5000);
		WebElement home = driver.findElement(By.xpath("//*[text()='Home']"));
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@class=\"_2KpZ6l _2doB4z\"]")).click();
		Actions action = new Actions(driver);
		action
		.moveToElement(home)
		.perform();
		
	}

}
