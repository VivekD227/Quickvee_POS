package utilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void SetUp() throws MalformedURLException, URISyntaxException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\Priya Mishra\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("samsung SM-T733");
		options.setAppPackage("com.apprication.quickveemanager.dev");
		options.setAppActivity("com.apprication.quickveemanager.activity.LauncherActivity");

		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
	}
	
	
	@AfterClass
	public void tearDown() {
		// driver.quit();
		service.stop();
	}
}

