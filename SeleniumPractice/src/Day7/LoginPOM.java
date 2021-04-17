package Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPOM {
	WebDriver driver;
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver;
	}
	
	By E_UN = By.name("uid");
	By E_PW = By.name("password");
	By E_Login = By.name("btnLogin");
	By E_NewCust = By.linkText("New Customer");
	
	public void LoginProcess(String username, String password) {
		driver.findElement(E_UN).sendKeys(username);
		driver.findElement(E_PW).sendKeys(password);
		driver.findElement(E_Login).click();
	}
		
	public void NewCustomer() {
		driver.findElement(E_NewCust).click();
	}
}
