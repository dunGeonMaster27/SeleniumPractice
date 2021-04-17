package Day2;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class FrameExample {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://demoqa.com/frames");
		//WebElement webelement = driver.findElement(By.id("1"));
		driver.switchTo().frame("frame1");
		//driver.switchTo().frame(1);
		//driver.switchTo().frame(webelement);
		String f1text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(f1text);
		TakesScreenshot screen = (TakesScreenshot)driver;
		File FRAME1 = screen.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(FRAME1, new File(".\\Screenshots\\FrameExample\\frame1.png"));
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		String f2text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(f2text);
		
		File FRAME2 = screen.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(FRAME2, new File(".\\Screenshots\\FrameExample\\frame2.png"));
		
		driver.get("https://demoqa.com/nestedframes");
		Thread.sleep(2000);
		driver.switchTo().frame("frame1");
		String parenttext = driver.findElement(By.xpath("/html/body")).getText();
		System.out.println("Parent Text is " +parenttext);
		
		File PFRAME = screen.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(PFRAME, new File(".\\Screenshots\\FrameExample\\Parentframe.png"));
		
		
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe")));
		String childtext = driver.findElement(By.xpath("/html/body/p")).getText();
		System.out.println("Child text is " +childtext);
		
		File CFRAME = screen.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(CFRAME, new File(".\\Screenshots\\FrameExample\\Childframe.png"));
		
		
	}

}
