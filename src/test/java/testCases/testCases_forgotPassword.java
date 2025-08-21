package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.forgotPassword;
import pageObjects.loginPage;
import utilities.BaseClass;

public class testCases_forgotPassword extends BaseClass {
	
	loginPage loginpage;
	forgotPassword forgotpassword;
	
	@BeforeMethod
	public void init() {
		loginpage = new loginPage(driver);
		forgotpassword = new forgotPassword(driver);
	}
	
	@Test(priority = 1)
	public void checkText() {
		
		loginpage.forgotPassBtnClicked();
		
		Assert.assertTrue(forgotpassword.forgotPasswordDisplay(), "Forgot Password Text is not displayed");
		Assert.assertEquals(forgotpassword.getForgotPasswordText(), "FORGOT YOUR PASSWORD");
		Assert.assertTrue(forgotpassword.backBtnDisplay(), "Back button is not displayed");
		Assert.assertTrue(forgotpassword.resetTextDisplay(), "Reset Password text is not displayed");
		Assert.assertEquals(forgotpassword.resetText(), "To reset your password, please enter your Email ID and Follow the instructions.");
		Assert.assertTrue(forgotpassword.emailLabelDisplay(), "Email text is not displayed");
		Assert.assertEquals(forgotpassword.emailLabelText(), "Email*");
		Assert.assertEquals(forgotpassword.resetBtnText(), "Reset");
	}
	
	@Test(priority = 2)
	public void unRegisterEmail() throws InterruptedException {
		
		forgotpassword.emailFieldText("vvv");
		Assert.assertTrue(forgotpassword.emailErrorMessageDisplay(), "Enter Valid email address isn not displayed");
		Assert.assertEquals(forgotpassword.emailErrorMessageText(), "Enter valid email address");
		
		forgotpassword.emailFieldText("");
		Assert.assertFalse(forgotpassword.isResetBtnEnabled(), "Login button should be disabled for blank input");
		
		forgotpassword.emailFieldText("vivek@imerchantech.com");
		forgotpassword.resetBtnClick();
		
		Assert.assertTrue(forgotpassword.resetLogoDisplayed(), "Error Logo is not visible");
		Assert.assertTrue(forgotpassword.emailNotRegisterDisplay(), "Email register error is not displayed");
		Assert.assertEquals(forgotpassword.emailNotRegisterText(), "Email-id is not registered with us.");
		
		forgotpassword.resetOkBtnClick();
		
		forgotpassword.emailFieldText("vivek.dubey521@gmail.com");
		forgotpassword.resetBtnClick();
		Thread.sleep(2000);

		loginpage.forgotPassBtnClicked();
		Assert.assertTrue(forgotpassword.resetLogoDisplayed(), "Error Logo is not visible");
		Assert.assertTrue(forgotpassword.emailNotRegisterDisplay(), "Email register error is not displayed");
		Assert.assertEquals(forgotpassword.emailNotRegisterText(), "Please check your email for additional instructions to complete your password change request.");
		
		forgotpassword.resetOkBtnClick();
		
	}
}
