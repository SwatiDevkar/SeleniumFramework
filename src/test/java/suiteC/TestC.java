package suiteC;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import dataProviders.DataProviders;
import testbase.TestBase;

public class TestC extends TestBase{
	@Parameters("browser")
	@Test(groups = {"Sanity", "browsergroup1"}, dataProviderClass = DataProviders.class, dataProvider = "dataProviderC")
	public void testCTest(String a, String b) throws InterruptedException {
	//public void testCTest(String para) throws InterruptedException {
		log("Starting TestC "+browser);
		Thread.sleep(2000);
		log("Ending TestC");
	}

}
