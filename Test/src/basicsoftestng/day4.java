package basicsoftestng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day4 {
	@Test
	public void WebloginHomeLoan()
	{
		System.out.println("Webloginhome");
		
	}
	@Test(enabled=false)
	public void MobileloginHomeLoan()
	{
		System.out.println("MobileloginHome");
	}
	//@Parameters({"testURL"})
	@Test(groups= {"smoke"})
	public void APILoginhomeloan()
	{
		System.out.println("APIloginHome");
		//System.out.println(u);
	}

	@AfterSuite
	public void aftersuite()
	{
		System.out.println("after suite method day4");
	}
	@AfterMethod
	public void method2()
	{
		System.out.println("after method in day4");
	}
	


}
