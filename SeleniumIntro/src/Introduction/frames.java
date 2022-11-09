package Introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//frames can switched with webelement, id, index
		driver.get("https://jqueryui.com/droppable/");
		try
		{
			System.out.println(driver.findElements(By.tagName("iframe")).size());
			driver.switchTo().frame(0);
			//driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
			Actions a=new Actions(driver);
			WebElement source=driver.findElement(By.id("draggable"));
			WebElement target=driver.findElement(By.id("droppable"));
			a.dragAndDrop(source, target).perform();
			String h=driver.findElement(By.cssSelector("div[id='droppable']")).getAttribute("class");
			if(h.contains("ui-state-highlight"))
			{
				Assert.assertTrue(true);
				System.out.println("dropped");
			}
			driver.switchTo().defaultContent();
			driver.quit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		

	}

}
