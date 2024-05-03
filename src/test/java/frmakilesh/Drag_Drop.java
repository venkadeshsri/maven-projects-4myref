
package sampleTesting;

//import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag_Drop {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[@class='demo-frame']")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		WebElement drag = driver.findElement(By.xpath(".//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath(".//div[@id='droppable']"));
		Actions drag_drop = new Actions(driver);
		drag_drop.clickAndHold(drag).moveToElement(drop).release(drop).build().perform();

		
	}

}
