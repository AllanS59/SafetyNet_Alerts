package com.safetynet.safetynetalerts.dto;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.safetynetalerts.model.Person;



@SpringBootTest
public class AddressesPersonsByFirestationDTOTest {

	
	@Test
	public void DTOEqualsWhenEqualsTest() {
		
		AddressesPersonsByFirestationDTO DTOTest = new AddressesPersonsByFirestationDTO();
		AddressesPersonsByFirestationDTO DTOTest2 = new AddressesPersonsByFirestationDTO();
		
		DTOTest.setAddress("adresse");
		DTOTest.setResidents(null);
		DTOTest2.setAddress("adresse");
		DTOTest2.setResidents(null);

		assertEquals(true, DTOTest.equals(DTOTest2));
	}
	
	@Test
	public void DTOEqualsWhenNotEqualsTest() {
		
		AddressesPersonsByFirestationDTO DTOTest = new AddressesPersonsByFirestationDTO();
		AddressesPersonsByFirestationDTO DTOTest2 = new AddressesPersonsByFirestationDTO();
		
		DTOTest.setAddress("adresse");
		DTOTest.setResidents(null);
		DTOTest2.setAddress("autreAdresse");
		DTOTest2.setResidents(null);

		assertEquals(false, DTOTest.equals(DTOTest2));
	}
	

	@Test
	public void DTOToStringTest() {
		
		AddressesPersonsByFirestationDTO DTOTest = new AddressesPersonsByFirestationDTO();
		String DTOTestString = "AddressesPersonsByFirestationDTO(address=adresse, residents=null)";
		
		DTOTest.setAddress("adresse");
		DTOTest.setResidents(null);

		assertEquals(DTOTestString, DTOTest.toString());
	}
	
	@Test
	public void DTOHashCodeTest() {
		
		AddressesPersonsByFirestationDTO DTOTest = new AddressesPersonsByFirestationDTO();
		int code = DTOTest.hashCode();

		assertNotEquals(0, code);

	}
}
