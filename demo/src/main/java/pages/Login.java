package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testing.demo.App;

public class Login extends App {
	
	@FindBy(xpath = "//*[@id=\"divUsername\"]/span")
	private WebElement username;
	
	@FindBy(xpath = "//*[@id=\"txtPassword\"]")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"btnLogin\"]")
	private WebElement submit;
	
	public Login() {
		PageFactory.initElements(driver, this);
	}
	
	public static WebElement user() {
		return user();
	}
	
	public static WebElement pass() {
		return pass();
	}
	
	public static WebElement button() {
		return button();
	}

}
