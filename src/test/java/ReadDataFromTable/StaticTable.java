package ReadDataFromTable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class StaticTable {
	
	@Test
	public void statictable()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//no.of rows
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Total no.of rows are "+rows);
		
		//no.of columns
		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Total no.of columns are "+cols);
		
		//get the data of a specific row and column
		String data = driver.findElement(By.xpath("//table[@name='BookTable']//tr[4]//td[2]")).getText();
		System.out.println(data);
		
		//get the data of all rows and columns
		System.out.println("BookName"+"\t"+"Author"+"\t"+"Subject"+"\t"+"Price");
		for(int r=2;r<=rows;r++)
		{
			for(int c=1;c<=cols;c++)
			{
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();//"+r+" this helps us to create dynamic xpath
				System.out.print(value+"\t");//\t helps us to give the space in a row format
			}
			System.out.println();
		}
		
		//get the book name when the author is mukesh
		for(int r=2;r<=rows;r++)
		{
			String Author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			if(Author.equals("Mukesh"))
			{
				String BookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(BookName+"\t"+Author);
			}
		}
		
		//total price
		int Total =0;
		for(int r=2;r<=rows;r++)
		{
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			Total = Total+Integer.parseInt(price);
		}
		System.out.println(Total);
		
		
	}

}
