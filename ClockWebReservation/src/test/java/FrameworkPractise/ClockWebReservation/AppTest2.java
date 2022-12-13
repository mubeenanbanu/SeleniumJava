package FrameworkPractise.ClockWebReservation;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest2 
{
   
    @org.testng.annotations.Test
    public void Booking() throws InterruptedException
    {
    	WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		ChromeOptions option=new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	driver.get("https://www.clock-software.com/demo-clockpms/index.html");
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("date-start")));
		driver.findElement(By.id("date-start")).click();
		String expectedMonth="Sep";
		String expectedYear="2023";
		String day="22";
		String expectedDate=day+" "+expectedMonth+" "+expectedYear;
		System.out.println(expectedDate);
		String n=driver.findElement(By.xpath("//th[@class='datepicker-switch'][1]")).getText();
		String dismonth=n.split(" ")[0].trim();
		String disyear=n.split(" ")[1].trim();
		
		while(!(dismonth.contains(expectedMonth) &&  disyear.equalsIgnoreCase(expectedYear)))
		{
			driver.findElement(By.xpath("//th[text()=\"»\"][1]")).click();
			n=driver.findElement(By.xpath("//th[@class='datepicker-switch'][1]")).getText();
			dismonth=n.split(" ")[0].trim();
			disyear=n.split(" ")[1].trim();
			
		}

	
		Thread.sleep(3000);
		List<WebElement> dates= driver.findElements(By.xpath("//div[@class='datepicker-days']/table/tbody/tr[4]/td"));
		for(int i=0;i<dates.size();i++)
		{
			if(dates.get(i).getText().equalsIgnoreCase(day))
			{
				dates.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//input[@value='Book now !']")).click();
		driver.switchTo().frame(driver.findElement(By.id("clock_pms_iframe_1")));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1300)");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bookable_container_15343")));
		Thread.sleep(15000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bookable_container_15343")));
		List<WebElement> packages=driver.findElements(By.xpath("//div[@id='bookable_container_15343']/div[2]/div[2]//tr[4]/td/h4"));
		//System.out.println(driver.findElement(By.xpath("//div[@id='bookable_container_15343']/div[2]/div[2]//tr[4]/td/h4[1]")).getText());
		String actualRate=packages.get(0).getText().split("\n")[0].trim();
		String roomCharges=packages.get(1).getText();	
		System.out.println("actualRate :"+actualRate);
		System.out.println("roomCharges:  "+roomCharges);
		driver.findElement(By.xpath("//div[@id='bookable_container_15343']//tr[4]/td[3]//a")).click();
		//Thread.sleep(1000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.id("clock_pms_iframe_1")));
		
		//Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,1500)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='panel-default']")));
		
//		driver.findElement(By.cssSelector("[id*='batch_charges_40f3177f17b35050e46f3ca33c810265_qty']")).sendKeys("1");
//		driver.findElement(By.cssSelector("[id*='batch_charges_d156fa2bad7905c09f9acaf2ee0487f1_qty']")).sendKeys("1");
		driver.findElements(By.xpath("//*[@Placeholder='Quantity'][1]")).get(0).sendKeys("1");
		driver.findElements(By.xpath("//*[@Placeholder='Quantity'][1]")).get(1).sendKeys("1");
		driver.findElement(By.name("commit")).click();
		//third page
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.id("clock_pms_iframe_1")));
		js.executeScript("window.scrollBy(0,1500)");
		//stay
		String displayedNights=driver.findElement(By.xpath("//b[text()='Stay']/parent::div/following-sibling::div")).getText();
		String displayedRoomType=driver.findElement(By.xpath("//b[text()='Room Type']/parent::div/following-sibling::div")).getText();
		String displayedRate=driver.findElement(By.xpath("//b[text()='Rate']/parent::div/following-sibling::div")).getText().split("Max")[0].trim();
		String displayedExtraService=driver.findElement(By.cssSelector("[class*='extra_services'] div:nth-child(2)")).getText();
		String displayedTotalCharge=driver.findElement(By.cssSelector("[class*='total_charges'] div:nth-child(2) h3")).getText();
		String displayedDate=driver.findElement(By.xpath("//b[text()='Arrival']/parent::div/following-sibling::div")).getText();
		System.out.println(displayedDate);
		System.out.println(displayedNights);
		System.out.println(displayedRoomType);
		System.out.println(displayedRate);
		System.out.println(displayedExtraService);
		System.out.println(displayedTotalCharge);
		Assert.assertEquals(expectedDate, displayedDate);
		Assert.assertEquals(actualRate, displayedRate);
		Assert.assertEquals(displayedNights, "1");
		Assert.assertEquals(displayedRoomType, "Deluxe Appartment");
		Assert.assertEquals(displayedExtraService, "30.00 EUR");
		Assert.assertEquals(displayedTotalCharge, "430.00 EUR");
		driver.findElement(By.id("booking_guest_attributes_e_mail")).sendKeys("john@mail.com");
		driver.findElement(By.id("booking_guest_attributes_last_name")).sendKeys("def");
		driver.findElement(By.id("booking_guest_attributes_first_name")).sendKeys("abc");
		driver.findElement(By.id("booking_guest_attributes_phone_number")).sendKeys("98765432");
		driver.findElement(By.id("booking_payment_service_credit_card_collect")).click();
		driver.findElement(By.id("booking_agreed")).click();
		driver.findElement(By.cssSelector("[value='Create Booking']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.id("clock_pms_iframe_1")));
		
		//card details
		driver.findElement(By.id("cardNumber")).sendKeys("4111111111111111");
		Select brand=new Select(driver.findElement(By.id("credit_card_collect_purchase_brand")));
		brand.selectByValue("visa");
		
		Select expiresMonth=new Select(driver.findElement(By.id("cardExpirationMonth")));	
		expiresMonth.selectByValue("8");
		
		Select expiresYear=new Select(driver.findElement(By.id("cardExpirationYear")));	
		expiresYear.selectByValue("2024");
		
		driver.findElement(By.id("credit_card_collect_purchase_address")).sendKeys("sarjapur");
		driver.findElement(By.id("credit_card_collect_purchase_zip")).sendKeys("567890");
		driver.findElement(By.id("credit_card_collect_purchase_city")).sendKeys("bangalore");
		driver.findElement(By.id("credit_card_collect_purchase_state")).sendKeys("karnataka");
	
		Select country=new Select(driver.findElement(By.id("credit_card_collect_purchase_country")));	
		country.selectByValue("IN");
		driver.findElement(By.cssSelector("button[class*='btn-success']")).click();
		String succesMsg=driver.findElement(By.cssSelector("[class='row'] h1:nth-child(2)")).getText();
		System.out.println(succesMsg);
		
		
		
		
		
		
    }

}
