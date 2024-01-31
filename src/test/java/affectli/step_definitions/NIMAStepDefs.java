package affectli.step_definitions;

import affectli.utilities.CommonSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class NIMAStepDefs extends CommonSteps {

    @Then("verifies that {string} label is visible")
    public void verifiesThatLabelIsVisible(String label) {
        Assert.assertTrue(nimaPage.isLabelVisible(label));
    }

    @Then("verifies that Site list is populated with data")
    public void verifiesThatSiteListIsPopulatedWithData() {
        Assert.assertTrue(driver.findElements(By.xpath("//div[@role=\"menuitem\"]")).size()>0);
    }

    @And("the user clicks on {string} dropdown")
    public void theUserClicksOnDropdown(String dropdownName) {
        nimaPage.clickOnDropdownByLabel(dropdownName);
    }

    @And("the user selects {string} site from the site dropdown")
    public void theUserSelectsSiteFromTheSiteDropdown(String siteNameOrId) {
        nimaPage.selectASiteFromSiteDropdown(siteNameOrId);
    }


    @Then("verifies that site has correct background color")
    public void verifiesThatSiteHasCorrectBackgroundColor() {
        //TODO All priority color codes need to be added
        nimaPage.isSiteBackgroundColorCorrect();
    }

    @And("the user selects {string} option from {string} dropdown")
    public void theUserSelectsOptionFromDropdown(String option, String dropdownLabel) {
        waitFor(1);
        nimaPage.selectAnOptionFromADropdown(dropdownLabel,option);
        waitFor(1);
    }

    @And("clicks on {string} button")
    public void clicksOnButton(String buttonText) {
        scrollToElement(driver.findElement(By.xpath("//span[contains(text(),'"+buttonText+"')]//..//..//button")));
        nimaPage.clickOnAButton(buttonText);
    }

    @Then("verifies that {string} popup appears on the screen")
    public void verifiesThatPopupAppearsOnTheScreen(String popupMessage) {
        waitForVisibility(nimaPage.popupLocator,10);
        Assert.assertEquals(nimaPage.getPopupMessage(),popupMessage);
        waitFor(1);
        nimaPage.popupCloseButton.click();
    }

    @And("the user selects a fault start time")
    public void theUserSelectsAFaultStartTime() {
        nimaPage.faultStartTime.click();
        nimaPage.calendarOKbutton.click();
    }

    @And("the user selects a fault end time")
    public void theUserSelectsAFaultEndTime() {
        waitFor(3);
        nimaPage.faultEndTime.click();
        nimaPage.calendarOKbutton.click();
    }

    @And("enters {string} text into {string} textarea")
    public void entersTextIntoTextarea(String textToEnter, String textboxLabel) {
        waitFor(2);
        scrollToElement(nimaPage.resolutionTextarea);
        nimaPage.enterATextIntoATextarea(textboxLabel,textToEnter);
        waitFor(2);
    }

    @And("clicks on {string} button on confirmation popup")
    public void clicksOnButtonOnConfirmationPopup(String buttonText) {
        waitFor(3);
        driver.findElement(By.xpath("//span[contains(text(),'"+buttonText+"')]//..")).click();
    }

    @And("the user navigates to Dashboard page")
    public void theUserNavigatesToDashboardPage() {
        nimaPage.homeBtn.click();
    }
}
