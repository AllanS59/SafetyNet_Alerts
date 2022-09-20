package com.safetynet.safetynetalerts.repository;

import java.util.ArrayList;
import java.util.List;

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
	
	
public Person[] getPersonsByAddress (Person[] persons, String address) {
		
		List <Person> listPersons = new ArrayList<Person>();
		
		for (Person p : persons) {
			if (p.getAddress().equals(address)) {
					listPersons.add(p);
			}
		}
		Person[] foundPersons = listPersons.toArray(new Person[0]);
		return foundPersons;
	}


public Person[] getPersonsByCity (Person[] persons, String city) {
	
	List <Person> listPersons = new ArrayList<Person>();
	
	for (Person p : persons) {
		if (p.getCity().equals(city)) {
				listPersons.add(p);
		}
	}
	Person[] foundPersons = listPersons.toArray(new Person[0]);
	return foundPersons;
}
		
}




