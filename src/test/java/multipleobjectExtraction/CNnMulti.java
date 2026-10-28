package multipleobjectExtraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import testbase.TestBase;

public class CNnMulti extends TestBase{
	@Test
	public void tesDropDown() throws InterruptedException {
		WebDriver driver = launchBrowser("Chrome");
		driver.get("https://www.qtpselenium.com/contact-us");
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='userCountry']"));		
		Select dropDownList = new Select(dropDown);
		dropDownList.selectByIndex(8);		
		dropDownList.selectByContainsVisibleText("India");		
		System.out.println(dropDownList.getFirstSelectedOption().getText());
		
		
		driver.quit();
		
	}

}
