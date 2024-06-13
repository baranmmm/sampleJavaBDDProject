package projectFolders.mobileAutomation.step_definitions;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import projectFolders.mobileAutomation.utilities.CommonMobileSteps;
import projectFolders.mobileAutomation.utilities.MobileDriver;

import java.io.IOException;

public class MobileStepDef extends CommonMobileSteps {
    @Given("the user runs the application")
    public void theUserRunsTheApplication() {
        configureAppium("Pixel 2", "Etsy");
        try{
            getMobileDriver();
        }catch (Exception e){
            getMobileDriver();
        }
    }

    @When("the user taps on {string} button")
    public void theUserTapsOnButton(String buttonName) {
        driver.findElement(AppiumBy.accessibilityId(buttonName)).click();
    }
}
















