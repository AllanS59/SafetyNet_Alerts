package com.safetynet.safetynetalerts.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.PersonsRepository;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class PersonsRepositoryTest {

	@Autowired
	private PersonsRepository personsRepo;
	
	public static  Person[] allPersons;
	
	
	@BeforeAll
	public void setUp() {
		allPersons = personsRepo.getPersonsFromAppData();
	}
	
	@Test
	public void getPersonsByAppDataTest() {
		String firstName0 = allPersons[0].getFirstName();
		String lastName3 = allPersons[3].getLastName();

		assertEquals("John", firstName0);
		assertEquals("Boyd", lastName3);
	}
	
	
	@Test
	public void getPersonByNameTest() {
		Person foundperson = personsRepo.getPersonByFirstNameAndLastName(allPersons, "Jonanathan", "Marrack");
		
		String firstName = foundperson.getFirstName();
		String address = foundperson.getAddress();
		
		assertEquals("Jonanathan", firstName);
		assertEquals("29 15th St", address);
	}
	
	@Test
	public void getPersonByAddressTest() {
		Person[] foundpersons = personsRepo.getPersonsByAddress(allPersons, "29 15th St");
		
		String firstName = foundpersons[0].getFirstName();
		String address = foundpersons[0].getAddress();
		
		assertEquals("Jonanathan", firstName);
		assertEquals("29 15th St", address);
	}
	
	@Test
	public void getPersonsByCityTest() {
		Person[] foundpersons = personsRepo.getPersonsByCity(allPersons, "Culver");
		
		String firstName = foundpersons[0].getFirstName();
		String address = foundpersons[0].getAddress();
		
		assertEquals("John", firstName);
		assertEquals("1509 Culver St", address);
		
	}
	
}


