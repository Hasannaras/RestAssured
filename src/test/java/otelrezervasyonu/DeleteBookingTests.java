package otelrezervasyonu;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTests extends BaseTest {

    @Test
    public void deleteBookingTest() {

        //Delete çağrısı yap

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + createToken())
                .when()
                .delete("/https://restful-booker.herokuapp.com/booking/" + createBookingId());

        response.prettyPrint();
        //Assertion/test yaz
        response
                .then()
                .statusCode(201);
    }
}
