package otelrezervasyonu;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetAllBookingsIdTest extends BaseTest {

    @Test
    public void getBookingById() {

        //Çağrıyı oluşturulur
        //Response kontrelleri

        Response response = given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking/" + createBookingId());

        response
                .then()
                .log().all()
                .statusCode(200);
        response.prettyPrint();

        String firstname = response.jsonPath().getJsonObject("firstname");
        String lastname = response.jsonPath().getJsonObject("lastname");
        int totalprice = response.jsonPath().getJsonObject("totalprice");

        Assertions.assertEquals("Hasan", firstname);
        Assertions.assertEquals("Aras", lastname);
        Assertions.assertEquals(200, totalprice);
    }
}
