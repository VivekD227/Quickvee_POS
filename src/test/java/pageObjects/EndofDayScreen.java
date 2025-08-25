package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.waitHelper;

public class EndofDayScreen extends waitHelper {
	
	AndroidDriver driver;
	public EndofDayScreen(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvHeader")
	private WebElement passcodeText;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/buttonBack")
	private WebElement cancelBtn;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/imageViewLogo")
	private WebElement quickveeLogo;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvStoreName")
	private WebElement storeName;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/passcodeLayout")
	private WebElement pinLayout;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/rvPasscode")
	private WebElement pinDial;
	
	public String getpasscodeText() {
		return passcodeText.getText();
	}
	
	public boolean cancelBtnDisplay() {
		return cancelBtn.isDisplayed();
	}
	
	public boolean quickveeLogoDisplay() {
		return quickveeLogo.isDisplayed();
	}
	
	public boolean passcodeTextDisplay() {
		return passcodeText.isDisplayed();
	}
	
	public void cancelBtnClick() {
		cancelBtn.click();
	}
	
	public String getstoreName() {
		return storeName.getText();
	}
	
	public boolean storeNameDisplay() {
		return storeName.isDisplayed();
	}
	
	public boolean pinLayoutDisplay() {
		return pinLayout.isDisplayed();
	}
	
	public boolean pinDialDisplay() {
		return pinDial.isDisplayed();
	}
	public void clickDigit(String digit) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    String xpath = "(//android.view.ViewGroup[@resource-id=\'com.apprication.quickveemanager.dev:id/numberLayout\"])[" + digit +"']";
	    
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	    element.click();
	}


	public void enterPasscode(String passcode) {
		for (char digit : passcode.toCharArray()) {
			clickDigit(String.valueOf(digit));
		}
	}
}
