package com.safetynet.safetynetalerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalerts.model.AppData;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.AppDataRepository;
import com.safetynet.safetynetalerts.service.PersonsService;

@RestController
public class PersonsController {

//	@Autowired
//	AppDataRepository appDataRepo = new AppDataRepository();
	
//	@Autowired
//	PersonsService personsService = new PersonsService();
	
	/**
	 * Read - Get one employee
	 * 
	 * @param id The id of the employee
	 * @return An Employee object full filled
	 */
	@GetMapping("/persons/{firstName}_{lastName}")
	public Person getPerson(@PathVariable("firstName") final String firstName, @PathVariable("firstName") final String lastName) {
		
		AppDataRepository appDataRepo = new AppDataRepository();
		PersonsService personsService = new PersonsService();
			
		AppData appData = appDataRepo.readDatafromJson("src/main/resources/data.json");
        Person[] persons = appData.getPersons();
        
        Person foundPerson = personsService.getPersonByFirstNameAndLastName(persons, firstName, lastName);
        
        System.out.println (persons[0].getFirstName());
		return foundPerson;
        //return foundPerson.getAddress();
		
	}

}