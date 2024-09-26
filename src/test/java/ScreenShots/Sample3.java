//Multiple screenshots
//NEW THING FOR TIME STAMP (System.currentTimeMillis())
package ScreenShots;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample3 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");
		Sample3.captureMulScrshots(driver,"HomePage");
		driver.findElement(By.name("q")).sendKeys("Knowledge share");
		Sample3.captureMulScrshots(driver,"NextPage");
		driver.close();

	}

	/*public static void capture(WebDriver driver) throws IOException, InterruptedException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenShot\\" + System.currentTimeMillis() + ".PNG");
		FileUtils.copyFile(src, trg);
		}*/
	
	public static void captureMulScrshots(WebDriver driver,String Name) throws IOException, InterruptedException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenShot\\" + Name + ".PNG");
		FileUtils.copyFile(src, trg);
	}

}

