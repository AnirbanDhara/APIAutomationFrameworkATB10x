package com.anirbandhara.tests.crud;

import com.anirbandhara.base.BaseTest;
import com.anirbandhara.endpoints.APIConstants;
import com.anirbandhara.pojos.BookingResponse;
import com.anirbandhara.pojos.TokenResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateToken extends BaseTest {

    @Test(groups = "reg", priority = 1)
    @Owner("Anirban")
    @Description("TC#INT2 - Step 2. Verify that the Token can be generated")
    public void test_CreateToken_POST() {

        // preparation part
        requestSpecification.basePath(APIConstants.CreateToken_BasePath);

        // Making of request part
        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.setAuthPayload())
                .log().all().post();

        // Validation part(Verification)
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        String token = payloadManager.getTokenFromJSON(response.asString());
        assertActions.verifyStringKeyNotEmpty(token);

    }
}
