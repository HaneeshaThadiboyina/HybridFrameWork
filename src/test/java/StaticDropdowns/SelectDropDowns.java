package StaticDropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectDropDowns {
	
	@Test
	public void selectDropDowns()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement dropCountryele = driver.findElement(By.xpath("//select[@id='country']"));
		Select dropCountry = new Select(dropCountryele);//to select options from the drop down
		
		//dropCountry.selectByVisibleText("India");
		//dropCountry.selectByValue("japan");
		//dropCountry.selectByIndex(2);
		
		List<WebElement> options = dropCountry.getOptions();
		System.out.println(options.size());
//		for(int i=0; i<options.size();i++)
//		{
//			System.out.println(options.get(i).getText());
//		}
		
		for (WebElement op : options) {
			System.out.println(op.getText());
		}
		
		
		driver.quit();		
		
	}

}
