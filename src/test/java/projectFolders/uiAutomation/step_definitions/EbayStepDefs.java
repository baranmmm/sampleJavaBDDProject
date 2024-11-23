package projectFolders.uiAutomation.step_definitions;

import io.cucumber.java.en.Given;
import projectFolders._projectUtilities.ConfigurationReader;
import projectFolders.uiAutomation.utilities.CommonUISteps;

public class EbayStepDefs extends CommonUISteps {

    @Given("the user goes to ebay website")
    public void theUserGoesToEbayWebsite() {
        driver.get(ConfigurationReader.get("ebayUrl"));
        try{
            waitFor(3);
            clickWithJS(homePage.acceptAllButton);
        }catch (Exception e){
        }

    }
}
