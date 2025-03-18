package com.anirbandhara.tests.crud;

import com.anirbandhara.base.BaseTest;
import com.anirbandhara.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestHealthCheck extends BaseTest {

    @Test(groups = "reg", priority = 1)
    @Owner("Anirban")
    @Description("TC#INT2 - Step 3. Verify that URL is Up and Running")
    public void test_HealthCheck_GET() {

        // preparation part
        requestSpecification.basePath(APIConstants.HealthCheck_BasePath);

//        // Making of request part
        response = RestAssured.given(requestSpecification)
                .when()
                .log().all().get();

        // Validation part(Verification)
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
        validatableResponse.contentType("text/plain; charset=utf-8");
    }
}
