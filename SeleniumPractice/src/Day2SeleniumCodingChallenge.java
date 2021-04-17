import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day2SeleniumCodingChallenge {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.noon.com/uae-en/");
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//h3[text()='Recommended For You']")) );
		
		List<WebElement> data1 = driver.findElements(By.xpath("//h3[text()='Recommended For You']//parent::div//parent::div//following-sibling::div//div[@data-qa='product-name']"));
		
		WebElement Arrow = driver.findElement(By.xpath("//h3[text()='Recommended For You']//parent::div//parent::div//following-sibling::div//child::div[contains(@class,'swiper-button-next custom-navigation swiper-nav')]"));
//		while(Arrow.isDisplayed()) {
//
//			Arrow.click();
//			data1.addAll(driver.findElements(By.xpath("//h3[text()='Recommended For You']//parent::div//parent::div//following-sibling::div//div[@data-qa='product-name']")));
//			
//		}
		System.out.println(data1.size());

		for(int p=0;p<data1.size()/5;p++) {
			data1.addAll(driver.findElements(By.xpath("//h3[text()='Recommended For You']//parent::div//parent::div//following-sibling::div//div[@data-qa='product-name']")));
			if(!(Arrow.isDisplayed())) {
				break;
			}
			Arrow.click();
			
		}
		//data1.addAll(0,driver.findElements(By.xpath("//h3[text()='Recommended For You']//parent::div//parent::div//following-sibling::div//div[@data-qa='product-name']")));
		data1.removeAll(Arrays.asList("", null));
		System.out.println(data1.size());
		for(int k=0;k<data1.size();k++) {
			System.out.println(data1.get(k).getText());
		}
//		String strArry [] = new String[data1.size()];
//		for(int i=0;i < data1.size();i++)
//		{
//			strArry[i]=data1.get(i).getText();
//		}
//		Arrays.sort(strArry);
//		System.out.println(strArry.length);
//		for(int j=0;j<strArry.length;j++) {
//			System.out.println(strArry[j]);
//		}
		
	}

}
