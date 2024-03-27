package projectFolders.apiAutomation.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import projectFolders._projectUtilities.Log;
import projectFolders.uiAutomation.utilities.CommonUISteps;
import projectFolders.uiAutomation.utilities.Driver;

public class Hooks extends Log{


    @Before
    public void setUp() {
        startTestCase();

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            Log.info("---------------------------------------------------------------------------------------");
            Log.error("***********************     API TEST FAILED    **************************");
            Log.info("---------------------------------------------------------------------------------------");
        }else {
            Log.info("---------------------------------------------------------------------------------------");
            Log.info("***********************     API TEST PASSED    **************************");
            Log.info("---------------------------------------------------------------------------------------");
        }
        endTestCase();
    }


    @Override
    public void startTestCase() {
        Log.info("---------------------------------------------------------------------------------------");
        Log.info("***********************     API TEST STARTED    **************************");
        Log.info("---------------------------------------------------------------------------------------");
    }

    public void endTestCase() {
        Log.info("---------------------------------------------------------------------------------------");
        Log.info("***********************     API TEST ENDED    **************************");
        Log.info("---------------------------------------------------------------------------------------");
    }






}

