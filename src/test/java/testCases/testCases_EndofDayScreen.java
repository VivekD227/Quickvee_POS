package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.EndofDayScreen;
import pageObjects.homeScreen;
import pageObjects.lockPinScreen;
import utilities.BaseClass;

public class testCases_EndofDayScreen extends BaseClass{

	lockPinScreen lockscreen;
	homeScreen homescreen;
	EndofDayScreen endofday;

	@BeforeMethod
	public void init() {
		lockscreen = new lockPinScreen(driver);
		homescreen = new homeScreen(driver);
		endofday = new EndofDayScreen(driver);
	}
	
	@Test(priority = 1)
	public void checkUI() {
		
		lockscreen.enterPasscode("1111");
		Assert.assertTrue(homescreen.storeNameDisplay(), "Not in a home page");
		
		homescreen.menuBtnClick();
		homescreen.menuEndOfDayBtnClick();
		
		Assert.assertTrue(endofday.quickveeLogoDisplay(), "Quickvee Logo not displayed");
		Assert.assertTrue(endofday.storeNameDisplay(), "Store Name is not displayed");
		
		String storeName = p.getProperty("StoreName");
		Assert.assertEquals(endofday.getstoreName(), storeName, "Store is changed to "+endofday.getstoreName());
		Assert.assertTrue(endofday.passcodeTextDisplay(), "Please Enter Passcode is not Displayed");
		Assert.assertEquals(endofday.getpasscodeText(), "Please Enter Passcode", "Please Enter Passcode text is not displayed");
		
		Assert.assertTrue(endofday.pinLayoutDisplay(), "Pin layout is not displayed");
		Assert.assertTrue(endofday.pinDialDisplay(), "Pin Dial is not displayed");

	
	}
}
