package com.safetynet.safetynetalerts.model;

import java.util.Date;

import lombok.Data;

@Data
public class MedicalRecord {
	
	private String firstName;
	
	private String lastName;
	
	private Date birthdate;
	
	private String[] medications;
	
	private String[] allergies;
	
}
