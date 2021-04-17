package Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import utils.Base;

public class Scrolling extends Base{
  @Test
  public void f() throws Exception{
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  driver.get("https://www.nseindia.com/");
	  Thread.sleep(3000);
	  executor.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.linkText("Circulars")) );
	  Thread.sleep(2000);
	  executor.executeScript("window.scrollBy(0,-150)");
	  Thread.sleep(2000);
	  executor.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	  Thread.sleep(2000);
	  executor.executeScript("window.scrollBy(document.body.scrollWidth,0)");
	  Thread.sleep(2000);
	  executor.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.linkText("Circulars")) );
	  executor.executeScript("arguments[0].click();", driver.findElement(By.linkText("Press Releases")) );
	  Thread.sleep(2000);
  }
}
