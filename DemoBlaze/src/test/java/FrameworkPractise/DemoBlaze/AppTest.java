package FrameworkPractise.DemoBlaze;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@Test()
	public void Login() throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.setAcceptInsecureCerts(true);

		driver.get("https://www.demoblaze.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Log in']")));
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
//		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));
		Thread.sleep(3000);
		driver.findElement(By.id("loginusername")).click();
		driver.findElement(By.id("loginusername")).sendKeys("mubeena");
		driver.findElement(By.id("loginpassword")).click();
		driver.findElement(By.id("loginpassword")).sendKeys("mub");
		driver.findElement(By.xpath("//*[@onclick='logIn()']")).click();
//		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@onclick='logOut()']")));
		Boolean b1 = driver.findElement(By.xpath("//*[@onclick='logOut()']")).isDisplayed();
		Assert.assertEquals(b1, true);
		System.out.println("succesfully logged in");

	}

//	@Test(dependsOnMethods = "Login")
//	public void AddProductToCart() {
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.demoblaze.com/");
//		String prod = "Sony xperia z5";
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='card-title']/a"));
//		WebElement a = products.stream().filter(p -> p.getText().equalsIgnoreCase(prod)).findFirst().orElse(null);
//		a.click();
//		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
//		wait.until(ExpectedConditions.alertIsPresent());
//		driver.switchTo().alert().accept();
//		driver.findElement(By.id("cartur")).click();
//		List<WebElement> productsInCart = driver.findElements(By.xpath("//tr[@class='success']/td[2]"));
//		Boolean b = productsInCart.stream().anyMatch(p -> p.getText().equalsIgnoreCase(prod));
//		Assert.assertEquals(true, b);
//		
//		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
//		driver.findElement(By.id("name")).click();
//		driver.findElement(By.id("name")).sendKeys("mubeena");
//		driver.findElement(By.id("card")).click();
//		driver.findElement(By.id("card")).sendKeys("45678");
//		driver.findElement(By.xpath("//button[text()='Purchase']")).click();
//		String msg=driver.findElement(By.cssSelector("[class*='sweet-alert'] h2")).getText();
//		System.out.println(msg);
//		driver.findElement(By.xpath("//button[text()='OK']")).click();
//		driver.quit();
//
//	}

}
