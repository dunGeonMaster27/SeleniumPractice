package Day1;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoLogin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter username");
		String username = sc.nextLine();
		System.out.println("Please enter password");
		String password = sc.nextLine();
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://mdcomputers.in/login");
		System.out.println("You are on " + driver.getTitle() +" page");
		
		driver.findElement(By.id("input-email")).sendKeys(username);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		if(driver.getTitle().equals("My Account")) {
			if(driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div[1]/a/img")).getAttribute("src").equals("https://mdcomputers.in/image/catalog/logo.png")) {
				System.out.println("Image is correct");
			}
				driver.findElement(By.linkText("Logout")).click();
				System.out.println("Login was Successful");	
		}
		else {
			System.out.println("Login was not successful");
		}
		driver.quit();
		sc.close();
	}

}
