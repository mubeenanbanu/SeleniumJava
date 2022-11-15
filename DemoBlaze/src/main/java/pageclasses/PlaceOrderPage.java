package pageclasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class PlaceOrderPage extends AbstractComponent {
	 WebDriver driver;
	public PlaceOrderPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy (xpath="//button[text()='Place Order']")
	public WebElement placeorderbutton;
	
	@FindBy (id="name")
	public WebElement name;
	
	@FindBy (id="card")
	public WebElement card;
	
	@FindBy (xpath="//button[text()='Purchase']")
	public WebElement purchase;
	
	@FindBy (css="[class*='sweet-alert'] h2")
	public WebElement msg;
	
	@FindBy (xpath="//button[text()='OK']")
	public WebElement Okbutton;
	
	public void PlaceOrder(String name1,String creditcard)
	{
		placeorderbutton.click();
		name.click();
		name.sendKeys(name1);
		card.click();
		card.sendKeys(creditcard);
		purchase.click();
	}
	public String validateMessage()
	{
		String msg1=msg.getText();
		return msg1;
//		
	}
	public void Wrapup()
	{
		Okbutton.click();
	}


}
