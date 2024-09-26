package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotations {
	@BeforeMethod
	void login() 
	{
	System.out.println("@BeforeMethod");	
	}
	@Test(priority=1)
	void search()
	{
		System.out.println("search");
	}
	@Test(priority=2)
	void advanceSearch()
	{
		System.out.println("advance search");
	}
	@AfterMethod
	void logOut()
	{
		System.out.println("@AfterMethod");
	}
	@BeforeTest
	void abc() 
	{
	System.out.println("This is before test");	
	}
	@AfterTest
	void xyz() 
	{
	System.out.println("This is after test");	
	}
	@BeforeSuite
	void pqr() 
	{
	System.out.println("This is before suite");	
	}
	@AfterSuite
	void efg() 
	{
	System.out.println("This is after suite");	
	}

}
