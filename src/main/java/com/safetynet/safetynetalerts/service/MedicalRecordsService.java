package com.safetynet.safetynetalerts.service;

import com.safetynet.safetynetalerts.model.MedicalRecord;

public interface MedicalRecordsService {

	/**
	 * get the MedicalRecords from Json file
	 * 
	 * @return MedicalRecord[] array of the medicalrecords found
	 */
	MedicalRecord[] getMedicalRecords();

	/**
	 * get the MedicalRecords from a specific person
	 * 
	 * @param firstName firstName of the person we search
	 * @param lastName  lastName of the person we search
	 * @return MedicalRecord the MedicalRecord found
	 */
	MedicalRecord getMedicalRecordByFirstNameAndLastName(String firstName, String lastName);

	/**
	 * get the MedicalRecords of person over a specific age
	 * 
	 * @param MinAge the age over which the persons are kept
	 * @return MedicalRecord[] array of the medicalrecords found
	 */
	MedicalRecord[] getMedicalRecordsByMinAge(int MinAge);

	/**
	 * get the MedicalRecords of person under a specific age
	 * 
	 * @param MaxAge the age under which the persons are kept
	 * @return MedicalRecord[] array of the medicalrecords found
	 */
	MedicalRecord[] getMedicalRecordsByMaxAge(int MaxAge);

	/**
	 * add a MedicalRecord into Json data
	 * 
	 * @param medicalRecord the medical record to add
	 */
	void addMedicalRecordInData(MedicalRecord medicalRecord);

	/**
	 * update a MedicalRecord into Json data
	 * 
	 * @param medicalRecord the medical record to update
	 */
	void updateMedicalRecordInData(MedicalRecord medicalRecord);

	/**
	 * delete a MedicalRecord into Json data
	 * 
	 * @param firstName the first name of the person to delete
	 * @param lastName  the last name of the person to delete
	 */
	void deleteMedicalRecordInData(String firstName, String lastName);
}
