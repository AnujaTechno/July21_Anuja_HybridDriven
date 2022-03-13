package missingLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.PredefinedActions;

public class BrokenLink {
	@Test
	public void brokenLink() throws IOException, MalformedURLException{
		WebDriver driver = PredefinedActions.start("file:///G:/TechnoCredits/July21_Anuja_HybridDriven/resources/htmlForms/BrokenLink.html");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement element : links) { 
			String link = element.getAttribute("href");

			URL url = new URL(link);
			URLConnection utlConnection = url.openConnection();
			HttpURLConnection connection = (HttpURLConnection) utlConnection;
			connection.connect();
			if (connection.getResponseCode() >= 200 && connection.getResponseCode()<300) {
				System.out.println("Link is  working" + element.getText());
			}
				else
					System.out.println("Link is not working" + element.getText());
			//MalformedURLException is due to Globant link not available
		}
	}
}
