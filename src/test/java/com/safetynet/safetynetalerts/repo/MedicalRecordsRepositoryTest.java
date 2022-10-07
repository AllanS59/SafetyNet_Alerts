package com.safetynet.safetynetalerts.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.MedicalRecordsRepository;
import com.safetynet.safetynetalerts.repository.PersonsRepository;


@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class MedicalRecordsRepositoryTest {

	@Autowired
	private MedicalRecordsRepository medicalRecordsRepo;
	
	@Autowired
	private PersonsRepository personsRepo;
	
	public static  Person[] allPersons;
	public static  MedicalRecord[] allMedicalRecords;
	
	
	@BeforeAll
	public void setUp() {
		allPersons = personsRepo.getPersonsFromAppData();
		allMedicalRecords = medicalRecordsRepo.getMedicalRecordsFromData();
	}
	
	@Test
	public void getMedicalRecordsByAppDataTest() {
		String firstName0 = allMedicalRecords[0].getFirstName();
		String lastName3 = allMedicalRecords[3].getLastName();

		assertEquals("John", firstName0);
		assertEquals("Boyd", lastName3);
	}
	
	
	@Test
	public void getMedicalRecordByNameTest() {
		MedicalRecord foundMedicalRecord = medicalRecordsRepo.getMedicalRecordByFirstNameAndLastName(allMedicalRecords, "Jonanathan", "Marrack");
		
		String firstName = foundMedicalRecord.getFirstName();
		String lastName = foundMedicalRecord.getLastName();
		
		assertEquals("Jonanathan", firstName);
		assertEquals("Marrack", lastName);

	}
	
	@Test
	public void getMedicalRecordsByMinAgeTest() {
		MedicalRecord[] foundMedicalRecord = medicalRecordsRepo.getMedicalRecordsByMinAge(allMedicalRecords, 40);
		
		String firstName = foundMedicalRecord[0].getFirstName();
		String lastName = foundMedicalRecord[1].getLastName();
		
		assertEquals("Foster", firstName);
		assertEquals("Walker", lastName);

	}
	
	
	@Test
	public void getMedicalRecordsByMaxAgeTest() {
		MedicalRecord[] foundMedicalRecord = medicalRecordsRepo.getMedicalRecordsByMaxAge(allMedicalRecords, 18);
		
		String firstName = foundMedicalRecord[0].getFirstName();
		String lastName = foundMedicalRecord[1].getLastName();
		
		assertEquals("Tenley", firstName);
		assertEquals("Boyd", lastName);

	}
	
	@Test
	public void getAgeTest() {
		MedicalRecord medicalRecord = allMedicalRecords[1];
		
		int age = medicalRecordsRepo.getAge(medicalRecord);
		
		assertEquals(33, age);
	}
	
	@Test
	public void countChildrenFromPersonsArrayTest() {
		int numberChildren = medicalRecordsRepo.countChildrenFromPersonsArray(allPersons, allMedicalRecords);
		assertEquals(5, numberChildren);
	}
}

