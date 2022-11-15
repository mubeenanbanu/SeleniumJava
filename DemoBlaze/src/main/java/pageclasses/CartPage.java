package pageclasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//tr[@class='success']/td[2]")
	public List<WebElement> productsInCart;
	
	
	public Boolean ValidateAddedProduct(String prod)
	{
		ClickOnCart();
		Boolean b = productsInCart.stream().anyMatch(p -> p.getText().equalsIgnoreCase(prod));
		return b;
	}

}
