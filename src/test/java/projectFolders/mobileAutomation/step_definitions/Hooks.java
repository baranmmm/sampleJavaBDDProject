package projectFolders.mobileAutomation.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import projectFolders._projectUtilities.Log;
import projectFolders.mobileAutomation.utilities.CommonMobileSteps;
import projectFolders.mobileAutomation.utilities.MobileDriver;

import java.io.IOException;

public class Hooks extends Log{

    @Override
    public void startTestCase() {
        Log.info("---------------------------------------------------------------------------------------");
        Log.info("***********************     MOBILE TEST STARTED    **************************");
        Log.info("---------------------------------------------------------------------------------------");
    }

    public void endTestCase() {
        Log.info("---------------------------------------------------------------------------------------");
        Log.info("***********************     MOBILE TEST ENDED    **************************");
        Log.info("---------------------------------------------------------------------------------------");
    }

    @Before
    public void setUp() throws IOException, InterruptedException {
        startTestCase();
        CommonMobileSteps.startAppiumServer();
        CommonMobileSteps.waitFor(3);
    }

    @After
    public void tearDown(Scenario scenario) {
        byte[] picture;
        if (scenario.isFailed()) {
            Log.info("---------------------------------------------------------------------------------------");
            Log.error("***********************     MOBILE TEST FAILED    **************************");
            Log.info("---------------------------------------------------------------------------------------");
            // take screenshot and save it in /failed
            picture = CommonMobileSteps.takeScreenshotOfMobile(scenario.getName()); // notes
            scenario.attach(picture, "image/png", scenario.getName());
        }else {
            Log.info("---------------------------------------------------------------------------------------");
            Log.info("***********************     MOBILE TEST PASSED    **************************");
            Log.info("---------------------------------------------------------------------------------------");
        }
        endTestCase();
        MobileDriver.closeDriver();
    }






}

