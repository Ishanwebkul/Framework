package com.learn.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider()
	{
		File src = new File("./TestData/Data.xlsx");
		try 
		{
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to Read Excel File" +e.getMessage());
		}
	}
	
	public String getString(String sheetname, int row, int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumeric(String sheetname, int row, int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}
}
