package suiteB;

import org.testng.annotations.Test;

import dataProviders.DataProviders;
import testbase.TestBase;

public class TestB extends TestBase{
	@Test(groups = {"Sanity", "browsergroup2"}, dataProviderClass = DataProviders.class, dataProvider = "dataProviderB")
	public void testBTest(String a, String b) throws InterruptedException {
		log("Starting TestB");
		Thread.sleep(2000);
		log("Ending TestB");
	}

}
