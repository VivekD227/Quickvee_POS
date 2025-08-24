package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.waitHelper;

public class saleSummaryScreen extends waitHelper {

	AndroidDriver driver;
	public saleSummaryScreen(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvTitle")
	private WebElement saleSummaryTitle;
	
	public boolean saleSummaryDisplay() {
		return saleSummaryTitle.isDisplayed();
	}
}
