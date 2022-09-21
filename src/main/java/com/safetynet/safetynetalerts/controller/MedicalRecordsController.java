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
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.service.AppDataService;
import com.safetynet.safetynetalerts.service.MedicalRecordsService;

@RestController
public class MedicalRecordsController {

	@Autowired
	AppDataService appDataService = new AppDataService();
	
	@Autowired
	MedicalRecordsService medicalRecordsService = new MedicalRecordsService();
	
	
	/**
	 * Read - Get all medical records
	 * @return A MedicalRecord object full filled
	 */
	@GetMapping("/medicalRecords")
	public MedicalRecord[] getMedicalRecords() {
		
		//lecture du fichier Json
		AppData appData = appDataService.readDatafromJson("src/main/resources/data.json");
		MedicalRecord[] medicalRecords = appData.getMedicalrecords();
		return medicalRecords;	
	}
		
	
	
	/**
	 * Read - Get one Medical Record
	 * 
	 * @param firstName The first name of the person for who we are searching the medical record
	 * @param lastName The last name of the person for who we are searching the medical record
	 * @return A MedicalRecord object full filled
	 */
	@GetMapping("/medicalRecord/{firstName}_{lastName}")
	public MedicalRecord getMedicalRecord(@PathVariable("firstName") final String firstName, @PathVariable("lastName") final String lastName) {
		
		//lecture du fichier Json
		AppData appData = appDataService.readDatafromJson("src/main/resources/data.json");
		MedicalRecord[] medicalRecords = appData.getMedicalrecords();
		
		System.out.println(medicalRecords[0].getBirthdate());
       
        //Search the person by Name in the Persons Array
		MedicalRecord foundMedicalRecord = medicalRecordsService.getMedicalRecordByFirstNameAndLastName(medicalRecords, firstName, lastName);
        
		return foundMedicalRecord;	
	}
	
	
	/**
	 * Create - Add a new medical record
	 * @param medicalRecord An object MedicalRecord
	 * @return The MedicalRecord object saved
	 */
	@PostMapping("/medicalRecord")
	public MedicalRecord CreateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		appDataService.addMedicalRecordInJson(medicalRecord, "src/main/resources/data2.json");
		return medicalRecord;
	}
	
	/**
	 * Update - Update an existing medical Record
	 * @param firstName The first name of the person
	 * @param lastName The last name of the person
	 * @return
	 */
	@PutMapping("/medicalRecord/{firstName}_{lastName}")
	public MedicalRecord updateMedicalRecord(@PathVariable("firstName") final String firstName, @PathVariable("lastName") final String lastName, @RequestBody MedicalRecord medicalRecord) {
		appDataService.updateMedicalRecordInJson(firstName, lastName , medicalRecord, "src/main/resources/data2.json");
		return medicalRecord;
	} 
	
	
	/**
	 * Delete - Delete a medical Record
	 * @param firstName The first name of the person
	 * @param lastName The last name of the person
	 */
	@DeleteMapping("/medicalRecord/{firstName}_{lastName}")
	public void deleteMedicalRecord(@PathVariable("firstName") final String firstName, @PathVariable("lastName") final String lastName) {
		appDataService.deleteMedicalRecordInJson(firstName, lastName , "src/main/resources/data2.json");
	}
}
