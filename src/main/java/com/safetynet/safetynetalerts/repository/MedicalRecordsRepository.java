package com.safetynet.safetynetalerts.repository;

import org.springframework.stereotype.Repository;

import com.safetynet.safetynetalerts.model.MedicalRecord;

@Repository
public interface MedicalRecordsRepository {
	
	MedicalRecord[] getMedicalRecordsFromData();
	
	MedicalRecord getMedicalRecordByFirstNameAndLastName(MedicalRecord[] medicalRecords, String firstName, String lastName);

	MedicalRecord[] getMedicalRecordsByMinAge(MedicalRecord[] medicalRecords, int MinAge);
	
	MedicalRecord[] getMedicalRecordsByMaxAge(MedicalRecord[] medicalRecords, int MaxAge);
	
	void addMedicalRecordInData (MedicalRecord medicalRecord);
	
	void updateMedicalRecordInData (MedicalRecord medicalRecord);
	
	void deleteMedicalRecordInData (String firstName, String lastName);
	
	
}
