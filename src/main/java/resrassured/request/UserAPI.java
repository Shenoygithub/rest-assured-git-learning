package resrassured.request;

public class UserAPI {

	public static String getPOSTRequestBody() {
		
		return "{\n"

   + "        \"emailAddress\": \"Suhail1234@gmail.com\",\n"

   + "        \"firstName\": \"Amit\",\n"

   + "        \"lastName\": \"Suneja\"\n"

  + "}";
	}
	public static String getPUTRequestBody() {
		
		return "{\n"

  + "        \"emailAddress\": \"Suhail1234@gmail.com\",\n"

   + "        \"firstName\": \"Suhani\",\n"

   + "        \"lastName\": \"Suneja\"\n"

  + "}";
	}
	//for data provider
	public static String getPOSTRequestBody (String emailAddress, String firstName, String lastName, String userId) {//passing argumnets instead of get putrequestbody
		
		return "{\n"
				+ "        \"emailAddress\": \""+ emailAddress +  "\",\n"
				+ "        \"firstName\": \"" + firstName + "\",\n"
				+ "        \"lastName\":  \""+ lastName + "\",\n"
				+ "        \"userId\": \"" + userId +"\"\n"
				+ "    }";
}
	public static String getPUTRequestBody(String emailAddress, String firstName, String lastName, String userId) {
		return "{\n"
				+ "        \"emailAddress\": \""+ emailAddress +  "\",\n"
				+ "        \"firstName\": \"" + firstName + "\",\n"
				+ "        \"lastName\":  \""+ lastName + "\",\n"
				+ "        \"userId\": \"" + userId +"\"\n"
				+ "    }";
	}
}

