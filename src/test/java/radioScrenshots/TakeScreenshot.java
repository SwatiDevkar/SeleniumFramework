package radioScrenshots;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import testbase.TestBase;

public class TakeScreenshot extends TestBase{
	@Test
	public void takeScreenshotExample() {
		WebDriver driver = launchBrowser("Chrome");
		driver.get("https://demoqa.com/radio-button");
		takeScreenshot("C:\\Users\\datta\\Documents\\Swati Documents\\2026\\WhizdomMyWorkSpace\\ProjectStrucutre\\screenshots\\test.jpg");
		driver.quit();		
	}
	
	public void takeScreenshot(String filepath) {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(filepath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
