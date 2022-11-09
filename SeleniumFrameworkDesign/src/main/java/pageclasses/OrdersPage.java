package pageclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class OrdersPage extends AbstractComponent {
	WebDriver driver;
	public OrdersPage(WebDriver driver)
	{
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderproducts;
	
	
	
	
	public List<WebElement> GetOrderProducts()
	{
		return orderproducts;
	}
	public boolean VerifyOrderDisplay(String productName)
	{
		boolean flag =GetOrderProducts().stream().anyMatch(p->p.getText().equalsIgnoreCase(productName));
		return flag;
	}

	

}
