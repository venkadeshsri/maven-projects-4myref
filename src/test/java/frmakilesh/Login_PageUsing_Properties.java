package frmakilesh;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_PageUsing_Properties {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		WebElement search =driver.findElement(By.xpath(".//textarea[@id='APjFqb']"));
		search.sendKeys("Orangehrm");
		search.sendKeys(Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000); 
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,120)");
		File file = new File("D:\\ECLIPSE - Automation\\Automation_Testing_Files\\Test file.txt");
		FileInputStream fins=new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fins);
		Thread.sleep(5000);
		for(int i=1;i<=5;i++)
		{
			
			driver.get(prop.getProperty("url").indent(i));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20000));
			WebElement username = driver.findElement(By.xpath(".//input[@name='username']"));
			username.sendKeys(prop.getProperty("username"));
			WebElement Password = driver.findElement(By.xpath(".//input[@name='password']"));
			Password.sendKeys(prop.getProperty("password"));
			WebElement login = driver.findElement(By.xpath(".//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
			login.submit();
			WebElement tab=driver.findElement(By.xpath(".//span[@class='oxd-userdropdown-tab']"));
			tab.click();
			Thread.sleep(5000);
			WebElement logout=driver.findElement(By.xpath("(.//a[@class='oxd-userdropdown-link'])[4]"));
			logout.click();
			//i++;
		}
		
		
	}

}


