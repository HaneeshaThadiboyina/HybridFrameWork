package dynamicDropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoSuggestDropDown {
	
	@Test
	public void autosuggestdropdown()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@role='presentation']//li//div[@role='option']"));
		System.out.println("size of the elemnts " +elements.size());
		
		for (WebElement ele : elements) {
			
			if (ele.getText().equals("selenium"))
			{
				ele.click();
			}
			
		}
		
		driver.quit();
	}
}
