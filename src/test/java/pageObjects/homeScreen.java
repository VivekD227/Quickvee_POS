package pageObjects;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.waitHelper;

public class homeScreen extends waitHelper {

	public homeScreen(AndroidDriver driver) {
		super(driver);

	}

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvSupportNumber")
	private WebElement callSupportBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvStoreName")
	private WebElement storeName;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/tvEmployeeName")
	private WebElement employeeName;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/ivMenu")
	private WebElement menuBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/lockscreen")
	private WebElement menuLockScreenBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/salesSummary")
	private WebElement menuSaleSummaryBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/endOfDay")
	private WebElement menuEndOfDayBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/include_register")
	private WebElement registerBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/include_online_orders")
	private WebElement orderBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/include_inventory_home")
	private WebElement inventoryBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/include_dashboard")
	private WebElement dashBoardBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/include_customers")
	private WebElement customerBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/include_attendance")
	private WebElement attendenceBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/include_station_settings")
	private WebElement stationSettingBtn;

	@AndroidFindBy(id = "com.apprication.quickveemanager.dev:id/include_more")
	private WebElement moreBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.apprication.quickveemanager.dev:id/tvRegisterLabel\" and @text=\"Register\"]")
	private WebElement registerText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.apprication.quickveemanager.dev:id/tvRegisterLabel\" and @text=\"Orders\"]")
	private WebElement orderText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.apprication.quickveemanager.dev:id/tvRegisterLabel\" and @text=\"Inventory\"]")
	private WebElement inventoryText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.apprication.quickveemanager.dev:id/tvRegisterLabel\" and @text=\"Dashboard\"]")
	private WebElement dashBoardText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.apprication.quickveemanager.dev:id/tvRegisterLabel\" and @text=\"Customers\"]")
	private WebElement customerText;

	@AndroidFindBy(xpath = "//andro	id.widget.TextView[@resource-id=\"com.apprication.quickveemanager.dev:id/tvRegisterLabel\" and @text=\"Attendence\"]")
	private WebElement attendenceText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.apprication.quickveemanager.dev:id/tvRegisterLabel\" and @text=\"Station Settings\"]")
	private WebElement stationSettingsText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.apprication.quickveemanager.dev:id/tvRegisterLabel\" and @text=\"More\"]")
	private WebElement moreText;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Quickvee POS (Dev)\"])[1]")
	private WebElement registerLogo;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Quickvee POS (Dev)\"])[2]")
	private WebElement orderLogo;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Quickvee POS (Dev)\"])[3]")
	private WebElement inventoryLogo;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Quickvee POS (Dev)\"])[4]")
	private WebElement dashboardLogo;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Quickvee POS (Dev)\"])[5]")
	private WebElement customerLogo;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Quickvee POS (Dev)\"])[6]")
	private WebElement attendenceLogo;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Quickvee POS (Dev)\"])[7]")
	private WebElement stationLogo;

	@AndroidFindBy(xpath = "(//android.widget.ImageView[@content-desc=\"Quickvee POS (Dev)\"])[8]")
	private WebElement moreLogo;

	public void callSupportBtnClick() {
		elementClick(callSupportBtn);
		callSupportBtn.click();
	}

	public String storeNameText() {
		return storeName.getText();
	}

	public String employeeName() {
		return employeeName.getText();
	}

	public void menuBtnClick() {
		elementClick(menuBtn);
		menuBtn.click();
	}

	public void menuLockScreenBtnClick() {
		elementClick(menuLockScreenBtn);
		menuLockScreenBtn.click();
	}

	public void menuSaleSummaryBtnClick() {
		elementClick(menuSaleSummaryBtn);
		menuSaleSummaryBtn.click();
	}

	public void menuEndOfDayBtnClick() {
		elementClick(menuEndOfDayBtn);
		menuEndOfDayBtn.click();
	}
	
	public void registerBtnClick() {
		registerBtn.click();
	}
	
	public void orderBtnClick() {
		orderBtn.click();
	}
	
	public void inventoryBtnClick() {
		inventoryBtn.click();
	}
	
	public void dashBoardBtnClick() {
		dashBoardBtn.click();
	}
	
	public void customerBtnClick() {
		customerBtn.click();
	}
	
	public void attendenceBtnClick() {
		attendenceBtn.click();
	}
	
	public void stationSettingBtnClick() {
		stationSettingBtn.click();
	}
	
	public void moreBtnClick() {
		moreBtn.click();
	}
	
	public String getRegisterText() {
		return registerText.getText();
	}
	
	public String getOrderText() {
		return orderText.getText();
	}
	
	public String getInventoryText() {
		return inventoryText.getText();
	}
	
	public String getDashBoardText() {
		return dashBoardText.getText();
	}
	
	public String getCustomerText() {
		return customerText.getText();
	}
	
	public String getAttendenceText() {
		return attendenceText.getText();
	}
	
	public String getStationText() {
		return stationSettingsText.getText();
	}
	
	public String getMoreText() {
		return moreText.getText();
	}
	
	public boolean getRegisterLogo() {
		return registerLogo.isDisplayed();
	}
	
	public boolean getOrderLogo() {
		return orderLogo.isDisplayed();
	}
	
	public boolean getInventoryLogo() {
		return inventoryLogo.isDisplayed();
	}
	
	public boolean getDashBoardLogo() {
		return dashboardLogo.isDisplayed();
	}
	
	public boolean getCustomerLogo() {
		return customerLogo.isDisplayed();
	}
	
	public boolean getAttendenceLogo() {
		return attendenceLogo.isDisplayed();
	}
	
	public boolean getStataionSettingLogo() {
		return stationLogo.isDisplayed();
	}
	
	public boolean getMoreLogo() {
		return moreLogo.isDisplayed();
	}
	
}
