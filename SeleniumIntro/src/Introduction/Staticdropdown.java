package Introduction;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Staticdropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		UpdatedDropdown(driver);

		/*
		 * WebElement
		 * INR=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		 * Select dropdown=new Select(INR); dropdown.selectByIndex(3);
		 * Thread.sleep(1000); //List<String> currencies=
		 * System.out.println(dropdown.isMultiple());
		 * dropdown.selectByVisibleText("AED"); WebElement
		 * a=dropdown.getFirstSelectedOption(); System.out.println(a.getText());
		 * List<WebElement> currencies=dropdown.getAllSelectedOptions(); for(WebElement
		 * i: currencies) { System.out.println(i.getText()); }
		 * 
		 * 
		 * driver.quit();
		 */

	}

	public static void UpdatedDropdown(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		int i = 10;
		while (i > 1) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i--;
		}
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'adult')]/div[2]")).getText());
		driver.quit();
	}

}
