package com.safetynet.safetynetalerts.dto;

import lombok.Data;

@Data
public class PersonsChildrenByAddressDTO {

	private PersonNameAgeDTO[] listChildren;
	
	private PersonNameDTO[] listAdults;
}
