package testcomponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

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
		
	public ProductCataloguePage LaunchApplication() throws IOException, InterruptedException
	{
		driver=InitializeDriver();
		driver.manage().window().maximize();
		loginPage=new LoginPage(driver);
	    pd=loginPage.GoTo();
		return pd;
		
	}

}
