package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.waitHelper;

public class loginPage extends waitHelper {

	public AndroidDriver driver;

	public loginPage(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

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
		visiblityOfElement(quickveeLogo);
		return quickveeLogo.isDisplayed();
	}

	public boolean loginTextDisplay() {
		visiblityOfElement(loginText);
		return loginText.isDisplayed();
	}

	public boolean storeTextDisplay() {
		visiblityOfElement(storeNameText);
		return storeNameText.isDisplayed();
	}

	public boolean emailTextDisplay() {
		visiblityOfElement(emailText);
		return emailText.isDisplayed();
	}

	public boolean passwordText() {
		visiblityOfElement(passwordText);
		return passwordText.isDisplayed();
	}

	public void storeFieldText(String storeName) {
		elementClick(storeField);
		storeField.sendKeys(storeName);
	}

	public String getStoreField() {
		return storeField.getAttribute("value");
	}

	public void emailFieldText(String email) {
		elementClick(emailField);
		emailField.sendKeys(email);
	}

	public String getEmailField() {
		return emailField.getAttribute("value");

	}

	public void passwordFieldText(String pass) {
		elementClick(passwordField);
		passwordField.sendKeys(pass);
	}

	public String getPasswordField() {
		return passwordField.getAttribute("value");
	}

	public void storeToolTipClicked() {
		elementClick(storeToolTip);
		storeToolTip.click();
	}

	public void showPasswordBtnClicked() {
		elementClick(showPasswordBtn);
		showPasswordBtn.click();
	}

	public void forgotPassBtnClicked() {
		elementClick(forgotPassBtn);
		forgotPassBtn.click();
	}

	public boolean manadatoryTextDisplay() {
		visiblityOfElement(manadatoryText);
		return manadatoryText.isDisplayed();
	}

	public void logiBtnClicked() {
		elementClick(loginBtn);
		loginBtn.click();
	}

	public boolean invalidErrorMsgDisplay() {
		visiblityOfElement(invalidErrorMsg);
		return invalidErrorMsg.isDisplayed();
	}

	public void invalidOKBtnClicked() {
		elementClick(invalidOKBtn);
		invalidOKBtn.click();
	}

	public boolean errorStoreInputDisplay() {
		visiblityOfElement(errorStoreInput);
		return errorStoreInput.isDisplayed();
	}

	public boolean errorEmailInputDisplay() {
		visiblityOfElement(errorEmailInput);
		return errorEmailInput.isDisplayed();
	}

	public boolean errorPasswordInputDisplay() {
		visiblityOfElement(errorPasswordInput);
		return errorPasswordInput.isDisplayed();
	}

}
