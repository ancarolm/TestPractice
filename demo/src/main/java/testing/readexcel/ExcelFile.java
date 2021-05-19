package testing.readexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {
	
	public XSSFSheet readExcel(String fileName , String sheetName) throws IOException{
		
		File file =	new File("../demo/src/main/resources/"+fileName);
		
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		
		if(fileExtensionName.equals(".xlsx")){
			
			workbook = new XSSFWorkbook(inputStream);
		}


		XSSFSheet sheet = (XSSFSheet) workbook.getSheet(sheetName);
		
		
			return sheet;	
			
		}

}
