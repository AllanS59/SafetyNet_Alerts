package com.safetynet.safetynetalerts.repository;

import org.springframework.stereotype.Repository;

import com.safetynet.safetynetalerts.model.Person;

@Repository
public class PersonsRepository {

	
	public Person getPersonByFirstNameAndLastName (Person[] persons, String firstName, String lastName) {
		
		Person foundPerson = null;
		
		for (Person p : persons) {
			if (p.getFirstName().equals(firstName) && p.getLastName().equals(lastName) ) {
					foundPerson = p;
					break;
			}
		}
		return foundPerson;
	}
}




