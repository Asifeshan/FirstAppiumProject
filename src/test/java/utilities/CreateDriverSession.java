package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {
    public static void androidDriverSession(String deviceName, String udId, String appPath) throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.UDID, udId);
        //caps.setCapability(MobileCapabilityType.APP, appPath);
        // Run Cmd command <adb shell dumpsys window | grep -E mCurrentFocus> or
        //adb shell “dumpsys activity activities | grep mResumedActivity
        //mResumedActivity: ActivityRecord{2fd6d21 u0 com.android.launcher3/.uioverrides.QuickstepLauncher t5}
        //{5c616ac u0 com.android.launcher3/com.android.launcher3.uioverrides.QuickstepLauncher}
    //    caps.setCapability("appPackage", "io.appium.android.apis");
     //   caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        caps.setCapability("appPackage", "com.android.launcher3");
        caps.setCapability("appActivity", ".uioverrides.QuickstepLauncher t5");

        URL url = new URL("http://localhost:4723/wd/hub");
        AppiumDriver driver = new AndroidDriver(url, caps);
    }
}
