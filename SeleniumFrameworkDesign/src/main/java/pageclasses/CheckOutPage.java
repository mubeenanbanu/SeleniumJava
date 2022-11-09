package pageclasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{

	WebDriver driver;
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement cvv;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement name;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css="section[class*='ta-results'] button span")
	List<WebElement> countries;
	
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement placeorderButton;
	
	@FindBy(className="hero-primary")
	WebElement validatemsg;
	
	@FindBy(xpath="//label[@class='ng-star-inserted']")
	WebElement orderid;
	
	public ConfirmPage PlaceOrder(String cardcvv,String cardname,String personcountry)
	{
		cvv.sendKeys(cardcvv);
		name.sendKeys(cardname);
		country.sendKeys(personcountry);
		
		WebElement c=countries.stream().filter(p->p.getText().equalsIgnoreCase(personcountry)).findFirst().orElse(null);
		//returning webelemnet which given country from list of countries
		c.click();
		placeorderButton.click();
		ConfirmPage cp=new ConfirmPage(driver);
		return cp;
	}
//	
//	public String ValidateOrder()
//	{
//		String msg=validatemsg.getText();
//		return msg;
//	}
//	public String PrintOrderID()
//	{
//		return orderid.getText();
//	}

}
