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
		radios.get(0).click();
		
		
		/*for (int i = 0; i < radios.size()-1; i++) {
			radios.get(0).click();
			System.out.println(driver.findElement(By.xpath("//*[@name='like']/following-sibling::label"+"["+i+"]")).getAttribute("for"));
			
		}*/
		
		
		
		driver.quit();
		
		
				
		
	}

}
