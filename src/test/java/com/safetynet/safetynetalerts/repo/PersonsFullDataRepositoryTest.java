package com.safetynet.safetynetalerts.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.safetynet.safetynetalerts.model.AppData;
import com.safetynet.safetynetalerts.model.PersonFullData;
import com.safetynet.safetynetalerts.repository.PersonsFullDataRepository;
import com.safetynet.safetynetalerts.repository.Impl.AppDataRepoImpl;

public class PersonsFullDataRepositoryTest {

	private static PersonsFullDataRepository personsFullDataRepo;
	private static AppDataRepoImpl appDataRepository;
	private static PersonFullData[] allPersons;

	@BeforeAll
	private static void setUp() {
		appDataRepository = new AppDataRepoImpl();
		personsFullDataRepo = new PersonsFullDataRepository();
		
		AppData appData = appDataRepository.readDatafromJson();
		allPersons = personsFullDataRepo.getPersonsByAppData(appData);
	}

	@BeforeEach
	private void setUpPerTest() {
	}

	@Test
	public void getPersonsByAppDataTest() {
		String firstName0 = allPersons[0].getFirstName();
		String lastName3 = allPersons[3].getLastName();
		int station0 = allPersons[0].getStation();

		assertEquals("John", firstName0);
		assertEquals("Boyd", lastName3);
		assertEquals(3, station0);
	}
	
	
	@Test
	public void getPersonByNameTest() {
		PersonFullData person = personsFullDataRepo.getPersonByFirstNameAndLastName(allPersons, "Jonanathan", "Marrack");
		
		String firstName = person.getFirstName();
		String address = person.getAddress();
		
		assertEquals("Jonanathan", firstName);
		assertEquals("29 15th St", address);
	}
	
	@Test
	public void getPersonByAddressTest() {
		PersonFullData[] persons = personsFullDataRepo.getPersonsByAddress(allPersons, "29 15th St");
		
		String firstName = persons[0].getFirstName();
		String address = persons[0].getAddress();
		
		assertEquals("Jonanathan", firstName);
		assertEquals("29 15th St", address);
	}
	
	@Test
	public void getPersonsByCityTest() {
		PersonFullData[] persons = personsFullDataRepo.getPersonsByCity(allPersons, "Culver");
		
		String firstName = persons[0].getFirstName();
		String address = persons[0].getAddress();
		
		assertEquals("John", firstName);
		assertEquals("1509 Culver St", address);
	}
	
	@Test
	public void getPersonsByStationTest() {
		PersonFullData[] persons = personsFullDataRepo.getPersonsByStation(allPersons, 2);
		
		String firstName = persons[0].getFirstName();
		String address = persons[0].getAddress();
		
		assertEquals("Jonanathan", firstName);
		assertEquals("29 15th St", address);
	}
	
	@Test
	public void getPersonsByMaxAgeTest() {
		PersonFullData[] persons = personsFullDataRepo.getPersonsByMaxAge(allPersons, 18);
		
		String firstName = persons[0].getFirstName();
		String address = persons[0].getAddress();
		
		assertEquals("Tenley", firstName);
		assertEquals("1509 Culver St", address);
	}

}
