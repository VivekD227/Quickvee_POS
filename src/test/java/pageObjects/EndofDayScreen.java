package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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
	
	
	public boolean passcodeTextDisplay() {
		return passcodeText.isDisplayed();
	}
	
	public void cancelBtnClick() {
		cancelBtn.click();
	}
}
