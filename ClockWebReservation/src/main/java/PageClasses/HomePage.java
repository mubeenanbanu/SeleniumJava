package PageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class HomePage extends AbstractComponent{
	public WebDriver driver;
	public RommDetailsPage rmpage;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="date-start")
	public WebElement datestart;
	
	@FindBy(xpath="//th[@class='datepicker-switch'][1]")
	public WebElement datePickerSwitch;
	
	By date =By.id("date-start");
	
	@FindBy(xpath="//th[text()=\"»\"][1]")
	public WebElement next;
	
	@FindBy(xpath="//div[@class='datepicker-days']/table/tbody/tr[4]/td")
	public List<WebElement> datePickerDays;
	
	@FindBy(name="wbe_product[nights]")
	public WebElement nights;
	
	@FindBy(xpath="//input[@value='Book now !']")
	public WebElement book;
	
	public RommDetailsPage BookDate(String expectedMonth,String expectedYear,String day) throws InterruptedException
	{
		visibilityOfElementLocated(date);
		Thread.sleep(1000);
		datestart.click();
		String n=datePickerSwitch.getText();
		String dismonth=n.split(" ")[0].trim();
		String disyear=n.split(" ")[1].trim();
		
		while(!(dismonth.contains(expectedMonth) &&  disyear.equalsIgnoreCase(expectedYear)))
		{
			next.click();
			n=datePickerSwitch.getText();
			dismonth=n.split(" ")[0].trim();
			disyear=n.split(" ")[1].trim();
			
		}
		Thread.sleep(3000);
		//List<WebElement> dates= driver.findElements(By.xpath("//div[@class='datepicker-days']/table/tbody/tr[4]/td"));
		for(int i=0;i<datePickerDays.size();i++)
		{
			if(datePickerDays.get(i).getText().equalsIgnoreCase(day))
			{
				datePickerDays.get(i).click();
				break;
			}
		}
		//nights.clear();
		nights.click();
		book.click();
		rmpage=new RommDetailsPage(driver);
		return rmpage;
		
	}
	public void GoTo()
	{
		driver.get("https://www.clock-software.com/demo-clockpms/index.html");
	}
	

}
