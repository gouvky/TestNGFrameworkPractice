package utilityPackage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import basePackage.Constants;
import basePackage.ManageDriver;
import pageObjects.SwagLoginPage;

public class CommonFunctions {

	//Using Lazy initialization Singleton pattern
	private static CommonFunctions commonFninstance;
	private CommonFunctions() {}

	public static CommonFunctions getCommonInstance() {

		if(commonFninstance==null) {
			commonFninstance = new CommonFunctions();
		}
		return commonFninstance;
	}

	public static JavascriptExecutor js;
	SimpleDateFormat sdf;

	public void initPageWebElements() {
		PageFactory.initElements(ManageDriver.getDriverInstance().getDriver(), SwagLoginPage.getLoginInstance());
	}

	public void sendKeysAction(String data, WebElement element) {
		js = (JavascriptExecutor)ManageDriver.getDriverInstance().getDriver();
		js.executeScript("arguments[0].value='"+data+"'", element);
	}

	public void clickAction(WebElement element) {
		js=(JavascriptExecutor)ManageDriver.getDriverInstance().getDriver();
		js.executeScript("arguments[0].click", element);
	}
	
	public String generateDateTimeStamp(String pathFromConfig, String fileName, String fileType) {
		
		String userDirectory = System.getProperty("user.dir");
		String imageOrReportLocation = userDirectory + pathFromConfig;
		
		sdf = new SimpleDateFormat("dd-MM-YYYY-hh-mm-ss");
		String actualImgReportName = imageOrReportLocation+fileName+"_"+ sdf.format(new Date())+ fileType;
		
		return actualImgReportName;
	}

	public String captureScreenshot(String imageName) {

		if(imageName.equals("")) {
			imageName="screenshot";
		}
		String actualImageName = generateDateTimeStamp(Constants.ScreenshotPath, imageName, ".png");
		
		try {
			TakesScreenshot screenshot = (TakesScreenshot)ManageDriver.getDriverInstance().getDriver();
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			File dest = new File(actualImageName);
			FileUtils.copyFile(source, dest);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return actualImageName;
	}
}