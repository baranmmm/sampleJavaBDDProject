package projectFolders.mobileAutomation.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DashboardScreen extends CommonPageElements{


    @AndroidFindBy(accessibility = "Preference")
    public WebElement preferenceOption;

}
