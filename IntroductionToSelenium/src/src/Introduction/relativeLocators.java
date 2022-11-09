package Introduction;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

public class relativeLocators {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\mubeena\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
//		WebElement suggestbox=driver.findElement(By.cssSelector("[id='autocomplete']"));
//		//driver.findElement(By.tagName("legend")).above(suggestbox);
		driver.get("https://www.rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		//driver.switchTo().newWindow(WindowType.TAB);
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parentid=it.next();
		String childid=it.next();
		driver.switchTo().window(childid);
		driver.get("https://www.rahulshettyacademy.com/#");
		List<WebElement> courses=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"));
		String n=courses.get(1).getText();
		System.out.println(n);
		driver.switchTo().window(parentid);
		WebElement name=driver.findElement(By.name("name"));
		name.click();
		name.sendKeys(n);
		File f=name.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(f, new File("elemntscreenshot.file")); file will be stored in this project
		FileUtils.copyFile(f, new File("C:\\Users\\mubeena\\eleesc.png"));
	
		System.out.println(name.getRect().getDimension().getWidth());
		System.out.println(name.getRect().getDimension().getWidth());
		
		driver.quit();
		
//		for(WebElement i:courses)
//		{
//			String s=i.getText();
//		}
		
		
		

	}

}
