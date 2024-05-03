package examplecode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Web_Table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/webtables");
		driver.manage().window().maximize();

		// finding header & printing
		WebElement table = driver.findElement(By.xpath("//div[@role='grid']"));
		List<WebElement> headers = table.findElements(By.xpath("//div[@class='rt-thead -header']"));
		for (WebElement header : headers) {
			String text = header.getText();
			System.out.println(text);
		}

		// finding Rows & printing
		List<WebElement> rows = table.findElements(By.xpath("(//div[@role='rowgroup'])"));
		System.out.println("No.of rows are: " + rows.size());
		
        //Finding Columns
		List<WebElement> column = table.findElements(By.xpath("//*[contains(@class,'rt-td')]"));
		System.out.println("No.of column are: " + column.size());
		  
		Boolean result = false;  //Setting Boolean true or false to work correct for if statements inside the loop
		  	  
		for (WebElement columns : column) 
		{
		  
		String columnsdata = columns.getText(); 
		System.out.println(columnsdata);
			  
		if(columnsdata.equals("Gentry"))    //Verifying the text with Table
		 
		{ 
			  result = true;
			  System.out.println("\t Test passed --  " + columns.getText() + " -- Text found");
		    break;
		  
		 }
		}
		if (result == false)
		  {
			  System.out.println("Text not found");
		 
		  } Assert.assertTrue(result);
		  driver.quit();
	}
}
