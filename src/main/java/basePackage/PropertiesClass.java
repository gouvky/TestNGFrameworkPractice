package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass {

	private static PropertiesClass propInstance;
	private PropertiesClass() {}
	public static PropertiesClass getPropInstance() {
		if(propInstance == null) {
			propInstance = new PropertiesClass();
		}
		return propInstance;
	}

	public Properties prop;
	public FileInputStream fis;
	String filePath = "./src/test/resources/Properties/Config.properties";

	public void initializeProperties() {
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);

		} catch (FileNotFoundException e) {
			System.out.println("File is not available in the following " + filePath);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Constants.Browser = prop.getProperty("browser");
		Constants.AppURL = prop.getProperty("appurl");
		Constants.UserName = prop.getProperty("username");
		Constants.Password = prop.getProperty("password");
		Constants.ScreenshotPath = prop.getProperty("screenshotLocation");
		Constants.ExtentReportPath = prop.getProperty("reportLocation");
	}
}