package suiteC;

import org.testng.annotations.Test;

import dataProviders.DataProviders;
import testbase.TestBase;

public class TestCC extends TestBase{
	@Test(groups={"Sanity", "browsergroup2"}, dataProviderClass = DataProviders.class, dataProvider = "dataProviderC")
	public void testCCTest(String a, String b) throws InterruptedException {
		log("Starting TestCC");
		Thread.sleep(2000);
		log("Ending TestCC");
	}

}
