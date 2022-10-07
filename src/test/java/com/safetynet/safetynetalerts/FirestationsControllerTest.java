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
public class FirestationsControllerTest {

	@Autowired
	public MockMvc mockMvc;
	
	@Test
	public void testGetFirestations () throws Exception   {
      	mockMvc.perform(get("/firestations")).andExpect(status().isOk()).andExpect(jsonPath("$[0].station", is(3)));
	}
	//@Test
	//public void testGetFirestationByAddress () throws Exception   {
    //  	mockMvc.perform(get("/firestation/489_Manchester_St")).andExpect(status().isOk()).andExpect(jsonPath("$.station", is(4)));
	//}
}
