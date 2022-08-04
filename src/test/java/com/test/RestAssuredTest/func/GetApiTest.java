package com.test.RestAssuredTest.func;

import com.test.RestAssuredTest.TestApp;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestApp.class)
@Slf4j
public class GetApiTest {
    String URI_GET_EMPLOYEES = "http://localhost:8080/employees";

    @Test
    public void test1(){

        log.info("Test started...");
        Response response = RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .get(URI_GET_EMPLOYEES);
        Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode());
        log.info("Response received : {}",response.body().print());
        log.info("Test finished...");

    }
}
