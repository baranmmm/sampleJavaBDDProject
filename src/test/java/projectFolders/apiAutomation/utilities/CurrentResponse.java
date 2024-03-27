package projectFolders.apiAutomation.utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CurrentResponse {
    public static Response response;

    public static Response getResponse() {
        return response;
    }

}
