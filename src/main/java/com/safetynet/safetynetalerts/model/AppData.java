package com.safetynet.safetynetalerts.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class AppData {

	private Person[] persons;

	private Firestation[] firestations;

	private MedicalRecord[] medicalrecords;

	/**
	 * Create - Add a new Person
	 * 
	 * @param personToAdd An object Person
	 */
	public void addPerson(Person personToAdd) {

		// Convert to ArrayList
		List<Person> listPersons = new ArrayList<>(Arrays.asList(this.persons));

		// Add elements to it
		listPersons.add(personToAdd);

		// Convert the array list back to an array
		Person[] foundPersons = listPersons.toArray(new Person[0]);
		setPersons(foundPersons);
	}

	/**
	 * Delete - Delete a Person
	 * 
	 * @param firstName The first name of the person
	 * @param lastName  The last name of the person
	 */
	public void deletePerson(String firstName, String lastName) {
		// Convert to ArrayList
		List<Person> listPersons = new ArrayList<>(Arrays.asList(this.persons));

		// Delete elements to it if found
		for (int i = 0; i < listPersons.size(); i++) {
			if (listPersons.get(i).getFirstName().equals(firstName)
					&& listPersons.get(i).getLastName().equals(lastName)) {
				listPersons.remove(i);
				break;
			}
		}
		// Convert the array list back to an array
		Person[] foundPersons = listPersons.toArray(new Person[0]);
		setPersons(foundPersons);

	}

	/**
	 * Update - Update a Person
	 * 
	 * @param personUpdatedValues An object Person
	 */
	public void updatePerson(Person personUpdatedValues) {

		String firstName = personUpdatedValues.getFirstName();
		String lastName = personUpdatedValues.getLastName();

		for (Person p : this.persons) {
			if (firstName.equals(p.getFirstName()) && lastName.equals(p.getLastName())) {
				p.updatePerson(personUpdatedValues);
				break;
			}
		}
	}

	/**
	 * Create - Add a new Firestation
	 * 
	 * @param firestationToAdd An object Firestation
	 */
	public void addFirestation(Firestation firestationToAdd) {

		// Convert to ArrayList
		List<Firestation> listFirestations = new ArrayList<>(Arrays.asList(this.firestations));

		// Add elements to it
		listFirestations.add(firestationToAdd);

		// Convert the array list back to an array
		Firestation[] foundFirestations = listFirestations.toArray(new Firestation[0]);
		setFirestations(foundFirestations);
	}

	/**
	 * Delete - Delete a Firestation
	 * 
	 * @param firestationToDelete An object Person
	 */
	public void deleteFirestation(String address) {

		// Convert to ArrayList
		List<Firestation> listFirestations = new ArrayList<>(Arrays.asList(this.firestations));

		// Delete elements to it if found
		for (int i = 0; i < listFirestations.size(); i++) {
			if (listFirestations.get(i).getAddress().equals(address)) {
				listFirestations.remove(i);
				break;
			}
		}

		// Convert the array list back to an array
		Firestation[] foundFirestations = listFirestations.toArray(new Firestation[0]);
		setFirestations(foundFirestations);
	}

	/**
	 * Update - Update a Firestation
	 * 
	 * @param firestationUpdatedValues An object Firestation
	 */
	public void updateFirestation(Firestation firestationUpdatedValues) {

		String address = firestationUpdatedValues.getAddress();

		for (Firestation f : this.firestations) {
			if (address.equals(f.getAddress())) {
				f.updateFirestation(firestationUpdatedValues);
				break;
			}
		}
	}

	/**
	 * Create - Add a new MedicalRecord
	 * 
	 * @param medicalRecordToAdd An object MedicalRecord
	 */
	public void addMedicalRecord(MedicalRecord medicalRecordToAdd) {

		// Convert to ArrayList
		List<MedicalRecord> listMedicalRecords = new ArrayList<>(Arrays.asList(this.medicalrecords));

		// Add elements to it
		listMedicalRecords.add(medicalRecordToAdd);

		// Convert the array list back to an array
		MedicalRecord[] foundMedicalRecords = listMedicalRecords.toArray(new MedicalRecord[0]);
		setMedicalrecords(foundMedicalRecords);
	}

	/**
	 * Delete - Delete a MedicalRecord
	 * 
	 * @param medicalRecordToDelete An object MedicalRecord
	 */
	public void deleteMedicalRecord(String firstName, String lastName) {
		// Convert to ArrayList
		List<MedicalRecord> listMedicalRecords = new ArrayList<>(Arrays.asList(this.medicalrecords));

		// Delete elements to it if found
		for (int i = 0; i < listMedicalRecords.size(); i++) {
			if (listMedicalRecords.get(i).getFirstName().equals(firstName)
					&& listMedicalRecords.get(i).getLastName().equals(lastName)) {
				listMedicalRecords.remove(i);
				break;
			}
		}

		// Convert the array list back to an array
		MedicalRecord[] foundMedicalRecords = listMedicalRecords.toArray(new MedicalRecord[0]);
		setMedicalrecords(foundMedicalRecords);
	}

	/**
	 * Update - Update a MedicalRecord
	 * 
	 * @param medicalRecordUpdatedValues An object MedicalRecord
	 */
	public void updateMedicalRecord(MedicalRecord medicalRecordUpdatedValues) {

		String firstName = medicalRecordUpdatedValues.getFirstName();
		String lastName = medicalRecordUpdatedValues.getLastName();

		for (MedicalRecord m : this.medicalrecords) {
			if (firstName.equals(m.getFirstName()) && lastName.equals(m.getLastName())) {
				m.updateMedicalRecord(medicalRecordUpdatedValues);
				break;
			}
		}
	}

}