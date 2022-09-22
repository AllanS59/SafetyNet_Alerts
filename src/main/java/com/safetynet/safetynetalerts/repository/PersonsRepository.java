package com.safetynet.safetynetalerts.repository;

import org.springframework.stereotype.Repository;

import com.safetynet.safetynetalerts.model.Person;

@Repository
public interface PersonsRepository {

	Person[] getPersonsFromAppData();
	
	Person getpersonByfirstNameAndLastName (Person[] persons, String firstName, String lastName);
	
	Person[] getPersonsByAddress (Person[] persons, String address);
	
	Person[] getPersonsByCity (Person[] persons, String city);
	
	void addPersonInData (Person person);
	
	void updatePersonInData (Person person);
	
	void deletePersonInData (String firstName, String lastName);
	
	
}
