package testCases;

import org.testng.annotations.*;

import utilities.GetData;

import org.testng.Assert;

import pageObjects.forgotPassword;
import pageObjects.loginPage;
import utilities.BaseClass;

public class testCases_Login extends BaseClass {

	loginPage loginpage;
	forgotPassword forgotpassword;
	
	@BeforeMethod
	public void initPage() {
		loginpage = new loginPage(driver);
		forgotpassword = new forgotPassword(driver);
	}

	@Test(priority = 1)
	public void loginLogoTextDisplay() {

		boolean logoDisplayed = loginpage.quickveeLogoDisplay();

		Assert.assertEquals(loginpage.getLoginText(), "LOGIN TO YOUR STORE");
		Assert.assertEquals(loginpage.getStoreText(), "Registered Store Name*");
		Assert.assertEquals(loginpage.getEmailText(), "Email*");
		Assert.assertEquals(loginpage.getPasswordText(), "Password*");
		Assert.assertEquals(loginpage.getMandatoryText(), "Fields Marked With * Are Required.");

		Assert.assertTrue(logoDisplayed, "Quickvee logo is not displayed");

	}

	 @Test(dataProvider = "loginBlankData", dataProviderClass = GetData.class, priority = 2)
	public void blankData(String storeName, String Email, String Pass) {

		loginpage.storeFieldText(storeName);
		String sname = loginpage.getStoreField();

		loginpage.emailFieldText(Email);
		String email = loginpage.getEmailField();
		System.out.println("Email: " + email);

		loginpage.passwordFieldText(Pass);
		String pass = loginpage.getPasswordField();
		System.out.println("Password: " + pass);

		Assert.assertFalse(loginpage.isLoginBtnEnabled(), "Login button should be disabled for blank input");
	}

	 @Test(dataProvider = "invalidEmailData", dataProviderClass = GetData.class, priority = 3)
	public void invalidEmailId(String storeName, String Email, String Pass) throws InterruptedException {

		loginpage.storeFieldText(storeName);
		String sname = loginpage.getStoreField();
		System.out.println("Store Name: " + sname);

		loginpage.emailFieldText(Email);
		String email = loginpage.getEmailField();
		System.out.println("Email: " + email);

		loginpage.passwordFieldText(Pass);
		String pass = loginpage.getPasswordField();
		System.out.println("Password: " + pass);

		Assert.assertTrue(loginpage.errorEmailInputDisplay(), "Invaild Email message not displayed");
		Thread.sleep(1000);
	}

	 @Test(dataProvider = "invalidMerchantDetails", dataProviderClass = GetData.class, priority = 4)
	public void validationLogin(String storeName, String Email, String Pass) throws InterruptedException {

		loginpage.storeFieldText(storeName);
		String sname = loginpage.getStoreField();
		System.out.println("Store Name: " + sname);

		loginpage.emailFieldText(Email);
		String email = loginpage.getEmailField();
		System.out.println("Email: " + email);

		loginpage.passwordFieldText(Pass);
		String pass = loginpage.getPasswordField();
		System.out.println("Password: " + pass);

		loginpage.logiBtnClicked();

		Assert.assertTrue(loginpage.invalidErrorMsgDisplay(), "No Error message displayed");
		loginpage.invalidOKBtnClicked();
		Thread.sleep(1000);

	}

	@Test(priority = 5)
	public void otherText() {

		loginpage.storeToolTipClicked();

		Assert.assertTrue(loginpage.toolTipDisplay(), "Toot tip text not displayed");
		Assert.assertEquals(loginpage.getToolTipText(), "Please use your registered store credentials.");

	    tapOnScreen(100, 200);
		loginpage.clearAllFields();

		loginpage.forgotPassBtnClicked();
		Assert.assertTrue(forgotpassword.forgotPasswordDisplay(), "Not in a forgot password page");
		forgotpassword.backBtnClick();
		
		Assert.assertEquals(loginpage.storeFieldText(), "Enter your registered store name");
		Assert.assertEquals(loginpage.emailFieldText(), "Enter Your Email Address");
		Assert.assertEquals(loginpage.passwordFieldText(), "Enter Your Password (Case-Sensitive)");
	
	}
	
	@Test(dataProvider = "validDataLogin", dataProviderClass = GetData.class, priority = 6)
	public void validLogin(String storeName, String Email, String Pass) throws InterruptedException {
		
		loginpage.storeFieldText(storeName);
		String sname = loginpage.getStoreField();
		System.out.println("Store Name: " + sname);

		loginpage.emailFieldText(Email);
		String email = loginpage.getEmailField();
		System.out.println("Email: " + email);

		loginpage.passwordFieldText(Pass);
		String pass = loginpage.getPasswordField();
		System.out.println("Password: " + pass);	
		
		loginpage.logiBtnClicked();
		Thread.sleep(8000);
		Assert.assertEquals(loginpage.progressBarText(), "Please wait... while we are set up the Database");
		Assert.assertTrue(loginpage.progressBarDisplay(), "Progress bar is not displayed");
	}
}
