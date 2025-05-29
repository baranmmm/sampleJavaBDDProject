package projectFolders.uiAutomation.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import projectFolders.uiAutomation.pages.PageInitializer;

public class SearchResultsStepDefs extends PageInitializer {
    double firstItemsPrice;

    @And("collects the first item price")
    public void collectsTheFirstItemPrice() {
         firstItemsPrice = searchResultsPage.getFirstItemsPrice();
    }


    @And("clicks on the first search result")
    public void clicksOnTheFirstSearchResult() {
        searchResultsPage.clickOnTheFirstSearchResult();
        waitFor(3);
        switchToWindowByIndex(1);

    }

    @Then("verifies that the prices are matching")
    public void verifiesThatThePricesAreMatching() {
        double thePriceOfTheProduct = searchItemPage.getThePriceOfTheProduct();
        Assert.assertEquals(firstItemsPrice, thePriceOfTheProduct, 0);
    }
}
