package com.safetynet.safetynetalerts.model;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MedicalRecordTest {

	@Test
	public void MedicalRecordGettersAndSettersTest() {
		
		MedicalRecord medicalRecordTest = new MedicalRecord();
		String[] medications= {"aznol:350mg", "hydrapermazol:100mg"};
		String[] allergies= {"noix", "crevette"};
		Date dateTest = new Date();
		
		medicalRecordTest.setFirstName("prenom");
		medicalRecordTest.setLastName("nom");
		medicalRecordTest.setBirthdate(dateTest);
		medicalRecordTest.setMedications(medications);
		medicalRecordTest.setAllergies(allergies);

		assertEquals("prenom", medicalRecordTest.getFirstName());
		assertEquals("nom", medicalRecordTest.getLastName());
		assertEquals(dateTest, medicalRecordTest.getBirthdate());
		assertEquals(medications, medicalRecordTest.getMedications());
		assertEquals(allergies, medicalRecordTest.getAllergies());
	}
	
	
	@Test
	public void MedicalRecordEqualsWhenEqualsTest() {
		
		MedicalRecord medicalRecordTest = new MedicalRecord();
		MedicalRecord medicalRecordTest2 = new MedicalRecord();
		String[] medications= {"aznol:350mg", "hydrapermazol:100mg"};
		String[] allergies= {"noix", "crevette"};
		Date dateTest = new Date();
		
		medicalRecordTest.setFirstName("prenom");
		medicalRecordTest.setLastName("nom");
		medicalRecordTest.setBirthdate(dateTest);
		medicalRecordTest.setMedications(medications);
		medicalRecordTest.setAllergies(allergies);
		
		medicalRecordTest2.setFirstName("prenom");
		medicalRecordTest2.setLastName("nom");
		medicalRecordTest2.setBirthdate(dateTest);
		medicalRecordTest2.setMedications(medications);
		medicalRecordTest2.setAllergies(allergies);

		assertEquals(true, medicalRecordTest.equals(medicalRecordTest2));
	}
	
	@Test
	public void MedicalRecordEqualsWhenNotEqualsTest() {
		
		MedicalRecord medicalRecordTest = new MedicalRecord();
		MedicalRecord medicalRecordTest2 = new MedicalRecord();
		String[] medications= {"aznol:350mg", "hydrapermazol:100mg"};
		String[] allergies= {"noix", "crevette"};
		Date dateTest = new Date();
		
		medicalRecordTest.setFirstName("prenom");
		medicalRecordTest.setLastName("nom");
		medicalRecordTest.setBirthdate(dateTest);
		medicalRecordTest.setMedications(medications);
		medicalRecordTest.setAllergies(allergies);
		
		medicalRecordTest2.setFirstName("autrePrenom");
		medicalRecordTest2.setLastName("nom");
		medicalRecordTest2.setBirthdate(dateTest);
		medicalRecordTest2.setMedications(medications);
		medicalRecordTest2.setAllergies(allergies);

		assertEquals(false, medicalRecordTest.equals(medicalRecordTest2));
	}
	
	
	@Test
	public void MedicalRecordToStringTest() {
		
		MedicalRecord medicalRecordTest = new MedicalRecord();
		String medicalRecordTestString = "MedicalRecord(firstName=prenom, lastName=nom, birthdate=Sat Oct 01 00:00:00 CEST 2022, medications=[aznol:350mg, hydrapermazol:100mg], allergies=[noix, crevette])";
		String[] medications= {"aznol:350mg", "hydrapermazol:100mg"};
		String[] allergies= {"noix", "crevette"};
		
		Date dateTest = null;
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    String dateString = "01/10/2022";
	    try {
			dateTest = simpleDateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		medicalRecordTest.setFirstName("prenom");
		medicalRecordTest.setLastName("nom");
		medicalRecordTest.setBirthdate(dateTest);
		medicalRecordTest.setMedications(medications);
		medicalRecordTest.setAllergies(allergies);

		assertEquals(medicalRecordTestString, medicalRecordTest.toString());
	}
	
	@Test
	public void MedicalRecordHashCodeTest() {
		
		MedicalRecord medicalRecordTest = new MedicalRecord();;
		int code = medicalRecordTest.hashCode();

		assertNotEquals(0, code);

	}
	

}
