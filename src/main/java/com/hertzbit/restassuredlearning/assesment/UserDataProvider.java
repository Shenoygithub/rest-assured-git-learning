package com.hertzbit.restassuredlearning.assesment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.testng.annotations.DataProvider;

public class UserDataProvider {
	

	public static String fileName = "C:\\Users\\QQA0394\\Downloads\\UserAPITest.xlsx";
	public static String sheetName = "Sheet1";
	public static String testCaseLiteral = "Testcase";
	public static String testCaseNameUserOne = "userOne";
	public static String testCaseNameUserTwo = "userTwo";
	public static String sheetName2 = "Sheet2";
	
	
	@DataProvider (name = "getUser")
	public Object[][] getPostRequestData() throws Exception{
		
		Map<String, Integer> rowColumnMap = ExcelReader.
				searchForTestCase(fileName, sheetName, testCaseLiteral);
		
		ArrayList<Object> inputDataUserOne = ExcelReader.
				getDataForTestCase(rowColumnMap, fileName, sheetName, testCaseNameUserOne);
		System.out.println(inputDataUserOne);
		ArrayList<Object> inputDataUserTwo = ExcelReader.
				getDataForTestCase(rowColumnMap, fileName, sheetName, testCaseNameUserTwo);
		System.out.print(inputDataUserTwo);
		Object[] userOne = inputDataUserOne.toArray();
		Object[] userTwo = inputDataUserTwo.toArray();
		
		return new Object[][] {userOne, userTwo};

		
		//return new Object[][] {Arrays.copyOfRange(userOne,0,4), Arrays.copyOfRange(userTwo,0,4) };
	}
	
	@DataProvider (name = "putUser")
	public Object[][] getPutRequestData() throws Exception{
		
		Map<String, Integer> rowColumnMap = ExcelReader.
				searchForTestCase(fileName, sheetName2, testCaseLiteral);
		
		ArrayList<Object> inputDataUserOne = ExcelReader.
				getDataForTestCase(rowColumnMap, fileName, sheetName2, testCaseNameUserOne);
		System.out.println(inputDataUserOne);
		ArrayList<Object> inputDataUserTwo = ExcelReader.
				getDataForTestCase(rowColumnMap, fileName, sheetName2, testCaseNameUserTwo);
		System.out.print(inputDataUserTwo);
		Object[] userOne = inputDataUserOne.toArray();
		Object[] userTwo = inputDataUserTwo.toArray();
		
		return new Object[][] {userOne, userTwo};
		//return new Object[][] {Arrays.copyOfRange(userOne,0,1), Arrays.copyOfRange(userTwo,0,1) };


}
}