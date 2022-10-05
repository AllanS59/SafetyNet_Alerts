package com.safetynet.safetynetalerts.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MedicalRecord {
	
	private String firstName;
	
	private String lastName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date birthdate;
	
	private String[] medications;
	
	private String[] allergies;
	
	
	
	public void updateMedicalRecord (MedicalRecord updatedMedicalRecord) {
		this.firstName = updatedMedicalRecord.getFirstName();
		this.lastName = updatedMedicalRecord.getLastName();
		this.birthdate = updatedMedicalRecord.getBirthdate();
		this.medications = updatedMedicalRecord.getMedications();
		this.allergies = updatedMedicalRecord.getAllergies();
	}
	
}
