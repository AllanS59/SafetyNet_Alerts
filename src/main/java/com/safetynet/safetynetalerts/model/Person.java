package com.safetynet.safetynetalerts.model;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.Data;

@JsonFilter("DynamicFilter")
@Data
public class Person {
	
	private String firstName;
	
	private String lastName;
	
	private String  address;
	
	private String city;
	
	private String zip;
	
	private String phone;
	
	private String email;
	
	
	public void updatePerson (Person updatedPerson) {
		this.firstName = updatedPerson.getFirstName();
		this.lastName = updatedPerson.getLastName();
		this.address = updatedPerson.getAddress();
		this.city = updatedPerson.getCity();
		this.zip = updatedPerson.getZip();
		this.phone = updatedPerson.getPhone();
		this.email = updatedPerson.getEmail();	
	}
	
}
