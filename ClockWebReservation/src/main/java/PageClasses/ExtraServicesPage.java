package PageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class ExtraServicesPage extends AbstractComponent{
	
	WebDriver driver;
	public ContactAndValidationPage cvpage;
	public ExtraServicesPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="commit")
	public WebElement commit;
	
	@FindBy(id="clock_pms_iframe_1")
	public WebElement frame;
	
	@FindBy(xpath="//*[@Placeholder='Quantity'][1]")
	public List<WebElement> services;
	
	By a=By.cssSelector("[class*='panel-default']");
	
	public ContactAndValidationPage AddExtraService()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		visibilityOfElementLocated(a);
		services.get(0).sendKeys("1");
		services.get(1).sendKeys("1");
		commit.click();
		cvpage=new ContactAndValidationPage(driver);
		return cvpage ;
	}
	


}
