package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Auth;
import models.Booking;
import models.BookingDates;
import models.BookingResponse;

import static io.restassured.RestAssured.given;

public class ReservationService extends BaseTest {


    public String createToken(){
        Auth auth = new Auth("admin","password123");

        Response response = given(spec)
                .contentType(ContentType.JSON)
                .body(auth)
                .when()
                .post("/auth");

        response.then().statusCode(200);

        return response.jsonPath().getJsonObject("token");
    }
    public BookingResponse createBooking(){
        BookingDates bookingdates = new BookingDates("2018-01-04","2019-05-03");
        Booking booking = new Booking("Sefa","demiratli",110,false,bookingdates,"OLDUUUUUUU!!!!");

        Response response = given(spec)
                .contentType(ContentType.JSON)
                .body(booking)
                .when()
                .post("/booking");

        response.then().statusCode(200);

        return response.as(BookingResponse.class);
    }

    public void deleteBooking(String authKey,int idbooking){
        Response response = given(spec)
                .contentType(ContentType.JSON)
                .header("Cookie","token="+authKey)
                .delete("/booking/"+idbooking);

        response.then().statusCode(201);
    }

}
