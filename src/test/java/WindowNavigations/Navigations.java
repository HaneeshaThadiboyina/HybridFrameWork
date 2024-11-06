package WindowNavigations;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Navigations {
	
	@Test
	public void windowNavigation() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//driver.navigate().to("http://www.orangehrm.com/");//to open in the same tab
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();//to open in the different tab
		//driver.navigate().back();
		//driver.navigate().forward();
		//driver.navigate().refresh();
		
		Set<String> windowIds = driver.getWindowHandles();//storing id's in a set for uniqueness
//		List<String> windowList = new ArrayList(windowIds);//convert set to list for the order processing
//		
//		String parentId = windowList.get(0);
//		String childId = windowList.get(1);
//		
//		//to switch between windows
//		//to get parent
//		driver.switchTo().window(parentId);
//		System.out.println(driver.getTitle());
//		//to get child
//		driver.switchTo().window(childId);
//		System.out.println(driver.getTitle());
		
		//if we have more windows we use looping statement and no need to convert set to list
		for (String win : windowIds)
		{
			String title = driver.switchTo().window(win).getTitle();	
			if(title.equals("OrangeHRM"))
			{
				System.out.println(driver.getCurrentUrl());
			}
			
		}
		
		driver.quit();
	}

}
