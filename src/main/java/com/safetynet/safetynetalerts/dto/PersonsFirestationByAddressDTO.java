package com.safetynet.safetynetalerts.dto;

import lombok.Data;

@Data
public class PersonsFirestationByAddressDTO {

	private PersonNamePhoneAgeMedicalsDTO[] residents;
	
	private int station;
}
