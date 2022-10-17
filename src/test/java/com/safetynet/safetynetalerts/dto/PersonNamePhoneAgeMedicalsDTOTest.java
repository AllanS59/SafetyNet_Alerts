package com.safetynet.safetynetalerts.dto;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonNamePhoneAgeMedicalsDTOTest {

	@Test
	public void DTOEqualsWhenEqualsTest() {
		
		PersonNamePhoneAgeMedicalsDTO DTOTest = new PersonNamePhoneAgeMedicalsDTO();
		PersonNamePhoneAgeMedicalsDTO DTOTest2 = new PersonNamePhoneAgeMedicalsDTO();
		
		DTOTest.setFirstName("Jacques");
		DTOTest.setAge(40);
		
		DTOTest2.setFirstName("Jacques");
		DTOTest2.setAge(40);

		assertEquals(true, DTOTest.equals(DTOTest2));
	}
	
	@Test
	public void DTOEqualsWhenNotEqualsTest() {
		
		PersonNamePhoneAgeMedicalsDTO DTOTest = new PersonNamePhoneAgeMedicalsDTO();
		PersonNamePhoneAgeMedicalsDTO DTOTest2 = new PersonNamePhoneAgeMedicalsDTO();
		
		DTOTest.setFirstName("Jacques");
		DTOTest.setAge(40);
		
		DTOTest2.setFirstName("Jean");
		DTOTest.setAge(40);

		assertEquals(false, DTOTest.equals(DTOTest2));
	}
	
	@Test
	public void DTOToStringTest() {
		
		PersonNamePhoneAgeMedicalsDTO DTOTest = new PersonNamePhoneAgeMedicalsDTO();
		String DTOTestString = "PersonNamePhoneAgeMedicalsDTO(firstName=Jacques, lastName=null, phone=null, age=40, medications=null, allergies=null)";
		
		DTOTest.setFirstName("Jacques");
		DTOTest.setAge(40);

		assertEquals(DTOTestString, DTOTest.toString());
	}
	
	@Test
	public void DTOHashCodeTest() {
		
		PersonNamePhoneAgeMedicalsDTO DTOTest = new PersonNamePhoneAgeMedicalsDTO();
		int code = DTOTest.hashCode();

		assertNotEquals(0, code);

	}
	
}
