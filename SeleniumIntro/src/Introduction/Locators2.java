package Introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
	
		System.setProperty("webdriver.edge.driver", "C:\\Users\\mubeena\\Downloads\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		
		String pwd=GetPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys(pwd);
		driver.findElement(By.className("submit")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText());
	
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] p")).getText());
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.quit();
		
		

	}
	public static String GetPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
		
		String msg=driver.findElement(By.cssSelector("p.infoMsg")).getText();
		String[] passwordArray=msg.split("'");
		System.out.println(passwordArray[1]);
		return passwordArray[1];
		
	}

}
