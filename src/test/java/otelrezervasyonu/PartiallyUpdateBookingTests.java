package otelrezervasyonu;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PartiallyUpdateBookingTests extends BaseTest {

    @Test
    public void partiallyUpdateBookingTest() {
        // cagriyi yap

        JSONObject body = new JSONObject();
        body.put("firstname", "Okan");

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + createToken())
                .body(body.toString())
                .when()
                .patch("https://restful-booker.herokuapp.com/booking/" + createBookingId());

        response.prettyPrint();

        //Assertion/Testleri yaz
        Assertions.assertEquals("Okan", response.jsonPath().getJsonObject("firstname"));
    }
}