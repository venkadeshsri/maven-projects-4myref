package examples_selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Spar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.sparinc.com/logins/");
		driver.manage().window().maximize();
		
		
		
		String originalWindow = driver.getWindowHandle();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.cssSelector(".button.ub-cn-set-cookie")).click(); //clicking Cookies Accept button
		driver.findElement(By.id("link-99-326")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 
		
		for (String windowHandle : driver.getWindowHandles()) 
		{
		    if(!originalWindow.contentEquals(windowHandle)) {
		        driver.switchTo().window(windowHandle);        //
		        break;
		    }
		}


		   WebElement usrname=driver.findElement(By.id("Input_Username"));
		   WebElement pwd=driver.findElement(By.id("Input_Password"));	
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   
		   WebElement loginbutton = driver.findElement(By.cssSelector("input[value=' Login ']"));
		   WebElement clearbutton = driver.findElement(By.cssSelector("input[value=' Clear ']"));	 
		 
		  
		   //Entering invalid user name and clicking login button
		   
		   usrname.sendKeys("Testing Selenium");
		   loginbutton.click();
		   
		   WebElement pwderrormsg = driver.findElement(By.id("Input_Password-error"));
		   Boolean pwderrormsgdisplay = driver.findElement(By.id("Input_Password-error")).isDisplayed();
		   System.out.println(pwderrormsgdisplay);
		   clearbutton.click();
		 
	//Entering numerical values into user name and clicking login button
		   
		   usrname.sendKeys("999999999995454847754555555545454");
		   loginbutton.click();
		   clearbutton.click();
		   
	//Entering Spl characters into user name and clicking login button
		   
		   usrname.sendKeys("`~!@#$%^&*()__+");
		 //  loginbutton.click();
		   loginbutton.submit();
		   Boolean pwderrormsgdisplay1 = driver.findElement(By.id("Input_Password-error")).isDisplayed();
		   System.out.println(pwderrormsgdisplay1);
		   clearbutton.click();
		   
		    //Entering space key into user name and clicking login button
			 
			  usrname.sendKeys("               "); 
			  loginbutton.click();
			  clearbutton.click();
			 
			 // Entering valid usrname & invalid pwd
			  
			usrname.sendKeys("venketeshs"); pwd.sendKeys("testing");

			loginbutton.submit();
			

			WebElement usrnamepwderror = driver.findElement(By.cssSelector(".text-danger.text-center"));
			 // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
			 String usrnamepwderrormsg = usrnamepwderror.getText();
			 System.out.println(usrnamepwderrormsg);
			 
			 driver.get(driver.getCurrentUrl());
			 
			   WebElement loginbutton1 = driver.findElement(By.cssSelector("input[value=' Login ']"));
			  
			   WebElement usrname1=driver.findElement(By.id("Input_Username"));
			   WebElement pwd1=driver.findElement(By.id("Input_Password"));	
			   		   	
				 usrname1.sendKeys("srinivasan"); pwd1.sendKeys("Spr$1983");
				 loginbutton1.click();
				 
				WebElement labelapp = driver.findElement(By.xpath("//h3[@class='card-header card-bg p-3']"));
			    System.out.println(labelapp.isDisplayed());
			    labelapp.getText();
				
			    String actuallink = driver.getCurrentUrl();
			 	//System.out.println(actuallink);
			 	Assert.assertEquals(actuallink, "https://app4.sparinc.com/spartoolsus/Menu");
			 	System.out.println(actuallink);
			 	
			 	WebElement forgetpwd = driver.findElement(By.xpath("//button[normalize-space()='Change Password']"));
			 	forgetpwd.click();
			 	
			 	WebElement changepwdsubmit = driver.findElement(By.id("btnsubmit"));
			 	Boolean status = changepwdsubmit.isEnabled();
			 	if (status)
			 	{
			 		changepwdsubmit.click();
			 		System.out.println("Button Enabled");
			 	}
			 	else
			 	{	System.out.println("Button Disabled");
			 	
			 	}
			 	
			 	WebElement menulink = driver.findElement(By.linkText("Menu Page"));
			 	menulink.click();
			 	driver.close();

						
	}

	}


