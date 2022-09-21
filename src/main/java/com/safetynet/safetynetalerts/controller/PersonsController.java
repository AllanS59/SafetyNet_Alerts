package com.safetynet.safetynetalerts.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalerts.model.AppData;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.service.AppDataService;
import com.safetynet.safetynetalerts.service.PersonsService;

@RestController
public class PersonsController {

	@Autowired
	AppDataService appDataService = new AppDataService();
	
	@Autowired
	PersonsService personsService = new PersonsService();
	
	
	
	/**
	 * Read - Get all persons
	 * @return A Person object full filled
	 */
	@GetMapping("/persons")
	public Person[] getPersons() {
		
		//lecture du fichier Json
		AppData appData = appDataService.readDatafromJson("src/main/resources/data.json");
        Person[] persons = appData.getPersons();
               
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
		
		//lecture du fichier Json
		AppData appData = appDataService.readDatafromJson("src/main/resources/data.json");
        Person[] persons = appData.getPersons();
       
        //Search the person by Name in the Persons Array
        Person foundPerson = personsService.getPersonByFirstNameAndLastName(persons, firstName, lastName);
        
		return foundPerson;	
	}
	
	
	/**
	 * Create - Add a new person
	 * @param person An object Person
	 * @return The Person object saved
	 */
	@PostMapping("/person")
	public Person CreatePerson(@RequestBody Person person) {
		appDataService.addPersonInJson(person, "src/main/resources/data.json");
		return person;
	}
	
	
	
	/**
	 * Update - Update an existing person
	 * @param firstName The first name of the person
	 * @param lastName The last name of the person
	 * @return
	 */
	@PutMapping("/employee/{firstName}_{lastName}")
	public Person updatePerson(@PathVariable("firstName") final String firstName, @PathVariable("lastName") final String lastName, @RequestBody Person person) {
		appDataService.updatePersonInJson(firstName, lastName , person, "src/main/resources/data2.json");
		return person;
	} 
	
	
	/**
	 * Delete - Delete an person
	 * @param firstName The first name of the person
	 * @param lastName The last name of the person
	 */
	@DeleteMapping("/person/{firstName}_{lastName}")
	public void deletePerson(@PathVariable("firstName") final String firstName, @PathVariable("lastName") final String lastName) {
		appDataService.deletePersonInJson(firstName, lastName , "src/main/resources/data2.json");
	}

}