package restassured.jsonutil;

import io.restassured.path.json.JsonPath;
import restassured.model.User;

public class UserUtils {

		public static String getValueFromResponse(String userResponse, String value)
		{
			//return userResponse;
			JsonPath jsonPath = new JsonPath(userResponse);
			return jsonPath.getString(value);
		}

		public static String getValueFromResponse(User userResponse, String value) {
			// TODO Auto-generated method stub
			return null;
		}

		

		}

