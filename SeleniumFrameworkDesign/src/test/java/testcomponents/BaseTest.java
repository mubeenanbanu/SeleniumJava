package testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageclasses.LoginPage;

public class BaseTest {

	
	public WebDriver driver;
	public LoginPage loginpage;
	
	public WebDriver InitializeDriver() throws IOException
	{
		
		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main\\java\\resources\\GobalVariable.properties");
		p.load(fis);
	
		String browserName=p.getProperty("browser");
		
		if(browserName=="chrome")
		{
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
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	public String GetScreenshot(String testCasename, WebDriver driver2) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver2;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File filePath=new File(System.getProperty("user.dir")+"//reports//" +testCasename+ ".png");
		FileUtils.copyFile(source, filePath );
		return System.getProperty("user.dir")+"//reports//" +testCasename+ ".png"; 
		
	}
	public List<HashMap<String, String>> GetJsonDataToMap(String filePath) throws IOException
	{
		String jsonContent=FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
	@BeforeMethod(alwaysRun=true)
	public LoginPage LaunchApplication() throws IOException
	{
		driver=InitializeDriver();
		loginpage=new LoginPage(driver);
		loginpage.GoTo();
		return loginpage;
	}
	@AfterMethod(alwaysRun=true)
	public void Cleanup()
	{
		driver.quit();
	}
	
	

}
