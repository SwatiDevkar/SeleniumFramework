package suiteA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import testbase.TestBase;

public class SakraWorld extends TestBase{
	
	@Test
	public void appointmentTest() throws InterruptedException  {
		
		
		launchBrowser("Chrome");
		driver.get(prop.getProperty("url"));
		driver.findElement(getObjectLocator("doctor_name_xpath")).click();		
		driver.findElement(getObjectLocator("services_xpath")).click();
		
		if(isElementPresent("nameField_xpath"))
			failAndStopTest("Name field is not present");
		driver.findElement(getObjectLocator("nameField_xpath")).sendKeys(prop.getProperty("name"));
		
		driver.findElement(getObjectLocator("emailField_xpath")).sendKeys(prop.getProperty("email"));
		driver.findElement(getObjectLocator("mobileField_xpath")).sendKeys(prop.getProperty("mobile"));
		WebElement genderDropDown = driver.findElement(getObjectLocator("genderField_xpath"));
		Select genderFValue = new Select(genderDropDown);
		genderFValue.selectByVisibleText(prop.getProperty("gender"));
		
		List<WebElement> registerRadio = driver.findElements(getObjectLocator("registeredRadioBox_xpath"));
		if(prop.getProperty("registered").equals("yes")) {
			registerRadio.get(0).click();
		}else {
			registerRadio.get(1).click();
		}
		
		Thread.sleep(3000);
		//driver.findElement(By.xpath(prop.getProperty(""))).sendKeys(prop.getProperty("registered"));
		//driver.findElement(By.xpath(prop.getProperty(""))).sendKeys(prop.getProperty(""));
		//driver.findElement(By.xpath(prop.getProperty(""))).sendKeys(prop.getProperty(""));
		
		
		
		/*driver.get("https://demoqa.com/date-picker");
		driver.findElement(By.id("datePickerMonthYearInput")).click();
		Thread.sleep(2000);*/
		
		
		
		
		
		driver.quit();		
		
	}
	
	

}
