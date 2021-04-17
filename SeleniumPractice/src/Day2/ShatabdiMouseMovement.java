package Day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShatabdiMouseMovement {

	public static void main(String[] args) throws Exception {
	
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wt = new WebDriverWait(driver, 10);
		
		driver.get("https://indiarailinfo.com/");
		
		Actions A = new Actions(driver);
		WebElement trains = driver.findElement(By.linkText("Trains"));
		A.moveToElement(trains).perform();
		
		WebElement Shatabdi = driver.findElement(By.cssSelector("td[pref='/trains/shatabdi-express/shatabdi\']"));
		wt.until(ExpectedConditions.visibilityOf(Shatabdi));
		A.moveToElement(Shatabdi).click().perform();
		wt.until(ExpectedConditions.invisibilityOf(Shatabdi));
		
		WebElement Search = driver.findElement(By.name("q"));
		A.moveToElement(Search).keyDown(Search, Keys.SHIFT).sendKeys("lti").doubleClick().contextClick().perform();
		
		Thread.sleep(3000);
		driver.quit();
		
	
	}
	
}
