package missingLinks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class MissingLink {
	@Test
	public void missingLink() {
		WebDriver driver = PredefinedActions.start("file:///G:/TechnoCredits/July21_Anuja_HybridDriven/resources/htmlForms/MissingLinks.html");
		
		List<WebElement> list = driver.findElements(By.xpath("//a"));

		for (WebElement element : list) {
			String link = element.getAttribute("href");
			if (link == null) {
				System.out.println("href is missing: " + element.getText());
			} else if (link.isEmpty()) {
				System.out.println("Missing Link : " + element.getText());
			}
		}
	}
}
