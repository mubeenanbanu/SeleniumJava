package pageclasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class ProductCataloguePage extends AbstractComponent{
	
	 WebDriver driver;
	public ProductCataloguePage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy (xpath="//h4[@class='card-title']/a")
	public List<WebElement> products;
	
	@FindBy (xpath="//a[text()='Add to cart']")
	public WebElement addToCart;
	
	public CartPage AddProductToCart(String prod)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement a = products.stream().filter(p -> p.getText().equalsIgnoreCase(prod)).findFirst().orElse(null);
		a.click();
		addToCart.click();
		WaitforAlertPresent();
		driver.switchTo().alert().accept();
		CartPage c=new CartPage(driver);
		return c;
	}
	
}
