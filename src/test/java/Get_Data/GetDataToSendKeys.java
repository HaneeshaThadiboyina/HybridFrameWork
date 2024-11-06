package Get_Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataToSendKeys {

	public Object[] controllerdatabaseRead_LKA(int RecordRow,String SheetName) throws Exception{
		
		File file = new File(".\\DataFiles\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);		
		XSSFSheet sheet =workbook.getSheet("sheet1");
		int numRows = RecordRow;
	    int numCols = sheet.getRow(0).getLastCellNum();
	    //numCols = numCols-1;
	    ArrayList<Object> result = new ArrayList<Object>();
	    for(int i=1;i==numRows;i++)
	    {
	    	XSSFRow row = sheet.getRow(i);
	   	for (int j=0;j<numCols;j++)
	   	{
	   		XSSFCell cell = row.getCell(j);
	   		
	   		switch( cell.getCellType())
    		{
    		case STRING:result.add(cell.getStringCellValue()); break;
    		case NUMERIC:result.add(cell.getNumericCellValue()); break;
    		case BOOLEAN:result.add(cell.getNumericCellValue()); break;
    		}
			   	}  
	    }
	    Object[] arr = new Object[result.size()]; 
	    arr = result.toArray(arr); 
		return arr;
	}
}
