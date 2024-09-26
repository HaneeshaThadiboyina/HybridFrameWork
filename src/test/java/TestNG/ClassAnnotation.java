package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClassAnnotation {
	@BeforeClass
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
	@AfterClass
	void logOut()
	{
		System.out.println("Logged out of the page");
	}

}
