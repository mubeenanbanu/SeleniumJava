package pageclasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class ConfirmPage extends AbstractComponent{

	WebDriver driver;
	public ConfirmPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	

	
	@FindBy(className="hero-primary")
	WebElement validatemsg;
	
	@FindBy(xpath="//label[@class='ng-star-inserted']")
	WebElement orderid;
	
	
	
	public String ValidateOrder()
	{
		String msg=validatemsg.getText();
		return msg;
	}
	public String PrintOrderID()
	{
		return orderid.getText();
	}

}
