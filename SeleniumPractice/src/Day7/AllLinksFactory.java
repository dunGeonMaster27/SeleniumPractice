package Day7;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllLinksFactory {
	WebDriver driver;
	
	public AllLinksFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
		driver = this.driver;
	}
	
@FindBy(tagName = "a")
	List<WebElement> allLinks;
	
public void clickLinks() {
	for(int i=0; i<=allLinks.size();i++) {
		allLinks.get(i).click();
		driver.navigate().back();
	}
}

}
