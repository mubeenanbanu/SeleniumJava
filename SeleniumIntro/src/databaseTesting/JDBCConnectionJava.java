package databaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JDBCConnectionJava {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String port="3306";
		String hostname="localhost";
		Connection con=DriverManager.getConnection("jdbc:mysql://"+hostname+":"+port+"/sakila","root","Mubina@12");
		Statement s=con.createStatement();
	
		ResultSet r=s.executeQuery("select * from credentials1 where credentialid='creditbalance'");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=in");
		while(r.next())
		{
		
			driver.findElement(By.name("username")).sendKeys(r.getString("username"));
			driver.findElement(By.name("pw")).sendKeys(r.getString("passwords"));
		}
		driver.close();
		
		

	}

}
