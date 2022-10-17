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
public class FirestationsControllerTest {

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
	public void testGetFirestations () throws Exception   {
      	mockMvc.perform(get("/firestations")).andExpect(status().isOk()).andExpect(jsonPath("$[0].station", is(3)));
	}
	
	@Test
	public void testPostFirestation() throws Exception {

		String jsonFirestation = "{\"address\":\"555 fake ad\", \"station\":\"5\" }";

		mockMvc.perform(
				post("/firestation").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(jsonFirestation))
				.andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testPutFirestation() throws Exception {

		String jsonFirestation = "{\"address\":\"29 15th St\", \"station\":\"1\" }";

		mockMvc.perform(
				put("/firestation").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(jsonFirestation))
				.andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testDeleteFirestation() throws Exception {

		mockMvc.perform(delete("/firestation?address=834 Binoc Ave"))
				.andExpect(status().isOk());
	}
}
