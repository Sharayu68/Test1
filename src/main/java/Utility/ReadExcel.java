package Utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	
	public static String readExcelFile(int row, int col) throws Exception
	{
		FileInputStream file = new FileInputStream("C:\\Users\\asus\\eclipse-workspace\\FrameWork\\TestData\\Book 36.xlsx");
        Sheet excelSheet = WorkbookFactory.create(file).getSheet("Sheet1");
        String value = excelSheet.getRow(row).getCell(col).getStringCellValue();
        return value;
	}

}
