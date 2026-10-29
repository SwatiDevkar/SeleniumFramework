package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import reports.ExtentManager;

public class TestBase {
	
	public ExtentReports reports;
	public ExtentTest test;
	public SoftAssert softAssert;
	public String browser;
	public WebDriver driver = null;
	public Properties prop = new Properties();
	
	public WebDriver launchBrowser(String browserName) {
		
		if(browserName.equals("Chrome")) {
			//System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "logs\\chrome.log");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			ChromeOptions ops = new ChromeOptions();
			//ops.setBinary("");
			//ops.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			ops.addArguments("--disable-notifications");
			ops.addArguments("--start-maximized");
			driver = new ChromeDriver(ops);
			//driver=new ChromeDriver();
		}
		else if(browserName.equals("Edge"))
			driver=new EdgeDriver();
		else if(browserName.equals("Firefox"))
			driver=new FirefoxDriver();
		
		//dynamic wait-not pause
		//global time out for all driver.findelememt
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//properties file initialization
		
		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//project.properties");			
			prop.load(fs);			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return driver;
		
		
	}
	
	// true-present and not hidden
	public boolean isElementPresent(String locatorKey) {
		WebElement e = null;
		/*try {
			e = driver.findElement(By.id(locator));
		} catch(Exception ex) {
			return false;
		}
		if(!e.isDisplayed())
			return false;
			return true;*/
		By locator = getObjectLocator(locatorKey);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated((locator)));
		wait.until((ExpectedConditions.visibilityOfElementLocated((locator))));
		return true;
	}
	
	public void selectDate(String dateToSelect) {
		String displayedMonthYear = driver.findElement(By.xpath("//div[@class='react-datepicker__header ']/h2")).getText();
		System.out.println(displayedMonthYear);
		//String dateToSelect="11-04-2025";
		Date currentDate = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("d-MM-yyyy");
		Date dateToSelectFormatted;
		try {
			dateToSelectFormatted = sd.parse(dateToSelect);
			String day = new SimpleDateFormat("d").format(dateToSelectFormatted);
			String month = new SimpleDateFormat("MMMM").format(dateToSelectFormatted);
			String year = new SimpleDateFormat("yyyy").format(dateToSelectFormatted);
			System.out.println(day+"-"+month+"-"+year);
			String toSelectMOnthYear = month+" "+year;
			
			while(!displayedMonthYear.equals(toSelectMOnthYear)) {
				//comparision - selectDate is past -1 else +1
				if(dateToSelectFormatted.compareTo(currentDate) == -1) {
					driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")).click();
					displayedMonthYear = driver.findElement(By.xpath("//div[@class='react-datepicker__header ']/h2")).getText();
				} else if(dateToSelectFormatted.compareTo(currentDate) == 1) {
					driver.findElement(By.xpath("//button[@class='react-datepicker__navigation react-datepicker__navigation--next']")).click();
					displayedMonthYear = driver.findElement(By.xpath("//div[@class='react-datepicker__header ']/h2")).getText();
				}
				
			}
			
			driver.findElement(By.xpath("//div[text()="+day+"]")).click();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(displayedMonthYear);
	}
	
	//To return By object corresponding to locator
	public By getObjectLocator(String locator) {		
		if(locator.endsWith("_id")) 
			return By.xpath(prop.getProperty(locator));
		else if(locator.endsWith("_name")) 
			return By.xpath(locator);
		else if(locator.endsWith("_cssSelector")) 
			return By.xpath(prop.getProperty(locator));
		else 			
			return By.xpath(prop.getProperty(locator));
	}
	
	
	
	@BeforeMethod(alwaysRun = true)
	public void init(ITestContext context, ITestResult result) {
		reports = ExtentManager.getReports();
		System.out.println(result.getMethod().getMethodName().toUpperCase());
		test = reports.createTest(result.getMethod().getMethodName().toUpperCase());
		softAssert = new SoftAssert();
		browser= context.getCurrentXmlTest().getParameter("browser");
		//System.out.println("**********************Browser: "+browser);
		String browsergroup[] = context.getAllTestMethods()[0].getGroups();
		String selectedBrowser="";
		for(String b:browsergroup) {
			if(b.startsWith("browsergroup")) {
				selectedBrowser=b;
				break;
			}			
		}
		System.out.println("Browser to be run: "+context.getCurrentXmlTest().getParameter(selectedBrowser));
			
		

	}	
	@AfterMethod(alwaysRun = true)
	public void quit() {
		reports.flush();
	}
	
	public void log(String msg) {
		System.out.println(msg);
		test.log(Status.INFO, msg);
	}
	
	public void logFailure(String msg) {//only fails in extent report
		System.out.println(msg);
		test.log(Status.FAIL, msg);
	}
	
	public void failAndStopTest(String msg) {//fail in testng as well as extent & STOP
		logFailure(msg);
		softAssert.fail(msg);
		softAssert.assertAll();
	}
	
	
	
	public void softAssert(String msg) {//fail in testng as well as extent - but continue
		logFailure(msg);// extent
		softAssert.fail(msg); // testng
		// take screenshot as well - put in reports
	}


}
