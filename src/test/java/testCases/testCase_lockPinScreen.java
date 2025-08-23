package testCases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.lockPinScreen;
import pageObjects.loginScreen;
import utilities.BaseClass;

public class testCase_lockPinScreen extends BaseClass {

	loginScreen loginpage;
	// forgotPasswordScreen forgotpassword;
	lockPinScreen lockscreen;

	@BeforeMethod
	public void init() {
		loginpage = new loginScreen(driver);
		// forgotpassword = new forgotPasswordScreen(driver);
		lockscreen = new lockPinScreen(driver);
	}

	@Test(priority = 1)
	public void DisplayAndTextCheck() throws Exception {
		if (loginpage.progressBarDisplay()) {
			System.out.println("Waiting for lock screen page.....");
			Thread.sleep(20000);

		}

		else {
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
			
			
		}
	}
	
	public void logoutBtnAndCallSupportClick() {
		
	}
}
