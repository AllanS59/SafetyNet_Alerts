package com.safetynet.safetynetalerts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.repository.AppDataRepository;
import com.safetynet.safetynetalerts.repository.FirestationsRepository;
import com.safetynet.safetynetalerts.service.FirestationsService;


@Service
public class FirestationsServiceImpl implements FirestationsService {
	
	@Autowired
	private FirestationsRepository firestationsRepository;
	
	@Autowired
	private AppDataRepository appDataRepository ;

	@Override
	public Firestation[] getFirestations() {
		return firestationsRepository.getFirestationsFromAppData();
	}
	
	@Override
	public Firestation getFirestationByAddress (String address) {		
		Firestation[] firestations = appDataRepository.readDatafromJson().getFirestations(); 		
		return firestationsRepository.getFirestationByAddress(firestations, address);
	}





	@Override
	public Firestation[] getFirestationsByStation(Firestation[] firestations, int station) {
	 return firestationsRepository.getFirestationsByStation(firestations, station);
	 }

	@Override
	public void addFirestationInData(Firestation firestation) {
		firestationsRepository.addFirestationInData(firestation);
		
	}


	@Override
	public void updateFirestationInData(Firestation firestation) {
		firestationsRepository.updateFirestationInData(firestation);
		
	}


	@Override
	public void deleteFirestationInData(String address) {
		firestationsRepository.deleteFirestationInData(address);
		
	}
}
