package FrameworkPractise.ClockWebReservation;



import java.io.IOException;
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
import org.testng.annotations.Test;

import PageClasses.ContactAndValidationPage;
import PageClasses.CreditCardDetailsPage;
import PageClasses.ExtraServicesPage;
import PageClasses.HomePage;
import PageClasses.RommDetailsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import testcomponents.BaseTest;
import testcomponents.RetryClass;

public class AppTest extends BaseTest
{

    @Test(retryAnalyzer=RetryClass.class)
    public void Booking() throws InterruptedException, IOException
    {
		
		String expectedMonth="Sep";
		String expectedYear="2023";
		String day="22";
		String extraCost="30.00 EUR";
		String address="manyata tech park";
		String zip="577205";
		String city="bangalore";
		String state="karnataka";
		String cardno="4111111111111111";
		String expectedDate=day+" "+expectedMonth+" "+expectedYear;

		RommDetailsPage rmpage=homepage.BookDate(expectedMonth, expectedYear, day);
		rmpage.WaitForRoomsDetails();
		String actualRate=rmpage.GetRate();
		String roomCharge=rmpage.GetRoomCharges().split(" ")[0];
		ExtraServicesPage expage=rmpage.SelectRoom();
		ContactAndValidationPage cvpage=expage.AddExtraService();
		cvpage.SwitchtoFrame();

	
		Assert.assertEquals(expectedDate, cvpage.ValidateDate());
		Assert.assertEquals(cvpage.ValidateNights(), "1");
		Assert.assertEquals(cvpage.ValidateRoomType(), "Deluxe Appartment");
		Assert.assertEquals(cvpage.ValidateRate(), actualRate);
		Assert.assertEquals(cvpage.ValidateextraService(), extraCost);
		Assert.assertEquals(cvpage.ValidateTotal(), "430.00 EUR");
		CreditCardDetailsPage ccpage=cvpage.EnterContactDetails();
		ccpage.EnterCreditCardDetails(cardno, address, zip, city, state);
		String successmsg=ccpage.validateSuccessMessage();
		
    }
}
