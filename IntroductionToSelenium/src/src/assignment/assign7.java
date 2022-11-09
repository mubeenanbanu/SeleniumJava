package assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assign7 {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
//		List<WebElement> courseDetails= driver.findElements(By.xpath("//table[@name='courses']//tbody/tr/td"));
//		for(WebElement i: courseDetails)
//		{
//			System.out.println(i.getText());
//		}
//		int sumOfPrice=0;
//		List<WebElement>prices=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/td[3]"));
//		for(int i=0;i<prices.size();i++)
//		{
//			sumOfPrice+=Integer.parseInt(prices.get(i).getText());
//		}
//		System.out.println(sumOfPrice));
		
		System.out.println("no of rows "+driver.findElements(By.xpath("//table[@name='courses']/tbody/tr")).size());
		System.out.println("no of columns "+driver.findElements(By.xpath("//table[@name='courses']/tbody/tr/th")).size());
		List<WebElement> row2=driver.findElements(By.xpath("//table[@name='courses']/tbody/tr[3]/td"));
		for(int i=0;i<row2.size();i++)
		{
			System.out.println(row2.get(i).getText());
		}
		driver.quit();
	}

}
