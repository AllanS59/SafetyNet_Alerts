package com.safetynet.safetynetalerts.service;

import com.safetynet.safetynetalerts.model.AppData;
import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;

public interface AppDataService {

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
	void addPersonInJson(Person personToAdd);
	
	/**
	 * Delete one Person into Json file
	 * @param firstname the first name of the person to delete
	 * @param lastName the last name of the person to delete
	 */
	void deletePersonInJson(String firstName, String lastName);

	/**
	 * Update one Person into Json file
	 * @param personUpdatedValue the person to update (found with name)
	 */
	void updatePersonInJson(Person personUpdatedValue);

	/**
	 * Add one Firestation into Json file
	 * @param firestationToAdd the firestation information to add
	 */
	void addFirestationInJson(Firestation firestationToAdd);

	/**
	 * Delete one Firestation into Json file
	 * @param address the address of the firestation to delete
	 */
	void deleteFirestationInJson(String address);

	/**
	 * Update one Firestation into Json file
	 * @param firestationUpdatedValue the firestation to update (found with address)
	 */
	void updateFirestationInJson(Firestation firestationUpdatedValue);

	/**
	 * Add one MedicalRecord into Json file
	 * @param medicalRecordToAdd the medicalRecord information to add
	 */
	void addMedicalRecordInJson(MedicalRecord medicalRecordToAdd);

	/**
	 * Delete one MedicalRecord into Json file
	 * @param firstname the first name of the person to delete
	 * @param lastName the last name of the person to delete
	 */
	void deleteMedicalRecordInJson(String firstName, String lastName);

	/**
	 * Update one MedicalRecord into Json file
	 * @param medicalRecordUpdatedValue the medicalrecord to update (found with name)
	 */
	void updateMedicalRecordInJson(MedicalRecord medicalRecordUpdatedValue);

}
