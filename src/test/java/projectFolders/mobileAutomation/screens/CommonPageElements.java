package projectFolders.mobileAutomation.screens;

import org.openqa.selenium.support.PageFactory;
import projectFolders.mobileAutomation.utilities.MobileDriver;

public abstract class CommonPageElements extends MobileDriver {
    public CommonPageElements(){
        PageFactory.initElements(driver, this);
    }


}
