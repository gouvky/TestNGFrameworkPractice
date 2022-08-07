package basePackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ManageDriver extends BaseClass{
	
	private static ManageDriver driverInstance;
	private ManageDriver() {}
	public static ManageDriver getDriverInstance() {
		if(driverInstance==null) {
			driverInstance = new ManageDriver();
		}
		return driverInstance;
	}
	
	private static WebDriver driver=null;

	@Override
	public void initializeBrowser() {

		switch ((Constants.Browser).toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			break;

		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			break;
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}