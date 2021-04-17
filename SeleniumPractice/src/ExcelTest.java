import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {

	public static void main(String[] args) throws Exception{
		
		FileInputStream IP = new FileInputStream("./src/2.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(IP);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		
		System.out.println(sheet.getLastRowNum());
		
		System.out.println(sheet.getRow(0).getCell(0).toString());
		System.out.println(sheet.getRow(0).getCell(1).toString());
		System.out.println(sheet.getRow(0).getCell(2).toString());
		System.out.println(sheet.getRow(1).getCell(0).toString());

		
		sheet.createRow(1).createCell(0).setCellValue("data4");
		wb.write(new FileOutputStream("./src/2.xlsx"));	
		wb.close();
	}

}
