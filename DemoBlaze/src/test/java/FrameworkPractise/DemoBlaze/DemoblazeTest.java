package FrameworkPractise.DemoBlaze;

import java.io.IOException;
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

import pageclasses.CartPage;
import pageclasses.PlaceOrderPage;
import pageclasses.ProductCataloguePage;
import testcomponents.BaseTest;

public class DemoblazeTest extends BaseTest{
//	WebDriver driver = new ChromeDriver();
	


	public void Login() throws InterruptedException, IOException {
		
//		ChromeOptions option = new ChromeOptions();
//		option.setAcceptInsecureCerts(true);
        String user="mubeena";
        String password="mub";
		
//        LaunchApplication(user,password);
//    	Boolean b=loginPage.VerifyLogOutDisplay();
//		Assert.assertEquals(b, true);
//		System.out.println("succesfully logged in");
		
//		driver.get("https://www.demoblaze.com/");
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Log in']")));
//		driver.findElement(By.xpath("//a[text()='Log in']")).click();
////		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));
//		Thread.sleep(3000);
//		driver.findElement(By.id("loginusername")).click();
//		driver.findElement(By.id("loginusername")).sendKeys("mubeena");
//		driver.findElement(By.id("loginpassword")).click();
//		driver.findElement(By.id("loginpassword")).sendKeys("mub");
//		driver.findElement(By.xpath("//*[@onclick='logIn()']")).click();
////		Thread.sleep(3000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@onclick='logOut()']")));
//		Boolean b1 = driver.findElement(By.xpath("//*[@onclick='logOut()']")).isDisplayed();
//		Assert.assertEquals(b1, true);
//		System.out.println("succesfully logged in");

	}

	@Test()
	public void AddProductToCart() throws IOException, InterruptedException
	{
		String prod = "Sony xperia z5";
		String name="mubeena";
		String creditCard="45678";
		
		ProductCataloguePage pg=LaunchApplication();
		CartPage c=pg.AddProductToCart(prod);
		boolean b=c.ValidateAddedProduct(prod);
		Assert.assertEquals(true, b);
		PlaceOrderPage po= new PlaceOrderPage(driver);
		po.PlaceOrder(name,creditCard);
		String msg=po.validateMessage();
		System.out.println(msg);
		po.Wrapup();
		
	}
}
