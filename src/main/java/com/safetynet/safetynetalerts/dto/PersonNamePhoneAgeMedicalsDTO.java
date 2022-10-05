package com.safetynet.safetynetalerts.dto;

import lombok.Data;

@Data
public class PersonNamePhoneAgeMedicalsDTO {

	private String firstName;
	
	private String lastName;
	
	private String phone;
	
	private int age;
	
	private String[] medications;
	
	private String[] allergies;
	
}
