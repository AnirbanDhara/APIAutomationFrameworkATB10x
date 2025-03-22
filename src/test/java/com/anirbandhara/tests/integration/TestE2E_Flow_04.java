package com.anirbandhara.tests.integration;

import com.anirbandhara.base.BaseTest;
import com.anirbandhara.endpoints.APIConstants;
import com.anirbandhara.pojos.Booking;
import com.anirbandhara.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestE2E_Flow_04 extends BaseTest {
    // Create Booking -> Update it -> Try to Delete

    @Test(groups = "qa", priority = 1)
    @Owner("Anirban")
    @Description("TCINT1 - Step 1.Verify that Booking can created")
    public void testCreateBooking(ITestContext iTestContext) {

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

        iTestContext.setAttribute("Bookingid",bookingResponse.getBookingid());

    }

    @Test(groups = "qa", priority = 2)
    @Owner("Anirban")
    @Description("TCINT2 - Step 2.Verify that Booking can updated")
    public void testUpdateBooking(ITestContext iTestContext)
    {
        Integer booking_id = (Integer) (iTestContext.getAttribute("Bookingid"));

        String basePathUPDATE = APIConstants.CreateBooking_BasePath + "/" + booking_id;
        String token = getToken();
        System.out.println(basePathUPDATE);

        requestSpecification.basePath(basePathUPDATE);
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.fullUpdatePayloadAsString())
                .cookie("token", token).put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        Booking updateResponse = payloadManager.getResponseFromJSON(response.asString());
        assertThat(updateResponse.getFirstname()).isNotNull().isNotBlank();
        assertThat(updateResponse.getFirstname()).isEqualTo("James");


    }

    @Test(groups = "qa", priority = 3)
    @Owner("Anirban")
    @Description("TCINT3 - Step 3. Verify that Booking can deleted")
    public void testDeleteBooking(ITestContext iTestContext)
    {
        Integer booking_id = (Integer) (iTestContext.getAttribute("Bookingid"));

        String basePathDELETE = APIConstants.CreateBooking_BasePath + "/" + booking_id;
        String token = getToken();

        requestSpecification.basePath(basePathDELETE);
        response = RestAssured.given(requestSpecification)
                .when().cookie("token", token).delete();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
        validatableResponse.statusLine("HTTP/1.1 201 Created");
    }
}
