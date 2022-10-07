package com.safetynet.safetynetalerts.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.FirestationsRepository;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest
public class FirestationsRepositoryTest {

	@Autowired
	private FirestationsRepository firestationsRepo;

	public static Firestation[] allFirestations;

	@BeforeAll
	public void setUp() {
		allFirestations = firestationsRepo.getFirestationsFromAppData();
	}

	@Test
	public void getFirestationsFromAppDataTest() {
		String address0 = allFirestations[0].getAddress();
		int station1 = allFirestations[1].getStation();

		assertEquals("1509 Culver St", address0);
		assertEquals(2, station1);
	}

	@Test
	public void getFirestationByAddressTest() {
		Firestation foundFirestations = firestationsRepo.getFirestationByAddress(allFirestations, "748 Townings Dr");

		String address = foundFirestations.getAddress();
		int station = foundFirestations.getStation();

		assertEquals("748 Townings Dr", address);
		assertEquals(3, station);
	}

	@Test
	public void getFirestationsByStationTest() {
		Firestation[] foundFirestations = firestationsRepo.getFirestationsByStation(allFirestations, 2);

		int station0 = foundFirestations[0].getStation();
		String address0 = foundFirestations[0].getAddress();
		String address1 = foundFirestations[1].getAddress();
		String address2 = foundFirestations[2].getAddress();

		assertEquals(2, station0);
		assertEquals("29 15th St", address0);
		assertEquals("892 Downing Ct", address1);
		assertEquals("951 LoneTree Rd", address2);

	}
}
