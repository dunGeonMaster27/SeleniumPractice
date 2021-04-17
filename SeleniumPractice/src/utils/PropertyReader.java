package utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class PropertyReader {

	Properties prop = null;
	public PropertyReader(String path) {
		prop = new Properties();
		
		try {
			prop.load(new FileInputStream(path));
		}
		catch(Exception E) {
			System.out.println("Error while reading Properties " + E.getMessage());
		}
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}
	
	public By getElementProperty(String key) 
	{
		String Locator=prop.getProperty(key);
		String LocatorType = Locator.split(":=")[0];
		String LocatorValue = Locator.split(":=")[1];
		System.out.println(LocatorValue);
		By element=null;
		switch (LocatorType) {
		case "id":
			element= By.id(LocatorValue);
			break;
		case "name":
			element= By.name(LocatorValue);
			break;
		case "xpath":
			element= By.xpath(LocatorValue);
			break;
		case "linktext":
			element= By.linkText(LocatorValue);
			break;
		default:
			System.out.println("Invalid Locators");
		}
		
	return element;
		
	}
	
}
