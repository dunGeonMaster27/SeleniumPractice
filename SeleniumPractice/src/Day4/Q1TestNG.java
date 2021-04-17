package Day4;


import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Q1TestNG{
	WebDriver driver;
	
@DataProvider(name="GuruTest")
public Object[][] testData(){
	Object[][] data = new Object[4][2];
	
	data[0][0] = Q1Util.getUN();
	data[0][1] = Q1Util.getPW();
	
	data[1][0] = Q1Util.getUN();
	data[1][1] = "dd";
	
	data[2][0] = "dd";
	data[2][1] = Q1Util.getPW();
	
	data[3][0] = "dd";
	data[3][1] = "dd";
	
	return data;
	
}
	
 @BeforeTest
  public void startBrowser() {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.get(URL);
	}
	
  @Test(dataProvider = "GuruTest")
  public void f(String Username, String Password) throws Exception{
	  		
//		driver.findElement(By.name("uid")).sendKeys(Q1Util.getUN());
//		driver.findElement(By.name("password")).sendKeys(Q1Util.getPW());
		
		
			driver.get(Q1Util.getURL());
			driver.findElement(By.name("uid")).sendKeys(Username);
			driver.findElement(By.name("password")).sendKeys(Password);
			driver.findElement(By.name("btnLogin")).click();
			
			try {
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
				System.out.println("Login Failed");
			}
			catch(Exception E) {
			if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
				System.out.println("Login Successful");
				String pageText = driver.findElement(By.xpath("//td[contains(text(),'Manger Id')]")).getText();
				
				String[] parts = pageText.split(":");
				String dynamicText = parts[1];
				
				assertTrue(dynamicText.substring(1, 5).equals("mngr"));
				String remain = dynamicText.substring(dynamicText.length() - 4);
				assertTrue(remain.matches("[0-9]+"));
			}
							
			}
		}
		
	
	  
  @AfterTest
	public void tearDown(){
		driver.quit();
	}
  
 

 

}
