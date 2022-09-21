package com.safetynet.safetynetalerts.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.Data;

@JsonFilter("DynamicFilterFullData")
@Data
public class PersonFullData {

	
	private String firstName;
	
	private String lastName;
	
	private String  address;
	
	private String city;
	
	private String zip;
	
	private String phone;
	
	private String email;
	
	
	private int station;
	
	
	private Date birthdate;
	
	private String[] medications;
	
	private String[] allergies;
	
}
