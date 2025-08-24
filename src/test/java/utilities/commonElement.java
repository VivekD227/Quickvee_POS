package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class commonElement {

	 static AndroidDriver driver;

	public commonElement(AndroidDriver driver) {
		commonElement.driver = driver;
	}

	public static void homeBtnClick() {
		WebElement homeBtn = driver.findElement(By.id("com.apprication.quickveemanager.dev:id/ivHome"));
		homeBtn.click();
	}
}
