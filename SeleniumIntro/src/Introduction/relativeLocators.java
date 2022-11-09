package Introduction;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
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
		//Goto website take the first course name and place it in name field
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\mubeena\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/angularpractice/");
		String currentw=driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.rahulshettyacademy.com/#/");
		List<WebElement> courses=driver.findElements(By.xpath("//div[@id='courses-block']/div/div//h2/a"));
		String firstCourse=courses.get(0).getText();
		System.out.println(firstCourse);
		driver.switchTo().window(currentw);
		WebElement nameField=driver.findElement(By.name("name"));
		nameField.click();
		nameField.sendKeys(firstCourse);
		System.out.println(nameField.getRect().getDimension().getHeight());
		File src=nameField.getScreenshotAs(OutputType.FILE);
		String target=System.getProperty("user.dir")+"\\Screenshots\\sc.png";
	
		FileUtils.copyFile(src, new File(target));
//		FileUtils.copyFile(src, new File("C:\\Users\\mubeena\\sc.png"));
		driver.quit();


	}

}
