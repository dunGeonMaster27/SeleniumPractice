package Day4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGNewTest {
	WebDriver driver;
  @Test
  public void GoogleTest() {
	  driver.get("https://www.google.com/");
	  Assert.assertEquals(driver.getTitle(), "Google");
  }  
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
	  driver = new FirefoxDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
