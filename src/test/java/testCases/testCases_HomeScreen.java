package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.EndofDayScreen;
import pageObjects.callSupportQuickvee;
import pageObjects.homeScreen;
import pageObjects.lockPinScreen;
import pageObjects.saleSummaryScreen;
import utilities.BaseClass;
import utilities.commonElement;

public class testCases_HomeScreen extends BaseClass {

	homeScreen homescreen;
	lockPinScreen lockscreen;
	saleSummaryScreen saleSummary;
	EndofDayScreen endofday;
	commonElement commonClass;
	callSupportQuickvee callsupport;

	@BeforeMethod
	public void initPage() {
		homescreen = new homeScreen(driver);
		lockscreen = new lockPinScreen(driver);
		saleSummary = new saleSummaryScreen(driver);
		endofday = new EndofDayScreen(driver);
		commonClass = new commonElement(driver);
		callsupport = new callSupportQuickvee(driver);

	}

	@Test(priority = 1)
	public void checkUI() {

		lockscreen.enterPasscode("1111");
		Assert.assertTrue(homescreen.storeNameDisplay(), "Not in a home page");

		Assert.assertTrue(homescreen.callSupportBtnDisplay(), "Call support button is not displayed");

		String callText = "CALL ME FOR SUPPORT";
		String actual = homescreen.callSupportBtnText();
		
		callText= callText.replace("\\s+", " ").trim();	
		actual   = actual.replaceAll("\\s+", " ").trim();
		Assert.assertEquals(actual, callText, "Call button text mismatch!");

		Assert.assertTrue(homescreen.storeNameDisplay(), "Store Name is not displayed");
		Assert.assertTrue(homescreen.employeeNameDisplay(), "Employee Name is not displayed");

		String empname = p.getProperty("EmpName");
		String storename = p.getProperty("StoreName");

		Assert.assertEquals(homescreen.storeNameText(), storename, "Store Name Miss Match");
		Assert.assertEquals(homescreen.employeeName().trim(), empname, "Employee Name Miss Match");

		Assert.assertEquals(homescreen.getRegisterText(), "Register");
		Assert.assertEquals(homescreen.getOrderText(), "Orders");
		Assert.assertEquals(homescreen.getInventoryText(), "Inventory");
		Assert.assertEquals(homescreen.getDashBoardText(), "Dashboard");
		Assert.assertEquals(homescreen.getCustomerText(), "Customers");
		Assert.assertEquals(homescreen.getAttendenceText(), "Attendance");
		Assert.assertEquals(homescreen.getStationText(), "Station Settings");
		Assert.assertEquals(homescreen.getMoreText(), "More");

		Assert.assertTrue(homescreen.getRegisterLogo(), "Register Logo not displayed");
		Assert.assertTrue(homescreen.getOrderLogo(), "Orders Logo not displayed");
		Assert.assertTrue(homescreen.getInventoryLogo(), "Inventory Logo not displayed");
		Assert.assertTrue(homescreen.getDashBoardLogo(), "Dashboard Logo not displayed");
		Assert.assertTrue(homescreen.getCustomerLogo(), "Customers Logo not displayed");
		Assert.assertTrue(homescreen.getAttendenceLogo(), "Attendance Logo not displayed");
		Assert.assertTrue(homescreen.getStataionSettingLogo(), "Station Settings Logo not displayed");
		Assert.assertTrue(homescreen.getMoreLogo(), "More Logo not displayed");

		Assert.assertTrue(homescreen.menuBtnDisplay(), "Menu button not diaplayed");
		homescreen.menuBtnClick();

		Assert.assertTrue(homescreen.menulockScreenDisplay(), "Lock Screen button not diaplayed");
		Assert.assertTrue(homescreen.menuSaleSummaryDisplay(), "Sale Summary button not diaplayed");
		Assert.assertTrue(homescreen.menuEndOfDayDisplay(), "End of Day button not diaplayed");

		String lockscreen = "Lock Screen";
		String SaleSummary = "Sales Summary";
		String EndofDay = "End of Day";

		Assert.assertEquals(homescreen.menulockScreenText(), lockscreen);
		Assert.assertEquals(homescreen.menuSaleSummaryText(), SaleSummary);
		Assert.assertEquals(homescreen.menuEndOFDayText(), EndofDay);

	}

	@Test(priority = 2)
	public void menuClick() throws InterruptedException {

		Thread.sleep(1000);
		homescreen.menuLockScreenBtnClick();
		Assert.assertTrue(lockscreen.passcodeDisplay(), "We are not in a lock screen page");
		lockscreen.enterPasscode("1111");
		Assert.assertTrue(homescreen.storeNameDisplay(), "Not in a home page");

		homescreen.menuBtnClick();

		homescreen.menuSaleSummaryBtnClick();
		Assert.assertTrue(saleSummary.saleSummaryDisplay(), "Not in a sale summary page");
		commonElement.homeBtnClick();
		Assert.assertTrue(homescreen.storeNameDisplay(), "Not in a home page");

		homescreen.menuBtnClick();

		homescreen.menuEndOfDayBtnClick();
		Assert.assertTrue(endofday.passcodeTextDisplay(), "Not in End of Day page");
		endofday.cancelBtnClick();
		Assert.assertTrue(homescreen.storeNameDisplay(), "Not in a home page");

	}

	@Test(priority = 3)
	public void callMeClass() throws InterruptedException {

		homescreen.callSupportBtnClick();
		callsupport.enterNumberText("4444");
		Thread.sleep(2000);
		Assert.assertTrue(callsupport.callMeBtnDisplay(), "Call button is not display");
		callsupport.closeBtnClick();
		homescreen.callSupportBtnClick();

		callsupport.enterNumberText("117-179-1113");

		callsupport.callMeBtnClick();
		Thread.sleep(5000);

		Assert.assertTrue(callsupport.callLogoDisplay(), "call support logo is not display");
		Assert.assertTrue(callsupport.getCallDisplay(), "call text is not display");
		String expected = "Quickvee Support will be contacting you soon.";
		String actual   = callsupport.getCallText();

		// Normalize spaces/newlines
		expected = expected.replaceAll("\\s+", " ").trim();
		actual   = actual.replaceAll("\\s+", " ").trim();

		Assert.assertEquals(actual, expected, "Message text mismatch!");
		callsupport.okayBtnClick();

		Assert.assertTrue(homescreen.storeNameDisplay(), "Not in a home page");
		Assert.assertTrue(homescreen.callSupportBtnDisplay(), "Call support button is not displayed");

	}
}
