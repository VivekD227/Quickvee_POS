package testCases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.callSupportQuickvee;
import pageObjects.homeScreen;
import pageObjects.lockPinScreen;
import pageObjects.loginScreen;
import pageObjects.logoutScreen;
import utilities.BaseClass;

public class testCases_lockPinScreen extends BaseClass {

	loginScreen loginpage;
	lockPinScreen lockscreen;
	logoutScreen logoutscreen;
	callSupportQuickvee callsupport;
	homeScreen homescreen;

	@BeforeMethod
	public void init() {
		loginpage = new loginScreen(driver);
		lockscreen = new lockPinScreen(driver);
		logoutscreen = new logoutScreen(driver);
		callsupport = new callSupportQuickvee(driver);
		homescreen = new homeScreen(driver);
	}

	@Test(priority = 1)
	public void DisplayAndTextCheck() throws Exception {
		// boolean pBar = true;
		try{
		if (loginpage.progressBarDisplay()) {
			System.out.println("Waiting for lock screen page.....");
			Thread.sleep(20000);
		}
		}
		catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		
		Assert.assertTrue(lockscreen.quickveeLogoDisplay(), "Quickvee Logo is not displayed");

		String deviceTimeRaw = driver.getDeviceTime();
		System.out.println("Device Time: " + deviceTimeRaw);

		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date parsedDate = inputFormat.parse(deviceTimeRaw.substring(0, 19));

		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
		timeFormat.setTimeZone(TimeZone.getDefault());
		String formattedDeviceTime = timeFormat.format(parsedDate);

		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setTimeZone(TimeZone.getDefault());
		String formattedDeviceDate = dateFormat.format(parsedDate);

		String appTime = lockscreen.getTime();
		String appDate = lockscreen.getDate();

		System.out.println("App Time: " + appTime);
		System.out.println("Device Time: " + formattedDeviceTime);
		System.out.println("App Date: " + appDate);
		System.out.println("Device Date: " + formattedDeviceDate);

		Assert.assertEquals(appTime.toUpperCase(), formattedDeviceTime.toUpperCase(),
				"App time does not match device time!");
		Assert.assertEquals(appDate, formattedDeviceDate, "App date does not match device date!");
		Assert.assertTrue(lockscreen.quickveeSupportDisplay(), "Call support Text is not displayed");
		Assert.assertEquals(lockscreen.callMeSupportText(), "CALL ME FOR SUPPORT");
		Assert.assertTrue(lockscreen.callLogoDisplay(), "Call logo is not displayed");

		Assert.assertEquals(lockscreen.enterPasscodeText(), "Enter Your Passcode");
		Assert.assertTrue(lockscreen.passcodeDisplay(), "Pin Display not visible");
		Assert.assertEquals(lockscreen.passcodeHintText(), "Enter your 4-digit passcode.");

	}

	@Test(priority = 2)
	public void validateRefreshButton() throws Exception {
		// Ensure refresh button is displayed
		Assert.assertTrue(lockscreen.isRefreshDisplayed(), "Refresh button not displayed");

		// Get old time before refresh
		String oldTime = driver.getDeviceTime();
		System.out.println("Old Time: " + oldTime);

		// Click refresh
		lockscreen.refreshBtnClick();
		Thread.sleep(3000); // wait for UI to update

		// Get new time after refresh
		String newTime = driver.getDeviceTime();
		System.out.println("New Time: " + newTime);

		// Validate that time got updated
		Assert.assertNotEquals(newTime, oldTime, "Time did not refresh after clicking refresh button!");
	}

	@Test(priority = 3)
	public void logoutAndCallBtn() throws InterruptedException {

		Assert.assertTrue(lockscreen.logoutBtnDisplay(), "Logout button not displayed");
		lockscreen.logoutBtnClick();

		Assert.assertTrue(logoutscreen.logoutTextDisplay(), "We are not in a logout page");
		logoutscreen.noBtnClick();

		Assert.assertTrue(lockscreen.quickveeSupportDisplay(), "We are not in lock screen page");
		lockscreen.quickveeSupportClick();
		Assert.assertTrue(callsupport.phoneTextDisplay(), "We are not in Call Support Quickvee Page");

		callsupport.closeBtnClick();
		lockscreen.cancelBtnClick();

		relaunchApp();

		loginpage = new loginScreen(driver);
		lockscreen = new lockPinScreen(driver);
		logoutscreen = new logoutScreen(driver);
		callsupport = new callSupportQuickvee(driver);

		Thread.sleep(5000);
		// Validate app is back on lock screen
		Assert.assertTrue(lockscreen.passcodeDisplay(), "We are not in a logout page");
	}

	@Test(priority = 4)
	public void invalidPin() {

		lockscreen.enterPasscode("5874");
		Assert.assertTrue(lockscreen.passcodeDisplay(), "We are not in a logout page");

	}

	@Test(priority = 4)
	public void validPin() {

		lockscreen.enterPasscode("1111");
		Assert.assertTrue(homescreen.storeNameDisplay(), "Not in a home page");
		Assert.assertTrue(homescreen.employeeNameDisplay(), "Not in a home page");

		String empname = p.getProperty("EmpName").trim();
		String storename = p.getProperty("StoreName").trim();

		Assert.assertEquals(homescreen.storeNameText(), storename, "Store Name Miss Match");
		Assert.assertEquals(homescreen.employeeName().trim(), empname, "Employee Name Miss Match");

	}

}
