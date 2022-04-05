package Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.URL;

public class DriverManager {

    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();


    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(AppiumDriver driver1) {
        driver.set(driver1);
    }

    public static void initializeDriver(String deviceName, String port, String systemPort) throws Exception {

        AppiumDriver driver;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.UDID,deviceName);
        caps.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT,systemPort);
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.snap.mushroom.MainActivity");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.snapchat.android");
        caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
        URL url = new URL("http://127.0.0.1:"+port+"/wd/hub");
        driver = new AndroidDriver<AndroidElement>(url, caps);
        setDriver(driver);
        }

    }
