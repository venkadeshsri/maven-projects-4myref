package examplecode;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alertwindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		WebElement textb = driver.findElement(By.xpath("//input[@id='name']"));
		textb.click();
		textb.sendKeys("Testing");
		
		WebElement alertb = driver.findElement(By.xpath("//input[@id='alertbtn']"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		alertb.click();
		
		driver.switchTo().alert().accept();
		
		textb.click();
		textb.sendKeys("Testing for second time");
		
		WebElement confirmb = driver.findElement(By.xpath("//input[@id='confirmbtn']"));
		confirmb.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		driver.switchTo().alert().accept();
		
		
		

	}

}
