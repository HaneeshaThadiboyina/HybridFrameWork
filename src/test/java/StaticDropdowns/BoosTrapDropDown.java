package StaticDropdowns;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BoosTrapDropDown {
	
	@Test
	public void BoosTrapDropDown()
	{
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();//open the drop down
	driver.findElement(By.xpath("//input[@value='Java']")).click();//to select only one value/single element
	List<WebElement> TotalElements = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//label"));//total no.of elements
	System.out.println("Total number of elements "+TotalElements.size());
	
	for (WebElement TE : TotalElements)// print all the elements 
	{
		System.out.println(TE.getText());
	}
	
	for (WebElement TE : TotalElements) //to elect multiple options
	{
		if(TE.getText().equals("C#")||TE.getText().equals("Python")||TE.getText().equals("Oracle"))
		{
		TE.click();
		}
	}
	
	driver.quit();
	}

}
