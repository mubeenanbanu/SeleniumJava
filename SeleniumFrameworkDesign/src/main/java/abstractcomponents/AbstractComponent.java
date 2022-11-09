package abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageclasses.MyCartPage;
import pageclasses.OrdersPage;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
//		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css="button[routerLink='/dashboard/cart']")
	WebElement cartButton;
	
	@FindBy(css="button[routerLink='/dashboard/myorders']")
	WebElement ordersButton;

	//dont initialize webdriverwait here
	public void WaitForElementToLoad(By findby)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public void WaitForElementToInvisible(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	public void WaitForWebElementToLoad(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	public MyCartPage ClickOnCartButton()
	{
		cartButton.click();
		MyCartPage myCart=new MyCartPage(driver);
		return myCart;
	}
	public OrdersPage ClickOnOrderButton()
	{
		ordersButton.click();
		OrdersPage op=new OrdersPage(driver);
		return op;
		
	}
	
	

}
