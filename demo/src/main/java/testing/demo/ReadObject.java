package testing.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import testing.readexcel.ExcelFile;

public class ReadObject {
	
	Properties p = new Properties();
	 
	public Properties getObjectRepository() throws IOException{


		//InputStream stream = new FileInputStream("../demo/src/main/java/config/config.properties");
		
		InputStream stream = new FileInputStream("../demo/src/main/java/config/config.properties");
		
		
		p.load(stream);
		
		return p;
	}

}
