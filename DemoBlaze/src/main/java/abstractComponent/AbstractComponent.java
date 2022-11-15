package abstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(xpath="//a[text()='Log in']")
	public WebElement login;
	
	By loginBy= By.xpath("//a[text()='Log in'") ;
	
	@FindBy(xpath="//*[@onclick='logOut()']")
	public WebElement logout;
	
	By logoutBy =By.xpath("//*[@onclick='logOut()']");
	
	@FindBy(id="cartur")
	public WebElement cartButton;
	
	public void visibilityOfElementLocated(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void WaitforAlertPresent()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void ClickOnLogin() throws InterruptedException
	{
	visibilityOfElementLocated(loginBy);
//		Thread.sleep(3000);
		login.click();
	}
	public Boolean VerifyLogoutButton()
	{
		visibilityOfElementLocated(logoutBy);
		Boolean b=logout.isDisplayed();
		return b;
	}

	public void ClickOnCart()
	{
		cartButton.click();
	}
}
