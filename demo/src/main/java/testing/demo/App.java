package testing.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static Properties prop;
    public static WebDriver driver;
    
    public App() {
    	prop = new Properties();
    	
    	try {
    		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") +
    		"/demo/src/main/java/config/config.properties");
    		prop.load(ip);
    		}catch (FileNotFoundException e) {
    			
    		}catch (IOException e) {
    			
    		}
    	
    }
    
    public static void init (String url) {
    	if (prop.get("browser").equals("chrome")) {
    		
    		
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();
    		driver.get(url);
    		driver.manage().window().maximize();
    		
    	}
    }
}
