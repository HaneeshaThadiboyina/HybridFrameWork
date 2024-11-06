package HandlingAlerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Alerts {
	@Test
	public void handlingAlerts() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		//explicit wait instance
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//handling normal alert have only ok button
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Alert MyAlert = driver.switchTo().alert();
		System.out.println(MyAlert.getText());
		Thread.sleep(3000);
		MyAlert.accept();
		
		//handling confirmation alert have ok and cancel button
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		Alert CifAlert = driver.switchTo().alert();
		System.out.println(CifAlert.getText());
		Thread.sleep(3000);
		//CifAlert.accept();
		CifAlert.dismiss();
		
		//handling confirmation alert have input box, ok and cancel button
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert myPromtAlert = driver.switchTo().alert();
		System.out.println(myPromtAlert.getText());
		Thread.sleep(3000);
		myPromtAlert.sendKeys("welcome");
		//myPromtAlert.accept();
		myPromtAlert.dismiss();
		
//		//using explicit wait instead of switch
//		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
//		Alert alert = mywait.until(ExpectedConditions.alertIsPresent());
//		System.out.println(alert.getText());
//		Thread.sleep(3000);
//		alert.accept();
		
		driver.quit();
	}

}
