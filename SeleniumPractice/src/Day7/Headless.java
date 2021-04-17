package Day7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Headless {
  @Test
  public void f() {
	  //WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);	
	  
	  System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--headless");
	  
	  WebDriver driver = new ChromeDriver(options);
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("http://demo.guru99.com/test/newtours/");
	  System.out.println(driver.findElement(By.name("submit")).isDisplayed());  
  }
}
