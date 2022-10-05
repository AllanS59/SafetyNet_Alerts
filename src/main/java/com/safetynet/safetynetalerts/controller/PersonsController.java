package com.safetynet.safetynetalerts.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.service.PersonsService;

@RestController
public class PersonsController {
	
	@Autowired
	private PersonsService personsService;
	
	
	
	/**
	 * Read - Get all persons
	 * @return A Person object full filled
	 */
	@GetMapping("/persons")
	public Person[] getPersons() {
        
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
	@GetMapping("/person/{firstName}_{lastName}")
	public Person getPerson(@PathVariable("firstName") final String firstName, @PathVariable("lastName") final String lastName) {
        
		Person foundPerson = personsService.getPersonByFirstNameAndLastName(firstName, lastName);
		return foundPerson;	
	}
	
	
	/**
	 * Create - Add a new person
	 * @param person An object Person
	 * @return The Person object saved
	 */
	@PostMapping("/person")
	public Person CreatePerson(@RequestBody Person person) {
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
		personsService.updatePersonInData(person);
		return person;
	} 
	
	
	/**
	 * Delete - Delete an person
	 * @param firstName The first name of the person
	 * @param lastName The last name of the person
	 */
	@DeleteMapping("/person/{firstName}_{lastName}")
	public void deletePerson(@PathVariable("firstName") final String firstName, @PathVariable("lastName") final String lastName) {
		personsService.deletePersonInData(firstName, lastName);
	}

}