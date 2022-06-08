package ApiTest;

import ApiFolder.ApiInteration;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ApiTest {
    ApiInteration apiInteration = new ApiInteration();
    @Test(priority = 1)
    public void testGetWatherWhiteInformation() {

        RestAssured.baseURI = "https://www.breakingbadapi.com/api/";

        var body =
                RestAssured.given()
                        .when()
                        .get("characters?name=Walter")
                        .then()
                        .statusCode(200)
                        .extract().asString();

        apiInteration.getWatherWhiteInformation(body);
    }

    @Test(priority = 2)
    public void testGetallcharactersinformation() {

        RestAssured.baseURI = "https://www.breakingbadapi.com/api/";

        var body =
                RestAssured.given()
                        .when()
                        .get("/characters")
                        .then()
                        .statusCode(200)
                        .extract().asString();

        apiInteration.getallcharactersinformation(body);
    }
}
