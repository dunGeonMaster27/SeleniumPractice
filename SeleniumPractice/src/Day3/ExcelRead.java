package Day3;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ExcelRead {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		FileInputStream IP = new FileInputStream(".\\Excel\\data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(IP);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		System.out.println(sheet.getLastRowNum());
		
		for(int i=0; i<=sheet.getLastRowNum(); i++) {
			driver.get("http://the-internet.herokuapp.com/login");
			
			String username = sheet.getRow(i).getCell(0).toString();
			String password = sheet.getRow(i).getCell(1).toString();
			
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			
			driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
			if(driver.findElement(By.xpath("//div[@id='flash']")).getText().contains("You logged into a secure area!")) {
				driver.findElement(By.xpath("//*[contains(text(),'Logout')]")).click();
				System.out.println("Login Successful");
				sheet.getRow(i).createCell(2).setCellValue("Login Successful");
			}
			else {			
				System.out.println("Login Failed");
				sheet.getRow(i).createCell(2).setCellValue("Login Failed");
			}						
		}
		wb.write(new FileOutputStream(".\\Excel\\data2.xlsx"));

			
	wb.close();	
	}

}
