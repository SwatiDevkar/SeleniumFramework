package suiteA;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import freemarker.template.SimpleDate;
import testbase.TestBase;

public class SakraWorld extends TestBase{
	
	@Test
	public void appointmentTest() throws InterruptedException  {
		
		
		launchBrowser("Chrome");
		/*driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath(prop.getProperty("doctor_name"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("services")).click();
		Thread.sleep(2000);*/
		
		driver.get("https://demoqa.com/date-picker");
		driver.findElement(By.id("datePickerMonthYearInput")).click();
		Thread.sleep(2000);
		
		
		
		
		
		driver.quit();		
		
	}
	
	

}
