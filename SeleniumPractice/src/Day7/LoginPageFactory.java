package Day7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	WebDriver driver;
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	WebElement E_UN;
	
	@FindBy(name="password")
	WebElement E_PW;
	
	@FindBy(name="btnLogin")
	WebElement E_Login;
	
	@FindBy(linkText = "New Customer")
	WebElement E_NewCust;
	
	public void LoginProcess(String username, String password) {
		E_UN.sendKeys(username);
		E_PW.sendKeys(password);
		Actions A = new Actions(driver);
		A.moveToElement(E_Login).click().perform();
		//E_Login.click();
	}
	
	public void NewCust() {
		E_NewCust.click();
	}
	
}
