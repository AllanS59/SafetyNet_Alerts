package com.safetynet.safetynetalerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.service.MedicalRecordsService;


@RestController
public class MedicalRecordsController {
	
	@Autowired
	private MedicalRecordsService medicalRecordsService;
	
	
	/**
	 * Read - Get all medical records
	 * @return A MedicalRecord object full filled
	 */
	@GetMapping("/medicalRecords")
	public MedicalRecord[] getMedicalRecords() {
		
		MedicalRecord[] medicalRecords = medicalRecordsService.getMedicalRecords();
		return medicalRecords;	
	}
		
	
	
	/**
	 * Read - Get one Medical Record
	 * 
	 * @param firstName The first name of the person for who we are searching the medical record
	 * @param lastName The last name of the person for who we are searching the medical record
	 * @return A MedicalRecord object full filled
	 */
	@GetMapping("/medicalRecord")
	public MedicalRecord getMedicalRecord(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
		
		MedicalRecord foundMedicalRecord = medicalRecordsService.getMedicalRecordByFirstNameAndLastName(firstName, lastName);
		return foundMedicalRecord;	
	}
	
	
	/**
	 * Create - Add a new medical record
	 * @param medicalRecord An object MedicalRecord
	 * @return The MedicalRecord object saved
	 */
	@PostMapping("/medicalRecord")
	public MedicalRecord CreateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		medicalRecordsService.addMedicalRecordInData(medicalRecord);
		return medicalRecord;
	}
	
	/**
	 * Update - Update an existing medical Record
	 * @param firstName The first name of the person
	 * @param lastName The last name of the person
	 * @return
	 */
	@PutMapping("/medicalRecord")
	public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		medicalRecordsService.updateMedicalRecordInData(medicalRecord);
		return medicalRecord;
	} 
	
	
	/**
	 * Delete - Delete a medical Record
	 * @param firstName The first name of the person
	 * @param lastName The last name of the person
	 */
	@DeleteMapping("/medicalRecord")
	public void deleteMedicalRecord(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
		medicalRecordsService.deleteMedicalRecordInData(firstName, lastName);
	}
}
