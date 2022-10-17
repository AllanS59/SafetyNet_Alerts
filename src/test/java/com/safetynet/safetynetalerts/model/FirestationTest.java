package com.safetynet.safetynetalerts.model;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FirestationTest {

	@Test
	public void FirestationGettersAndSettersTest() {
		
		Firestation firestationTest = new Firestation();
		
		firestationTest.setAddress("adresse");
		firestationTest.setStation(3);

		assertEquals("adresse", firestationTest.getAddress());
		assertEquals(3, firestationTest.getStation());
	}
	
	
	@Test
	public void FirestationEqualsWhenEqualsTest() {
		
		Firestation firestationTest = new Firestation();
		Firestation firestationTest2 = new Firestation();
		
		firestationTest.setAddress("adresse");
		firestationTest.setStation(3);
		firestationTest2.setAddress("adresse");
		firestationTest2.setStation(3);

		assertEquals(true, firestationTest.equals(firestationTest2));
	}
	
	@Test
	public void FirestationEqualsWhenNotEqualsTest() {
		
		Firestation firestationTest = new Firestation();
		Firestation firestationTest2 = new Firestation();
		
		firestationTest.setAddress("adresse");
		firestationTest.setStation(3);
		firestationTest2.setAddress("adresse");
		firestationTest2.setStation(2);

		assertEquals(false, firestationTest.equals(firestationTest2));
	}
	
	@Test
	public void FirestationToStringTest() {
		
		Firestation firestationTest = new Firestation();
		String firestationTestString = "Firestation(address=adresse, station=3)";
		
		firestationTest.setAddress("adresse");
		firestationTest.setStation(3);

		assertEquals(firestationTestString, firestationTest.toString());
	}
	
	@Test
	public void FirestationHashCodeTest() {
		
		Firestation firestationTest = new Firestation();
		int code = firestationTest.hashCode();

		assertNotEquals(0, code);

	}
	
}
