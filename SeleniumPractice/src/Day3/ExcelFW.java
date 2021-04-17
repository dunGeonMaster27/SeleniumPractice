package Day3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFW {

		Workbook wb;
		ExcelFW(String FileName){
			try {
				FileInputStream IP = new FileInputStream(FileName);
				if(FileName.endsWith("xls")) {
					wb = new HSSFWorkbook(IP);					
				}
				else if(FileName.endsWith("xlsx")) {
					wb = new XSSFWorkbook(IP);
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		

		public String getData(String sheetName, int R, int C) {
			return wb.getSheet(sheetName).getRow(R).getCell(C).toString();
		}

		public int getRowNum(String sheetName) {
			return wb.getSheet(sheetName).getLastRowNum();
		}

		public void setData(String username, String password) {
			Sheet sheet = wb.getSheet("Sheet1");
			sheet.createRow(3).createCell(0).setCellValue(username);
			sheet.getRow(3).createCell(1).setCellValue(password);
			
			try {
				wb.write(new FileOutputStream(".\\Excel\\dataFW.xlsx"));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		public void writeDate(String sheetName, String Data, int R, int C) {
			wb.getSheet(sheetName).createRow(R).createCell(C).setCellValue(Data);
			//wb.getSheet(sheetName).getRow(R).getCell(C).setCellValue(Data);
		}
		
		public void writeFile(String FileLocation) {
			try {
				wb.write(new FileOutputStream(FileLocation));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}



		
}


