//Screenshots using driver

//NEW THING FOR TIME  STAMP 
//(Date currentDate = new Date();
//String Datefile = currentDate.toString().replace(" ", "-").replace(":", "-"); )
package ScreenShots;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		           
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		Date currentDate = new Date();
		String Datefile = currentDate.toString().replace(" ", "-").replace(":", "-"); 
		System.out.println(currentDate);
		
		//Full Page screenShot
		/*TakesScreenshot ts =(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenShot\\\"+Datefile+\".PNG");
		FileUtils.copyFile(src, trg);
		Thread.sleep(1000);*/
		
		//Particular portion of the page screenshot
		Thread.sleep(1000);
		WebElement section = driver.findElement(By.xpath("//div[@class='imageSlideContainer']"));
		File src = section.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenShot\\"+Datefile+".PNG");
		FileUtils.copyFile(src, trg);
		
		//WebElement screenshot
		/*Thread.sleep(1000);
		WebElement ele = driver.findElement(By.xpath("//input[@class='font14 fullWidth']"));
		File src = ele.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenShot\\"+Datefile+".png");
		FileUtils.copyFile(src, trg);*/
		
		
		driver.close();
	}

}

