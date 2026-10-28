package reports;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {		
	static ExtentReports reports;	
	public static ExtentReports getReports() {		
		if(reports == null) {
			reports = new ExtentReports();
			Date d = new Date();
			System.out.println(d.toString().replaceAll(":", "-"));
			String reportsFolder = d.toString().replaceAll(":", "-");
			String reportsFolderPath = System.getProperty("user.dir")+"\\reports\\"+reportsFolder;
			String screenshotsFolderPath = reportsFolderPath+"\\screenshots";
			File file = new File(screenshotsFolderPath);
			file.mkdirs();//to make sub-directories under the folder
			ExtentSparkReporter sparkreporter = new ExtentSparkReporter(reportsFolderPath);
			sparkreporter.config().setReportName("UAT Regression");
			sparkreporter.config().setDocumentTitle("Automation Results");
			sparkreporter.config().setTheme(Theme.STANDARD);
			sparkreporter.config().setEncoding("utf-8");		
			reports.attachReporter(sparkreporter);	
		}		
		return reports;		
	}
}


