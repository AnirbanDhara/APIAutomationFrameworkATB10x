package com.anirbandhara.tests.crud;

import com.anirbandhara.base.BaseTest;
import com.anirbandhara.endpoints.APIConstants;
import com.anirbandhara.modules.PayloadManager;
import com.anirbandhara.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCreateBooking extends BaseTest{

    // Create A Booking, Create a Token
    // Verify that Get booking -
    // Update the Booking
    // Delete the Booking

    @Test(groups = "reg", priority = 1)
    @Owner("Anirban")
    @Description("TC#INT1 - Step 1. Verify that the Booking can be Created")
    public void test_CreateBooking_POST() {

        // preparation part
        requestSpecification.basePath(APIConstants.CreateBooking_BasePath);

        // Making of request part
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString())
                .log().all().post();

        // Validation part(Verification)
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(), "Daniel");
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());
        assertActions.verifyStringKeyNotEmpty(bookingResponse.getBookingid().toString());

    }

}
