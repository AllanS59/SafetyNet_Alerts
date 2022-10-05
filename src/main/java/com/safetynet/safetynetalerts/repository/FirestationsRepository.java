package com.safetynet.safetynetalerts.repository;

import com.safetynet.safetynetalerts.model.Firestation;

public interface FirestationsRepository {

	/**
	 * get the Firestations from Json file
	 * @return Firestation[] array of the firestations found
	 */
	Firestation[] getFirestationsFromAppData();
	
	/**
	 * get the Firestation from a specific address
	 * @param firestations array of firestations where search 
	 * @param address the address to find a specific firestation
	 * @return Firestation the  firestations found
	 */
	Firestation getFirestationByAddress (Firestation[] firestations, String address);

	/**
	 * get the Firestation from a specific station number
	 * @param firestations array of firestations where search 
	 * @param station the station to find specific firestations
	 * @return Firestation[] array of the firestations found
	 */
	Firestation[] getFirestationsByStation (Firestation[] firestations, int station) ;
	
	/**
	 * add a Firestation into Json data
	 * @param firestation firestation to add in data
	 */
	void addFirestationInData (Firestation firestation);
	
	/**
	 * update a Firestation into Json data
	 * @param firestation firestation to update  in data (found by address)
	 */
	void updateFirestationInData (Firestation firestation);
	
	/**
	 * delete a Firestation into Json data
	 * @param address the address of the firestation to delete
	 */
	void deleteFirestationInData (String address);
	
}
