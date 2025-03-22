package com.anirbandhara.tests.integration;

import com.anirbandhara.base.BaseTest;
import com.anirbandhara.endpoints.APIConstants;
import com.anirbandhara.pojos.GetAllBookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.List;

public class TestE2E_Flow_03 extends BaseTest {
    //Get a Booking from Get All -> Try to Delete that booking


    @Test(groups = "qa", priority = 1)
    @Owner("Anirban")
    @Description("TCINT1 - Step 1.Verify that Booking can created")
    public void test_AllBookingsByid_GET(ITestContext iTestContext) {
        String basePathUri = APIConstants.BaseURL;
        requestSpecification.baseUri(basePathUri).basePath(APIConstants.CreateBooking_BasePath);

        response = RestAssured.given(requestSpecification).when().log().all().get();

        List<GetAllBookingResponse> getallresponse = payloadManager.getAllBookingByIdResponse(response.asString());

        iTestContext.setAttribute("bookingid", getallresponse.get(2).getBookings());

    }

    @Test(groups = "qa", priority = 2)
    @Owner("Anirban")
    @Description("TCINT2 - Step 2. Verify that Booking can deleted")
    public void testDeleteBooking(ITestContext iTestContext) {
        Integer booking_id = (Integer) (iTestContext.getAttribute("bookingid"));

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
