package com.sportyshoe.RestAssuredScripts;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PutUpdateShoe {
	

	@Test()
	public void update_a_product()
	{
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


}
