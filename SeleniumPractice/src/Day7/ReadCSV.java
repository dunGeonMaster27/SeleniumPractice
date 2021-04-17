package Day7;

import java.io.FileReader;
import java.util.List;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;
import utils.Base;

public class ReadCSV extends Base{
  @Test
  public void f() throws Exception{
	  CSVReader CS  = new CSVReader(new FileReader(".\\src\\Day7\\data.csv"));
	  List<String[]> data = CS.readAll();
	  for(String[] dataArr:data) {
		  for(String A:dataArr) {
			  System.out.println(A);
		  }
		  driver.get("http://www.demo.guru99.com/V4/");
		  LoginPageFactory LPF = new LoginPageFactory(driver);
		  HomePageFactory HPF = new HomePageFactory(driver);
		  
		  LPF.LoginProcess(dataArr[0], dataArr[1]);
		  try {
				Alert alert = driver.switchTo().alert();
				System.out.println(alert.getText());
				alert.accept();
			}
			catch(Exception E) {
			if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
				HPF.Logout();
				  System.out.println(driver.switchTo().alert().getText());
				  driver.switchTo().alert().accept();
			}		  
	  }
	  CS.close();	  
  }
}
}
