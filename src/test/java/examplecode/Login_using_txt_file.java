package examplecode;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_using_txt_file {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		

		
		FileInputStream file = new FileInputStream("D:\\ECLIPSE - Automation\\Automation_Testing_Files\\Test login.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rows = sheet.getLastRowNum(); 
		int columns = sheet.getRow(0).getLastCellNum();
				
		System.out.println(rows);
		System.out.println(columns);
		
		for (int r=1;r<=rows;r++)
		{ 
			XSSFRow rows1 = sheet.getRow(r);
			
		    
		    String usrname_excel = rows1.getCell(0).getStringCellValue();
			String pwd_excel = rows1.getCell(1).getStringCellValue(); 
			
/*		    for (int c=0;c<columns;c++) {
			XSSFCell colmns = rows1.getCell(c);
			System.out.println(colmns);
			String usrname_excel = rows1.getCell(0).getStringCellValue();
			String pwd_excel = rows1.getCell(1).getStringCellValue(); 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));*/ 

			WebElement usrname = driver.findElement(By.xpath("//input[@id='user-name']"));
			WebElement pwd = driver.findElement(By.xpath("//input[@id='password']"));
			WebElement login = driver.findElement(By.xpath("//input[@id='login-button']"));
			
			usrname.sendKeys(usrname_excel);
			pwd.sendKeys(pwd_excel);
			login.click();
			driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
			
			System.out.println("Tested login: " + usrname_excel);
			driver.getCurrentUrl();
		    }
		}

               /* public static void main(String[] args) throws IOException, InterruptedException {
				
				WebDriverManager.chromedriver().setup();
				WebDriver driver= new ChromeDriver();
				driver.get("https://www.saucedemo.com/");
				driver.manage().window().maximize();
				
				WebElement search =driver.findElement(By.xpath("//input[@id='user-name']"));
				search.sendKeys("Orangehrm");
				search.sendKeys(Keys.ENTER);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0,100)");
				Thread.sleep(1000);
				js.executeScript("window.scrollBy(0,120)");
				
				
				File file = new File("/home/akileshv/eclipse-workspace/SampleTesting/My_File_Properties/Test_Textfile.properties");
				FileInputStream fins=new FileInputStream(file);
				Properties prop = new Properties();
				prop.load(fins);
				Thread.sleep(5000);
				for(int i=1;i<=5;i++)
				{
					
					driver.get(prop.getProperty("url").indent(i));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20000));
					WebElement username = driver.findElement(By.xpath(".//input[@name='username']"));
					username.sendKeys(prop.getProperty("username"));
					WebElement Password = driver.findElement(By.xpath(".//input[@name='password']"));
					Password.sendKeys(prop.getProperty("password"));
					WebElement login = driver.findElement(By.xpath(".//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']"));
					login.submit();
					WebElement tab=driver.findElement(By.xpath(".//span[@class='oxd-userdropdown-tab']"));
					tab.click();
					Thread.sleep(5000);
					WebElement logout=driver.findElement(By.xpath("(.//a[@class='oxd-userdropdown-link'])[4]"));
					logout.click();
					//i++;
				}
				
				
			}

		}

	} */

}