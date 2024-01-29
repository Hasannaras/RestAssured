package otelrezervasyonu;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTests extends BaseTest {

    @Test
    public void deleteBookingTest() {

        //Delete çağrısı yap

        // curl -X DELETE \
        // /https://restful-booker.herokuapp.com/booking/1 \
        //-H 'Content-Type: application/json' \
        //-H 'Cookie: token=abc123'

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
