package Day6;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.Base;

public class AllLinks extends Base{
  @Test
  public void f() {
	  driver.get("http://demo.guru99.com/test/newtours/");
	  List<WebElement> all = driver.findElements(By.tagName("a"));
	  for(int i=0; i<all.size(); i++) {
		  System.out.println(all.get(i).getText());
		  //all.get(i).click();
		  //driver.navigate().back();
		  all = driver.findElements(By.tagName("a"));
	  }
	  
	  
	  
  }
  
}
