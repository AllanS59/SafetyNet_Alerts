package com.safetynet.safetynetalerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalerts.model.AppData;
import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.model.Person;
import com.safetynet.safetynetalerts.service.AppDataService;
import com.safetynet.safetynetalerts.service.FirestationsService;


@RestController
public class FirestationsController {
	
	@Autowired
	AppDataService appDataService = new AppDataService();
	
	@Autowired
	FirestationsService firestationsService = new FirestationsService();
	
	
	
	/**
	 * Read - Get all firestations
	 * @return A Person object full filled
	 */
	@GetMapping("/firestations")
	public Firestation[] getFirestations() {
		
		//lecture du fichier Json
		AppData appData = appDataService.readDatafromJson("src/main/resources/data.json");
		Firestation[] firestations = appData.getFirestations();
		return firestations;	
	}
		
        
        
	/**
	 * Read - Get one firestation
	 * 
	 * @param address The address of the firestation
	 * @return A Firestation object full filled
	 */
	@GetMapping("/firestation/{address}")
	public Firestation getFirestation(@PathVariable("address") final String address) {
		
		//lecture du fichier Json
		AppData appData = appDataService.readDatafromJson("src/main/resources/data.json");
		Firestation[] firestations = appData.getFirestations();
         
		//Convert the address from URL version to database version
		String convertedAddress = address.replace("_", " ");
		
		//Search the firestation by Address in the Persons Array
		Firestation foundfirestation = firestationsService.getFirestationByAddress(firestations, convertedAddress);
        
		return foundfirestation;	
	}
	
	
	/**
	 * Create - Add a new firestation
	 * @param firestation An object Firestation
	 * @return The Firestation object saved
	 */
	@PostMapping("/firestation")
	public Firestation CreateFirestation(@RequestBody Firestation firestation) {
		appDataService.addFirestationInJson(firestation, "src/main/resources/data.json");
		return firestation;
	}
	
	
	/**
	 * Update - Update an existing firestation
	 * @param address The address of the firestation
	 * @return
	 */
	@PutMapping("/firestation/{address}")
	public Firestation updateFirestation(@PathVariable("address") final String address, @RequestBody Firestation firestation) {
		
		//Convert the address from URL version to database version
				String convertedAddress = address.replace("_", " ");
				
		appDataService.updateFirestationInJson(convertedAddress , firestation, "src/main/resources/data.json");
		return firestation;
	} 
	
	
	/**
	 * Delete - Delete a firestation
	 * @param address The address of the firestation
	 */
	@DeleteMapping("/firestation/{address}")
	public void deleteFirestation(@PathVariable("address") final String address) {
		appDataService.deleteFirestationInJson(address , "src/main/resources/data.json");
	}
	
}
