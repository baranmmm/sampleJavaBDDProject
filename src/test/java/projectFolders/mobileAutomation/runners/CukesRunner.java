package projectFolders.mobileAutomation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.util.Scanner;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/cucumber-default-report",
                "rerun:target/failed.txt"},
        features = "src/test/resources/projectResources/mobileResources/mobileFeatures",
        glue = "projectFolders/mobileAutomation/step_definitions",
        dryRun = false,
        tags = "@mobileDemo"
)
public class CukesRunner {
}
