package com.safetynet.safetynetalerts.dto;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonNameAddressAgeMailMedicalsDTOTest {

	@Test
	public void DTOEqualsWhenEqualsTest() {
		
		PersonNameAddressAgeMailMedicalsDTO DTOTest = new PersonNameAddressAgeMailMedicalsDTO();
		PersonNameAddressAgeMailMedicalsDTO DTOTest2 = new PersonNameAddressAgeMailMedicalsDTO();
		
		DTOTest.setFirstName("Jacques");
		DTOTest.setAddress("adresse");
		
		DTOTest2.setFirstName("Jacques");
		DTOTest2.setAddress("adresse");

		assertEquals(true, DTOTest.equals(DTOTest2));
	}
	
	@Test
	public void DTOEqualsWhenNotEqualsTest() {
		
		PersonNameAddressAgeMailMedicalsDTO DTOTest = new PersonNameAddressAgeMailMedicalsDTO();
		PersonNameAddressAgeMailMedicalsDTO DTOTest2 = new PersonNameAddressAgeMailMedicalsDTO();
		
		DTOTest.setFirstName("Jean");
		DTOTest.setAddress("adresse");
		
		DTOTest2.setFirstName("Jacques");
		DTOTest2.setAddress("adresse2");

		assertEquals(false, DTOTest.equals(DTOTest2));
	}
	
	@Test
	public void DTOToStringTest() {
		
		PersonNameAddressAgeMailMedicalsDTO DTOTest = new PersonNameAddressAgeMailMedicalsDTO();
		String DTOTestString = "PersonNameAddressAgeMailMedicalsDTO(firstName=Jacques, lastName=null, address=adresse, age=0, email=null, medications=null, allergies=null)";
		
		DTOTest.setFirstName("Jacques");
		DTOTest.setAddress("adresse");

		assertEquals(DTOTestString, DTOTest.toString());
	}
	
	
	@Test
	public void DTOHashCodeTest() {
		
		PersonNameAddressAgeMailMedicalsDTO DTOTest = new PersonNameAddressAgeMailMedicalsDTO();
		int code = DTOTest.hashCode();

		assertNotEquals(0, code);

	}
	
}
