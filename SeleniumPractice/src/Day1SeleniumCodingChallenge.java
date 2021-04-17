import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1SeleniumCodingChallenge {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.worldometers.info/world-population/");

		WebElement CWP = driver.findElement(By.xpath("//span[@class='rts-counter' and @rel='current_population']"));
		WebElement BT = driver.findElement(By.xpath("//span[@class='rts-counter' and @rel='births_today']"));
		WebElement DT = driver.findElement(By.xpath("//span[@class='rts-counter' and @rel='dth1s_today']"));
		WebElement PGT = driver.findElement(By.xpath("//span[@class='rts-counter' and @rel='absolute_growth']"));
		WebElement BTY = driver.findElement(By.xpath("//span[@class='rts-counter' and @rel='births_this_year']"));
		WebElement DTY = driver.findElement(By.xpath("//span[@class='rts-counter' and @rel='dth1s_this_year']"));
		WebElement PGTY = driver.findElement(By.xpath("//span[@class='rts-counter' and @rel='absolute_growth_year']"));

		long t= System.currentTimeMillis();
		long end = t+20000;		
		while(System.currentTimeMillis()<end) {

			System.out.println("-----------------------------------------------------------------------------");
			System.out.printf("%45s",  "Current World Population" );
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------");
			System.out.format("%37s",CWP.getText() );
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------");

			System.out.printf("%17s %47s",  "Births today", "Births this year" );
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------");
			System.out.format("%14s %46s",BT.getText(),BTY.getText());
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------");

			System.out.printf("%17s %47s",  "Deaths today", "Deaths this year" );
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------");
			System.out.format("%14s %46s",DT.getText(),DTY.getText());
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------");

			System.out.printf("%17s %47s",  "Population Growth today", "Population Growth this year" );
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------");
			System.out.format("%14s %46s",PGT.getText(),PGTY.getText());
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------");
	
		}

	}

}
