package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import utilities.waitHelper;

public class forgotPassword extends waitHelper {
	AndroidDriver driver;
	
	public forgotPassword(AndroidDriver driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvSignInLabel")
	private WebElement forgotPasswordText;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/ivBack")
	private WebElement backBtn;
	
	public boolean forgotPasswordDisplay() {
		visiblityOfElement(forgotPasswordText);
		return forgotPasswordText.isDisplayed();
	}
	
	public void backBtnClick() {
		elementClick(backBtn);
		backBtn.click();
	}
}
