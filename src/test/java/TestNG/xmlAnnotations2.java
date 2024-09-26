package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class xmlAnnotations2 {
	
	
	@Test()
	void advanceSearch()
	{
		System.out.println("advance search");
	}
	@AfterTest
	void logOut()
	{
		System.out.println("Logged out of the page");
	}

}
