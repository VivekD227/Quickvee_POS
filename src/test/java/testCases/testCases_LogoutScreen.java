package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.lockPinScreen;
import pageObjects.loginScreen;
import pageObjects.logoutScreen;
import utilities.BaseClass;

public class testCases_LogoutScreen extends BaseClass {

	lockPinScreen lockscreen;
	logoutScreen logoutscreen;
	loginScreen loginscreen;

	@BeforeMethod
	public void init() {
		lockscreen = new lockPinScreen(driver);
		logoutscreen = new logoutScreen(driver);
		loginscreen = new loginScreen(driver);
	}

	@Test(priority = 1)
	public void CheckUI() {

		lockscreen.logoutBtnClick();

		Assert.assertTrue(logoutscreen.logoutLogoDisplay(), "Not in logout Screen");
		Assert.assertTrue(logoutscreen.logoutTextDisplay(), "Logout text is not display");
		Assert.assertTrue(logoutscreen.noBtnDisplay(), "No button not display");
		Assert.assertTrue(logoutscreen.yesBtnDisplay(), "Yes button not display");

		String logoutConfirmText = "Are you sure you want to logout?\nOnce you logout, after log in you need to check printers again.";
		Assert.assertEquals(logoutscreen.getlogoutText(), logoutConfirmText);
	}

	@Test(priority = 2)
	public void pressNoButton() {

//		lockscreen.logoutBtnClick();
//		Assert.assertTrue(logoutscreen.logoutLogoDisplay(), "Not in logout Screen");
		logoutscreen.noBtnClick();
		Assert.assertTrue(lockscreen.passcodeDisplay(), "We are not in a lock Screen page");

	}

	@Test(priority = 3)
	public void pressYesButton() throws InterruptedException {

		lockscreen.logoutBtnClick();
		Assert.assertTrue(logoutscreen.logoutLogoDisplay(), "Not in logout Screen");
		logoutscreen.yesBtnClick();
		Thread.sleep(5000);
		Assert.assertTrue(loginscreen.loginTextDisplay(), "User is not logout");

	}
}
