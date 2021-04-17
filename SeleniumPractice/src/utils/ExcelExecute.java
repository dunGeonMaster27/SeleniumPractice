package utils;

public class ExcelExecute {

	public static void main(String[] args) {
	Excel ex = new Excel(".\\src\\Day5\\data.xlsx");
	System.out.println(ex.getData("Sheet1", 0, 0));
	
    ex.WriteData("Sheet1", 9, 3, "huehuehuehue");
   
    ex.WriteFile(".\\src\\Day5\\data1.xls");
}
	
}
