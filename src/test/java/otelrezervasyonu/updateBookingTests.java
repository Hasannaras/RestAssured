package otelrezervasyonu;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class updateBookingTests extends BaseTest {

    @Test
    public void updateBookingTest() {


        //Çağrı Yap

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + createToken())
                .body(bookingObject("Emre", "Çalışkan", 500, false))
                .put("https://restful-booker.herokuapp.com/booking/" + createBookingId());

        response.prettyPrint();

        //Assertion/Test yaz
        String firstName = response.jsonPath().getJsonObject("firstname");
        String lastname = response.jsonPath().getJsonObject("lastname");
        int totalPrice = response.jsonPath().getJsonObject("totalprice");
        boolean depositPaid = response.jsonPath().getJsonObject("depositpaid");


        Assertions.assertEquals("Emre", firstName);
        Assertions.assertEquals("Çalışkan", lastname);
        Assertions.assertEquals(500, totalPrice);
        Assertions.assertEquals(false, depositPaid);
    }
}
