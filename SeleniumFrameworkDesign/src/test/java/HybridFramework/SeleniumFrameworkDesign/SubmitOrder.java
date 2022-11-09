package HybridFramework.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageclasses.CheckOutPage;
import pageclasses.ConfirmPage;
import pageclasses.LoginPage;
import pageclasses.MyCartPage;
import pageclasses.OrdersPage;
import pageclasses.ProductCatalogue;
import testcomponents.BaseTest;

public class SubmitOrder extends BaseTest {

	@Test(dataProvider= "GetData" ,groups= {"Purchase"})
	public  void SubmitOrderTest(HashMap<String,String> input) throws IOException, InterruptedException {
		
		String name="mubeena";
		String cvv="456";
		String country="India";
		ProductCatalogue p=loginpage.LoginToApp(input.get("username"), input.get("password"));
		p.AddProductToCart(input.get("productName"));
		MyCartPage myCart=p.ClickOnCartButton();
		Boolean flag=myCart.VerifyProductDisplay(input.get("productName"));
		Assert.assertTrue(flag);//checking whether product is added to cart
		CheckOutPage chkpage=myCart.ClickOnCheckOut();

		ConfirmPage cp=chkpage.PlaceOrder( cvv,name, country);
		Assert.assertEquals(cp.ValidateOrder(), "THANKYOU FOR THE ORDER.");
		System.out.println("Order ID: "+cp.PrintOrderID());
		

	}
	//@Test(dependsOnMethods= {"SubmitOrderTest"})
	@Test(retryAnalyzer=testcomponents.Retry.class)
	public void CartValidationCheck()
	{
		String productName="ZARA COAT 3";
		ProductCatalogue p=loginpage.LoginToApp("mubeenabanu6125@gmail.com", "Mubina@12");
		
		OrdersPage op=p.ClickOnOrderButton();//abstract component bcz its a header
		boolean flag=op.VerifyOrderDisplay(productName);
		Assert.assertTrue(flag);

	}
	
	@DataProvider
	public Object[][] GetData()
	{
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("username", "mubeenabanu6125@gmail.com");
		map.put("password", "Mubina@12");
		map.put("productName", "ZARA COAT 3");
		
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("username", "rahulshetty@gmail.com");
		map1.put("password", "Iamking@000");
		map1.put("productName","ADIDAS ORIGINAL");
		
		return new Object[][] {{map},{map1}};
	}
//	@DataProvider
//	public Object[][] GetData() throws IOException
//	{
//		List<HashMap<String,String>>  data=GetJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\data\\data.json");
//		return new Object[][] {{data.get(0)},{data.get(1)}};
//	}
	
	
//	public Object[][] GetData()
//	{
//		return new Object[][] {{"mubeenabanu6125@gmail.com", "Mubina@12","ZARA COAT 3"},{"rahulshetty@gmail.com", "Iamking@000","ADIDAS ORIGINAL"}};
//	}
}
