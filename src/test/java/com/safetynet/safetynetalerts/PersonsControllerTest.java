package com.safetynet.safetynetalerts;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.safetynet.safetynetalerts.model.AppData;
import com.safetynet.safetynetalerts.repository.AppDataRepository;


@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
public class PersonsControllerTest {

	@Autowired
	public MockMvc mockMvc;
	
	@Autowired
	private AppDataRepository appDataRepo;
	
	public static  AppData initialData;
	
	
	@BeforeAll
	public void saveInitialdata() {
		initialData = appDataRepo.readDatafromJson();
	}
	
	@AfterAll
	public void getBackToInitialData() {
		appDataRepo.writeDataInJson(initialData);
	}
	

	@Test
	public void testGetPersons() throws Exception {
		mockMvc.perform(get("/persons")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", is("John")));
	}

	@Test
	public void testGetPersonByName() throws Exception {
		mockMvc.perform(get("/person?firstName=Jonanathan&lastName=Marrack")).andExpect(status().isOk())
				.andExpect(jsonPath("$.firstName", is("Jonanathan")));
	}

	@Test
	public void testPostPerson() throws Exception {

		String jsonPerson = "{\"firstName\":\"Jean\",\"lastName\":\"Test\",\"address\":\"04 fake ad\",\"city\":\"City\",\"zip\":\"55555\",\"phone\":\"111-555-1234\",\"email\":\"fake@email.com\"}";

		mockMvc.perform(
				post("/person").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(jsonPerson))
				.andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testPutPerson() throws Exception {

		String jsonPerson = "{\"firstName\":\"Felicia\",\"lastName\":\"Boyd\",\"address\":\"new ad\",\"city\":\"NewCity\",\"zip\":\"55555\",\"phone\":\"111-555-1234\",\"email\":\"newfake@email.com\"}";

		mockMvc.perform(
				put("/person").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(jsonPerson))
				.andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testDeletePerson() throws Exception {

		mockMvc.perform(delete("/person?firstName=Kendrik&lastName=Stelzer"))
				.andExpect(status().isOk());
	}
}
