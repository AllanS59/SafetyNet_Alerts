package com.safetynet.safetynetalerts.dto;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonsByFirestationNbAdultsDTOTest {

	@Test
	public void DTOEqualsWhenEqualsTest() {
		
		PersonsByFirestationNbAdultsDTO DTOTest = new PersonsByFirestationNbAdultsDTO();
		PersonsByFirestationNbAdultsDTO DTOTest2 = new PersonsByFirestationNbAdultsDTO();
		
		DTOTest.setNumberAdults(2);
		DTOTest2.setNumberAdults(2);

		assertEquals(true, DTOTest.equals(DTOTest2));
	}
	
	@Test
	public void DTOEqualsWhenNotEqualsTest() {
		
		PersonsByFirestationNbAdultsDTO DTOTest = new PersonsByFirestationNbAdultsDTO();
		PersonsByFirestationNbAdultsDTO DTOTest2 = new PersonsByFirestationNbAdultsDTO();
		
		DTOTest.setNumberAdults(2);
		DTOTest2.setNumberAdults(3);

		assertEquals(false, DTOTest.equals(DTOTest2));
	}
	
	@Test
	public void DTOToStringTest() {
		
		PersonsByFirestationNbAdultsDTO DTOTest = new PersonsByFirestationNbAdultsDTO();
		String DTOTestString = "PersonsByFirestationNbAdultsDTO(persons=null, numberChildren=0, numberAdults=2)";
		
		DTOTest.setNumberAdults(2);

		assertEquals(DTOTestString, DTOTest.toString());
	}
	
	@Test
	public void DTOHashCodeTest() {
		
		PersonsByFirestationNbAdultsDTO DTOTest = new PersonsByFirestationNbAdultsDTO();
		int code = DTOTest.hashCode();

		assertNotEquals(0, code);

	}
	
}
