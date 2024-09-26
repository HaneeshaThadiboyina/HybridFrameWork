package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MethodAnnotation {
	@BeforeMethod
	void login() 
	{
	System.out.println("logged in into the page");	
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
		System.out.println("Logged out of the page");
	}

}
