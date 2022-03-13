package technocredits.actionsClassExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class ClickAndHoldExample {
	
	@Test
	public static void m1() throws InterruptedException {
		WebDriver driver = PredefinedActions.start("file:///G:/TechnoCredits/July21_Anuja_HybridDriven/resources/htmlForms/DragAndDropCircleAngularJS.html");
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droptarget = driver.findElement(By.id("droptarget"));
		
		
		Actions action = new Actions(driver);
		action
		.clickAndHold(draggable)// single action
		.moveToElement(droptarget)// single action
		.release()// single action
		.build()
		.perform();
		
	}

}
