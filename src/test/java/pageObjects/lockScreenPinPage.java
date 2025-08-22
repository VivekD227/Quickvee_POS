package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.waitHelper;

public class lockScreenPinPage extends waitHelper {

	AndroidDriver driver;

	public lockScreenPinPage(AndroidDriver driver) {
		super(driver);
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
}
