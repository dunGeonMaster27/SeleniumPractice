package Day4;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Q2 {

	public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wt = new WebDriverWait(driver, 5);
		TakesScreenshot screen = (TakesScreenshot)driver;
		
		driver.get("https://www.marketwatch.com/");
		driver.findElement(By.xpath("//header/button[1]")).click();
		driver.findElement(By.xpath("//body/div[20]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("Reliance Industries");
		WebElement Reliance = driver.findElement(By.xpath("//span[contains(text(),'IN:500325')]"));
		wt.until(ExpectedConditions.visibilityOf(Reliance));
		Reliance.click();
		File Rel = screen.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(Rel, new File(".\\Screenshots\\Day4-Q2\\Reliance.png"));
	
		System.out.println("Face Value is " + driver.findElement(By.xpath("//body/div[4]/div[2]/div[3]/div[1]/div[2]/h3[1]")).getText());
		System.out.println("Intraday High Low is " + driver.findElement(By.xpath("//body/div[4]/div[5]/div[1]/div[1]/div[1]/ul[1]/li[2]")).getText());
		System.out.println("52 Week High Low is " + driver.findElement(By.xpath("//body/div[4]/div[5]/div[1]/div[1]/div[1]/ul[1]/li[3]")).getText());
		
	}

}
