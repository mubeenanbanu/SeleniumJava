package Introduction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutoSuggestion {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait  wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//Suggestion(driver,wait);
		CheckBox(driver,wait);
		

	}

	public static void CheckBox(WebDriver driver,WebDriverWait  wait) throws InterruptedException
	{
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("label[for*='SeniorCitizen']")));
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[name*='ctl00$mainContent$chk_SeniorCitizen']")).isSelected());
		driver.findElement(By.cssSelector("input[name*='ctl00$mainContent$chk_SeniorCitizen']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='ctl00$mainContent$chk_SeniorCitizen']")).isSelected());
		
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(),6);
		Assert.assertEquals(driver.findElement(By.cssSelector("label[for*='SeniorCitizenDiscount']")).getText(),"Senior Citizen");
		System.out.println(driver.findElement(By.cssSelector("label[for*='SeniorCitizenDiscount']")).getText());
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println("is return date enabled : "+driver.findElement(By.id("Div1")).isEnabled());
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
			Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertFalse(false);
			
		}
		driver.quit();
		
	}
	public static void Suggestion(WebDriver driver,WebDriverWait wait) throws InterruptedException
	{
		Thread.sleep(1000);
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("ui-autocomplete-input"))));
		driver.findElement(By.id("autosuggest")).click();
		driver.findElement(By.id("autosuggest")).sendKeys("pa");
		
		//List<WebElement > suggestions =driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='ui-menu-item']/a")));
		List<WebElement > suggestions =driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		
		//Thread.sleep(2000);
		//List<WebElement > suggestions =driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		
		
		for(WebElement i :suggestions)
		{
			System.out.println(i.getText());
			if(i.getText().equalsIgnoreCase("Panama"))
			{
				i.click();
				System.out.println("clicked successfully");
				break;
			}
		}
		
		driver.quit();
	}


	}


