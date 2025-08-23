package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.waitHelper;

public class loginScreen extends waitHelper {

	public AndroidDriver driver;

	public loginScreen(AndroidDriver driver) {
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

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Please use your registered store credentials.\"]")
	private WebElement toolTipText;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Show password\"]")
	private WebElement showPasswordBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvMerchantForgotPassword")
	private WebElement forgotPassBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Fields Marked With * Are Required.\"]")
	private WebElement manadatoryText;

	@AndroidFindBy(className = "android.widget.Button")
	private WebElement loginBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvMessage")
	private WebElement invalidErrorMsg;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/buttonOk")
	private WebElement invalidOKBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/textinput_error")
	private WebElement errorInvalidText;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/progressMessage")
	private WebElement progressBar;

	 // Logo
    public boolean quickveeLogoDisplay() {
        visiblityOfElement(quickveeLogo);
        return quickveeLogo.isDisplayed();
    }

    
    // Labels - Get Text
    public String getLoginText() {
        visiblityOfElement(loginText);
        return loginText.getText();
    }

    public String getStoreText() {
        visiblityOfElement(storeNameText);
        return storeNameText.getText();
    }

    public String getEmailText() {
        visiblityOfElement(emailText);
        return emailText.getText();
    }

    public String getPasswordText() {
        visiblityOfElement(passwordText);
        return passwordText.getText();
    }

    public String getMandatoryText() {
        visiblityOfElement(manadatoryText);
        return manadatoryText.getText();
    }

    // Fields input
    public void storeFieldText(String storeName) {
        elementClick(storeField);
        storeField.clear();
        storeField.sendKeys(storeName);
    }

    public String getStoreField() {
        return storeField.getText();
    }

    public void emailFieldText(String email) {
        elementClick(emailField);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public String getEmailField() {
        return emailField.getText();
    }

    public String getToolTipText() {
    	return toolTipText.getText();
    }
    
    public boolean toolTipDisplay() {
    	return toolTipText.isDisplayed();
    }
    public void passwordFieldText(String pass) {
        elementClick(passwordField);
        passwordField.clear();
        passwordField.sendKeys(pass);
    }

    public String getPasswordField() {
        return passwordField.getText();
    }

    // Buttons & Clicks
    public void storeToolTipClicked() {
        elementClick(storeToolTip);
        storeToolTip.click();
    }
    public void storeFieldClick() {
    	elementClick(storeField);
    	storeField.click();
    }
    
    public void forgotPassBtnClicked() {
        elementClick(forgotPassBtn);
        forgotPassBtn.click();
    }

    public void logiBtnClicked() {
        elementClick(loginBtn);
        loginBtn.click();
    }

    public boolean isLoginBtnEnabled() {
        return loginBtn.isEnabled();
    }

    // Error handling
    public boolean invalidErrorMsgDisplay() {
        visiblityOfElement(invalidErrorMsg);
        return invalidErrorMsg.isDisplayed();
    }

    public void invalidOKBtnClicked() {
        elementClick(invalidOKBtn);
        invalidOKBtn.click();
    }

    public boolean errorEmailInputDisplay() {
        visiblityOfElement(errorInvalidText);
        return errorInvalidText.isDisplayed();
    }

    public void clearAllFields() {
        storeField.clear();
        emailField.clear();
        passwordField.clear();
    }
    
    public boolean progressBarDisplay() {
    	visiblityOfElement(progressBar);
    	return progressBar.isDisplayed();
    }
    
    public String progressBarText() {
    	visiblityOfElement(progressBar);
    	return progressBar.getText();
    }
    
    public String storeFieldText() {
    	return storeField.getText();
    }
    
    public String emailFieldText() {
    	return emailField.getText();
    }
    
    public String passwordFieldText() {
    	return passwordField.getText();
    }
}
