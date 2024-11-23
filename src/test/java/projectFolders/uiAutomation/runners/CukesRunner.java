package projectFolders.uiAutomation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/cucumber-default-report",
                "rerun:target/failed.txt"},
        features = "src/test/resources/projectResources/uiResources/uiFeatures",
        glue = "projectFolders/uiAutomation/step_definitions",
        dryRun = false,
        tags = "@ebay"
)
public class CukesRunner {
}
