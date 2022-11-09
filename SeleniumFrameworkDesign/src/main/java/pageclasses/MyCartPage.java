package pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class MyCartPage extends AbstractComponent {
	
	
		// TODO Auto-generated constructor stub
	WebDriver driver;
	public MyCartPage(WebDriver driver)
	{
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="cartSection")
	List<WebElement> cartproducts;
	
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkOutButton;
	
	By cartProdName=By.tagName("h3");
	
	public List<WebElement> GetCartProducts()
	{
		return cartproducts;
	}
	public boolean VerifyProductDisplay(String productName)
	{
		boolean flag =GetCartProducts().stream().anyMatch(p->p.findElement(cartProdName).getText().equals(productName));
		return flag;
	}
	public CheckOutPage ClickOnCheckOut()
	{
		checkOutButton.click();
		CheckOutPage chkpage=new CheckOutPage(driver);
		return chkpage;
	}
	
	
	
	
	
}
