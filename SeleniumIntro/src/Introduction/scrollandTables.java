package Introduction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class scrollandTables {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");
			//grab amount data of table and print it
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(1000);
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=500");
		List<WebElement> tabledata=driver.findElements(By.cssSelector("[class='tableFixHead'] table tbody tr td:nth-child(4)"));
		int amount=0;
		for(int i=0;i<tabledata.size();i++)
		{
			amount+=Integer.parseInt(tabledata.get(i).getText());
		}
		System.out.println(amount);
		String  a=driver.findElement(By.className("totalAmount")).getText();
		int displayedAmount=Integer.parseInt(a.split(":")[1].trim());
		Assert.assertEquals(amount, displayedAmount);
		driver.quit();
	}


}
