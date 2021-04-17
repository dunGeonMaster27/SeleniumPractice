package Day7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
WebDriver driver;
	public HomePageFactory(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Log out")
	WebElement E_Logout;
	
	public void Logout() {
		E_Logout.click();
		driver.switchTo().alert().accept();
	}
}
