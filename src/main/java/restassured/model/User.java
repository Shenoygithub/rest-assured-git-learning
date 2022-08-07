package restassured.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User{
	
	@JsonProperty
	private String emailAddress;
	@JsonProperty
	private String firstName;
	@JsonProperty
	private String lastName;
	@JsonProperty
	private String userId;
	
 
	public User(){}//constructor
	
	public User( String emailAddress, String firstName, String lastName, String userId) {
		this.emailAddress =emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
	}


	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", emailId='" + emailAddress +'\''+
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}