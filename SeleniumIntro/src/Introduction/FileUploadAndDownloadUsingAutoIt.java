package Introduction;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileUploadAndDownloadUsingAutoIt {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mubeena\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.setAcceptInsecureCerts(true);
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.sodapdf.com/txt-to-pdf/");
		System.out.println(driver.getTitle());
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("label[for='choose-file']"));
		driver.findElement(By.cssSelector("label[for='choose-file']")).sendKeys("C:\\Users\\mubeena\\Desktop\\autoit\\New Text Document.txt");
//		Runtime.getRuntime().exec("C:\\Users\\mubeena\\Documents\\fileuploadnew.exe");
		Thread.sleep(1000);

		driver.close();

	}

}
