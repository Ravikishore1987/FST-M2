package Examples;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class addPetImage {
    @Test
    public void simpleTest(){
        String ROOT_URI  = "https://petstore.swagger.io/v2/pet/{petId}/uploadImage";
        File petImage = new File("src/test/resources/Final_Vaccination_Ravikishore.jpg");
        Response response = given().multiPart(petImage) // Add image to upload
                .pathParam("petId", "77232") // Set petId parameter
                .when().post(ROOT_URI); // Send POST request

        // Print response
        System.out.println(response.asPrettyString());

        // Assertion
        response.then().body("code", equalTo(200));

    }
}
