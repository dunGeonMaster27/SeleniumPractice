package Day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class BlazeDemoFlights {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://blazedemo.com/");
		
		Select FROM = new Select(driver.findElement(By.name("fromPort")));
		FROM.selectByIndex(1);
		
		Select TO = new Select(driver.findElement(By.name("toPort")));
		TO.selectByVisibleText("Cairo");
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		if(driver.getTitle().contentEquals("BlazeDemo - reserve")) {
			System.out.println("Page Title is correct and it is "+ driver.getTitle());
			List<WebElement> All = driver.findElements(By.cssSelector("input[value='Choose This Flight']"));
			System.out.println("Total buttons are "+ All.size());
			All.get(3).click();
			
			if(driver.getTitle().contentEquals("BlazeDemo Purchase")) {
				System.out.println("Page Title is correct and it is "+ driver.getTitle());
				driver.findElement(By.id("inputName")).sendKeys("Saket");
				driver.findElement(By.id("address")).sendKeys("123 Main St.");
				driver.findElement(By.id("city")).sendKeys("Anytown");
				driver.findElement(By.id("state")).sendKeys("AnyState");
				driver.findElement(By.id("zipCode")).sendKeys("12345");
				
				Select Card = new Select(driver.findElement(By.id("cardType")));
				Card.selectByValue("amex");
				
				driver.findElement(By.id("creditCardNumber")).sendKeys("123456789");

				driver.findElement(By.id("creditCardMonth")).clear();
				driver.findElement(By.id("creditCardMonth")).sendKeys("07");
				
				driver.findElement(By.id("creditCardYear")).clear();
				driver.findElement(By.id("creditCardYear")).sendKeys("2027");
				
				driver.findElement(By.id("nameOnCard")).sendKeys("Saket");
				
				WebElement rememberMe = driver.findElement(By.id("rememberMe"));
				rememberMe.click();
				boolean Displayed = rememberMe.isDisplayed();
				boolean Enabled = rememberMe.isEnabled();	
				boolean Selected = rememberMe.isSelected();
				String type = rememberMe.getAttribute("type");
				
				if(Displayed==true && Enabled==true && Selected==true && type.equals("checkbox")) {
					System.out.println("RememberMe Test Passed");					
				}
				else {
					System.out.println("RememberMe Test Failed");
				}
				
				driver.findElement(By.cssSelector("input[value='Purchase Flight']")).click();
				
				if(driver.getTitle().contentEquals("BlazeDemo Confirmation")) {
					System.out.println("Page Title is correct and it is "+ driver.getTitle());
					System.out.println("ID: " + driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[1]/td[2]")).getText());
					System.out.println("Tickets Confirmed");
					
				}
				else {
					System.out.println("Tickets not Confirmed");
					
				}
			}
			
			driver.quit();
			
			
		}

	}

}
