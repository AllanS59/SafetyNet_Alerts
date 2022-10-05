package com.safetynet.safetynetalerts.dto;

import lombok.Data;

@Data
public class AddressesPersonsByFirestationDTO {
	
	private String address;
	
	private PersonNamePhoneAgeMedicalsDTO[] residents;
	

}
