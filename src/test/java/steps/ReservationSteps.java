package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.BookingResponse;
import org.junit.jupiter.api.Assertions;
import services.ReservationService;

public class ReservationSteps {
    ReservationService reservationService;
    String autKey;
    BookingResponse bookingResponse;
    @Given("User create a new reservation")
    public void userCreateANewReservation() {
        reservationService = new ReservationService();
    }

    @Given("User give information for hotel reservation")
    public void userGiveInformationForHotelReservation() {
        autKey = reservationService.createToken();
    }

    @When("User create hotel reservation")
    public void userCreateHotelReservation() {
        bookingResponse = reservationService.createBooking();
    }

    @Then("Reservation create succesfull")
    public void reservationCreateSuccesfull() {
        Assertions.assertEquals("Sefa",bookingResponse.getBooking().getFirstname());
    }

    @Then("User would delete that crated reservation")
    public void userWouldDeleteThatCratedReservation() {
        reservationService.deleteBooking(autKey, bookingResponse.getBookingid());
    }
}
