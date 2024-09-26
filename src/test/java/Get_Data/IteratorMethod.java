package Get_Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IteratorMethod {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		File file = new File(".\\DataFiles\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);
	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    //XSSFSheet sheet = wb.getSheet("sheet1");
	    XSSFSheet sheet = wb.getSheetAt(0);
	    
	    Iterator iterator = sheet.iterator();
	    while (iterator.hasNext()) {
	    	
		XSSFRow	row=(XSSFRow) iterator.next();
		Iterator cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			
			XSSFCell cell = (XSSFCell) cellIterator.next();
			switch(cell.getCellType())
    		{
    		case STRING: System.out.print(cell.getStringCellValue()); break;
    		case NUMERIC: System.out.print(cell.getNumericCellValue()); break;
    		case BOOLEAN: System.out.print(cell.getBooleanCellValue()); break;
    		}
			
			System.out.print("|");
    	}
    	 System.out.println();		
		}

	}

}
