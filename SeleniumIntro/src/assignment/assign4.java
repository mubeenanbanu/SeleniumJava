package assignment;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assign4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://the-internet.herokuapp.com/");
		WindowHandle(driver);
		driver.quit();
	}
	public static void  WindowHandle(WebDriver driver)
	{
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String currentWindow=it.next();
		String childWindow=it.next();
		driver.switchTo().window(childWindow);
		System.out.println(driver.findElement(By.cssSelector("div h3")).getText());
		driver.switchTo().window(currentWindow);
		System.out.println(driver.findElement(By.cssSelector("div h3")).getText());
		
	}

}
