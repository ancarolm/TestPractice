package testing.demo;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Keywords {
	
	WebDriver driver;
	
	public Keywords(WebDriver driver){
		this.driver = driver;
	}
	
	public void perform(Properties p, String action, String objectType, String objectName, String value) throws Exception{
		
		System.out.println("");
		try {
			switch (action.toUpperCase()) {
			case "GOTO":	
				driver.get(p.getProperty(value));
				break;	
			case "SETTEXT":
				driver.findElement(this.getObject(p, objectType , objectName)).sendKeys(value);
				break;	
			case "CLICK":
				driver.findElement(this.getObject(p , objectType, objectName)).click();
				break;
			default:
				break;
			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Find element BY using object type and value
	 * @param p
	 * @param objectName
	 * @param objectType
	 * @return
	 * @throws Exception
	 */
	private By getObject(Properties p, String objectType, String objectName) throws Exception{
		
		if(objectType.equals("xpath")){
			
			return By.xpath(p.getProperty(objectName));
			
		}else {
			throw new Exception("No object type");
		}
	}

}
