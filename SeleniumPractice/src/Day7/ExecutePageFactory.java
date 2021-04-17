package Day7;

import org.testng.annotations.Test;

import utils.Base;

public class ExecutePageFactory extends Base{
  @Test(enabled=true)
  public void f() {
	  driver.get("http://www.demo.guru99.com/V4/");
	  LoginPageFactory LPF = new LoginPageFactory(driver);
	  HomePageFactory HPF = new HomePageFactory(driver);
	  
	  LPF.LoginProcess("mngr312595", "UpaduqU");
	  LPF.NewCust();
	  HPF.Logout();
	  //driver.switchTo().alert().accept();
  }
  
  @Test(enabled =false)
  public void AllLinks() {
	  driver.get("http://demo.guru99.com/test/newtours/");
	  AllLinksFactory ALF = new AllLinksFactory(driver);
	  ALF.clickLinks();
  }
}
