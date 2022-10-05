package com.safetynet.safetynetalerts.dto;

import lombok.Data;

@Data
public class PersonNameAddressAgeMailMedicalsDTO {

	private String firstName;

	private String lastName;

	private String address;

	private int age;
	
	private String email;

	private String[] medications;

	private String[] allergies;
}
