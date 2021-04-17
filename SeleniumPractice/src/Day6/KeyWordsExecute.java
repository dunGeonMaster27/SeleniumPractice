package Day6;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.Base;
import utils.Excel;
import utils.KeyWords;

public class KeyWordsExecute extends Base {
  @Test(dataProvider = "dp")
  public void f(String ExcelKey, String Locator, String data) {
	  
	  KeyWords KEY = new KeyWords(driver);
	  switch(ExcelKey){
	  case "openUrl":
		  KEY.openUrl(data);
		  break;
	  case "type":
		  KEY.type(Locator, data);
		  break;
	  case "click":
		  KEY.captureScreen(data);
		  break;
	  default:
		  System.out.println("Invalid Key");
	  }
	  
  }

  @DataProvider
  public Object[][] dp() {
	  Excel ex = new Excel(".\\src\\Day6\\Book1.xlsx");
	  System.out.println(ex.getRowNum("Sheet1"));
	  Object data[][] = new Object[ex.getRowNum("Sheet1")+1][3];
     for(int i=0;i<=ex.getRowNum("Sheet1");i++){
    	 data[i][0] = ex.getData("Sheet1", i, 0);
    	 data[i][1] = ex.getData("Sheet1", i, 1);
    	 data[i][2] = ex.getData("Sheet1", i, 2);
    }
     return data;
  }
}
