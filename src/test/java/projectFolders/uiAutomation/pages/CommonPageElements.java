package projectFolders.uiAutomation.pages;

import org.openqa.selenium.support.PageFactory;
import projectFolders.uiAutomation.utilities.Driver;

public abstract class CommonPageElements extends Driver {
    public CommonPageElements(){
        PageFactory.initElements(driver, this);
    }


}
