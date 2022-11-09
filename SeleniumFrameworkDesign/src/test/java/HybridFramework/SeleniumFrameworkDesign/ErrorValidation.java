package HybridFramework.SeleniumFrameworkDesign;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import pageclasses.CheckOutPage;
import pageclasses.MyCartPage;
import pageclasses.ProductCatalogue;
import testcomponents.BaseTest;

public class ErrorValidation extends BaseTest {
	
	@Test(groups= {"ErrorHandling"})
	public void LoginErrorValidationTest()
	{
		//wrong mailid and password
		ProductCatalogue p=loginpage.LoginToApp("mubeenabanu6125@gmail.com", "Mubina@1");
		String msg=loginpage.GetErrorMessage().trim();
		Assert.assertEquals(msg, "Incorrect email or password.");
//		
		
	}
	@Test(groups= {"ErrorHandling"},retryAnalyzer=testcomponents.Retry.class)
	public void ProductValidationCheck() throws InterruptedException
	{
		String productName="ZARA COAT 3";
		ProductCatalogue p=loginpage.LoginToApp("rahulshetty@gmail.com", "Iamking@000");
		p.AddProductToCart(productName);
		MyCartPage myCart=p.ClickOnCartButton();
		Boolean flag=myCart.VerifyProductDisplay(productName);
		Assert.assertTrue(flag);//checking whether product is added to cart
		
	}
}
