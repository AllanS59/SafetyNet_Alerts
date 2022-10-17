package com.safetynet.safetynetalerts.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.AppDataRepository;
import com.safetynet.safetynetalerts.repository.PersonsRepository;

@Repository
public class PersonsRepoImpl implements PersonsRepository {

	@Autowired
	private AppDataRepository appDataRepo;

	public Person getPersonByFirstNameAndLastName(Person[] persons, String firstName, String lastName) {

		Person foundPerson = null;

		for (Person p : persons) {
			if (p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)) {
				foundPerson = p;
				break;
			}
		}
		return foundPerson;
	}

	public Person[] getPersonsByAddress(Person[] persons, String address) {

		List<Person> listPersons = new ArrayList<Person>();

		for (Person p : persons) {
			if (p.getAddress().equals(address)) {
				listPersons.add(p);
			}
		}
		Person[] foundPersons = listPersons.toArray(new Person[0]);
		return foundPersons;
	}

	public Person[] getPersonsByCity(Person[] persons, String city) {

		List<Person> listPersons = new ArrayList<Person>();

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
		Person[] persons = appDataRepo.readDatafromJson().getPersons();
		return persons;
	}

	@Override
	public void addPersonInData(Person person) {
		appDataRepo.addPersonInJson(person);

	}

	@Override
	public void updatePersonInData(Person person) {
		appDataRepo.updatePersonInJson(person);

	}

	@Override
	public void deletePersonInData(String firstName, String lastName) {
		appDataRepo.deletePersonInJson(firstName, lastName);

	}

}
