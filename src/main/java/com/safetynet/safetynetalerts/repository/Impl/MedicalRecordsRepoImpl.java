package com.safetynet.safetynetalerts.repository.Impl;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.repository.MedicalRecordsRepository;

@Component
public class MedicalRecordsRepoImpl implements MedicalRecordsRepository  {

	public MedicalRecord getMedicalRecordByFirstNameAndLastName(MedicalRecord[] medicalRecords, String firstName, String lastName) {

		MedicalRecord foundmedicalRecord = null;

		for (MedicalRecord m : medicalRecords) {
			if (m.getFirstName().equals(firstName) && m.getLastName().equals(lastName)) {
				foundmedicalRecord = m;
				break;
			}
		}
		return foundmedicalRecord;
	}

//	@Override
//	public MedicalRecord[] getMedicalRecordsforMinors(MedicalRecord[] medicalRecords) {
//
//		long todaysMillis = System.currentTimeMillis();
//		long birthdateMillis = 0;
//
//		// Convert to ArrayList
//		List<MedicalRecord> listMedicalRecords = new ArrayList<>(Arrays.asList(medicalRecords));
//
//		// Delete elements to it if found
//		for (int i = 0; i < listMedicalRecords.size(); i++) {
//
//			// Calcul of the age
//			birthdateMillis = listMedicalRecords.get(i).getBirthdate().getTime();
//			long age = (todaysMillis - birthdateMillis) / 1000; // age in seconde
//			age = age / (60 * 60 * 24 * 365); // age in year
//
//			if (age >= 18) {
//				listMedicalRecords.remove(i);
//			}
//		}
//		// Convert the array list back to an array
//		MedicalRecord[] foundMedicalRecords = listMedicalRecords.toArray(new MedicalRecord[0]);
//
//		return foundMedicalRecords;
//
//	}

	@Override
	public MedicalRecord[] getMedicalRecordsFromData() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MedicalRecord[] getMedicalRecordsByMinAge(MedicalRecord[] medicalRecords, int MinAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MedicalRecord[] getMedicalRecordsByMaxAge(MedicalRecord[] medicalRecords, int MaxAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMedicalRecordInData(MedicalRecord medicalRecord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMedicalRecordInData(MedicalRecord medicalRecord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMedicalRecordInData(String firstName, String lastName) {
		// TODO Auto-generated method stub
		
	}

}
