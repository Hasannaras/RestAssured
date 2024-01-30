package otelrezervasyonu;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CreateBookingTests extends BaseTest {

    @Test
    public void createBookingTest() {


        //Çağrıyı   gerçekleştir

        Response response = createBooking();

        Assertions.assertEquals("Hasan", response.jsonPath().getJsonObject("booking.firstname"));
        Assertions.assertEquals("Aras", response.jsonPath().getJsonObject("booking.lastname"));
        Assertions.assertEquals(200, (Integer) response.jsonPath().getJsonObject("booking.totalprice"));
        Assertions.assertEquals(true, response.jsonPath().getJsonObject("booking.depositpaid"));
    }
}
