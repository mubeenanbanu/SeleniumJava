package pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="[class='card-body']")
	List<WebElement> products ;
	

	@FindBy(css=".ng-animating")
	WebElement spinner ;
	
	@FindBy(css="button[routerLink='/dashboard/cart']")
	WebElement cartButton;
	
	By product1 =By.tagName("b");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toastmessage=By.id("toast-container");
	
	
	public List<WebElement> GetProducts()
	{
		return products;
	}
	public WebElement GetProductByName(String productname)
	{
		
		WebElement prod=GetProducts().stream().filter(product->product.findElement(product1).getText().equals(productname)).findFirst().orElse(null);
		return prod;
	}
	
	public void AddProductToCart(String productname) throws InterruptedException
	{
		GetProductByName(productname).findElement(addToCart).click();
		WaitForElementToLoad(toastmessage);
		WaitForElementToInvisible(spinner);
		Thread.sleep(1000);
		//headers
	
	}

}
