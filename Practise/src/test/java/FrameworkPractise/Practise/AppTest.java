package FrameworkPractise.Practise;



import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AppTest 
{
    @SuppressWarnings("null")
	@Test
    public static void OpenCart() throws InterruptedException
    {
       
        WebDriver driver=new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("products")));
        List<WebElement> availableVeggies=driver.findElements(By.className("product-name"));
        int count=0;
        String[] givenproducts= {"Carrot","Beans","Potato","Apple","Mango","Pears"};
        List<String > prods=null;
        for(int i=0;i<availableVeggies.size();i++)
        {
        	prods=Arrays.asList(givenproducts);	
        	String[] veggie=availableVeggies.get(i).getText().split("-");
        
        	String veg=veggie[0].trim();
        	
        	if(prods.contains(veg))
        	{
        		Thread.sleep(500);
        		driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
        	}
        	Thread.sleep(1000);
       
        }
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='PROCEED TO CHECKOUT']")).click();
        List<WebElement> cartProddispay=driver.findElements(By.xpath("//div/table/tbody/tr/td[2]/p"));

        List<String> secondList = new ArrayList<>();   
  
        for(WebElement i:cartProddispay)
        { 
        	
        	String c=i.getText().split("-")[0].trim();
        	secondList.add(c);
        	
        }
        System.out.println("Given products "+prods);
        System.out.println("Products in the cart "+secondList);
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        driver.findElement(By.cssSelector(".chkAgree")).click();
        
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
        String msg=driver.findElement(By.xpath("//span")).getText();
        System.out.println(msg);

    
        
    }
   		
}
