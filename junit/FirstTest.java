package Examples;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FirstTest {
    @Test
    public void simpleTest(){
        final String baseURI = "https://petstore.swagger.io/v2/pet";
        // Make a request to the server by specifying the method Type
        // Store the response received from the server for later use.
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().get(baseURI + "/findByStatus?status=sold"); // Run GET request

        // we have received response from the server
        String responseBody = response.getBody().asPrettyString();
        System.out.println("Response Body is =>  " + responseBody);

        // Assertions
        response.then().statusCode(200);
        response.then().body("[0].status", equalTo("sold"));
        // Assertion for status of pet
        response.then().extract().path("[0].status").equals("sold");

    }
}
