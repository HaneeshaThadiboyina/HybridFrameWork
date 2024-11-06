package ReadDataFromTable;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LeastValueFromTable {
	
	@Test
	public void leastvaluefromtable()
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//select[@name='fromPort']")).sendKeys("Paris");
		driver.findElement(By.xpath("//select[@name='toPort']")).sendKeys("London");
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		List<WebElement> priceElements = driver.findElements(By.xpath("//table[@class='table']//tr//td[6]"));
		List<WebElement> links= driver.findElements(By.xpath("//table[@class='table']//tr//td[1]//input[@type='submit']"));
		int rows = priceElements.size();
		float[] prices = new float[rows];
		for(int i=0;i<rows;i++)
		{
			String pricetext= priceElements.get(i).getText().replace("$", "").trim();
			prices[i] = Float.parseFloat(pricetext);
		}
		//copied the prices value to the sorted value as it is
		float[] sortedValues = Arrays.copyOf(prices, prices.length);
		Arrays.sort(sortedValues);
		float Leastvalue = sortedValues[0];
		
	
		for(int i=1;i<=rows;i++)
		{
			if(prices[i-1]==Leastvalue)
			{
				links.get(i).click();
				break;
			}
			
		}
		
		
		
	}

}
