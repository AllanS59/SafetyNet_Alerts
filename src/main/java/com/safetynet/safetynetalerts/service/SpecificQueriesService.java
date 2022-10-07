package com.safetynet.safetynetalerts.service;

import com.safetynet.safetynetalerts.dto.AddressesPersonsByFirestationDTO;
import com.safetynet.safetynetalerts.dto.PersonNameAddressAgeMailMedicalsDTO;
import com.safetynet.safetynetalerts.dto.PersonsByFirestationNbAdultsDTO;
import com.safetynet.safetynetalerts.dto.PersonsChildrenByAddressDTO;
import com.safetynet.safetynetalerts.dto.PersonsFirestationByAddressDTO;


public interface SpecificQueriesService {

	/**
	 * get needed information of people covered by a specific firestation, with count of adults and children
	 * @param station number of the firestation requested
	 * @return PersonsByFirestationNbAdultsDTO DTO object containing several information
	 */
	public PersonsByFirestationNbAdultsDTO getPersonsByFirestationsWithCountAdults(int station);
	
	/**
	 * get list of children living in a specific address, with also of others livers
	 * @param address the address requested
	 * @return PersonsChildrenByAddressDTO DTO object containing several information
	 */
	public PersonsChildrenByAddressDTO getChildrenByAddress(String address);
	
	/**
	 * get list of phone numbers from people covered by a specific Firestation
	 * @param station number of the firestation requested
	 * @return PersonsPhonesByFirestationDTO DTO object containing several information
	 */
	public String[] getPhonesByFirestation(int station);
	
	/**
	 * get list of persons from a specific address and precise the corresponding firestation
	 * @param station number of the firestation requested
	 * @return PersonsFirestationByAddressDTO DTO object containing several information
	 */
	public PersonsFirestationByAddressDTO getPersonsAndStationByAddress (String address);
	
	/**
	 * get list of persons, sorted by addresses, covered by a specific firestation
	 * @param station number of the firestation requested
	 * @return AddressesPersonsByFirestationDTO DTO object containing several information
	 */
	public AddressesPersonsByFirestationDTO[] getPersonsByFirestations (int[] station);
	
	/**
	 * get information for a specific person (search by name)
	 * @param firstName the firstname of the person we search
	 * @param lastName the lastname of the person we search
	 * @return PersonNameAddressAgeMailMedicalsDTO DTO object containing several information
	 */
	public PersonNameAddressAgeMailMedicalsDTO getPersonsInformation (String firstName, String lastName);
	
	/**
	 * get list of emails of people from a specific city
	 * @param city the city we search
	 * @return String[] a list of emails
	 */
	public String[] getEmailsByCity (String city);
}
