package extentReports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestFactory {
	
	private static ExtentTestFactory testInstance;
	private ExtentTestFactory() {}
	
	public static ExtentTestFactory getTestInstance() {
		if(testInstance==null) {
			testInstance = new ExtentTestFactory();
		}
		return testInstance;
	}

	/*The Java ThreadLocal class enables you to create variables that can only be read and written by the same thread. 
	Thus, even if two threads are executing the same code, and the code has a reference to the same ThreadLocal variable, 
	the two threads cannot see each other's ThreadLocal variables.
*/	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	
	public ExtentTest getTest() {
		return extentTest.get();	
	}
	
	public void setExtent(ExtentTest extentTestObject) {
		extentTest.set(extentTestObject);
	}
	
	//removes the current thread's value for this thread-local variable.
	
	public void removeThreadLocalObject() {
		extentTest.remove();
	}
}