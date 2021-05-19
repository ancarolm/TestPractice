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
       
       XSSFSheet sheet = file.readExcel("TestCases.xlsx" , "Hoja1");
       
       int rowCount = sheet.getLastRowNum();
       
       for (int i = 1; i <= rowCount; i++) {
    	   
    		try {
    			
				if(sheet.getRow(i).getCell(0).toString().length() == 0){
					
					System.out.println(sheet.getRow(i).getCell(1).toString()+"----"+ sheet.getRow(i).getCell(2).toString()+"----"+
							sheet.getRow(i).getCell(3).toString()+"----"+ sheet.getRow(i).getCell(4).toString());
					operation.perform(allObjects, sheet.getRow(i).getCell(1).toString(), sheet.getRow(i).getCell(2).toString(),
							sheet.getRow(i).getCell(3).toString(), sheet.getRow(i).getCell(4).toString());
				}
				else{
						System.out.println("New Testcase->"+sheet.getRow(i).getCell(0).toString() +" Started");
					}
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
