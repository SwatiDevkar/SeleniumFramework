package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener{
	
	public void onTestFailure​(ITestResult result) {
	
		System.out.println("--Test Failed--");
	}
	
	public void onTestSuccess​(ITestResult result) {
		System.out.println("--Test Passed--");
	}
}
