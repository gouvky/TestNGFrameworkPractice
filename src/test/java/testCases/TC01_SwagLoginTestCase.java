package testCases;

import org.testng.annotations.*;

import basePackage.Constants;
import basePackage.ManageDriver;
import pageObjects.SwagLoginPage;
import utilityPackage.ExecutionSetup;

public class TC01_SwagLoginTestCase {
	
	@BeforeSuite
	public void startExecution() {
		
		ExecutionSetup.getexecInstance().initialExecutionSetup();
	}
	@Test
	public void validateUserLoginUsingValidCredentials() {
		
		ManageDriver.getDriverInstance().getDriver().get(Constants.AppURL);
		SwagLoginPage.getLoginInstance().enterUserID(Constants.UserName);
		SwagLoginPage.getLoginInstance().enterPwd(Constants.Password);
		SwagLoginPage.getLoginInstance().clickLoginbtn();
	}
}