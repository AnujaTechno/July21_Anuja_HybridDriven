package technocredits.fileUploading;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class UploadFile {

	@Test
	public static void m1() throws InterruptedException, AWTException {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("basicelements")).click();
		driver.findElement(By.xpath("//label[@for='exampleInputFile']")).click();
		//driver.findElement(By.xpath("//*[@id=\"exampleInputFile\"]")).click();
	
		Thread.sleep(3000);
		
		StringSelection ss = new StringSelection("G:\\TechnoCredits\\Notes\\Git notes.txt");// file path
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Robot robot = new Robot();
		System.out.println(System.getProperty("os"));
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
}
