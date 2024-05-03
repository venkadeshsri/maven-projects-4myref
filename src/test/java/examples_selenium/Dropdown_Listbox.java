package examples_selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown_Listbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://192.168.55.181:4300/form");
		driver.manage().window().maximize();
		
		List <WebElement> ddl = driver.findElements(By.xpath("//div[5]//div[1]"));
		for (WebElement ddlboxlist : ddl) {
			System.out.println("Dropdown list are" + ddlboxlist.getText()); 
					} 	
		WebElement ddlelement = driver.findElement(By.xpath("//select[@id='applied_for']"));
		Select ddlistbox = new Select(ddlelement);
		ddlistbox.selectByVisibleText("Testing");
		
	
	}

}
