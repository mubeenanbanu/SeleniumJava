package FrameworkPractise.Practise;



import java.time.Duration;
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

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws InterruptedException 
     */
    @Test
    public static void OpenCart() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.opencart.com/index.php");
        driver.manage().window().maximize();
     
        List<WebElement> laptops=driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li[2]//a"));
        Actions a=new Actions(driver);
        a.moveToElement(laptops.stream().filter(p->p.getText().equalsIgnoreCase("Laptops & Notebooks")).findFirst().orElse(null)).perform();
        a.moveToElement(laptops.stream().filter(p->p.getText().equalsIgnoreCase("Show All Laptops & Notebooks")).
        		findFirst().orElse(null)).click().perform();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-list\"]")));
        List<WebElement> availableLaptops=driver.findElements(By.xpath("//*[@class='description']//a"));
        int count=0;
        for(WebElement l:availableLaptops)
        {
        	if(l.getText().equalsIgnoreCase("MacBook"))
        	{
        		
        		break;
        	}
//        	List<WebElement> addtocartButtons=l.findElements(By.xpath("/parent::h4/parent::div/following-sibling::div/button[1]"));
//        	addtocartButtons.get(count).click();
//        	count++;
        	
        }
        
        Thread.sleep(1000);
//        WebElement lap=availableLaptops.stream().filter(p->p.getText().equalsIgnoreCase("MacBook")).findFirst().orElse(null);
//        System.out.println(lap.getText());
//        lap.findElements(By.xpath("/parent::h4/parent::div/following-sibling::div/button[1]"));
       
        driver.close();
        
    }
}
