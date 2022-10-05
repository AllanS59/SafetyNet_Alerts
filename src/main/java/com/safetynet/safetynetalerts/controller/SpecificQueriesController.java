package com.safetynet.safetynetalerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/firestation?stationNumber={station_number}")
	public PersonsByFirestationNbAdultsDTO getPersonsByStation(
			@PathVariable("station_number") final int station_number) {

		PersonsByFirestationNbAdultsDTO answer = queriesService.getPersonsByFirestationsWithCountAdults(station_number);
		return answer;
	}

	/**
	 * Read - Get all children (<18y) of one address
	 * 
	 * @param address The address to check
	 * @return A Person object full filled
	 */
	@GetMapping("/childAlert?address={address}")
	public PersonsChildrenByAddressDTO getMinorsByAddress(@PathVariable("address") final String address) {

		PersonsChildrenByAddressDTO answer = queriesService.getChildrenByAddress(address);
		return answer;

	}

	/**
	 * Read - Get all phones of people covered by a specified firestation
	 * 
	 * @param firestation_number firestation specified
	 * @return A Person object full filled
	 */
	@GetMapping("/phoneAlert?firestation={firestation_number}")
	public String[] getPhonesByStation(@PathVariable("firestation_number") final int firestation_number) {

		String[] answer = queriesService.getPhonesByFirestation(firestation_number);
		return answer;
	}

	/**
	 * Read - Get all persons from an address and indicated the corresponding
	 * firestation
	 * 
	 * @param address The address to check
	 * @return A Person object full filled
	 */
	@GetMapping("/fire?address={address}")
	public PersonsFirestationByAddressDTO getPersonsAndStationByAddress(@PathVariable("address") final String address) {

		PersonsFirestationByAddressDTO anwser = queriesService.getPersonsAndStationByAddress(address);
		return anwser;
	}

	/**
	 * Read - Get all persons from a list of Firestation number
	 * 
	 * @param StationNumbers the list of Station numbers (separated with ",")
	 * @return A Person object full filled
	 */
	@GetMapping("/flood/stations?stations={StationNumbers}")
	public AddressesPersonsByFirestationDTO[] getPersonsByStationList(
			@PathVariable("listStationNumbers") final int[] stationNumbers) {

		AddressesPersonsByFirestationDTO[] answer = queriesService.getPersonsByFirestations(stationNumbers);
		return answer;
	}

	
	
	/**
	 * Read - Get all persons from a list of Firestation number
	 * 
	 * @param StationNumbers the list of Station numbers (separated with ",")
	 * @return A Person object full filled
	 */
	@GetMapping("/personInfo?firstName={firstName}&lastName={lastName}")
	public PersonNameAddressAgeMailMedicalsDTO[] getPersonsInfoByName(@PathVariable("firstName") final String firstName,@PathVariable("lastName") final String lastName) {
			 PersonNameAddressAgeMailMedicalsDTO[] answer = queriesService.getPersonsInformation (firstName, lastName);
	return answer;
}

	
	
	/**
	 * Read - Get persons from one city
	 * 
	 * @param city The city for which we need the data
	 * @return A Person object full filled
	 */
	@GetMapping("/communityEmail?city={city}")
	public String[] getMailsByCity(@PathVariable("city") final String city) {

		String[] answer =  queriesService.getEmailsByCity(city);
		return answer;
	}

}
