package com.safetynet.safetynetalerts.repository.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.PersonsRepository;

@Component
public class PersonsRepoImpl implements PersonsRepository {

	
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


@Override
public Person[] getPersonsFromAppData() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public Person getpersonByfirstNameAndLastName(Person[] persons, String firstName, String lastName) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public void addPersonInData(Person person) {
	// TODO Auto-generated method stub
	
}


@Override
public void updatePersonInData(Person person) {
	// TODO Auto-generated method stub
	
}


@Override
public void deletePersonInData(String firstName, String lastName) {
	// TODO Auto-generated method stub
	
}
		
}




