package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.appium.java_client.android.AndroidDriver;
import utilities.BaseClass;
import utilities.waitHelper;

public class loginPage extends BaseClass {

	public AndroidDriver driver;
	waitHelper wait;
	public loginPage(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new waitHelper(driver);
	}
		
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Quickvee POS (Dev)']")
	private WebElement quickveeLogo;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvSignInLabel")
	private WebElement loginText;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvMerchantSoreNameLabel")
	private WebElement storeNameText;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvMerchantEmailLabel")
	private WebElement emailText;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvMerchantPasswordLabel")
	private WebElement passwordText;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tietMerchantStoreName")
	private WebElement storeField;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tietMerchantEmail")
	private WebElement emailField;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tietMerchantPassword")
	private WebElement passwordField;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Please use your registered store credentials.']")
	private WebElement storeToolTip;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Show password\"]")
	private WebElement showPasswordBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvMerchantForgotPassword")
	private WebElement forgotPassBtn;

	@AndroidFindBy(className = "android.widget.TextView")
	private WebElement manadatoryText;

	@AndroidFindBy(className = "android.widget.Button")
	private WebElement loginBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvMessage")
	private WebElement invalidErrorMsg;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/buttonOk")
	private WebElement invalidOKBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.apprication.quickveemanager.dev:id/textinput_error\" and @text=\"Enter Store Name\"]")
	private WebElement errorStoreInput;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.apprication.quickveemanager.dev:id/textinput_error\" and @text=\"Enter valid email address\"]")
	private WebElement errorEmailInput;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.apprication.quickveemanager.dev:id/textinput_error\" and @text=\"Enter password\"]")
	private WebElement errorPasswordInput;

	public boolean quickveeLogoDisplay() {
		wait.visiblityOfElement(quickveeLogo);
		return quickveeLogo.isDisplayed();
	}
	
	public boolean loginTextDisplay() {
		wait.visiblityOfElement(loginText);
		return loginText.isDisplayed();
	}
	
	public boolean storeTextDisplay() {
		wait.visiblityOfElement(storeNameText);
		return storeNameText.isDisplayed();
	}
	
	public boolean emailTextDisplay() {
		wait.visiblityOfElement(emailText);
		return emailText.isDisplayed();
	}
	
	public boolean passwordText() {
		wait.visiblityOfElement(passwordText);
		return passwordText.isDisplayed();
	}
	
	public void storeFieldClicked() {
		wait.elementClick(storeField);
		storeField.click();
	}
	
	public void emailFieldClicked() {
		wait.elementClick(emailField);
		emailField.click();
	}
	
	public void passwordField() {
		wait.elementClick(passwordField);
		passwordField.click();
	}
	
	public void storeToolTipClicked() {
		wait.elementClick(storeToolTip);
		storeToolTip.click();
	}
	
	public void showPasswordBtnClicked() {
		wait.elementClick(showPasswordBtn);
		showPasswordBtn.click();
	}
	
	public void forgotPassBtnClicked() {
		wait.elementClick(forgotPassBtn);
		forgotPassBtn.click();
	}
	
	public boolean manadatoryTextDisplay() {
		wait.visiblityOfElement(manadatoryText);
		return manadatoryText.isDisplayed();
	}
	
	public void logiBtnClicked() {
		wait.elementClick(loginBtn);
		loginBtn.click();
	}
	
	public boolean invalidErrorMsgDisplay() {
		wait.visiblityOfElement(invalidErrorMsg);
		return invalidErrorMsg.isDisplayed();
	}
	
	public void invalidOKBtnClicked() {
		wait.elementClick(invalidOKBtn);
		invalidOKBtn.click();
	}
	
	public boolean errorStoreInputDisplay() {
		wait.visiblityOfElement(errorStoreInput);
		return errorStoreInput.isDisplayed();
	}
	
	public boolean errorEmailInputDisplay() {
		wait.visiblityOfElement(errorEmailInput);
		return errorEmailInput.isDisplayed();
	}
	
	public boolean errorPasswordInputDisplay() {
		wait.visiblityOfElement(errorPasswordInput);
		return errorPasswordInput.isDisplayed();
	}
	
}
