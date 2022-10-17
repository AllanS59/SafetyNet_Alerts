package com.safetynet.safetynetalerts.model;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AppDataTest {

	
	@Test
	public void AppDataEqualsWhenEqualsTest() {
		
		AppData appDataTest = new AppData();
		AppData appDataTest2 = new AppData();
		
		Person[] personTest = new Person[1];
		Firestation[] firestationTest = new Firestation[1];
		MedicalRecord[] medicalRecordTest = new MedicalRecord[1];
		
		personTest[0]=new Person();
		personTest[0].setFirstName("prenom");
		firestationTest[0]= new Firestation();
		firestationTest[0].setAddress("adresse");
		medicalRecordTest[0] = new MedicalRecord();
		medicalRecordTest[0].setFirstName("prenom");
		
		appDataTest.setPersons(personTest);
		appDataTest.setFirestations(firestationTest);
		appDataTest.setMedicalrecords(medicalRecordTest);
		
		appDataTest2.setPersons(personTest);
		appDataTest2.setFirestations(firestationTest);
		appDataTest2.setMedicalrecords(medicalRecordTest);

		assertEquals(true, appDataTest.equals(appDataTest2));
	}
	
	

	@Test
	public void AppDataEqualsWhenNotEqualsTest() {
		
		AppData appDataTest = new AppData();
		AppData appDataTest2 = new AppData();
		
		Person[] personTest = new Person[1];
		Firestation[] firestationTest = new Firestation[1];
		MedicalRecord[] medicalRecordTest = new MedicalRecord[1];
		
		personTest[0]=new Person();
		personTest[0].setFirstName("prenom");
		firestationTest[0]= new Firestation();
		firestationTest[0].setAddress("adresse");
		medicalRecordTest[0] = new MedicalRecord();
		medicalRecordTest[0].setFirstName("prenom");
		
		appDataTest.setPersons(personTest);
		appDataTest.setFirestations(firestationTest);
		appDataTest.setMedicalrecords(medicalRecordTest);
		
		appDataTest2.setPersons(personTest);
		appDataTest2.setFirestations(firestationTest);
		appDataTest2.setMedicalrecords(null);

		assertEquals(false, appDataTest.equals(appDataTest2));
	}
	
	@Test
	public void AppDataToStringTest() {
		
		AppData appDataTest = new AppData();
		String appDataTestString = "AppData(persons=[Person(firstName=prenom, lastName=null, address=null, city=null, zip=null, phone=null, email=null)], firestations=[Firestation(address=adresse, station=0)], medicalrecords=[MedicalRecord(firstName=prenom, lastName=null, birthdate=null, medications=null, allergies=null)])";
		Person[] personTest = new Person[1];
		Firestation[] firestationTest = new Firestation[1];
		MedicalRecord[] medicalRecordTest = new MedicalRecord[1];
		
		personTest[0]=new Person();
		personTest[0].setFirstName("prenom");
		firestationTest[0]= new Firestation();
		firestationTest[0].setAddress("adresse");
		medicalRecordTest[0] = new MedicalRecord();
		medicalRecordTest[0].setFirstName("prenom");
		
		appDataTest.setPersons(personTest);
		appDataTest.setFirestations(firestationTest);
		appDataTest.setMedicalrecords(medicalRecordTest);
		

		assertEquals(appDataTestString, appDataTest.toString());
	}
	
	@Test
	public void AppDataHashCodeTest() {
		
		AppData appDataTest = new AppData();
		int code = appDataTest.hashCode();

		assertNotEquals(0, code);

	}
}
