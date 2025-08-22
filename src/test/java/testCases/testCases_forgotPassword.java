package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.forgotPassword;
import pageObjects.loginPage;
import utilities.BaseClass;
import utilities.GmailReader;

public class testCases_forgotPassword extends BaseClass {

	loginPage loginpage;
	forgotPassword forgotpassword;

	@BeforeMethod
	public void init() {
		loginpage = new loginPage(driver);
		forgotpassword = new forgotPassword(driver);
	}

//	@Test(priority = 1)
	public void checkText() {

		loginpage.forgotPassBtnClicked();

		Assert.assertTrue(forgotpassword.forgotPasswordDisplay(), "Forgot Password Text is not displayed");
		Assert.assertEquals(forgotpassword.getForgotPasswordText(), "FORGOT YOUR PASSWORD");
		Assert.assertTrue(forgotpassword.backBtnDisplay(), "Back button is not displayed");
		Assert.assertTrue(forgotpassword.resetTextDisplay(), "Reset Password text is not displayed");
		Assert.assertEquals(forgotpassword.resetText(),
				"To reset your password, please enter your Email ID and follow the instructions.");
		Assert.assertTrue(forgotpassword.emailLabelDisplay(), "Email text is not displayed");
		Assert.assertEquals(forgotpassword.emailLabelText(), "Email*");
		Assert.assertEquals(forgotpassword.resetBtnText(), "Reset");
	}

//	@Test(priority = 2)
	public void invalidEmail() throws InterruptedException {

		forgotpassword.emailFieldText(p.getProperty("setInvalidEmail"));
		Assert.assertTrue(forgotpassword.emailErrorMessageDisplay(), "Enter Valid email address isn not displayed");
		Assert.assertEquals(forgotpassword.emailErrorMessageText(), "Enter valid email address");
		Thread.sleep(500);
		forgotpassword.emailFieldClear();
	}

//	@Test(priority = 3)
	public void blankData() throws InterruptedException {
		forgotpassword.emailFieldText(p.getProperty("setBlankForgotPassword"));
		Assert.assertFalse(forgotpassword.isResetBtnEnabled(), "Login button should be disabled for blank input");
		Thread.sleep(500);
		forgotpassword.emailFieldClear();

	}

//	@Test(priority = 4)
	public void unregisterEmail() {
		forgotpassword.emailFieldText(p.getProperty("setUnregisterEmail"));
		forgotpassword.resetBtnClick();

		Assert.assertTrue(forgotpassword.resetLogoDisplayed(), "Error Logo is not visible");
		Assert.assertTrue(forgotpassword.emailNotRegisterDisplay(), "Email register error is not displayed");
		Assert.assertEquals(forgotpassword.emailNotRegisterText(), "Email-id is not registered with us.");

		forgotpassword.resetOkBtnClick();
		
	}

	@Test(priority = 5)
	public void emailReceivedConfirmation() throws InterruptedException {
		loginpage.forgotPassBtnClicked();

		forgotpassword.emailFieldText(p.getProperty("setRegisterEmail"));
		forgotpassword.resetBtnClick();
		Thread.sleep(2000);

		Assert.assertTrue(forgotpassword.resetLogoDisplayed(), "Error Logo is not visible");
		Assert.assertTrue(forgotpassword.emailNotRegisterDisplay(), "Email register error is not displayed");
		Assert.assertEquals(forgotpassword.emailNotRegisterText(),
				"Please check your email for additional instructions to complete your password change request.");

		forgotpassword.resetOkBtnClick();
		
		Thread.sleep(15000);

		String gmailUsername = p.getProperty("gmailEmail");
		String gmailPassword = p.getProperty("gmailPassword");

		try {
			String resetLink = GmailReader.getResetLinkFromEmail(gmailUsername, gmailPassword);
			//System.out.println("Reset link: " + resetLink);
			Assert.assertNotNull(resetLink);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("GmailReader failed: " + e.getMessage());
		}
	}
	
	@Test(priority = 6)
	public void validateResetEmailTitleAndBody() {
		
	    String gmailUsername = p.getProperty("gmailEmail");
	    String gmailPassword = p.getProperty("gmailPassword");

	    GmailReader.EmailContent email = GmailReader.getLatestResetEmail(gmailUsername, gmailPassword);
	    Assert.assertNotNull(email, "Reset password email not found");
	    System.out.println("Email Body:\n" + email.body);

	    // Subject validation
	    Assert.assertEquals(email.subject.trim(), "Reset Password", "Subject mismatch");

	    // Body validation (contains key phrases)
	    Assert.assertTrue(email.body.contains("Hello Chain Smoker"), "Missing greeting");
	    Assert.assertTrue(email.body.contains("reset the password for your account"), "Missing reset message");
	    Assert.assertTrue(email.body.contains("click here"), "Missing reset link");
	}
	
	
}
