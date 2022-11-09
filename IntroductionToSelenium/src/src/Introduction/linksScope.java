package Introduction;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class linksScope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footer=driver.findElement(By.id("gf-BIG"));//limiting webdriver scope to footer
		System.out.println(footer.findElements(By.tagName("a")).size()); //20
		
		WebElement column=footer.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td/ul"));
		//int b=column.findElements(By.tagName("a")).size();
		System.out.println(column.findElements(By.tagName("a")).size());
		
		for(int i=0;i<column.findElements(By.tagName("a")).size();i++)
		{
			String holdTheLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			column.findElements(By.tagName("a")).get(i).sendKeys(holdTheLink);
			Thread.sleep(1000);
			
			
		}
		Set<String> tabs=driver.getWindowHandles();
		Iterator<String> it=tabs.iterator();
//		while(it.hasNext())
//		{
//			driver.switchTo().window(it.next());
		System.out.println(driver.getTitle());
//		}
		for(int i=0;i<tabs.size();i++)
		{

			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		
		
		
		
		driver.quit();

	}

}
