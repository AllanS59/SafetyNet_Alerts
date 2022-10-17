package com.safetynet.safetynetalerts.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.repository.AppDataRepository;
import com.safetynet.safetynetalerts.repository.FirestationsRepository;

@Repository
public class FirestationsRepositoryImpl implements FirestationsRepository {

	@Override
	public Firestation[] getFirestationsFromAppData() {
		Firestation[] firestations = appDataRepo.readDatafromJson().getFirestations();
		return firestations;
	}

	@Autowired
	private AppDataRepository appDataRepo;

	public Firestation getFirestationByAddress(Firestation[] firestations, String address) {

		Firestation foundFirestation = null;

		for (Firestation f : firestations) {
			if (f.getAddress().equals(address)) {
				foundFirestation = f;
				break;
			}
		}
		return foundFirestation;
	}

	public Firestation[] getFirestationsByStation(Firestation[] firestations, int station) {

		List<Firestation> listFirestations = new ArrayList<Firestation>();

		for (Firestation f : firestations) {
			if (f.getStation() == station) {
				listFirestations.add(f);
			}
		}
		Firestation[] foundFirestation = listFirestations.toArray(new Firestation[0]);
		return foundFirestation;
	}

	@Override
	public void addFirestationInData(Firestation firestation) {
		appDataRepo.addFirestationInJson(firestation);

	}

	@Override
	public void updateFirestationInData(Firestation firestation) {
		appDataRepo.updateFirestationInJson(firestation);

	}

	@Override
	public void deleteFirestationInData(String address) {
		appDataRepo.deleteFirestationInJson(address);

	}
}
