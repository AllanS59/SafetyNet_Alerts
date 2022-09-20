package com.safetynet.safetynetalerts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.repository.MedicalRecordsRepository;


import lombok.Data;

@Data
@Service
public class MedicalRecordsService {

	@Autowired
	private MedicalRecordsRepository medicalRecordsRepository ;
	
	
	
	public MedicalRecord getMedicalRecordByFirstNameAndLastName (MedicalRecord[] medicalRecords, String firstName, String lastName) {
		
		return medicalRecordsRepository.getMedicalRecordByFirstNameAndLastName (medicalRecords, firstName, lastName);
	}
}
