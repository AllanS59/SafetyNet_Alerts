package com.safetynet.safetynetalerts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.AppDataRepository;
import com.safetynet.safetynetalerts.repository.PersonsRepository;
import com.safetynet.safetynetalerts.service.PersonsService;


@Service
public class PersonsServiceImpl implements PersonsService {

	

	@Autowired
	private PersonsRepository personsRepository ;
	
	@Autowired
	private AppDataRepository appDataRepository ;
	
	
	@Override
	public Person[] getPersons() {
		
		return personsRepository.getPersonsFromAppData();
	}
	
	@Override
	public Person getPersonByFirstNameAndLastName (String firstName, String lastName) {
		Person[] persons = appDataRepository.readDatafromJson().getPersons();
		return personsRepository.getPersonByFirstNameAndLastName (persons, firstName, lastName);
	}
	
	@Override
	public Person[] getPersonByAddress(String address) {
		Person[] persons = appDataRepository.readDatafromJson().getPersons();
		return personsRepository.getPersonsByAddress (persons,address);
	}
	
	@Override
	public Person[] getPersonByCity(String city) {
		Person[] persons = appDataRepository.readDatafromJson().getPersons();
		return personsRepository.getPersonsByCity (persons,city);
	}
	
	

	@Override
	public void deletePersonInData(String firstName, String lastName) {
		personsRepository.deletePersonInData(firstName,  lastName);	
	}

	@Override
	public void addPersonInData(Person person) {
		personsRepository.addPersonInData(person);	
	}

	@Override
	public void updatePersonInData(Person person) {
		personsRepository.updatePersonInData(person);	
		
	}



	
}
