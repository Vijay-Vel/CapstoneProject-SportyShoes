package com.sportyshoe.steps;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SportyShoeStepDefinition {
	
	@Test
	@Given("User sends a get request to get list of users and validates status")
	public void user_sends_a_get_request_to_get_list_of_users_and_validates_status() {
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

	@Test
	@Given("User send a Post request to create a new shoe and validates status")
	public void user_send_a_post_request_to_create_a_new_shoe_and_validates_status() {
		
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

	@Test
	@Given("User sends a get request to get list of shoes and validates status")
	public void user_sends_a_get_request_to_get_list_of_shoes_and_validates_status() {
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

	@Test
	@Given("User sends a Put request to update a shoe and validates status")
	public void user_sends_a_put_request_to_update_a_shoe_and_validates_status() {
		String Shoe_Name = "Adidas";
		RestAssured.given()
		.baseUri("http://localhost:9010")
		.basePath("/update-shoe")
		.queryParam("id","100")
		.queryParam("image", "www.imge123.com")
		.queryParam("name", Shoe_Name)
		.queryParam("category", "Running")
		.queryParam("sizes","5,6,7")
		.queryParam("price", "2500")
		.when()
		.put()
		.then()
		.log().all()
		.body("code", Matchers.equalTo(101))
		.body("message", Matchers.equalTo(Shoe_Name +" Updated Successfully."));
	}

	@Test
	@Given("User sends a delete request to delete shoe and validates status")
	public void user_sends_a_delete_request_to_delete_shoe_and_validates_status() {
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
