package basicsoftestng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2 {

	@Test
	public void demo2()
	{
		System.out.println("hello in day2");
	}
	@BeforeTest
	public void prerequisite()
	{
		System.out.println("before test method in day2 ");
		
	}
	@AfterTest
	public void aftertest()
	{
		System.out.println("after test method in day2 ");
		
	}
	@BeforeSuite
	public void bfsuite()
	{
		System.out.println("before suite method day2");
	}

}
