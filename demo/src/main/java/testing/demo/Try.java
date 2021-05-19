package testing.demo;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import testing.readexcel.ExcelFile;

public class Try {
		
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		ExcelFile file = new ExcelFile();

		XSSFSheet sheet = file.readExcel("TestCases.xlsx" , "Hoja1");
		
		int count = sheet.getLastRowNum();
		
		for (int i = 0; i <= count; i++) {
			
			String data = sheet.getRow(i).getCell(1).toString();
			
			System.out.println(data);
		}
		
		/*String info = sheet.getRow(0).getCell(0).toString();
		
		System.out.println(info);*/



	}


}
