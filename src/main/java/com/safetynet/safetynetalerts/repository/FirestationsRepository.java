package com.safetynet.safetynetalerts.repository;

import org.springframework.stereotype.Repository;

import com.safetynet.safetynetalerts.model.Firestation;


@Repository
public interface FirestationsRepository {

	Firestation[] getFirestationsFromAppData();
	
	Firestation getFirestationByAddress (Firestation[] firestations, String address);

	Firestation[] getFirestationsByStation (Firestation[] firestations, int station) ;
	
	void addFirestationInData (Firestation firestation);
	
	void updateFirestationInData (Firestation firestation);
	
	void deleteFirestationInData (String address);
	
}
