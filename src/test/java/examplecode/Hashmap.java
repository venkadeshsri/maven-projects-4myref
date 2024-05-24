package examplecode;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hashmap {

		static HashMap<String, String> logindata()
		{
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("x", "standard_user,secret_sauce");
			hm.put("y", "visual_user,secret_sauce");
			hm.put("z", "problem_user,secret_sauce");
			return hm;
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		//Login as x
		
		String crenditials = logindata().get("y");
		String arr[] = crenditials.split(",");
		
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(arr[0]);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(arr[1]);
		driver.findElement(By.xpath("//input[@id='login-button']")).submit();
		
		

	}

}
