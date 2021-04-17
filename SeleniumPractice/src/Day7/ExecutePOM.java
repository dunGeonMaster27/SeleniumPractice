package Day7;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Base;

public class ExecutePOM extends Base{
  @Test
  public void f() {
	  driver.get("http://www.demo.guru99.com/V4/");
	  
	  LoginPOM LP = new LoginPOM(driver);
	  HomePOM HP = new HomePOM(driver);
	  
	  LP.LoginProcess("mngr312595", "UpaduqU");
	  LP.NewCustomer();
	  
	  Set<Cookie> Ck = driver.manage().getCookies();
	  for(Cookie C:Ck) {
		  System.out.println("Name of Cookie is " + C.getName());
		  System.out.println("Domain of Cookie is " + C.getDomain());
		  System.out.println("Path of Cookie is " + C.getPath());
		  System.out.println("Value of Cookie is " + C.getValue());
		  System.out.println("Class of Cookie is " + C.getClass());
		  System.out.println("Expiry of Cookie is " + C.getExpiry());		  
	  }
	  
	  driver.manage().deleteAllCookies();
	  driver.navigate().refresh();
	  Assert.assertEquals(driver.getTitle(), "Guru99 Bank New Customer Entry Page");
	  HP.Logout();
  }
}
