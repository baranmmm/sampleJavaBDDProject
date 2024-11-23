package projectFolders.mobileAutomation.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import projectFolders.mobileAutomation.utilities.MobileDriver;

public abstract class CommonPageElements extends MobileDriver {

    public CommonPageElements(){ PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


}
