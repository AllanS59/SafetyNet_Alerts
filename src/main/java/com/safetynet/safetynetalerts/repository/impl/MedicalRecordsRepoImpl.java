package com.safetynet.safetynetalerts.repository.impl;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetynet.safetynetalerts.dto.PersonNameAgeDTO;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.AppDataRepository;
import com.safetynet.safetynetalerts.repository.MedicalRecordsRepository;

@Repository
public class MedicalRecordsRepoImpl implements MedicalRecordsRepository {

	@Autowired
	private AppDataRepository appDataRepo;

	@Override
	public MedicalRecord getMedicalRecordByFirstNameAndLastName(MedicalRecord[] medicalRecords, String firstName,
			String lastName) {

		MedicalRecord foundmedicalRecord = null;

		for (MedicalRecord m : medicalRecords) {
			if (m.getFirstName().equals(firstName) && m.getLastName().equals(lastName)) {
				foundmedicalRecord = m;
				break;
			}
		}
		return foundmedicalRecord;
	}

	@Override
	public MedicalRecord[] getMedicalRecordsFromData() {
		MedicalRecord[] medicalRecords = appDataRepo.readDatafromJson().getMedicalrecords();
		return medicalRecords;
	}

	@Override
	public MedicalRecord[] getMedicalRecordsByMinAge(MedicalRecord[] medicalRecords, int MinAge) {

		// Create a list to add the correct records
		List<MedicalRecord> listMedicalRecords = new ArrayList<MedicalRecord>();

		// add elements to it if found
		for (MedicalRecord m : medicalRecords) {
			
			// Calcul of the age
			int age = getAge(m);
			
			if (age >= MinAge) {
				listMedicalRecords.add(m);
			}
		}

		// Convert the array list back to an array
		MedicalRecord[] foundMedicalRecords = listMedicalRecords.toArray(new MedicalRecord[0]);
		return foundMedicalRecords;

	}

	@Override
	public MedicalRecord[] getMedicalRecordsByMaxAge(MedicalRecord[] medicalRecords, int MaxAge) {

		// Create a list to add the correct records
		List<MedicalRecord> listMedicalRecords = new ArrayList<MedicalRecord>();

		// add elements to it if found
				for (MedicalRecord m : medicalRecords) {
					
					// Calcul of the age
					int age = getAge(m);
					
					if (age <= MaxAge) {
						listMedicalRecords.add(m);
					}
				}

		// Convert the array list back to an array
		MedicalRecord[] foundMedicalRecords = listMedicalRecords.toArray(new MedicalRecord[0]);
		return foundMedicalRecords;
	}

	@Override
	public void addMedicalRecordInData(MedicalRecord medicalRecord) {
		appDataRepo.addMedicalRecordInJson(medicalRecord);

	}

	@Override
	public void updateMedicalRecordInData(MedicalRecord medicalRecord) {
		appDataRepo.updateMedicalRecordInJson(medicalRecord);

	}

	@Override
	public void deleteMedicalRecordInData(String firstName, String lastName) {
		appDataRepo.deleteMedicalRecordInJson(firstName, lastName);

	}

	@Override
	public int getAge(MedicalRecord medicalRecord) {

		LocalDate birthDate = medicalRecord.getBirthdate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate todayDate = java.time.LocalDate.now();

		return Period.between(birthDate, todayDate).getYears();
	}

	@Override
	public int countChildrenFromPersonsArray(Person[] persons, MedicalRecord[] medicalRecords) {
		int count = 0;
		
		for (Person p : persons) {
			MedicalRecord medicalRecord = getMedicalRecordByFirstNameAndLastName(medicalRecords,
					p.getFirstName(), p.getLastName());
			int age = getAge (medicalRecord);
			if (age < 18) {
				count ++;
			}
		}
		return count;
	}

}
