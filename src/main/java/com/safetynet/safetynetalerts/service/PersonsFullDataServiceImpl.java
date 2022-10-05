package com.safetynet.safetynetalerts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalerts.model.AppData;

import com.safetynet.safetynetalerts.model.PersonFullData;
import com.safetynet.safetynetalerts.repository.PersonsFullDataRepository;


@Service
public class PersonsFullDataServiceImpl {

	@Autowired
	private PersonsFullDataRepository personsFullDataRepo ;
	
	
	
	
	public PersonFullData[] getPersonsByAppData(AppData appData) {
		return personsFullDataRepo.getPersonsByAppData(appData);
	}
	
	public PersonFullData getPersonByFirstNameAndLastName(PersonFullData[] persons, String firstName, String lastName) {
		return personsFullDataRepo.getPersonByFirstNameAndLastName(persons, firstName, lastName);
	}
	
	
	public PersonFullData[] getPersonsByAddress(PersonFullData[] persons, String address) {
		return personsFullDataRepo.getPersonsByAddress(persons, address);
	}
	
	
	public PersonFullData[] getPersonsByCity(PersonFullData[] persons, String city) {
		return personsFullDataRepo.getPersonsByCity(persons, city);
	}
	
		
	public PersonFullData[] getPersonsByStation (PersonFullData[] persons, int station) {
			return personsFullDataRepo.getPersonsByStation (persons, station);
		}
		
	
	public PersonFullData[] getPersonsByMaxAge(PersonFullData[] persons, int MaxAge) {
		return personsFullDataRepo.getPersonsByMaxAge(persons, MaxAge);

	}
	
	
	
}
