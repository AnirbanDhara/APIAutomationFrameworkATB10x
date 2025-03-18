package com.anirbandhara.base;

import com.anirbandhara.asserts.AssertActions;
import com.anirbandhara.asserts.AssertActions;
import com.anirbandhara.endpoints.APIConstants;

import com.anirbandhara.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class BaseTest {
    // Common To All Tests
    // BaseURL, Content Type - json

    public RequestSpecification requestSpecification;
    //public RequestSpecBuilder requestSpecBuilder;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;

    @BeforeTest
    public void setUp() {
        // Base URL, Content Type - json
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
//
//        requestSpecification = RestAssured.given();
//        requestSpecification.baseUri(APIConstants.BaseURL);
//        requestSpecification.contentType(ContentType.JSON).log().all();


          requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.BaseURL)
                .addHeader("Content-Type", "application/json")
                .build().log().all();

//        RequestSpecBuilder builder = new RequestSpecBuilder();
//        builder.setBaseUri(APIConstants.BaseURL);
//        builder.addHeader("Content-Type","application/json");
//        builder.setSessionId("S31508252");
//        requestSpec = builder.build();
//        RestAssured.with().spec(requestSpec);



    }

//    public String getToken() {
//        requestSpecification  = RestAssured
//                .given()
//                .baseUri(APIConstants.BaseURL).basePath(APIConstants.CreateToken_BasePath);
//
//        // Setting the payload
//        String payload = payloadManager.setAuthPayload();
//
//        // Get the Token
//        response = requestSpecification.contentType(ContentType.JSON).body(payload).when().post();
//        // String Extraction
//
//        return payloadManager.getTokenFromJSON(response.asString());


    }

