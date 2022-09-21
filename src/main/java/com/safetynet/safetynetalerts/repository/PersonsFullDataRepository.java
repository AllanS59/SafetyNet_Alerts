package com.safetynet.safetynetalerts.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetynet.safetynetalerts.model.AppData;
import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.PersonFullData;

@Repository
public class PersonsFullDataRepository {

	
	@Autowired
	private FirestationsRepository firestationRepo;
	
	@Autowired
	private MedicalRecordsRepository medicalRecordRepo;
	
	
	public PersonFullData[] getPersonsByAppData(AppData appData) {
		
		firestationRepo = new FirestationsRepository();
		medicalRecordRepo = new MedicalRecordsRepository();
		

		List<PersonFullData> listPersonsFullData = new ArrayList<PersonFullData>();
		
		for (Person p : appData.getPersons()) {
			
			PersonFullData personFullData = new PersonFullData();
			
			//Data relative to Person model
			personFullData.setFirstName(p.getFirstName());
			personFullData.setLastName(p.getLastName());
			personFullData.setAddress(p.getAddress());
			personFullData.setCity(p.getCity());
			personFullData.setZip(p.getZip());
			personFullData.setPhone(p.getPhone());
			personFullData.setEmail(p.getEmail());
			
			
			//Data relative to Firestation Model 
			Firestation f = firestationRepo.getFirestationByAddress (appData.getFirestations(), personFullData.getAddress());
			personFullData.setStation(f.getStation());
			
			//Data relative to MedicalRecord Model 
			MedicalRecord m = medicalRecordRepo.getMedicalRecordByFirstNameAndLastName(appData.getMedicalrecords(), personFullData.getFirstName(), personFullData.getLastName());
			personFullData.setBirthdate(m.getBirthdate());
			personFullData.setMedications(m.getMedications());
			personFullData.setAllergies(m.getAllergies());
			
			listPersonsFullData.add(personFullData);
		}			
			
		PersonFullData[] PersonsFullData = listPersonsFullData.toArray(new PersonFullData[0]);
		return PersonsFullData;
	}
	
	
	
	
	
	
	
	public PersonFullData getPersonByFirstNameAndLastName(PersonFullData[] persons, String firstName, String lastName) {

		PersonFullData foundPerson = null;

		for (PersonFullData p : persons) {
			if (p.getFirstName().equals(firstName) && p.getLastName().equals(lastName)) {
				foundPerson = p;
				break;
			}
		}
		return foundPerson;
	}
	

	public PersonFullData[] getPersonsByAddress(PersonFullData[] persons, String address) {

		List<PersonFullData> listPersons = new ArrayList<PersonFullData>();

		for (PersonFullData p : persons) {
			if (p.getAddress().equals(address)) {
				listPersons.add(p);
			}
		}
		PersonFullData[] foundPersons = listPersons.toArray(new PersonFullData[0]);
		return foundPersons;
	}
	

	public PersonFullData[] getPersonsByCity(PersonFullData[] persons, String city) {

		List<PersonFullData> listPersons = new ArrayList<PersonFullData>();

		for (PersonFullData p : persons) {
			if (p.getCity().equals(city)) {
				listPersons.add(p);
			}
		}
		PersonFullData[] foundPersons = listPersons.toArray(new PersonFullData[0]);
		return foundPersons;
	}
	
	
	
	public PersonFullData[] getPersonsByStation (PersonFullData[] persons, int station) {
		
		List <PersonFullData> listPersons = new ArrayList<PersonFullData>();
			
			for (PersonFullData f : persons) {
				if (f.getStation() == station) {
					listPersons.add(f);
				}
			}
			PersonFullData[] foundPersons = listPersons.toArray(new PersonFullData[0]);
			return foundPersons;
		}
	
	
	
	public PersonFullData[] getPersonsByMaxAge(PersonFullData[] persons, int MaxAge) {

		long todaysMillis = System.currentTimeMillis();
		long birthdateMillis = 0;

		// Convert to ArrayList
		List<PersonFullData> listPersonsFullData = new ArrayList<>(Arrays.asList(persons));

		// Delete elements to it if found
		for (int i = 0; i < listPersonsFullData.size(); i++) {

			// Calcul of the age
			birthdateMillis = listPersonsFullData.get(i).getBirthdate().getTime();
			long age = (todaysMillis - birthdateMillis) / 1000; // age in seconde
			age = age / (60 * 60 * 24 * 365); // age in year

			if (age >= MaxAge) {
				listPersonsFullData.remove(i);
			}
		}
		// Convert the array list back to an array
		PersonFullData[] foundPersons = listPersonsFullData.toArray(new PersonFullData[0]);

		return foundPersons;

	}


}
