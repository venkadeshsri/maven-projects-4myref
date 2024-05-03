package examplecode;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testformsel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		  driver.get("http://192.168.55.181:4300/form");
		  driver.manage().window().maximize();
		  
		  WebElement formheader = driver.findElement(By.cssSelector(".p-2"));
		  
		  System.out.println("Title Displayed: " + formheader.isDisplayed());
		  
		  WebElement formtitletext = driver.findElement(By.cssSelector(".mb-0"));
		  System.out.println("Form Title Displayed: " + formtitletext.isDisplayed());
		  System.out.println("Validation passed for title text displaying");
		  //Assert.assertTrue(formtitletext.isDisplayed());
		  //Assert.assertFalse(formtitletext.isDisplayed());
		   
		    Assert.assertEquals(formtitletext.getText(),"Employee Form");
		    System.out.println("Title Compared - Validation passed");
		    Assert.assertNotEquals(formtitletext.getText(),"Employee Forms"); 
		    System.out.println("Text Not Matched - Valdiation pass");
		   
		    WebElement fnametbox=driver.findElement(By.id("f_name"));
		    fnametbox.sendKeys("Testing first name");
		    fnametbox.sendKeys(Keys.TAB);
		  //driver.close(); 
		    String firstnamelength = fnametbox.getAttribute("value");
		  
		  int size = firstnamelength.length();
		  if (size<=50) {
			  System.out.println("Length Verification - Tested =  " + size);
		  } else
		  {System.out.println("Length verification failed");
		  }
		  
		  WebElement lastnametbox = driver.findElement(By.id("l_name"));
		  lastnametbox.sendKeys("Testing Last name");
		  lastnametbox.sendKeys(Keys.TAB);
		  
		  WebElement datec = driver.findElement(By.id("dob"));
		  datec.click();
		 //datec.sendKeys("02-10-2023");
		  
		  
			/*
			 * DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("mm/dd/yyyy");
			 * dtformat.localizedBy(null); DateTime datec1 =
			 * dtformat.parseDateTime((10/10/1980));
			 */


		 String[] dates = {"02/28/2023","09/10/2024","test","09/10/2023","00-01-9999","OCT/09/2023"};
		 
		 for (String date1:dates)
		 {
			 
			 datec.sendKeys(date1);
			 datec.clear();
			 
		 }
		 
		 //String regex =  "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
		 
		 String regex = "^(?=\\d{2}([-.,\\/])\\d{2}\\1\\d{4}$)(?:0[1-9]|1\\d|[2][0-8]|29(?!.02.(?!(?!(?:[02468][1-35-79]|[13579][0-13-57-9])00)\\d{2}(?:[02468][048]|[13579][26])))|30(?!.02)|31(?=.(?:0[13578]|10|12))).(?:0[1-9]|1[012]).\\d{4}$";

		//String regex = "(^(?:(?:(?:31(?:(?:([-.\\/])(?:0?[13578]|1[02])\\1)|(?:([-.\\/ ])(?:Jan|JAN|Mar|MAR|May|MAY|Jul|JUL|Aug|AUG|Oct|OCT|Dec|DEC)\\2)))|(?:(?:29|30)(?:(?:([-.\\/])(?:0?[13-9]|1[0-2])\\3)|(?:([-.\\/ ])(?:Jan|JAN|Mar|MAR|Apr|APR|May|MAY|Jun|JUN|Jul|JUL|Aug|AUG|Sep|SEP|Oct|OCT|Nov|NOV|Dec|DEC)\\4))))(?:(?:1[6-9]|[2-9]\\d)?\\d{2}))$|^(?:29(?:(?:([-.\\/])(?:0?2)\\5)|(?:([-.\\/ ])(?:Feb|FEB)\\6))(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))$|^(?:(?:0?[1-9]|1\\d|2[0-8])(?:(?:([-.\\/])(?:(?:0?[1-9]|(?:1[0-2])))\\7)|(?:([-.\\/ ])(?:Jan|JAN|Feb|FEB|Mar|MAR|May|MAY|Jul|JUL|Aug|AUG|Oct|OCT|Dec|DEC)\\8))(?:(?:1[6-9]|[2-9]\\d)?\\d{2}))$)";
			
		 Pattern pattern = Pattern.compile(regex);
			
			for (String dateValidation : dates) 
				
				{
				
				Matcher matcher = pattern.matcher(dateValidation);
				System.out.println(dateValidation +" : "+ matcher.matches());
				  
				if (matcher.matches())
				{
					System.out.println("Entered date" + dates + "is Valid");
				}
				else {
					
					
					System.out.println("Entered date" + dates +  "is invalid");
				     }

			    }
			 datec.sendKeys(dates[3]);
			 datec.sendKeys(Keys.TAB);
			 
			 WebElement genlabel = driver.findElement(By.cssSelector("label[for='gender']"));
			 System.out.println(genlabel.getText());
			Assert.assertEquals(genlabel.getText(),"Gender");
			
			/*
			 * WebElement genMale = driver.findElement(By.cssSelector("label[for='male']"));
			 * 
			 * boolean selectstatus = genMale.isSelected(); 
			 * if (selectstatus == false) {
			 * genMale.click(); } else {
			 *  WebElement genFemale = driver.findElement(By.cssSelector("#female")); genFemale.click(); }
			 * 
			 * System.out.println("Selected option is" + genMale.getAttribute("checked")+
			 * "True");
			 */
			/*
			 * WebElement selectradio = driver.findElement(By.name("flexRadioDefault"));
			 * System.out.println(selectradio); Select select = new Select(selectradio);
			 * List<WebElement> optionList = select.getOptions(); select.selectByIndex(1);
			 * System.out.println(optionList);
			 */
			 //List<WebElement> selectedOptionList = select.getAllSelectedOptions();
			
			List<WebElement> radobutton = driver.findElements(By.cssSelector("body > app-root:nth-child(1) > app-form:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(3) > div:nth-child(2)"));
			for (WebElement a:radobutton )
			{
				System.out.println("Gender list" + a.getText());
				
			}
			
			WebElement genMale = driver.findElement(By.cssSelector("label[for='male']"));
			genMale.isDisplayed();
			genMale.isEnabled();
			System.out.println("Is Male Selected : " + genMale.isSelected());
			
			
			WebElement genFemale = driver.findElement(By.cssSelector("#female"));
			genFemale.isDisplayed();
			genFemale.isEnabled();
			System.out.println("Is Female Selected : " + genFemale.isSelected());
			
			genMale.click();
			
			WebElement emailid = driver.findElement(By.id("email"));
			emailid.sendKeys("testing@muthutech.com");
			String eg = emailid.getAttribute("value");
			//System.out.println("Entered Email :" + " " +  eg);
			
			//System.out.println(emailid.getAttribute("value"));
			/*
			 * String[] emailaddr = {"testing@muthutech.com"};
			 * //0,1,2 --> 0 - testing, 1
			 * 
			 * for (int i=0;i>=emailaddr.length;i++) { String stemail = emailaddr[i];
			 * System.out.println(emailid..()); }
			 */
			
			
			  String regex1 = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
			  Pattern pattern1 = Pattern.compile(regex1); 
			 // String email1 = new String  (emailid.getText()); 
			  
			 // System.out.println(email1); // 
			  //String email= new  String("test@muthutech.com"); 
			  
			  Matcher matcher = pattern1.matcher(eg);
			  System.out.println("Entered Email :"+ eg +" : "+ matcher.matches());
			  
			  emailid.sendKeys(Keys.TAB);
			  
			  WebElement phoneno = driver.findElement(By.id("phno"));
			 // phoneno.sendKeys("9999999999999999999999999999");
			  String inpdata = ("9999999999999999999999999999");
			  phoneno.sendKeys(inpdata);
			  int lengthphone = phoneno.getAttribute("value").length();
			  System.out.println("Phone no length: " + lengthphone);
			  
			  
				/*
				 * System.out.println(phoneno.getAttribute("value")); String max_length_phno =
				 * phoneno.getAttribute("maxLength"); System.out.println("Phone no length: " +
				 * max_length_phno); // phoneno.click();
				 */	  
			  
			  
			 
				/*
				 * for(String email= new String("test@muthutech.com") { Matcher matcher =
				 * pattern.matcher(email); //System.out.println(email +" : "+
				 * matcher.matches()); }
				 */
			 
			}
			}

