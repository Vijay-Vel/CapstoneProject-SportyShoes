package com.sportyshoe.RestAssuredScripts;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetAllUsers {

	@Test()
	public void get_all_users() {
		
		RestAssured.given()
		.baseUri("http://localhost:9010")
		.basePath("/get-users")
		.contentType(ContentType.JSON)
		.when()
		.get()
		.then()
		.statusCode(200)
		.log()
		.all()
		.body("code", Matchers.equalTo(101))
		.body("message", Matchers.equalTo("3 Users Fetched Successfully."));
	}

}
