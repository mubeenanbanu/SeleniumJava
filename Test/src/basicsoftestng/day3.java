package basicsoftestng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {
	@BeforeSuite
	public void bfsuite()
	{
		System.out.println("before suite method day3");
	}

//	@Parameters({"testURL"})
	@Test
	public void WebloginCarLoan()
	{
		System.out.println("WebloginCar");
		//System.out.println(s);
		
	}
	@Test
	public void MobileloginCarLoan()
	{
		System.out.println("MobileloginCar");
	}
	@Test(timeOut=4000)//wait till 4secs 
	public void MobilesignoutCarLoan()
	{
		System.out.println("MobilesignoutCar");
	}
	@Test(dataProvider="getData")
	public void MobilesigninCarLoan(String user,String pwd)
	{
		System.out.println("MobilesigninCar");
		System.out.println(user);
		System.out.println(pwd);
	}
	@Test(groups={"smoke"})
	public void APILogincarloan()
	{
		System.out.println("APIloginCar");
	}
	@AfterTest
	public void cleanup()
	{
		System.out.println("after test method in day3");
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[3][2];
		
		data[0][0]="firstuser";
		data[0][1]="firstpassword";
		data[1][0]="seconduser";
		data[1][1]="secondtpassword";
		data[2][0]="thirduser";
		data[2][1]="thirdpassword";
		return data;
		
	}

}
