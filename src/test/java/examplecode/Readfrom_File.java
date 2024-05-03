package examplecode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Readfrom_File {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Read only one line from the text file
	/*	FileReader fr = new FileReader("D:\\ECLIPSE - Automation\\Test file.txt");
		BufferedReader br = new BufferedReader(fr);
		String text = br.readLine();
		while (text != null)
		{
		System.out.println(text);
		break;
	    } */
		
		File file = new File("D:\\\\ECLIPSE - Automation\\\\Test file.txt");
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine())
		{
		System.out.println(sc.nextLine());
		}
		
	}

}
