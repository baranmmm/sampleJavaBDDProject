package affectli.step_definitions;

import affectli.utilities.Log;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import affectli.utilities.CommonSteps;
import affectli.utilities.Driver;

public class Hooks {

    @Before
    public void setUp() {
        Log.info("****************TEST STARTED****************");
        Driver.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        byte[] picture;
        if (scenario.isFailed()) {
            Log.error("TEST FAILED");
            // take screenshot and save it in /failed
            picture = CommonSteps.takeScreenshot("failed/" + scenario.getName()); // notes
            scenario.attach(picture, "image/png", scenario.getName());
        }else {
            Log.info("TEST PASSED");
        }
        Log.info("****************TEST ENDED****************");
        //Driver.closeDriver();
    }






}

