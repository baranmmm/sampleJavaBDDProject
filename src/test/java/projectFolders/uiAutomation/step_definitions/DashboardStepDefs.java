package projectFolders.uiAutomation.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import projectFolders._projectUtilities.Log;
import projectFolders.uiAutomation.utilities.CommonUISteps;

public class DashboardStepDefs extends CommonUISteps {
    @Given("the user goes to {string} website")
    public void theUserGoesToWebsite(String url) {
        driver.navigate().to(url);
        Log.info("Navigated to "+url);
    }

    @When("the user clicks on {string} option in top navigation bar")
    public void theUserClicksOnOptionInTopNavigationBar(String option) {
        //business logic comes here

    }
}
