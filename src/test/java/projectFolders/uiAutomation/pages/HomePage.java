package projectFolders.uiAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonPageElements {

    @FindBy(id = "gdpr-banner-accept")
    public WebElement acceptAllButton;


}
