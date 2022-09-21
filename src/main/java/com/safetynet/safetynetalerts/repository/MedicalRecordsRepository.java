package com.safetynet.safetynetalerts.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.safetynet.safetynetalerts.model.MedicalRecord;

@Repository
public class MedicalRecordsRepository {

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

	public MedicalRecord[] getMedicalRecordsforMinors(MedicalRecord[] medicalRecords) {

		long todaysMillis = System.currentTimeMillis();
		long birthdateMillis = 0;

		// Convert to ArrayList
		List<MedicalRecord> listMedicalRecords = new ArrayList<>(Arrays.asList(medicalRecords));

		// Delete elements to it if found
		for (int i = 0; i < listMedicalRecords.size(); i++) {

			// Calcul of the age
			birthdateMillis = listMedicalRecords.get(i).getBirthdate().getTime();
			long age = (todaysMillis - birthdateMillis) / 1000; // age in seconde
			age = age / (60 * 60 * 24 * 365); // age in year

			if (age >= 18) {
				listMedicalRecords.remove(i);
			}
		}
		// Convert the array list back to an array
		MedicalRecord[] foundMedicalRecords = listMedicalRecords.toArray(new MedicalRecord[0]);

		return foundMedicalRecords;

	}

}
