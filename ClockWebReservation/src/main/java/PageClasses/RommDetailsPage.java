package PageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class RommDetailsPage extends AbstractComponent {
	
	WebDriver driver;
	public ExtraServicesPage expage;
	public RommDetailsPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@id='bookable_container_15343']//tr[4]/td[3]//a")
	public WebElement select;
	
	By room=By.id("bookable_container_15343");
	
	@FindBy(xpath="//div[@id='bookable_container_15343']/div[2]/div[2]//tr[4]/td/h4")
	public List<WebElement> packages1;
	
	@FindBy(id="clock_pms_iframe_1")
	public WebElement frame;
	
	public void WaitForRoomsDetails() throws InterruptedException 
	{
		driver.switchTo().frame(frame);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1300)");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bookable_container_15343")));
		Thread.sleep(15000);
		visibilityOfElementLocated(room);	
	}
	public String GetRoomCharges()
	{
		return packages1.get(1).getText();	
	}
	public String GetRate()
	{
		return packages1.get(0).getText().split("\n")[0].trim();
	}
	public ExtraServicesPage SelectRoom()
	{
		select.click();
		expage=new ExtraServicesPage(driver);
		return expage;	
	}


}
