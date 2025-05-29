package projectFolders.uiAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends PageInitializer {
    public BasePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id=\"gh-search-box\"]//input")
    public WebElement searchBox;

    @FindBy(css = "[value=\"Search\"]")
    public WebElement searchButton;



}
