package PageClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class ContactAndValidationPage{
	
	WebDriver driver;
	public CreditCardDetailsPage creditCardpage;
	public ContactAndValidationPage(WebDriver driver)
	{
	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//b[text()='Stay']/parent::div/following-sibling::div")
	public WebElement night;
	
	@FindBy(xpath="//b[text()='Room Type']/parent::div/following-sibling::div")
	public WebElement roomType;
	
	@FindBy(xpath="//b[text()='Rate']/parent::div/following-sibling::div")
	public WebElement rate;
	
	@FindBy(css="[class*='extra_services'] div:nth-child(2)")
	public WebElement extraservice;
	
	@FindBy(css="[class*='total_charges'] div:nth-child(2) h3")
	public WebElement totalCharge;
	
	@FindBy(xpath="//b[text()='Arrival']/parent::div/following-sibling::div")
	public WebElement date;
	
	@FindBy(id="clock_pms_iframe_1")
	public WebElement frame;
	
	@FindBy(id="booking_guest_attributes_e_mail")
	public WebElement email;
	
	@FindBy(id="booking_guest_attributes_last_name")
	public WebElement lastname;
	
	@FindBy(id="booking_guest_attributes_first_name")
	public WebElement firstname;
	
	@FindBy(id="booking_guest_attributes_phone_number")
	public WebElement number;
	
	@FindBy(id="booking_payment_service_credit_card_collect")
	public WebElement cc;
	
	@FindBy(id="booking_agreed")
	public WebElement checkbox;
	
	@FindBy(css="[value='Create Booking']")
	public WebElement createBooking;
	
	
	public CreditCardDetailsPage EnterContactDetails()
	{
		email.sendKeys("john@mail.com");
		lastname.sendKeys("def");
		firstname.sendKeys("abc");
		number.sendKeys("98765432");
		cc.click();
		checkbox.click();
		createBooking.click();
		creditCardpage=new CreditCardDetailsPage(driver);
		return creditCardpage;
	}
	public void SwitchtoFrame()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
	
		
	}
	public String ValidateDate()
	{
		return date.getText();
	}
	public String ValidateNights()
	{
		return night.getText();
	}
	public String ValidateRoomType()
	{
		return roomType.getText();
	}
	public String ValidateRate()
	{
		return rate.getText().split("Max")[0].trim();
	}
	public String ValidateextraService()
	{
		return extraservice.getText();
	}
	public String ValidateTotal()
	{
		return totalCharge.getText();
	}
	
}
