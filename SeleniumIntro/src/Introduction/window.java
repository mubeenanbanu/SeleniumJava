package Introduction;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class window {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Goto loginpage click on blinktext and grab mentor name and enter in loginpage name field
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.className("blinkingText")).click();
		Set<String> handles=driver.getWindowHandles();
		String currentwindow=driver.getWindowHandle();
		for(String s: handles)
		{
			if(currentwindow!=s)
			{
				driver.switchTo().window(s);
			}
		}
		String mentor=driver.findElement(By.cssSelector("[class='im-para red'] strong a")).getText();
		System.out.println(mentor);
		driver.switchTo().window(currentwindow);
		
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys(mentor);
		Thread.sleep(1000);
		driver.quit();
		

	}

}
