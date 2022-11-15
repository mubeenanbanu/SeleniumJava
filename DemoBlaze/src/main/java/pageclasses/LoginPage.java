package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class LoginPage extends AbstractComponent{
	WebDriver driver;
	public 	ProductCataloguePage p;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="loginusername")
	public WebElement user;
	
	@FindBy(id="loginpassword")
	public WebElement pwd;
	
	@FindBy(xpath="//*[@onclick='logIn()']")
	public WebElement loginButton;
	
	
	public void LoginToApp(String user1,String pwd1) throws InterruptedException
	{
		ClickOnLogin();
		Thread.sleep(3000);
		user.click();
		user.sendKeys(user1);
		pwd.click();
		pwd.sendKeys(pwd1);
		loginButton.click();
	
	}
	public ProductCataloguePage GoTo()
	{
		driver.get("https://www.demoblaze.com/");
		p=new ProductCataloguePage(driver);
		return p;

	}


}
