package com.safetynet.safetynetalerts.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.service.PersonsService;

@RestController
public class PersonsController {
	
	private static final Logger LOG = LogManager.getLogger(PersonsController.class);
	
	@Autowired
	private PersonsService personsService;
	
	
	
	/**
	 * Read - Get all persons
	 * @return A Person object full filled
	 */
	@GetMapping("/persons")
	public Person[] getPersons() {
		LOG.info("Command GET /persons received. Sending all persons recorded");
		Person[] persons = personsService.getPersons();      
		return persons;	
	}
	
        		
	/**
	 * Read - Get one person
	 * 
	 * @param firstName The first name of the person
	 * @param lastName The last name of the person
	 * @return A Person object full filled
	 */
	@GetMapping("/person")
	public Person getPerson(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
		LOG.info("Command GET  /person received with firestName=" + firstName + " & lastName=" + lastName + ". Sending the person information");
		Person foundPerson = personsService.getPersonByFirstNameAndLastName(firstName, lastName);
		return foundPerson;	
	}
	
	
	/**
	 * Create - Add a new person
	 * @param person An object Person
	 * @return The Person object saved
	 */
	@PostMapping("/person")
	public Person createPerson(@RequestBody Person person) {
		LOG.info("Command POST /person received. Creating person");
		personsService.addPersonInData(person);
		return person;
	}
	
	
	
	/**
	 * Update - Update an existing person
	 * @param firstName The first name of the person
	 * @param lastName The last name of the person
	 * @return
	 */
	@PutMapping("/person")
	public Person updatePerson(@RequestBody Person person) {
		LOG.info("Command PUT /person received. Updating person");
		personsService.updatePersonInData(person);
		return person;
	} 
	
	
	/**
	 * Delete - Delete an person
	 * @param firstName The first name of the person
	 * @param lastName The last name of the person
	 */
	@DeleteMapping("/person")
	public void deletePerson(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
		LOG.info("Command DELETE  /person received with firestName=" + firstName + " & lastName=" + lastName
				+ ". Deleting the person");
		personsService.deletePersonInData(firstName, lastName);
	}

}