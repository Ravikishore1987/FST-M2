package Examples;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import javax.json.Json;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PostService {
    @Test
    public void postRequest() {
        final String baseURI = "https://petstore.swagger.io/v2/pet";
//        String reqBody = "{\"id\": 77232, \"name\": \"Riley\", \"status\": \"alive\"}";
        String reqBody = "{" +
                "\"id\": 77232, " +
                "\"name\": \"Riley\", " +
                "\"status\": \"alive\"" +
                "}";

        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .body(reqBody).when().post(baseURI); // Send POST request

        // Print response of POST request
        String body = response.getBody().asPrettyString();
        System.out.println(body);
        response.then().statusCode(200);
    }
}
