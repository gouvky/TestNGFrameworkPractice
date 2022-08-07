package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwagLoginPage {

	//Using Lazy initialization Singleton pattern
	private static SwagLoginPage swagLogininstance;
	private SwagLoginPage() {}

	public static SwagLoginPage getLoginInstance() {

		if(swagLogininstance==null) {
			swagLogininstance = new SwagLoginPage();
		}
		return swagLogininstance;
	}

	//Identify the LoginPage Web Elements
	@FindBy(id="user-name")
	WebElement userID;

	@FindBy(id="password")
	WebElement pwd;

	@FindBy(id="login-button")
	WebElement loginBtn;

	//Performing actions in Login page

	public void enterUserID(String uName) {
		userID.sendKeys(uName);
	}

	public void enterPwd(String password) {
		pwd.sendKeys(password);
	}

	public void clickLoginbtn() {
		loginBtn.click();
	}
}