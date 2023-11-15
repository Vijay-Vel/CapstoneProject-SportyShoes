package com.sportyshoe.RestAssuredScripts;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostNewShoe {
	
	@Test
	public void AddNewShoe() {
		
		String Shoe_Name = "Adidas";
		RestAssured
		
		.given()
		.baseUri("http://localhost:9010")
		.basePath("/add-shoe")
		.queryParam("id", "106")
		.queryParam("image", "img106.src")
		.queryParam("name", Shoe_Name)
		.queryParam("category", "Fashion")
		.queryParam("sizes", "11,12")
		.queryParam("price", "8000")
		.contentType(ContentType.JSON)
		.when()
		.post()
		.then().statusCode(200)
		.log()
		.all()
		.body("code", Matchers.equalTo(101))
		.body("message", Matchers.equalTo(Shoe_Name +" Added Successfully."));

		
	}

}
