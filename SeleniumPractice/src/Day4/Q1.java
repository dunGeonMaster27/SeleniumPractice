package Day4;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q1 {
	
	static WebDriver driver;
	
	public static void startBrowser(String URL, String Firefox) {
		
		System.setProperty("webdriver.chrome.driver", Firefox);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.get(URL);
	}

	public static void main(String[] args) throws Exception {
		
		//Q1Util util = new Q1Util();
		startBrowser(Q1Util.getURL(), Q1Util.getFirefoxLocation());		
//		driver.findElement(By.name("uid")).sendKeys(Q1Util.getUN());
//		driver.findElement(By.name("password")).sendKeys(Q1Util.getPW());
		FileInputStream IP = new FileInputStream(".\\Excel\\Q1 data2.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(IP);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			driver.get(Q1Util.getURL());
			driver.findElement(By.name("uid")).sendKeys(sheet.getRow(i).getCell(0).toString());
			driver.findElement(By.name("password")).sendKeys(sheet.getRow(i).getCell(1).toString());
			Thread.sleep(1000);
			driver.findElement(By.name("btnLogin")).click();
			Thread.sleep(1000);
			
			try {
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
				System.out.println("Login Failed");
				sheet.getRow(i).createCell(2).setCellValue("Login Failed");
			}
			catch(Exception E) {
			if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
				System.out.println("Login Successful");
				String pageText = driver.findElement(By.xpath("//td[contains(text(),'Manger Id')]")).getText();
				System.out.println(pageText);
				String[] parts = pageText.split(":");
				String dynamicText = parts[1];
				System.out.println(dynamicText);
				System.out.println(dynamicText.substring(1, 5));
				assertTrue(dynamicText.substring(1, 5).equals("mngr"));
				String remain = dynamicText.substring(dynamicText.length() - 6);
				System.out.println(remain);
				assertTrue(remain.matches("[0-9]+"));
				driver.findElement(By.linkText("Log out")).click();
				System.out.println(driver.switchTo().alert().getText());
				driver.switchTo().alert().accept();		
				sheet.getRow(i).createCell(2).setCellValue("Login Successful");
			}
							
			}
			wb.write(new FileOutputStream(".\\Excel\\Q1 Test.xlsx"));
		}
		Thread.sleep(2000);
		driver.close();
		wb.close();
	}

}
