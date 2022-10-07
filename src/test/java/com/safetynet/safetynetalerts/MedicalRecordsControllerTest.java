package com.safetynet.safetynetalerts;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MedicalRecordsControllerTest {

	@Autowired
	public MockMvc mockMvc;
	
	@Test
	public void testGetMedicalRecords () throws Exception   {
      	mockMvc.perform(get("/medicalRecords")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", is("John")));
	}
	
	@Test
	public void testGetMedicalRecordByName () throws Exception   {
      	mockMvc.perform(get("/medicalRecord?firstName=Jonanathan&lastName=Marrack")).andExpect(status().isOk()).andExpect(jsonPath("$.birthdate", is("01/03/1989")));
	}
}
