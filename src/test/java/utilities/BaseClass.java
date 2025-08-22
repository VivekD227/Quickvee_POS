package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public Properties p;
	@BeforeClass
	public void SetUp() throws URISyntaxException, IOException {
		
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\Appri\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
		options.setDeviceName("samsung SM-T733");
		options.setAppPackage("com.apprication.quickveemanager.dev");
		options.setAppActivity("com.apprication.quickveemanager.activity.LauncherActivity");
		options.setNoReset(true);   // keep data, don’t uninstall

		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		
	}
	
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
	    if (driver != null) {
	        try {
	            driver.terminateApp("com.apprication.quickveemanager.dev"); // close app explicitly
	        } catch (Exception e) {
	            System.out.println("App already closed: " + e.getMessage());
	        }
	        driver.quit();  // end Appium session
	    }
	    if (service != null) {
	        service.stop();  // stop Appium server
	    }
	}
	
	public void tapOnScreen(int x, int y) {
	    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	    Sequence tap = new Sequence(finger, 1);
	    tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
	    tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	    tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	    driver.perform(Collections.singletonList(tap));
	}
}

