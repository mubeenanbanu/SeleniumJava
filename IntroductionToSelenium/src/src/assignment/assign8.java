package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assign8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("autocomplete")).click();
		driver.findElement(By.id("autocomplete")).sendKeys("unit");
		List<WebElement> autosuggestion=driver.findElements(By.xpath("//ul[@id='ui-id-1']//li//div"));
		for(int i=0;i<autosuggestion.size();i++)
		{
			String s=autosuggestion.get(i).getText();
			if(s.contains("United States"))
			{
				autosuggestion.get(i).click();
				System.out.println(s);
			}
		}
		driver.quit();
	}

}
