package com.safetynet.safetynetalerts.repository;

import org.springframework.stereotype.Repository;

import com.safetynet.safetynetalerts.model.AppData;
import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;

@Repository
public interface AppDataRepository {
	
	AppData readDatafromJson();
	
	void writeDataInJson(AppData appData);
	
	void addPersonInJson(Person person);
	
	void deletePersonInJson(String firstName, String lastName);
	
	void updatePersonInJson(Person person);
	
	
	void addFirestationInJson(Firestation firestation);
	
	void deleteFirestationInJson(String address);
	
	void updateFirestationInJson(Firestation firestation);
	
	
	void addMedicalRecordInJson(MedicalRecord medicalrecord);
	
	void deleteMedicalRecordInJson(String firstName, String lastName);
	
	void updateMedicalRecordInJson(MedicalRecord medicalrecord);

}
