package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assign2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("tester");
		driver.findElement(By.name("email")).sendKeys("tester@tester.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("tester@123");
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement dropdown=driver.findElement(By.id("exampleFormControlSelect1"));
		Select s=new Select(dropdown);
		s.selectByVisibleText("Female");
		driver.findElement(By.id("inlineRadio2")).click();
		driver.findElement(By.name("bday")).click();
		driver.findElement(By.name("bday")).sendKeys(Keys.ENTER);
		driver.findElement(By.className("btn-success")).submit();
		System.out.println(driver.findElement(By.cssSelector("div[class*='alert alert-success alert-dismissible']")).getText());
		driver.quit();
		
	}

}
