package dataProviders;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider
	public static Object[][] dataProviderA(Method m) {
		System.out.println(m.getName().toUpperCase());
		Object[][] data = null;
		if(m.getName().toUpperCase().equalsIgnoreCase("testATest")) {
			data = new Object[2][2];
			data[0][0] = "d00";
			data[0][1] = "d01";
			
			data[1][0] = "d10";
			data[1][1] = "d11";
		}else if(m.getName().toUpperCase().equalsIgnoreCase("testATest1")) {
			data = new Object[2][2];
			data[0][0] = 100;
			data[0][1] = 101;
			
			data[1][0] = 110;
			data[1][1] = 111;
		}else if(m.getName().toUpperCase().equalsIgnoreCase("testAATest")) {
			data = new Object[2][2];
			data[0][0] = "d00";
			data[0][1] = "d01";
			
			data[1][0] = "d10";
			data[1][1] = "d11";
		}
	
			return data;
	}
	
	@DataProvider
	public static Object[][] dataProviderB(Method m) {
		Object[][] data = new Object[2][2];
		data[0][0] = "bd00";
		data[0][1] = "bd01";
		
		data[1][0] = "bd10";
		data[1][1] = "bd11";
		return data;
	}
	
	@DataProvider
	public static Object[][] dataProviderC(Method m) {
		Object[][] data = new Object[2][2];
		data[0][0] = "cd00";
		data[0][1] = "cd01";
		
		data[1][0] = "cd10";
		data[1][1] = "cd11";
		return data;
	}

}
