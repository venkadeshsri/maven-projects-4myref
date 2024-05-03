package examplecode;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Read {

	private static final String STRING = null;
	private static final String NUMERIC = null;
	private static final String BOOLEAN = null;

	public static void main(String[] args) throws IOException {
	
		String excelfilepath = "D:\\ECLIPSE - Automation\\Automation_Testing_Files\\Test login.xlsx";
		FileInputStream fileinput = new FileInputStream(excelfilepath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fileinput);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		//Using For Loop
		
		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(1).getLastCellNum();
		System.out.println(rows);
		
		for (int r=0;r<rows;r++)
		{
			XSSFRow row = sheet.getRow(r);
			
			for (int c=0; c<columns;c++)
			{
				XSSFCell cell = row.getCell(c);
				
			switch (cell.getCellType())	
			{
			case STRING: System.out.print(cell.getStringCellValue()); break;
			case NUMERIC:System.out.print(cell.getNumericCellValue()); break;
			case BOOLEAN:System.out.print(cell.getBooleanCellValue()); break; 
			
			}
			System.out.print(" | ");
			}
			System.out.println();
		}
		
		//Iterator
		
	/*	Iterator iterator = sheet.iterator();
		while(iterator.hasNext())
		{
			XSSFRow row = (XSSFRow) iterator.next();
			Iterator celliterator = row.cellIterator();
			
			while(celliterator.hasNext())
			{
				XSSFCell Cell = (XSSFCell) celliterator.next();
				switch (Cell.getCellType())
				{
				case STRING: System.out.print(Cell.getStringCellValue()); break;
				case NUMERIC:System.out.print(Cell.getNumericCellValue()); break;
				case BOOLEAN:System.out.print(Cell.getBooleanCellValue()); break; 
				}
			System.out.print(" | ");
			}
			System.out.println();
		} */
 
	}

}
