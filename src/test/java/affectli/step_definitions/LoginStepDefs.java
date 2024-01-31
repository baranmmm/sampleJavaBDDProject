package affectli.step_definitions;

import affectli.utilities.CommonSteps;
import affectli.utilities.ConfigurationReader;
import affectli.utilities.Driver;
import affectli.utilities.Log;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs extends CommonSteps {

    @Given("the user provides valid credentials")
    public void theUserProvidesValidCredentials() {
        driver.get(ConfigurationReader.get("uat_url"));
        loginPage.usernameTxtbox.sendKeys(ConfigurationReader.get("mehmetUser"));
        loginPage.passwordTxtbox.sendKeys(System.getenv("affectli_password"));

    }

    @When("the user clicks on login button")
    public void theUserClicksOnLoginButton() {
        loginPage.loginBtn.click();
    }

    @Then("the user should be able to logged in successfully")
    public void theUserShouldBeAbleToLoggedInSuccessfully() {
    }

    @Given("the user logs in as {string} role for {string} user")
    public void theUserLogsInAsRoleForUser(String role, String user) {
        role = role.toLowerCase().replace(" ","_");
        role = ConfigurationReader.get(role)+"."+user;
        driver.get(ConfigurationReader.get("uat_url"));
        loginPage.usernameTxtbox.sendKeys(role);
        loginPage.passwordTxtbox.sendKeys(System.getenv("affectli_password"));
        loginPage.loginBtn.click();
        Assert.assertTrue(dashboardPage.profileBtn.isDisplayed());
        Log.info("User logged in with \""+role+"\" role.");
    }

    @And("the user logs out from Affectli")
    public void theUserLogsOutFromAffectli() {
        dashboardPage.profileBtn.click();
        dashboardPage.logoutBtn.click();
        waitForVisibility(loginPage.loginTxt, 10);
        Assert.assertTrue(loginPage.loginTxt.isDisplayed());
        Log.info("User logged out successfully.");
        Driver.closeDriver();
    }

    @Given("the user logs in with {string} kumoco user")
    public void theUserLogsInWithKumocoUser(String user) {
        driver.get(ConfigurationReader.get("uat_url"));
        user = user+"User";
        loginPage.usernameTxtbox.sendKeys(ConfigurationReader.get(user));
        loginPage.passwordTxtbox.sendKeys(System.getenv("affectli_password"));
        loginPage.loginBtn.click();
        waitForVisibility(dashboardPage.profileBtn,10);
        Assert.assertTrue(dashboardPage.profileBtn.isDisplayed());
        Log.info("User logged in with \""+user+"\" kumoco role.");
    }


}
