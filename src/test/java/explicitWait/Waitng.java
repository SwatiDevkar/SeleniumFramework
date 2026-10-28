package explicitWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import testbase.TestBase;

public class Waitng extends TestBase{
	@Test
	public void waitEx() throws InterruptedException {
		launchBrowser("Chrome");
		driver.get("https://automationbro.com");
		System.out.println(driver.findElement(By.xpath("//input[@id='lease-to-own-radio']")).isEnabled());
		String flag = driver.findElement(By.xpath("//input[@id='lease-to-own-radio']")).getAttribute("aria-checked");
		System.out.println("Before: "+flag);
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//input[@id='lease-to-own-radio']")).click();
		flag = driver.findElement(By.xpath("//input[@id='lease-to-own-radio']")).getAttribute("aria-checked");
		System.out.println("After: "+flag);
		System.out.println(driver.findElement(By.xpath("//div[@class='LeaseToOwnCalculator_payment__5U2os d-flex flex-column']")).getText());
		Thread.sleep(2000);
		driver.quit();
	}

}
