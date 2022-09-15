package com.safetynet.safetynetalerts.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.PersonsRepository;

import lombok.Data;

@Data
@Service
public class PersonsService {


	
	
	
	
	
	public Person getPersonByFirstNameAndLastName (Person[] persons, String firstName, String lastName) {
		
		PersonsRepository personsRepository = new PersonsRepository() ;
				
		return personsRepository.getPersonByFirstNameAndLastName (persons, firstName, lastName);
	}
	
	
}
