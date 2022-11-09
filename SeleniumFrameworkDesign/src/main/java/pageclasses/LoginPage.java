package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponents.AbstractComponent;

public class LoginPage extends AbstractComponent{
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	

	@FindBy(css="#userEmail")
	WebElement Username;
	
	@FindBy(css="#userPassword")
	WebElement Password;
	
	@FindBy(id="login")
	WebElement Submit;
	
//	@FindBy(className="ng-tns-c4-3 toast-message ng-star-inserted")
//	WebElement errorMessage;
	
	
	@FindBy(css="div[aria-label='Incorrect email or password.']")
	WebElement errorMessage;
	
	
	public ProductCatalogue LoginToApp(String username,String password)
	{
		Username.sendKeys(username);
		Password.sendKeys(password);
		Submit.click();
		ProductCatalogue pc=new ProductCatalogue(driver);
		return pc;
				
	}
	public void GoTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	public String GetErrorMessage()
	
	{
		WaitForWebElementToLoad(errorMessage);
		return errorMessage.getText();
	}

}
