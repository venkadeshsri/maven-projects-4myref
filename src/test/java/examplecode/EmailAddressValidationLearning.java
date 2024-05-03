package learnselenium.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmailAddressValidationLearning {
	
	public static void main(String[] args) {
		
  WebDriverManager.edgedriver().setup();
  EdgeDriver driver= new EdgeDriver();

  driver.manage().window().maximize();
  
  driver.get("https://app4.sparinc.com/spartoolsus?_ga=2.158329274.1040077832.1655564889-117463900.1645817069");
  
  WebElement forgotuserElement = driver.findElement(By.xpath("//a[@class='btn text-blue small']"));
  forgotuserElement.click();
  
  String ExpectedLink=driver.getCurrentUrl();
  String ActualLink="https://app4.sparinc.com/spartoolsus/Fgu";
  
  if (ExpectedLink.equals(ActualLink)) {
	  
	  System.out.println("True");
	
} else {
	
	System.out.println("False");

}
	  
  WebElement emailaddressElement = driver.findElement(By.id("Input_UserEMailAddress"));
  
  String [] multiemailAddress = {
		  
		  "ma@noj@muthu.com",
		  "manoj@gmail",  
		  "manoj#gmail.com",
		  "mnoj@gamil-com",
		  "manojgmail.com",
		  "manoj@gmmail.com"
 };
  
  for (String emailAddress : multiemailAddress) {
	  	  
	  emailaddressElement.clear(); // Clear any existing text in the input field
	  emailaddressElement.sendKeys(emailAddress,Keys.ENTER);
	
}

		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";  

  		Pattern pattern = Pattern.compile(regex);  
  		
  		
		for(String email : multiemailAddress)

		{  	
		    Matcher matcher = pattern.matcher(email);  
		    
		    System.out.println(email +" : "+ matcher.matches()+"\n");  
		}  
	
		 driver.close();
		
		 
	}

}
