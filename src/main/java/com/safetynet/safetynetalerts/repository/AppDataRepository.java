package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.model.AppData;
import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;

public interface AppDataRepository {
	
	/**
	 * Read Json file and put information in an 'AppData' object
	 * @return AppData (object class containing informations from Json file)
	 */
	AppData readDatafromJson();
	
	
	/**
	 * Write data into Json file
	 * @param appData information updated
	 */
	void writeDataInJson(AppData appData);
	
	/**
	 * Add one Person into Json file
	 * @param person the person information to add
	 */
	void addPersonInJson(Person person);
	
	/**
	 * Delete one Person into Json file
	 * @param firstname the first name of the person to delete
	 * @param lastName the last name of the person to delete
	 */
	void deletePersonInJson(String firstName, String lastName);
	
	
	/**
	 * Update one Person into Json file
	 * @param person the person to update (found with name)
	 */
	void updatePersonInJson(Person person);
	
	
	/**
	 * Add one Firestation into Json file
	 * @param firestation the firestation information to add
	 */
	void addFirestationInJson(Firestation firestation);
	
	/**
	 * Delete one Firestation into Json file
	 * @param address the address of the firestation to delete
	 */
	void deleteFirestationInJson(String address);
	
	/**
	 * Update one Firestation into Json file
	 * @param firestation the firestation to update (found with address)
	 */
	void updateFirestationInJson(Firestation firestation);
	
	
	/**
	 * Add one MedicalRecord into Json file
	 * @param medicalRecord the medicalRecord information to add
	 */
	void addMedicalRecordInJson(MedicalRecord medicalrecord);
	
	/**
	 * Delete one MedicalRecord into Json file
	 * @param firstname the first name of the person to delete
	 * @param lastName the last name of the person to delete
	 */
	void deleteMedicalRecordInJson(String firstName, String lastName);
	
	/**
	 * Update one MedicalRecord into Json file
	 * @param medicalrecord the medicalrecord to update (found with name)
	 */
	void updateMedicalRecordInJson(MedicalRecord medicalrecord);

}
