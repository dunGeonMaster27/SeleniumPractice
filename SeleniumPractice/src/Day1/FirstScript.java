package Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/watch?v=EV16iQ9r16o&list=PL2ZAv6qJdzJSbC76odCFwvZwuNaaJKmGK&index=8&ab_channel=MagneticAutomationandLearning");
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.quit();
	}

}
