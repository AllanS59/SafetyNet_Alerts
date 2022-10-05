package com.safetynet.safetynetalerts.repository.impl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.safetynet.safetynetalerts.model.AppData;
import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.AppDataRepository;

@Repository
public class AppDataRepoImpl implements AppDataRepository {
	
	private String jsonFileName = "src/main/resources/data.json";
	
	

	public AppData readDatafromJson() {

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

	public void writeDataInJson(AppData appData) {
		
		//Conversion of the App Data into a string in Json format
		Gson gson =  new GsonBuilder().setPrettyPrinting().setDateFormat("dd/MM/yyyy").create();
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
	
	
	
	public void addPersonInJson(Person personToAdd) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson();
		
		//add the person
		appData.addPerson(personToAdd);
		
		//Re-write the Json file
		writeDataInJson(appData);
	}
	
	
	public void deletePersonInJson(String firstName, String lastName) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson();
		
		//add the person
		appData.deletePerson(firstName,lastName);
		
		//Re-write the Json file
		writeDataInJson(appData);
	}
	
	
	public void updatePersonInJson(Person personUpdatedValue) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson();
		
		//add the person
		appData.updatePerson(personUpdatedValue);
		
		//Re-write the Json file
		writeDataInJson(appData);
	}
	
	
	
	public void addFirestationInJson(Firestation firestationToAdd) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson();
		
		//add the person
		appData.addFirestation(firestationToAdd);
		
		//Re-write the Json file
		writeDataInJson(appData);
	}
	
	
	public void deleteFirestationInJson(String address) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson();
		
		//add the person
		appData.deleteFirestation(address);
		
		//Re-write the Json file
		writeDataInJson(appData);
	}
	
	
	public void updateFirestationInJson(Firestation firestationUpdatedValue) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson();
		
		//add the person
		appData.updateFirestation(firestationUpdatedValue);
		
		//Re-write the Json file
		writeDataInJson(appData);
	}
	
	
	
	public void addMedicalRecordInJson(MedicalRecord medicalRecordToAdd) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson();
		
		//add the person
		appData.addMedicalRecord(medicalRecordToAdd);
		
		//Re-write the Json file
		writeDataInJson(appData);
	}
	
	
	public void deleteMedicalRecordInJson(String firstName, String lastName) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson();
		
		//add the person
		appData.deleteMedicalRecord(firstName, lastName);
		
		//Re-write the Json file
		writeDataInJson(appData);
	}
	
	
	public void updateMedicalRecordInJson(MedicalRecord medicalRecordUpdatedValue) {
		
		//Read Json file and save in AppData object
		AppData appData = readDatafromJson();
		
		//add the person
		appData.updateMedicalRecord(medicalRecordUpdatedValue);
		
		//Re-write the Json file
		writeDataInJson(appData);
	}

		
	
	
	
	
	
	





}
