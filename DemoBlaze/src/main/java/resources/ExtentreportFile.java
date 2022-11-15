package resources;

import java.io.FileInputStream;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportFile {

	public ExtentReports ExtentFile() {
		// TODO Auto-generated method stub
		String file=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter ex=new ExtentSparkReporter(file);
		ex.config().setDocumentTitle("automation results");
		ex.config().setReportName("test results");
		
		ExtentReports report=new ExtentReports();
		report.attachReporter(ex);
		report.setSystemInfo("tester", "mub");
		return report;

	}

}
