package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import basePackage.Constants;
import utilityPackage.CommonFunctions;

public class ExtentManager {

	public static final ExtentReports extentReports = new ExtentReports();
	static String reportPath = System.getProperty("user.dir") + Constants.ExtentReportPath;

	public static ExtentReports createExtentReports() {

		String reportPath = CommonFunctions.getCommonInstance().generateDateTimeStamp
				(Constants.ExtentReportPath, "ExtentReport", ".html");
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		
		reporter.config().setReportName("TestNG Framework Practice Extent Report");
		reporter.config().setDocumentTitle("Extent Report");
		reporter.config().setTheme(Theme.DARK);
		
		extentReports.attachReporter(reporter);
		
		extentReports.setSystemInfo("Author", "Vignesh");
		extentReports.setSystemInfo("Browser", Constants.Browser);
		
		return extentReports;
	}
}