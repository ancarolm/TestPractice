package testing.demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class SelTesting /*extends App*/{
	
    WebDriver driver;
    
    public SelTesting() {
    	
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver();
    }

	@Test
	public void test() throws Exception {
		
		// TODO Auto-generated method stub
       ExcelFile file = new ExcelFile();
       ReadObject object = new ReadObject();
       Properties allObjects =  object.getObjectRepository();
       Keywords operation = new Keywords(driver);
       
       Sheet sheet = file.readExcel("../demo/src/main/resources/", "TestCases.xlsx" , "Hoja1");
       
       int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
       
       for (int i = 1; i < rowCount+1; i++) {
    	   
   		Row row = sheet.getRow(i);
  
    		try {
    			
				if(row.getCell(0).toString().length() == 0){
					
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
	
	@AfterMethod
	public void end() {
		driver.quit();
	}

}
