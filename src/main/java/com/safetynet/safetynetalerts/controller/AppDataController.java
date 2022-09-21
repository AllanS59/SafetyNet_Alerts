//package com.safetynet.safetynetalerts.controller;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.converter.json.MappingJacksonValue;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fasterxml.jackson.databind.ser.FilterProvider;
//import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
//import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
//import com.safetynet.safetynetalerts.model.AppData;
//import com.safetynet.safetynetalerts.model.Person;
//import com.safetynet.safetynetalerts.service.AppDataService;
//
//@RestController
//public class AppDataController {
//	
//
//	@Autowired
//	private AppDataService appDataService;
//
//	/**
//	 * Read - Get persons covered by the station requested
//	 * 
//	 * @param station_number The station number for which all person covered shall
//	 *                       be returned
//	 * @return A Person object full filled
//	 */
//	@GetMapping("/firestation?stationNumber={station_number}")
//	public Person[] getPersonsByStation(@PathVariable("station_number") final int station_number) {
//
//		Person[] persons = appDataService.getPersonsByStation(station_number, "src/main/resources/data.json");
//
//		return persons;
//	}
//	
//
//	/**
//	 * Read - Get persons from one city
//	 * 
//	 * @param city The city for which we need the data
//	 * @return A Person object full filled
//	 */
//	@GetMapping("/communityEmail?city={city}")
//	public MappingJacksonValue getPersonsByCity(@PathVariable("city") final String city) {
//
//		Person[] persons = appDataService.getPersonsByCity(city, "src/main/resources/data.json");
//
//		List<Person> listPersons = new ArrayList<>(Arrays.asList(persons));   
//	    
//	    SimpleBeanPropertyFilter myFilter = SimpleBeanPropertyFilter. filterOutAllExcept("email");
//	    FilterProvider listOfOurFilters = new SimpleFilterProvider().addFilter("DynamicFilter", myFilter);
//	    MappingJacksonValue personsFiltered = new MappingJacksonValue(listPersons);
//	    personsFiltered.setFilters(listOfOurFilters);
//	    return personsFiltered;
//	}
//	
//}
