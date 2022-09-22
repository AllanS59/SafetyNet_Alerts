package com.safetynet.safetynetalerts.repository.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.repository.FirestationsRepository;

@Component
public class FirestationsRepositoryImpl implements FirestationsRepository {

	
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

@Override
public Firestation[] getFirestationsFromAppData() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void addFirestationInData(Firestation firestation) {
	// TODO Auto-generated method stub
	
}

@Override
public void updateFirestationInData(Firestation firestation) {
	// TODO Auto-generated method stub
	
}

@Override
public void deleteFirestationInData(String address) {
	// TODO Auto-generated method stub
	
}
}


