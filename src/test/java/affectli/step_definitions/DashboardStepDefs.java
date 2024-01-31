package affectli.step_definitions;

import affectli.utilities.CommonSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DashboardStepDefs extends CommonSteps {

    @And("the user navigates to {string} module from top navigation bar")
    public void theUserNavigatesToModuleFromTopNavigationBar(String module) {
        dashboardPage.goToModuleFromDashboardTopNavBar(module);
    }

    @And("the user navigates to {string} module from App Launcher")
    public void theUserNavigatesToModuleFromAppLauncher(String module) {
        dashboardPage.goToAModuleFromAppLauncher(module);
    }

}
