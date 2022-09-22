package com.safetynet.safetynetalerts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.Impl.PersonsRepoImpl;

import lombok.Data;

@Data
@Service
public class PersonsService {


	@Autowired
	private PersonsRepoImpl personsRepository ;
	
	
	public Person getPersonByFirstNameAndLastName (Person[] persons, String firstName, String lastName) {
		
		return personsRepository.getPersonByFirstNameAndLastName (persons, firstName, lastName);
	}
	
	
	public Person deletePersonByFirstNameAndLastName (Person[] persons, String firstName, String lastName) {
		
		return personsRepository.getPersonByFirstNameAndLastName (persons, firstName, lastName);
	}
	
	
}
