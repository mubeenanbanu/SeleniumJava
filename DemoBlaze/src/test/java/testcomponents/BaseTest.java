package testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageclasses.LoginPage;
import pageclasses.ProductCataloguePage;

public class BaseTest {
	public WebDriver driver;
	public LoginPage loginPage;
	public ProductCataloguePage pd;
	
		public WebDriver InitializeDriver() throws IOException
		{
			FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\GlovalProperty.properties");
			Properties p=new Properties();
			p.load(f);
			String browserName=p.getProperty("browser");
			if(browserName=="chrome")
			{
				ChromeOptions option = new ChromeOptions();
				option.setAcceptInsecureCerts(true);
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else if(browserName=="edge")
			{
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			else
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
					
			return driver;
		}
		@BeforeMethod(alwaysRun=true)
	public ProductCataloguePage LaunchApplication() throws IOException, InterruptedException
	{
		driver=InitializeDriver();
		driver.manage().window().maximize();
		loginPage=new LoginPage(driver);
	    pd=loginPage.GoTo();
		return pd;
		
	}
		@AfterMethod(alwaysRun=true)
	public void CloseDriver()
	{
		driver.quit();
	}
	public String GetScreenshot(String testCasename, WebDriver driver2) throws IOException
	{
		
	
		TakesScreenshot ts=(TakesScreenshot)driver2;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File filePath=new File(System.getProperty("user.dir")+"//reports//" +testCasename+ ".png");
		FileUtils.copyFile(source, filePath );
		return System.getProperty("user.dir")+"//reports//" +testCasename+ ".png"; 
		 
		
	}

}
