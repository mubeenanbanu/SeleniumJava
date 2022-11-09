package Introduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//chrome driver
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\mubeena\\Downloads\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		
		//edge driver
		System.setProperty("webdriver.edge.driver", "C:\\Users\\mubeena\\Downloads\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();

	}

}
