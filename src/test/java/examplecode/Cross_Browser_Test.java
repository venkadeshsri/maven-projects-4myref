package examplecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Cross_Browser_Test {
	
	//static WebDriver driver;
	
	public static void main (String args[])
	{
		String browsername = "firefox";
		WebDriver driver =null;
		
		if (browsername.equalsIgnoreCase("Chrome"))
		{			
			driver = new ChromeDriver();
			
		} else if(browsername.equalsIgnoreCase("firefox")) {
		
			driver = new FirefoxDriver();
		} else
		{
			System.out.println("Browser not found");
		}
	
    driver.manage().window().maximize();
	driver.get("https://google.com");
	System.out.println("Title is :" + driver.getTitle());
	}
}
