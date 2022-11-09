package testcomponents;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportsFile;

public class Listener extends BaseTest implements ITestListener {
	WebDriver driver;
	
	ExtentTest test;
	ExtentReports ex=ExtentReportsFile.ExtentReportData();
	ThreadLocal<ExtentTest> t=new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
	
		t.set(ex.createTest(result.getMethod().getMethodName()));
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	
//		test.fail(result.getThrowable());
		t.get().log(Status.PASS, "Test is passed");
	
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		t.get().fail(result.getThrowable()+" "+result.getMethod().getMethodName());
		try
		{
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		

		String f=null;
		try {
			f=GetScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t.get().addScreenCaptureFromPath(f, result.getMethod().getMethodName());
		
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
//		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	
		ex.flush();
	}
	

}
