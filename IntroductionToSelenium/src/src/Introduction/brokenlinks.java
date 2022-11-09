package Introduction;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class brokenlinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("start-maximized");
		WebDriver driver =new ChromeDriver(option);
		driver.manage().deleteAllCookies();
		SoftAssert sa=new SoftAssert();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> Urls=driver.findElements((By.xpath("//li[@class='gf-li']/a")));
		for(WebElement a:Urls)
		{
			String url=a.getAttribute("href");
			HttpURLConnection ui=(HttpURLConnection)new URL(url).openConnection();
			ui.setRequestMethod("HEAD");
			ui.connect();
			int status=ui.getResponseCode();
			sa.assertTrue(status<400, a.getText() +" is broken link with "+status);
//			if(status==200)
//			{
//				//Assert.assertTrue(true);
//				System.out.println();
//				
//			}
//			else
//			{
//				System.out.println(a.getText()  +" is Broken link with "+status);
//			}
			
		}
		sa.assertAll(); //for showing what has failed 
		
	
		driver.quit();

	}


}
