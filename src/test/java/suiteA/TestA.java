package suiteA;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import dataProviders.DataProviders;
import reports.ExtentManager;
import testbase.TestBase;

public class TestA extends TestBase{
	
	
	
	@Test(groups = {"Sanity", "browsergroup2"}, dataProviderClass = DataProviders.class, dataProvider = "dataProviderA")
	public void testATest(String a, String b) throws InterruptedException {
		log("Starting TestA");
		System.out.println(a+"********"+b);
		Thread.sleep(2000);
		log("Starting Test Case TestA");
		
		log("Logging In");
		//test.log(Status.FAIL, "Test Passed");
		//Assert.fail("---Failed Scenario watch----");
		if("title".equals("title1"))
			softAssert("Titles doesnt match");
		log("Ending TestA");
	}
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "dataProviderA")
	public void testATest1(int a, int b) throws InterruptedException {
		log("Starting TestA");
		System.out.println(a+"********"+b);
		Thread.sleep(2000);
		log("Starting Test Case TestA");
		
		log("Logging In");
		test.log(Status.PASS, "Test Passed");
		log("Ending TestA");
	}

}
