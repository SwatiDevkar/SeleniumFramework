package suiteB;

import org.testng.annotations.Test;

import dataProviders.DataProviders;
import testbase.TestBase;

public class TestBB extends TestBase{
	@Test(groups = {"Smoke", "browsergroup2"}, dataProviderClass = DataProviders.class, dataProvider = "dataProviderB")
	public void testBBTest(String a, String b) throws InterruptedException {
		log("Starting TestBB");
		Thread.sleep(2000);
		log("Ending TestBB");
	}

}
