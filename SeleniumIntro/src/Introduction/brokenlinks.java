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
				"C:\\Users\\mubeena\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("start-maximized");
		WebDriver driver =new ChromeDriver(option);
		driver.manage().deleteAllCookies();
		SoftAssert sa=new SoftAssert();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> links=driver.findElements(By.cssSelector("[class='gf-li'] a"));
		for(WebElement i: links)
		{
			String url=i.getAttribute("href");
			 HttpURLConnection con=(HttpURLConnection) new URL(url).openConnection();
			 con.setRequestMethod("HEAD");
			 con.connect();
			 int code=con.getResponseCode();
			 sa.assertTrue(code<400,i.getText()+" is broken with " +code);
				 
		}
		sa.assertAll();
	}


}
