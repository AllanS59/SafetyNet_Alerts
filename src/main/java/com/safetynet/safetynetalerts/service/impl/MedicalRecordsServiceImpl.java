package com.safetynet.safetynetalerts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.repository.AppDataRepository;
import com.safetynet.safetynetalerts.repository.MedicalRecordsRepository;
import com.safetynet.safetynetalerts.service.MedicalRecordsService;


@Service
public class MedicalRecordsServiceImpl implements MedicalRecordsService{

	@Autowired
	private MedicalRecordsRepository medicalRecordsRepository ;
	
	@Autowired
	private AppDataRepository appDataRepository ;
	
	
	public MedicalRecord getMedicalRecordByFirstNameAndLastName (String firstName, String lastName) {
		MedicalRecord[] medicalRecords = appDataRepository.readDatafromJson().getMedicalrecords();
		return medicalRecordsRepository.getMedicalRecordByFirstNameAndLastName (medicalRecords, firstName, lastName);
	}


	@Override
	public MedicalRecord[] getMedicalRecords() {
		return medicalRecordsRepository.getMedicalRecordsFromData();
	}


	@Override
	public MedicalRecord[] getMedicalRecordsByMinAge(int MinAge) {
		MedicalRecord[] medicalRecords = appDataRepository.readDatafromJson().getMedicalrecords();
		return medicalRecordsRepository.getMedicalRecordsByMinAge(medicalRecords, MinAge);
	}


	@Override
	public MedicalRecord[] getMedicalRecordsByMaxAge(int MaxAge) {
		MedicalRecord[] medicalRecords = appDataRepository.readDatafromJson().getMedicalrecords();
		return medicalRecordsRepository.getMedicalRecordsByMaxAge(medicalRecords, MaxAge);
	}


	@Override
	public void addMedicalRecordInData(MedicalRecord medicalRecord) {
		medicalRecordsRepository.addMedicalRecordInData(medicalRecord);
		
	}


	@Override
	public void updateMedicalRecordInData(MedicalRecord medicalRecord) {
		medicalRecordsRepository.updateMedicalRecordInData(medicalRecord);
		
	}


	@Override
	public void deleteMedicalRecordInData(String firstName, String lastName) {
		medicalRecordsRepository.deleteMedicalRecordInData(firstName, lastName);
		
	}
}
