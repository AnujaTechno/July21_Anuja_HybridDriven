package excelFileReading;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelOperation {
	
	@Test
	public static Object[][] readExcelFile()  {
		File file=new File("./excelFiles/testing.xlsx");//given file path
		FileInputStream input;
		Workbook workbook=null;
		try {
			input = new FileInputStream(file);//throws FilenotFoundException if file was unable to locate at the above path
			 workbook=new XSSFWorkbook(input);//throws IOException if ref of InputStream is unable to load to m/m
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Sheet sheet=workbook.getSheet("Sheet1");
		int lastRow=sheet.getLastRowNum()+1;
		int lastCell=sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[lastRow][lastCell];
		
		System.out.println("Total rows :"+lastRow);
		System.out.println("Total columns :"+lastCell);
		
		for(int row=0;row<lastRow;row++) {
			for(int column=0;column<lastCell;column++) {//save date with adding space before and then make general format
				//System.out.print(sheet.getRow(row).getCell(column).getStringCellValue()+ "\t");
				Cell cell = sheet.getRow(row).getCell(column);
				if (cell.getCellType() == CellType.NUMERIC) {
					data[row][column] = String.valueOf(cell.getNumericCellValue());
				} else if (cell.getCellType() == CellType.STRING) {
					data[row][column] = String.valueOf(cell.getStringCellValue());
				} else if (cell.getCellType() == CellType.BOOLEAN) {
					data[row][column] = String.valueOf(cell.getBooleanCellValue());
				}
				
			}
			System.out.println();
		}
		return data;
	}
}
