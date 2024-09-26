package parameterization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider_Annotation {

	WebDriver driver;

	@BeforeClass
	void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Thread.sleep(1000);
	}

	@Test(dataProvider = "dp")
	void login(String email, String pass) throws InterruptedException {
		boolean status = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']")).isDisplayed();
		Thread.sleep(1000);
		if (status == true) {
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys(email);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}

	@AfterClass
	void teardown() {
		driver.quit();

	}

	@DataProvider(name="dp", indices = {1,2})
	Object getData()
	{
		Object data[][] = 
			{
				{"haneesha","haneesha123"},
				{"Admin","admin123"},
					{"kartheek","ks12234"}
				
		};
		return data;
	}
}
