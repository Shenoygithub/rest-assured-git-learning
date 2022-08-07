package com.hertzbit.restassuredlearning.assesment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import resrassured.request.UserAPI;
import restassured.jsonutil.UserUtils;
import restassured.model.User;

import static io.restassured.RestAssured.*;


public class POJO {
	
	//private String createdUserID;
	
	public POJO() {
		RestAssured.baseURI = "http://13.234.202.14:8088/api";
	}
			
	@Test(priority = 1)
	public void testGET() {
		User[] userResponse =
		given()
		  .log()
		  .all()
		  .headers("Content-Type", "application/json").
		when()
		  .get("/users").
		then()
		  .log()
		  .all()
		  .assertThat()
		  .statusCode(200)
     	  .extract()
          .as(User[].class);
//		  System.out.println(userResponse);     	  
	}
	@Test(priority = 2)
	public void testPOST() {
		User userResponse =
			given()
			  .log()
			  .all()
			  .headers("Content-Type", "application/json")
			  .body(UserAPI.getPOSTRequestBody()).	  
			when()
			  .post("/users").
			then()
			  .log()
			  .all()
			  .assertThat()
			  .statusCode(201)
			  .extract()
			  .as(User.class);
		System.setProperty("userId", userResponse.getUserId());

			//System.out.println("userId has been created" +("userID"));
			//userID = UserUtils.getValueFromResponse(responseBodyPOSTString, "userId");
		//createdUserID = UserUtils.getValueFromResponse(userResponse, "userId");

	}
	@Test(priority = 3)
	public void testGETUser() {
        String userId = String.valueOf(System.getProperty("userId"));

		User userResponse =
			given()
			  .log()
			  .all()
			  .headers("Content-Type", "application/json").
			  //.body(UserAPI.getPUTRequestBody())
			  //.pathParam("userId",createdUserID).
			when()
			  .get("/users/"+userId).
			then()
			  .log()
			  .all()
			  .assertThat()
			  .statusCode(200)
			  .extract()
			  .as(User.class);
	
}
	@Test(priority = 4)
	public void testPUTAPI() {
        String userId = String.valueOf(System.getProperty("userId"));

		User userResponse =
			given()
			  .log()
			  .all()
			  .headers("Content-Type", "application/json")
			  .body(UserAPI.getPOSTRequestBody()).
			  //.pathParam("userId",createdUserID).
			when()
			  .put("/users/"+userId).
			then()
			  .log()
			  .all()
			  .assertThat()
			  .statusCode(200)
			  .extract()
			  .as(User.class);
	
}	
	@Test(priority = 5)
	public void testDELETEAPI() {
        String userId = String.valueOf(System.getProperty("userId"));

		//User userResponse =
			given()
			  .log()
			  .all()
			  .headers("Content-Type", "application/json").
			 // .pathParam("userId",createdUserID).
			when()
			  .delete("/users/"+userId).
			then()
			  .log()
			  .all()
			  .assertThat()
			  .statusCode(204);
			 // .extract()
			 // .as(User.class);
	}
	@Test(priority = 6)
	public void testGETAPI() {
        String userId = String.valueOf(System.getProperty("userId"));

		//User userResponse =
			given()
			  .log()
			  .all()
			  .headers("Content-Type", "application/json").
			 // .pathParam("userId",createdUserID).
			when()
			  .get("/users/"+userId).
			then()
			  .log()
			  .all()
			  .assertThat()
			  .statusCode(404);
			 // .extract()
			 // .as(User.class);
	}
	
}