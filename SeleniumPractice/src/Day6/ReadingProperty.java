package Day6;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ReadingProperty {
	
	WebDriver driver;
	Properties prop;
	
  @Test
  public void f() {
	  
	  driver.get(prop.getProperty("url", "https://www.bing.com/"));
	  Assert.assertEquals("Google", driver.getTitle());
	  driver.findElement(By.name(prop.getProperty("searchField"))).sendKeys("R6");
  }
  @BeforeTest
  public void beforeTest() throws Exception{
	  prop = new Properties();
	  prop.load(new FileInputStream(".\\src\\Day6\\config.property"));
	  
	  if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		  driver = new ChromeDriver();
	  }
	  else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
		  System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		  driver = new FirefoxDriver();
	  }
  }

  @AfterTest
  public void afterTest() {
  }

}
