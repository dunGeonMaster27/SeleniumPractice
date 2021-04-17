package Day2;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class NewWindowExample {

	public static void main(String[] args) throws Exception {
			
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("disable-popup-blocking");
		WebDriver driver = new ChromeDriver();
				
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/browser-windows");
		//driver.navigate().to("https://demoqa.com/frames");

		String PID = driver.getWindowHandle();
		//driver.findElement(By.id("tabButton")).click();
		
		driver.findElement(By.id("windowButton")).click();
		
		Set<String> CID = driver.getWindowHandles();
		Iterator<String> it = CID.iterator();
		while(it.hasNext()) {
			String ID = it.next();
			if(!(ID.equals(PID))) {
				driver.switchTo().window(ID);
				System.out.println("You are in " + driver.getTitle()+ " page");
				String text = driver.findElement(By.xpath("//*[@id=\"sampleHeading\"]")).getText();
				System.out.println("Window Text is '" + text + "'");
				
				TakesScreenshot screen = (TakesScreenshot)driver;
				File SRC = screen.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(SRC, new File(".\\Screenshots\\NewWindowExample\\ChildWindow.png"));
				
				driver.close();
			}
		}
		
		
	}

}
