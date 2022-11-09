package Introduction;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import dev.failsafe.Timeout;

public class Cart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 * WebDriver driver=new ChromeDriver();
		 */
		//implicit n explicit waits
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\mubeena\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((5)));
		driver.manage().window().maximize();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		AddProductsToCart(driver, wait);

	}

	public static void AddProductsToCart(WebDriver driver, WebDriverWait wait) {
		String[] prods = { "Brocolli", "Cauliflower", "Cucumber", "Potato", "Mushroom" };
		List<WebElement> veggies = driver.findElements(By.cssSelector("h4[class='product-name']"));
		int j = 0;
		for (int i = 0; i < veggies.size(); i++) {
			String name = veggies.get(i).getText();
			String[] names = name.split("-");
			String formattedname = names[0].trim(); // trim is to remove spaces
			List expectedprods = Arrays.asList(prods);
			if (j > expectedprods.size()) {
				break;
			}

			if (expectedprods.contains(formattedname)) {
				j++;
				System.out.print(names[0] + "" + formattedname);
				System.out.println();
				driver.findElements(By.cssSelector("div[class='product-action']")).get(i).click();
			}
		}
		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoCode")));
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='promoInfo']")));
		String code = driver.findElement(By.cssSelector("span[class='promoInfo']")).getText();
		System.out.println("promo code message: " + code);
		Assert.assertEquals("Code applied ..!", code);
		driver.quit();
	}
}
