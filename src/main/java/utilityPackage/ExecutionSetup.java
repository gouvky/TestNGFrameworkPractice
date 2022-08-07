package utilityPackage;

import basePackage.ManageDriver;
import basePackage.PropertiesClass;

public class ExecutionSetup {

	private static ExecutionSetup execInstance;
	private ExecutionSetup() {}
	public static ExecutionSetup getexecInstance() {
		if(execInstance==null) {
			execInstance = new ExecutionSetup();
		}
		return execInstance;
	}

	public void initialExecutionSetup() {

		try {
			if(ManageDriver.getDriverInstance().getDriver()==null) {
				PropertiesClass.getPropInstance().initializeProperties();

				ManageDriver.getDriverInstance().initializeBrowser();	
			}
			CommonFunctions.getCommonInstance().initPageWebElements();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}