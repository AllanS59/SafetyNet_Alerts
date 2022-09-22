package com.safetynet.safetynetalerts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.safetynetalerts.model.Firestation;
import com.safetynet.safetynetalerts.repository.Impl.FirestationsRepositoryImpl;

import lombok.Data;

@Data
@Service
public class FirestationsService {
	
	@Autowired
	private FirestationsRepositoryImpl firestationsRepository;

	
	public Firestation getFirestationByAddress (Firestation[] firestations, String address) {		
				
		return firestationsRepository.getFirestationByAddress (firestations, address);
	}
}
