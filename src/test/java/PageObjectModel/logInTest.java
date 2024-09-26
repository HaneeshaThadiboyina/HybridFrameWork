package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class logInTest {
	WebDriver driver;
	
	@BeforeClass
	void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
	}
	
    @Test
	void testLogIn()
	{
    	logInPage2 lp = new logInPage2(driver);
    	lp.setUserName("Admin");;
    	lp.setPassword("admin123");
    	lp.submit();
    	
    	Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    	
	}
	
    @AfterClass
	void tearDown()
	{
		driver.quit();
	}
}
