//package com.safetynet.safetynetalerts;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class PersonsFullDataDataControllerTest {
//	
//	@Autowired
//	public MockMvc mockMvc;
	
//	@Test
//	public void testGetPersonsByStation () throws Exception   {
//      	mockMvc.perform(get("/firestation?stationNumber=1")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", is("Peter")));
//	}
//	
//	
//	@Test
//	public void testGetChildrenByAddress () throws Exception   {
//      	mockMvc.perform(get("/childAlert?address=1509_Culver_St")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", is("Tenley")));
//	}
//	
//	
//	@Test
//	public void testGetPhoneByStation () throws Exception   {
//      	mockMvc.perform(get("/phoneAlert?firestation=1")).andExpect(status().isOk()).andExpect(jsonPath("$[0].phone", is("841-874-6512")));
//	}
//	
//	
//	@Test
//	public void testGetPersonsByAddress () throws Exception   {
//      	mockMvc.perform(get("/fire?address=112_Steppes_Pl")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", is("Tony")));
//	}
//	
//	
//	@Test
//	public void testGetAddressesByStations () throws Exception   {
//      	mockMvc.perform(get("/flood/stations?stations=1,2")).andExpect(status().isOk()).andExpect(jsonPath("$[0].address", is("29 15th St")));
//	}
//	
//	
//	@Test
//	public void testPersonsInfosByName () throws Exception   {
//      	mockMvc.perform(get("/personInfo?firstName=Jonanathan&lastName=Marrack")).andExpect(status().isOk()).andExpect(jsonPath("$[0].firstName", is("Jonanathan")));
//	}
//	
//	
//	@Test
//	public void testGetEmailssByCity () throws Exception   {
//      	mockMvc.perform(get("/communityEmail?city=Culver")).andExpect(status().isOk()).andExpect(jsonPath("$[0].email", is("841-874-6512")));
//	}

//}
