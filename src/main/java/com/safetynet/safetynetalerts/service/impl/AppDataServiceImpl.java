package com.safetynet.safetynetalerts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalerts.model.AppData;
import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.AppDataRepository;
import com.safetynet.safetynetalerts.service.AppDataService;


@Service
public class AppDataServiceImpl implements AppDataService{

	@Autowired
	private AppDataRepository appRepo;

	public AppData readDatafromJson() {
		return appRepo.readDatafromJson();
	}

	public void writeDataInJson(AppData appData) {
		appRepo.writeDataInJson(appData);
	}

	public void addPersonInJson(Person personToAdd) {
		appRepo.addPersonInJson(personToAdd);
	}

	public void deletePersonInJson(String firstName, String lastName) {
		appRepo.deletePersonInJson(firstName, lastName);
	}

	public void updatePersonInJson(Person personUpdatedValue) {
		appRepo.updatePersonInJson(personUpdatedValue);
	}

	public void addFirestationInJson(Firestation firestationToAdd) {
		appRepo.addFirestationInJson(firestationToAdd);
	}

	public void deleteFirestationInJson(String address) {
		appRepo.deleteFirestationInJson(address);
	}

	public void updateFirestationInJson(Firestation firestationUpdatedValue) {
		appRepo.updateFirestationInJson(firestationUpdatedValue);
	}

	public void addMedicalRecordInJson(MedicalRecord medicalRecordToAdd) {
		appRepo.addMedicalRecordInJson(medicalRecordToAdd);
	}

	public void deleteMedicalRecordInJson(String firstName, String lastName) {
		appRepo.deleteMedicalRecordInJson(firstName, lastName);
	}

	public void updateMedicalRecordInJson(MedicalRecord medicalRecordUpdatedValue) {
		appRepo.updateMedicalRecordInJson(medicalRecordUpdatedValue);
	}

//	public Person[] getPersonsByStation(int station, String jsonFileName) {
//		List<Person> listPersons = new ArrayList<Person>();
//
//		// Read Json file and save in AppData object
//		AppData appData = readDatafromJson(jsonFileName);
//
//		// get addresses related to the station
//		Firestation[] foundFirestations = appRepo.getFirestationsByStation(station, appData);
//
//		// For each address covered by station, get all persons living to that address
//		for (Firestation f : foundFirestations) {
//			Person[] foundPersonsOneAddress = appRepo.getPersonsByAddress(f.getAddress(), appData);
//			List<Person> listPersonsOneAddress = new ArrayList<>(Arrays.asList(foundPersonsOneAddress));
//			listPersons.addAll(listPersonsOneAddress);
//		}
//
//		Person[] foundPersons = listPersons.toArray(new Person[0]);
//		return foundPersons;
//	}
	
	

//	public Person[] getPersonsByCity(String city, String jsonFileName) {
//
//		// Read Json file and save in AppData object
//		AppData appData = readDatafromJson(jsonFileName);
//
//		Person[] foundPersons = appRepo.getPersonsByCity(city, appData);
//		return foundPersons;
//
//	}

}
