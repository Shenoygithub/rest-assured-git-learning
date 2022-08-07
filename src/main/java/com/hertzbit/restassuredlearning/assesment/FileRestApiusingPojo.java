package com.hertzbit.restassuredlearning.assesment;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBodyData;
import restassured.model.FileAPI;
import restassured.model.User;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;

public class FileRestApiusingPojo {

		@Test(priority =1 )
		public void testFileUploadGoodCase(ITestContext fileContext) {
			
			RestAssured.baseURI = "http://13.234.202.14:8088";
			
		FileAPI responseBody = 
					given() 
			    .log()
			    .all()
			    //.headers("Content-Type","application-multipart")
			    .contentType(ContentType.MULTIPART)
			    .multiPart("fileName", new File("C:\\Users\\QQA0394\\Desktop\\soapvsrest.png")).
		    when()
			    .post("/api/files/upload/database").
		    then()
		    	.log()
		    	.all()
			    .assertThat()
			    .statusCode(200)
			    .extract()
		        .as(FileAPI.class);
			    
			 //.toString();
			
			//JsonPath jsonPath = new  JsonPath(responseBody);
			//String fileID = jsonPath.getString("fileId");
			//System.out.println("fileId"+fileID);
			System.setProperty("fileId", responseBody.getFileId());
			//fileContext.setAttribute("fileId", fileID);
		}
	    @Test(priority = 2)
		public void testFileDownloadAPI(ITestContext fileContext) {
	    	
			RestAssured.baseURI = "http://13.234.202.14:8088";
			
	        String fileId = String.valueOf(System.getProperty("fileId"));
	        
	        byte[] downloadedFile =
	        		
	        given()
		     .log()
		     .all().
		     //.pathParam("fileId",fileId).
	        when()
		     .get("/api/files/download/database/"+fileId).
	        then()
	    	 .log()
	    	 .all()
		     .assertThat()
		     .statusCode(200)
			 .extract()
			 .asByteArray();
	        
	        File uploadedFile = new File("C:\\Users\\QQA0394\\Desktop\\soapvsrest.png");
	        long sizeofUploadedFile = uploadedFile.length();
	        System.out.println("Upload length=" +uploadedFile.length());
	        long sizeofDownloadedFile = downloadedFile.length;
	        System.out.println("Download length=" +downloadedFile.length);

	        assertEquals(sizeofUploadedFile, sizeofDownloadedFile );
	
		}

			
		}



