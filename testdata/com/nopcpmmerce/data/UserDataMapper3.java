package com.nopcpmmerce.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserDataMapper3 {
	public static UserDataMapper3 getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/resources/UserData3.json"),
					UserDataMapper3.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			
			return null;
		}
	}
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("emailAddress")
	private String emailAddress;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("date")
	private String date;
	
	@JsonProperty("month")
	private String month;
	
	@JsonProperty("year")
	private String year;


	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public String getDate() {
		return date;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

}
