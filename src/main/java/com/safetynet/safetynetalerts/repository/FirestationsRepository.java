package com.safetynet.safetynetalerts.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.safetynet.safetynetalerts.model.Firestation;

@Repository
public class FirestationsRepository {

	
public Firestation getFirestationByAddress (Firestation[] firestations, String address) {
		
	Firestation foundFirestation = null;
		
		for (Firestation f : firestations) {
			if (f.getAddress().equals(address)) {
				foundFirestation = f;
					break;
			}
		}
		return foundFirestation;
	}

public Firestation[] getFirestationsByStation (Firestation[] firestations, int station) {
	
	List <Firestation> listFirestations = new ArrayList<Firestation>();
		
		for (Firestation f : firestations) {
			if (f.getStation() == station) {
				listFirestations.add(f);
			}
		}
		Firestation[] foundFirestation = listFirestations.toArray(new Firestation[0]);
		return foundFirestation;
	}
}


