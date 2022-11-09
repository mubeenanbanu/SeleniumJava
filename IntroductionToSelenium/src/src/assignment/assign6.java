package assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Introduction.Alerts;

public class assign6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/#");
		Assign6( driver);
		driver.quit();

	}
	public static void Assign6(WebDriver driver)
	{
		driver.findElement(By.cssSelector("label[for='benz'] input")).click();
		String checkBox=driver.findElement(By.xpath("//label[@for='benz']/input/parent::label")).getText();
		System.out.println(checkBox);
		Select s=new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByVisibleText(checkBox);
		driver.findElement(By.name("enter-name")).sendKeys(checkBox);
		driver.findElement(By.id("alertbtn")).click();
		Alert a=driver.switchTo().alert();
		String message=a.getText();
		if(message.contains(checkBox))
		{
			Assert.assertTrue(true);
		}
		a.accept();
		System.out.println(message.split(" ")[1].split(",")[0].trim());
		
		
		
	}

}
