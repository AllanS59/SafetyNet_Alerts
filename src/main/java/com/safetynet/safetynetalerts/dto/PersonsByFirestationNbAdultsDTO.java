package com.safetynet.safetynetalerts.dto;

import lombok.Data;

@Data
public class PersonsByFirestationNbAdultsDTO {

	private PersonNameAddressPhoneDTO[] persons;

	private int numberChildren;

	private int numberAdults;
}
