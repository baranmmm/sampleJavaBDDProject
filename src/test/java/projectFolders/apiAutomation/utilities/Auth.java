package projectFolders.apiAutomation.utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import projectFolders._projectUtilities.ConfigurationReader;
import projectFolders.uiAutomation.utilities.Utility;
import projectFolders.uiAutomation.utilities.Driver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Auth {

    public static String getAPIKey(String yopmailAddress) throws InterruptedException {
        String apiKey = "";
        String apiKeyTextFile = "src/test/resources/projectResources/apiResources/apiFiles/apiKey.txt";
        File file = new File(apiKeyTextFile);
        if (file.exists()) {
            try {
                apiKey = new String(Files.readAllBytes(Paths.get(apiKeyTextFile)));
                if (!apiKey.isBlank()) {
                    return apiKey;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // If API key not found in file, obtain a new one
        RestAssured.baseURI = ConfigurationReader.get("apiBaseUri");
        String jsonBodyForApiKey = "{\"email\":\""+yopmailAddress+"@yopmail.com\",\"appDescription\":\"This request is sent for training purposes.\",\"opted_into_mailing_list\":false,\"details\":{\"user_type\":\"personal\"}}";
        RestAssured.given().accept(ContentType.JSON).and().contentType(ContentType.JSON).body(jsonBodyForApiKey)
                .when().post(Endpoints.APIKEY_ENDPOINT)
                .then().statusCode(200).body("message", Matchers.equalTo("SUCCESS"));
        //The request above is sending an API Key request to Cat API. It's sent to the email written in the method as parameter. It should be retrieved from yopmail address by using Selenium.
        WebDriver driver = Driver.getDriver();
        driver.get("https://yopmail.com/en/");
        driver.findElement(By.cssSelector("[aria-label=\"Consent\"]")).click();
        driver.findElement(By.cssSelector("[title=\"Login\"]")).sendKeys(yopmailAddress+"@yopmail.com");
        driver.findElement(By.id("refreshbut")).click();
        Utility.switchToFrame("ifmail");
        apiKey = driver.findElement(By.xpath("(//strong)[1]")).getText();
        driver.quit();

        try (FileWriter writer = new FileWriter(apiKeyTextFile)) {
            writer.write(apiKey);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return apiKey;

    }

    public String getBearerToken(String username, String password){
        //If the API requires bearerToken for authentication, update this method to retrieve the bearer token
        String token = "";
        return "Bearer "+token;
    }



}
