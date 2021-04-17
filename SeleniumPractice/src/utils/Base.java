package utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
  public static WebDriver driver;
  public Properties prop;
  @BeforeTest(alwaysRun = true)
  public void beforeTest() throws Exception{
	  prop = new Properties();
	  prop.load(new FileInputStream(".\\Property\\config.property"));
	  
	  if(prop.getProperty("Browser").equalsIgnoreCase("firefox")) {
		  System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		  FirefoxOptions op= new FirefoxOptions();
		  op.addArguments("--headless");
		  driver = new FirefoxDriver();
	  }
	  
	  else if(prop.getProperty("Browser").equalsIgnoreCase("Chrome")) {
		  System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		  ChromeOptions op= new ChromeOptions();
		  op.addArguments("--headless");
		  driver = new ChromeDriver();
	  }
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
