package otelrezervasyonu;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetAllBookingsTests {
    // Çağrı oluşturma
    // Response kontrolleri
    // Curl -i https://restful-booker.herokuapp.com/booking

    @Test
    public void getAllBookingTest() {

        given()
                .when()
                .get("https://restful-booker.herokuapp.com/booking")
                .then()
                .log().all()
                .statusCode(200);
    }
}
