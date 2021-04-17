package Day3;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class dragNdrop {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://jqueryui.com/droppable/");
		
		TakesScreenshot screen = (TakesScreenshot)driver;
		Actions A = new Actions(driver);
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		WebElement src = driver.findElement(By.id("draggable"));
		System.out.println(driver.findElement(By.id("draggable")).getText());
		WebElement dest = driver.findElement(By.id("droppable"));
		System.out.println(driver.findElement(By.id("droppable")).getText());

		A.dragAndDrop(src, dest).perform();
		
		File SRC = screen.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(SRC, new File(".\\Screenshots\\dragNdrop\\dragNdrop.png"));
		
		
		
	}

}
