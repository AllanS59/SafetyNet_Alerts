package com.safetynet.safetynetalerts.dto;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonNameDTOTest {

	@Test
	public void DTOEqualsWhenEqualsTest() {
		
		PersonNameDTO DTOTest = new PersonNameDTO();
		PersonNameDTO DTOTest2 = new PersonNameDTO();
		
		DTOTest.setFirstName("Jacques");
		DTOTest2.setFirstName("Jacques");

		assertEquals(true, DTOTest.equals(DTOTest2));
	}
	
	@Test
	public void DTOEqualsWhenNotEqualsTest() {
		
		PersonNameDTO DTOTest = new PersonNameDTO();
		PersonNameDTO DTOTest2 = new PersonNameDTO();
		
		DTOTest.setFirstName("Jacques");
		DTOTest2.setFirstName("Jean");

		assertEquals(false, DTOTest.equals(DTOTest2));
	}
	
	@Test
	public void DTOToStringTest() {
		
		PersonNameDTO DTOTest = new PersonNameDTO();
		String DTOTestString = "PersonNameDTO(firstName=Jacques, lastName=null)";
		
		DTOTest.setFirstName("Jacques");

		assertEquals(DTOTestString,DTOTest.toString());
	}
	
	@Test
	public void DTOHashCodeTest() {
		
		PersonNameDTO DTOTest = new PersonNameDTO();
		int code = DTOTest.hashCode();

		assertNotEquals(0, code);

	}
}
