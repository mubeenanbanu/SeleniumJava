package basicsoftestng;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class day1 {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println("mubeena");
//
//	}
	@Parameters({"URL"})
	@Test(groups= {"smoke"})
	public void demo1(String s)
	{
		System.out.println("hi");
		System.out.println(s);
	}
	@Test(dependsOnMethods={"demo1"})
	public void a1()
	{
		System.out.println("bye");
		Assert.assertTrue(false);
	}
	@AfterTest
	public void cleanup()
	{
		System.out.println("after test method in day1");
	}
	@AfterSuite
	public void aftersuite()
	{
		System.out.println("after suite method day1");
	}
	@BeforeMethod
	public void method1()
	{
		System.out.println("before method in day1");
	}
	@AfterMethod
	public void method2()
	{
		System.out.println("after method in day1");
	}
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("before executing all methods in day1 class");
	}
	@AfterClass
	public void aeforeclass()
	{
		System.out.println("after executing all methods in day1 class");
	}
	


}
