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
import org.openqa.selenium.chrome.ChromeDriver;

@Listeners({AllureListener.class})
public class SelTesting /*extends App*/{
	
    WebDriver driver;
    
    public SelTesting() {
    	
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
		driver.manage().window().maximize();

    }

	@Test (priority=0, groups = { "firstgroup" })
	@Description ("Run test cases using Excel file")
	@Feature ("Login page and home page")
	@Step ("Verify test cases in Excel file")
	@Severity (SeverityLevel.MINOR)
	public void test() throws Exception {
		
		// TODO Auto-generated method stub
       ExcelFile file = new ExcelFile();
       ReadObject object = new ReadObject();
       Properties allObjects =  object.getObjectRepository();
       Keywords operation = new Keywords(driver);
       
       Sheet sheet = file.readExcel("C:\\Users\\Usuario\\Desktop\\Website\\", "TestCases.xlsx" , "Hoja1");
       
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
	
	@Test (priority=1, groups = { "firstgroup", "secondgroup" })
	@Description ("Run test cases using Excel file")
	@Feature ("Login page and home page")
	@Step ("Verify test cases in Excel file")
	@Severity (SeverityLevel.MINOR)
	public void testGroupOne() throws Exception {
		
		// TODO Auto-generated method stub
       ExcelFile file = new ExcelFile();
       ReadObject object = new ReadObject();
       Properties allObjects =  object.getObjectRepository();
       Keywords operation = new Keywords(driver);
       
       Sheet sheet = file.readExcel("../demo/src/main/resources/", "TestCases.xlsx" , "Hoja1");
       
       int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
       
       for (int i = 6; i <= rowCount+1; i++) {
    	   
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
	
	@Test (priority=2, groups = { "secondgroup" })
	@Description ("Run test cases using Excel file")
	@Feature ("Login page and home page")
	@Step ("Verify test cases in Excel file")
	@Severity (SeverityLevel.MINOR)
	public void testGroupTwo() throws Exception {
		
		// TODO Auto-generated method stub
       ExcelFile file = new ExcelFile();
       ReadObject object = new ReadObject();
       Properties allObjects =  object.getObjectRepository();
       Keywords operation = new Keywords(driver);
       
       Sheet sheet = file.readExcel("C:\\Users\\Usuario\\Desktop\\Website\\", "TestCases.xlsx" , "Hoja1");
       
       int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
       
       for (int i = 11; i < rowCount+1; i++) {
    	   
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
	
	/*@Test (priority=1)
	public void skip() {
		
		throw new SkipException("Test skipped");
	}*/
	
	
	/*public Login login;
	
	public SelTesting() {
		super();
	}
	
	@BeforeMethod
	public void setUrl() {
		String url = "https://opensource-demo.orangehrmlive.com/";
		init(url);
	}
	
	@Test
	public void test() {
		
		login.user().sendKeys("Admin");
		login.pass().sendKeys("admin123");
		login.button().click();
		
	}*/
	
	@AfterTest
	public void end() {
		driver.quit();
	}

}
