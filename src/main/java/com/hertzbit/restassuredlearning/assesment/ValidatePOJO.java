package com.hertzbit.restassuredlearning.assesment;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import resrassured.request.UserAPI;
import restassured.model.User;

public class ValidatePOJO {

 public static User userResponse1;
	@Test
	public void getAllUsersTest() {
        RestAssured.baseURI = "http://13.234.202.14:8088/api/";
		
        User[] userResponse =		
		given()
		    .log()
		    .all()
		    .headers("Content-Type","application/json").
		when()
		    .get("users").
	    then()
	        .log()
	        .all()
	        .assertThat()
            .statusCode(200)
            .extract()
            .body()
            .as(User[].class);
		    System.out.println(userResponse);     
		   // System.out.println(userResponse.firstName.equalsIgnoreCase("Baku"));
	}
	
	@Test(dataProvider = "getUser", dataProviderClass = UserDataProvider.class)

	public void postUserTest(String emailAddress, String firstName, String lastName, String userId) {
		
        RestAssured.baseURI = "http://13.234.202.14:8088/api/";
       // String myUser="{\"emailAddress\":"+emailAddress+",\"firstName\":"+firstName+",\"lastName\":"+lastName+",\"userId\":"+userId+"}";
        User userResponse =		
        given()
		    .log()
		    .all()
		    .headers("Content-Type", "application/json")
		    .body(UserAPI.getPOSTRequestBody(emailAddress, firstName, lastName, userId)).
         when()
            .post("users").
		 then()
		    .log()
		    .all()
            .assertThat()
            .statusCode(201)
            .extract()
		    .as(User.class);
		    System.out.println(userResponse);
			System.setProperty("userId", userResponse.getUserId());

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
	    System.out.println(userResponse);
		System.setProperty("userId", userResponse.getUserId());
		userResponse1 = userResponse;

}
	@Test(priority =4, dataProvider = "putUser", dataProviderClass = UserDataProvider.class)

	public void putUserTest(String firstName) {
        String userId = String.valueOf(System.getProperty("userId"));
        String email =userResponse1.getEmailAddress();
        String lastName =userResponse1.getLastName();
        
        RestAssured.baseURI = "http://13.234.202.14:8088/api/";
        User userResponse =		
        given()
		    .log()
		    .all()
		    .headers("Content-Type", "application/json")
		    .body(UserAPI.getPUTRequestBody(email, firstName, lastName,  userId)).
         when()
            .put("users/"+userId).
		 then()
		    .log()
		    .all()
            .assertThat()
            .statusCode(200)
            .extract()
		    .as(User.class);
		    System.out.println(userResponse);
			System.setProperty("userId", userResponse.getUserId());
}
	@Test(priority =5)
   public void deleteUserTest() {
    String userId = String.valueOf(System.getProperty("userId"));
    
    RestAssured.baseURI = "http://13.234.202.14:8088/api/";
    //User userResponse =		
    given()
	    .log()
	    .all()
	    .headers("Content-Type", "application/json").
	   // .body(UserAPI.getPUTRequestBody(email, firstName, lastName,  userId)).
     when()
        .delete("users/"+userId).
	 then()
	    .log()
	    .all()
        .assertThat()
        .statusCode(204);
        //.extract()
	    //.as(User.class);
	   
	}
}