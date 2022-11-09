package Introduction;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class SSLCheckAndScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\mubeena\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		option.addArguments("start-maximized");
		
		option.setExperimentalOption("excludeSwitches",

			     Arrays.asList("disable-popup-blocking"));
		WebDriver driver = new ChromeDriver(option);
		
//		System.setProperty("webdriver.edge.driver","C:\\Users\\mubeena\\Downloads\\edgedriver_win64\\msedgedriver.exe");
//	
//		
//		EdgeOptions option1=new EdgeOptions();
//		option1.setAcceptInsecureCerts(true);
//		option1.addArguments("start-maximized");
//		WebDriver driver=new EdgeDriver(option1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\mubeena\\src.png"));
		//.img is corrupted and .png is file working
		
		//java.nio.file.AccessDeniedException if screenshot is saved in c folder
				
		driver.quit();

	}

}
