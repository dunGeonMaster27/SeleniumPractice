package Day3;

public class ExcelFW_Execute {

	public static void main(String[] args) {
		
		ExcelFW ex = new ExcelFW(".\\Excel\\data.xlsx");
		System.out.println(ex.getRowNum("Sheet1"));
		System.out.println(ex.getData("Sheet1", 0, 0));
		ex.writeDate("Sheet1", "NAMO", 3, 0);
		ex.writeFile(".\\Excel\\data3.xlsx");
				
	}
}
