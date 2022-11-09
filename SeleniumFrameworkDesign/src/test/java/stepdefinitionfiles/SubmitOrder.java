package stepdefinitionfiles;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import abstractcomponents.AbstractComponent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageclasses.CheckOutPage;
import pageclasses.ConfirmPage;
import pageclasses.LoginPage;
import pageclasses.MyCartPage;
import pageclasses.ProductCatalogue;
import testcomponents.BaseTest;


public class SubmitOrder extends BaseTest{
	
	WebDriver driver;
	LoginPage loginpage;
	ProductCatalogue p;
	MyCartPage myCart;
	AbstractComponent a;
	CheckOutPage chkpage;
	ConfirmPage cp;
	
	@Given("the lets shop app for login")
	public void Given_the_lets_shop_app_for_login()
	{
		 loginpage=new LoginPage(driver);
		 loginpage.GoTo();
	}
	@Given ("^I enter the (.+) and (.+) and click on submit$")
	public void Given_I_enter_the_username_and_password_and_click_on_submit(String user,String pwd)
	{
		p=loginpage.LoginToApp(user, pwd);
	
	}
	@When("^I add product (.+) to cart$")
	public void  When_I_add_product_to_cart (String productname) throws InterruptedException
	{
		p.AddProductToCart(productname);
	}
	@And("Verify the (.+) in cart and checkout")
	public void Verify_the_product_in_cart_and_checkout(String productname)
	{
		myCart=p.ClickOnCartButton();
		Boolean flag=myCart.VerifyProductDisplay(productname);
		Assert.assertTrue(flag);//checking whether product is added to cart
	   chkpage=myCart.ClickOnCheckOut();
	}
	
    @And ("Place the order with (.+)(.+)(.+)")
    public void Place_the_order(String cvv,String name,String country)
    {
    	cp=chkpage.PlaceOrder( cvv,name, country);
    }
	
    @Then ("I validate the message {msg} is displayed")
    public void Validate_the_confirmation_page(String msg)
    {
    	Assert.assertEquals(cp.ValidateOrder(), msg);
		System.out.println("Order ID: "+cp.PrintOrderID());
    	
    }
}
