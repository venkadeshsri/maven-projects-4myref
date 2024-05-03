package examplecode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiselect_dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();
		
//Scrolling to the element & Clicking the ddl
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement multiselectlabel = driver.findElement(By.cssSelector("[id='selectMenuContainer'] div[class='row'] div[class=' css-1wa3eu0-placeholder']"));
		jse.executeScript("arguments[0].scrollIntoView();", multiselectlabel);
		multiselectlabel.click();
        jse.executeScript("arguments[0].style.display='block';",multiselectlabel);
        
		/*
		 * List<WebElement> ddl = driver.findElements(By.id("react-select-4-input"));
		 * for (WebElement list:ddl) { //System.out.println(list.getText());
		 * list.click(); } 
		 */
       // WebElement ddl = driver.findElement(By.id("react-select-4-input"));  
        
// searching the ddl by sendKeys        
		/*
		 * WebElement ddl =
		 * driver.findElement(By.xpath(".//input[@id='react-select-4-input'] "));
		 * System.out.println(ddl.isDisplayed()); ddl.sendKeys("yesgre");
		 * driver.findElement(By.xpath("(//div[@id='react-select-4-option-0'])[1]")).
		 * click();
		 */
        
        
       
	}

}
