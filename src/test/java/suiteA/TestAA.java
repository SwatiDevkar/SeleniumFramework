package suiteA;

import org.testng.annotations.Test;

import dataProviders.DataProviders;
import testbase.TestBase;

public class TestAA extends TestBase{
	@Test(groups = {"Smoke", "browsergroup1"}, dataProviderClass = DataProviders.class, dataProvider = "dataProviderA")
	public void testAATest(String a, String b) throws InterruptedException {
		log("Starting TestAA");
		Thread.sleep(2000);
		log("Ending TestAA");
	}

}
