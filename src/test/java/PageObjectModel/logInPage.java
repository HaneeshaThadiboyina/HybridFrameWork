package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class logInPage {
	WebDriver driver;
	//constructor
	logInPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//locator
	By txt_userName_loc = By.xpath("//input[@name='username']");
	By txt_pass_loc = By.xpath("//input[@name='password']");
	By btn_logIn_loc = By.xpath("//button[@type='submit']");
	
	//action method
	
	public void setUserName(String User)
	{
		driver.findElement(txt_userName_loc).sendKeys(User);
	}
	
	public void setPassword(String Password)
	{
		driver.findElement(txt_pass_loc).sendKeys(Password);
	}
	
	public void submit()
	{
		driver.findElement(btn_logIn_loc).click();
	}

}
