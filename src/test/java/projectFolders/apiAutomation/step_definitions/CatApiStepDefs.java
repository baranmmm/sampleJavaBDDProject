package projectFolders.apiAutomation.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.junit.Assert;
import projectFolders._projectUtilities.ConfigurationReader;
import projectFolders.apiAutomation.utilities.Auth;
import projectFolders.apiAutomation.utilities.CurrentResponse;

public class CatApiStepDefs extends CurrentResponse {
    @Given("the user sends a request to get all cat breeds to CAT api")
    public void theUserSendsARequestToGetAllCatBreedsToCATApi() throws InterruptedException {
        String apiKey = Auth.getAPIKey("newUser");
        response = RestAssured.given().header("x-api-key",apiKey)
                .when().get("https://api.thecatapi.com/v1/breeds");
    }

    @Then("verifies that the status code is {int}")
    public void verifiesThatTheStatusCodeIs(int statusCode) {
        Assert.assertEquals(response.statusCode(),statusCode);
    }

    @Then("the response contains {string} breed")
    public void theResponseContainsBreed(String breedType) {

    }
}
