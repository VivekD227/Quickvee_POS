package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import utilities.waitHelper;
	
public class forgotPassword extends waitHelper {
	AndroidDriver driver;
	loginPage loginpage;
	public forgotPassword(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvSignInLabel")
	private WebElement forgotPasswordText;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/ivBack")
	private WebElement backBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvResetPasswordLabel")
	private WebElement resetText;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvMerchantEmailLabel")
	private WebElement emailLabel;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.apprication.quickveemanager.dev:id/tietEmail\"]")
	private WebElement emailField;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/buttonReset")
	private WebElement resetBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/textinput_error")
	private WebElement emailErrorMessage;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/ivIcon")
	private WebElement resetLogo;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvMessage")
	private WebElement emailNotRegister;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/buttonOk")
	private WebElement resetOkBtn;

	public boolean forgotPasswordDisplay() {
		visiblityOfElement(forgotPasswordText);
		return forgotPasswordText.isDisplayed();
	}

	public String getForgotPasswordText() {
		return forgotPasswordText.getText();
	}

	public void backBtnClick() {
		elementClick(backBtn);
		backBtn.click();
	}

	public boolean backBtnDisplay() {
		visiblityOfElement(backBtn);
		return backBtn.isDisplayed();
	}

	public boolean resetTextDisplay() {
		visiblityOfElement(resetText);
		return resetText.isDisplayed();
	}

	public String resetText() {
		return resetText.getText();
	}

	public boolean emailLabelDisplay() {
		visiblityOfElement(emailLabel);
		return emailLabel.isDisplayed();
	}

	public String emailLabelText() {
		return emailLabel.getText();
	}

	public void emailFieldText(String email) {
		emailField.sendKeys(email);
	}

	public void resetBtnClick() {
		elementClick(resetBtn);
		resetBtn.click();
	}

	public String resetBtnText() {
		return resetBtn.getText();
	}

	public boolean emailErrorMessageDisplay() {
		visiblityOfElement(emailErrorMessage);
		return emailErrorMessage.isDisplayed();
	}

	public String emailErrorMessageText() {
		visiblityOfElement(emailErrorMessage);
		return emailErrorMessage.getText();
	}

	public boolean resetLogoDisplayed() {
		visiblityOfElement(resetLogo);
		return resetLogo.isDisplayed();
	}

	public String emailNotRegisterText() {
		visiblityOfElement(emailNotRegister);
		return emailNotRegister.getText();
	}

	public boolean emailNotRegisterDisplay() {
		visiblityOfElement(emailNotRegister);
		return emailNotRegister.isDisplayed();
	}

	public void resetOkBtnClick() {
		elementClick(resetOkBtn);
		resetOkBtn.click();
	
	}

	public boolean isResetBtnEnabled() {
		return resetBtn.isEnabled();
	}
}
