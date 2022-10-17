package com.safetynet.safetynetalerts.dto;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonsChildrenByAddressDTOTest {


	@Test
	public void DTOEqualsWhenEqualsTest() {
		
		PersonsChildrenByAddressDTO DTOTest = new PersonsChildrenByAddressDTO();
		PersonsChildrenByAddressDTO DTOTest2 = new PersonsChildrenByAddressDTO();
		
		PersonNameAgeDTO[] person = new PersonNameAgeDTO[1];
		person[0] = new PersonNameAgeDTO();
		person[0].setFirstName("Jacques");
		person[0].setAge(40);

		DTOTest.setListChildren(person);
		DTOTest2.setListChildren(person);

		assertEquals(true, DTOTest.equals(DTOTest2));
	}
	
	
	@Test
	public void DTOEqualsWhenNotEqualsTest() {
		
		PersonsChildrenByAddressDTO DTOTest = new PersonsChildrenByAddressDTO();
		PersonsChildrenByAddressDTO DTOTest2 = new PersonsChildrenByAddressDTO();
		
		PersonNameAgeDTO[] person = new PersonNameAgeDTO[1];
		person[0] = new PersonNameAgeDTO();
		person[0].setFirstName("Jacques");
		person[0].setAge(40);

		DTOTest.setListChildren(person);

		assertEquals(false, DTOTest.equals(DTOTest2));
	}
	
	@Test
	public void DTOToStringTest() {
		
		PersonsChildrenByAddressDTO DTOTest = new PersonsChildrenByAddressDTO();
		String DTOTestString = "PersonsChildrenByAddressDTO(listChildren=[PersonNameAgeDTO(firstName=Jacques, lastName=null, age=40)], listAdults=null)";
		
		PersonNameAgeDTO[] person = new PersonNameAgeDTO[1];
		person[0] = new PersonNameAgeDTO();
		person[0].setFirstName("Jacques");
		person[0].setAge(40);

		DTOTest.setListChildren(person);

		assertEquals(DTOTestString, DTOTest.toString());
	}
	
	@Test
	public void DTOHashCodeTest() {
		
		PersonsChildrenByAddressDTO DTOTest = new PersonsChildrenByAddressDTO();
		int code = DTOTest.hashCode();

		assertNotEquals(0, code);

	}
	
}
