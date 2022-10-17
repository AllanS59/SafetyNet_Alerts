package com.safetynet.safetynetalerts.dto;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonsFirestationByAddressDTOTest {

	@Test
	public void DTOEqualsWhenEqualsTest() {
		
		PersonsFirestationByAddressDTO DTOTest = new PersonsFirestationByAddressDTO();
		PersonsFirestationByAddressDTO DTOTest2 = new PersonsFirestationByAddressDTO();
		
		DTOTest.setStation(1);
		DTOTest2.setStation(1);
		
		assertEquals(true, DTOTest.equals(DTOTest2));
	}
	
	@Test
	public void DTOEqualsWhenNotEqualsTest() {
		
		PersonsFirestationByAddressDTO DTOTest = new PersonsFirestationByAddressDTO();
		PersonsFirestationByAddressDTO DTOTest2 = new PersonsFirestationByAddressDTO();
		
		DTOTest.setStation(1);
		DTOTest2.setStation(2);
		
		assertEquals(false, DTOTest.equals(DTOTest2));
	}
	
	@Test
	public void DTOToStringTest() {
		
		PersonsFirestationByAddressDTO DTOTest = new PersonsFirestationByAddressDTO();
		String DTOTestString = "PersonsFirestationByAddressDTO(residents=null, station=1)";
		
		DTOTest.setStation(1);
		
		assertEquals(DTOTestString, DTOTest.toString());
	}
	
	@Test
	public void DTOHashCodeTest() {
		
		PersonsFirestationByAddressDTO DTOTest = new PersonsFirestationByAddressDTO();
		int code = DTOTest.hashCode();

		assertNotEquals(0, code);

	}
}
