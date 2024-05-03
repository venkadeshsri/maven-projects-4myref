package examplecode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Datepicker {

	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub

        WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/#date-range");
		driver.manage().window().maximize();
		
		//List<WebElement> iframeElements = driver.findElements(By.tagName("iframeResult"));
		//System.out.println("Total number of iframes are " + iframeElements.size());
		
		
 
		//driver.switchTo().frame( driver.findElement(By.cssSelector(".demo-frame")));
		driver.switchTo().frame( driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement dttext = driver.findElement(By.xpath("(//input[@id='from'])[1]"));
        dttext.click();    
   
        //Month
       WebElement monthddl = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
       Select monthddlistbox = new Select(monthddl);
       monthddlistbox.selectByVisibleText("Sep");
       
	    String date_to_select = "12";
	    
	   List<WebElement> dates_in_Cal = driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[1]//td"));
	   
	   
	   for (WebElement dt_new : dates_in_Cal)
	   {
		   String dtcomp = dt_new.getText();
		   
		   if (dtcomp.equals(date_to_select))
		   {
			   dt_new.click();
			   break;
		   }
		   
	   }
  
	   WebElement to_date = driver.findElement(By.xpath("//input[@id='to']"));
	   to_date.click();
	   
	   Select to_date_month = new Select(driver.findElement(By.xpath("//select[@aria-label='Select month']")));
	   to_date_month.selectByVisibleText("Nov");
	    
	    String todate_to_select = "29";
	    
	  List<WebElement> todates_in_Cal = driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[1]//td"));
	   
	   
	   for (WebElement todt_new : todates_in_Cal)
	   {
		   String todtcomp = todt_new.getText();
		    
		   if (todtcomp.equals(todate_to_select))
		   {
			   todt_new.click();
			   System.out.println("Selected date:" + todtcomp);
			   break;
			   
			   
		   }
		  	   }
		
	}

}
