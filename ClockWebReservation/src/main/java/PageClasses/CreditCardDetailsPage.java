package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponent.AbstractComponent;

public class CreditCardDetailsPage{
	
	WebDriver driver;
	public CreditCardDetailsPage(WebDriver driver)
	{
	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="clock_pms_iframe_1")
	public WebElement frame;
	
	@FindBy(id="cardNumber")
	public WebElement cardno;
	
	@FindBy(id="credit_card_collect_purchase_brand")
	public WebElement brand;
	
	@FindBy(id="cardExpirationMonth")
	public WebElement month;
	
	@FindBy(id="cardExpirationYear")
	public WebElement year;
	
	@FindBy(id="credit_card_collect_purchase_address")
	public WebElement address;
	
	@FindBy(id="credit_card_collect_purchase_zip")
	public WebElement zip;
	
	@FindBy(id="credit_card_collect_purchase_city")
	public WebElement city;
	
	@FindBy(id="credit_card_collect_purchase_state")
	public WebElement state;
	
	@FindBy(id="credit_card_collect_purchase_country")
	public WebElement country;
	
	@FindBy(css="button[class*='btn-success']")
	public WebElement button;
	
	@FindBy(css="[class='row'] h1:nth-child(2)")
	public WebElement msg;
	
	public void EnterCreditCardDetails(String cardnumber,String addres,String zipcode,String cityname,String statename)
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frame);
		

		cardno.sendKeys(cardnumber);
		Select brandName=new Select(brand);
		brandName.selectByValue("visa");
		
		Select expiresMonth=new Select(month);	
		expiresMonth.selectByValue("8");
		
		Select expiresYear=new Select(year);	
		expiresYear.selectByValue("2024");
		
		address.sendKeys(addres);
		zip.sendKeys(zipcode);
		city.sendKeys(cityname);
		state.sendKeys(statename);

		Select countryname=new Select(country);	
		countryname.selectByValue("IN");
		button.click();
		
	}
	
	public String validateSuccessMessage()
	{
		return msg.getText();
	}
}
