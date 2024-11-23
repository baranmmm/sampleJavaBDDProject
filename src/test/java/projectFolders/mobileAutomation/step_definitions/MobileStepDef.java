package projectFolders.mobileAutomation.step_definitions;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import projectFolders.mobileAutomation.utilities.CommonMobileSteps;
import projectFolders.mobileAutomation.utilities.MobileDriver;

import java.io.IOException;

public class MobileStepDef extends CommonMobileSteps {

    @When("the user taps on {string} button")
    public void theUserTapsOnButton(String buttonName) {
        waitFor(2);
        dashboardScreen.preferenceOption.click();
    }

    @Given("the user runs {string} application on {string} device")
    public void theUserRunsApplicationOnDevice(String appName, String deviceName) {
        configureAppium(deviceName, appName);
        try{
            getMobileDriver();
        }catch (Exception e){
            getMobileDriver();
        }
    }
}
















