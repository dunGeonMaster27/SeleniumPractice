package Day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class TestNGNewTest2{
	WebDriver driver;
	
  @Test(priority=1)
  public void TitleTest() {
	  	  driver.get("https://www.istqb.org/");
	  	  Assert.assertEquals(driver.getTitle(), "Certifying Software Testers Worldwide - ISTQB® International Software Testing Qualifications Board");
  }
  
  @Test(priority=2,dependsOnMethods= {"TitleTest"})
  public void ReferencesTest() throws Exception {
	  	  WebElement E = driver.findElement(By.linkText("References"));
	  	  Assert.assertEquals(E.isDisplayed(), true);
	  	  Assert.assertEquals(E.isEnabled(), true);
	  	  Assert.assertEquals(E.getAttribute("href"), "https://www.istqb.org/references.html", "URL - Mismatch");
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
