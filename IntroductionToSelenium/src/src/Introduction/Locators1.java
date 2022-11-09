package Introduction;

import java.time.Duration;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class Locators1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello");
		driver.findElement(By.className("submit")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("tester");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(2)")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("tester");
		driver.findElement(By.cssSelector("form input:nth-child(3)")).clear();
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("tester@tester.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("4567");
		driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
		String msg=driver.findElement(By.cssSelector("p.infoMsg")).getText();
		String[] passwordArray=msg.split("'");
		System.out.println(passwordArray[1]);
		System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		driver.findElement(By.cssSelector("input[id*='Username']")).sendKeys("rahul");
		driver.findElement(By.xpath("//input[contains(@name,'Password')]")).sendKeys("rahulshettyacademy");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.submit")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText());
		
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] p")).getText());
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.quit();
		
		
	}

}
