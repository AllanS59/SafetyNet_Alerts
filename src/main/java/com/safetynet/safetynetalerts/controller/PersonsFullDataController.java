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
//import com.safetynet.safetynetalerts.model.PersonFullData;
//import com.safetynet.safetynetalerts.service.PersonsFullDataServiceImpl;
//import com.safetynet.safetynetalerts.service.impl.AppDataServiceImpl;
//
//@RestController
//public class PersonsFullDataController {
//
//	@Autowired
//	private PersonsFullDataServiceImpl personsFullDataService;
//
//	@Autowired
//	private AppDataServiceImpl appDataService;
//
//	/**
//	 * Read - Get persons covered by the station requested
//	 * 
//	 * @param station_number The station number for which all person covered shall
//	 *                       be returned
//	 * @return A Person object full filled
//	 */
//	@GetMapping("/firestation?stationNumber={station_number}")
//	public MappingJacksonValue getPersonsByStation(@PathVariable("station_number") final int station_number) {
//
//		// Read JSON file
//		AppData appData = appDataService.readDatafromJson();
//		PersonFullData[] Allpersons = personsFullDataService.getPersonsByAppData(appData);
//
//		// Find only the persons covered by Station
//		PersonFullData[] foundPersons = personsFullDataService.getPersonsByStation(Allpersons, station_number);
//
//		// Transform Array to List and apply filters
//		List<PersonFullData> listPersons = new ArrayList<>(Arrays.asList(foundPersons));
//
//		SimpleBeanPropertyFilter myFilter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "lastName",
//				"address", "phone");
//		FilterProvider listOfOurFilters = new SimpleFilterProvider().addFilter("DynamicFilterFullData", myFilter);
//		MappingJacksonValue personsFiltered = new MappingJacksonValue(listPersons);
//		personsFiltered.setFilters(listOfOurFilters);
//		return personsFiltered;
////**************************************************
//		// TODO: AJOUTER DECOMPTE ENFANTS/ADULTES
////**************************************************
//	}
//
//	
//	
//	/**
//	 * Read - Get all children (<18y) of one address
//	 * 
//	 * @param address The address to check
//	 * @return A Person object full filled
//	 */
//	@GetMapping("/childAlert?address={address}")
//	public MappingJacksonValue getMinorsByAddress(@PathVariable("address") final String address) {
//
//		// Read JSON file
//		AppData appData = appDataService.readDatafromJson();
//		PersonFullData[] Allpersons = personsFullDataService.getPersonsByAppData(appData);
//
//		// Find only the persons from the address
//		PersonFullData[] personsByAddress = personsFullDataService.getPersonsByAddress(Allpersons, address);
//
//		// Find only the children in that address
//		PersonFullData[] minorPersonsByAddress = personsFullDataService.getPersonsByMaxAge(personsByAddress, 18);
//
//		// Transform Array to List and apply filters
//		List<PersonFullData> listPersons = new ArrayList<>(Arrays.asList(minorPersonsByAddress));
//
//		SimpleBeanPropertyFilter myFilter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "lastName",
//				"birthdate");
//		FilterProvider listOfOurFilters = new SimpleFilterProvider().addFilter("DynamicFilterFullData", myFilter);
//		MappingJacksonValue personsFiltered = new MappingJacksonValue(listPersons);
//		personsFiltered.setFilters(listOfOurFilters);
//		return personsFiltered;
//		
////**************************************************
//		// TODO: - replace the returned Birthdate by Age
//		// - all return the adult members of the address
////**************************************************
//	}
//
//	
//	
//	/**
//	 * Read - Get all phones of people covered by a specified firestation
//	 * 
//	 * @param firestation_number firestation specified
//	 * @return A Person object full filled
//	 */
//	@GetMapping("/phoneAlert?firestation={firestation_number}")
//	public MappingJacksonValue getPhonesByStation(@PathVariable("firestation_number") final int firestation_number) {
//
//		// Read JSON file
//		AppData appData = appDataService.readDatafromJson();
//		PersonFullData[] Allpersons = personsFullDataService.getPersonsByAppData(appData);
//
//		// Find only the persons covered by the firestation
//		PersonFullData[] personsByStation = personsFullDataService.getPersonsByStation(Allpersons, firestation_number);
//
//		// Transform Array to List and apply filters
//		List<PersonFullData> listPersons = new ArrayList<>(Arrays.asList(personsByStation));
//
//		SimpleBeanPropertyFilter myFilter = SimpleBeanPropertyFilter.filterOutAllExcept("phone");
//		FilterProvider listOfOurFilters = new SimpleFilterProvider().addFilter("DynamicFilterFullData", myFilter);
//		MappingJacksonValue personsFiltered = new MappingJacksonValue(listPersons);
//		personsFiltered.setFilters(listOfOurFilters);
//		return personsFiltered;
//	}
//
//	
//	
//	/**
//	 * Read - Get all persons from an address and indicated the corresponding
//	 * firestation
//	 * 
//	 * @param address The address to check
//	 * @return A Person object full filled
//	 */
//	@GetMapping("/fire?address={address}")
//	public MappingJacksonValue getPersonsAndStationByAddress(@PathVariable("address") final String address) {
//
//		// Read JSON file
//		AppData appData = appDataService.readDatafromJson();
//		PersonFullData[] Allpersons = personsFullDataService.getPersonsByAppData(appData);
//
//		// Find only the persons from the address
//		PersonFullData[] personsByAddress = personsFullDataService.getPersonsByAddress(Allpersons, address);
//
//		// Transform Array to List and apply filters
//		List<PersonFullData> listPersons = new ArrayList<>(Arrays.asList(personsByAddress));
//
//		SimpleBeanPropertyFilter myFilter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "lastName",
//				"phone", "birthdate", "medications", "allergies");
//		FilterProvider listOfOurFilters = new SimpleFilterProvider().addFilter("DynamicFilterFullData", myFilter);
//		MappingJacksonValue personsFiltered = new MappingJacksonValue(listPersons);
//		personsFiltered.setFilters(listOfOurFilters);
//		return personsFiltered;
//
////**************************************************		
//		// TODO: - replace the returned Birthdate by Age
//		// - add the corresponding station number
////**************************************************
//	}
//
//	
//	
//	/**
//	 * Read - Get all persons from a list of Firestation number
//	 * 
//	 * @param StationNumbers the list of Station numbers (separated with ",")
//	 * @return A Person object full filled
//	 */
//	@GetMapping("/flood/stations?stations={StationNumbers}")
//	public MappingJacksonValue getPersonsByStationList(@PathVariable("listStationNumbers") final int[] StationNumbers) {
//
//		// Read JSON file
//		AppData appData = appDataService.readDatafromJson();
//		PersonFullData[] Allpersons = personsFullDataService.getPersonsByAppData(appData);
//
//		// Create a list of Person and add all persons covererd by one of the station
//		// numbers
//		List<PersonFullData> listPersons = new ArrayList<>();
//		for (int i : StationNumbers) {
//			for (PersonFullData p : Allpersons) {
//				if (i == p.getStation()) {
//					listPersons.add(p);
//				}
//			}
//		}
//
//		// Apply filters
//		SimpleBeanPropertyFilter myFilter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "lastName",
//				"phone", "birthdate", "medications", "allergies");
//		FilterProvider listOfOurFilters = new SimpleFilterProvider().addFilter("DynamicFilterFullData", myFilter);
//		MappingJacksonValue personsFiltered = new MappingJacksonValue(listPersons);
//		personsFiltered.setFilters(listOfOurFilters);
//		return personsFiltered;
//
////**************************************************
//		// TODO: - replace the returned Birthdate by Age
//		// 		 - regrouper les personnes par addresses
////**************************************************
//	}
//
//	
//	
//	/**
//	 * Read - Get all persons from a list of Firestation number
//	 * 
//	 * @param StationNumbers the list of Station numbers (separated with ",")
//	 * @return A Person object full filled
//	 */
//	@GetMapping("/personInfo?firstName={firstName}&lastName={lastName}")
//	public MappingJacksonValue getPersonsInfoByName(@PathVariable("firstName") final String firstName,
//			@PathVariable("lastName") final String lastName) {
//
//		// Read JSON file
//		AppData appData = appDataService.readDatafromJson();
//		PersonFullData[] Allpersons = personsFullDataService.getPersonsByAppData(appData);
//
//		// Find only the persons by Name
//		PersonFullData personsByName = personsFullDataService.getPersonByFirstNameAndLastName(Allpersons, firstName,
//				lastName);
//
//		// Transform Array to List and apply filters
//		List<PersonFullData> listPersons = new ArrayList<>(Arrays.asList(personsByName));
//
//		SimpleBeanPropertyFilter myFilter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "lastName",
//				"address", "birthdate", "email", "medications", "allergies");
//		FilterProvider listOfOurFilters = new SimpleFilterProvider().addFilter("DynamicFilterFullData", myFilter);
//		MappingJacksonValue personsFiltered = new MappingJacksonValue(listPersons);
//		personsFiltered.setFilters(listOfOurFilters);
//		return personsFiltered;
//		
////**************************************************
//		// TODO: - replace the returned Birthdate by Age
//		// - couvrir le cas où plusieurs persones ont le même nom
////**************************************************
//	}
//
//	
//	
//	/**
//	 * Read - Get persons from one city
//	 * 
//	 * @param city The city for which we need the data
//	 * @return A Person object full filled
//	 */
//	@GetMapping("/communityEmail?city={city}")
//	public MappingJacksonValue getMailsByCity(@PathVariable("city") final String city) {
//
//		// Read JSON file
//		AppData appData = appDataService.readDatafromJson();
//		PersonFullData[] Allpersons = personsFullDataService.getPersonsByAppData(appData);
//
//		// Find only the persons in the city
//		PersonFullData[] foundPersons = personsFullDataService.getPersonsByCity(Allpersons, city);
//
//		List<PersonFullData> listPersons = new ArrayList<>(Arrays.asList(foundPersons));
//
//		SimpleBeanPropertyFilter myFilter = SimpleBeanPropertyFilter.filterOutAllExcept("email");
//		FilterProvider listOfOurFilters = new SimpleFilterProvider().addFilter("DynamicFilterFullData", myFilter);
//		MappingJacksonValue personsFiltered = new MappingJacksonValue(listPersons);
//		personsFiltered.setFilters(listOfOurFilters);
//		return personsFiltered;
//	}
//}
