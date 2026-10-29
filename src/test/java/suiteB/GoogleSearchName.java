package suiteB;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import testbase.TestBase;

public class GoogleSearchName extends TestBase{
	@Test
	public void testGoogleName() throws InterruptedException {
		launchBrowser("Chrome");
		driver.get("https://www.google.com/");
		String searchString = "Swati Devkar";
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys(searchString);
		List<WebElement> searchResult = driver.findElements(By.xpath("//div[@id='Alh6id']/div/div/ul/descendant::li"));
		System.out.println("Number of results returned: ");
		for(WebElement e:searchResult)
			System.out.println(e.getText());
		searchResult.get(2).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
