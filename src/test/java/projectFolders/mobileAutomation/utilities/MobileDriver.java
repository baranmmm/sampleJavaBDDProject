package projectFolders.mobileAutomation.utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.time.Duration;

public class MobileDriver{

    public static UiAutomator2Options options;
    public static AndroidDriver driver;
    public static Actions actions;



    public static void configureAppium(String deviceName, String appName){
        options = new UiAutomator2Options();
        options.setDeviceName(deviceName);
        options.setApp(System.getProperty("user.dir")+"\\src\\test\\resources\\projectResources\\mobileResources\\mobileApps\\"+appName+".apk");
    }

    public static AndroidDriver getMobileDriver() {
        driver = new AndroidDriver(options);
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }


//        CommonMobileSteps.waitFor(5);
//        driver.quit();
////        appiumServer.stop();









}
