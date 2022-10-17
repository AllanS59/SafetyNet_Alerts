package com.safetynet.safetynetalerts.model;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonTest {

	@Test
	public void PersonGettersAndSettersTest() {
		
		Person personTest = new Person();;
		
		personTest.setFirstName("prenom");
		personTest.setLastName("nom");
		personTest.setAddress("adresse");
		personTest.setZip("1234");
		personTest.setCity("ville");
		personTest.setPhone("11-555-22");
		personTest.setEmail("mail@mail.fr");

		assertEquals("prenom", personTest.getFirstName());
		assertEquals("nom", personTest.getLastName());
		assertEquals("adresse", personTest.getAddress());
		assertEquals("1234", personTest.getZip());
		assertEquals("ville", personTest.getCity());
		assertEquals("11-555-22", personTest.getPhone());
		assertEquals("mail@mail.fr", personTest.getEmail());
	}
	
	
	@Test
	public void PersonEqualsWhenEqualsTest() {
		
		Person personTest = new Person();
		Person personTest2 = new Person();
		
		personTest.setFirstName("prenom");
		personTest.setLastName("nom");
		personTest.setAddress("adresse");
		personTest.setZip("1234");
		personTest.setCity("ville");
		personTest.setPhone("11-555-22");
		personTest.setEmail("mail@mail.fr");
		
		personTest2.setFirstName("prenom");
		personTest2.setLastName("nom");
		personTest2.setAddress("adresse");
		personTest2.setZip("1234");
		personTest2.setCity("ville");
		personTest2.setPhone("11-555-22");
		personTest2.setEmail("mail@mail.fr");

		assertEquals(true, personTest.equals(personTest2));
	}
	
	@Test
	public void PersonEqualsWhenNotEqualsTest() {
		
		Person personTest = new Person();
		Person personTest2 = new Person();
		
		personTest.setFirstName("prenom");
		personTest.setLastName("nom");
		personTest.setAddress("adresse");
		personTest.setZip("1234");
		personTest.setCity("ville");
		personTest.setPhone("11-555-22");
		personTest.setEmail("mail@mail.fr");
		
		personTest2.setFirstName("AutrePrenom");
		personTest2.setLastName("nom");
		personTest2.setAddress("adresse");
		personTest2.setZip("1234");
		personTest2.setCity("ville");
		personTest2.setPhone("11-555-22");
		personTest2.setEmail("mail@mail.fr");

		assertEquals(false, personTest.equals(personTest2));
	}
	
	
	
	@Test
	public void PersonToStringTest() {
		
		String personTestString = "Person(firstName=prenom, lastName=nom, address=adresse, city=ville, zip=1234, phone=11-555-22, email=mail@mail.fr)";
		Person personTest = new Person();
		
		personTest.setFirstName("prenom");
		personTest.setLastName("nom");
		personTest.setAddress("adresse");
		personTest.setZip("1234");
		personTest.setCity("ville");
		personTest.setPhone("11-555-22");
		personTest.setEmail("mail@mail.fr");

		assertEquals(personTestString, personTest.toString());

	}
	
	@Test
	public void PersonHashCodeTest() {
		
		Person personTest = new Person();
		int code = personTest.hashCode();

		assertNotEquals(0, code);

	}
	
}
