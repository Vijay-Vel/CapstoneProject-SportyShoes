package com.sportyshoe.RestAssuredScripts;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteShoe {

	@Test()
	public void delete_product()
	{
		String Shoe_id = "100";
		RestAssured.given()
		.baseUri("http://localhost:9010")
		.basePath("/delete-shoe")
		.queryParam("id", Shoe_id)
		.when().delete()
		.then().log().all()
		.body("code", Matchers.equalTo(101))
		.body("message", Matchers.equalTo("Shoe with ID " + Shoe_id + " Deleted Successfully."));
		
	}
}
