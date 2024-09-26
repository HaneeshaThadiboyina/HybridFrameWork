package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class xmlAnnotations1 {
	@BeforeTest
	void login() 
	{
	System.out.println("logged in into the page");	
	}
	@Test()
	void search()
	{
		System.out.println("search");
	}
	
}
