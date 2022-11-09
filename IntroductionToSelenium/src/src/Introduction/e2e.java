package Introduction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='DED']")));
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='DED']"))
				.click();
		
		// driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr[2]/td[6]")).click();
		// Assert.assertFalse(driver.findElement(By.id("Div1")).isEnabled());
		String roundTrip = driver.findElement(By.xpath("//table[@id='ctl00_mainContent_rbtnl_Trip']//td/label"))
				.getAttribute("class");

		if (!roundTrip.contains("select-label")) {
			Assert.assertTrue(true);
			System.out.println("round trip radio button is disabled");
		} else {
			Assert.assertFalse(false);
		}
		driver.findElement(By.id("divpaxinfo")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hrefIncAdt")));
		int i = 4;
		while (i > 1) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i--;
		}
		System.out.println("no. of adults selected are : " + driver.findElement(By.id("divpaxinfo")).getText());
		WebElement currency = driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));
		Select s = new Select(currency);
		s.selectByIndex(1);
		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.quit();

	}

}
