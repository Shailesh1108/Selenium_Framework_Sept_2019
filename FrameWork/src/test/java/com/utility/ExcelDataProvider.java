package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider
{
	XSSFWorkbook wb;
	//Constructor will simply load excel
	public ExcelDataProvider()
	{
		try 
		{
			FileInputStream fis= new FileInputStream("./Test_Data/TestData.xlsx");
			wb=new XSSFWorkbook(fis);
			
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	//MethodOverloading
	public String getStringData(int sheetIndex,int row, int column)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();	
	}
	
	public String getStringData(String sheetName,int row, int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();	
	}
	
	public double  getNumericData(String sheetName,int row, int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();	
	}
	
	
	
	
	

}
