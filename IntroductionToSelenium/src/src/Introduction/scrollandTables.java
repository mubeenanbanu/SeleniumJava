package Introduction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class scrollandTables {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		 
		int sum=0;
		List<WebElement> amount=driver.findElements(By.cssSelector("div[class='tableFixHead'] tbody tr td:nth-child(4)"));
		for(int i=0;i<amount.size();i++)
		{
			sum+=Integer.parseInt(amount.get(i).getText());
			
		}
		System.out.println(sum);
		String message=driver.findElement(By.className("totalAmount")).getText();
		int actualSum=Integer.parseInt(message.split(":")[1].trim());
		System.out.println(actualSum);
		Assert.assertEquals(actualSum, sum);
		
		driver.quit();
		js.executeScript("window.scrollBy(0,700)");
		

	}

}
