package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class KeyWords {
WebDriver driver;


	public KeyWords(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openUrl(String url) {
		driver.get(url);
	}
	
	public void captureScreen(String FileName) {
	Date d = new Date();
	String newDate = d.toString().replaceAll(" ", "_").replaceAll(":", "-");
	TakesScreenshot screen = (TakesScreenshot)driver;
	File SRC = screen.getScreenshotAs(OutputType.FILE);
	
	try {
		FileHandler.copy(SRC, new File(".\\Screenshots\\"+FileName +" "+newDate+".png"));
	}
	catch(IOException e) {
		System.out.println("Error while taking Screenshot");
	}
	}
	
	public void click(String Locator)
	{
		String LocatorType = Locator.split(":=")[0];
		String LocatorValue = Locator.split(":=")[1];
	
		switch(LocatorType)
		{
		case "id" :
		driver.findElement(By.id(LocatorValue)).click();
		break;
	case "name" :
		driver.findElement(By.name(LocatorValue)).click();
		break;
	case "xpath" :
		driver.findElement(By.xpath(LocatorValue)).click();
		break;
	case "linkText":
		driver.findElement(By.linkText(LocatorValue)).click();
		}
	
	}
	public void type(String Locator, String data)
	{
		
		String LocatorType = Locator.split(":=")[0];
		String LocatorValue = Locator.split(":=")[1];
	
		switch(LocatorType)
		{
		case "id" :
		driver.findElement(By.id(LocatorValue)).sendKeys(data);
		break;
		case "name" :
		driver.findElement(By.name(LocatorValue)).sendKeys(data);
		break;
		case "xpath" :
		driver.findElement(By.xpath(LocatorValue)).sendKeys(data);
		break;
		case "linkText":
		driver.findElement(By.linkText(LocatorValue)).sendKeys(data);
		}
	
	}
	
	
	
	
}
