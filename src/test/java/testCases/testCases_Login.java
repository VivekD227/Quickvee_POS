package testCases;

import org.testng.annotations.*;
import utilities.GetData;


import org.testng.Assert;
import pageObjects.loginPage;
import utilities.BaseClass;

public class testCases_Login extends BaseClass {

	loginPage loginpage;

	@BeforeMethod
	public void initPage() {
		loginpage = new loginPage(driver);
	}

	@Test(priority = 1)
	public void loginLogoTextDisplay() {

		boolean logoDisplayed = loginpage.quickveeLogoDisplay();
		boolean loginText = loginpage.loginTextDisplay();
		boolean storeLoginText = loginpage.storeTextDisplay();
		boolean emailLoginText = loginpage.emailTextDisplay();
		boolean passwordLoginText = loginpage.passwordText();
		boolean mandatoryText = loginpage.manadatoryTextDisplay();

		Assert.assertTrue(logoDisplayed, "Quickvee logo is not displayed");
		Assert.assertTrue(loginText, "Login Text is not displayed");
		Assert.assertTrue(storeLoginText, "Store Login Text is not displayed");
		Assert.assertTrue(emailLoginText, "Email Login Text is not displayed");
		Assert.assertTrue(passwordLoginText, "Password Login Text is not displayed");
		Assert.assertTrue(mandatoryText, "Mandatory Text is not displayed");

	}

	@Test(dataProvider = "loginBlankData", dataProviderClass = GetData.class , priority = 1)
	public void blankData(String storeName, String Email, String Pass) {
		
		loginpage.storeFieldText(storeName);
		String sname = loginpage.getStoreField();
		System.out.println("Store Name: " +sname);
		
		loginpage.emailFieldText(Email);
		String email = loginpage.getEmailField();
		System.out.println("Email: "+email);
		
		loginpage.passwordFieldText(Pass);
		String pass = loginpage.getPasswordField();
		System.out.println("Password: "+pass);
		
		loginpage.logiBtnClicked();
		
		Assert.assertTrue(loginpage.loginTextDisplay(), "You have Successfully login");
		
	}

}
