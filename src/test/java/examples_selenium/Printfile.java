package examples_selenium;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Printfile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		   FileOutputStream fout=new FileOutputStream("D:\\ECLIPSE - Automation\\Automation-Selenium\\mavenselenium\\src\\test\\resources\\Testfile.txt");  
		   PrintStream pout=new PrintStream(fout);  
		   pout.println(1900);  
		   pout.println("Hello Java");  
		   pout.println("Welcome to Java Selenium");  
		   pout.close();   
		   fout.close();  
	}

}
