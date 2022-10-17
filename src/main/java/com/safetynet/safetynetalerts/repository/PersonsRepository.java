package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.model.Person;

public interface PersonsRepository {

	/**
	 * get the Persons from Json file
	 * 
	 * @return Person[] array of the persons found
	 */
	Person[] getPersonsFromAppData();

	/**
	 * get the Persons from a specific person
	 * 
	 * @param persons   array of Persons where search
	 * @param firstName firstName of the person we search
	 * @param lastName  lastName of the person we search
	 * @return Person the Person found
	 */
	Person getPersonByFirstNameAndLastName(Person[] persons, String firstName, String lastName);

	/**
	 * get the Persons from a specific address
	 * 
	 * @param persons array of Persons where search
	 * @param address the address to search
	 * @return Person[] array of the persons found
	 */
	Person[] getPersonsByAddress(Person[] persons, String address);

	/**
	 * get the Persons from a specific city
	 * 
	 * @param persons array of Persons where search
	 * @param city    the address to search
	 * @return Person[] array of the persons found
	 */
	Person[] getPersonsByCity(Person[] persons, String city);

	/**
	 * add Person in data
	 * 
	 * @param person person to add in data
	 */
	void addPersonInData(Person person);

	/**
	 * update Person in data
	 * 
	 * @param person person to update in data
	 */
	void updatePersonInData(Person person);

	/**
	 * delete Person in data
	 * 
	 * @param firstName firstname of the person to delete
	 * @param lastName  lastname of the person to delete
	 */
	void deletePersonInData(String firstName, String lastName);

}
