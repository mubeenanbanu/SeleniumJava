package Introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//div/div[4]/fieldset/label[2]/following-sibling::label")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.cssSelector("div div:nth-child(4) fieldset label:nth-child(4)")).getText());
		System.out.println(driver.findElement(By.xpath("//div/div[4]/fieldset/label[3]/parent::fieldset/legend")).getText());
		System.out.println(driver.findElement(By.xpath("//div/button[3]/preceding-sibling::button[1]")).getText());
		driver.quit();
		
	}

}
