package StaticDropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HiddenDropDown {
	
	@Test
	public void HiddenDropDown()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		
		driver.findElement(By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[7]/div[1]/div[2]/div[1]/div[1]")).click();
		//driver.findElement(By.xpath("//span[normalize-space()='java']")).click();
		List<WebElement> TotalEle = driver.findElements(By.xpath("//div[@role ='listbox']//span"));
		System.out.println(TotalEle.size());
		
		for (WebElement TE : TotalEle) 
		{
			System.out.println(TE.getText());
		}
		
		for (WebElement TE : TotalEle)
		{
			if(TE.getText().equals("Json"))
			{
				TE.click();
			}
			
			driver.quit();
		}
		
		
		
		//NOTE: to get hidden drop down we use selectors hub->debug->select drop down
		//OR we go event listeners remove blur from it
	
	}

}
