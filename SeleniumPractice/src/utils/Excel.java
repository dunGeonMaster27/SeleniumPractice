package utils;

import java.io.FileInputStream;

import java.io.FileOutputStream;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {

	
	Workbook wb;
	Sheet sheet;
	
	public Excel(String FileName)
	{
		
		try {
			FileInputStream IP = new  FileInputStream(FileName);
			if(FileName.endsWith(".xls"))
			{
				 wb= new HSSFWorkbook(IP);
			}
			else if(FileName.endsWith(".xlsx"))
			{
				wb= new XSSFWorkbook(IP);
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getData(String sheetName,int R,int C)
	{
		return wb.getSheet(sheetName).getRow(R).getCell(C).toString();
	}

	public int getRowNum(String sheetName)
	{
		return wb.getSheet(sheetName).getLastRowNum();
	}
	
	public void WriteData(String sheetName,int R,int C, String Data)
	{
		sheet = wb.getSheet(sheetName);
		try {
		sheet.getRow(R).getCell(C).setCellValue(Data);
		}
		catch(NullPointerException e) {
			try {
			sheet.getRow(R).createCell(C).setCellValue(Data);
		}
		catch(NullPointerException e1) {
			try {
			sheet.createRow(R).createCell(C).setCellValue(Data);
		}
			catch(NullPointerException e2) {
				System.out.println("Error with Data Writing " + e2.getMessage());
			}
		}
		
		}
			}
	
public void WriteFile(String newFile) {
	try {
		wb.write(new FileOutputStream(newFile));
	} catch (Exception e) {
		// TODO Auto-generated catch block
System.out.println("Error with File Writing " + e.getMessage());	
} 
	
}
	
	
	
	
	
	
}
