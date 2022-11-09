package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assign3 {
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub'
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("learning");
		Select s=new Select(driver.findElement(By.className("form-control")));
		s.selectByValue("stud");
		driver.findElement(By.id("signInBtn")).click();
//		AddProductsToCart(driver);

	}
	public static void AddProductsToCart(WebDriver driver) throws InterruptedException
	{
//		Thread.sleep(1000);
		
		
	}

}
