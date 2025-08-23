package pageObjects;

import org.openqa.selenium.By;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.waitHelper;

public class lockPinScreen extends waitHelper {

	AndroidDriver driver;

	public lockPinScreen(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvBtnRefresh")
	private WebElement refreshBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvLogo")
	private WebElement quickveeLogo;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvTime")
	private WebElement timeText;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvdate")
	private WebElement dateText;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/clQuickveeSupport")
	private WebElement quickveeSupport;
	
	@AndroidFindBy(id ="com.apprication.quickveemanager.dev:id/tvQuickveeSupportNumber")
	private WebElement callMeSupport;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/ivCall")
	private WebElement callLogo;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/buttonBack")
	private WebElement cancelBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvHeader")
	private WebElement enterPasscode;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/layout_view")
	private WebElement passcodeDisplay;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvHint")
	private WebElement passcodeHint;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/rvPasscode")
	private WebElement passcodeInput;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/ivLogout")
	private WebElement logoutBtn;

	@AndroidFindBy(xpath = "//*[contains(@text,'Invalid Passcode')]")
	private WebElement invalidPasscodeMsg;
	
	public boolean quickveeLogoDisplay(){
		visiblityOfElement(quickveeLogo);
		return quickveeLogo.isDisplayed();
	}
	
	public boolean timeDisplay() {
		visiblityOfElement(timeText);
		return timeText.isDisplayed();
	}
	
	public String getTime() {
		return timeText.getText();
	}
	
	public boolean dateDisplay() {
		visiblityOfElement(dateText);
		return dateText.isDisplayed();
	}
	
	public String getDate() {
		return dateText.getText();
	}
	
	public boolean quickveeSupportDisplay() {
		return quickveeSupport.isDisplayed();
	}
	
	public String callMeSupportText() {
		return callMeSupport.getText();
	}
	
	public boolean callLogoDisplay() {
		return callLogo.isDisplayed();
	}
	
	public String enterPasscodeText() {
		return enterPasscode.getText();
	}
	
	public boolean passcodeDisplay() {
		return passcodeDisplay.isDisplayed();
	}
	
	public String passcodeHintText() {
		return passcodeHint.getText();
	}
	
	public boolean passcodeInput() {
		return passcodeInput.isDisplayed();
	}
	
	public void logoutBtnClick() {
		elementClick(logoutBtn);
		logoutBtn.click();
	}
	
	public void clickDigit(String digit) {
		WebElement btn = driver.findElement(By.xpath(
				"//android.widget.TextView[@resource-id='com.apprication.quickveemanager.dev:id/tvNumber' and @text='"
						+ digit + "']"));
		btn.click();
	}

	public void enterPasscode(String passcode) {
		for (char digit : passcode.toCharArray()) {
			clickDigit(String.valueOf(digit));
		}
	}
	
	public void cancelBtnClick() {
		cancelBtn.click();
	}
}
