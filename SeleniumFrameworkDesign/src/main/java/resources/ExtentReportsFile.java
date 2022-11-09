package resources;

import java.io.FileInputStream;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsFile
{
	
	public static ExtentReports ExtentReportData()
	{
		String fis=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(fis);
		reporter.config().setReportName("webautomnation test results");
		reporter.config().setDocumentTitle("Test results");
		
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("tester", "mubeena");
		return report;
		
		

	}

}
