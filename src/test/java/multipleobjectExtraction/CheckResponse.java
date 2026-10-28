package multipleobjectExtraction;

import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import testbase.TestBase;

public class CheckResponse extends TestBase{
	@Test
	public void tesDropDown() throws InterruptedException {
		/*WebDriver driver = launchBrowser("Chrome");
		driver.get("https://www.cnn.com/");
			
		List<WebElement> allLinks = driver.findElements(By.xpath("//div[@class='header__nav-item']/a"));
		
		System.out.println("Size: "+allLinks.size());
		for(WebElement e:allLinks)
			System.out.println(e.getAttribute("href"));
		
		
		driver.quit();*/
		int resp_code=0;
		try {
			resp_code = Request.Get("https://www.cnn.com/").execute().returnResponse().getStatusLine().getStatusCode();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result: "+resp_code);
		
				
		
	}
}
