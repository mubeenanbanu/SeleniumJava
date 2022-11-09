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
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.className("blinkingText")).click();
		String currentWindow = driver.getWindowHandle();
		Set<String> childWindows = driver.getWindowHandles();
		// we can do with for loop also
//		for(String i:childWindows)
//		{
//			if(i!=currentWindow)
//			{
//				driver.switchTo().window(i);
//			}
//		}
		Iterator<String> it=childWindows.iterator();
		String parentId=it.next();
		String childId=it.next();
		driver.switchTo().window(childId);

		String para = driver.findElement(By.cssSelector("p[class*='red']")).getText();
		// driver.switchTo().window(currentWindow);

		String username = para.split("at")[1].trim().split(" ")[0];
		System.out.println(username);
		driver.switchTo().window(parentId);

		driver.findElement(By.name("username")).sendKeys(username);
		Thread.sleep(1000);
		driver.quit();

	}

}
