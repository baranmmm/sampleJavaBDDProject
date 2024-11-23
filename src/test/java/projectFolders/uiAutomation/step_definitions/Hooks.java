package projectFolders.uiAutomation.step_definitions;

import projectFolders._projectUtilities.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import projectFolders.uiAutomation.utilities.CommonUISteps;
import projectFolders.uiAutomation.utilities.Driver;

public class Hooks extends Log{

    @Override
    public void startTestCase() {
        Log.info("---------------------------------------------------------------------------------------");
        Log.info("***********************     UI TEST STARTED    **************************");
        Log.info("---------------------------------------------------------------------------------------");
    }

    public void endTestCase() {
        Log.info("---------------------------------------------------------------------------------------");
        Log.info("***********************     UI TEST ENDED    **************************");
        Log.info("---------------------------------------------------------------------------------------");
    }

    @Before
    public void setUp() {
        startTestCase();
        Driver.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        byte[] picture;
        if (scenario.isFailed()) {
            Log.info("---------------------------------------------------------------------------------------");
            Log.error("***********************     UI TEST FAILED    **************************");
            Log.info("---------------------------------------------------------------------------------------");
            // take screenshot and save it in /failed
            picture = CommonUISteps.takeScreenshot("failed/" + scenario.getName()); // notes
            scenario.attach(picture, "image/png", scenario.getName());
        }else {
            Log.info("---------------------------------------------------------------------------------------");
            Log.info("***********************     UI TEST PASSED    **************************");
            Log.info("---------------------------------------------------------------------------------------");
        }
        endTestCase();
//        Driver.closeDriver();
    }






}

