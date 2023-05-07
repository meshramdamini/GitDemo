package com.newFramwork.utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RaedExcelFile 
{
	public static FileInputStream inputStream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet excelSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String getCellValue(String filename, String sheetName,int rowNo,int cellNo)
	{
		try 
		{
			inputStream= new FileInputStream(filename);
			workbook = new XSSFWorkbook(inputStream);
			excelSheet= workbook.getSheet(sheetName);
			cell=workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
			
			workbook.close();
			return cell.getStringCellValue();
			
		 }
		catch (Exception e) 
		{
			return "";
		}
			
	}
	
	public  static int getRowCount (String filename, String SheetName)
	{
		try 
		{
			inputStream= new FileInputStream(filename);
			workbook= new XSSFWorkbook(inputStream);
			excelSheet = workbook.getSheet(SheetName);
			
			
			int ttlRows= excelSheet.getLastRowNum()+1;
			workbook.close();
			return ttlRows;
		}
			
		
		catch (Exception e) 
		{
			return 0;
		}
		
		
	}
	
	public  static int getColunmCount (String filename, String SheetName)
	{
		try 
		{
			inputStream= new FileInputStream(filename);
			workbook = new XSSFWorkbook(inputStream);
			excelSheet = workbook.getSheet(SheetName);
			
			int ttlCells= excelSheet.getRow(0).getLastCellNum();
			workbook.close();
			return ttlCells ;
		}
			
		
		catch (Exception e) 
		{
			return 0;
		}
		
		
	}


}
