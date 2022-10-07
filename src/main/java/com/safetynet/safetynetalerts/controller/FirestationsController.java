package com.safetynet.safetynetalerts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.service.impl.FirestationsServiceImpl;


@RestController
public class FirestationsController {
	
	@Autowired
	FirestationsServiceImpl firestationsService = new FirestationsServiceImpl();
	
	
	
	/**
	 * Read - Get all firestations
	 * @return A Person object full filled
	 */
	@GetMapping("/firestations")
	public Firestation[] getFirestations() {
		Firestation[] firestations = firestationsService.getFirestations();
		return firestations;	
	}
        
//	/**
//	 * Read - Get one firestation
//	 * 
//	 * @param address The address of the firestation
//	 * @return A Firestation object full filled
//	 */
//	@GetMapping("/firestation")
//	public Firestation getFirestation(@RequestParam(name ="address")  String address) {
//         
//		//Convert the address from URL version to database version
//		String convertedAddress = address.replace("_", " ");
//		
//		//Search the firestation by Address in the Persons Array
//		Firestation foundfirestation = firestationsService.getFirestationByAddress(convertedAddress);
//        
//		return foundfirestation;	
//	}
	
	
	/**
	 * Create - Add a new firestation
	 * @param firestation An object Firestation
	 * @return The Firestation object saved
	 */
	@PostMapping("/firestation")
	public Firestation CreateFirestation(@RequestBody Firestation firestation) {
		firestationsService.addFirestationInData(firestation);
		return firestation;
	}
	
	
	/**
	 * Update - Update an existing firestation
	 * @param address The address of the firestation
	 * @return
	 */
	@PutMapping("/firestation")
	public Firestation updateFirestation( @RequestBody Firestation firestation) {
				
				firestationsService.updateFirestationInData(firestation);
				return firestation;
	} 
	
	
	/**
	 * Delete - Delete a firestation
	 * @param address The address of the firestation
	 */
	@DeleteMapping("/firestation")
	public void deleteFirestation(@RequestParam(name ="address")  String address) {
		firestationsService.deleteFirestationInData(address);
	}
	
	
	
	
	
}
