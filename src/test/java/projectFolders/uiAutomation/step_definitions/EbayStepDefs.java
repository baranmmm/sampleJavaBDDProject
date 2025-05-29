package projectFolders.uiAutomation.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import projectFolders._projectUtilities.ConfigurationReader;
import projectFolders.uiAutomation.pages.BasePage;
import projectFolders.uiAutomation.pages.PageInitializer;

public class EbayStepDefs extends BasePage {

    @Given("the user goes to ebay website")
    public void theUserGoesToEbayWebsite() {
        driver.get(ConfigurationReader.get("ebayUrl"));
        try{
            waitFor(3);
            clickWithJS(homePage.acceptAllButton);
        }catch (Exception e){
        }

    }

    @When("the user searches for {string} item")
    public void theUserSearchesForItem(String searchItem) {
        homePage.searchAnItem(searchItem);
    }

    @And("navigates to search results")
    public void navigatesToSearchResults() {
        homePage.clickOnSearchButton();
    }


}
