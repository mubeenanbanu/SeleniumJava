package assignment;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class assign {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("start-maximized");
		WebDriver driver =new ChromeDriver(option);
		driver.manage().deleteAllCookies();
		BrokenlinkQA(driver);

	}
	public static void BrokenlinkQA(WebDriver driver) throws MalformedURLException, IOException
	{
	
		driver.get("https://demoqa.com/links");
		List<WebElement> Urls=driver.findElements(By.xpath("//div[@id='linkWrapper']//a"));
		for(WebElement i:Urls )
		{
			
			String url=i.getAttribute("href");
			
			
			HttpURLConnection c=(HttpURLConnection) new URL(url).openConnection();
			c.setRequestMethod("HEAD");
			c.connect();
			int status=c.getResponseCode();
			Assert.assertTrue(status<400,"broken link with "+status);
		}
	}
	 public static boolean isUrlValid(String url) {
	      try {
	         URL obj = new URL(url);
	         obj.toURI();
	         return true;
	      } catch (MalformedURLException e) {
	         return false;
	      } catch (URISyntaxException e) {
	         return false;
	      }
	   }


}
