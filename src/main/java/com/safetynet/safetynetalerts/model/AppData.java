package com.safetynet.safetynetalerts.model;

import lombok.Data;

@Data
public class AppData {

	private Person[] persons;
	
	private Firestation[] firestations;
	
	private MedicalRecord[] medicalrecords;
	
}
