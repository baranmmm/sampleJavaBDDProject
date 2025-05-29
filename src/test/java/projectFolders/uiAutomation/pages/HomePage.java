package projectFolders.uiAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "gdpr-banner-accept")
    public WebElement acceptAllButton;




    public void searchAnItem(String searchItem){
        searchBox.sendKeys(searchItem);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }









}
