package com.sportyshoe.RestAssuredScripts;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetAllShoes {
	
	@Test()
	public void get_all_shoes() {
		
		RestAssured.given()
		.baseUri("http://localhost:9010")
		.basePath("/get-shoes")
		.contentType(ContentType.JSON)
		.when()
		.get()
		.then().statusCode(200)
		.log()
		.all()
		.body("code", Matchers.equalTo(101));
		
		
	}
}
