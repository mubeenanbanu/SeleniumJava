package Introduction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.jdbc.Driver;

public class calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		String expectedMonth="December";
//		String expectedYear="2022";
	
//		driver.findElement(By.id("form-field-travel_comp_date")).click();
//		String actualDate=driver.findElement(By.className("cur-month")).getText();
//		System.out.println(actualDate);
//		while(!actualDate.contains(expectedMonth))
//		{
//			driver.findElement(By.cssSelector("span[class='flatpickr-next-month'] svg")).click();
//		}
//		List<WebElement> days=driver.findElements(By.className("flatpickr-day"));
//		for(int i=0;i<days.size();i++)
//		{
//			if(days.get(i).getText().contains("26"))
//			{
//				days.get(i).click();
//			}
//		}
		//HandleCalendar( driver );
		HandleCalendar1(driver);
		
		driver.quit();

	}
	public static void HandleCalendar(WebDriver driver )
	{
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.findElement(By.id("form-field-travel_comp_date")).click();


		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May"))
		{
		driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}


		List<WebElement> dates= driver.findElements(By.className("day"));
		//Grab common attribute//Put into list and iterate
		int count=driver.findElements(By.className("day")).size();

		for(int i=0;i<count;i++)
		{
		String text=dates.get(i).getText();
		if(text.equalsIgnoreCase("21"))
		{
		dates.get(i).click();
		break;
		}
		}

	}
	public static void HandleCalendar1(WebDriver driver ) throws InterruptedException
	{
		driver.get("https://www.clock-software.com/demo-clockpms/index.html");
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("date-start")));
		driver.findElement(By.id("date-start")).click();
		String expectedMonth="Dec";
		String expectedYear="2022";
		String day="22";
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
		System.out.println(dismonth);
	
		Thread.sleep(3000);
		List<WebElement> dates= driver.findElements(By.xpath("//div[@class='datepicker-days']/table/tbody/tr[4]/td[3]"));
		for(int i=0;i<dates.size();i++)
		{
			if(dates.get(i).getText().equalsIgnoreCase(day))
			{
				dates.get(i).click();
			}
		}
	}
		
}


