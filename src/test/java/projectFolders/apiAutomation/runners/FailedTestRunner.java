package projectFolders.apiAutomation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/failed-html-report"},
        features = "@target/failed.txt",
        glue = "projectFolders/apiAutomation/step_definitions"
)
public class FailedTestRunner {
}