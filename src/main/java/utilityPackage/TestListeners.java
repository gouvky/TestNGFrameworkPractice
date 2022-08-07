package utilityPackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import extentReports.ExtentManager;
import extentReports.ExtentTestFactory;

public class TestListeners implements ITestListener{

	ExtentReports report;

	private static String getTestMethodName(ITestResult result) {
		return result.getMethod().getConstructorOrMethod().getName();
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		ExtentTestFactory.getTestInstance().getTest().log(Status.SKIP, "Test Case " + 
				getTestMethodName(result) + " is Skipped");
		ExtentTestFactory.getTestInstance().removeThreadLocalObject();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println(getTestMethodName(result) + " test is starting");
		ExtentTestFactory.getTestInstance().setExtent(report.createTest(getTestMethodName(result)));
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		ExtentTestFactory.getTestInstance().getTest().log(Status.PASS, "Test Case " + 
				getTestMethodName(result) + " is Passed");
		ExtentTestFactory.getTestInstance().removeThreadLocalObject();
	}

	@Override
	public void onTestFailure(ITestResult result) {

		ExtentTestFactory.getTestInstance().getTest().log(Status.FAIL, "Test Case " + 
				getTestMethodName(result) + " is Failed");

		String attachImg = CommonFunctions.getCommonInstance().captureScreenshot(getTestMethodName(result));
		ExtentTestFactory.getTestInstance().getTest().addScreenCaptureFromPath(attachImg);

		ExtentTestFactory.getTestInstance().removeThreadLocalObject();
	}

	@Override
	public void onStart(ITestContext context) {

		report = ExtentManager.createExtentReports();
		System.out.println("I am in onStart method " + context.getName());

	}

	@Override
	public void onFinish(ITestContext context) {

		report.flush();
		System.out.println("I am in onFinish method " + context.getName());
	}
}