import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

public class Test {

	public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.rediff.com/");
		driver.findElement(By.linkText("NEWS")).click();
		FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(".\\Screenshots\\Test.png"));
		
		List<WebElement> all = driver.findElements(By.xpath("//div[@class='subnavbar news']//a"));
		for(WebElement a:all) {
			System.out.println(a.getAttribute("href"));
		}
		
		Assert.assertEquals(driver.findElement(By.linkText("BUSINESS")).getAttribute("title"), "Business headlines");
		
		Actions A = new Actions(driver);
		
		A.moveToElement(driver.findElement(By.linkText("BUSINESS"))).perform();
		Thread.sleep(3000);
		FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE), new File(".\\Screenshots\\Test1.png"));

		WebElement E = driver.findElement(By.xpath("//body/div[5]/div[2]"));
		String bg = E.getCssValue("background-color");
		System.out.println(bg);
		String col = Color.fromString(bg).asRgb();
		System.out.println(col);
		Assert.assertEquals(col, "rgb(188, 62, 49)");
		
		driver.get("https://www.color-blindness.com/color-name-hue/");
		driver.switchTo().frame(driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='maincontentcontainer']/div[@id='primary']/div[1]/article[1]/div[1]/p[2]/iframe[1]")));

		driver.findElement(By.xpath("//input[@id='cp1_Red']")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		driver.findElement(By.id("cp1_Red")).sendKeys(col.substring(4, 7));
		
		driver.findElement(By.id("cp1_Green")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		driver.findElement(By.id("cp1_Green")).sendKeys(col.substring(9,11));
		
		driver.findElement(By.id("cp1_Blue")).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		driver.findElement(By.id("cp1_Blue")).sendKeys(col.substring(13, 15));
		
		System.out.println(driver.findElement(By.id("cp1_ColorNameText")).getText());
		Assert.assertEquals(driver.findElement(By.id("cp1_ColorNameText")).getText(), "Grenadier");
	}
	
}