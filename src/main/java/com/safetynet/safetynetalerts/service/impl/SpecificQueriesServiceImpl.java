package com.safetynet.safetynetalerts.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalerts.dto.AddressesPersonsByFirestationDTO;
import com.safetynet.safetynetalerts.dto.PersonNameAddressAgeMailMedicalsDTO;
import com.safetynet.safetynetalerts.dto.PersonNameAddressPhoneDTO;
import com.safetynet.safetynetalerts.dto.PersonNameAgeDTO;
import com.safetynet.safetynetalerts.dto.PersonNameDTO;
import com.safetynet.safetynetalerts.dto.PersonsByFirestationNbAdultsDTO;
import com.safetynet.safetynetalerts.dto.PersonsChildrenByAddressDTO;
import com.safetynet.safetynetalerts.dto.PersonsFirestationByAddressDTO;
import com.safetynet.safetynetalerts.dto.PersonsPhonesByFirestationDTO;
import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.model.MedicalRecord;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.repository.FirestationsRepository;
import com.safetynet.safetynetalerts.repository.MedicalRecordsRepository;
import com.safetynet.safetynetalerts.repository.PersonsRepository;
import com.safetynet.safetynetalerts.service.PersonsService;
import com.safetynet.safetynetalerts.service.SpecificQueriesService;

@Service
public class SpecificQueriesServiceImpl implements SpecificQueriesService {

	@Autowired
	private PersonsRepository personsRepo;

	@Autowired
	private FirestationsRepository firestationsRepo;

	@Autowired
	private MedicalRecordsRepository medicalRecordsRepo;

	@Autowired
	private PersonsService personsService;

	@Override
	public PersonsByFirestationNbAdultsDTO getPersonsByFirestationsWithCountAdults(int station) {

		// Get information from the data
		Firestation[] allFirestations = firestationsRepo.getFirestationsFromAppData();
		Person[] allPersons = personsRepo.getPersonsFromAppData();
		MedicalRecord[] allMedicalRecords = medicalRecordsRepo.getMedicalRecordsFromData();

		// initialize variables
		List<PersonNameAddressPhoneDTO> listfoundPersons = new ArrayList<PersonNameAddressPhoneDTO>();
		PersonsByFirestationNbAdultsDTO personsByFirestationNbAdultsDTO = new PersonsByFirestationNbAdultsDTO();
		int countChildren = 0;
		int countAdults = 0;
		int NbAdultsInAddress = 0;
		int NbChildrenInAddress = 0;

		// Get all Firestations related to the requested station number
		Firestation[] foundFirestations = firestationsRepo.getFirestationsByStation(allFirestations, station);

		// For each firestation found, get all persons living in the address
		for (Firestation f : foundFirestations) {
			Person[] personsByAddress = personsRepo.getPersonsByAddress(allPersons, f.getAddress());

			// For each person of that address, report the information into the DTO
			for (Person p : personsByAddress) {
				PersonNameAddressPhoneDTO personDTO = new PersonNameAddressPhoneDTO();
				personDTO.setFirstName(p.getFirstName());
				personDTO.setLastName(p.getLastName());
				personDTO.setAddress(p.getAddress());
				personDTO.setPhone(p.getPhone());

				listfoundPersons.add(personDTO);
			}

			// For each address, count the number of adults and children
			NbChildrenInAddress = medicalRecordsRepo.countChildrenFromPersonsArray(personsByAddress, allMedicalRecords);
			NbAdultsInAddress = personsByAddress.length - NbChildrenInAddress;
			countChildren = countChildren + NbChildrenInAddress;
			countAdults = countAdults + NbAdultsInAddress;
		}

		// Set the information into DTO
		PersonNameAddressPhoneDTO[] foundPersonsDTO = listfoundPersons.toArray(new PersonNameAddressPhoneDTO[0]);
		personsByFirestationNbAdultsDTO.setPersons(foundPersonsDTO);
		personsByFirestationNbAdultsDTO.setNumberChildren(countChildren);
		personsByFirestationNbAdultsDTO.setNumberAdults(countAdults);

		return personsByFirestationNbAdultsDTO;
	}

	@Override
	public PersonsChildrenByAddressDTO getChildrenByAddress(String address) {
		// initialize data
		MedicalRecord[] allMedicalRecords = medicalRecordsRepo.getMedicalRecordsFromData();
		List<PersonNameAgeDTO> listChildren = new ArrayList<PersonNameAgeDTO>();
		List<PersonNameDTO> listAdults = new ArrayList<PersonNameDTO>();

		// get all persons living in the address
		Person[] allResidents = personsService.getPersonByAddress(address);

		// For each person, add to the corresponding list depending on address
		for (Person p : allResidents) {
			MedicalRecord medicalRecord = medicalRecordsRepo.getMedicalRecordByFirstNameAndLastName(allMedicalRecords,
					p.getFirstName(), p.getLastName());
			int age = medicalRecordsRepo.getAge(medicalRecord);
			if (age < 18) {
				PersonNameAgeDTO children = new PersonNameAgeDTO();
				children.setFirstName(p.getFirstName());
				children.setLastName(p.getLastName());
				children.setAge(age);
				listChildren.add(children);
			} else {
				PersonNameDTO adult = new PersonNameDTO();
				adult.setFirstName(p.getFirstName());
				adult.setLastName(p.getLastName());
				listAdults.add(adult);
			}
		}

		// Transform the lists into DTO
		PersonNameAgeDTO[] personNameAgeDTO = listChildren.toArray(new PersonNameAgeDTO[0]);
		PersonNameDTO[] personNameDTO = listAdults.toArray(new PersonNameDTO[0]);

		PersonsChildrenByAddressDTO personsChildrenByAddressDTO = new PersonsChildrenByAddressDTO();
		personsChildrenByAddressDTO.setListChildren(personNameAgeDTO);
		personsChildrenByAddressDTO.setListAdults(personNameDTO);

		return personsChildrenByAddressDTO;
	}

	@Override
	public String[] getPhonesByFirestation(int station) {

		// Initialize Data
		List<String> phonesList = new ArrayList<String>();
		Firestation[] allFirestations = firestationsRepo.getFirestationsFromAppData();
		Person[] allPersons = personsRepo.getPersonsFromAppData();

		// Get all Firestations related to the requested station number
		Firestation[] foundFirestations = firestationsRepo.getFirestationsByStation(allFirestations, station);

		// For each firestation found, get all persons living in the address
		for (Firestation f : foundFirestations) {
			Person[] personsByAddress = personsRepo.getPersonsByAddress(allPersons, f.getAddress());

			// For each person of that address, get phone number
			for (Person p : personsByAddress) {
				phonesList.add(p.getPhone());
			}
		}
		
		//Convert info from list to DTO
		String[] phones = phonesList.toArray(new String[0]);
		
		return phones;
	}

	@Override
	public PersonsFirestationByAddressDTO getPersonsAndStationByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressesPersonsByFirestationDTO[] getPersonsByFirestations(int[] station) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonNameAddressAgeMailMedicalsDTO[] getPersonsInformation(String firstName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getEmailsByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

}
