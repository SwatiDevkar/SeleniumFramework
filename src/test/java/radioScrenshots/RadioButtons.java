package radioScrenshots;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import testbase.TestBase;

public class RadioButtons extends TestBase{
	@Test
	public void tesDropDown() throws InterruptedException {
		WebDriver driver = launchBrowser("Chrome");
		driver.get("https://demoqa.com/radio-button");
			
		List<WebElement> radios = driver.findElements(By.xpath("//*[@name='like']"));
		System.out.println("Number of Radios: "+radios.size());
		for (int i = 0; i < radios.size(); i++) {
			radios.get(i).click();
			System.out.println("Radio clicked: "+driver.findElement(By.xpath("//*[@name='like']/following-sibling::label")));
			
		}
		Thread.sleep(2000);
		
		
		driver.quit();
		
		
				
		
	}

}
