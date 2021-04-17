package Day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.magneticautomation.in/2019/01/alert-example.html");
		
		driver.findElement(By.xpath("//*[@id=\"post-body-5405753133268992336\"]/div/button[1]")).click();
		String msg = driver.switchTo().alert().getText();
		System.out.println("Date and Time is "+ msg);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//*[@id=\"post-body-5405753133268992336\"]/div/button[2]")).click();
		String confirm = driver.switchTo().alert().getText();
		System.out.println("Confirm "+ confirm);
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("demo")).getText());
		
		driver.findElement(By.cssSelector("button[onclick='myFunction2()']")).click();
		String decline = driver.switchTo().alert().getText();
		System.out.println("Decline "+ decline);
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.id("demo")).getText());
		
		driver.findElement(By.cssSelector("button[onclick='myFunction()']")).click();
		driver.switchTo().alert().dismiss();
		System.out.println(driver.findElement(By.id("demo2")).getText());
		
		driver.findElement(By.cssSelector("button[onclick='myFunction()']")).click();
		driver.switchTo().alert().sendKeys("Saket");
		driver.switchTo().alert().accept();
		System.out.println(driver.findElement(By.id("demo2")).getText());
		
		//Alert A = driver.switchTo().alert();
		
	}

}
