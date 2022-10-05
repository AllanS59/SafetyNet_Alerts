package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;

public interface MedicalRecordsRepository {
	
	/**
	 * get the MedicalRecords from Json file
	 * @return MedicalRecord[] array of the medicalrecords found
	 */
	MedicalRecord[] getMedicalRecordsFromData();
	
	/**
	 * get the MedicalRecords from a specific person
	 * @param medicalRecords array of medicalRecords where search 
	 * @param firstName firstName of the person we search
	 * @param lastName lastName of the person we search
	 * @return MedicalRecord the  MedicalRecord found
	 */
	MedicalRecord getMedicalRecordByFirstNameAndLastName(MedicalRecord[] medicalRecords, String firstName, String lastName);

	/**
	 * get the MedicalRecords of person over a specific age
	 * @param medicalRecords array of medicalRecords where search 
	 * @param MinAge the age over which the persons are kept
	 * @return MedicalRecord[] array of the medicalrecords found
	 */
	MedicalRecord[] getMedicalRecordsByMinAge(MedicalRecord[] medicalRecords, int MinAge);
	
	/**
	 * get the MedicalRecords of person under a specific age
	 * @param medicalRecords array of medicalRecords where search 
	 * @param MaxAge the age under which the persons are kept
	 * @return MedicalRecord[] array of the medicalrecords found
	 */
	MedicalRecord[] getMedicalRecordsByMaxAge(MedicalRecord[] medicalRecords, int MaxAge);
	
	/**
	 * add a MedicalRecord into Json data
	 * @param medicalRecord the medical record to add
	 */
	void addMedicalRecordInData (MedicalRecord medicalRecord);
	
	/**
	 * update a MedicalRecord into Json data
	 * @param medicalRecord the medical record to update
	 */
	void updateMedicalRecordInData (MedicalRecord medicalRecord);
	
	/**
	 * delete a MedicalRecord into Json data
	 * @param firstName the first name of the person to delete
	 * @param lastName the last name of the person to delete
	 */
	void deleteMedicalRecordInData (String firstName, String lastName);
	
	/**
	 * calculate the age of a person from MedicalREcord
	 * @param  medicalRecord the medical record to check
	 * @return int age of the person
	 */
	int getAge (MedicalRecord medicalRecord);
	
	
	/**
	 * Count the number of children (<18yr) from an array of Persons
	 * @param persons array of persons in which the children are counted
	 * @param medicalRecords array of medicalrecords to find the birthdates
	 * @return int number of children among the persons array
	 */
	int countChildrenFromPersonsArray (Person[] persons, MedicalRecord[] medicalRecords);
	
	
}
