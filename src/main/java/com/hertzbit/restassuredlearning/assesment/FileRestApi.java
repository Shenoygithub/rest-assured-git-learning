package com.hertzbit.restassuredlearning.assesment;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.File;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class FileRestApi {

	@Test(priority =1)
	public void testFileUploadGoodCase(ITestContext fileContext) {
		RestAssured.baseURI = "http://13.234.202.14:8088";

		String responseBody =
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
		    .response()
		    .asString();
		JsonPath jsonPath = new JsonPath(responseBody);
		String fileID = jsonPath.getString("fileId");
		fileContext.setAttribute("fileId", fileID);
	}
	@Test(priority = 2)
	public void testFileDownloadAPI(ITestContext fileContext) {
		
		RestAssured.baseURI = "http://13.234.202.14:8088";
        String fileId = String.valueOf(fileContext.getAttribute("fileId"));
        
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
        
        //length of File
        File uploadedFile = new File("C:\\Users\\QQA0394\\Desktop\\soapvsrest.png");
        long sizeofUploadedFile = uploadedFile.length();
        System.out.println("uploadFile length:"+uploadedFile.length());
        long sizeofDownloadedFile = downloadedFile.length;
        System.out.println("downloadFile length:"+downloadedFile.length);
        
        assertEquals(sizeofUploadedFile, sizeofDownloadedFile );
        System.out.println("Both files length are equal!!");

        //name of File
        String nameofUploadedFile = uploadedFile.getName();
        System.out.println("upload File Name:"+uploadedFile.getName());
        boolean nameofDownloadedFile = downloadedFile.equals(nameofUploadedFile);
        System.out.println("File names are same!!");
	
	}

		
	}


