package testing.demo;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import pages.Login;
import java.util.Properties;
import testing.demo.Keywords;
import testing.demo.ReadObject;
import testing.readexcel.ExcelFile;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ParallelTest {
	
WebDriver driver;
    
    public ParallelTest() {
    	
    	WebDriverManager.firefoxdriver().setup();
    	driver = new FirefoxDriver();
		driver.manage().window().maximize();

    }

	@Test (priority=1)
	@Description ("Run test cases using Excel file")
	@Feature ("Login page and home page")
	@Step ("Verify test cases in Excel file")
	@Severity (SeverityLevel.MINOR)
	public void testFirefox() throws Exception {
		
		// TODO Auto-generated method stub
       ExcelFile file = new ExcelFile();
       ReadObject object = new ReadObject();
       Properties allObjects =  object.getObjectRepository();
       Keywords operation = new Keywords(driver);
       
       Sheet sheet = file.readExcel("C:\\Users\\Usuario\\Desktop\\Website\\", "TestCases.xlsx" , "Hoja2");
       
       int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
       
       for (int i = 1; i < rowCount+1; i++) {
    	   
   		Row row = sheet.getRow(i);
  
    		try {
    			
				if(row.getCell(0).toString().length() == 0 || row.getCell(0).toString().equals("NULL")){
					
					System.out.println(row.getCell(1).getStringCellValue()+"----"+ row.getCell(2).getStringCellValue()+"----"+
							row.getCell(3).getStringCellValue()+"----"+ row.getCell(4).getStringCellValue());
					
					
					
					operation.perform(allObjects, row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue(),
							row.getCell(3).getStringCellValue(), row.getCell(4).getStringCellValue());
				}
				else{
						System.out.println("New Testcase->"+row.getCell(0).getStringCellValue() +" Started");
					}
				
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
			} catch (IllegalArgumentException ex) {
				
			}
    	}
	}
	
	@AfterTest
	public void end() {
		driver.quit();
	}
	
	

}
