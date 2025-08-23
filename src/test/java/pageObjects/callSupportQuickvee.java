package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.appium.java_client.android.AndroidDriver;
import utilities.waitHelper;

public class callSupportQuickvee extends waitHelper{

	AndroidDriver driver;
	
	public callSupportQuickvee(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id ="com.apprication.quickveemanager.dev:id/tvEnterPhoneNumber")
	private WebElement phoneNumberText;
	
	@AndroidFindBy(id= "com.apprication.quickveemanager.dev:id/tvEnterPhone")
	private WebElement enterNumberText;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/etCallSupport")
	private WebElement enterNumber;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/btnCallMe")
	private WebElement callMeBtn;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvSupportPhoneNumber")
	private WebElement supportText;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/ivClose")
	private WebElement closeBtn;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/ivCall")
	private WebElement callLogo;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvSupportTeam")
	private WebElement callText;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/btnOkay")
	private WebElement okayBtn;
	
	public String getPhoneText() {
		return phoneNumberText.getText();
	}
	
	public boolean phoneTextDisplay() {
		return phoneNumberText.isDisplayed();
	}
	
	public boolean enterNumberDisplay() {
		return enterNumberText.isDisplayed();
	}
	
	
	public String getEnterText() {
		return enterNumberText.getText();
	}	
	
	public void enterNumberText(String number) {
		enterNumber.sendKeys(number);
	}
	
	public void callMeBtnClick() {
		elementClick(callMeBtn);
		callMeBtn.click();
	}
	
	public boolean callMeBtnDisplay() {
		return callMeBtn.isDisplayed();
	}
	
	public String getsupportText() {
		return supportText.getText();
	}
	
	public boolean closeBtnDisplay() {
		return closeBtn.isDisplayed();
	}
	public void closeBtnClick() {
		elementClick(closeBtn);
		closeBtn.click();
	}
	
	public boolean callLogoDisplay() {
		return callLogo.isDisplayed();
	}
	
	public boolean getCallDisplay() {
		return callText.isDisplayed();
	}
	public String getCallText() {
		return callText.getText();
	}
	
	public void okayBtnClick() {
		okayBtn.click();
	}
	
}
