package com.safetynet.safetynetalerts.repository;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.safetynet.safetynetalerts.model.AppData;
import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;

@Repository
public class AppDataRepository {
	
	@Autowired
	private PersonsRepository personsRepository;
	
	@Autowired
	private FirestationsRepository firestationsRepository;

	
	
	public AppData readDatafromJson(String jsonFileName) {

		AppData appData = null;

		try {
			// create Gson instance
			Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();

			// create a reader
			Reader reader = Files.newBufferedReader(Paths.get(jsonFileName));

			// convert JSON string to User object
			appData = gson.fromJson(reader, AppData.class);

			//// print user object
			// System.out.println(appData);

			// close reader
			reader.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return appData;

	}

	public void writeDataInJson(AppData appData, String jsonFileName) {
		
		//Conversion of the App Data into a string in Json format
		Gson gson =  new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(appData);
		
		//Write into the file the new Data
		PrintWriter writer;
		try {
			writer = new PrintWriter(jsonFileName);
			writer.println(json);
			writer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void addPersonInJson(Person personToAdd, String jsonFileName) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson(jsonFileName);
		
		//add the person
		appData.addPerson(personToAdd);
		
		//Re-write the Json file
		writeDataInJson(appData, jsonFileName);
	}
	
	
	public void deletePersonInJson(String firstName, String lastName, String jsonFileName) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson(jsonFileName);
		
		//add the person
		appData.deletePerson(firstName,lastName);
		
		//Re-write the Json file
		writeDataInJson(appData, jsonFileName);
	}
	
	
	public void updatePersonInJson(String firstName, String lastName, Person personUpdatedValue, String jsonFileName) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson(jsonFileName);
		
		//add the person
		appData.updatePerson(firstName,lastName, personUpdatedValue);
		
		//Re-write the Json file
		writeDataInJson(appData, jsonFileName);
	}
	
	
	
	public void addFirestationInJson(Firestation firestationToAdd, String jsonFileName) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson(jsonFileName);
		
		//add the person
		appData.addFirestation(firestationToAdd);
		
		//Re-write the Json file
		writeDataInJson(appData, jsonFileName);
	}
	
	
	public void deleteFirestationInJson(String address, String jsonFileName) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson(jsonFileName);
		
		//add the person
		appData.deleteFirestation(address);
		
		//Re-write the Json file
		writeDataInJson(appData, jsonFileName);
	}
	
	
	public void updateFirestationInJson(String address, Firestation firestationUpdatedValue, String jsonFileName) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson(jsonFileName);
		
		//add the person
		appData.updateFirestation(address, firestationUpdatedValue);
		
		//Re-write the Json file
		writeDataInJson(appData, jsonFileName);
	}
	
	
	
	public void addMedicalRecordInJson(MedicalRecord medicalRecordToAdd, String jsonFileName) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson(jsonFileName);
		
		//add the person
		appData.addMedicalRecord(medicalRecordToAdd);
		
		//Re-write the Json file
		writeDataInJson(appData, jsonFileName);
	}
	
	
	public void deleteMedicalRecordInJson(String firstName, String lastName, String jsonFileName) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson(jsonFileName);
		
		//add the person
		appData.deleteMedicalRecord(firstName, lastName);
		
		//Re-write the Json file
		writeDataInJson(appData, jsonFileName);
	}
	
	
	public void updateMedicalRecordInJson(String firstName, String lastName, MedicalRecord medicalRecordUpdatedValue, String jsonFileName) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson(jsonFileName);
		
		//add the person
		appData.updateMedicalRecord(firstName, lastName,  medicalRecordUpdatedValue);
		
		//Re-write the Json file
		writeDataInJson(appData, jsonFileName);
	}
	
	
	
	public Person[] getPersonsByAddress (String address,AppData appData ) {
		
		//find each persons of the array for requested address
		Person[] persons = appData.getPersons();
		Person[] personsByAddress = personsRepository.getPersonsByAddress(persons, address);
			
		//Return the Data
		return personsByAddress;
	}
	
	
	public Person[] getPersonsByCity (String city,AppData appData ) {
		
		//find each persons of the array for requested address
		Person[] persons = appData.getPersons();
		Person[] personsByCity = personsRepository.getPersonsByCity(persons, city);
			
		//Return the Data
		return personsByCity;
	}
	
	
	
	public Firestation[] getFirestationsByStation (int station, AppData appData) {
		
		//find each firestation of the array for the requested station number
		Firestation[] firestations = firestationsRepository.getFirestationsByStation (appData.getFirestations(),  station);
			
		//Return the Data
		return firestations;
	}
}
