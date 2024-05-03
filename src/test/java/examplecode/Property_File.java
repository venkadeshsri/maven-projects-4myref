package examplecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Property_File {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
			
			FileInputStream fip = new FileInputStream("D:\\ECLIPSE - Automation\\Automation-Selenium\\PageObjectModel\\src\\main\\java\\config\\login.properties");
			Properties prop = new Properties();
			prop.load(fip);
		    

		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium Jar\\chromedriver-win64\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(prop.getProperty("url"));

