import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		
		
//		FOR Printing the value on console for 20 sec
		
//		driver.get("https://www.worldometers.info/world-population/");
//		
//		WebElement CWP = driver.findElement(By.xpath("//span[@class='rts-counter' and @rel='current_population']"));
//		WebElement BT = driver.findElement(By.xpath("//span[@class='rts-counter' and @rel='births_today']"));
//		WebElement DT = driver.findElement(By.xpath("//span[@class='rts-counter' and @rel='dth1s_today']"));
//		WebElement PGT = driver.findElement(By.xpath("//span[@class='rts-counter' and @rel='absolute_growth']"));
//		WebElement BTY = driver.findElement(By.xpath("//span[@class='rts-counter' and @rel='births_this_year']"));
//		WebElement DTY = driver.findElement(By.xpath("//span[@class='rts-counter' and @rel='dth1s_this_year']"));
//		WebElement PGTY = driver.findElement(By.xpath("//span[@class='rts-counter' and @rel='absolute_growth_year']"));
//		
//		long t= System.currentTimeMillis();
//		long end = t+20000;		
//		while(System.currentTimeMillis()<end) {
//			
//			System.out.println("-----------------------------------------------------------------------------");
//		    System.out.printf("%45s",  "Current World Population" );
//		    System.out.println();
//		    System.out.println("-----------------------------------------------------------------------------");
//	        System.out.format("%37s",CWP.getText() );
//		    System.out.println();
//			System.out.println("-----------------------------------------------------------------------------");
//
//		    System.out.printf("%17s %47s",  "Births today", "Births this year" );
//		    System.out.println();
//		    System.out.println("-----------------------------------------------------------------------------");
//	        System.out.format("%14s %46s",BT.getText(),BTY.getText());
//		    System.out.println();
//			System.out.println("-----------------------------------------------------------------------------");
//
//		    System.out.printf("%17s %47s",  "Deaths today", "Deaths this year" );
//		    System.out.println();
//		    System.out.println("-----------------------------------------------------------------------------");
//	        System.out.format("%14s %46s",DT.getText(),DTY.getText());
//		    System.out.println();
//			System.out.println("-----------------------------------------------------------------------------");
//
//			System.out.printf("%17s %47s",  "Population Growth today", "Population Growth this year" );
//			System.out.println();
//			System.out.println("-----------------------------------------------------------------------------");
//			System.out.format("%14s %46s",PGT.getText(),PGTY.getText());
//			System.out.println();
//			System.out.println("-----------------------------------------------------------------------------");
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		}
		
//		FOR selecting value from dropdown when you dont know complete value
//		
//		driver.get("https://blazedemo.com/");//		
//		Select FROM = new Select(driver.findElement(By.name("fromPort")));
//		List<WebElement> all = FROM.getOptions();
//		System.out.println(all.size());
//		System.out.println(all.get(0).getText());
//	`	Iterator<WebElement> it = all.iterator();
//		while(it.hasNext()) {
//			String ID = it.next().getText();
//			if(ID.contains("Bos")) {
//			FROM.selectByVisibleText(ID);
//			}		
//		}
// --------------------------------------------------------------------------------------------------------------		
		
//		FOR getting all the checkbox in the page
//		
//		driver.get("https://www.ironspider.ca/forms/checkradio.htm");
//		List<WebElement> all = driver.findElements(By.xpath("//input[@type='checkbox']"));
//		System.out.println(all.size());
//		all.get(0).click();
		
// --------------------------------------------------------------------------------------------------------------		
		
//		FOR getting all the links in the page
//
//		driver.get("https://www.guru99.com/xpath-selenium.html");
//		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
//		System.out.println("There are "+allLinks.size()+" links in the page");
//		Iterator<WebElement> i = allLinks.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next().getText());
//		}
		
// --------------------------------------------------------------------------------------------------------------		
		
		
		
}
}
