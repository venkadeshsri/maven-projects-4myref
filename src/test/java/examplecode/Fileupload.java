package examplecode;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fileupload {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		driver.get("https://demoqa.com/upload-download");
		driver.manage().window().maximize();
		

		//WebElement fileup = driver.findElement(By.xpath("//input[@id='uploadFile']"));
		
		
		//Using file path
		/*
		 * WebElement fileup = driver.findElement(By.xpath("//input[@id='imgFile']"));
		 * JavascriptExecutor jse = (JavascriptExecutor) driver;
		 * jse.executeScript("arguments[0].scrollIntoView();", fileup);
		 * fileup.sendKeys("C:/Users/Venkadesh/Pictures/malaysia.jpg");
		 * System.out.println("File uploaded successfully");
		 */
			 
		    
		
		//Using Autoit
		//WebElement upbutton = driver.findElement(By.xpath("//input[@id='uploadFile']"));
		WebElement upbutton = driver.findElement(By.xpath("//label[normalize-space()='Select a file']")); 
        //JavascriptExecutor jse = (JavascriptExecutor) driver;
        //jse.executeScript("arguments[0].scrollIntoView();", upbutton);
        //jse.executeScript("arguments[0].click();", upbutton);
       upbutton.click();
        Runtime.getRuntime().exec("D:\\ECLIPSE - Automation\\Autoit\\Files\\fileupload.exe"); // used autoit file & compiled as exe
	}

}
