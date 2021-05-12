package testing.demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.Login;

public class SelTesting extends App{
	
	public Login login;
	
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
		
	}
	
	@AfterMethod
	public void end() {
		driver.quit();
	}

}
