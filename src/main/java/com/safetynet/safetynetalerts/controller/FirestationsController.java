package com.safetynet.safetynetalerts.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	private static final Logger LOG = LogManager.getLogger(FirestationsController.class);

	@Autowired
	FirestationsServiceImpl firestationsService = new FirestationsServiceImpl();

	/**
	 * Read - Get all firestations
	 * 
	 * @return A Person object full filled
	 */
	@GetMapping("/firestations")
	public Firestation[] getFirestations() {
		LOG.info("Command GET /firestations received. Sending all firestations recorded");
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
//      LOG.info("Command GET  /firestation received with address=" + address + ". Sending the firestation information");
//		Firestation foundfirestation = firestationsService.getFirestationByAddress(address);
//		return foundfirestation;	
//	}

	/**
	 * Create - Add a new firestation
	 * 
	 * @param firestation An object Firestation
	 * @return The Firestation object saved
	 */
	@PostMapping("/firestation")
	public Firestation createFirestation(@RequestBody Firestation firestation) {
		LOG.info("Command POST /firestation received. Creating firestation");
		firestationsService.addFirestationInData(firestation);
		return firestation;
	}

	/**
	 * Update - Update an existing firestation
	 * 
	 * @param address The address of the firestation
	 * @return
	 */
	@PutMapping("/firestation")
	public Firestation updateFirestation(@RequestBody Firestation firestation) {
		LOG.info("Command PUT /firestation received. Updating firestation");
		firestationsService.updateFirestationInData(firestation);
		return firestation;
	}

	/**
	 * Delete - Delete a firestation
	 * 
	 * @param address The address of the firestation
	 */
	@DeleteMapping("/firestation")
	public void deleteFirestation(@RequestParam(name = "address") String address) {
		LOG.info("Command DELETE  /firestation received with address=" + address + ". Deleting the firestation");
		firestationsService.deleteFirestationInData(address);
	}

}
