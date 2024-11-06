package Frames;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Argument;

public class frames_Iframes {
	
	@Test
	public void switchToFrames()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;//use this for element clickable exception
		
		//FRAME 1
		WebElement Frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(Frame1);//SWITCH TO FRAME 1
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("selenium");//INTERACT WITH ELEMENTS
		
		//COME BACK TO MAIN PAGE
		driver.switchTo().defaultContent();
		
		//FRAME2
		WebElement Frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(Frame2);//SWITCH TO FRAME 2
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Java");//INTERACT WITH ELEMENT
		
		//COME BACK TO MAIN PAGE
	    driver.switchTo().defaultContent();
	    
		//FRAME3
		WebElement Frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(Frame3); //SWITCH TO FRAME 3
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Cucumber");//INTERACT WITH ELEMENT
		driver.switchTo().frame(0);//switch to iframe inside frame 3
		//driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']")).click();//INTERACT WITH ELEMENT in iframe
		//INTERACT WITH ELEMENT in iframe using javascript
		WebElement rdbut = driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']"));
		js.executeScript("arguments[0].click();", rdbut);
		
	    
		//COME BACK TO MAIN PAGE
	    driver.switchTo().defaultContent();
	    
	    //FRAME 5
	    WebElement Frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(Frame5); //SWITCH TO FRAME 5
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("C#");
		WebElement link = driver.findElement(By.linkText("https://a9t9.com"));
		js.executeScript("arguments[0].click();", link);
		WebElement image = driver.findElement(By.xpath("//img[@alt='UI Vision by a9t9 software - Image-Driven Automation']"));
		try {
		if(image.isDisplayed())
		{
			assertTrue(true);
			System.out.println("Image is displaying");
		}
		else
		{
			assertTrue(false);
		}
		}catch(Exception e) {
			Assert.fail();
		}
	
		driver.quit();
		
	}

}
