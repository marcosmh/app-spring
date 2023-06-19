package com.std.springapp.librerias.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonCreator {

	public static void main(String[] args) {
		System.out.println("Inicializando User as POJO");
		User user = new User();
		user.name = "user";
		user.lastName = "Lastname";
		user.zipCode = "37800";
		System.out.println("User data: " + user);
		try {
			System.out.println("Json DATA");
			System.out.println(new ObjectMapper().writeValueAsString(user));
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}

class User {
	@JsonProperty
	String name;

	@JsonProperty("last_name")
	String lastName;

	@JsonProperty("zip_code")
	String zipCode;

	@Override
	public String toString() {
		return "User{" + "name='" + name + '\'' + ", lastName='" + lastName + '\'' + ", zipCode='" + zipCode + '\''
				+ '}';
	}
}
