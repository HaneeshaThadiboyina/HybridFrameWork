package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class logInPage2 {

	WebDriver driver;
	//constructor
	logInPage2(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//locator
	//@FindBy(how=How.XPATH,using = "//input[@name='username']")
	@FindBy(xpath="//input[@name='username']")
	WebElement txt_userName_loc;
	@FindBy(xpath="//input[@name='password']")
	WebElement txt_pass_loc;
	@FindBy(xpath="//button[@type='submit']")
	WebElement btn_logIn_loc;
	
	//action method
	public void setUserName(String User)
	{
		txt_userName_loc.sendKeys(User);
	}
	
	public void setPassword(String Password)
	{
		txt_pass_loc.sendKeys(Password);
	}
	
	public void submit()
	{
		btn_logIn_loc.click();
	}
}
