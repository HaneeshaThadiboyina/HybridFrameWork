package ReadDataFromTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicTableandStaleEleExep {
	
	@Test
	public void dynamictable()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		List<WebElement> Pages = driver.findElements(By.xpath("//ul[@class='pagination']//li"));
		List<WebElement> names_rows = driver.findElements(By.xpath("//table[@id='productTable']//tr//td[2]"));
		List<WebElement> prices_rows = driver.findElements(By.xpath("//table[@id='productTable']//tr//td[3]"));
		
		int no_Of_Pages = Pages.size();
		int no_of_rows = names_rows.size();
		
		System.out.println("no_Of_Pages are "+no_Of_Pages);
		System.out.println("no_of_rows are "+no_of_rows);
		
		for(int p=0;p<no_Of_Pages;p++)
		{
			String value = Pages.get(p).getText();
			int i = Integer.parseInt(value);
			System.out.println(value);
			for(int r=0;r<no_of_rows;r++)
			{
				try
			{
				String email = names_rows.get(r).getText();
				String Prices = prices_rows.get(r).getText();
				System.out.println(email+"\t"+Prices+"\t");
			}catch(StaleElementReferenceException e)
				{
				names_rows = driver.findElements(By.xpath("//table[@id='productTable']//tr//td[2]"));
			    prices_rows = driver.findElements(By.xpath("//table[@id='productTable']//tr//td[3]"));
			    String email = names_rows.get(r).getText();
				String Prices = prices_rows.get(r).getText();
				System.out.println(email+"\t"+Prices+"\t");
				}
			}
			
			if(i==no_Of_Pages)
			{
				break;
			}
			else
			{
				Pages.get(i).click();
			}
			
		}
		
		driver.quit();
		
		
		
	}
	

}
