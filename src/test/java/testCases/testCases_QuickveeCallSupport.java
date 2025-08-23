package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.callSupportQuickvee;
import pageObjects.lockPinScreen;
import utilities.BaseClass;

public class testCases_QuickveeCallSupport extends BaseClass{
	
	lockPinScreen lockscreen;
	callSupportQuickvee callsupport;

	@BeforeMethod
	public void init() {
		lockscreen = new lockPinScreen(driver);
		callsupport = new callSupportQuickvee(driver);
	}
	
	@Test(priority = 1)
	public void checkUI() {
		
		lockscreen.quickveeSupportClick();
		String phoneText  = "Enter a call back phone number";
		Assert.assertTrue(callsupport.phoneTextDisplay(), "Call back phone number is not displayed");
		Assert.assertEquals(callsupport.getPhoneText(), phoneText);
		
		Assert.assertTrue(callsupport.enterNumberDisplay(), "Enter Phone Number is not visible");
		String EnterNumber = "Enter Phone Number";
		Assert.assertEquals(callsupport.getEnterText(), EnterNumber);
		
		Assert.assertTrue(callsupport.callMeBtnDisplay(), "Call button is not display");
		Assert.assertTrue(callsupport.closeBtnDisplay(), "Cancel button is not display");
				
		String supportNumber = "SUPPORT: 877-579-1113 OPTION 4";
		Assert.assertEquals(callsupport.getsupportText(), supportNumber);
		
		callsupport.closeBtnClick();
		Assert.assertTrue(lockscreen.passcodeDisplay(), "We are not in a lock Screen page");

	}
	
	@Test(priority = 2)
	public void invalidNumber() throws InterruptedException {
		
		lockscreen.quickveeSupportClick();
		callsupport.enterNumberText("4444");
		callsupport.callMeBtnClick();
		Thread.sleep(2000);
		Assert.assertTrue(callsupport.callMeBtnDisplay(), "Call button is not display");
		callsupport.closeBtnClick();
		
		Assert.assertTrue(lockscreen.passcodeDisplay(), "We are not in a lock Screen page");
		
	}
	
	@Test(priority = 3)
	public void validNumber() throws InterruptedException {
		
		lockscreen.quickveeSupportClick();
		callsupport.enterNumberText("117-179-1113");
		
		callsupport.callMeBtnClick();
		Thread.sleep(5000);

		Assert.assertTrue(callsupport.callLogoDisplay(), "call support logo is not display");
		Assert.assertTrue(callsupport.getCallDisplay(), "call text is not display");
		String successCall = "Quickvee Support will be\ncontacting you soon.";
							  
		Assert.assertEquals(callsupport.getCallText(), successCall);
		
		callsupport.okayBtnClick();
		Assert.assertTrue(lockscreen.passcodeDisplay(), "We are not in a lock Screen page");

	}
	
}
