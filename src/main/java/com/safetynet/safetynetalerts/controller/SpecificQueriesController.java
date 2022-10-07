package com.safetynet.safetynetalerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalerts.dto.AddressesPersonsByFirestationDTO;
import com.safetynet.safetynetalerts.dto.PersonNameAddressAgeMailMedicalsDTO;
import com.safetynet.safetynetalerts.dto.PersonsByFirestationNbAdultsDTO;
import com.safetynet.safetynetalerts.dto.PersonsChildrenByAddressDTO;
import com.safetynet.safetynetalerts.dto.PersonsFirestationByAddressDTO;
import com.safetynet.safetynetalerts.service.SpecificQueriesService;

@RestController
public class SpecificQueriesController {

	@Autowired
	private SpecificQueriesService queriesService;

	/**
	 * Read - Get persons covered by the station requested
	 * 
	 * @param station_number The station number for which all person covered shall
	 *                       be returned
	 * @return A Person object full filled
	 */
	@GetMapping("/firestation")
	public PersonsByFirestationNbAdultsDTO getPersonsByStation(	@RequestParam(name = "stationNumber") int station_number) {

		PersonsByFirestationNbAdultsDTO answer = queriesService.getPersonsByFirestationsWithCountAdults(station_number);
		return answer;
	}

	/**
	 * Read - Get all children (<18y) of one address
	 * 
	 * @param address The address to check
	 * @return A Person object full filled
	 */
	@GetMapping("/childAlert")
	public PersonsChildrenByAddressDTO getMinorsByAddress(@RequestParam(name = "address") String address) {

		PersonsChildrenByAddressDTO answer = queriesService.getChildrenByAddress(address);
		return answer;

	}

	/**
	 * Read - Get all phones of people covered by a specified firestation
	 * 
	 * @param firestation_number firestation specified
	 * @return A Person object full filled
	 */
	@GetMapping("/phoneAlert")
	public String[] getPhonesByStation(@RequestParam(name = "firestation") int station_number) {

		String[] answer = queriesService.getPhonesByFirestation(station_number);
		return answer;
	}

	/**
	 * Read - Get all persons from an address and indicated the corresponding
	 * firestation
	 * 
	 * @param address The address to check
	 * @return A Person object full filled
	 */
	@GetMapping("/fire")
	public PersonsFirestationByAddressDTO getPersonsAndStationByAddress(@RequestParam(name = "address") String address) {

		PersonsFirestationByAddressDTO anwser = queriesService.getPersonsAndStationByAddress(address);
		return anwser;
	}

	/**
	 * Read - Get all persons from a list of Firestation number
	 * 
	 * @param StationNumbers the list of Station numbers (separated with ",")
	 * @return A Person object full filled
	 */
	@GetMapping("/flood/stations")
	public AddressesPersonsByFirestationDTO[] getPersonsByStationList(@RequestParam(name = "stations") int[] stationNumbers) {

		AddressesPersonsByFirestationDTO[] answer = queriesService.getPersonsByFirestations(stationNumbers);
		return answer;
	}

	
	
	/**
	 * Read - Get all persons from a list of Firestation number
	 * 
	 * @param StationNumbers the list of Station numbers (separated with ",")
	 * @return A Person object full filled
	 */
	@GetMapping("/personInfo")
	public PersonNameAddressAgeMailMedicalsDTO getPersonsInfoByName(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
			 System.out.println(firstName);
			 System.out.println(lastName);
			 
		
		PersonNameAddressAgeMailMedicalsDTO answer = queriesService.getPersonsInformation (firstName, lastName);
	return answer;
}

	
	
	/**
	 * Read - Get persons from one city
	 * 
	 * @param city The city for which we need the data
	 * @return A Person object full filled
	 */
	@GetMapping("/communityEmail")
	public String[] getMailsByCity(@RequestParam(name = "city") String city) {

		String[] answer =  queriesService.getEmailsByCity(city);
		return answer;
	}

}
