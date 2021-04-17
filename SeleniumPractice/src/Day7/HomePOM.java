package Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePOM {

	WebDriver driver;
	
	public HomePOM(WebDriver driver) {
		this.driver = driver;
	}
	
	By E_Logout = By.linkText("Log out");
	
	public void Logout() {
		driver.findElement(E_Logout).click();
		driver.switchTo().alert().accept();
	}
	
}
