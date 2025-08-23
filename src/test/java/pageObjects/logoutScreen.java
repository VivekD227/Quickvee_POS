package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.appium.java_client.android.AndroidDriver;
import utilities.waitHelper;

public class logoutScreen extends waitHelper{

	AndroidDriver driver;
	
	public logoutScreen(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), driver);
	}

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/ivIcon")
	private WebElement logoutLogo;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvMessage")
	private WebElement logoutText;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/buttonCancel")
	private WebElement noBtn;
	
	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/buttonOk")
	private WebElement yesBtn;
	
	public boolean logoutLogoDisplay() {
		return logoutLogo.isDisplayed();
	}
	
	public String getlogoutText() {
		return logoutText.getText();
	}
	
	public void noBtnClick() {
		noBtn.click();
	}
	
	public void yesBtn() {
		yesBtn.click();
	}
	
}
