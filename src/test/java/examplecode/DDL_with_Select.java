package examplecode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DDL_with_Select {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).submit();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='PIM']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement nationalityddl = driver.findElement(By.xpath("//label[normalize-space()='Nationality']"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", nationalityddl);
		System.out.println(nationalityddl.isDisplayed());
		
		WebElement nationalddl = driver.findElement(By.xpath("(//div[@clear='false'][normalize-space()='-- Select --'])[1]"));
		System.out.println(nationalityddl.isDisplayed());
		System.out.println(nationalityddl.isEnabled());
		nationalddl.sendKeys("Un");
		

	}

}
