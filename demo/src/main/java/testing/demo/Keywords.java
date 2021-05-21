package testing.demo;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class Keywords {
	
	WebDriver driver;
	
	public Keywords(WebDriver driver){
		this.driver = driver;
	}
	
	@Step ("define keywords and their path")
	public void perform(Properties p, String action, String objectType, String objectName, String value) throws Exception{
		
		System.out.println("");
		try {
			switch (action.toUpperCase()) {
			case "GOTO":	
				//driver.get(p.getProperty(value));
				driver.get("https://opensource-demo.orangehrmlive.com");
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
	
	@Step ("define type of object")
	private By getObject(Properties p, String objectType, String objectName) throws Exception{
		
		if(objectType.equalsIgnoreCase("XPATH")){
			
			return By.xpath(p.getProperty(objectName));
		}
		//find by class

		else if(objectType.equalsIgnoreCase("ID")){
			
			return By.id(p.getProperty(objectName));
			
		}
		//find by name
		else if(objectType.equalsIgnoreCase("NAME")){
			
			return By.name(p.getProperty(objectName));
			
		}
		//Find by css
		else if(objectType.equalsIgnoreCase("CSS")){
			
			return By.cssSelector(p.getProperty(objectName));
			
		}
		//find by link
		else if(objectType.equalsIgnoreCase("LINK")){
			
			return By.linkText(p.getProperty(objectName));
			
		}
		//find by partial link
		else if(objectType.equalsIgnoreCase("PARTIALLINK")){
			
			return By.partialLinkText(p.getProperty(objectName));
			
		}else {
			throw new Exception("No object type");
		}
	}

}
