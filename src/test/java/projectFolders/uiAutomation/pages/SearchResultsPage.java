package projectFolders.uiAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//li[contains(@id,'item')]//span[@role=\"heading\"]")
    public List<WebElement> searchResults;

    @FindBy(xpath = "(//li[contains(@id,'item')]//span[@role=\"heading\"]//..//..//..//span[@class=\"s-item__price\"])[1]")
    public WebElement firstItemPrice;

    public void clickOnTheFirstSearchResult(){
        searchResults.get(0).click();
    }

    public double getFirstItemsPrice(){
        String[] s = firstItemPrice.getText().split(" ");
        return Double.parseDouble(s[0].substring(1));
    }



}
