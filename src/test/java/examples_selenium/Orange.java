package examples_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Orange {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(4000);
		WebElement pim = driver.findElement(By.xpath("//span[normalize-space()='PIM']"));
		Thread.sleep(3000);
		pim.click();
		Thread.sleep(3000);
		WebElement EmpTab = driver.findElement(By.xpath(".//a[@class='oxd-topbar-body-nav-tab-item'][1]"));
		Thread.sleep(3000);
		System.out.println(EmpTab.isDisplayed());
		System.out.println(EmpTab.isEnabled());
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary' and @type='button']")).click();
		
		

	}

}
